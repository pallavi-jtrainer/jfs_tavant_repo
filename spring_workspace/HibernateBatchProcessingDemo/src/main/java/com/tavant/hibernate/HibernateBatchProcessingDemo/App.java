package com.tavant.hibernate.HibernateBatchProcessingDemo;

import java.util.ArrayList;
import java.util.List;

import com.tavant.hibernate.HibernateBatchProcessingDemo.dao.StudentDao;
import com.tavant.hibernate.HibernateBatchProcessingDemo.entity.Student;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
        
        List<Student> students = new ArrayList<Student>();
        
        students.add(new Student("Prithvi", "Raj", "pri@jajaj.c"));
        students.add(new Student("Pranav", "Upadhayay", "pran@jajaj.c"));
        students.add(new Student("Prakruthi", "Upadhayay", "prk@jajaj.c"));
        students.add(new Student("Pranathi", "G", "prat@jajaj.c"));
        students.add(new Student("Praveen", "Kumar", "prav@jajaj.c"));
        
        dao.batchInsertStudents(students);
        
        List<Student> students1 = dao.listAllStudents();
        
        for(Student s: students1) {
        	System.out.println(s.toString());
        }
        
        
        
    }
}
