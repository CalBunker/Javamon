package events;

import java.util.Scanner;

import pokemon.Pokemon;
import primary.Player;

public abstract class Event {
    public enum ResolveType {
        SUCCESS,
        FAIL
    }

    public abstract ResolveType handleEvent(Pokemon pokemon, Player player, Scanner scans);
}
