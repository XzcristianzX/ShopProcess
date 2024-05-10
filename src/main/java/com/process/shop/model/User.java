package com.process.shop.model;

import com.process.shop.model.enunm.DocumentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "please provide the full name")
    private String fullName;
    private DocumentType ccType;
    @NotBlank(message = "please provide the full cedula")
    private String cc;
    private LocalDate birthDay;
    @NotBlank(message = "please provide the full phone")
    private String phoneNumber;
    @Email(message = "please email")
    private String email;
    @NotBlank(message = "please password")
    @Size(min = 8,max = 15)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Address> address;


}
