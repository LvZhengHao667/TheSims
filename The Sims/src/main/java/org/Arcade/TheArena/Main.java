package org.Arcade.TheArena;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static RoundCounter roundCounter = new RoundCounter();
    static int hpUp = 0;
    static int spdUp = 0;
    static int atkUp = 0;

    public static void main(String[] args) {

        while (true) {
            if(roundCounter.getRound() == -1) {
                roundCounter.setRound(0);
                hpUp = 0;
                spdUp = 0;
                atkUp = 0;
            }

            System.out.println("Please pick a group of component");
            System.out.println("1.goblin gang");
            int choosingOpponents = input.nextInt();

            switch (choosingOpponents) {
                case 1:
                    new Goblin();
                    break;
            }
            if(roundCounter.getRound() != -1) {
                System.out.println("Choose one upgrade from the 3 choices below.");
                System.out.println("1. add 5 hp for all the heroes.");
                System.out.println("2. add 1 spd for all the heroes.");
                System.out.println("3. add 1 str for all the heroes.");

                int choosingTrophy = input.nextInt();
                switch (choosingTrophy) {
                    case 1:
                        hpUp += 5;
                        break;
                    case 2:
                        spdUp++;
                        break;
                    case 3:
                        atkUp++;
                        break;
                }
            }
        }
    }
}