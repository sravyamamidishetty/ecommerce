package com.xyz.studentdao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xyz.model.Student;

	
@Repository
public class StudentDAOImp implements StudentDAOInt {

		@Autowired
		private SessionFactory sessionFactory;
		
		
		public boolean addStudent(Student s) {
			boolean result=false;
			try {
				Session ses = sessionFactory.openSession();
				ses.beginTransaction();
				ses.save(s); // save() method executes insert query in sql
				ses.getTransaction().commit();
				ses.close();
				result=true;
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}		
			return result;		
		}


		public List<Student> getAllStudent() {
			List<Student> data = null;
			Session ses = sessionFactory.openSession();
			Query qr = ses.createQuery("from Student");
			data = qr.list(); /// executes select * from Student query
			ses.close();		
			return data;
		}


		public Student validateStudent(Student s) {
			s.setResult("PASS");
			for(int i:s.getMarks()) {
				if(i<35) {
					s.setResult("FAIL");
					break;
				}
			}
			if(s.getResult().equals("PASS")) {
				int sum=0;
				for(int m:s.getMarks()) {
					sum+=m;
				}
				s.setTotal(sum);
				s.setAverage((float)s.getTotal()/5);
				if(s.getAverage()>=90)
					s.setGrade("A+");
				else if(s.getAverage()>=80)
					s.setGrade("A");
				else if(s.getAverage()>=70)
					s.setGrade("B+");
				else if(s.getAverage()>=60)
					s.setGrade("B");
				else 
					s.setGrade("C");
			}
			else {
				s.setTotal(0);
				s.setAverage(0);
				s.setGrade("NA");
			}
			System.out.println(s.getResult());
			return s;
		}
		
		
		
		

	}



