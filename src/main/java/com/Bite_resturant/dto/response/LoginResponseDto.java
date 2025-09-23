package com.Bite_resturant.dto.response;

import com.Bite_resturant.dto.UserDto;

public class LoginResponseDto {
    private String token;
    private LoginResponseUserDto loginResponseUserDto;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String token, LoginResponseUserDto loginResponseUserDto) {
        this.token = token;
        this.loginResponseUserDto = loginResponseUserDto;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponseUserDto getLoginResponseUserDto() {
        return loginResponseUserDto;
    }

    public void setLoginResponseUserDto(LoginResponseUserDto loginResponseUserDto) {
        this.loginResponseUserDto = loginResponseUserDto;
    }
}
