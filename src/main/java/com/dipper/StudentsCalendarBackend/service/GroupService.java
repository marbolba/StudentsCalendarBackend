package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.entity.GroupEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.repository.GroupRepository;
import com.dipper.StudentsCalendarBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    public GroupEntity addGroup(GroupEntity groupEntity){
        return groupRepository.save(groupEntity);
    }
    public void addUserToGroup(UserEntity newUser, int groupId){
        //TODO check if user is already present in group
        GroupEntity searchedGroup = groupRepository.findById(groupId).get();
        newUser = userRepository.findById(newUser.getUser_id()).get();
        searchedGroup.setUsers(newUser);
        groupRepository.save(searchedGroup);
    }
}
