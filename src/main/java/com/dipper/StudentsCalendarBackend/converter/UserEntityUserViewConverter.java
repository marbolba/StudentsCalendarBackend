package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.view.UserView;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityUserViewConverter {
    public UserView convert(UserEntity userEntity){
        return new UserView(userEntity.getUserId(),userEntity.getUserName(),userEntity.getEmail(),userEntity.getName(),userEntity.getSurname());
    }
}
