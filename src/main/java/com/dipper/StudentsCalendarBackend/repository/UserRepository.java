package com.dipper.StudentsCalendarBackend.repository;

import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUserName(String name);
}