package org.Arcade.TheArena;

import org.User.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Dragon {
    RoundCounter roundCounter = new RoundCounter();
    Heroes heroes = new Heroes();
    Paladin paladin = new Paladin();
    Magician magician = new Magician();
    Assassin assassin = new Assassin();
    Priest priest = new Priest();
    Guardian guardian = new Guardian();
    Berserker berserker = new Berserker();

    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> hp = new ArrayList<>();
    ArrayList<Integer> mp = new ArrayList<>();
    ArrayList<Integer> str = new ArrayList<>();
    ArrayList<Integer> spd = new ArrayList<>();
    ArrayList<Integer> orderInt = new ArrayList<>();
    ArrayList<String> orderString = new ArrayList<>();
    //Setting lists

    Scanner input = new Scanner(System.in);


    Dragon(User user) {
        Random r = new Random();
        int giantNumber = 1;

        for (int i = 0; i < giantNumber; i++) {
            name.add("Dragon");
            hp.add(100);
            str.add(15);
            spd.add(5);
        }
        //numbering lists


        orderInt.add(0);
        orderString.add("0");
        for (int i = 0; i < spd.size(); i++) {
            int locate = orderInt.size();
            for (int j = orderInt.size() - 1; j > 0; j--) {
                if (spd.get(i) > orderInt.get(j)) {
                    locate--;
                }
            }
            orderInt.add(locate, spd.get(i));
            orderString.add(locate, name.get(i));
        }

        for (int i = 0; i < heroes.spd.size(); i++) {
            int locate = orderInt.size();
            for (int j = orderInt.size() - 1; j > 0; j--) {
                if (heroes.spd.get(i) > orderInt.get(j)) {
                    locate--;
                }
            }
            orderInt.add(locate, heroes.spd.get(i));
            orderString.add(locate, heroes.name.get(i));
        }
        orderString.remove(0);
        //ordering

        int dragonSp = 3;
        while (!(name.isEmpty() || heroes.name.isEmpty())) {
            int i;

            for (i = 0; i < orderString.size(); i++) {

                if(name.isEmpty() || heroes.name.isEmpty()){
                    break;
                }

                System.out.println(orderString);
                for(int k = -4; k<i*9.5; k++) {
                    System.out.print(" ");
                }
                System.out.print("^");
                System.out.println();

                if (!heroes.name.contains(orderString.get(i))) {
                    if(dragonSp == 0) {
                        dragonSp = 3;
                        System.out.println("The dragon releases the flame, which can cause 10 direct damage to all the heroes regardless of their skills.");
                        for (int j = 0; j < heroes.hp.size(); j++){
                            heroes.hp.set(j,heroes.hp.get(j) - 10);
                        }
                    } else {
                        int chooseToAttack;
                        int damage;
                        if (!paladin.taunt) {
                            chooseToAttack = r.nextInt(heroes.name.size());
                            damage = str.get(name.indexOf(orderString.get(i))) + r.nextInt(2);
                        } else {
                            System.out.println(orderString.get(i) + " get taunted by Paladin.");
                            chooseToAttack = 0;
                            damage = (str.get(name.indexOf(orderString.get(i))) + r.nextInt(2)) / 2;
                        }

                        int minHp = heroes.hp.get(0);
                        for (int j = 0; j < heroes.hp.size(); j++) {
                            if (heroes.hp.get(j) < minHp) {
                                minHp = heroes.hp.get(j);
                            }
                        }

                        if (guardian.protect && heroes.hp.get(chooseToAttack) == minHp) {
                            System.out.println(orderString.get(i) + " attacking " + heroes.name.get(chooseToAttack) + " ,but the damage is reduced by the guardian");
                        } else {
                            System.out.println(orderString.get(i) + " attacking " + heroes.name.get(chooseToAttack) + " ,causing " + damage + " damages.");
                            heroes.hp.set(chooseToAttack, heroes.hp.get(chooseToAttack) - damage);
                        }
                        System.out.println(new String(new char[1]).replace("\0", "\r\n"));
                    }

                        for (int j = 0; j <= heroes.hp.size() - 1; j++) {
                            if (heroes.hp.get(j) <= 0) {
                                System.out.println(heroes.name.get(j) + " died.");
                                orderString.remove(orderString.indexOf(heroes.name.get(j)));
                                heroes.name.remove(j);
                                heroes.hp.remove(j);
                                heroes.mp.remove(j);
                                heroes.spd.remove(j);
                                heroes.str.remove(j);
                                if (j < i - 1) {
                                    i--;
                                }
                                j--;
                            }
                        }
                        dragonSp --;

                    //opponents' round

                } else {
                    int chooseToAttack = r.nextInt(name.size());
                    int damage = heroes.str.get(heroes.name.indexOf(orderString.get(i))) + r.nextInt(2);
                    if(heroes.mp.get(heroes.name.indexOf(orderString.get(i))) != 0){
                        System.out.println(orderString.get(i) + " attacking " + name.get(chooseToAttack) + " ,causing " + damage + " damages.");
                        hp.set(chooseToAttack, hp.get(chooseToAttack) - damage);

                        if(Objects.equals(orderString.get(i), "paladin") && heroes.mp.get(heroes.name.indexOf("paladin")) == 2 && paladin.taunt){
                            paladin.skill();
                        }
                        if(Objects.equals(orderString.get(i), "guardian") && heroes.mp.get(heroes.name.indexOf("guardian")) == 2 && guardian.protect){
                            guardian.skill();
                        }

                        heroes.mp.set(heroes.name.indexOf(orderString.get(i)), heroes.mp.get(heroes.name.indexOf(orderString.get(i))) - 1);

                    }else{
                        System.out.println(orderString.get(i) + " using skill.");
                        switch (heroes.allName.indexOf(orderString.get(i))){
                            case 0: paladin.skill();break;
                            case 1: int max = hp.get(0);
                                for(int j = 0; j<orderString.size()-1; j++){
                                    if(name.contains(orderString.get(j)) && hp.get(name.indexOf(orderString.get(j)))>max){
                                        max = hp.get(name.indexOf(orderString.get(j)));
                                    }
                                }
                                hp.set(hp.indexOf(max),max*2/3);
                                break;
                            case 2:
                                for(int j = 0; j<orderString.size(); j++){
                                    if(name.contains(orderString.get(j))){
                                        hp.set(name.indexOf(orderString.get(j)) , hp.get(name.indexOf(orderString.get(j)))-magician.getWeapon());
                                    }
                                }
                                break;
                            case 3:
                                for(int j = 0; j<orderString.size(); j++){
                                    if(heroes.name.contains(orderString.get(j))){
                                        heroes.hp.set(heroes.name.indexOf(orderString.get(j)) , heroes.hp.get(heroes.name.indexOf(orderString.get(j))) + 4*priest.getWeapon());
                                    }
                                }
                                break;
                            case 4: guardian.skill();break;
                            case 5: heroes.str.set(heroes.name.indexOf("berserker") , heroes.str.get(heroes.name.indexOf("berserker")) + 2);break;
                        }
                        heroes.mp.set(heroes.name.indexOf(orderString.get(i)), 2);
                    }

                    System.out.println(new String(new char[1]).replace("\0", "\r\n"));

                    for(int j = 0; j <= hp.size()-1 ;j++) {
                        if (hp.get(j) <= 0) {
                            System.out.println(name.get(j) + " died.");
                            orderString.remove(orderString.indexOf(name.get(j)));
                            name.remove(j);
                            hp.remove(j);
                            if(j < i-1){
                                i--;
                            }
                            j--;
                        }
                    }
                    //heroes' round

                }
                //calculating damage

                for (int j = 0; j < hp.size(); j++) {
                    System.out.print(name.get(j) + " hp : " + hp.get(j) + "      sp : " + dragonSp);
                }
                System.out.println(new String(new char[1]).replace("\0", "\r\n"));

                for (int j = 0; j < heroes.hp.size(); j++) {
                    System.out.println(heroes.name.get(j) + " hp : " + heroes.hp.get(j) + "      sp : " + heroes.mp.get(j) + "      atk : " + heroes.str.get(j));
                }
                //printing

                input.nextLine();
                System.out.println(new String(new char[10]).replace("\0", "\r\n"));
                //enter to continue
            }
        }

        if(heroes.name.isEmpty()){
            System.out.println("Heroes lose.");
            input.nextLine();
            RunArena.end = true;
        }else{
            System.out.println("Heroes beat the boss. Congratulations!");
            user.addMoney(50000);
            RunArena.end = true;
        }
        input.nextLine();
        System.out.println(new String(new char[10]).replace("\0", "\r\n"));
    }
}