let now_date = new Date();

const comparison_date = now_date.getFullYear() + "/" + (now_date.getMonth() + 1) + "/" + (now_date.getDate() - 2);

console.log("きょうの日付" + comparison_date);

function comparison(plan, idname) {
	console.log("今日の日付" + comparison_date + "比較日付：" + plan);
	if (new Date(comparison_date) > new Date(plan)) {
		var obj = document.getElementById(idname);
		obj.style.backgroundColor = '#ff2020';
		console.log(new Date(comparison_date) > new Date(plan));
	} else {
		console.log(new Date(comparison_date) > new Date(plan));
		var obj = document.getElementById(idname);
		obj.style.backgroundColor = '#fff450';
	}

}

window.onload = function() {
	const elements = document.getElementsByClassName('rental');
	let i = 0;
	console.log(elements.length)
	console.log(elements)
	for (let step = 0; step < elements.length; step++) {
		comparison(elements[step].name, elements[step].id);
	}
}