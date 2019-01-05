package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.converter.FileEntityToFileViewConverter;
import com.dipper.StudentsCalendarBackend.converter.GroupEntityToGroupViewConverter;
import com.dipper.StudentsCalendarBackend.view.FileView;
import com.dipper.StudentsCalendarBackend.view.GroupView;
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
    private GroupEntityToGroupViewConverter groupEntityToGroupViewConverter;
    private FileService fileService;
    private FileEntityToFileViewConverter fileEntityToFileViewConverter;

    @Autowired
    public GroupService(GroupRepository groupRepository,
                        UserRepository userRepository,
                        GroupEntityToGroupViewConverter groupEntityToGroupViewConverter,
                        FileService fileService,
                        FileEntityToFileViewConverter fileEntityToFileViewConverter) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.groupEntityToGroupViewConverter = groupEntityToGroupViewConverter;
        this.fileService = fileService;
        this.fileEntityToFileViewConverter = fileEntityToFileViewConverter;
    }

    private GroupEntity getGroupById(int groupId){
        //TODO if not found ...
        return groupRepository.findById(groupId).get();
    }

    public GroupEntity addGroup(GroupEntity groupEntity){
        //TODO check if group is still avaliable
        return groupRepository.save(groupEntity);
    }

    public boolean addUserToGroup(int groupId, int userId){
        GroupEntity searchedGroup = groupRepository.findById(groupId).get();
        boolean operationSuccessful = false;
        if(searchedGroup!=null){
            boolean found = false;
            for(UserEntity userEntity: searchedGroup.getUsers()){
                if(userEntity.getUserId()==userId){
                    found = true;
                    break;
                }
            }
            if(!found){
                searchedGroup.setUsers(userRepository.findById(userId).get());
                groupRepository.save(searchedGroup);
                operationSuccessful = true;
            }else {
                System.out.println("user already in group!!!");
            }
        }
        return operationSuccessful;
    }

    public List<GroupView> getUsersGroups(int userId){
        List<GroupView> foundGroups = new ArrayList<>();
        for(GroupEntity group : groupRepository.findAll()){
            for(UserEntity user: group.getUsers()){
                if(user.checkById(userId)){
                    foundGroups.add(groupEntityToGroupViewConverter.convert(group));
                    break;
                }
            }
        }
        return foundGroups;
    }

    public void addFileToGroup(int groupId,int fileId){
        //TODO CHECK IF ANYTHING FOUND
        FileEntity fileToAdd = fileService.getFileById(fileId);
        GroupEntity groupEntity = getGroupById(groupId);
        groupEntity.addFile(fileToAdd);
        groupRepository.save(groupEntity);
    }

    public void deleteFile(int groupId, int fileId){
        GroupEntity groupEntity = getGroupById(groupId);
        List<FileEntity> fileEntityList = groupEntity.getFiles();
        fileEntityList.removeIf(file -> file.getFileId() == fileId);
        groupEntity.setFiles(fileEntityList);
        groupRepository.save(groupEntity);
    }

    public List<FileView> getGroupFileDtoList(int groupId){
        return fileEntityToFileViewConverter.convertList(getGroupFilesList(groupId));
    }

    private List<FileEntity> getGroupFilesList(int groupId){
        GroupEntity groupEntity = getGroupById(groupId);
        return groupEntity.getFiles();
    }

    public List<FileView> getUsersGroupFilesList(int groupId, int userId){
        List<FileEntity> groupsFiles = getGroupFilesList(groupId);
        List<FileEntity> returnList = new ArrayList<>();
        for(FileEntity f : groupsFiles){
            if(f.getFileOwner().getUserId() == userId){
                returnList.add(f);
            }
        }
        return fileEntityToFileViewConverter.convertList(returnList);
    }
    public List<GroupView> getGroupsStartsWithList(String startsWith){
        List<GroupEntity> found = new ArrayList<>();
        for(GroupEntity group : groupRepository.findAll()){
            if(group.getGroupName().toLowerCase().startsWith(startsWith.toLowerCase())) {
                found.add(group);
            }
        }
        return groupEntityToGroupViewConverter.convertList(found);
    }
}
