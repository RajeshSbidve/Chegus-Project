package org.chegus.Service;



import java.util.List;

import org.chegus.Dao.StudentDao;
import org.chegus.Pojo.College;
import org.chegus.Pojo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentServiceImpl implements StudentService {

	
	
	     @Autowired
	        private StudentDao studentdao;
	     

public StudentServiceImpl(){
	System.out.println("inside student service impl constructor......");
}


	
	   @Transactional
	       public List<Student> listStudents() {
		
		        System.out.println("inside list -->student service");
		        return studentdao.listStudents();
	}

	  @Transactional
	       public void addStudents(Student student) {
		
		        studentdao.addStudents(student);
		
	}

	@Transactional
	     public void updateStudents(Student student) {
		 
		       studentdao.updateStudents(student);
		
	}



	@Override
	@Transactional
	     public List<Student> searchStudent(Student studentsearch) {
		
		        return studentdao.searchStudent(studentsearch);
	}


    @Transactional
	     public void deleteStudents(Integer id) {
		
               studentdao.deleteStudents(id);
		
	}



    @Transactional
	    public Student getStudentById(Integer studentId) {
		
		      return studentdao.getStudentById(studentId);
	}




	



	





	

}
