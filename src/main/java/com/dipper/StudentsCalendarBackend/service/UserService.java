package com.dipper.StudentsCalendarBackend.service;


import com.dipper.StudentsCalendarBackend.converter.UserEntityUserDtoConverter;
import com.dipper.StudentsCalendarBackend.dto.UserDto;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityUserDtoConverter userEntityUserDtoConverter;

    public UserDto registerUser(UserEntity userToRegister){
        UserEntity recivedUser = userRepository.findByUserName(userToRegister.getUserName());
        if(recivedUser==null){
            return userEntityUserDtoConverter.convert(userRepository.save(userToRegister));
        }else{
            return null;
        }
    }

    public UserDto authorizeUser(UserEntity loggingUser){
        UserEntity recivedUser = userRepository.findByUserName(loggingUser.getUserName());
        if(recivedUser!=null && recivedUser.getPassword().equals(loggingUser.getPassword())){
            return userEntityUserDtoConverter.convert(recivedUser);
        }else{
            return null;
        }
    }
}
