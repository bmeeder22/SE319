error = false;

function handleForm() {
    window.error = false;
	var paras = document.getElementsByClassName("image");

	while(paras[0]) {
    	paras[0].parentNode.removeChild(paras[0]);
	}

	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	var address = document.getElementById("address").value;

    addButtons(checkEmail(email), 1);
    addButtons(checkPhone(phone), 2);
    addButtons(checkAddress(address), 3);

    if(window.error == false) {
        address = address.replace(' ', '+');
        window.location = "https://www.google.com/maps/place/" + address;
    }
}

function addButtons(correct, divNum) {
    if(correct) {
        addRight(divNum);
    }
    else {
        addWrong(divNum);
    }
}

function checkEmail(email) {
	if(!checkNonEmpty(email)) {
		return false;
	}

	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function checkPhone(phone) {
	if(!checkNonEmpty(phone)) {
		return false;
	}

	phone = phone.replace(/\D/g, '');
	if (!phone.match(/\d{10,14}/)) return false;
	else if (phone.length != 10) return false;

	return true;
}

function checkAddress(address) {
	if(!checkNonEmpty(address)) {
			return false;
	}

	return true;
}

function addWrong(div) {
    window.error = true;
    var el = document.getElementById("div" + div);
    var node = document.createElement("img");
    node.className = "image";
    node.src = "wrong.png";

    el.appendChild(node);
}

function addRight(div) {
	var el = document.getElementById("div" + div);
	var node = document.createElement("img");
	node.className = "image";
	node.src = "correct.png";

	el.appendChild(node);
}

function checkNonEmpty(s) {
    return  s != null && s != "";
}