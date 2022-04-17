package org.project.Student.Services;

import java.util.List;

import org.project.Student.DAO.StudentDAO;
import org.project.Student.entity.Student;

public class StudentServices {

	StudentDAO dao=new StudentDAO();
	
	public List<Student> getStudents() {
		List<Student> students=dao.getStudents();
		return students;
	}

	public void addStudent(Student student) {
		dao.addStudent(student);
	}

	public void updateStudent(Student updatedStudent) {
		dao.updateStudent(updatedStudent);
	}

	public void deleteStudent(int id) {
		dao.deleteStudent(id);
	}

	public Student getStudentById(int id) {
		return dao.getStudentById(id);
	}
	
}
