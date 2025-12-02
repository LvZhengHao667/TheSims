package org.Arcade.TheArena;

public class Magician {
    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    private static int weapon;
    //
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private static int hp;
    //
    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    private int mp;
    //
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    private int exp;

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    private static int spd;

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
                ", exp=" + exp +
                '}';
    }

    public Magician(){
        setWeapon(1 + Main.atkUp);
        setHp(20 + Main.hpUp);
        setMp(2);
        setSpd(3 + Main.spdUp);
        setName("magician");
    }
}
