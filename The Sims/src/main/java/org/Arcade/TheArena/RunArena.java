package org.Arcade.TheArena;

import org.User.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RunArena {
    static Scanner input = new Scanner(System.in);
    static RoundCounter roundCounter = new RoundCounter();
    static int hpUp = 0;
    static int spdUp = 0;
    static int atkUp = 0;

    static Paladin paladin = new Paladin();
    static Assassin assassin = new Assassin();
    static Magician magician = new Magician();
    static Priest priest = new Priest();
    static Guardian guardian = new Guardian();
    static Berserker berserker = new Berserker();

    static ArrayList<String> name;
    static ArrayList<Integer> hp;
    static ArrayList<Integer> mp;
    static ArrayList<Integer> str;
    static ArrayList<Integer> spd;

    static boolean end;
    public static void RunningArena(User user) {
        end = false;
        while (!end) {
            if(roundCounter.getRound() == 0) {
                hpUp = 0;
                spdUp = 0;
                atkUp = 0;

                name = new ArrayList<>(Arrays.asList(paladin.getName(),assassin.getName(),magician.getName(),priest.getName(),guardian.getName(),berserker.getName()));
                hp = new ArrayList<>(Arrays.asList(paladin.getHp(),assassin.getHp(),magician.getHp(),priest.getHp(),guardian.getHp(),berserker.getHp()));
                mp = new ArrayList<>(Arrays.asList(paladin.getMp(),assassin.getMp(),magician.getMp(),priest.getMp(),guardian.getMp(),berserker.getMp()));
                str = new ArrayList<>(Arrays.asList(paladin.getWeapon(),assassin.getWeapon(),magician.getWeapon(),priest.getWeapon(),guardian.getWeapon(),berserker.getWeapon()));
                spd = new ArrayList<>(Arrays.asList(paladin.getSpd(),assassin.getSpd(),magician.getSpd(),priest.getSpd(),guardian.getSpd(),berserker.getSpd()));

                System.out.println("Please pick 3 heroes from the 6 choices below.");
                System.out.println();
                System.out.println("1.Paladin: High HP, with the ability to taunt the enemies.");
                System.out.println("2.Assassin: High Speed, with the ability to deal percentage damage.");
                System.out.println("3.Magician: Has the ability to attack a group enemies at once.");
                System.out.println("4.Priest: Has the ability to heal the team.");
                System.out.println("5.Guardian: High HP, with the ability to protect the weakest teammate.");
                System.out.println("6.Berserker: High attack, with the ability to become stronger in the fight.");
                System.out.println();

                for(int i = 0; i < 3; i++){
                    System.out.println("Input the number of hero " + (i+1));
                    int choosingHeroes = input.nextInt();
                    if(choosingHeroes > 0 && choosingHeroes <= 6){
                        name.add(name.get(choosingHeroes-1));
                        hp.add(hp.get(choosingHeroes-1));
                        spd.add(spd.get(choosingHeroes-1));
                        str.add(str.get(choosingHeroes-1));
                        mp.add(mp.get(choosingHeroes-1));
                    }else{
                        System.out.println("Wrong input, please type again.");
                        i--;
                    }
                }
                for (int i = 0; i < 6; i++) {
                    name.remove(0);
                    hp.remove(0);
                    spd.remove(0);
                    str.remove(0);
                    mp.remove(0);
                }
                System.out.println(name);
            }

            System.out.println("Please pick a group of component");
            System.out.println("1.goblin: Weak, but they have huge advantage in numbers.");
            System.out.println("2.giant: Tough and powerful, but also lonely.");
            System.out.println("3.wizard: He can turn one of your teammate into a frog at the beginning of the fight, and what do you expect a frog will do?");
            System.out.println("4.dragon: The final boss, chose it if you think you are ready.");
            int choosingOpponents = input.nextInt();

            switch (choosingOpponents) {
                case 1:
                    new Goblin();
                    break;
                case 2:
                    new Giant();
                    break;
                case 3:
                    new Wizard();
                    break;
                case 4:
                    new Dragon(user);
                    break;
            }

            if(!end) {
                System.out.println("Choose one upgrade from the 3 choices below.");
                System.out.println("1. add 10 hp for all the heroes.");
                System.out.println("2. add 3 spd for all the heroes.");
                System.out.println("3. add 1 str for all the heroes.");

                int choosingTrophy = input.nextInt();
                switch (choosingTrophy) {
                    case 1:
                        hpUp += 10;
                        break;
                    case 2:
                        spdUp += 3;
                        break;
                    case 3:
                        atkUp++;
                        break;
                }
            }
        }
        user.addMoney(roundCounter.getRound() * 20000);
    }
}