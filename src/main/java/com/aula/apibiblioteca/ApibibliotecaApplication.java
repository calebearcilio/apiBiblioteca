package com.aula.apibiblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApibibliotecaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApibibliotecaApplication.class, args);
    IO.print("Server on: http://localhost:3333");
  }

}
