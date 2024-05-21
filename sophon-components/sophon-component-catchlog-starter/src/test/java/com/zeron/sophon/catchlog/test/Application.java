package com.zeron.sophon.catchlog.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 *
 */
@SpringBootApplication(scanBasePackages = {"com.zeron.sophon.catchlog"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
