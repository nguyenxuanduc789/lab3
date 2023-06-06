package com.example.demo.entity;

import com.example.demo.Validator.annotation.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username",length = 50,nullable = false)
    @Size(max =50,message = "username must be less than 50")
    @ValidUsername
    private  String username;


    @Column(name = "password",length = 250,nullable = false)
    @NotBlank(message = "password id required")
    private  String password;

    @Column(name = "email",length = 50)
    @Size(max=50,message = "email must be less than 50")
    @Email(message = "Email should be")
    private  String email;

    @Column(name = "name",length = 50,nullable = false)
    @Size(max=50,message = "your name must be less than 50")
    @NotBlank(message = "your name is required")
    private  String name;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private  List<Book> books=new ArrayList<>();
}
