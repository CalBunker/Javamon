package dev.dragonofshuu.utils.user.editables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import dev.dragonofshuu.primary.Player;
import dev.dragonofshuu.utils.Statics;
import dev.dragonofshuu.utils.user.Question;
import dev.dragonofshuu.utils.user.Screen;

public class EditUI {
    public ArrayList<EditableItem> items;
    public EditableItem returnItem;
    public boolean createNew = false;
    public ExitType exitType;

    /**
     * The possible EditUI
     * actions of each object.
     */
    public enum Actions {
        DELETE,
        ADD,
        RENAME,
        USE,
        BACK
    }

    /**
     * How each menu is resolved.
     */
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

    /**
     * Start the ability for the 
     * player to edit the list
     * of items.
     * @param scan The Scanner
     * object in the current 
     * context.
     * @param question The question
     * to ask the user for the objects.
     * @param baseClass A generic 
     * example of the object.
     * @param player The player in 
     * the current context.
     * @return How the UI exists;
     * if the user straight exitted,
     * or if an option pulled them
     * out.
     */
    public ExitType initialize(Scanner scan, String question, EditableItem baseClass, Player player) {
        ExitType exit = mainLoop(scan, question, baseClass, player);

        return exit;
    }

    /**
     * The main loop for the 
     * user to choose items
     * to edit/use.
     * @param scan the Scanner
     * object in the current
     * context.
     * @param question The question
     * to ask the user for the objects.
     * @param baseClass A generic
     * example of the object.
     * @param player The player in
     * the current context.
     * @return If the user decides
     * to exit, or if they are pulled
     * out by an element.
     */
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

            ResolveType resolve = manipulateItem(scan, player, chosen, eItem);

            switch (resolve) {
                case CONTINUE: continue;
                case RETURN:   return ExitType.OTHER;
                case BREAK:    return ExitType.OTHER;
            }
        }
    }

    /**
     * When the user chooses 
     * an item.
     * @param scan The main
     * Scanner object in the
     * current context.
     * @param player The 
     * player in the current
     * context.
     * @param chosen The
     * chosen index value.
     * @param eItem The editable
     * item chosen.
     * @return How the user 
     * left the method.
     */
    private ResolveType manipulateItem(Scanner scan, Player player, int chosen, EditableItem eItem) {
        while (true) {
            System.out.println(eItem.toString() + " selected.");

            Actions[] allActions = availableActions(eItem, !eItem.isCompleteObjectAddition());

            Object answer = Question.chooseItem(scan, "What would you like to do?", Statics.fromEnumToString(allActions), allActions);
            Actions action = (Actions) answer;

            ResolveType newAction = determineAction(scan, player, chosen, action, eItem);

            switch (newAction) {
                case BREAK:    return ResolveType.CONTINUE;
                case CONTINUE: continue;
                case RETURN:   return ResolveType.RETURN;
            }
        }
    }

    /**
     * Determine how the player's
     * action corresponds to
     * the object.
     * @param scan
     * @param player
     * @param chosen
     * @param action
     * @param eItem
     * @param baseClass
     * @return
     */
    private ResolveType determineAction(Scanner scan, Player player, int chosen, Actions action, EditableItem eItem) {
        returnItem = eItem;

        switch (action) {
            case ADD:    return add(eItem);
            case DELETE: return delete(chosen, eItem);
            case RENAME: return rename(scan, eItem);
            case USE:    return use(player, eItem);
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

    private ResolveType delete(int chosen, EditableItem eItem) {
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

    /**
     * Determine the available
     * actions for an item.
     * @param x The EditableItem
     * reference
     * @param includeBack If a
     * back option should be 
     * included.
     * @param includeAdd If an 
     * add option should be 
     * included.
     * @return The actions available
     * from the item chosen.
     */
    public Actions[] availableActions(EditableItem x, boolean includeBack, boolean includeAdd) {
        ArrayList<Actions> actions = new ArrayList<Actions>();

        if (x.canUse()) {
            actions.add(Actions.USE);
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
