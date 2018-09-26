package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import com.dipper.StudentsCalendarBackend.repository.ClassesRepository;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassesService {

  private ClassesRepository classesRepository;

  @Autowired
  public ClassesService(
      ClassesRepository classesRepository) {
    this.classesRepository = classesRepository;
  }

  public Calendar copyCalendarObject(Calendar objectToCopy){
    return new GregorianCalendar(
        objectToCopy.get(Calendar.YEAR),
        objectToCopy.get(Calendar.MONTH),
        objectToCopy.get(Calendar.DAY_OF_MONTH),
        objectToCopy.get(Calendar.HOUR_OF_DAY),
        objectToCopy.get(Calendar.MINUTE)
        );
  }

  public boolean createClassesForCourse(CourseEntity newCourse){

    Calendar startDate = new GregorianCalendar(
        Integer.parseInt(newCourse.getStartDate().substring(0,4)),
        Integer.parseInt(newCourse.getStartDate().substring(5,7))-1,
        Integer.parseInt(newCourse.getStartDate().substring(8,10)),
        Integer.parseInt(newCourse.getStartTime().substring(0,2)),
        Integer.parseInt(newCourse.getStartTime().substring(3,5))
    );

    Calendar endDate = new GregorianCalendar(
        Integer.parseInt(newCourse.getEndDate().substring(0,4)),
        Integer.parseInt(newCourse.getEndDate().substring(5,7))-1,
        Integer.parseInt(newCourse.getEndDate().substring(8,10)),
        Integer.parseInt(newCourse.getEndTime().substring(0,2)),
        Integer.parseInt(newCourse.getEndTime().substring(3,5))
    );

    //prepare first day of course
    Calendar currentProcessedDate = this.copyCalendarObject(startDate);
    System.out.println(currentProcessedDate.getTime());
    currentProcessedDate.set(Calendar.DAY_OF_WEEK,newCourse.getCourseDay());
    if(currentProcessedDate.before(startDate)){
      currentProcessedDate.set(Calendar.WEEK_OF_YEAR,currentProcessedDate.get(Calendar.WEEK_OF_YEAR)+1);
    }

    while(currentProcessedDate.before(endDate)){
      Calendar currentProcessedEndDate = copyCalendarObject(currentProcessedDate);
      currentProcessedEndDate.set(Calendar.HOUR_OF_DAY,Integer.parseInt(newCourse.getEndTime().substring(0,2)));
      currentProcessedEndDate.set(Calendar.MINUTE,Integer.parseInt(newCourse.getEndTime().substring(3,5)));
      classesRepository.save(
          new ClassesEntity(
              newCourse.getCourseId(),
              newCourse.getCourseName(),
              newCourse.getCourseType(),
              currentProcessedDate.getTime(),
              currentProcessedEndDate.getTime()));

      //iterate
      currentProcessedDate.set(Calendar.WEEK_OF_YEAR,currentProcessedDate.get(Calendar.WEEK_OF_YEAR)+1);
    }

    /*
    *
      System.out.println(endDate.getTime());
      endDate.set(Calendar.DAY_OF_WEEK,newCourse.getCourseDay());
      System.out.println(endDate.getTime());
      endDate.set(Calendar.WEEK_OF_YEAR,endDate.get(Calendar.WEEK_OF_YEAR)+1);
    System.out.println(endDate.getTime());
    * */
    return true;
  }
}
