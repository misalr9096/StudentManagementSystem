<%@page import="java.util.List"%>
<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Navbar.jsp"></jsp:include>
<%
StudentPOJO pojo = (StudentPOJO) request.getAttribute("result");
String message = (String) request.getAttribute("message");
List<StudentPOJO> students = (List) request.getAttribute("students");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container-fluid mt-3">
		<h2 class="text-center">Search Student</h2>



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
			<form action="./search" method="post">
				
				<label for="exampleInputEmail1" class="form-label">Search Student by
						</label>
				<select class="form-select" aria-label="Default select example" name="select">
					<option value="1">Id</option>
					<option value="2">Name</option>
					<option value="3">email</option>
					<option value="4">Contact</option>
				</select>

				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Enter value
						</label>
					 <input type="text" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp" name="value">
				</div>

				<div class="container d-flex justify-content-center">
					<button type="submit" class="btn btn-info">Search Student</button>
				</div>

			</form>

			<%
			if (pojo != null) {
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
					<tr>
						<td><%=pojo.getId()%></td>
						<td><%=pojo.getName()%></td>
						<td><%=pojo.getEmail()%></td>
						<td><%=pojo.getContact()%></td>
						<td><%=pojo.getAddress()%></td>
					</tr>
				</tbody>
			</table>
			<%
			}else{
			%>
			
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
			
			<% }%>

		</div>



	</div>


</body>
</html>