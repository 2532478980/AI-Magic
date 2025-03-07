package org.elves;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
@SpringBootApplication
@EnableKnife4j
public class ServeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServeApplication.class, args);
    }
}
