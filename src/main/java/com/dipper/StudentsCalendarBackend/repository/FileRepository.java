package com.dipper.StudentsCalendarBackend.repository;

import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import com.dipper.StudentsCalendarBackend.entity.FileEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FileRepository extends JpaRepository<FileEntity, Integer> {

    List<FileEntity> findByFileOwnerAndParentClassesId(UserEntity fileOwner,ClassesEntity parentClassesId);
    @Query(value = "select * from files f left join classes c on f.parent_classes_id = c.classes_id where c.parent_course_id_course_id = :courseID", nativeQuery = true)
    List<FileEntity> findByParentClassesId(@Param("courseID") int courseID);
}