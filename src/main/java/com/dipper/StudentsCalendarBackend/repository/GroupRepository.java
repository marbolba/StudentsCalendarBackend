package com.dipper.StudentsCalendarBackend.repository;

import com.dipper.StudentsCalendarBackend.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {
    GroupEntity findByGroupName(String groupName);
}
