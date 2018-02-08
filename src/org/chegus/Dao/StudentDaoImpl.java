package org.chegus.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.chegus.Pojo.College;
import org.chegus.Pojo.Student;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public class StudentDaoImpl implements StudentDao {

	
	         @Autowired
	         private SessionFactory sessionfactory;
	
	         
	         
public  StudentDaoImpl(){
	System.out.println("iam in student dao Impl constructor.......");
}


    
    @SuppressWarnings("unchecked")
	    public List<Student> listStudents() {
    	
    	     List<Student> list = sessionfactory.getCurrentSession().createQuery("from Student").list();
    	     for(Student student:list)
		     System.out.println(student.toString());
		     return list;
   	}

	
	    public void addStudents(Student student) {
		
		
		       sessionfactory.getCurrentSession().save(student);
	}

	
        public void updateStudents(Student student) {
		
		
		      sessionfactory.getCurrentSession().update(student);
		      
	}
        
        

	@SuppressWarnings("unchecked")
	@Override
	    public List<Student> searchStudent(Student student) {
		 
		     System.out.println("inside student search dao impl.......");
		
		     Session session=sessionfactory.getCurrentSession();
		     List<Student> list = new ArrayList<Student>();
	     	 Criteria cr = session.createCriteria(Student.class);
		
	     	 cr.add(Restrictions.eq("college.id", student.getCollege().getId()));
		 
		     list = cr.list();
		     //int size = cr.list().size();
		     return list;
	
	  }

	@Override
	    public void deleteStudents(Integer id) {
		
		     System.out.println("inside delete students in dao...");
	         Student student = (Student)sessionfactory.getCurrentSession().load(Student.class, id);
		     if(null != student) {
			 sessionfactory.getCurrentSession().delete(student);
			 sessionfactory.getCurrentSession().flush();
		}
	
	}

	@SuppressWarnings("unchecked")
	@Override
	    public Student getStudentById(Integer studentId) {
		     
		     System.out.println("inside edit students in dao...");
		  
		     Session session = sessionfactory.getCurrentSession();
		     List<Student> list = session.createQuery("from Student s where s.id = :studentId")
			           .setParameter("studentId",studentId).list();
		     return list.size() > 0 ?(Student)list.get(0): null;
		
	}
	
}
