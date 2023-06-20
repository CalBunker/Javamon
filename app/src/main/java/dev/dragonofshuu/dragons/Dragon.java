package dev.dragonofshuu.dragons;

import java.io.Serializable;
import java.util.Scanner;

import dev.dragonofshuu.player.Player;
import dev.dragonofshuu.player.backpack.BackpackItem;
import dev.dragonofshuu.primary.Entity;
import dev.dragonofshuu.utils.user.Question;

public class Dragon extends Entity implements Serializable, BackpackItem {
    private static final long serialVersionUID = 32L;
    
    // dragon Name
    private String name;

    // Nickname
    private String nickname;

    // dragon Level
    private int level;

    // Is a favorite
    public boolean isFavorite;

    /**
     * Initialize the dragon.
     * @param name The name of the dragon
     * @param level The level of the dragon
     */
    public Dragon(String name, int level, float startingHealth) {
        super(startingHealth);
        this.name = name;
        this.level = level;
    }

    /**
     * @return The name of the dragon
     */
    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPreferredName() {
        return (nickname == null) ? name : nickname; 
    }

    @Override
    public String toString() {
        return getPreferredName()+" lvl "+level;
    }

    /**
     * @return The level the dragon 
     * is at.
     */
    public int getLevel() {
        return level;
    }

    @Override
    public boolean canDelete() { return false; }

    @Override
    public Success delete() { return null; }

    @Override
    public boolean canAdd() { return false; }

    @Override
    public Success add() { return null; }

    @Override
    public boolean isCompleteObjectAddition() { return false; }

    @Override
    public boolean canRename() { return true; }

    @Override
    public Success rename(Scanner scan) {
        String name = Question.requestString(scan, "What would you like to rename your Dragon to? (Don't enter anything to cancel rename)");
        
        if (name.equals("")) {
            setNickname(null);
        } 
        else {
            setNickname(name);
        }

        return Success.TRUE;
    }

    @Override
    public boolean canUse() { return false; }

    @Override
    public Success use(Player instigator) { return null; }

    @Override
    public boolean canFavorite() { return true; }

    @Override
    public Boolean toggleFavorite() { return isFavorite = !isFavorite; }

    @Override
    public boolean isFavorite() { return isFavorite; }
}