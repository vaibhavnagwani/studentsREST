package org.project.Student.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.project.Student.entity.Student;

public class StudentDAO {
	
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	


	public List<Student> getStudents() {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Student> list=session.createQuery("from Student").getResultList();
		return list;
	}

	public Student getStudentById(int id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		return session.get(Student.class, id);
	}
	
	public void addStudent(Student student) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	public void updateStudent(Student updatedStudent) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Student brand=session.get(Student.class, updatedStudent.getStudentNo());
		brand.setStudentName(updatedStudent.getStudentName());
		session.getTransaction().commit();
	}
	
	public void deleteStudent(int id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Student student=session.get(Student.class, id);
		session.delete(student);		
		session.getTransaction().commit();
	}	
}
