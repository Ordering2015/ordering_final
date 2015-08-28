<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
 <form action="UpdateDb">
 <table class="vztable" border="5">
  <tr>
  <td><label class="vzh3" >Product_Name</label></td>  
   <td><label class="vzh3" >Product_id</label></td>
  <td><label class="vzh3" >Service_id</label></td>
  <td><label class="vzh3" >Price</label></td>
    </tr>
  
  
    <c:forEach var="e" items="${pds}">
   <tr>
   <td><input type="checkbox" name="cb" value= "${e.productID},${e.productName},${e.serviceID},${e.rate}" id="cb1" checked="checked"><label for="cb1"><c:out value="${e.productID}"></c:out></label></td>
   <td><c:out value="${e.productName}"></c:out></td>
 <td><c:out value="${e.serviceID}"></c:out></td>
 <td><c:out value="${e.rate}"></c:out></td> 
 
 </tr>
   </c:forEach>
  
  
  
   <c:forEach var="e" items="${apds}">
  <tr>
   <td><input type="checkbox" name="cb" value= "${e.productID},${e.productName},${e.serviceID},${e.rate}"  id="cb1"  ><label for="cb1"> <c:out value="${e.productID}"></c:out></label> </td>
  <td> <c:out value="${e.productName}"></c:out></td>
  <td><c:out value="${e.serviceID}"></c:out></td>
  <td><c:out value="${e.rate}"></c:out></td>
   </tr>
   </c:forEach>
  
  
   </table>
   <br>
   <br>
   <div align="center">
   <input type="submit" value="Submit"  class="vzbtnmedium">
   </div>
   </form>
   </div>
<jsp:include page="Header2.jsp"></jsp:include>
</body>
</html>