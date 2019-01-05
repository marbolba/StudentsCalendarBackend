package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.view.UserView;
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
        UserView registeredUser = userService.registerUser(userEntity);
        if(registeredUser!=null){
            return new ResponseEntity<UserView>(registeredUser,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<UserView>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/auth",method = RequestMethod.POST, consumes = "application/json",produces = "application/json")
    ResponseEntity<?> authorizeUser(@RequestBody UserEntity userEntity){
        UserView authRequestedUser = userService.authorizeUser(userEntity);
        if(authRequestedUser!=null){
            return new ResponseEntity<UserView>(authRequestedUser,HttpStatus.OK);
        }else{
            return new ResponseEntity<UserView>(HttpStatus.FORBIDDEN);
        }
    }
}
