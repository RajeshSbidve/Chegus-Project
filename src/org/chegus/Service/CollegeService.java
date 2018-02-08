package org.chegus.Service;

import java.util.List;

import org.chegus.Pojo.College;


public interface CollegeService {
	
public List<College> listColleges();

public College getCollege(Integer id);

}
