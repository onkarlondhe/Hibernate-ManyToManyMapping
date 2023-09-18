package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Employee emp1 = new Employee();
		emp1.setEmpId(1);
		emp1.setEmpName("Onkar Londhe");
		emp1.setEmpSal(50000);
		
		Employee emp2 = new Employee();
		emp2.setEmpId(2);
		emp2.setEmpName("Hritesh Jadhav");
		emp2.setEmpSal(60000);
		
		
		Project pro1 = new Project();
		pro1.setProjectId(101);
		pro1.setProjectName("Develop the Desktop Application");
		
		Project pro2 = new Project();
		pro2.setProjectId(102);
		pro2.setProjectName("Develop the Web Application");
		
		
		List<Employee> emp = new ArrayList<>();
		emp.add(emp1);
		emp.add(emp2);
		
		List<Project> pro = new ArrayList<>();
		pro.add(pro1);
		pro.add(pro2);
		
		emp1.setProjects(pro);
		emp2.setProjects(pro);
		
		pro1.setEmployees(emp);
		pro2.setEmployees(emp);
		
		
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(pro1);
		session.save(pro2);
		
		tr.commit();
		session.close();
		
		
	}

}
