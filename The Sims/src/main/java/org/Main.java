

import org.Arcade.NumberBand.RunNumberBand;
import org.CarShop.*;
import org.Days.Days;
import org.Detect.DetectAnomalies;
import org.Hospital.Medicine;
import org.User.User;

import java.util.Objects;
import java.util.Scanner;


public static void main(String[] args) {
    //Determine whether the game has been initiated.
    while (true) {
        //
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please type in 'Start the day' or 'Start' or 'start' to begin your day!");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        DetectAnomalies detectAnomalies = new DetectAnomalies();
        String userTypesIn = detectAnomalies.Detect();
        if (Objects.equals(userTypesIn, "Start the day") || Objects.equals(userTypesIn, "Start") || Objects.equals(userTypesIn, "start")) {
            //Input correct. Game starts.
            System.out.println("You will have 5 skill points each day, and each of your actions will consume 1 skill point.");
            System.out.println("(Actions that consume skill points will be noted with \\\"This action will consume 1 skill point\\\" after the action name.)");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            break;
        } else {
            //Input error. Please re-enter.
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("If you're not ready yet, you can type in 'Start the day' once you are ready.");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }




    String[] userCar = new String[4];

    //Instantiate Medicine class.
    Medicine medicine = new Medicine();

    //Instantiate Cars class.
    Cars car = new Cars();

    //Instantiate User class.
    User user = new User(5, 1, 100000, 10 , userCar);

    //Set initial money.
    user.setMoney();

//This loop represents game start and end.
    while (true) {

        //Adjust initial money and health for testing.

        //user.changeHealth();
        //user.changeMoney(1000000);



        //Instantiate DetectAnomalies class.
        DetectAnomalies detectAnomalies = new DetectAnomalies();

        //Load actual action points.
        //Because buying a car modifies action points.
        user.equal();

        //Instantiate Days class.
        Days days = new Days();
        days.setDay();


        //Present game rules.
        System.out.println(" ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("You start with 100,000$ and 5 health points per day.");
        System.out.println("Your goal is to earn 1 million dollars by playing games, selling cars, and other methods!");
        System.out.println("However, there will be some obstacles on your way to making money, because you only have 10 health points.");
        System.out.println("You may get sick every day, and a certain amount of health points will be deducted!");
        System.out.println("Health points do not refresh, and you must go to the hospital to buy medicine to increase them.");
        System.out.println("If your health points drop to zero, the game will end in failure immediately!");
        System.out.println("If your action points drop to zero, your day will end immediately!");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


        //This loop represents day start and end.
        while (true) {

            //Action points fall to zero, start next day.
            if (user.getActionPoint() <= 0) {
                while (true) {
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Your action points have dropped to zero.");
                    //Input 'End the day' 'End' 'end' to finish the day.
                    System.out.println("Please enter \"End the day\" or \"End\" or \"end\" to conclude the day.");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    String userTypesInLeave = detectAnomalies.Detect();
                    if (Objects.equals(userTypesInLeave, "End the day") || Objects.equals(userTypesInLeave, "End") ||Objects.equals(userTypesInLeave, "end")) {
                        user.equal();
                        break;
                    } else {
                        //Input error, re-enter.
                        System.out.println("Please type in again!");
                    }
                }

                //Car price fluctuates randomly.
                car.randomDown();
                car.randomUp();

                //Player gets ill randomly (health points lost).
                user.randomIll();

                //Reset day count.
                days.setDay();

                break;
            }




            //Two Game Failure Scenarios

            if (user.getHealth() <= 0) {
                //Health ≤ 0, game over.
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Your health points have dropped to 0, and the game is over!");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }

            if (user.getMoney() <= 0) {
                //Bankrupt, game over.
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Congratulations! You've triggered the hidden plot—you're bankrupt! The game is over!");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }


            //Win the game
            if (user.getMoney() >= 1000000) {
                //Earn 1 million, game success.
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Congratulations! You have successfully earned 1 million, and the game is over!");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }






            // Inform player of current day, money, health, action points
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Today is your " + days.getDay() + " day!");
            System.out.println("You have " + user.getMoney() + "$ .");
            System.out.println("You have " + user.getHealth() + " health points. ");
            System.out.println("You have " + user.getActionPoint() + " action points now.");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


            // Player chooses destination
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Now please choose where you want to go (traveling to each place will consume health points).");
            System.out.println("1. Arcade: You can play a variety of games here and get corresponding rewards after each game, but each play will consume action points.");
            System.out.println("2. Car Shop: Here you can use money to buy your car or sell one. (Different cars can increase your daily action points; naturally, their prices also vary.)");
            System.out.println("3. Hospital: If your health points have decreased, you can come here to buy medicine and increase your health points.");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


            //Where to go
            String userGo = detectAnomalies.Detect();





            //Go into Arcade
            RunNumberBand runNumberBand = new RunNumberBand();
            if (Objects.equals(userGo, "Arcade") || Objects.equals(userGo, "1")) {
                user.reduceActionPoint(1);

                //Introduction to Arcade
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("You have many choices.However,participating in the game costs 1 action point");
                System.out.println("1.You can choose to play NumberBand, a mini-game where you guess a number between 1 and 100. If your guess is correct, you will win a reward of 30,000 yuan.");
                System.out.println("2.You can choose to play The Arena.This is a turn-based game where players need to construct their teams strategically, select battle rewards wisely, and win more rounds in the arena. You will win a reward of 100,000 yuan.");
                System.out.println("Now you can enter the game by inputting the full name of the two games or their corresponding numerical codes.");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                while(true){
                    String gamesToPlay = detectAnomalies.Detect();

                    //Number Band
                    if (Objects.equals(gamesToPlay, "Number Band")||Objects.equals(gamesToPlay, "1")) {
                        user.reduceActionPoint(1);
                        runNumberBand.numberBand();
                        user.addMoney(30000);
                        break;
                    }


                    //The Arena
                    else if (Objects.equals(gamesToPlay, "The Arena")||Objects.equals(gamesToPlay, "2")) {
                        user.reduceActionPoint(1);
                        runNumberBand.numberBand();
                        user.addMoney(100000);
                        break;
                    }


                    else{
                        System.out.println("You have entered an incorrect name. Please try again.");
                    }
                }

            }





            //Go into Car Shop
            else if (Objects.equals(userGo, "Car Shop") || Objects.equals(userGo, "2")) {
                user.reduceActionPoint(1);

                //Introduction to CarShop
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Welcome to the Car Shop.");
                System.out.println("Our CarShop has two random cars with price increases or decreases every day! You can use this method to choose your purchasing strategy!");
                System.out.println("We currently have four car models.");
                System.out.println("They are respectively MINI Cooper , Volkswagen ID.3 , Octavia , Toyota Corolla Hybrid.");
                System.out.println("1) MINI Cooper:It increases the daily initial action points by 1" + "Its price is " + car.getValue(1));
                System.out.println("2) Volkswagen ID.3:It increases the daily initial action points by 2." + "Its price is " + car.getValue(2));
                System.out.println("3) Octavia:It increases the daily initial action points by 3" + "Its price is " + car.getValue(3));
                System.out.println("4) Toyota Corolla Hybrid:It increases the daily initial action points by 4" + "Its price is " + car.getValue(4));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println(" ");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Please choose whether you want to buy or sell a car? (You can enter in either uppercase or lowercase.)");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


                String buyOrSell = detectAnomalies.Detect();


                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Choose which car to choose ");
                System.out.println("You can select by typing their full name (only the first word), their corresponding numerical code (1, 2...), or their initial (regardless of uppercase or lowercase).");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                String carsToChoose = detectAnomalies.Detect();


                // Instantiate the corresponding classes for the four cars respectively
                MINI mini = new MINI();
                Volkswagen volkswagen = new Volkswagen();
                Octavia octavia = new Octavia();
                Toyota toyota = new Toyota();



                // If choose to buy
                if (Objects.equals(buyOrSell, "buy")|| Objects.equals(buyOrSell, "Buy")) {

                    switch (carsToChoose) {

                        // Choose to buy MINI
                        case "MINI", "1", "M", "m" -> {
                            mini.BuyMINI(user, car);
                            user.addCar(0, "MINI");
                        }

                        // Choose to buy Volkswagen
                        case "Volkswagen", "2", "V", "v" -> {
                            volkswagen.BuyVolk(user, car);
                            user.addCar(1, "Volkswagen");
                        }


                        // Choose to buy Octavia
                        case "Octavia", "3", "O", "o" -> {
                            octavia.BuyOct(user, car);
                            user.addCar(2, "Octavia");
                        }


                        // Choose to buy Toyota
                        case "Toyota", "4", "T", "t" -> {
                            toyota.BuyTo(user, car);
                            user.addCar(3, "Toyota");
                        }


                        case null, default -> {

                            //Input error → go home directly (deduct 1 action point)
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("It seems you haven't made a decision yet, so you slink back home!");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        }

                    }

                }

                // Choose to sell
                else if (Objects.equals(buyOrSell, "sell") || Objects.equals(buyOrSell, "Sell") ) {

                    switch (carsToChoose) {

                        // Choose to sell MINI
                        case "MINI", "1", "M", "m" -> {
                            if (Objects.equals(user.getCar(0), "MINI")) {
                                mini.SellMINI(user, car);
                            } else {
                                System.out.println("You do not have the car!");
                                System.out.println("Therefore, you has to go home");
                            }
                        }

                        // Choose to sell Volkswagen
                        case "Volkswagen", "2", "V", "v" -> {
                            if (Objects.equals(user.getCar(1), "Volkswagen")) {
                                volkswagen.SellVolk(user, car);
                            } else {
                                System.out.println("You do not have the car!");
                                System.out.println("Therefore, you has to go home");
                            }
                        }

                        // Choose to sell Octavia
                        case "Octavia", "3", "O", "o" -> {
                            if (Objects.equals(user.getCar(2), "Octavia")) {
                                octavia.SellOct(user, car);
                            } else {
                                System.out.println("You do not have the car!");
                                System.out.println("Therefore, you has to go home");
                            }
                        }

                        // Choose to sell Toyota
                        case "Toyota", "4", "T", "t" -> {
                            if (Objects.equals(user.getCar(3), "Toyota")) {
                                toyota.SellTo(user, car);
                            } else {
                                System.out.println("You do not have the car!");
                                System.out.println("Therefore, you has to go home");
                            }
                        }
                        case null, default -> {
                            //Input error → go home directly (deduct 1 action point)
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("It seems you haven't made a decision yet, so you slink back home!");
                        }
                    }
                }

                else {
                    //Input error → go home directly (deduct 1 action point)
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("It seems you haven't made a decision yet, so you slink back home!");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            }




            //Go into Hospital
            else if (Objects.equals(userGo, "Hospital") || Objects.equals(userGo, "3")) {
                user.reduceActionPoint(1);

                //Introduction to Hospital
                System.out.println("There are may medicines to choose !");
                System.out.println("Here are five medicines. All of them restore your health!");
                System.out.println("1. lemsip : It restores 1 health point for you.It costs 1000 $.");
                System.out.println("2. benylin : It restores 1 health point for you.It costs 2000 $");
                System.out.println("3. nurofen : It restores 1 health point for you.It costs 3000 $");
                System.out.println("4. bonjela : It restores 1 health point for you.It costs 4000 $");
                System.out.println("5. rennie : It restores 1 health point for you.It costs 5000 $");
                System.out.println("You can now enter either their full names or corresponding numbers to choose which medicine to buy.");
                String chooseMedicine = detectAnomalies.Detect();
                //Buy lemsip

                if (Objects.equals(chooseMedicine, "1") || Objects.equals(chooseMedicine, "lemsip")) {
                    medicine.lemsip(user);
                }
                //Buy benylin
                else if (Objects.equals(chooseMedicine, "2") || Objects.equals(chooseMedicine, "benylin")) {
                    medicine.benylin(user);
                }
                //Buy nurofen
                else if (Objects.equals(chooseMedicine, "3") || Objects.equals(chooseMedicine, "nurofen")) {
                    medicine.nurofen(user);
                }
                //Buy bonjela
                else if (Objects.equals(chooseMedicine, "4") || Objects.equals(chooseMedicine, "bonjela")) {
                    medicine.bonjela(user);
                }
                //Buy rennie
                else if (Objects.equals(chooseMedicine, "5") || Objects.equals(chooseMedicine, "rennie")) {
                    medicine.rennie(user);
                }

                else {
                    //Input error → go home directly (deduct 1 action point)
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("It seems you haven't made a decision yet, so you slink back home!");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            }


            //Invalid destination input. Please re-enter.
            else {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("You type in the wrong name! Please type in again!");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }



        }




    }
}



