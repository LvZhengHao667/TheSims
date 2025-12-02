package org.CarShop;


import org.Detect.DetectAnomalies;
import org.User.User;

import java.util.Objects;
import java.util.Scanner;

public class Octavia {
    public void BuyOct(User user , Cars car ){
        if (user.getMoney() >= car.getValue(3)) {
            while (true) {
                System.out.println("Now, you can enter 'Yes' or 'yes' or 'Y' or 'y' to decide whether to purchase.");
                System.out.println("Or you can also enter 'No' or 'no' or 'N' or 'n' to refuse the purchase.");
                Scanner confirmBuyOctavia = new Scanner(System.in);
                String confirmsBuyOctavia = String.valueOf(confirmBuyOctavia.nextLine());
                if (Objects.equals(confirmsBuyOctavia, "Yes") || Objects.equals(confirmsBuyOctavia, "Y") || Objects.equals(confirmsBuyOctavia, "y")) {
                    user.reduceActionPoint(1);
                    user.reduceMoney(car.getValue(2));
                    user.setInitialActionPoint(2);
                    System.out.println("You get the car!");
                    break;
                }
                else if (Objects.equals(confirmsBuyOctavia, "No") || Objects.equals(confirmsBuyOctavia, "no") || Objects.equals(confirmsBuyOctavia, "N") || Objects.equals(confirmsBuyOctavia, "n")) {
                    System.out.println(" You didn’t find a car you liked today, so you’ll have to come back another time.");
                    break;
                }
                else {
                    //你输入了错误的内容，请重新输入
                    System.out.println("You have entered incorrect content. Please re-enter.");
                }

            }
        } else {
            //你没有足够的钱，你只能灰溜溜回家了！
            System.out.println("You don't have enough money, so you can only slink back home!");
        }

}
    public void SellOct( User user , Cars car){
        DetectAnomalies detectAnomalies = new DetectAnomalies();
        while(true){
            System.out.println("If you really want to sell the car?");
            String sellCars = detectAnomalies.Detect();
            if (Objects.equals(sellCars, "Yes") ||  Objects.equals(sellCars, "yes") || Objects.equals(sellCars, "Y") || Objects.equals(sellCars, "y")){
                System.out.println("You sell the car!");
                user.reduceActionPoint(1);
                user.addMoney(car.getValue(3));
                user.sellCar(2);
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
