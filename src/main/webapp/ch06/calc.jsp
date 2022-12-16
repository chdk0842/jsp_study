<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//request : 클라이언트가 요청한(보낸) 내용들이 담겨있다. 보낸 내용 중에 n1을 가져온다.
	int n1 = Integer.parseInt(request.getParameter("n1"));
    int n2 = Integer.parseInt(request.getParameter("n2"));
    System.out.println("n1 : " + n1 + "\nn2 : " + n2);
    
    String op = request.getParameter("op");
    System.out.println("op : " + op);
    
    long result = 0;   // 연산의 결과를 담을 변수
    
    switch(op) {
    case "+" : result = n1 + n2;
    break;
    case "-" : result = n1 - n2;
    break;
    case "*" : result = n1 * n2;
    break;
    case "/" : result = n1 / n2;
    break;
    }


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     결과 : <%=result %>
 <!-- 응답 -->
</body>
</html>