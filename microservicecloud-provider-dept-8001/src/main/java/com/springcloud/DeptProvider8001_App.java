package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * DeptProvider提供类，Eureka客户端
 *
 * @author Leon
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8001_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
