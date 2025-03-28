package com.tavant.hibernate.HibernateOneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import com.tavant.hibernate.HibernateOneToManyMapping.dao.InstructorDao;
import com.tavant.hibernate.HibernateOneToManyMapping.entity.Course;
import com.tavant.hibernate.HibernateOneToManyMapping.entity.Instructor;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Instructor instructor = new Instructor("Ins2", "ins2@newo.c");
        
        InstructorDao dao = new InstructorDao();
        //dao.saveInstructor(instructor);
        
        Course c1 = new Course("Spring Boot", "6 weeks");
  //      Course c2 = new Course("Typescript", "1 week");
        c1.setInstructor(instructor);
      //  c2.setInstructor(instructor);
        
        List<Course> courses = new ArrayList<Course>();
        courses.add(c1);
   //     courses.add(c2);
        
        instructor.setCourses(courses);
        
        dao.saveInstructor(instructor);
    }
}
