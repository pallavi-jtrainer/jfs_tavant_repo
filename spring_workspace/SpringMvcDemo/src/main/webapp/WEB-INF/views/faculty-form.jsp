<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add New Faculty</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
			rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="card">
				<div class="card-header">
					<h2>New Faculty Details</h2>
				</div>
				<div class="card-body">
					<form:form action="saveFaculty" class="form-horizontal" method="post" modelAttribute="faculty">
						<div class="form-group">
							<label>First Name</label>
							<form:input type="text" class="form-control" path="firstName"/>
						</div>
						<div class="form-group">
							<label>Last Name</label>
							<form:input type="text" class="form-control" path="lastName"/>
						</div>
						<div class="form-group">
							<label>Email</label>
							<form:input type="email" class="form-control" path="email"/>
						</div>
						<div>
							<form:button class="btn btn-success" type="submit">Submit</form:button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>