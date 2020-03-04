<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>

		<div id="container">

			<div id="content">
				<input type="button" value="Add Customer" 
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"/>

				<!--  add our html table here -->

				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>

					<!-- loop over and print our customers -->
					<c:forEach var="tempCustomer" items="${customers}"> 
					<!-- customers is the name from the controller (theModel.addAtribute("customers", theCustomers) -->
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
						</tr>

					</c:forEach>

				</table>

			</div>

		</div>
	</div>
</body>
</html>