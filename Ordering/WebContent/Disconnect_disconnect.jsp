
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


</head>
<body>
<div class = "layout">
<%-- <jsp:useBean id="obj" class="ordering.CustomerIdBean"></jsp:useBean>   
<jsp:setProperty property="*" name="obj"/>

 --%>

<form action="ServiceCustomerId_disconnect" method="post">
<div align="center" style="position:relative; top:100px;"> 
<div class="vzh2">
<h4>Customer ID</h4>
<input type="text" class="vztext" name="customerId" required> 

</div>
<br/><br/><br/><br/>

<div class="inputwrap"> 
<button  class="vzbtnmedium" >list services</button><br/>
</div> 
</div> 


<!-- <div align="center">
Customer ID:<input type="text" class="vztext"name="customerId"><BR><BR><BR>
<input type="submit"  class="vzbtn" value="list services" ><br/>
</div>
 -->
 
</form>
 
</div></br></br></br></br></br></br></br></br></br></br>
<jsp:include page="Header2.jsp"></jsp:include>
</body>
</html>

