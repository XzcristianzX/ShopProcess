package com.process.shop.service;

import com.process.shop.model.Address;
import com.process.shop.model.User;
import com.process.shop.model.enunm.DocumentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User userUpdated, Long id) {
        return null;
    }

    @Override
    public User getUser(Long id) {

        return User.builder()
                .fullName("cristian")
                .cc("12345")
                .ccType(DocumentType.CC)
                .address(List.of(Address.builder()
                        .street("calle13")
                        .neighborhood("neig")
                        .build()
                ))
                .build();


    }



    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
