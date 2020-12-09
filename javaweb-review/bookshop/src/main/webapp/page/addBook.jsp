<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
</head>
<body>
	<c:url value="/addBookServlet" var="addBookUrl"></c:url>
 	<form action="${addBookUrl}" method="post">
       <table>
       <tr>
          <td>编号</td>
          <td><input type="text" name="id"/></td>
       </tr>
       <tr>
          <td>标题</td>
          <td><input type="text" name="title"/></td>
       </tr>
       <tr>
          <td>价格</td>
          <td><input type="text" name="price"/></td>
       </tr>
       <tr>
          <td></td>
          <td><input type="submit" value="添加"/></td>
       </tr>  
       </table>                   
    </form>

</body>
</html>