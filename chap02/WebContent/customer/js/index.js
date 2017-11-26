function Toseat(r) {
	window.open("manager/seat.jsp")
}
function Toseat1(r) {
	window.open("customer/seat.jsp")
}
function deleteRow(r) {
	console.log("dfj");
	con = confirm("确定要删除吗？");
	if (con == true) {
		var i = r.parentNode.parentNode.rowIndex;
		document.getElementById('tab').deleteRow(i);
	}
}

var td = new Array();
var tdNode = new Array();

function ModifyRow(r) {

	console.log(r);
	for (var i = 1; i <= 5; i++) {
		td[i] = r.parentNode.parentNode.childNodes[2 * i - 1];
		td[i].contentEditable = "true";

	}
	td[1].focus();

	r.onclick = function() {
		modifynode(this);
		alert("修改成功");
	};

}

function modifynode(r) {
	// alert("cheng");
	for (var j = 1; j <= 5; j++) {
		// tdNode[j];
		tdNode[j] = r.parentNode.parentNode.childNodes[2 * j - 1].textContent;
		console.log(tdNode[j]);
		td[j].contentEditable = "false";
	}
}

function ModifyRow1(r) {

	console.log(r);
	for (var i = 0; i < 5; i++) {
		td[i] = r.parentNode.parentNode.childNodes[i];
		td[i].contentEditable = "true";

	}
	td[0].focus();

	r.onclick = function() {
		console.log("shibai");
		modifynode1(this);
		alert("修改成功");
	};

}

function modifynode1(r) {
	// alert("cheng");
	for (var j = 0; j < 5; j++) {
		// tdNode[j];
		tdNode[j] = r.parentNode.parentNode.childNodes[j].textContent;
		console.log(tdNode[j]);
		td[j].contentEditable = "false";
	}
}

function add() {
	var num = document.getElementById('recipient-name1');
	var name = document.getElementById('recipient-name2');
	var row = document.getElementById('recipient-name3');
	var col = document.getElementById('recipient-name4');
	var sss = document.getElementById('recipient-name5');
	var tab = document.getElementById('tab');
	var tbody = document.getElementById("tbody");
	var tr = document.createElement("tr");

	var td1 = document.createElement("td");
	var num1 = document.createTextNode(num.value);
	td1.appendChild(num1);

	var td2 = document.createElement("td");
	var name1 = document.createTextNode(name.value);
	td2.appendChild(name1);

	var td3 = document.createElement("td");
	var row1 = document.createTextNode(row.value);
	td3.appendChild(row1);

	var td4 = document.createElement("td");
	var col1 = document.createTextNode(col.value);
	td4.appendChild(col1);

	var td5 = document.createElement("td");
	var info1 = document.createTextNode(sss.value);
	td5.appendChild(info1);

	var td6 = document.createElement("td");

	var btn1 = document.createElement("button");
	var i1 = document.createElement("i");
	var i11 = document.createTextNode("");
	i1.appendChild(i11);
	btn1.appendChild(i1);
	td6.appendChild(btn1);

	var td7 = document.createElement("td");
	var btn2 = document.createElement("button");
	var i2 = document.createElement("i");
	var i22 = document.createTextNode("");
	i2.appendChild(i22);
	btn2.appendChild(i2);
	td7.appendChild(btn2);

	var td8 = document.createElement("td");
	var btn3 = document.createElement("button");
	var i3 = document.createElement("i");
	var i33 = document.createTextNode("");
	i3.appendChild(i33);
	btn3.appendChild(i3);
	td8.appendChild(btn3);

	// btn.addClass('layui-btn');
	// i.
	i1.className = "layui-icon";
	btn1.className = "layui-btn";
	btn1.className += " layui-btn-warm";
	btn1.className += " layui-btn-radius";
	btn1.onclick = function() {

		ModifyRow1(this);

	}

	i2.className = "layui-icon";
	btn2.className = "layui-btn";
	btn2.className += " layui-btn-danger";
	btn2.className += " layui-btn-radius";
	btn2.onclick = function() {
		deleteRow(this);
	}
	i3.className = "layui-icon";
	btn3.className = "layui-btn";
	btn3.className += " layui-btn-radius";
	btn3.onclick = function() {
		Toseat(this);
	}
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	tr.appendChild(td7);
	tr.appendChild(td8);
	tbody.appendChild(tr)
	tab.appendChild(tbody);
	tr.className = "success";
}

function checkid() {
	var id = document.getElementById('recipient-name1');
	if (!/^[0-9]{1,}$/.test(id.value)) {
		document.getElementById('name1_img').innerHTML = "<img src='images/error.png' />";
		document.getElementById("name1_tip").innerHTML = "请输入数字编号！";
		id.focus();
		return false;
	} else {
		document.getElementById('name1_img').innerHTML = "<img src='images/right.png'/>";
		document.getElementById("name1_tip").innerHTML = "";
		return true;
	}
}
function name2() {
	var name = document.getElementById('recipient-name2');
	if (!/^[0-9\u4e00-\u9fa5]{2,20}$/.test(name.value)) {
		document.getElementById('name2_img').innerHTML = "<img src='images/error.png' />";
		document.getElementById("name2_tip").innerHTML = "请输入中文汉字不超过20个字！";
		name.focus();
		return false;
	} else {
		document.getElementById('name2_img').innerHTML = "<img src='images/right.png' />";
		document.getElementById("name2_tip").innerHTML = "";
		return true;
	}
}
function name3() {
	var row = document.getElementById('recipient-name3');
	if (!/^[0-9]{1,}$/.test(row.value)) {
		document.getElementById('name3_img').innerHTML = "<img src='images/error.png' />";
		document.getElementById("name3_tip").innerHTML = "请输入数字！";
		row.focus();
		return false;
	} else {
		document.getElementById('name3_img').innerHTML = "<img src='images/right.png' />";
		document.getElementById("name3_tip").innerHTML = "";
		return true;
	}
}
function name4() {
	var col = document.getElementById('recipient-name4');
	if (!/^[0-9]{1,}$/.test(col.value)) {
		document.getElementById('name4_img').innerHTML = "<img src='images/error.png' />";
		document.getElementById("name4_tip").innerHTML = "请输入数字！";
		col.focus();
		return false;
	} else {
		document.getElementById('name4_img').innerHTML = "<img src='images/right.png' />";
		document.getElementById("name4_tip").innerHTML = "";
		return true;
	}
}
function name5() {
	var info = document.getElementById('recipient-name4');
	if (!/^[0-9\u4e00-\u9fa5]{2,50}$/.test(info.value)) {
		document.getElementById('name5_img').innerHTML = "<img src='images/error.png' />";
		document.getElementById("name5_tip").innerHTML = "请输入不超过50字的描述！";
		info.focus();
		return false;
	} else {
		document.getElementById('name5_img').innerHTML = "<img src='images/right.png' />";
		document.getElementById("name5_tip").innerHTML = "";
		return true;
	}
}
