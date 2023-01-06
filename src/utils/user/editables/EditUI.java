package utils.user.editables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import primary.Player;
import utils.Statics;
import utils.user.Question;
import utils.user.Screen;

public class EditUI {
    public ArrayList<EditableItem> items;
    public EditableItem returnItem;
    public boolean createNew = false;
    public ExitType exitType;

    public enum Actions {
        DELETE,
        ADD,
        RENAME,
        LOAD,
        BACK
    }

    public enum ResolveType {
        CONTINUE,
        BREAK,
        RETURN;

        /**
         * @return This value converted into boolean
         */
        public Boolean convert() {
            switch (this) {
                case CONTINUE: return true;
                case BREAK:    return false;
                case RETURN:   return null;
                default:       throw new IllegalStateException();
            }
        }

        /**
         * @param s Success type of editable item
         * @return The conversion into a ResolveType
         */
        public static ResolveType toResolve(EditableItem.Success s) {
            switch (s) {
                case TRUE:         return ResolveType.CONTINUE;
                case FALSE:        return ResolveType.BREAK;
                case ABOVE_HANDLE: return ResolveType.RETURN;
                default:           throw new IllegalStateException();
            }
        }
    }

    public static enum ExitType {
        EXIT,
        OTHER
    }

    public EditUI(EditableItem... items) {
        this.items = new ArrayList<EditableItem>();

        Collections.addAll(this.items, items);
    }

    public ExitType initialize(Scanner scan, String question, EditableItem baseClass, Player player) {
        ExitType exit = mainLoop(scan, question, baseClass, player);
        exitType = exit;

        return exit;
    }

    private ExitType mainLoop(Scanner scan, String question, EditableItem baseClass, Player player) {
        while (true) {
            Screen.clear();
            returnItem = null;

            String[] choosable;
            if (baseClass.isCompleteObjectAddition()) {
                choosable = new String[items.size()+2];
            } else {
                choosable = new String[items.size()+1];
            }

            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) == null) continue;
                choosable[i] = items.get(i).toString();
            }

            if (baseClass.isCompleteObjectAddition()) {
                choosable[choosable.length-2] = "Create new...";
            }
            choosable[choosable.length-1] = "Exit";

            int chosen = Question.chooseItem(scan, question, choosable);
            
            // If they create a new
            if (chosen == choosable.length-2) {
                createNew = true;
                return ExitType.OTHER;
            }

            // If they go back
            if (chosen == choosable.length-1) return ExitType.EXIT;

            EditableItem eItem = items.get(chosen);

            ResolveType resolve = manipulateItem(scan, player, chosen, eItem, baseClass);

            switch (resolve) {
                case CONTINUE: continue;
                case RETURN:   return ExitType.OTHER;
                case BREAK:    return ExitType.OTHER;
            }
        }
    }

    private ResolveType manipulateItem(Scanner scan, Player player, int chosen, EditableItem eItem, EditableItem baseClass) {
        while (true) {
            System.out.println(eItem.toString() + " selected.");

            Actions[] allActions = availableActions(eItem, !baseClass.isCompleteObjectAddition());

            Object answer = Question.chooseItem(scan, "What would you like to do?", Statics.fromEnumToString(allActions), allActions);
            Actions action = (Actions) answer;

            ResolveType newAction = determineAction(scan, player, chosen, action, eItem, baseClass);

            switch (newAction) {
                case BREAK:    return ResolveType.CONTINUE;
                case CONTINUE: continue;
                case RETURN:   return ResolveType.RETURN;
            }
        }
    }

    private ResolveType determineAction(Scanner scan, Player player, int chosen, Actions action, EditableItem eItem, EditableItem baseClass) {
        returnItem = eItem;

        switch (action) {
            case ADD:    return add(eItem);
            case DELETE: return delete(chosen, eItem, baseClass);
            case RENAME: return rename(scan, eItem);
            case LOAD:    return use(player, eItem);
            case BACK:   return ResolveType.BREAK;
        }

        return ResolveType.CONTINUE;
    }

    private ResolveType use(Player player, EditableItem eItem) {
        Boolean exit = eItem.use(player).convert();

        if (exit)              return ResolveType.RETURN;
        else if (exit == null) return ResolveType.BREAK;
        else                   return ResolveType.CONTINUE;
    }

    private ResolveType rename(Scanner scan, EditableItem eItem) {
       EditableItem.Success success = eItem.rename(scan);
       return ResolveType.toResolve(success);
    }

    private ResolveType delete(int chosen, EditableItem eItem, EditableItem baseClass) {
        EditableItem.Success deleted = eItem.delete();
        Boolean resolve = deleted.convert();

        if (resolve == null) return ResolveType.RETURN;

        if (resolve) {
            items.remove(chosen);
            return ResolveType.BREAK;
        }

        return ResolveType.CONTINUE;
    }

    private ResolveType add(EditableItem eItem) {
        EditableItem.Success success = eItem.add();
        return ResolveType.toResolve(success);

    }



    public Actions[] availableActions(EditableItem x, boolean includeBack, boolean includeAdd) {
        ArrayList<Actions> actions = new ArrayList<Actions>();

        if (x.canUse()) {
            actions.add(Actions.LOAD);
        }

        if (x.canRename()) {
            actions.add(Actions.RENAME);
        }

        if (x.canAdd() && includeAdd) {
            actions.add(Actions.ADD);
        }

        if (x.canDelete()) {
            actions.add(Actions.DELETE);
        }

        if (includeBack) {
            actions.add(Actions.BACK);
        }

        Actions[] current = new Actions[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            current[i] = actions.get(i);
        }

        return current;
    }

    public Actions[] availableActions(EditableItem x, boolean includeAdd) {
        return availableActions(x, true, includeAdd);
    }

    public Actions[] availableActions(EditableItem x) {
        return availableActions(x, true, true);
    }
}
