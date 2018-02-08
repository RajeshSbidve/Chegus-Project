package org.chegus.Dao;

import java.util.List;

import org.chegus.Pojo.College;
import org.chegus.Pojo.Student;



public interface StudentDao {
	
	
	public List<Student> listStudents();
	
	public void addStudents(Student student);
	
	public void updateStudents(Student student);

	public  List<Student> searchStudent(Student student);
	
	public void deleteStudents(Integer id);
	
	public Student getStudentById(Integer studentId);

}
