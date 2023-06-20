package dev.dragonofshuu.player.backpack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import dev.dragonofshuu.dragons.Dragon;
import dev.dragonofshuu.player.Player;
// import dev.dragonofshuu.utils.user.editables.EditUI;

public class Backpack extends ArrayList<BackpackItem> {
    ArrayList<BackpackItem> x;

    public Backpack() {
        // x = super();
    }

    public ArrayList<Dragon> getDragons() {
        return new ArrayList<Dragon>(
            super.stream()
                .filter((x) -> x instanceof Dragon)
                .map((x) -> (Dragon) x)
                .collect(Collectors.toList())
            );
    }

    public void openBackpack(Scanner scan, Player player) {
        // EditUI edit = new EditUI(this);
        // edit.initialize(scan, "", super.get(0), player);
        this.getDragons().forEach((dragon) -> {
            System.out.println(dragon);
        });
    }
}
