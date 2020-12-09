<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>查询所有书籍</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<td>编号</td>
				<td>标题</td>
				<td>价格</td>
				<td>操作</td>
			</tr>
			<!-- 获得request作用的值bookList，展示 -->
			<c:forEach items="${requestScope.bookList}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.price}</td>
					<!-- 
						当前页面：http://localhost:8080/day10_demo/findAllBook
						目标页面：http://localhost:8080/day10_demo/preUpdateBookServlet
					 -->
					 <c:url var="updateBookUrl" value="/preUpdateBookServlet?bookId=${book.id}"></c:url>
					 <c:url var="deleteBookUrl" value="/deleteBookServlet?bookId=${book.id}"></c:url>
					<td><a href="${updateBookUrl}">修改</a> <a href="${deleteBookUrl}">删除</a></td>
				</tr>
			</c:forEach>
			

		</table>
	</body>
</html>