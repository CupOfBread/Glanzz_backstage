package cn.cupbread.glanzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GlanzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlanzzApplication.class, args);
    }

}
