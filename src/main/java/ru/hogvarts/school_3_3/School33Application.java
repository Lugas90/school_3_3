package ru.hogvarts.school_3_3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class School33Application {

    public static void main(String[] args) {
        SpringApplication.run(School33Application.class, args);
    }

}
