package com.aop.AOP.demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public  void  checkout(String status){
        //logging
        //Authentication & Authorization
        System.out.println("Checkout from ShoppingCart Called");
    }

    public  int quantity(){
        return  2;
    }



}
