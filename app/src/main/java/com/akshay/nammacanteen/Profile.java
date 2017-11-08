package com.akshay.nammacanteen;

/**
 * Created by admin on 03-Nov-17.
 */

public class Profile {
    private String Username,Street, City, phonenumber;
    private int  hno;

    public Profile(String phonenumber, String Username, int hno, String Street,String City){
        this.Username=Username;
        this.Street=Street;
        this.City=City;
        this.phonenumber=phonenumber;
        this.hno=hno;
    }


    public String getUsername(){
        return Username;
    }
    public String getStreet(){
        return Street;
    }
    public String getCity(){
        return City;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public int getHno(){ return hno;}
}
