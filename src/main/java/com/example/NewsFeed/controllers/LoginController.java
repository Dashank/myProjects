package com.example.NewsFeed.controllers;

import com.example.NewsFeed.dtos.LoginReqDTO;
import com.example.NewsFeed.dtos.LoginResDTO;
import com.example.NewsFeed.dtos.ResponseDTO;
import com.example.NewsFeed.dtos.SignUpReqDTO;
import com.example.NewsFeed.models.User;
import com.example.NewsFeed.services.LoginService;

public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public ResponseDTO<LoginResDTO> createLogin(LoginReqDTO request) {

        User user = loginService.createLoginService(request.getUsername(),request.getPassword());

        LoginResDTO response = new LoginResDTO();
        response.setUser(user);

        ResponseDTO<LoginResDTO> baseResponse = new ResponseDTO();

        if(user==null) {
            baseResponse.setStatus("Failure");
        } else {
            baseResponse.setStatus("Success");
        }

        baseResponse.setData(response);

        return baseResponse;


    }
}
