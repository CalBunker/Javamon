package dev.dragonofshuu.utils.user.editables;

import java.util.Scanner;

import dev.dragonofshuu.primary.Player;

public abstract interface EditableItem {
    public static enum Success {
        TRUE,
        FALSE,
        ABOVE_HANDLE;

        /**
         * Convert the value of the
         * enum to a true/false/null
         * statement.
         * @return A boolean.
         */
        public Boolean convert() {
            switch (this) {
                case TRUE: return true;
                case FALSE: return false;
                case ABOVE_HANDLE: return null;
                default: throw new IllegalStateException();
            }
        }
    }

    public boolean canDelete();
    /**
     * @return true if the object should be deleted
     */
    public Success delete();

    public boolean canAdd();
    /**
     * @return true if the object should be given away
     */
    public Success add();
    /**
     * @return If true, the UI assumes that you add
     * to the list of objects, rather than to an 
     * already created object
     */
    public boolean isCompleteObjectAddition();

    public boolean canRename();

    /**
     * @return True if execution should continue
     */
    public Success rename(Scanner scan);

    public boolean canUse();
    /**
     * @return true if the object should be given away
     */
    public Success use(Player instigator);
}