package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.entity.GroupEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<?> registerUser(@RequestBody GroupEntity groupEntity){
        return new ResponseEntity<>(groupService.addGroup(groupEntity), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST,consumes = "application/json")
    ResponseEntity<?> addUserToGroup(@RequestBody UserEntity userEntity,@RequestParam String groupName){
        groupService.addUserToGroup(userEntity,groupName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<?> getUsersGroups(@RequestParam int userId){
        return new ResponseEntity<>(groupService.getUsersGroups(userId),HttpStatus.OK);
    }
}