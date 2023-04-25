package com.example.NewsFeed;

import com.example.NewsFeed.controllers.LoginController;
import com.example.NewsFeed.dtos.*;
import com.example.NewsFeed.controllers.SignUpController;
import com.example.NewsFeed.repositories.SignUpRepository;
import com.example.NewsFeed.services.LoginService;
import com.example.NewsFeed.services.SignUpService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;

@SpringBootApplication
public class NewsFeedApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {




            String input = scanner.nextLine();
            List<String> params = Arrays.stream(input.split(" ")).toList();

            String command = params.get(0);
            String username = params.get(1);
            String password = params.get(2);



            if(command.equals("signup")) {

                SignUpRepository signUpRepository = new SignUpRepository();
                SignUpService signUpService = new SignUpService(signUpRepository);
                SignUpController signUpController = new SignUpController(signUpService);

                SignUpReqDTO request = new SignUpReqDTO();
                request.setUsername(username);
                request.setPassword(password);

                ResponseDTO<SignUpResDTO> response;
                response = signUpController.createSignUp(request);
                if(response.getStatus().equals("Success")) {
                    System.out.println("User has signed up successfully !!");
                } else {
                    System.out.println("User has already signed up !!");
                }

            }
            else if(command.equals("login"))
            {
                SignUpRepository signUpRepository = new SignUpRepository();
                LoginService loginService = new LoginService(signUpRepository);
                LoginController loginController = new LoginController(loginService);

                LoginReqDTO request = new LoginReqDTO();
                request.setUsername(username);
                request.setPassword(password);

                ResponseDTO<LoginResDTO> response;
                response = loginController.createLogin(request);
                if(response.getStatus().equals("Success")) {
                    System.out.println("User has logged in successfully !!");
                }
                else {
                    System.out.println("invalid credentials");
                }
            }




        }
    }

}
