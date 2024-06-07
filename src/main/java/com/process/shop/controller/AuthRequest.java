package com.process.shop.controller;


import lombok.Builder;
import lombok.Data;

//TROCAR
@Data
@Builder
public class AuthRequest {
    private String token;
}
