<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container my-2" align="center">

<h3>Movie List</h3>
<a href="@{/addnew}" class="btn btn-primary btn-sm mb-3" >Add Movie</a>
	<table style="width:80%" border="1"
		class = "table table-striped table-responsive-md">
	<thead>
<tr>
	<th>Title</th>
	<th>Description</th>
	<th>Image</th>
</tr>
</thead>
<tbody>


<c:forEach items="${movieListesi}" var="movie">
<tr>
<td>${movie.title}</td>
<td>${movie.description}</td>
<td><a href="/editTutorial/${movie.id}" class="btn btn-primary">Düzenle</a>  
<td><a href="/tutorialSil2/${tutorial.id}"  
 onclick="return confirm('Silmek istediğinizden emin misiniz?');" class="btn btn-danger">Sil</a></td>
 <td><img src="${movie.imageurl}" width="100" height="100" /></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>