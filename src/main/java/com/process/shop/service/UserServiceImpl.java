package com.process.shop.service;
import com.process.shop.model.User;
import com.process.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User userUpdated, Long id) {
        Optional<User> userBd = userRepository.findById(id);
        if(userBd.isEmpty()){
            return null;
        }
        userBd.get().setFullName(userUpdated.getFullName());
        userBd.get().setPhoneNumber(userUpdated.getPhoneNumber());

        return userRepository.save(userBd.get());
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userBb = userRepository.findById(id);
        if(userBb.isEmpty()){
            return null;//todo: validar excepcion
        }
        return userBb.get();


        /*
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

         */


    }



    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
