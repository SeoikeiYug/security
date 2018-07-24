package com.seoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shuaiqi
 * @create 2018-07-23 14:55
 * @desc start
 **/
@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.seoi")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
