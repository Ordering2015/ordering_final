<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>
<head>
<title>Ordering</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	var cid1;
	function handleWizardNext() {
		if (document.getElementById('ButtonNext').name == 'Step2') {
			document.getElementById('ButtonNext').name = 'Step3';
			document.getElementById('ButtonPrevious').name = 'Step1';
			document.getElementById('ButtonPrevious').disabled = '';
			document.getElementById('Step1').style.display = 'none';
			document.getElementById('Step2').style.display = '';
		}

		else if (document.getElementById('ButtonNext').name == 'Step3')

		{
			var fname = document.getElementById('firstName').value;
			var lname = document.getElementById('lastName').value;
			var pno = document.getElementById('phone').value;
			var emailid = document.getElementById('TextEmail').value;
			var addline1B = document.getElementById('TextAddressLine1B').value;
			var addline2B = document.getElementById('TextAddressLine2B').value;
			var cityB = document.getElementById('TextCityB').value;
			var stateB = document.getElementById('TextStateB').value;
			var zipcodeB = document.getElementById('TextZipCodeB').value;
			var addline1S = document.getElementById('TextAddressLine1service').value;
			var addline2S = document.getElementById('TextAddressLine2service').value;
			var cityS = document.getElementById('TextCityservice').value;
			var stateS = document.getElementById('TextStateservice').value;
			var zipcodeS = document.getElementById('TextZipCodeservice').value;
			var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
			var validemail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$/;
			var zipcode = /^[0-9]{5}$/;
			if (fname == "") {
				alert("Enter FirstName");
				valid();
			} else if (lname == "") {
				alert("Enter LastName");
				valid();
			} else if (!(phoneno.test(pno)))

			{
				alert("Invalid Phone Number");
				valid();
			} else if (!(validemail.test(emailid))) {
				alert("Invalid email address");
				valid();
			} else if (addline1B == "") {
				alert("Enter AddressLine 1 in Billing Address");
				valid();
			} else if (addline2B == "") {
				alert("Enter AddressLine 2 in Billing Address");
				valid();
			} else if (cityB == "") {
				alert("Enter City in Billing Address");
				valid();
			} else if (stateB == "") {
				alert("Enter State in Billing Address");
				valid();
			} else if (!(zipcode.test(zipcodeB))) {
				alert("Invalid Zipcode in Billing Address");
				valid();
			} else if (addline1S == "") {
				alert("Enter AddressLine 1 in Service Address");
				valid();
			} else if (addline2S == "") {
				alert("Enter AddressLine 2 in Service Address");
				valid();
			} else if (cityS == "") {
				alert("Enter City in Service Address");
				valid();
			} else if (stateS == "") {
				alert("Enter State in Service Address");
				valid();
			}

			else {
				if (!(zipcode.test(zipcodeS))) {
					alert("Invalid Zipcode in Service Address");
					valid();
				} else {
					document.getElementById('ButtonNext').name = 'Step4';

					document.getElementById('ButtonPrevious').name = 'Step2';

					document.getElementById('Step2').style.display = 'none';

					document.getElementById('Step3').style.display = '';

				}
			}

		} else if (document.getElementById('ButtonNext').name == 'Step4')

		{

			document.getElementById('ButtonNext').name = '';

			document.getElementById('ButtonPrevious').name = 'Step3';

			document.getElementById('ButtonNext').disabled = 'disabled';

			document.getElementById('SubmitFinal').disabled = '';

			document.getElementById('Step3').style.display = 'none';

			document.getElementById('Step4').style.display = '';

			loadStep5Review();

		}
	}

	function handleWizardPrevious()

	{

		if (document.getElementById('ButtonPrevious').name == 'Step1')

		{

			document.getElementById('ButtonNext').name = 'Step2';

			document.getElementById('ButtonPrevious').name = '';

			document.getElementById('ButtonPrevious').disabled = 'disabled';

			document.getElementById('Step2').style.display = 'none';

			document.getElementById('Step1').style.display = '';
		}

		else if (document.getElementById('ButtonPrevious').name == 'Step2')

		{
			document.getElementById('ButtonNext').name = 'Step3';

			document.getElementById('ButtonPrevious').name = 'Step1';

			document.getElementById('Step3').style.display = 'none';

			document.getElementById('Step2').style.display = '';

		} else if (document.getElementById('ButtonPrevious').name == 'Step3')

		{

			document.getElementById('ButtonNext').name = 'Step4';

			document.getElementById('ButtonPrevious').name = 'Step2';

			document.getElementById('ButtonNext').disabled = '';

			document.getElementById('SubmitFinal').disabled = 'disabled';

			document.getElementById('Step4').style.display = 'none';

			document.getElementById('Step3').style.display = '';

		}
	}
	function loadStep5Review() {
		document.getElementById('viewfirstname').innerHTML = document
				.getElementById('firstName').value
				+ "  " + document.getElementById('lastName').value;
		var checkboxes = document.getElementsByName('cb');
		var vals = "";
				for (var i = 0, n = checkboxes.length; i < n; i++) {
			if (checkboxes[i].checked) {
				vals += " ," + checkboxes[i].value;
			}
		}
		document.getElementById('viewproduct').innerHTML = vals;

		//var e=document.getElementById("service");
		// var servicetype=e.options[e.selectedIndex].text;
		// document.getElementById('viewservice').innerHTML = servicetype;
		// var f=document.getElementById("cb");
		//   var productname=f.options[f.selectedIndex].text;
		// document.getElementById('viewproduct').innerHTML = productname;

		document.getElementById('viewbillingaddress').innerHTML = document
				.getElementById('TextAddressLine1B').value
				+ " , "
				+ document.getElementById('TextAddressLine2B').value
				+ " , "
				+ document.getElementById('TextCityB').value
				+ " , "
				+ document.getElementById('TextStateB').value
				+ " , "
				+ document.getElementById('TextZipCodeB').value;

		//  document.getElementById('viewshippingaddress').innerHTML = document.getElementById('TextAddressLine1ship').value +" , "+document.getElementById('TextAddressLine2ship').value+" , "+document.getElementById('TextCityship').value+" , "+document.getElementById('TextStateship').value+" , "+document.getElementById('TextZipCodeship').value;

		document.getElementById('viewserviceaddress').innerHTML = document
				.getElementById('TextAddressLine1service').value
				+ " , "
				+ document.getElementById('TextAddressLine2service').value
				+ " , "
				+ document.getElementById('TextCityservice').value
				+ " , "
				+ document.getElementById('TextStateservice').value
				+ " , " + document.getElementById('TextZipCodeservice').value;

	}
	function getProducts() {
		//var v = request.getParameter("ser_id");
		//var c=request.getParameter("C");
		var v = "2";
		var c=" ";
		var url = "GetProducts1?val=" + v;
		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			request.onreadystatechange = getInfo;
			//req.onreadystatechange=getInfo;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function getInfo() {
		{
			if (request.readyState == 4) {
				if (request.status == 200) {

					document.getElementById("product1").innerHTML = request.responseText;
					//window.alert("I m in 2nd function");
				}

			}
		}
	}
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
	function getvalue(cid) {
		cid1 = cid;

	}
	function valid() {
		document.getElementById('ButtonNext').name = 'Step3';
		document.getElementById('ButtonPrevious').name = 'Step1';
		document.getElementById('ButtonPrevious').disabled = '';
		document.getElementById('Step1').style.display = 'none';
		document.getElementById('Step2').style.display = '';
	}
</script>

</head>

<body onload="getProducts()">
<div class = "layout">

	<form id="SubscriptionWizard" action="CustomerServlet" method="post">

		<table border="1" cellpadding="5" cellspacing="0" id="HeaderTable"
			class="vztable">

			<tr>
				<td id="HeaderTableStep1" style="background-color: Silver">

					Step 1:&nbsp; Select Product(s)</td>

				<td id="HeaderTableStep2" style="background-color: Silver">

					Step 2: Billing Address, Shipping Address, Service Address, Payment
					Method</td>

				<td id="HeaderTableStep3" style="background-color: Silver">

					Step 3: Choose Due Date</td>

				<td id="HeaderTableStep4" style="background-color: Silver">

					Step 4: Confirm order</td>

			</tr>

		</table>

		<br /> <br> <span id="Step1">
			<div align="center" id="product">

				<label class="vzh3"> Choose the product</label>
				<div class="inputwrap" id="product1"></div>
				<!-- 				<select id="product" -->
				<!-- 					multiple> -->
				<!-- 					<option value="1">Preferred HD</option> -->
				<!-- 					<option value="2">Extreme HD</option> -->
				<!-- 					<option value="3">Ultimate HD</option> -->
				<!-- 				</select> -->
			</div>
		</span> <span id="Step2" style="display: none">
			<div align="center">
				<div style="margin-right: 40px;">
					<label class="vzh3">FirstName:</label> <input id="firstName"
						name="firstName" type="text" class="vztext" /><br> <br>
				</div>
				<div style="margin-right: 40px;">
					<label class="vzh3">LastName:</label> <input id="lastName"
						name="lastName" type="text" class="vztext" /><br> <br>
				</div>
				<div style="margin-right: 5px;">
					<label class="vzh3">Phone:</label> <input id="phone" name="phone"
						type="text" class="vztext" /><br> <br>
				</div>
				<div style="margin-right: 18px;">
					<label class="vzh3">Email Id:</label> <input id="TextEmail"
						name="Email" type="text" class="vztext" /><br> <br>
				</div>
				<div>
					<h2 class="vzh2">Billing Address</h2>
					<br>
				</div>
				<div style="margin-right: 80px;">
					<label class="vzh3">Address Line1</label> <input
						id="TextAddressLine1B" name="BAddressLine1" type="text"
						class="vztext" /><br> <br>
				</div>
				<div style="margin-right: 85px;">
					<label class="vzh3">Address Line 2</label> <input
						id="TextAddressLine2B" name="BAddressLine2" type="text"
						class="vztext" /><br> <br>
				</div>
				<div style="margin-left: 32px;">
					<label class="vzh3">City</label> <input id="TextCityB" name="BCity"
						type="text" class="vztext" /><br> <br>
				</div>
				<div style="margin-left: 20px;">
					<label class="vzh3">State</label> <input id="TextStateB"
						name="BState" type="text" class="vztext" /><br> <br>
				</div>
				<div style="margin-right: 10px;">
					<label class="vzh3">ZipCode</label> <input id="TextZipCodeB"
						name="BZipCode" type="text" class="vztext" /><br> <br>
				</div>
				<div>
					<h2 class="vzh2">Service Address</h2>
					<br>
				</div>
				<div style="margin-right: 70px;">
					<label class="vzh3">Address Line1</label> <input
						id="TextAddressLine1service" name="SAddressLine1" type="text"
						class="vztext" /><br> <br>
				</div>
				<div style="margin-right: 75px;">
					<label class="vzh3">Address Line 2</label> <input
						id="TextAddressLine2service" name="SAddressLine2" type="text"
						class="vztext" /><br> <br>
				</div>
				<div style="margin-left: 40px;">

					<label class="vzh3">City</label> <input id="TextCityservice"
						name="SCity" type="text" class="vztext" /><br> <br>
				</div>
				<div style="margin-left: 27px;">
					<label class="vzh3">State</label> <input id="TextStateservice"
						name="SState" type="text" class="vztext" /><br> <br>
				</div>
				<div style="margin-right: 3px;">
					<label class="vzh3">ZipCode</label> <input id="TextZipCodeservice"
						name="SZipCode" type="text" class="vztext" /><br> <br>
				</div>
				<div>
					<label class="vzh3">Payment Method :</label> <input type="radio"
						id="autopay" name="paymentmethod" value="Auto" checked> <label
						for="autopay" class="vzh3">AutoPay</label>&nbsp&nbsp <input
						type="radio" id="cheque" name="paymentmethod" value="Cheque">
					<label for="cheque" class="vzh3">Cheque</label>
				</div>
			</div>
		</span> <span id="Step3" style="display: none">
			<div class="inputwrap">
				<div align="center">
					<select id="mySelect" name="mySelect" class="select-style"
						onchange="getDate()">
						<option value="January">January</option>
						<option value="February">February</option>
						<option value="March">March</option>
						<option value="July">July</option>
					</select>
					<div id="date2"></div>
				</div>
			</div>
		</span> <span id="Step4" style="display: none">
			<div align="center">
				<h2 class="vzh2">Confirm Order</h2>
				<table class="vztable1">
					<tr>
						<td align="left"><label class="vzh3"> Name:</label></td>
						<td id="viewfirstname"></td>
					</tr>
					<!--  <tr><td align="left"><label class="vzh3">Selected Service:</label></td><td id="viewservice"></td></tr> -->
					<tr>
						<td align="left"><label class="vzh3">Selected
								Product:</label></td>
						<td id="viewproduct"></td>
					</tr>
					<tr>
						<td align="left"><label class="vzh3">Billing Address
								:</label></td>
						<td id="viewbillingaddress"></td>
					</tr>
					<tr>
						<td align="left"><label class="vzh3">Service Address
								:</label></td>
						<td id="viewserviceaddress"></td>
					</tr>
				</table>
			</div>
		</span> <br> <br>
		<div align="center">
			<input id="ButtonPrevious" type="button" value="Previous"
				class="vzbtn" disabled="disabled" name=""
				onclick="handleWizardPrevious()" /> <input id="ButtonNext"
				type="button" value="Next" class="vzbtn" name="Step2"
				onclick="handleWizardNext()" /> <input id="SubmitFinal"
				type="submit" value="Finish" class="vzbtn" disabled="disabled" />
		</div>
	</form>

	<jsp:include page="Header2.jsp"></jsp:include>
		</div>
</body>
</html>