window.x = 100;
window.y = 100;

window.xAdd = 1;
window.yAdd = 0;

window.direction = "right";

window.running = false;

(function(){
    var canvas = document.getElementById("myCanvas");
    if(canvas != null && window.running == true) {
        window.x += window.xAdd;
        window.y += window.yAdd;
        var context = canvas.getContext("2d");
        context.beginPath();

        context.rect(window.x, window.y, 5, 5);
        context.fillStyle = "red";
        context.fill();
    }

    setTimeout(arguments.callee, 50);
})();

function right() {
    window.xAdd = 1;
    window.yAdd = 0;

    window.direction = "right";
}

function left() {
    window.xAdd = -1;
    window.yAdd = 0;

    window.direction = "left";
}

function up() {
    window.xAdd = 0;
    window.yAdd = -1;

    window.direction = "up";
}

function down() {
    window.xAdd = 0;
    window.yAdd = 1;

    window.direction = "down";
}

function handleLeft() {
    if(window.direction == "right") {
        up();
    }
    else if(window.direction == "left") {
        down();
    }
    else if(window.direction == "up") {
        left();
    }
    else if(window.direction == "down") {
        right();
    }
}

function hanleRight() {
    if(window.direction == "right") {
        down();
    }
    else if(window.direction == "left") {
        up();
    }
    else if(window.direction == "up") {
        right();
    }
    else if(window.direction == "down") {
        left();
    }
}

function toggle() {
    var button = document.getElementById("startstop");
    if(window.running) {
        button.innerHTML = "start";
        window.running = false;
    }
    else{
        button.innerHTML = "stop";
        window.running = true;
    }
}

function stop() {
    window.running = false;
}

function start() {
    window.running = true;
}