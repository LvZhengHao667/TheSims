package org.CarShop;



import java.util.Random;

public class Cars {
    //设置车的初始值
    String[] cars = {"MINI Cooper" , "Volkswagen ID.3" , "Octavia" , "Toyota Corolla Hybrid"};
    int[] values = {200000 , 300000 , 400000 , 500000};


    //得到汽车价格
    public int getValue(int round){
        return values[round-1];
    }

    public void randomUp(){
        int random =( ((int) (Math.random() * 10)/3) * 100000);
        Random randomNumber = new Random();
        int randomInt = randomNumber.nextInt(3);
        values[randomInt] = values[randomInt]+random;
    }


    public void randomDown(){
        int random =(((int) (Math.random() * 10)/3) * 100000);
        Random randomNumber = new Random();
        int randomInt = randomNumber.nextInt(3);
        values[randomInt] = values[randomInt]-random;
    }










}
