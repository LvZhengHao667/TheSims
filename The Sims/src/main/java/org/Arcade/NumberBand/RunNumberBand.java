package org.Arcade.NumberBand;
import java.util.Scanner;

public class RunNumberBand {
    public void numberBand() {
        System.out.println("This is the Number Bomb game.");
        System.out.println("Please enter the number of players.");
        Scanner playerNumber = new Scanner(System.in);
        int players = Integer.parseInt(playerNumber.nextLine());
        System.out.println("Now,I will explain the game rules to you.");
        System.out.println(
                """
                        1.Players take turns guessing a number in the range. After each guess:
                        2.Say "Too low!" if the guess is smaller than the bomb number.
                        3.Say "Too high!" if the guess is bigger than the bomb number.
                        4.Whoever guesses the exact bomb number loses .
                        """
        );
        int number = (int) (Math.random() * 100);
        while (true) {
            int round = 0;

            for (int i = 0; i < players; i++) {
                System.out.println("Player" + (round + 1) + ".It is your turn.");
                Scanner printin = new Scanner(System.in);
                int playerinput = Integer.parseInt(printin.nextLine());
                if (playerinput > 100) {
                    System.out.println("You lose! You should print in the number between 1~100");
                    return;
                } else {
                    if (playerinput == number) {
                        System.out.println("Boom!");
                        return;
                    } else if (playerinput < number) {
                        System.out.println("The number you entered is smaller than the bomb number.");
                    } else {
                        System.out.println("The number you entered is bigger than the bomb number.");
                    }
                }

                round++;

            }


        }

    }
}

