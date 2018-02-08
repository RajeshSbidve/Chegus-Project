package org.chegus.Dao;

import java.util.List;

import org.chegus.Pojo.College;


public interface CollegeDao {

	public List<College> listColleges();
	
	public College getCollege(Integer id);
}
