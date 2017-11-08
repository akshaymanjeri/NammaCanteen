package com.akshay.nammacanteen;

/**
 * Created by admin on 06-Nov-17.
 */

public class Order {
    private String orderid,orderon,phoneno,OrderAmt;

    public Order(String orderid,String orderon,String phoneno,String OrderAmt){
        this.orderid=orderid;
        this.orderon=orderon;
        this.phoneno=phoneno;
        this.OrderAmt=OrderAmt;
    }


    public String getOrderid(){
        return orderid;
    }
    public String getOrderon(){
        return orderon;
    }
    public String getPhoneno(){
        return phoneno;
    }
    public String getOrderAmt(){return OrderAmt;}


}
