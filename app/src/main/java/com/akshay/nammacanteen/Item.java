package com.akshay.nammacanteen;

/**
 * Created by admin on 31-Oct-17.
 */

public class Item {
    private String Itemname;
    private double price;
    private int count;

    public Item(String Itemname,double price,int count){
        this.Itemname=Itemname;
        this.price=price;
        this.count=0;

    }


    public String getItemname(){
        return Itemname;
    }
    public double getPrice(){
        return price;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count){
        this.count =count;
    }
}
