package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.converter.FileEntityToFileDtoConverter;
import com.dipper.StudentsCalendarBackend.converter.GroupEntityToGroupDtoConverter;
import com.dipper.StudentsCalendarBackend.dto.FileDto;
import com.dipper.StudentsCalendarBackend.dto.GroupDto;
import com.dipper.StudentsCalendarBackend.entity.FileEntity;
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
    private FileService fileService;
    private FileEntityToFileDtoConverter fileEntityToFileDtoConverter;

    @Autowired
    public GroupService(GroupRepository groupRepository,
                        UserRepository userRepository,
                        GroupEntityToGroupDtoConverter groupEntityToGroupDtoConverter,
                        FileService fileService,
                        FileEntityToFileDtoConverter fileEntityToFileDtoConverter) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.groupEntityToGroupDtoConverter = groupEntityToGroupDtoConverter;
        this.fileService = fileService;
        this.fileEntityToFileDtoConverter = fileEntityToFileDtoConverter;
    }

    public GroupEntity getGroupById(int groupId){
        //TODO if not found ...
        return groupRepository.findById(groupId).get();
    }

    public GroupEntity addGroup(GroupEntity groupEntity){
        //TODO check if group is still avaliable
        return groupRepository.save(groupEntity);
    }

    public void addUserToGroup(UserEntity newUser, String groupName){
        //TODO check if user is already present in group
        GroupEntity searchedGroup = groupRepository.findByGroupName(groupName);
        if(searchedGroup!=null){
            newUser = userRepository.findById(newUser.getUserId()).get();
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

    public void addFileToGroup(int groupId,int fileId){
        //TODO CHECK IF ANYTHING FOUND
        FileEntity fileToAdd = fileService.getFile(fileId);
        GroupEntity groupEntity = getGroupById(groupId);
        groupEntity.setFiles(fileToAdd);
        groupRepository.save(groupEntity);
    }
    public List<FileDto> getGroupFilesList(int groupId){
        System.out.println(groupId);
        GroupEntity groupEntity = getGroupById(groupId);
        List<FileDto> filesDto = new ArrayList<>();
        for(FileEntity file: groupEntity.getFiles()){
            filesDto.add(fileEntityToFileDtoConverter.convert(file));
        }
        return filesDto;
    }
}
