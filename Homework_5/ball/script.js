let canvas = document.getElementById("Canvas");
let context = canvas.getContext("2d");
let radius = 15;
let deltaX = 4;
let deltaY = 5;
let x = Math.floor(Math.random() * (300 - 30)) + 30;
let y = Math.floor(Math.random() * (580 - 30)) + 30;

function drawBall() {
    context.beginPath();
    context.arc(x, y, radius, 3.4, 3.14*2);
    context.fillStyle = "pink";
    context.fill();
    context.closePath();
}

function draw() {
    context.clearRect(0, 0, canvas.width, canvas.height);
    drawBall();

    if(x > canvas.width-radius - deltaX|| x + deltaX < 5) {
        deltaX = -deltaX;
    }
    if(y > canvas.height-radius-deltaY || y + deltaY < 5) {
        deltaY = -deltaY;
    }

    x += deltaX;
    y += deltaY;
}

setInterval(draw, 5);