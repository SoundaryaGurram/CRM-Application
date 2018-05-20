<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>

<title>Save Customer</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> 

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"> 
</head>
<body background="C:/Users/JAIPAL/Desktop/black.jpg">
<div id="wrapper">
<div id="header">
<h2>CRM-Customer Representation Manager</h2>
</div>
</div>

<div id="container">
<h3>Save Customer</h3>

<form:form action="saveCustomer" modelAttribute="customer" method="POST">
<form:hidden path="id"/>

<table>
<tbody>
<tr>
<td><label>First name:</label></td>
<td><form:input path="firstName"/></td>
</tr>
<tr>
<td><label>Last name:</label></td>
<td><form:input path="lastName"/></td>
</tr>
<tr>
<td><label>Email Id:</label></td>
<td><form:input path="email"/></td>
</tr>
</tbody>
</table>

<input type="submit" value="Save" class="save" onclick="">
<input type="submit" value="Cancel" class="save" onclick="">
</form:form>

<div style="clear;both;"></div>
<p>
<a href="${pageContext.request.contextPath}/customer/list">Back To List</a>
</p>
</div>
</body>
</html>