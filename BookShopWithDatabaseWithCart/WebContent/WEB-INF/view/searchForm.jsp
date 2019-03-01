<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/view/styliai.css"%></style>
<title>Insert title here</title>
</head>
<body>	
	<h2 style="color: #98FB98; margin-left: 100px;">Search</h2>
	<div style="color: #98FB98; margin-left: 50px;">
		<form action="BookServlet?action=search" method="post">		
			<p>Enter search text:</p>
			<input type="text" name="search" required>
			<select name="choise"> 
				<option value="select">Select</option>         
                <option value="title">Title</option>                          
                <option value="author">Author</option>             
          	</select>
			<input type="submit" value="Search">			
		</form>
		<br>
		<a href="BookServlet?action=" style="color: #98FB98;">Back</a><br>	
		
	<c:choose>
		<c:when test="${choise=='title'}"><br>
			<table border="1">
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Author</th>
					<th>Description</th>
					<th>Price</th>		
				</tr>
				<c:forEach var="book" items="${listOfBooks}">
					<tr>
						<td>${book.id}</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.description}</td>
						<td>&euro;<fmt:formatNumber type="number" maxFractionDigits="2" value="${book.price}"/></td>				
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${choise=='author'}"><br>
			<table border="1">
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Author</th>
					<th>Description</th>
					<th>Price</th>		
				</tr>
				<c:forEach var="book" items="${listOfBooks}">
					<tr>
						<td>${book.id}</td>
						<td>${book.title}</td>
						<td>${book.author}</td>
						<td>${book.description}</td>
						<td>&euro;<fmt:formatNumber type="number" maxFractionDigits="2" value="${book.price}"/></td>			
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${choise==''}"><br>
			<h2 style="margin-left: 20%;">Books not found</h2>
		</c:when>
	</c:choose>	
	</div>
</body>
</html>