package com.Bite_resturant.service;

import com.Bite_resturant.dto.ItemDto;
import com.Bite_resturant.dto.UserDto;
import com.Bite_resturant.dto.request.LoginDto;
import com.Bite_resturant.dto.request.RegisterDto;
import com.Bite_resturant.dto.response.LoginResponseUserDto;
import com.Bite_resturant.dto.response.UserResponseDto;
import com.Bite_resturant.entity.Item;
import com.Bite_resturant.entity.User;
import com.Bite_resturant.repo.UserRepo;
import com.Bite_resturant.utill.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public String userRegister(RegisterDto registerDto) {
        try{
            User user = new User(
                    registerDto.getEmail(),registerDto.getFirstName(),registerDto.getLastName(),registerDto.getNumber(),
                    registerDto.getAddress(),passwordEncoder.encode(registerDto.getPassword()),registerDto.getRole()
            );
            User savedUser = userRepo.save(user);
            if(savedUser==null){
                return null;
            }else{
                return "user save successfully...";
            }
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public List<UserResponseDto> getAllUsers() {
        try{
            List<UserResponseDto> userResponseDtos = new ArrayList<>();
            List<User>  userList = userRepo.findAll();
            if(userList==null){
                return null;
            }else{
                for(User user:userList){
                    UserResponseDto userResponseDto = new UserResponseDto(
                            user.getEmail(),user.getFirstName(),user.getLastName(),user.getNumber(),
                            user.getAddress(),user.getRole()
                    );
                    userResponseDtos.add(userResponseDto);
                }
                return userResponseDtos;
            }
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }

    public List<UserResponseDto> getAllByName(String word) {
        try{
            // Fetch users where first name OR last name matches the word
            List<User> users = userRepo.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(word, word);

            // Convert User entities to UserResponseDto
            return users.stream()
                    .map(user -> new UserResponseDto(
                            user.getEmail(),
                            user.getFirstName(),
                            user.getLastName(),
                            user.getNumber(),
                            user.getAddress(),
                            user.getRole()
                    ))
                    .collect(Collectors.toList());

        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }



    public LoginResponseUserDto findByEmail(String email) {
        User user = userRepo.findByEmail(email);
        if(user != null){
            return new LoginResponseUserDto(
                    user.getEmail(),user.getFirstName(),user.getLastName(),user.getNumber(),
                    user.getAddress(),user.getRole()
            );
        }
        else{
            return null;
        }
    }



    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public String authentication(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(loginDto.getEmail());
        }
        throw new RuntimeException();
    }
}
