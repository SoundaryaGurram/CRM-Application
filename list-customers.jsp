<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>


<title>Customers Representation Manager</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body background="C:/Users/JAIPAL/Desktop/black.jpg">
<div id="wrapper">
<div id="header">
<h1>CRM-Customer Representation Manager</h1>
</div>
</div>
<div id="container">
<div id="content">
<input type="button" value="Add Customer" class="add-button" onclick="window.location.href='showFormForAdd';return false;">
<br></br>

<table>
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>Action</th>
</tr>
<c:forEach var="temp" items="${customers}">
<c:url var="updateLink" value="/customer/showFormForUpdate">
<c:param name="customerId" value="${temp.id}"/>
</c:url>

<c:url var="deleteLink" value="/customer/delete">
<c:param name="customerId" value="${temp.id}"/>
</c:url>
<tr>
<td>${temp.firstName}</td>
<td>${temp.lastName}</td>
<td>${temp.email}</td>
<td><a href="${updateLink}">Update</a>|
<a href="${deleteLink}" onclick="if(!(confirm('Are you sure want to delete this customer?'))) return false">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div></div>
</body>
</html>


