let balls = document.getElementsByClassName('eye_black');
document.onmousemove = function (event) {
    let x = event.x *75;
    let y = event.y *75;
    for (let i = 0; i<2; i++) {
        balls[i].style.x = x;
        balls[i].style.y = y;
    }
}