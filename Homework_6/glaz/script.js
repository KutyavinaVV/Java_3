document.onmousemove = function (event){
    let x = event.x - 40;
    let y = event.y - 40;
    if (x*x + y*y <= 1600) {
        document.querySelector('.eye2').style.transform = 'rotate(' + grad(x - 96, y) + 'deg)';
    }
    else if ((x-96)*(x-96) + y*y <= 1600) {
        document.querySelector('.eye1').style.transform = 'rotate(' + grad(x, y) + 'deg)';
    }
    else {

        document.querySelector('.eye1').style.transform = 'rotate(' + grad(x, y) + 'deg)';
        document.querySelector('.eye2').style.transform = 'rotate(' + grad(x - 96, y) + 'deg)';
    }

    function grad(x, y) {
        if(x>=0) return 57.2958*Math.atan(y/x);
        else return 57.2958*(Math.atan(y/x)+Math.PI);
    }

}