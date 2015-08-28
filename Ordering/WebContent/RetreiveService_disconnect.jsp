<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 <%@ page import = "javax.servlet.RequestDispatcher" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="styles.css">
 
 
  
 <script type="text/javascript">
function evalGroup()
{
var group = document.Form1.cb;
for (var i=0; i<group.length; i++) 
{
if (group[i].checked)
break;
}
if (i==group.length)
{
	alert("Please select the services to be disconnected");
}
}
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 
</head>
<body>
<div class = "layout">

<form name="Form1" action="Update_disconnect" method="post">

<div class="inputwrap1" align="center" style="position:relative; top:100px; right:100px;"> 
		
<div class="vzh2" style="position:relative; left:100px;">
<h4>Customer ID: <c:out value="${sessionScope.att2}"/></h4>
</div>

<div class="vzh4" style="position:relative; left:100px;">
<h5>Your current services</h5>
</div>
<div style="position:relative; left:200px;">
		<c:forEach items="${att1}" var="a">
		<input type="checkbox" value="${a}" name="cb" id="${a}">
		<label class="vzh5" for="${a}"><c:out value="${a}"/></label><br/>
		</c:forEach>
		
		<br/><br/><br/>

</div>

<div style="position:relative; left:100px;">
<input type="submit" class="vzbtnmedium" value="Disconnect" onClick="evalGroup()">
</div>
</div>

</form>

<%--  <c:out value="${sessionScope.att2}"/>  --%>
</div></br></br></br></br></br></br></br></br></br></br>
<jsp:include page="Header2.jsp"></jsp:include>


</body>
</html>