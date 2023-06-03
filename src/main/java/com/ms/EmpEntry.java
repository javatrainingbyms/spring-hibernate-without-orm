package com.ms;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpEntry {
	
	@Autowired
	private Utility utility;
	
	public void saveData(Emp emp) {
		//here we need to write the code for saving
		//ApplicationContext context=new ClassPathXmlApplicationContext("info.xml");
		//SessionFactory sessionFactory=context.getBean("sessionFactory", SessionFactory.class);
		
		Session session=utility.getSessionFactory().openSession();
		Transaction tr=session.beginTransaction();
		session.save(emp);
		tr.commit();
		session.close();
	}
	
	
	public static void main(String[] args) {
		Emp e1=new Emp(113,"cdef","sales","manager",80000);
		EmpEntry empEntry=new EmpEntry();
		empEntry.saveData(e1);
		System.out.println("Data Stored....");
	}

}
