package org.CarShop;




import org.Detect.DetectAnomalies;
import org.User.User;

import java.util.Objects;
import java.util.Scanner;

public class MINI {
    public void BuyMINI (User user , Cars car) {
        if (user.getMoney() >= car.getValue(1)) {
            while (true) {
                System.out.println("Now, you can enter 'Yes' or 'yes' or 'Y' or 'y' to decide whether to purchase.");
                System.out.println("Or you can also enter 'No' or 'no' or 'N' or 'n' to refuse the purchase.");
                Scanner confirmBuyMINI = new Scanner(System.in);
                String confirmsBuyMINI = String.valueOf(confirmBuyMINI.nextLine());
                if (Objects.equals(confirmsBuyMINI, "Yes") || Objects.equals(confirmsBuyMINI, "yes") || Objects.equals(confirmsBuyMINI, "Y") || Objects.equals(confirmsBuyMINI, "y")) {
                    user.reduceActionPoint(1);
                    user.reduceMoney(car.getValue(1));
                    user.setInitialActionPoint(1);
                    System.out.println("You get the car!");
                    break;
                }
                else if (Objects.equals(confirmsBuyMINI, "No") || Objects.equals(confirmsBuyMINI, "no") || Objects.equals(confirmsBuyMINI, "N") || Objects.equals(confirmsBuyMINI, "n")) {
                    System.out.println(" You didn’t find a car you liked today, so you’ll have to come back another time.");
                    break;
                }
                else {
                    //你输入了错误的内容，请重新输入
                    System.out.println("You have entered incorrect content. Please re-enter.");

                }

            }
        } else {
            System.out.println("You don't have enough money, so you can only slink back home!");
        }
    }
    public void SellMINI( User user , Cars car){
        DetectAnomalies detectAnomalies = new DetectAnomalies();
        while(true){
            System.out.println("If you really want to sell the car?");
            String sellCars = detectAnomalies.Detect();
            if (Objects.equals(sellCars, "Yes") ||  Objects.equals(sellCars, "yes") || Objects.equals(sellCars, "Y") || Objects.equals(sellCars, "y")){
                System.out.println("You sell the car!");
                user.reduceActionPoint(1);
                user.addMoney(car.getValue(1));
                user.sellCar(0);
                break;
            }
            else if (Objects.equals(sellCars, "No") || Objects.equals(sellCars, "no") || Objects.equals(sellCars, "N") || Objects.equals(sellCars, "n")) {
                System.out.println("You do not sell the car.");
                break;
            }
            else {
                //你输入了错误的内容，请重新输入
                System.out.println("You have entered incorrect content. Please re-enter.");

            }
        }




    }
}
