package edu.ciphernotebook.shchors.client;

import edu.ciphernotebook.shchors.client.login.LoginView;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        //SpringApplication.run(ClientApplication.class, args);
        new SpringApplicationBuilder(ClientApplication.class).headless(false).run(args);
    }

    @Bean
    LoginView showLogin()
    {
        return new LoginView();
    }

}
