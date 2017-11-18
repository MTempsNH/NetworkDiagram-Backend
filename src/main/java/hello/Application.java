package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ComponentScan
public class Application {

    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[] {"./Spring-Autoscan.xml"});

        SpringApplication.run(Application.class, args);
    }

}