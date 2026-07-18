package com.shivam.demo.DependancyInjaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

 //   PaymentService paymentService;

 //   @Autowired
    PaymentService paymentService;   //field injection

    OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    // if we have multiple cinstructot then called @aurtowired , not in single as autoactio;ly underetastnd


   // @Autowired
    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.payment();
        System.out.println("ORder Placed");
    }
}
