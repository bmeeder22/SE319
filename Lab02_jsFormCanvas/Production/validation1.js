function validate() {
	var paras = document.getElementsByClassName("image");

	while(paras[0]) {
    	paras[0].parentNode.removeChild(paras[0]);
	}

	var firstName = document.getElementById("FirstName").value;
	var lastName = document.getElementById("LastName").value;
	var gender = document.getElementById("Gender").value;
	var state = document.getElementById("State").value;

	var errors = false;
	var mainError = false;

	errors = checkNonEmpty(firstName,1);
	if(errors) mainError = true;
	errors = checkNonEmpty(lastName,2);
	if(errors) mainError = true;
	errors = checkNonEmpty(gender,3);
	if(errors) mainError = true;
	errors = checkNonEmpty(state,4);
	if(errors) mainError = true;
	
	if(!mainError) {
		var text = "firstName=" + firstName + ";lastName=" + lastName + ";gender=" + gender + ";state=" + state + ";";
		document.cookie = text;
	}
	else {
		return;
	}

	window.location = "file:///Users/benjaminmeeder/Documents/School/SE%20319/Lab02_jsFormCanvas/Production/validation2.html";
}

function checkNonEmpty(s, div) {
	if(s == null || s == "") {
		var el = document.getElementById("div" + div);
		var node = document.createElement("img");
		node.className = "image";
		node.src = "wrong.png";

		el.appendChild(node);
		return true;
	}
	else {
		var el = document.getElementById("div" + div);
		var node = document.createElement("img");
		node.className = "image";
		node.src = "correct.png";

		el.appendChild(node);
		return false;
	}
}
