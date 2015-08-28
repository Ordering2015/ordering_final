/**
 * 
 */

/**
 * 
 */
var req;
var req2;
var str;
var s_type,o_type;
function sendRequest()
{

	var state =document.getElementById("state_code").value;
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
function getResponse()
{
	var string;
	if(req.readyState==4 && req.status==200)
	{
				response=req2.responseText;
					if(response.length >0){
						if(s_type == "business")
						    document.getElementById("ZipSelection").innerHTML=" <h2 class='vzh2' align='center'> All Enterprise services are available in region </h2>";
						else{
							var ar= response.split(" ");
							str="<div id='areaServiceSelection' class='vzh3'>Choose the required service in your area <br><select>";
							for(var i=0;i<ar.length;i++){
								if(ar[i] != "enterprise")
								{
									str+="<option value='"+ar[i]+"'/>"+ar[i]+"</option>";
									
									if(i==ar.length-1)
										document.getElementById('ZipSelection').innerHTML=str+"</select>"+"<button type='button' class='vzbtn' width='100px' onClick='getvalue(value)'>Submit</button>";
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

function getState()
{
	if(req.readyState==4 && req.status==200)
		{		
			if(req.responseText == "true")			
				 document.getElementById("zip_id").disabled = true;			
			else
				 document.getElementById("zip_id").disabled = false;
		}
		
}
  
function service(type)
{
	document.getElementById("typeSelection").innerHTML = '<div id="serviceSelection"><p class="vzh3">Choose the required service<br>'+ 
'<input type="radio" id="rb11" name="rb" value="new" onClick="askZip(type);getO_type(value)"> <label for="rb11">New Order</label><br>'+
'<input type="radio" id="rb22" name="rb" value="change" onClick="askID(type);getO_type(value)"> <label for="rb22">Change Order</label><br>'+ 
'<input type="radio" id="rb33" name="rb" value="terminate" onClick="askID(type);getO_type(value)"><label for="rb33">Terminate Order</label><br>'+ 
'<input type="radio" id="rb44" name="rb" value="sus_res" onClick="askID(type);getO_type(value)"><label for="rb44">Suspend/Restore Order</label></p></div>';
}
function askZip(type)
{
	document.getElementById("serviceSelection").innerHTML = '<div id="ZipSelection"><p class="vzh3">'+
	'State Code : <input class="vztext" type="text" id="state_code" onblur="sendRequeststate(this.value)"></input><br><br>'+
	'Zip Code :	<input class="vztext" type="text" id="zip_id" name="zip"></input><br><br>'+
	'<button id="button" class="vzbtn" width="100px" onClick="sendRequest(type)" >Submit</button>';
	
}
function askID(type)
{
	document.getElementById("serviceSelection").innerHTML = '<div id="ZipSelection"><p class="vzh3">Customer Id  : '+ 
	' <input class="vztext" type="text" name="name"></input><br><br>'+
	'<button id="button" class="vzbtn" width="100px" onClick="redirect_order()" >Submit</button>';
}

