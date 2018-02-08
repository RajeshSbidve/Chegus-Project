<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

 <link rel="stylesheet"href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
$(function() {
$(function() {
$('#dob').datepicker({
	
	
	 onSelect: function(value, ui) {
		 
	       /*  var today = new Date(),
	            dob = new Date(value),
	            age = new Date(today - dob).getFullYear() - 1970; */
	        
	        
	        var today = new Date(), 
	        dob = $('#dob').datepicker("getDate"),
	        age = (
	          (today.getMonth() > dob.getMonth())
	          ||
	          (today.getMonth() == dob.getMonth() && today.getDate() >= dob.getDate())
	        ) ? today.getFullYear() - dob.getFullYear() : today.getFullYear() - dob.getFullYear()-1;

	        alert("Age: " + age);
	
	        /* 	$.ajax({url:"student",success:function(){
		$("#age").val(age);
		
		}}); */
		
	    	$("#age").val(age);
		
	    },
	    
	    
	    maxDate: '+0d',
      yearRange: '1900:2018',
   	changeMonth: true,
     changeYear: true,
     
	 
});
});

});

</script>
<style type="text/css">
.maintable
{

alignment-adjust:-20px;
				
		position: relative;		
		line-height: 20px;		
		border-top: 1px solid #999;
		border-right: 1px solid #999;
		border-left: 1px solid #999;
		border-bottom: 1px solid #999;
        margin-top:5px;
		-moz-border-radius: 5px;
		-webkit-border-radius: 5px;
		-ms-border-radius: 5px;
		border-radius: 5px;		
}
.textFLD
{		
		border-top: 2px solid #999;
		border-right: 2px solid #999;
		border-left: 1px solid #999;
		border-bottom: 1px solid #999;
        margin-top:5px;
		
		border-radius: 5px;
		
		
}
.tablestyle{
	border:thick;	
	}

</style>
</head>
<body>


<script type="text/javascript">


   $(document).ready(function(){
     $("#collegeSelect").change(function(){
        $("#collId").val($(this).find(":selected").attr("class"));
   }); 
});

</script>


<form:form action="confirmation" method = "post" modelAttribute = "student">
  <h2 style="text-align:center">Student Enrollment</h2>
  

<table id="main" width="77%" align="right"   background="v2.gif"  class="maintable" cellpadding="0" cellspacing="5">
<tr>
  <td>Registration Number</td>
  <td><form:input type="text"  path="regnum"/></td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>

                  <tr>
                     <c:if test="${!empty student.firstname}">
	                       <form:hidden path="id" />
                     </c:if>
                     
<td width="13%">First Name</td>
<td width="18%"><form:input type="text" path="firstname" required = "true"/></td>
<td width="12%">Middle Name</td>
<td width="19%"><form:input type="text"  path="middlename"/></td>
<td width="19%">Last Name</td>
<td width="19%"><form:input type="text"  path="lastname"/></td>
</tr>
<tr>


  <td>Father's Name</td>
  <td><form:input type="text"  path="fathername" required = "true"/></td>
  <td>Father's Occupation</td>
  <td><form:input type="text"  path="fatherocc"/></td>
  <td>Mother's Maiden Name</td>
  <td><form:input type="text"  path="mothername" required = "true"/></td>
</tr>

<tr>
  <td>DOB</td>
  <td><form:input type="text"  path="dob"  id="dob"/></td>


  <td>Age</td>
  <td><form:input type="text"  path="age" id="age"/>
  </td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>


<tr>
  <td>Gender</td>
  <td><form:radiobutton path="gender" value="Male"/> Female
  <form:radiobutton  path="gender" value="Female"/> Male
  </td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>


<tr>
  <td>Branch</td>
  <td><form:input type="text"  path="branch" required = "true"/></td>
  <td>Year </td>
  <td><form:input type="text"  path="year" value=""/></td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr>
  <td>Email Id</td>
  <td><form:input type="text"  path="email" required = "true" /></td>
  <td>Phone Number</td>
  <td><form:input type="text"  path="phone" required = "true"/></td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr>
  <td>Address</td>
  <td><form:input type="text"  path="address"/></td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>

</tr>
<tr>
  <td>College Name</td>
   <td>
 
  
         <form:select path="collegename" id="collegeSelect">
             
             <option>Select College</option>
 
               <c:forEach items="${colleges}"  var="colleges" >
	
	               <form:option value="${colleges.collegename}" class="${colleges.id}"></form:option> 
	
	            </c:forEach>
 
           </form:select> 
 
 <form:hidden path="college.id" id="collId"/>
 
 </td>
 

           
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
</table>

<div align="center" >
 
  <p><a href="link">Search Based on College</a></p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p> 
  
  
  
  <input type="submit" value="Submit"/>
    <input type="reset" value="reset"/>
  </p>
</div>

</form:form>
</body>
</html>
