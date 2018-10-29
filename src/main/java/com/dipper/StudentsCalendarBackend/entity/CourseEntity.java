package com.dipper.StudentsCalendarBackend.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "course_id", updatable = false, nullable = false)
  private int courseId;

  @Column(name = "user_id", updatable = false, nullable = false)
  private int userId;

  private String courseName;
  private String courseType;
  private int courseDay;
  private String startTime;
  private String endTime;
  private String startDate;
  private String endDate;

  //change dates to JPA standardes:
  /*
    @Temporal(TemporalType.DATE)
    @Temporal(TemporalType.TIME)
  * */

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseType() {
    return courseType;
  }

  public void setCourseType(String courseType) {
    this.courseType = courseType;
  }

  public int getCourseDay() {
    return courseDay;
  }

  public void setCourseDay(int courseDay) {
    this.courseDay = courseDay;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "CourseEntity{" +
            "courseId=" + courseId +
            ", userId=" + userId +
            ", courseName='" + courseName + '\'' +
            ", courseType='" + courseType + '\'' +
            ", courseDay=" + courseDay +
            ", startTime='" + startTime + '\'' +
            ", endTime='" + endTime + '\'' +
            ", startDate='" + startDate + '\'' +
            ", endDate='" + endDate + '\'' +
            '}';
  }
}
