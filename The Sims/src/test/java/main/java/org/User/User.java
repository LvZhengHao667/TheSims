package org.User;

import java.util.Random;

public class User {
    public User(int actionPoint,int initialActionPoint ,int money , int health , String[] car  ){
        this.actionPoint = actionPoint;
        this.initialActionPoint = initialActionPoint;
        this.money = money;
        this.health = health;
        this.car = car;
    }


    int actionPoint;
    int initialActionPoint ;
    int money ;
    int health ;
    String[] car ;

    //Health
    public int getHealth() {
        return health;
    }

    public void reduceHealth(int healthNumber){
        this.health-=healthNumber;
    }

    public void addHealth(int healthNumber){
        this.health+=healthNumber;
    }

    public void randomIll(){
        Random randomNumber = new Random();
        reduceHealth(randomNumber.nextInt(3));
    }

    //Set action points at the beginning of the day
    public void setInitialActionPoint(int number){
        this.initialActionPoint = 5 + number ;
    }

    public void equal(){
        this.actionPoint = this.initialActionPoint;
    }

    //Action points which are in changing

    public int getActionPoint(){
        return actionPoint;
    }

    public void reduceActionPoint(int actionNumber){
        this.actionPoint-=actionNumber;
    }


    //Money

    public void setMoney(){
        this.money = 10000;
    }

    public int getMoney(){
        return money;
    }

    public void reduceMoney(int reduceMoney){
        this.money = this.money - reduceMoney;
    }

    public void addMoney(int addMoney){
        this.money = this.money - addMoney;
    }

    public String getCar(int number){
        return car[number];
    }

    public void addCar(int number , String cars){
        car[number] = cars;
    }

    public void sellCar(int number){
        car[number] = "";
    }





}

