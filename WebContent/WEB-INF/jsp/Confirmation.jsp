<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<style type="text/css">
.maintable
{
alignment-adjust:-20px;
       
		background: #F5F4F3;		
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


	
</style>
</head>

<body>
<h1> Welcome to Confiramtion page</h1>
<h2 style="text-align:center">Confirm Details</h2>

  
<form:form action="add"  modelAttribute="confirm">

<table class="maintable" align="center">
<tr>
<td>Registration Number:</td>
<td>${confirm.regnum}</td>
<td width="100px"> </td>
</tr>
<tr>
<td>Name:</td>
<td>${confirm.firstname }</td>
<td width="100px"> </td>
</tr>
<tr>
<td>Branch:</td>
<td>${confirm.branch }</td>
<td></td>
</tr>
<tr>
<td>College Name:</td>
<td>${confirm.collegename}</td><td></td>
</tr>
<tr>
<td> Father's Name:</td>
<td>${confirm.fathername }</td><td></td>
</tr>
<tr>
<td>Mother's Maiden Name:</td>
<td>${confirm.mothername }</td>
<td></td>
<form:hidden    path="id"/>
<form:hidden    path="regnum" />
<form:hidden    path="firstname" />
<form:hidden    path="middlename"/>
<form:hidden    path="lastname"/>
<form:hidden    path="fathername"/>
<form:hidden    path="fatherocc"/>
<form:hidden    path="mothername"/>
<form:hidden    path="dob"/>
<form:hidden    path="age"/>
<form:hidden    path="gender" />
<form:hidden    path="branch"/>
<form:hidden    path="year"/>
<form:hidden    path="email" />
<form:hidden    path="phone"/>
<form:hidden    path="address"/>
<form:hidden    path="college.collegename"/>
<form:hidden    path="college.id"/>
</tr>
<tr><td>
Phone Number:</td>
<td>${confirm.phone }</td>
<td></td>
</tr>
<tr><td>
Email : 
</td>
<td>${confirm.email }</td><td></td>
</tr>
</table>

<p>&nbsp;</p>
<div align="center">
<input type="submit" value="Confirm"/>

<a href="student"><input type="button" value="Cancel"/></a>
</div> 

</form:form>
</body>
</html>
