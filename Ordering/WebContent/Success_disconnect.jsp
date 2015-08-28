<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="styles.css"> 
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

<div class="vzh2" style="position:relative; top:200px;">
<center>
<h4>
<%
Object value1 = request.getAttribute("att3");
out.println(value1);
%>
<%-- <br/>
<%
Object value2 = request.getAttribute("att4");
out.println(value2);
%> --%>
</h4>
</center>
</div></br></br></br></br></br></br></br></br></br></br>
<jsp:include page="Header2.jsp"></jsp:include>
</body>
</html>