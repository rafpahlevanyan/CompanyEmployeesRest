package com.example.companyemployeesrest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class CreateUserRequest {


    private String name;
    private String surname;
    private String userEmail;
    private String password;


}