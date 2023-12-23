<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Tutorial Listesi</h1>
<table>
<th><b>Title</b></th>
<th><b>Description</b></th>

<c:forEach items="${tutorialListesi}" var="tutorial">
<tr>
<td>${tutorial.title}</td>
<td>${tutorial.description }</td>
<td><a href="/editTutorial/${tutorial.id}">Düzenle</a>
<td><a href="/tutorialSil2/${tutorial.id}"  
 onclick="return confirm('Silmek istediğinizden emin misiniz?');">Sil</a>
</tr>
</c:forEach>
</table>
<br />
<a href="/newtutorial">Tutorial Ekle</a> 
 <button onclick="tikla2();" >Tıkla</button>
 <script>
 function tikla2()
 {
	 alert('tıklandı 2');
 }
 </script>
</body>
</html>