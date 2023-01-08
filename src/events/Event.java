package events;

import java.util.Scanner;

import pokemon.Pokemon;
import primary.Player;

public abstract class Event {
    public enum ResolveType {
        SUCCESS,
        FAIL
    }

    /**
     * Handle the event
     * @param pokemon The current
     * Pokemon being used.
     * @param player The player
     * involved.
     * @param scans The current Scanner
     * Object in the current context.
     * @return How the event was
     * resolved.
     */
    public abstract ResolveType handleEvent(Pokemon pokemon, Player player, Scanner scans);
}
