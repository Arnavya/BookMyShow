package com.sst.bookmyshowsst.controllers;

import com.sst.bookmyshowsst.dtos.*;
import com.sst.bookmyshowsst.dtos.ResponseStatus;
import com.sst.bookmyshowsst.models.User;
import com.sst.bookmyshowsst.services.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //http://localhost:8080/users/signup
    @PostMapping("/signup")
    public SignUpResponseDto signup(@RequestBody SignUpRequestDto requestDto){
        User user = userService.signup(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        SignUpResponseDto responseDto = new SignUpResponseDto();
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setEmail(user.getEmail());
        responseDto.setId(user.getId());
        return responseDto;
    }
    @GetMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto){
        ResponseStatus responseStatus = userService.login(requestDto.getEmail(), requestDto.getPassword());
        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setResponseStatus(responseStatus);
        return responseDto;
    }
}
