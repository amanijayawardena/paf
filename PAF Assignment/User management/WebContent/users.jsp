
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/employees.js"></script>
</head>

<body>

<div class="container"><div class="row"><div class="col-6">
<h1>User  Management</h1>

<form id="formUser " name="formUser ">
User  Name:
<input id="username" name="username" type="text"
class="form-control form-control-sm">
<br> User  Address:
<input id="useraddress" name="useraddress" type="text"
class="form-control form-control-sm">
<br> User Electricity Account Number:
<input id="userelectricityaccountnumber" name="userelectricityaccountnumber" type="text"
class="form-control form-control-sm">

<br>


<input id="btnSave" name="btnSave" type="button" value="Save"
class="btn btn-primary">
<input type="hidden" id="hidUserIDSave"
name="hidUserIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divEmployeesGrid">
<%
User userObj = new User();
out.print(userObj.readUsers());
%>
</div>
</div> </div> </div>
</body>
</html>

