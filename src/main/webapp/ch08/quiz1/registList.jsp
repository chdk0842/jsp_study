<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 목록</title>
</head>
<body>
   <h2>고객 목록</h2>
   <hr>
   
   <table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
		</tr>

		<%-- for(Regist r : regist) --%>
		<c:forEach var="r" varStatus="i" items="${regist}">
			<tr>
				<td>${i.count}</td>				<%-- 포문을 몇번 돌리는지 카운팅 --%>
				<td><a href="/jsp_study/rontrol?action=info&id=${r.id}">${r.name} </a></td>
				<td>${r.phone}</td>
			</tr>
		</c:forEach>
	</table>
	
   
</body>
</html>