package com.dipper.StudentsCalendarBackend.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Classes")
public class ClassesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "classes_id", updatable = false, nullable = false)
  private int classesId;

  @ManyToOne(fetch = FetchType.LAZY)
  private CourseEntity parentCourseId;

  @Column(name = "classes_name")
  private String classesName;

  @Column(name = "classes_type")
  private String classesType;

  @Temporal(TemporalType.TIMESTAMP)
  private Date classesFullStartDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date classesFullEndDate;

  @OneToMany(mappedBy = "parentClassesId")
  private List<FileEntity> files;

  public ClassesEntity() {
  }

  public ClassesEntity(int classesId) {
    this.classesId = classesId;
  }

  public ClassesEntity(CourseEntity classesParentCourseId, String classesName, String classesType,
                       Date classesFullStartDate, Date classesFullEndDate) {
    this.parentCourseId = classesParentCourseId;
    this.classesName = classesName;
    this.classesType = classesType;
    this.classesFullStartDate = classesFullStartDate;
    this.classesFullEndDate = classesFullEndDate;
  }

  public int getClassesId() {
    return classesId;
  }

  public void setClassesId(int classesId) {
    this.classesId = classesId;
  }

  public CourseEntity getParentCourseId() {
    return parentCourseId;
  }

  public void setParentCourseId(CourseEntity parentCourseId) {
    this.parentCourseId = parentCourseId;
  }

  public List<FileEntity> getFiles() {
    return files;
  }

  public void setFiles(List<FileEntity> files) {
    this.files = files;
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

  @Override
  public String toString() {
    return "ClassesEntity{" +
            "classesId=" + classesId +
            ", parentCourseId=" + parentCourseId +
            ", classesName='" + classesName + '\'' +
            ", classesType='" + classesType + '\'' +
            ", classesFullStartDate=" + classesFullStartDate +
            ", classesFullEndDate=" + classesFullEndDate +
            '}';
  }
}
