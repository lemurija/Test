<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/view/styliai.css"%></style>
<title>View All Books</title>
</head>
<body>
	<div>
		<div id="kaire" style="vertical-align: middle;">
			<h2 style="color: #98FB98; margin-left: 50%">Book's Shop</h2>
		</div>
		<div id="desine">
			<input style="width: 100px;" type="text" name="login" required>
			<input style="width: 100px;" type="text" name="pasw" required>
			<input type="submit" name="submit" value="Login">
		</div>
	</div>	
	<div id="cart">
		<h3>Cart: </h3>
	</div>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Author</th>
			<th>Description</th>
			<th>Price</th>
			<th>Update</th>
			<th>Delete</th>			
		</tr>
		<c:forEach var="book" items="${listOfBooks}">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.description}</td>
				<td>&euro;<fmt:formatNumber type="number" maxFractionDigits="2" value="${book.price}"/></td>
				<td>
					<a href="BookServlet?action=showupdate&bookid=${book.id}" style="color: #98FB98;">Update</a>
				</td>
				<td>
					<a href="BookServlet?action=delete&bookid=${book.id}" style="color: #98FB98;">Delete</a>
				</td>				
			</tr>
		</c:forEach>
	</table>
	<br>
	<div class="nuorodos">
		<a href="BookServlet?action=showinsertform" style="color: #98FB98;">Insert New Book</a><br>
		<a href="BookServlet?action=searchform" style="color: #98FB98;">Search</a>
	</div>
</body>
</html>