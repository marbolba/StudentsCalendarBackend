package com.dipper.StudentsCalendarBackend.service;


import com.dipper.StudentsCalendarBackend.converter.UserEntityUserViewConverter;
import com.dipper.StudentsCalendarBackend.view.UserView;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityUserViewConverter userEntityUserViewConverter;

    public UserView registerUser(UserEntity userToRegister){
        UserEntity recivedUser = userRepository.findByUserName(userToRegister.getUserName());
        if(recivedUser==null){
            return userEntityUserViewConverter.convert(userRepository.save(userToRegister));
        }else{
            return null;
        }
    }

    public UserView authorizeUser(UserEntity loggingUser){
        UserEntity recivedUser = userRepository.findByUserName(loggingUser.getUserName());
        if(recivedUser!=null && recivedUser.getPassword().equals(loggingUser.getPassword())){
            return userEntityUserViewConverter.convert(recivedUser);
        }else{
            return null;
        }
    }

    public UserEntity findUserById(int userId){
        if(userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get();
        }else {
            throw new NoSuchElementException(){};
        }
    }
}
