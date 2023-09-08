<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-info shadow m-4 rounded-2">
  <div class="container-fluid">
    <a class="navbar-brand" href="./home">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="./add">Add Student</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./delete">Delete Student</a>
        </li>
       	  <li class="nav-item">
          <a class="nav-link" href="./update">Update Student</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="./search">Search Student</a>
        </li>
       	<li class="nav-item">
          <a class="nav-link" href="./login">Logout</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav>
</body>
</html>