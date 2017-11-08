package com.akshay.nammacanteen;

/**
 * Created by admin on 02-Nov-17.
 */

public class Sales {
    private String Itemname, salesid,soldon;
    private double total;
    private int quantity;

    public Sales(String Itemname,String salesid, String soldon, double total,int quantity){
        this.Itemname=Itemname;
        this.total=total;
        this.quantity=quantity;
        this.salesid=salesid;
        this.soldon=soldon;
    }


    public String getItemname(){
        return Itemname;
    }
    public double getTotal(){
        return total;
    }
    public String getSalesid(){
        return salesid;
    }
    public String getSoldon(){
        return soldon;
    }
    public int getQuantity() {
        return quantity;
    }

}
