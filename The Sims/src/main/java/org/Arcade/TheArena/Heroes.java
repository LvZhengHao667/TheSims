package org.Arcade.TheArena;



import java.util.ArrayList;
import java.util.Arrays;

public class Heroes {
    Main main = new Main();
    Paladin paladin = new Paladin();
    Assassin assassin = new Assassin();
    Magician magician = new Magician();

    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> hp = new ArrayList<>();
    ArrayList<Integer> mp = new ArrayList<>();
    ArrayList<Integer> str = new ArrayList<>();
    //ArrayList<Integer> def = new ArrayList<>();
    ArrayList<Integer> spd = new ArrayList<>();

    public Heroes(){
        name.add(paladin.getName());
        name.add(assassin.getName());
        name.add(magician.getName());
        spd.add(paladin.getSpd());
        spd.add(assassin.getSpd());
        spd.add(magician.getSpd());
        hp.add(paladin.getHp());
        hp.add(assassin.getHp());
        hp.add(magician.getHp());
        str.add(paladin.getWeapon());
        str.add(assassin.getWeapon());
        str.add(magician.getWeapon());
        mp.add(paladin.getMp());
        mp.add(assassin.getMp());
        mp.add(magician.getMp());
    }
}
