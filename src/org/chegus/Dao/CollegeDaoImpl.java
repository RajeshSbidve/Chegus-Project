package org.chegus.Dao;


import java.util.List;

import org.chegus.Pojo.College;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollegeDaoImpl implements CollegeDao {

	
	     @Autowired
	        private SessionFactory sessionfactory;
	
	
public CollegeDaoImpl(){
	System.out.println("inside college dao impl constructor.....");
}


	
	@SuppressWarnings("unchecked")
	      public List<College> listColleges() {
		
		       List<College> colleges = sessionfactory.getCurrentSession().createQuery("from College").list();
			   //for(College college:list)
		      //	System.out.println(college.toString());
			
			   return colleges;
		
	}

	
	@Override
	      public College getCollege(Integer id) {
	
		        College college = (College)sessionfactory.getCurrentSession().get(College.class, id);
		        return college;
	}

}
