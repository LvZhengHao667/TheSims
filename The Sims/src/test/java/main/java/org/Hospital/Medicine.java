package org.Hospital;


import org.User.User;

public class Medicine {
    String[] medicine = {"Lemsip", "Benylin" , "NUROFEN" , "Bonjela" , "Rennie" };
    int[] value = {1000 , 2000 , 3000 , 40000 ,5000};



    public void lemsip(User user){
        user.reduceMoney(1000);
        user.addHealth(1);
    }
    public void benylin(User user){
        user.reduceMoney(2000);
        user.addHealth(2);
    }
    public void nurofen(User user){
        user.reduceMoney(3000);
        user.addHealth(3);
    }
    public void bonjela(User user){
        user.reduceMoney(4000);
        user.addHealth(4);
    }
    public void rennie(User user){
        user.reduceMoney(5000);
        user.addHealth(5);
    }




}
