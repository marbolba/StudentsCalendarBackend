package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.UserDto;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityUserDtoConverter {
    public UserDto convert(UserEntity userEntity){
        return new UserDto(userEntity.getUser_id(),userEntity.getUserName(),userEntity.getEmail(),userEntity.getName(),userEntity.getSurname());
    }
}
