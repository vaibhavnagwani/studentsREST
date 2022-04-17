package org.project.Student.Resource;

import java.util.List;

import org.project.Student.Services.StudentServices;
import org.project.Student.entity.Student;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class StudentResource {
	StudentServices service = new StudentServices();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String home() {
		return "Welcome to the student's db home page";
	}
	
	@GET
	@Path("/stud")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() {
		return service.getStudents();
	}
	
	@GET
	@Path("/stud/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentById(@PathParam("id") int id) {
		return service.getStudentById(id);
	}
	
	@POST
	@Path("/stud")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addStudent(Student student) {
		service.addStudent(student);
	}
	
	@PUT
	@Path("/stud/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateStudent(@PathParam("id")int id, Student updatedStudent) {
		updatedStudent.setStudentNo(id);
		service.updateStudent(updatedStudent);
	}
	
	@DELETE
	@Path("/stud/{id}")
	public void deleteStudent(@PathParam("id") int id) {
		service.deleteStudent(id);
	}
}
