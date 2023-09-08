<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
  <jsp:include page="Navbar.jsp"></jsp:include>
  <%
  	String message=(String)request.getAttribute("message");
    List<StudentPOJO> students = (List) request.getAttribute("students");
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid mt-3">
  <h2 class="text-center">Add Student</h2>
  <div class="container d-flex justify-content-center mt-5 card p-5 shadow" style="width: 600px" >
  <form action="./add" method="post">
   <%
  
  	if(message != null){
  		
  		%>	
 
	  <div class="alert alert-info" role="alert">
	     <%= message %>
	  </div>


  <% 		
  	}
  %>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name">
  </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
  </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Contact No</label>
    <input type="tel" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="contact">
  </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">address</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="address">
  </div> 
  <div class="container d-flex justify-content-center">
  		<button type="submit" class="btn btn-info">Add Student</button>
  </div>
</form>
<%
			if (students != null) {
			%>
			<table class="table table-striped-columns" style="width: 300px">
				<thead>
					<tr>
						<th scope="col">Student Id</th>
						<th scope="col">Student Name</th>
						<th scope="col">Student Email</th>
						<th scope="col">Student Contact</th>
						<th scope="col">Student Address</th>
					</tr>
				</thead>
				<tbody>

					<%
					for (StudentPOJO pojo : students) {
					%>
					<tr>
						<td><%=pojo.getId()%></td>
						<td><%=pojo.getName()%></td>
						<td><%=pojo.getEmail()%></td>
						<td><%=pojo.getContact()%></td>
						<td><%=pojo.getAddress()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<%
			}
			%>

  
  </div>
 
  
</div>
</body>
</html>

