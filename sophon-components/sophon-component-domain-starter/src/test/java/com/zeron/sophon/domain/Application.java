package com.zeron.sophon.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Customer customer = DomainFactory.create(Customer.class);

        System.out.println("Customer purchase power score : " + customer.getPurchasePowerScore());
    }
}
