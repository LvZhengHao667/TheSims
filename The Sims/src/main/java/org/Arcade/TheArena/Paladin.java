package org.Arcade.TheArena;

import java.util.Objects;
import java.util.Random;

public class Paladin {
    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    private int weapon;
    //
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private int hp;
    //
    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    private int mp;

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    private int spd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    //
    @Override
    public String toString() {
        return "Hero{" +
                "weapon='" + weapon + '\'' +
                ", hp=" + hp +
                ", mp=" + mp +
                '}';
    }

    public Paladin(){
        setWeapon(1 + Main.atkUp);
        setHp(30 + Main.hpUp);
        setMp(2);
        setSpd(2+ Main.spdUp);
        setName("paladin");
    }

    boolean taunt = false;

    public void skill(){
        taunt = !taunt;
    }
}

