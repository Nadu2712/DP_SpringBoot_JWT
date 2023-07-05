package com.example.dp_springboot_jwt;

import com.example.dp_springboot_jwt.dto.RegisterRequest;
import com.example.dp_springboot_jwt.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.dp_springboot_jwt.entity.Role.ADMIN;
import static com.example.dp_springboot_jwt.entity.Role.MANAGER;

@SpringBootApplication
public class DpSpringBootJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(DpSpringBootJwtApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("Admin")
                    .lastname("Admin")
                    .email("manager@mail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };
    }

}
