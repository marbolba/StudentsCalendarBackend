package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.converter.GroupEntityToGroupDtoConverter;
import com.dipper.StudentsCalendarBackend.dto.GroupDto;
import com.dipper.StudentsCalendarBackend.entity.GroupEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.repository.GroupRepository;
import com.dipper.StudentsCalendarBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;
    private GroupEntityToGroupDtoConverter groupEntityToGroupDtoConverter;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository, GroupEntityToGroupDtoConverter groupEntityToGroupDtoConverter) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.groupEntityToGroupDtoConverter = groupEntityToGroupDtoConverter;
    }

    public GroupEntity addGroup(GroupEntity groupEntity){
        return groupRepository.save(groupEntity);
    }
    public void addUserToGroup(UserEntity newUser, String groupName){
        //TODO check if user is already present in group
        GroupEntity searchedGroup = groupRepository.findByGroupName(groupName);
        if(searchedGroup!=null){
            newUser = userRepository.findById(newUser.getUser_id()).get();
            searchedGroup.setUsers(newUser);
            groupRepository.save(searchedGroup);
        }
        //TODO ADD ERRORS !!!
    }

    public List<GroupDto> getUsersGroups(int userId){
        List<GroupDto> foundGroups = new ArrayList<>();
        for(GroupEntity group : groupRepository.findAll()){
            for(UserEntity user: group.getUsers()){
                if(user.checkById(userId)){
                    foundGroups.add(groupEntityToGroupDtoConverter.convert(group));
                    break;
                }
            }
        }
        return foundGroups;
    }
}
