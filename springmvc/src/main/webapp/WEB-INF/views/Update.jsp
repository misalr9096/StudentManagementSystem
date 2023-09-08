<%@page import="java.util.List"%>
<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Navbar.jsp"></jsp:include>

<%
List<StudentPOJO> students = (List) request.getAttribute("students");
StudentPOJO pojo = (StudentPOJO) request.getAttribute("result");
String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container-fluid mt-3">
		<h2 class="text-center">Update Student</h2>

		<%
		if (pojo == null) {
		%>

		<div
			class="container d-flex justify-content-center mt-5 card p-5 shadow"
			style="width: 600px">
			<%
			if (message != null) {
			%>

			<div class="alert alert-info" role="alert">
				<%=message%>
			</div>


			<%
			}
			%>
			<form action="./update" method="post">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Student
						Id </label> <input type="number" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp" name="id">
					<div id="passwordHelpBlock" class="form-text text-center">Enter
						the Student ID of Student to update the Student</div>
				</div>

				<div class="container d-flex justify-content-center">
					<button type="submit" class="btn btn-info">Update Student</button>
				</div>

			</form>

			<%
			if (students != null) {
			%>
			<table class="table table-striped-columns" style="width: 500px">
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
					for (StudentPOJO studentPOJO : students) {
					%>
					<tr>
						<td><%=studentPOJO.getId()%></td>
						<td><%=studentPOJO.getName()%></td>
						<td><%=studentPOJO.getEmail()%></td>
						<td><%=studentPOJO.getContact()%></td>
						<td><%=studentPOJO.getAddress()%></td>
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
		<%
		} else {
		%>
				
			<div
			class="container d-flex justify-content-center mt-5 card p-5 shadow"
			style="width: 600px">
			<form action="./updateStudent" method="post">
				
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label" hidden="true">Id</label> <input
						type="number" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="id" hidden="true" value="<%= pojo.getId()%>">
				</div>
				
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Name</label> <input
						type="text" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="name" value="<%= pojo.getName()%>">
				</div>
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Email</label> 
					<input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="email" value=" <%= pojo.getEmail() %>">
				</div>
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Contact
						No</label> <input type="tel" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="contact" value=" <%= pojo.getContact()%>">
				</div>
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">address</label>
					<input type="text" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="address" value=" <%= pojo.getAddress()%> ">
				</div>
				<div class="container d-flex justify-content-center">
					<button type="submit" class="btn btn-info">Update</button>
				</div>
			</form>
			</div>
		
			
		
		
			<%
			}
			%>
		</div>
</body>
</html>
