package com.dipper.StudentsCalendarBackend.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Classes")
public class ClassesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "classes_id", updatable = false, nullable = false)
  int classes_id;

  @Column(name = "course_id", updatable = false)
  int parentCourse_id;
  String classesName;
  String classesType;
  Date classesFullStartDate;
  Date classesFullEndDate;

  public ClassesEntity(int classesParentCourse_id, String classesName, String classesType,
      Date classesFullStartDate, Date classesFullEndDate) {
    this.parentCourse_id = classesParentCourse_id;
    this.classesName = classesName;
    this.classesType = classesType;
    this.classesFullStartDate = classesFullStartDate;
    this.classesFullEndDate = classesFullEndDate;
  }

  public int getClasses_id() {
    return classes_id;
  }

  public void setClasses_Id(int classes_id) {
    this.classes_id = classes_id;
  }

  public int getParentCourse_id() {
    return parentCourse_id;
  }

  public void setParentCourse_id(int classesParentCourse_id) {
    this.parentCourse_id = classesParentCourse_id;
  }

  public String getClassesName() {
    return classesName;
  }

  public void setClassesName(String classesName) {
    this.classesName = classesName;
  }

  public String getClassesType() {
    return classesType;
  }

  public void setClassesType(String classesType) {
    this.classesType = classesType;
  }

  public Date getClassesFullStartDate() {
    return classesFullStartDate;
  }

  public void setClassesFullStartDate(Date classesFullStartDate) {
    this.classesFullStartDate = classesFullStartDate;
  }

  public Date getClassesFullEndDate() {
    return classesFullEndDate;
  }

  public void setClassesFullEndDate(Date classesFullEndDate) {
    this.classesFullEndDate = classesFullEndDate;
  }
}
