<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<style type="text/css">
.maintable
{

       
		background: #EFEFEF;		
		position: relative;		
		line-height: 20px;		
		border-top: 2px solid #999;
		border-right: 2px solid #999;
		border-left: 2px solid #999;
		border-bottom: 2px solid #999;
        margin:15;
		-moz-border-radius: 5px;
		-webkit-border-radius: 5px;
		-ms-border-radius: 5px;
		border-radius: 5px;
		
		
}

.subText
{
	
	
	font-size:12px;
	color:#FFFFFF;
	font-weight:bold;
	font-family:Arial, Helvetica, sans-serif;	
	background-color:#d77d7d;
	height:25px;
	padding-left:5px;
	-moz-border-radius:4px;
    -webkit-border-radius:4px;
	border-radius:4px;
	

}	
</style>


<script language="javascript">

    function deleteStudents(id) {
    	
        if (confirm("Are you sure want to delete thr row?")){
        	var url = 'delete/'+id;
        	 window.location.href = url; 
        }
     
    } 
</script>
</head>
<body>



<%-- <c:url var="action" value="/searching.html" ></c:url> --%>


<form:form action ="searching" method = "post" modelAttribute="student">

<div align="center" style="font-weight:bold;font-size:20px">Search Page</div>
<div >


<p>Search Based On College  
           
            <form:select path="college.id"  >
            
                 <option>Select College</option>
 			
                    <c:forEach items="${listColleges}"  var="list" >
	 
	                    <form:option value="${list.id}">${list.collegeid} </form:option>
		
	                </c:forEach>
 
            </form:select>
 
 <form:hidden path="college.id" id="collId"/>
 
  </p></div>

<!--  <select>
    <option>RGIT</option>
    <option>ATRIA</option>
    <option>CMR</option>
    <option>BIT</option>
    <option>REVA</option>
    <option>IMPACT</option>
    <option>HKBK</option>
  </select>  -->
  
  
  
<p>Total Number of Students : 
          
          <input type="text" value="${std}" id="count"/></p>


            <div id="divbtns">
            
                <input name="Search" type="submit" id="Search" title="Search"  value="Search"/> 
                      
            </div>
          



<table width="100%">
<tr>
<td>



<table  width="100%" class="maintable" cellpadding="2px" cellspacing="2px" >

<tr>
<td class="subText">Student Name</td>

<td class="subText"> Register Number</td>
   
<td class="subText"> Father's Name</td>

<td class="subText"> DOB</td>

<td class="subText"> Email Id</td>

<td class="subText"> Branch</td>

<td class="subText">Action</td>
</tr>

       
 <c:if test="${!empty StudentSearchlist }">
 
                <c:forEach items="${StudentSearchlist}"  var="student">
                
                      <tbody id="studentslist">
                      
                          <tr>

                          <td><a href=" <c:url value='editStudents/${student.id}'/>"> ${student.firstname}</a></td>
                          
                          
                            <td>${student.regnum}</td>
                            <td>${student.fathername}</td>
                            <td>${student.dob}</td>
                            <td>${student.email}</td>
                            <td>${student.branch} </td>

                               <td><img src="<c:url value='/images/delete.jpg'  />"width="20" title="Delete Student" 
                                      onclick="javascript:deleteStudents(${student.id}) "/> 
                                      
                                      
                                   <a href="<c:url value='/edit/${student.id}' />"  >
                                         <img src="<c:url value='/images/edit.jpg' />"
                                                     width="20" height="20" title="Edit Student"/></a></td>
                        
                      <%--
                               <td>  <a href ="<c:url value='edit/${student.id}'/>">
                                       <img src="<c:url value='/images/edit.jpg' />" width="20" height="20"/></a></td> --%>
              
                 
                
                
                         </tr>
                      </tbody>
                   </c:forEach>
                </c:if>


</table></td></tr>



         <!--  <tr>
           
            <td><input type="button" id="btnGetCount" value="TotalStudents" onclick = "CountRows()" /> 
            
         
                   <script type="text/javascript">
                  
                           $(function () {
                	           $("#btnGetCount").click(function () {
                		           /* var totalRowCount = $("#studentslist tr").length; */
                		                 var rowCount = $("#studentslist td").closest("tr").length;
                                            var count =  rowCount;
                                               alert(count);
                                                   $("#count").val(count);
                	                        });
                                      });        
                  </script>
          
           </tr> -->


            <tr>
            
              <td colspan="5" align="right"><a href = "student"><input type="button" value="Cancel"/></a></td>
          
      
            </tr>
            
            
</table>
</form:form>
</body>
</html>
