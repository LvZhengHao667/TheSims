

import org.Arcade.NumberBand.RunNumberBand;
import org.CarShop.*;
import org.Days.Days;
import org.Detect.DetectAnomalies;
import org.Hospital.Medicine;
import org.User.User;

import java.util.Objects;
import java.util.Scanner;


public static void main(String[] args) {
    //开始这一天
    while (true) {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please type in \"Start the day\" or \"Start\" or \"start\" to begin your day!");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Scanner userTypeIn = new Scanner(System.in);
        String userTypesIn = String.valueOf(userTypeIn.nextLine());
        if (Objects.equals(userTypesIn, "Start the day") || Objects.equals(userTypesIn, "Start") || Objects.equals(userTypesIn, "start")) {
            System.out.println("You will have 5 skill points each day, and each of your actions will consume 1 skill point.");
            System.out.println("(Actions that consume skill points will be noted with \\\"This action will consume 1 skill point\\\" after the action name.)");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            break;
        } else {
            System.out.println("If you're not ready yet, you can type in \"Start the day\" once you are ready.");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }


    //介绍游戏规则
    System.out.println(" ");
    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("Your goal is to earn $1,000,000, and you can visit the following places every day.");
    System.out.println("Arcade:You can play many games here. Starting each game will cost a certain amount of money, and winning each game will earn you a certain amount of money.");
    System.out.println("Car Shop:You can buy a variety of cars here. Of course, you can also sell your existing cars to get money.");
    System.out.println("Hospital:If you feel ill, you can come here to buy medicine and treat your illness.");
    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    String[] userCar = new String[4];
    Medicine medicine = new Medicine();
    Cars car = new Cars();
    //实例化User类
    User user = new User(5, 1, 100000, 10 , userCar);
    user.setMoney();

//游戏开始 & 结束
    while (true) {
        //实例化检测空白文档的方法
        DetectAnomalies detectAnomalies = new DetectAnomalies();

        //加载实际行动点
        user.equal();

        //Days
        Days days = new Days();
        days.setDay();


        //介绍游戏规则
        //你将初始拥有十万元和每日五点健康值。
        //你的目标是通过玩游戏，卖车等方式，实现赚足一百万元！
        //但是，在你的赚钱之路中会有些许坎坷。因为你仅有十点健康值，
        //每天你都可能会生病，并且扣除一定的健康值！
        //健康值不会刷新，你必须去医院购买药品来增加健康值。
        //若健康值归零，游戏将会直接失败！
        //如果你的行动值为0，你的这一天将会结束！
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


//一天开始 & 结束
        while (true) {

            if (user.getActionPoint() <= 0) {
                while (true) {
                    //你的行动点归零
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Your action points have dropped to zero.");
                    //请输入 " End the day " 或者 " End " 来结束这一天
                    System.out.println("Please enter \"End the day\" or \"End\" or \"end\" to conclude the day.");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    String userTypesInLeave = detectAnomalies.Detect();
                    if (Objects.equals(userTypesInLeave, "End the day") || Objects.equals(userTypesInLeave, "End") ||Objects.equals(userTypesInLeave, "end")) {
                        user.equal();
                        break;
                    } else {
                        //你输入错误，请重新输入
                        System.out.println("Please type in again!");
                    }
                }

                car.randomDown();
                car.randomUp();
                user.randomIll();
                days.setDay();
                break;
            }
            if (user.getHealth() <= 0) {
                //你的健康值为0，游戏结束！
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Your health points have dropped to 0, and the game is over!");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }

            if (user.getMoney() >= 1000000) {
                //恭喜你，你成功赚到了100万，游戏结束！
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Congratulations! You have successfully earned 1 million, and the game is over!");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }

            if (user.getMoney() <= 0) {
                //恭喜你触发隐藏剧情，你破产了！游戏结束！
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Congratulations! You've triggered the hidden plot—you're bankrupt! The game is over!");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }






            //今天是第几天，你现在拥有多少钱，健康值是多少，行动点是多少
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Today is your " + days.getDay() + " day!");
            System.out.println("You have " + user.getMoney() + "$ .");
            System.out.println("You have " + user.getHealth() + " health points. ");
            System.out.println("You have " + user.getActionPoint() + " action points now.");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            //现在请你选择你要去哪（前往每个地方都将会消耗健康值）
            //1. Arcade : 在这里你可以玩到各种游戏，并且在游戏结束后可获得相应报酬，但每次游玩会消耗行动点
            //2. CarShop : 在这里你可以用钱购买你的爱车，或者出售。（不同的车可以增加每日的行动点，当然，价格也不同）
            //3. Hospital : 如果你的健康值减少了，你可以到这里来购买药品增加健康值。
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
                System.out.println("You have many choices.");
                String gamesToPlay = detectAnomalies.Detect();
                //Number Band
                if (Objects.equals(gamesToPlay, "Number Band")) {
                    user.reduceActionPoint(1);
                    runNumberBand.numberBand();
                    user.addMoney(30000);
                }

            }



            //Go into Car Shop
            else if (Objects.equals(userGo, "Car Shop") || Objects.equals(userGo, "2")) {
                user.reduceActionPoint(1);
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                //我们的CarShop每天都会有随机的两台车进行升价或降价！你可以通过这个方式来选择你的购买策略！
                System.out.println("Welcome to the Car Shop.");
                System.out.println("Our CarShop has two random cars with price increases or decreases every day! You can use this method to choose your purchasing strategy!");
                System.out.println("We currently have four car models.");
                System.out.println("They are respectively MINI Cooper , Volkswagen ID.3 , Octavia , Toyota Corolla Hybrid.");
                System.out.println("1) MINI Cooper:It increases the daily initial action points by 1" + "Its price is " + car.getValue(1));
                System.out.println("2) Volkswagen ID.3:It increases the daily initial action points by 2." + "Its price is " + car.getValue(2));
                System.out.println("3) Octavia:It increases the daily initial action points by 3" + "Its price is " + car.getValue(3));
                System.out.println("4) Toyota Corolla Hybrid:It increases the daily initial action points by 4" + "Its price is " + car.getValue(4));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");


                //检查是否输入为空
                //请选择你是想购买还是卖车？（你可以输入无论大写或小写）
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Please choose whether you want to buy or sell a car? (You can enter in either uppercase or lowercase.)");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                String buyOrSell = detectAnomalies.Detect();
                //请选择你想购买哪辆车
                //你可以选择打出他们的全称（第一个单词）或者它们对应的数字编码（1，2...)或者他们的首字母（无论大小写）来选择
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Choose which car to choose ");
                System.out.println("You can select by typing their full name (only the first word), their corresponding numerical code (1, 2...), or their initial (regardless of uppercase or lowercase).");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                String carsToChoose = detectAnomalies.Detect();
                MINI mini = new MINI();
                Volkswagen volkswagen = new Volkswagen();
                Octavia octavia = new Octavia();
                Toyota toyota = new Toyota();
                //购买MINI

                if (Objects.equals(buyOrSell, "buy")|| Objects.equals(buyOrSell, "Buy")) {
                    switch (carsToChoose) {
                        case "MINI", "1", "M", "m" -> {
                            mini.BuyMINI(user, car);
                            user.addCar(0, "MINI");

                        }

                        //购买Volkswagen
                        case "Volkswagen", "2", "V", "v" -> {
                            volkswagen.BuyVolk(user, car);
                            user.addCar(1, "Volkswagen");

                        }


                        //购买Octavia
                        case "Octavia", "3", "O", "o" -> {
                            octavia.BuyOct(user, car);
                            user.addCar(2, "Octavia");

                        }


                        //购买Toyota
                        case "Toyota", "4", "T", "t" -> {
                            toyota.BuyTo(user, car);
                            user.addCar(3, "Toyota");
                        }
                        case null, default -> {
                            //看来你并没有决定好，你灰溜溜地回家了！
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("It seems you haven't made a decision yet, so you slink back home!");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                        }
                    }


                } else if (Objects.equals(buyOrSell, "sell") || Objects.equals(buyOrSell, "Sell") ) {

                    switch (carsToChoose) {
                        case "MINI", "1", "M", "m" -> {
                            if (Objects.equals(user.getCar(0), "MINI")) {
                                mini.SellMINI(user, car);
                            } else {
                                System.out.println("You do not have the car!");
                            }

                        }
                        case "Volkswagen", "2", "V", "v" -> {
                            if (Objects.equals(user.getCar(1), "Volkswagen")) {
                                volkswagen.SellVolk(user, car);
                            } else {
                                System.out.println("You do not have the car!");
                            }

                        }
                        case "Octavia", "3", "O", "o" -> {
                            if (Objects.equals(user.getCar(2), "Octavia")) {
                                octavia.SellOct(user, car);
                            } else {
                                System.out.println("You do not have the car!");
                            }

                        }
                        case "Toyota", "4", "T", "t" -> {
                            if (Objects.equals(user.getCar(3), "Toyota")) {
                                toyota.SellTo(user, car);
                            } else {
                                System.out.println("You do not have the car!");
                            }

                        }
                        case null, default -> //看来你并没有决定好，你灰溜溜地回家了！
                                System.out.println("It seems you haven't made a decision yet, so you slink back home!");
                    }
                }
                else {
                    //看来你并没有决定好，你灰溜溜地回家了！
                    System.out.println("It seems you haven't made a decision yet, so you slink back home!");
                }
            }


            //Go into Hospital
            else if (Objects.equals(userGo, "Hospital") || Objects.equals(userGo, "3")) {
                System.out.println("There are may medicines to choose !");
                String chooseMedicine = detectAnomalies.Detect();
                if (Objects.equals(chooseMedicine, "1") || Objects.equals(chooseMedicine, "lemsip")) {
                    medicine.lemsip(user);
                } else if (Objects.equals(chooseMedicine, "2") || Objects.equals(chooseMedicine, "benylin")) {
                    medicine.benylin(user);
                } else if (Objects.equals(chooseMedicine, "3") || Objects.equals(chooseMedicine, "nurofen")) {
                    medicine.nurofen(user);
                } else if (Objects.equals(chooseMedicine, "4") || Objects.equals(chooseMedicine, "bonjela")) {
                    medicine.bonjela(user);
                } else if (Objects.equals(chooseMedicine, "5") || Objects.equals(chooseMedicine, "rennie")) {
                    medicine.rennie(user);
                } else {
                    //看来你并没有决定好，你灰溜溜地回家了！
                    System.out.println("It seems you haven't made a decision yet, so you slink back home!");
                }
            }


            else {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("You type in the wrong name! Please type in again!");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }











        }

        if (user.getHealth() <= 0) {
            break;
        }

        if (user.getMoney() >= 1000000) {
            break;
        }

        if (user.getMoney() <= 0) {
            break;
        }


    }
}



