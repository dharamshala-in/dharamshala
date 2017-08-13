function onlyNumbersWithZero(evt,name) { 
	
		var charCode = ( evt.which ) ? evt.which : event.keyCode
		//alert(charCode);
		if (charCode > 31 && (charCode < 48 || charCode > 57)){ 
			return false; 
		}
		
		else{
			if (name.value.length >= 15){
				var t='';
	   			for (i = 0; i <= 15; i++)
					{t+=name.value.charAt(i);
   				} 
	   			name.value=t;
				//name.select();
				return false
			}
			else{
				return true;
			}
		} 
	}
	
	function onlyNumbersWithZeroDot(evt,name) { 
	
		var charCode = ( evt.which ) ? evt.which : event.keyCode
		//alert(charCode);
		if ((charCode >=48 && charCode <=57)|| charCode==46 ){ 
			return true; 
		}else{
			return false;
		}
		
		
		
	}
	
	function onlyAlphaString(evt) { 
	//alert("inside");
		var charCode = ( evt.which ) ? evt.which : event.keyCode
		//alert(charCode);
		if((charCode>=97 && charCode<=122) || ( charCode>=65 && charCode<=90) || charCode==32 || charCode==8){		
			return true;
		}else{
			return false;
		}
	}
	
	function onlyAlphaNumericString(evt,name) { 
	//alert("fdsfdsf");
		var charCode = ( evt.which ) ? evt.which : event.keyCode
		//alert(charCode);
		if((charCode>=97 && charCode<=122) || ( charCode>=65 && charCode<=90)  ||  (charCode >= 48 && charCode <= 57)){		
			return true;
		}else{
			return false;
		}
	}
	
function checkSpecialChar(evt,name){
//var boxContent="1212!!!!"
  //alert("123"); 
var iChars = "`~!#$%^&+=[]\\;/{}|<>";

  for (var i = 0; i < name.value.length; i++) {
  	  	if (iChars.indexOf(name.value.charAt(i)) != -1) {
  	alert (" Special characters `~!#$%^&+=[]\\;/{}|<> not allow in text please remove and try again");
  	name.value="";
  	document.getElementById("charCount").innerHTML="3000";
  	return false;
  	}
  }
  
  if(name.value.length>=3000){
  		name.value= name.value.substr(0,3000);
  			
  	}
  	document.getElementById("charCount").innerHTML=""+(3000-parseInt(name.value.length));
}


  
function validateFields(){
	alert("IN SIDE VALIDATE"+document.SearchTable.roomTypeId.value);
	if(document.SearchTable.roomTypeId.value==null || document.SearchTable.roomTypeId.value==""){
		alert("Please select a Room Type !!");
		return false;
	
	}else  if(document.SearchTable.checkIn.value==null || document.SearchTable.checkIn.value==""){
		alert("Please select Check In Date !!");
		return false;
	}else if(document.SearchTable.checkIn.value!=null || document.SearchTable.checkIn.value!=""){
		 var matches = /(\d{2})[/\/](\d{2})[/\/](\d{4})/.exec(document.SearchTable.checkIn.value);
		// alert(matches);
        if (matches == null)
         {
            alert("Please enter Date in DD/MM/YYYY format")
            return false;
         }
	}else  if(document.SearchTable.checkOut.value==null || document.SearchTable.checkOut.value==""){
		alert("Please select Check Out Date !!");
		return false;
	}else if(document.SearchTable.checkOut.value!=null || document.SearchTable.checkOut.value!=""){
		 var matches = /(\d{2})[/\/](\d{2})[/\/](\d{4})/.exec(document.SearchTable.checkOut.value);
		// alert(matches);
        if (matches == null)
         {
            alert("Please enter Date in DD/MM/YYYY format")
            return false;
         }
	}else{  
		return true;
	}
}

