package org.Arcade.TheArena;

import java.util.ArrayList;
import java.util.Arrays;

public class Heroes {
    Paladin paladin = new Paladin();
    Assassin assassin = new Assassin();
    Magician magician = new Magician();
    Priest priest = new Priest();
    Guardian guardian = new Guardian();
    Berserker berserker = new Berserker();

    ArrayList<String> allName = new ArrayList<>(Arrays.asList(paladin.getName(),assassin.getName(),magician.getName(),priest.getName(),guardian.getName(),berserker.getName()));
    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> hp = new ArrayList<>();
    ArrayList<Integer> mp = new ArrayList<>();
    ArrayList<Integer> str = new ArrayList<>();
    ArrayList<Integer> spd = new ArrayList<>();

    public Heroes(){
        for (int i = 0; i < 3; i++) {
            name.add(RunArena.name.get(i));
            hp.add(RunArena.hp.get(i) + RunArena.hpUp);
            mp.add(RunArena.mp.get(i));
            str.add(RunArena.str.get(i) + RunArena.atkUp);
            spd.add(RunArena.spd.get(i) + RunArena.spdUp);
        }
    }
}
