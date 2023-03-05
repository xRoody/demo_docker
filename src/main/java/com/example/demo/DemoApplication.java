package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource=SpringApplication.run(DemoApplication.class, args).getBean(DataSource.class);
        System.out.println(dataSource.getConnection().getSchema());
    }
}
