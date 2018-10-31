//This function replaces the html in the major_courses fieldset depending on the major the user selected.
void function getCourses(){
    var obj = document.getElementById("major_selector");
	let major = obj.options[obj.selectedIndex].value;
	let html;
	if(major === "computer_science"){
		//The plan is to have something similar to this for all majors unless someone finds a better way of doing this.
		html = '<legend>Select the courses which you have taken</legend>';
		html += '<p><strong>Major Core</strong></p><br />';
		html += '<input type="checkbox" name="CORE" value="CS1300"/> CS1300 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS1400"/> CS1400 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS2400"/> CS2400 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS2640"/> CS2640 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS3110"/> CS3110 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS3310"/> CS3310 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS3650"/> CS3650 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS3750"/> CS3750 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS4080"/> CS4080 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS4310"/> CS4310 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS4630"/> CS4630 <br/>';
		html +=	'<input type="checkbox" name="CORE" value="CS4800"/> CS4800 <br/>';
		
		//The purpose of this button is to test the getChecked function
		html += '<input type="button" name="Button" onclick="getChecked()"/>';
	}
	else if(major === "computer_engineering" || major ==="mechanical_engineering"){
		html = '<p>Unfortunately we currently do not support this curriculum</p>';
	}
    document.getElementById("major_courses").innerHTML = html;
}


//Prints out an array of the different courses the user has checked off.
//Can be modified to return an array instead.
void function getChecked(){
	var items = document.getElementsByName("CORE");
	let checked = new Array();
	for(var i = 0; i < items.length; i++){
		if(items[i].checked === true){
			checked.push(items[i].value);
		}
	}
	
	let html = '<p><strong>Checked Classes</strong></p>';
	html += '<p>';
	for(var i = 0; i < checked.length; i++){
		html += (checked[i] + " ");
	}
	html += '</p>';
	
	document.getElementById("checked_courses").innerHTML = html;
}