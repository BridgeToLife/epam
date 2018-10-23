menu.onclick = function menuFunction(){

    var x = document.getElementById("top_nav_menu");

    if(x.className === "top_nav") {
        x.className += " responsive";
    } else {
        x.className = "top_nav";
    }
}


