<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
        <script type="text/javascript">
            function getDate() {
                var val1 = document.getElementById("mySelect").value;
                     var url = "GetDate?val=" + val1;
                if (window.XMLHttpRequest) {
                    request = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    request = new ActiveXObject("Microsoft.XMLHTTP");
                }
                try {
                    request.onreadystatechange = getDateInfo;
                    //req.onreadystatechange=getInfo;
                    request.open("GET", url, true);
                    request.send();
                } catch (e) {
                    alert("Unable to connect to server");
                }
            }

            function getDateInfo() {
                {
                    if (request.readyState == 4) {
                        if (request.status == 200) {
                            document.getElementById("date2").innerHTML = request.responseText;
                            //window.alert("I m in 2nd function");
                        }
                      
                    }
                }
            }
        </script>
    </head>

    <body>
    <div class = "layout">
        <form action="GenXml">
            <div class="inputwrap">
                <div align="center">
                    <select id="mySelect" class="select-style" name="mySelect"  onchange="getDate()">
                        <option value="January">January</option>
                        <option value="February">February</option>
                        <option value="March">March</option>
                        <option value="July">July</option>
                    </select>
                    <div id="date2">
                    </div>
                </div>
            </div>
            <br>
            <br>
            <div align="center">
            <input type="submit" class="vzbtnmedium">
            </div>
        </form>
</div>
<jsp:include page="Header2.jsp"></jsp:include>
    </body>

    </html>