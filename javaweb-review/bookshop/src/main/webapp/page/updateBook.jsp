<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
   <c:url value="/updateBookServlet" var="updateBook"></c:url>
   <form action="${updateBook}" method="post">
       <table border="1">
           <tr>
               <td>标题</td>
               <td>
                   <input type="text" name="title" value="${requestScope.book.title}">
                   <input type="hidden" name="id" value="${requestScope.book.id}">
               </td>
           </tr>
           <tr>
               <td>价格</td>
               <td><input type="text" name="price" value="${requestScope.book.price}"></td>
           </tr>
           <tr>
               <td></td>
               <td><input type="submit" value="提交"/></td>
           </tr>
       </table>
   </form>

</body>
</html>