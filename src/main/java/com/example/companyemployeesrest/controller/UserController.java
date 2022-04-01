package com.example.companyemployeesrest.controller;

import com.example.companyemployeesrest.dto.CreateUserRequest;
import com.example.companyemployeesrest.dto.UserResponseDto;
import com.example.companyemployeesrest.entity.User;
import com.example.companyemployeesrest.entity.UserRole;
import com.example.companyemployeesrest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/users/{id}")
    public UserResponseDto getUserById(@PathVariable("id") int id) {
        return modelMapper.map(userService.getById(id), UserResponseDto.class);
    }

    @GetMapping("/users/")
    public List<UserResponseDto> getUsers() {
        List<UserResponseDto> result = new ArrayList<>();
        for (User user : userService.findAll()) {
            result.add(modelMapper.map(user, UserResponseDto.class));
        }
        return result;
    }

    @PostMapping("/users")
    public UserResponseDto saveUser(@RequestBody CreateUserRequest createUserRequest){
        User user = modelMapper.map(createUserRequest, User.class);
        user.setUserRole(UserRole.USER);
        user.setActive(false);
        user.setToken(UUID.randomUUID().toString());
        user.setTokenCreatedDate(LocalDateTime.now());
        userService.save(user);
        UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
        return userResponseDto;
    }
    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@RequestBody CreateUserRequest createUserRequest,
                                      @PathVariable("id") int id){

        User byId = userService.getById(id);
        if (createUserRequest.getName()!=null) {
            byId.setName(createUserRequest.getName());
        }if (createUserRequest.getSurname()!=null) {
            byId.setName(createUserRequest.getSurname());
        }if (createUserRequest.getUserEmail()!=null) {
            byId.setName(createUserRequest.getUserEmail());
        }if (createUserRequest.getPassword()!=null) {
            byId.setName(createUserRequest.getPassword());
        }
        userService.save(byId);
        UserResponseDto userResponseDto = modelMapper.map(byId, UserResponseDto.class);
        return userResponseDto;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteById(@PathVariable("id") int id){
        if (userService.existsById(id)) {
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
