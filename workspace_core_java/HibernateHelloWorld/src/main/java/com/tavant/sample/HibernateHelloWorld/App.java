package com.tavant.sample.HibernateHelloWorld;

import java.util.List;

import org.hibernate.Session;

import com.tavant.sample.HibernateHelloWorld.entity.Employee;
import com.tavant.sample.HibernateHelloWorld.utils.HibernateUtils;

/**
 * Hello world!
 */
public class App {
 //   @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        
//        Employee emp = new Employee();
//     //   emp.setId(2);
//        emp.setFirstName("Prakruthi");
//        emp.setLastName("Upadhyay");
//        emp.setEmail("prk@ajjaj.c");
//        
//        session.save(emp);
//        session.persist(emp);
//        Employee e = session.get(Employee.class,1);
//       System.out.println(e.toString());
        
        //select * from employee
//         List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
//         employees.forEach(e -> System.out.println(e.toString()));
       
        //select * from employee where id = ?
//        Employee e = session.createQuery("from Employee e where e.id = " + 2, Employee.class).getSingleResult();
//        System.out.println(e.toString());
//        
//        e.setEmail("prk1@ahaha.c");
//        
//        session.saveOrUpdate(e);
        
        int res = session.createQuery("update Employee e set e.email = :email where e.id = :id")
        	.setParameter("email", "pranav@ajjaja.c")
        	.setParameter("id", 2).executeUpdate();
        
        if (res > 0)
        	System.out.println("Employee updated");
        
        session.getTransaction().commit();
        HibernateUtils.shutdown();
        
    }
}
