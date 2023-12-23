<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Tutorial Düzenle</h1>

<form:form method="POST" action="/editsave" >
<table>
<tr>
<form:hidden path="id" />
</tr>
<tr>
<td><b>Title : </b></td>
<td><form:input path="title" /></td>
</tr>


<tr>
<td><b>Description : </b></td>
<td><form:input path="description" /></td>
</tr>

</table>

<tr>
<td>&nbsp;</td>
<td><input type="submit" value="Güncelle" ></td>
</tr>
</form:form>
</body>
</html>