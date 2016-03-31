<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello!</title>
</head>
<body>
<form action="MsServlet" method="post">
                <label >Enter student id:</label>
                <input name="id" value="${param.id}">
                <input type="submit" ><br/>
                <span class="message">${message}</span>
 </form>
</body>
</html>