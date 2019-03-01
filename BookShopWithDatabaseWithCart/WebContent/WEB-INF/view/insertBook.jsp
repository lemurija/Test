<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style><%@include file="/WEB-INF/view/styliai.css"%></style>
<title>Insert title here</title>
</head>
<body>
	<div class="spal">
	<h2>Insert details for a Book</h2>
	<form action="BookServlet?action=insertbook" method="post">
		<p>Title</p>
		<p><input type="text" name="title" placeholder="title" required></p>
		<p>Author</p>
		<p><input type="text" name="author" placeholder="author" required></p>
		<p>Description</p>
		<p><textarea rows="5" cols="50" name="description" placeholder="description"></textarea></p>
		<p>Price</p>
		<p><input type="text" name="price" placeholder="price" required></p>
		<p><input type="submit" value="Insert"></p>
	</form>
		<a href="BookServlet?action=" style="color: #98FB98;">Back</a>
	</div>
</body>
</html>