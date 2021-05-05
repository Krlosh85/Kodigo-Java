//Cada vez que se le de click a un botón este cambiará
//Su estilo a como que esta "seleccionado", incluyendo su valor
var manzana = document.getElementById("manzana").addEventListener("click", selectedButton(), false);

function selectedButton(selected){
    this.selected = selected;
    document.getElementById(selected).classList.add("img-food-selected");
}