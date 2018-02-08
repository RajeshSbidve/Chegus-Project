package org.chegus.Controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;





import org.chegus.Pojo.College;
import org.chegus.Pojo.Student;
import org.chegus.Service.CollegeService;
import org.chegus.Service.StudentService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	
	@Autowired
	private StudentService studentservice;
	@Autowired
	private CollegeService collegeservice;
	

	public MainController(){
		System.out.println("inside main controller constructor....");
	}
	
	
 /* .... Home Page(Student.jsp) ....*/
	
	@RequestMapping({"/","/student"})
	public String listStudents(Model model){
	
		List<College> colleges=collegeservice.listColleges();
    	model.addAttribute("colleges",colleges );

    	 System.out.println("Welcome to home");
		
    	 model.addAttribute("student", new Student());
    	
    	
		 
		return "Student";
	}
	
	
	
 /*	.... for going from student to confirm page ....*/
	
	
	
    //@RequestMapping(value="/confimation",method=RequestMethod.POST)
    @RequestMapping({"/edit/confirmation", "/confirmation"})
	public ModelAndView addStudent(@ModelAttribute("student") Student student,BindingResult result, Model model)
	{ 
    	ModelAndView modelAndView = new ModelAndView(); 
    	//System.out.println(student.getCollege().getCollegeid());
    	
    	
    	//System.out.println("inside confirm "+student.getCollege().getCollegename());
    	System.out.println(student);
		modelAndView.addObject("confirm", student);
		modelAndView.setViewName("Confirmation");
    
		return modelAndView;
	}
    
    
 /*	.... for going from Confirm page to Search....*/
    
    
    //@RequestMapping(value="/add" ,method=RequestMethod.POST)
	@RequestMapping({"edit/add", "/add"})
    public ModelAndView addStudents(@ModelAttribute("student") @Validated Student student, BindingResult result)
	{
		College c = student.getCollege();
		c = collegeservice.getCollege(c.getId());
		student.setCollegeid((c.getCollegeid()));
		student.setCollegename(c.getCollegename());
		student.setCollege(c);
		
		
		ModelAndView modelAndView = new ModelAndView("SearchBasedColl");
	   	List<College> list =collegeservice.listColleges();
	   	modelAndView.addObject("student", student);
	   	modelAndView.addObject("listColleges", list);
		if(result.hasErrors()){
			return modelAndView;
		}
		else{
			if(null == student.getId()){
				studentservice.addStudents(student);
		     }
			else{
				studentservice.updateStudents(student);
			}
		}
		
		
	   
		return modelAndView;
 
}
	
	
	
	/*	.... for performing search operation ....*/
	
	

    @RequestMapping(value={"/searching", "/edit/searching"})
    public ModelAndView  searchStudents(Map<String, Object> map,
    		                              @ModelAttribute("student")Student student ,
    		                                       BindingResult result) {
													
    	System.out.println("inside search students...........................");
    	ModelAndView modelAndView = new ModelAndView("SearchBasedColl");

   	 List<College> list =collegeservice.listColleges();
   	modelAndView.addObject("student", student);
   	modelAndView.addObject("listColleges", list);
   	
  
   	
   	List<Student> list1=studentservice.searchStudent(student);
   	map.put("StudentSearchlist", list1);
   	map.put("student", new Student());
   	
   	int size = list1.size();
   	map.put("std",size);
   	
   	System.out.println("CollegeID..."+student.getCollege().getId());
   	System.out.println("Total no of students........."+size);
   	
    	return modelAndView;

   
    }
    
    
    
    /*	.... for search page link in student ....*/
    
    
    
@RequestMapping(value="/link")
    public ModelAndView displaySearch(@ModelAttribute("student")Student student,Model model){
	
	ModelAndView modelAndView = new ModelAndView("SearchBasedColl");
	
	
	 List<College> list =collegeservice.listColleges();
	 modelAndView.addObject("student", student);
	 modelAndView.addObject("listColleges", list);
	
	model.addAttribute("student", new Student());
	
		return modelAndView;
    	
    }



/*	.... for deleting and after editing ....*/



//@RequestMapping(value="/delete/{id}")
@RequestMapping(value={"edit/delete/{id}","/delete/{id}"})
public String deleteStudents(@PathVariable("id") Integer id)
{
	System.out.println("studentId = "+id);
	
	studentservice.deleteStudents(id);
	return "redirect:/link";
}



/*	.... for editing in search  page ....*/



@RequestMapping("/edit/{studentId}")
public String editStudents(@PathVariable("studentId") Integer studentId,Map<String, Object> map){
	
	map.put("student",studentservice.getStudentById(studentId));
	map.put("StudentSearchlist",studentservice.listStudents());
	return "Student";
	
}
}      
     
