<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update information here</title>
</head>
<body>
<form action="UpdateServlet" method="post">
                <label >Enter assignment id:</label>
                <input name="id" value="${param.id}">
                <label >Enter correct grade:</label>
                <input name="grade" value="${param.grade}">
                <input type="submit" ><br/>
                <span class="message">${message}</span>
 </form>
</body>
</html>