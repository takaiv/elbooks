function change(obj) {
    result = document.getElementById("result");

    index = obj.selectedIndex;

    value = obj.options[index].value;

    result.innerText = value + "の値が表示されています。";

}