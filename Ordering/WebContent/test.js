/**
 * 
 */

/**
 * 
 */
var req;
var req2;
var str;
var state;
var s_type,o_type;
function sendRequest()
{

	state =document.getElementById("state_code").value;
	var zip=document.getElementById("zip_id").value;
	if(window.XMLHttpRequest){
			req2=new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
		{
		req2=new ActiveXObject("Microsoft.XMLHttp");}
		var url="FetchServices?state_code="+state+"&zip_code="+zip;
		req2.onreadystatechange =getResponse;
		req2.open("GET",url,true);
		req2.send(null);
}
function sendRequeststate(state)
{
//	alert(cname)
	
	if(window.XMLHttpRequest){
			req=new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
		{
		req=new ActiveXObject("Microsoft.XMLHttp");
		}
		var url="stateAjax?state_code="+state;
		req.onreadystatechange =getState;
		req.open("GET",url,true);
		req.send(null);
		
}
function wind()
{
	document.getElementById("framePane").innerHTML="<div class='wrapper1' style='padding-left:2%; padding-top: 10%;' ><div class='h_iframe1'><img class='ratio' src='http://placehold.it/16x9'/>"
		+"<iframe src='http://192.168.0.174:200/PersonalDetails.aspx' ></iframe></div></div>";
}
function productCatalog(){
	document.getElementById("framePane").innerHTML="<div class='wrapper'><div class='h_iframe'><img class='ratio' src='http://placehold.it/16x9'/>"
		+"<iframe src='http://192.168.0.153:84/PCRtoProduction.aspx' ></iframe></div></div>";
}
function getResponse()
{
	var string;
	if(req.readyState==4 && req.status==200)
	{
				response=req2.responseText;
					if(response.length >0){
							if(s_type == "business")
						    document.getElementById("ZipSelection").innerHTML=" <h2 class='vzh2' align='center'>Enterprise service is available in this region </h2>"+
//						    "<form action='http://192.168.0.164:220/?V=10'>"+
						    "<br><button type='button' onclick='wind()' class='vzbtn'>Proceed</button>";
						
						else{
							var ar= response.split(" ");
							str="<div id='areaServiceSelection' class='vzh3'>Choose the required service in your area <br><select>";
							if(ar[0]=="*")
							{
								str+="<br><option value=fios/>Fios</option>"+
								"<option value=bundles/>Bundles</option>"+
								"<option value=data/>Data</option>"+
								"<option value=voice/>Voice</option>"+
								"<option value=wireless/>Wireless</option>";
								document.getElementById('ZipSelection').innerHTML=str+"</select>"+"<button type='button' class='vzbtn' width='100px' onClick=window.location.assign(\"http://localhost:8080/Ordering/HomePage1.jsp?ser_id=3"+"&C="+state+"\")>Submit1</button>";
							}
							else
								{
							for(var i=0;i<ar.length;i++){
								if(ar[i] != "enterprise")
								{
									str+="<option value='"+ar[i]+"'/>"+ar[i]+"</option>";
									
									if(i==ar.length-1)
										document.getElementById('ZipSelection').innerHTML=str+"</select>"+"<button type='button' class='vzbtn' width='100px' onClick=window.location.assign(\"http://localhost:8080/Ordering/HomePage1.jsp?ser_id=3"+"&C="+state+"\")>Submit1</button>";
								}
						}
						}
					}
				}
		}
}
function getS_type(service_type)
{
	s_type=service_type;
}
function getO_type(order)
{
	o_type=order;
}

function redirect_order()
{
	if(s_type == "business")
		{
		if(o_type=="change")
			document.getElementById("framePane").innerHTML="<div class='wrapper'><div class='h_iframe'><img class='ratio' src='http://placehold.it/16x9'/>"
				+"<iframe src=http://192.168.0.174:200/Change.aspx?customerid="+document.getElementById('cid').value+"></iframe></div></div>";
		else if(o_type=="sus_res")
			document.getElementById("framePane").innerHTML="<div class='wrapper'><div class='h_iframe'><img class='ratio' src='http://placehold.it/16x9'/>"
				+"<iframe src=http://192.168.0.174:200/Restore.aspx?customerid="+document.getElementById('cid').value+"></iframe></div></div>";
		else if(o_type=="terminate")
			document.getElementById("framePane").innerHTML="<div class='wrapper'><div class='h_iframe'><img class='ratio' src='http://placehold.it/16x9'/>"
				+"<iframe src=http://192.168.0.174:200/Disconnect_Or.aspx?customerid="+document.getElementById('cid').value+"></iframe></div></div>";
		}
	else
	{
	if(o_type=="change")
		window.location.assign("ChangeOrder.jsp");
	else if(o_type=="sus_res")
		window.location.assign("CustomerId.jsp");
	else if(o_type=="terminate")
		window.location.assign("Disconnect_disconnect.jsp");
	}
}

function getState()
{
	if(req.readyState==4 && req.status==200)
		{		
			if(req.responseText == "true")			
				{
				 document.getElementById("zip_id").disabled = true;			
				 document.getElementById("zip_id").style.background = "#a9a9a9";
				 document.getElementById("zip_id").value='*';
				}
				 else
				 document.getElementById("zip_id").disabled = false;
//				document.getElementById("zip_id").innerhtml="<h1 class='vzh3'>All the services are available in this State</h1>";
		}
}
  
function service(type)
{
	document.getElementById("typeSelection").innerHTML = '<div id="serviceSelection" font-size="28px" ><h1 class="vzh1">CHOOSE THE REQUIRED SERVICE</h1><br>'+ 
'<input type="radio" id="rb11" name="rb" value="new" onClick="askZip(type);getO_type(value)"> <label for="rb11">New Order</label><br>'+
'<input type="radio" id="rb22" name="rb" value="change" onClick="askID(type);getO_type(value)"> <label for="rb22">Change Order</label><br>'+ 
'<input type="radio" id="rb33" name="rb" value="terminate" onClick="askID(type);getO_type(value)"><label for="rb33">Terminate Order</label><br>'+ 
'<input type="radio" id="rb44" name="rb" value="sus_res" onClick="askID(type);getO_type(value)"><label for="rb44">Suspend/Restore Order</label></p></div>';
}
function askZip(type)
{
	document.getElementById("serviceSelection").innerHTML = '<div id="ZipSelection" class="vzh4" font-size="10px"><h1 class="vzh1">ENTER THE DETAILS</h1><br>'+
	'State Code : <input class="vztext" type="text" id="state_code" onblur="sendRequeststate(this.value)"></input><br><br>'+
	'Z I P Code :	<input class="vztext" type="text" id="zip_id" name="zip"></input><br><br>'+
	'<button id="button" class="vzbtn" width="100px" onClick="sendRequest(type)" >Submit</button>';
	
}
function askID(type)
{
	document.getElementById("serviceSelection").innerHTML = '<div id="ZipSelection" font-size="23px"><h1 class="vzh1">ENTER THE DETAILS</h1><br>Customer Id  : '+ 
	' <input id="cid" class="vztext" type="text" name="customerid"></input><br><br>'+
	'<button id="button" class="vzbtn" width="100px" onClick="redirect_order()">Submit</button>';
}

