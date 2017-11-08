package com.akshay.nammacanteen;

/**
 * Created by admin on 05-Nov-17.
 */

public class Review {
    private String review,retype,phno;
    public Review(String review,String retype, String phno){
        this.review=review;
        this.retype=retype;
        this.phno=phno;
    }
    public String getReview(){return review;}
    public String getRetype(){return retype;}
    public String getPhno(){return phno;}
}
