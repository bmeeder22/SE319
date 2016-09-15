window.x = 100;
window.y = 100;

window.xAdd = 10;
window.yAdd = 0;

window.direction = "right";

window.running = true;

(function(){
    window.x += window.xAdd;
    window.y += window.yAdd;

    var canvas = document.getElementById("myCanvas");
    if(canvas != null && window.running == true) {
        var context = canvas.getContext("2d");
        context.beginPath();

        context.rect(window.x, window.y, 20, 20);
        context.fillStyle = "red";
        context.fill();
    }

    setTimeout(arguments.callee, 1000);
})();

function right() {
    window.xAdd = 10;
    window.yAdd = 0;

    window.direction = "right";
}

function left() {
    window.xAdd = -10;
    window.yAdd = 0;

    window.direction = "left";
}

function up() {
    window.xAdd = 0;
    window.yAdd = -10;

    window.direction = "up";
}

function down() {
    window.xAdd = 0;
    window.yAdd = 10;

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

function stop() {
    window.running = false;
}

function start() {

}