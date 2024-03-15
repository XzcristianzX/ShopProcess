package com.process.shop.model;

import com.process.shop.model.enunm.DocumentType;
import lombok.AccessLevel;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

@Data
public class User{
    private String fullName;
    private Date birthDay;
    private DocumentType ccType;
    private String cc;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Address> address;


}
