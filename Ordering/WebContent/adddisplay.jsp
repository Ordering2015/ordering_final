<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<form action="AddressServ">

<br>


 
 <div align="center">
         <h2 class="vzh2">Enter New Address</h2><br>
         </div>
         <div align="center">
         <div class="inputwrap">
		<label class="vzh3">Address Line1</label>
            <input id="TextAddressLine1B" name="a1" type="text" required class="vztext" /><br><br>
            </div>
            <div class="inputwrap">
        <label class="vzh3">Address Line 2</label>
          <input id="TextAddressLine2B" name="a2" type="text" required class="vztext" /><br><br>
        </div>
        <div class="inputwrap">
        <label class="vzh3">City</label>
           <input id="TextCityB" name="a3" type="text" required class="vztext"/><br><br>
           </div>
           <div class="inputwrap">
       <label class="vzh3">State</label>
           <input id="TextStateB" name="a4" type="text" required class="vztext" /><br><br>
      </div>
       <div class="inputwrap">
       <label class="vzh3">StateCode</label>
            <input id="TextZipCodeB" name="a5" type="text"  required class="vztext" /><br><br>
  	    </div>
        <div class="inputwrap">
       <label class="vzh3">ZipCode</label>
            <input id="TextZipCodeB" name="a6" type="text" required class="vztext" /><br><br>
  	    </div>
  	    </div>


<!-- <div align="center">
<div class="inputwrap1">
<label class="vzh3" >Enter new address: </label><br><br><input type="text" class="vztext" placeholder="vztext" name="type2"><br>
</div>
<div class="inputwrap1"><label class="vzh3" >AddressLine1:<input type="text" name="a1"></label></div></br>
<div class="inputwrap1"><label class="vzh3" >AddressLine2:<input type="text" name="a2"></label></div></br> 
<div class="inputwrap1"><label class="vzh3" >City:<input type="text" name="a3"></label></div></br>
<div class="inputwrap1"><label class="vzh3" >State:<input type="text" name="a4"></label></div></br>
<div class="inputwrap1"><label class="vzh3" >State_code:<input type="text" name="a5"></label></div></br>
<div class="inputwrap1"><label class="vzh3" >Zip_code:<input type="text" name="a6"></label></div></br>
</div> -->
<div align="center">
<input type="submit" class="vzbtnmedium" value="submit">
</div>
</form>
</div>
<jsp:include page="Header2.jsp"></jsp:include>
</body>
</html>
