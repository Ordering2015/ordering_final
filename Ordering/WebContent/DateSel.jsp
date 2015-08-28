<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "layout">
<form>
<div class="inputwrap">
		<div align="center">
		<select id="mySelect" name="mySelect" class="select-style" onchange="getDate()">
		<option value="January">January</option>
		<option value="February">February</option>
		<option value="March">March</option>
		<option value="July">July</option>
		</select>
		<div id="date2">
		</div>
		</div>
		</div>
		</form>
</body>
</html>