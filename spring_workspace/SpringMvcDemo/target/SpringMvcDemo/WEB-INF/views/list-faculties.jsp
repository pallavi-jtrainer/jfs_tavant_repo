<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List of Faculties</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="card">
			<div class="card-header">
				<h2>Faculties List</h2>
			</div>
			
			<div class="card-body">
			<button type="button" class="btn btn-info" 
				onclick="window.location.href='showForm'; return false;">Add New Faculty</button>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="temp" items="${faculties}">
							<tr>
								<td>${temp.firstName}</td>
								<td>${temp.lastName}</td>
								<td>${temp.email}</td>
								<td>
									<button class="btn btn-warning">Edit</button>
									<button class="btn btn-danger">Delete</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>