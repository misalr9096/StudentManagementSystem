<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Navbar.jsp"></jsp:include>
<%
List<StudentPOJO> students = (List) request.getAttribute("students");
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
		<h2 class="text-center">Delete Student</h2>

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

			
			
			<form action="./delete" method="post">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Student
						Id </label> <input type="number" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp" name="id">
					<div id="passwordHelpBlock" class="form-text text-center">Enter
						the Student ID of Student to Delete the Student</div>
				</div>

				<div class="container d-flex justify-content-center">
					<button type="submit" class="btn btn-info">Delete Student</button>
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