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
    html += '<p><strong>Major Electives</strong></p><br />';
    html += '<p><strong>At least 12 units FROM:</strong></p><br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS3010"/> CS3010 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS3560"/> CS3560 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS3700"/> CS3800 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4110"/> CS4110 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4200"/> CS4200 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4350"/> CS4350 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4450"/> CS4450 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4500"/> CS4500 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4600"/> CS4600 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4650"/> CS4650 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4700"/> CS4700 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4810"/> CS4810 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4990"/> CS4990 <br/>';
    html += '<p><strong> No more than 3 units FROM:</strong></p><br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS2450"/> CS2450 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS2560"/> CS2560 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS2600"/> CS2600 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS2990"/> CS2990 <br/>';
    html += '<p><strong> No more than 4 units FROM: </strong></p><br />';
    html += '<input type="checkbox" name="ELECTIVES" value="CS2000"/> CS2000 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4000"/> CS4000 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4410"/> CS4410 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4610"/> CS4610 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="CS4620"/> CS4620 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="MAT3470"/> MAT3470 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="MAT3800"/> MAT3800 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="MAT3810"/> MAT3810 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="MAT4020"/> MAT4020 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="MAT4750"/> MAT4750 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="MAT4850"/> MAT4850 <br/>';
    html += '<input type="checkbox" name="ELECTIVES" value="MAT4860"/> MAT4860 <br/>';

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
