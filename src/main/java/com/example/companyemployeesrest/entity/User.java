package com.example.companyemployeesrest.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String userEmail;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private String token;
    private boolean active;
    private LocalDateTime tokenCreatedDate;

}