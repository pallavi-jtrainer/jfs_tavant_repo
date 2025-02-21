package com.tavant.hibernate.HibernateOneToManyMapping;

import com.tavant.hibernate.HibernateOneToManyMapping.dao.InstructorDao;
import com.tavant.hibernate.HibernateOneToManyMapping.entity.Course;
import com.tavant.hibernate.HibernateOneToManyMapping.entity.Instructor;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Instructor instructor = new Instructor("Ins1", "ins1@ajaj.c");
        
        InstructorDao dao = new InstructorDao();
        dao.saveInstructor(instructor);
        
        Course c1 = new Course("Math", "1 month");
        Course c2 = new Course("Physics", "1 month");
        
        instructor.getCourses().add(c1);
        instructor.getCourses().add(c2);
        
        dao.saveInstructor(instructor);
    }
}
