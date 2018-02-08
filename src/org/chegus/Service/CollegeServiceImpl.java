package org.chegus.Service;

import java.util.List;

import org.chegus.Dao.CollegeDao;
import org.chegus.Pojo.College;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CollegeServiceImpl implements  CollegeService{

	
	
	   @Autowired
	      private CollegeDao collegedao;
	

private	CollegeServiceImpl(){
	System.out.println("inside college service impl constructor....");
}
	
	
	 @Transactional
	    public List<College> listColleges() {
		
		     System.out.println("inside list-->college service");
		     return collegedao.listColleges();
	}


	@Transactional
       	public College getCollege(Integer id) {
		
		      return collegedao.getCollege(id);
	}

}
