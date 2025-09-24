package com.Bite_resturant.controller;


import com.Bite_resturant.dto.request.LoginDto;
import com.Bite_resturant.dto.request.RegisterDto;
import com.Bite_resturant.dto.response.LoginResponseDto;
import com.Bite_resturant.dto.response.LoginResponseUserDto;
import com.Bite_resturant.dto.response.UserResponseDto;
import com.Bite_resturant.service.UserService;
import com.Bite_resturant.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<StandardResponse> registerUser(@RequestBody RegisterDto registerDto){
        String message = userService.userRegister(registerDto);
        StandardResponse response=null;
        if(message.isEmpty()){
            response = new StandardResponse(404,"user not register to the database",null);
        }else{
            response = new StandardResponse(200,"user register to the database",message);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/authentication")
    public ResponseEntity<StandardResponse> authentication(@RequestBody LoginDto loginDto){
        String token = userService.authentication(loginDto);
        LoginResponseUserDto loginResponseUserDto = userService.findByEmail(loginDto.getEmail());
        LoginResponseDto loginResponseDto = new LoginResponseDto(
                token,loginResponseUserDto
        );
        StandardResponse response=null;
        if(token == null && loginResponseDto == null){
            response = new StandardResponse(404,"login error",null);
        }else{
            response = new StandardResponse(200,"Login successfully",loginResponseDto);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }





    @GetMapping("/")
    public ResponseEntity<StandardResponse> getAllUser(){
        List<UserResponseDto> users = userService.getAllUsers();
        StandardResponse response=null;
        if(users==null){
            response = new StandardResponse(404,"no users found",null);
        }else{
            response = new StandardResponse(200,"users founds",users);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{word}")
    public ResponseEntity<StandardResponse> getByName(@PathVariable String word){
        List<UserResponseDto> users = userService.getAllByName(word);
        StandardResponse response=null;
        if(users==null){
            response = new StandardResponse(404,"no users found",null);
        }else{
            response = new StandardResponse(200,"users founds",users);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }










}
