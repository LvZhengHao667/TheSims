package org.Arcade.TheArena;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Goblin {
    RoundCounter roundCounter = new RoundCounter();
    Heroes heroes = new Heroes();
    Paladin paladin = new Paladin();
    Magician magician = new Magician();
    Assassin assassin = new Assassin();

    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> hp = new ArrayList<>();
    ArrayList<Integer> mp = new ArrayList<>();
    ArrayList<Integer> str = new ArrayList<>();
    ArrayList<Integer> spd = new ArrayList<>();
    ArrayList<Integer> orderInt = new ArrayList<>();
    ArrayList<String> orderString = new ArrayList<>();
    //Setting lists

    Scanner input = new Scanner(System.in);


    Goblin() {
        Random r = new Random();
        int goblinNumber = r.nextInt(2) + roundCounter.getRound() + 1;

        for (int i = 0; i < goblinNumber; i++) {
            name.add("Goblin" + (i + 1));
            hp.add(3 + roundCounter.getRound() * 2);
            str.add(2 + roundCounter.getRound());
            spd.add(r.nextInt(2) + roundCounter.getRound());
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
                    int chooseToAttack;
                    int damage;
                    if(!paladin.taunt) {
                        chooseToAttack = r.nextInt(heroes.name.size());
                        damage = str.get(name.indexOf(orderString.get(i))) + r.nextInt(2);
                    }else{
                        chooseToAttack = 0;
                        damage = (str.get(name.indexOf(orderString.get(i))) + r.nextInt(2))/2;
                    }

                    System.out.println(orderString.get(i) + " attacking " + heroes.name.get(chooseToAttack) + " ,causing " + damage + " damages.");
                    heroes.hp.set(chooseToAttack, heroes.hp.get(chooseToAttack) - damage);
                    System.out.println(new String(new char[1]).replace("\0", "\r\n"));
                    if (heroes.hp.get(chooseToAttack) <= 0) {
                        System.out.println(heroes.name.get(chooseToAttack) + " died.");
                        if(orderString.indexOf(heroes.name.get(chooseToAttack)) < i){
                            i--;
                        }
                        orderString.remove(orderString.indexOf(heroes.name.get(chooseToAttack)));
                        heroes.name.remove(chooseToAttack);
                        heroes.hp.remove(chooseToAttack);
                    }
                    //opponents' round

                } else {
                    int chooseToAttack = r.nextInt(name.size());
                    int damage = heroes.str.get(heroes.name.indexOf(orderString.get(i))) + r.nextInt(2);
                    if(heroes.mp.get(heroes.name.indexOf(orderString.get(i))) != 0){
                        System.out.println(orderString.get(i) + " attacking " + name.get(chooseToAttack) + " ,causing " + damage + " damages.");
                        hp.set(chooseToAttack, hp.get(chooseToAttack) - damage);

                        if(heroes.name.indexOf(orderString.get(i)) == 0 && heroes.mp.get(0) == 2 && paladin.taunt){
                            paladin.skill();
                        }

                        heroes.mp.set(heroes.name.indexOf(orderString.get(i)), heroes.mp.get(heroes.name.indexOf(orderString.get(i))) - 1);

                    }else{
                        System.out.println(orderString.get(i) + " using skill.");
                        switch (heroes.name.indexOf(orderString.get(i))){
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
                                for(int j = 0; j<orderString.size()-1; j++){
                                    if(name.contains(orderString.get(j))){
                                        hp.set(name.indexOf(orderString.get(j)),hp.get(name.indexOf(orderString.get(j)))-magician.getWeapon());
                                    }
                                }
                                break;
                        }
                        heroes.mp.set(heroes.name.indexOf(orderString.get(i)), 2);
                    }

                    System.out.println(new String(new char[1]).replace("\0", "\r\n"));

                    for(int j = 0; j <= hp.size()-1 ;j++) {
                        if (hp.get(j) <= 0) {
                            System.out.println(name.get(j) + " died.");
                            if (orderString.indexOf(name.get(j)) < i) {
                                i--;
                            }
                            orderString.remove(orderString.indexOf(name.get(j)));
                            name.remove(j);
                            hp.remove(j);
                        }
                    }
                    //heroes' round

                }
                //calculating damage

                for (int j = 0; j < hp.size(); j++) {
                    System.out.print(name.get(j) + " : " + hp.get(j) + "   ");
                }
                System.out.println(new String(new char[1]).replace("\0", "\r\n"));

                for (int j = 0; j < heroes.hp.size(); j++) {
                    System.out.println(heroes.name.get(j) + " hp : " + heroes.hp.get(j) + "      sp : " + heroes.mp.get(j));
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
            roundCounter.setRound(-1);
        }else{
            System.out.println("Heroes win.");
        }
            roundCounter.setRound(roundCounter.getRound()+1);
            System.out.println(new String(new char[10]).replace("\0", "\r\n"));
    }
}
