package com.example.springboot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>在开始处详细描述该类的作用</p>
 *
 * @author haijie.liang
 * @date 2022/11/25 10:03
 */
@SpringBootApplication
public class KafkaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringBootApplication.class, args);
    }
}

