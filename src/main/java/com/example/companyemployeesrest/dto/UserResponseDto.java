package com.example.companyemployeesrest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserResponseDto {
    private int id;
    private String name;
    private String surname;
    private String userEmail;
    private String password;


}