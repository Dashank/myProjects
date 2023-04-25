package com.example.NewsFeed.controllers;
import com.example.NewsFeed.models.User;
import com.example.NewsFeed.dtos.ResponseDTO;
import com.example.NewsFeed.dtos.SignUpReqDTO;
import com.example.NewsFeed.dtos.SignUpResDTO;
import com.example.NewsFeed.services.SignUpService;

public class SignUpController {

    private SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    public ResponseDTO<SignUpResDTO> createSignUp(SignUpReqDTO request) {

        User user = signUpService.createSignUpService(request.getUsername(),request.getPassword());

        SignUpResDTO response = new SignUpResDTO();

        response.setUser(user);

        ResponseDTO<SignUpResDTO> baseResponse = new ResponseDTO();
        if(user==null) {
            baseResponse.setStatus("Failure");
        } else {
            baseResponse.setStatus("Success");
        }
        baseResponse.setData(response);

        return baseResponse;



    }

}
