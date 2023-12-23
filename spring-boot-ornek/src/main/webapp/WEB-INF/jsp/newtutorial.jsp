<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Yeni Tutorial Ekle</h1>
<form:form method="POST" action="addNewTutorial">
<table>
<tr>
<td><form:label path="title">Title </form:label></td>
<td><form:input path="title" /></td>
</tr>
<tr>
<td><form:label path="description">Description </form:label></td>
<td><form:input path="description" /></td>
</tr>

<tr>
<td>&nbsp;</td>
<td><input type="submit" value="Kaydet" /></td>
</tr>
</table>
</form:form>
</body>
</html>