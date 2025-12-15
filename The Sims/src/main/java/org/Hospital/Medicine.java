package org.Hospital;


import org.User.User;

public class Medicine {
    String[] medicine = {"Lemsip", "Benylin" , "NUROFEN" , "Bonjela" , "Rennie" };
    int[] value = {1000 , 2000 , 3000 , 40000 ,5000};



    public void lemsip(User user){
        user.reduceMoney(value[0]);
        user.addHealth(1);
    }
    public void benylin(User user){
        user.reduceMoney(value[1]);
        user.addHealth(2);
    }
    public void nurofen(User user){
        user.reduceMoney(value[2]);
        user.addHealth(3);
    }
    public void bonjela(User user){
        user.reduceMoney(value[3]);
        user.addHealth(4);
    }
    public void rennie(User user){
        user.reduceMoney(value[4]);
        user.addHealth(5);
    }




}
