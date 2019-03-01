<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/view/styliai.css"%></style>
<title>Insert title here</title>
</head>
<body>
	<div class="spal">
	<h2>Update a Book</h2>
	<form action="BookServlet?action=update" method="post">
		<p>Title</p>
		<p><input type="text" name="title" value="${book.title}" required></p>
		<p>Author</p>
		<p><input type="text" name="author" value="${book.author}" required></p>
		<p>Description</p>
		<p><textarea rows="5" cols="50" name="description">${book.description}</textarea></p>
		<p>Price</p>
		<p><input type="text" name="price" value="<fmt:formatNumber type='number' maxFractionDigits='2' value='${book.price}'/>" required></p>
		<p><input type="submit" value="Update"></p>
	</form>
		<a href="BookServlet?action=" style="color: #98FB98;">Back</a>
	</div>
</body>
</html>