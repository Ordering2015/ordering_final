<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
  <link rel="stylesheet" href="theme.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<div class = "layout">
<form action="ClientServ1">
<div align="center">
<label class="vzh3" >Current payment method is :${name}</label>
<br><br>
<label class="vzh3" >Enter new payment method: </label><input type="text" required class="vztext" placeholder="vztext" name="type2">
<br><br>
</div>
<div align="center">
<input type="submit" class="vzbtnmedium" value="submit">
</div>
</form>
</div>
<jsp:include page="Header2.jsp"></jsp:include>
</body>
</html>
