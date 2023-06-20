package dev.dragonofshuu.events;

import java.util.Scanner;

import dev.dragonofshuu.dragons.Dragon;
import dev.dragonofshuu.player.Player;

public abstract class Event {
    public enum ResolveType {
        SUCCESS,
        FAIL
    }

    /**
     * Handle the event
     * @param dragon The current
     * Dragon being used.
     * @param player The player
     * involved.
     * @param scans The current Scanner
     * Object in the current context.
     * @return How the event was
     * resolved.
     */
    public abstract ResolveType handleEvent(Dragon dragon, Player player, Scanner scans);
}
