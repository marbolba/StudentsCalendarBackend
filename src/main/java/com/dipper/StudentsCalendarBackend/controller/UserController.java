package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.dto.UserDto;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity){
        UserDto registeredUser = userService.registerUser(userEntity);
        if(registeredUser!=null){
            return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<UserDto>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/auth",method = RequestMethod.POST, consumes = "application/json",produces = "application/json")
    ResponseEntity<?> authorizeUser(@RequestBody UserEntity userEntity){
        UserDto authRequestedUser = userService.authorizeUser(userEntity);
        if(authRequestedUser!=null){
            return new ResponseEntity<UserDto>(authRequestedUser,HttpStatus.OK);
        }else{
            return new ResponseEntity<UserDto>(HttpStatus.FORBIDDEN);
        }

    }
}
