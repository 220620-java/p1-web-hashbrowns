function openModel(modelName) {
    var i;
    var x = document.getElementsByClassName("model");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    document.getElementById(modelName).style.display = "block";
}