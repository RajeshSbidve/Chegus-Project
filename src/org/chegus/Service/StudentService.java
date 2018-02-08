package org.chegus.Service;

import java.util.List;

import org.chegus.Pojo.College;
import org.chegus.Pojo.Student;



public interface StudentService {
	
	public List<Student> listStudents();
	
	public void addStudents(Student student);
	
	public void updateStudents(Student student);
	
	public void deleteStudents(Integer id);
	
	public  List<Student> searchStudent(Student studentsearch);
	
	public Student getStudentById(Integer studentId);

	


}
