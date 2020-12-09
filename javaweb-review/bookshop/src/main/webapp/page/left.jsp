<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <c:url value="/findAllBook" var="findAllBook"></c:url>
   <a href="${findAllBook}" target="mainContent">查询所有</a> <br/>
   <a href="addBook.jsp" target="mainContent">添加图书</a>
</body>
</html>