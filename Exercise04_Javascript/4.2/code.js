$(document).ready(function() {
	//Setup page
	$("#hiddenText").hide();
	$("#toggle2").toggle();
	$("#crawlRight").animate(
		{
			left: "+=1000"
		},
		100000,
		function() {
			console.log("Circle travelled right!");
	});


		$("#textColorExample").click( function() {
			console.log("Changing text color.");
			var currentColor = $(this).css("color");
			if (currentColor === "rgb(0, 0, 255)") { //blue -> red
				$(this).css("color", "red");
			} else if (currentColor === "rgb(255, 0, 0)") { //red -> green
				$(this).css("color", "green");
			} else if (currentColor === "rgb(0, 128, 0)") { //green -> blue
				$(this).css("color", "blue");
			}
		});

		$("#colorButton").click( function() {
			console.log("Button pressed.");
        	$("p").css("color","red").show();
		});

		$("#textSizeExample").mouseover(function() {
			console.log("Toggling text size.");
			var currentSize = $(this).css("font-size");
			console.log("Current Size: " + currentSize);
			if (currentSize === "18.72px") {
				$(this).css("font-size", "50px");
			} else if (currentSize === "50px") {
				$(this).css("font-size", "18.72px")
			}
		});

		$("#backGroundColorExample").dblclick( function() {
			$(this).css("background-color", "green");
		});

		$("#changeFontExample").click( function() {
			$(this).css("font-family", "courier");
			$(this).html("That's much better. Thank you kind traveller!");
		});

		$("#cursorExample").click( function() {
			$(this).css("cursor", "wait");
		});

		$("#unhideTextButton").click( function() {
			$("#hiddenText").show();
		});

		$("#shyText").click( function() {
			$(this).animate(
			{
				left: "300px",
				opacity: 0
			},
			1000,
			function() {
				console.log("Done!");
			});
		});

		$("#upButton").click( function() {
			$("#blueBox").animate(
			{
				bottom: "+=100"
			},
			500,
			function() {
				console.log("Blue Box travelled up!");
			});
		});

		$("#downButton").click( function() {
			$("#blueBox").animate(
			{
				bottom: "-=100"
			},
			500,
			function() {
				console.log("Blue Box travelled down!");
			});
		});

		$("#blurryText").blur( function() {
			var name = $(this).val();
			console.log("name: " + name);
			$("#name").html("Hello " + name);
		});

		$("#toggleTextButton").click( function() {
			$("#toggle1").slideToggle();
			$("#toggle2").slideToggle();
		});

		$("#stopButton").click( function() {
			$("#crawlRight").stop();
		});

		$("#switchColorOnChange").change( function() {
			console.log("Changing input color.");
			var currentColor = $(this).css("color");
			if (currentColor === "rgb(0, 0, 255)") { //blue -> red
				$(this).css("color", "red");
			} else if (currentColor === "rgb(255, 0, 0)") { //red -> green
				$(this).css("color", "green");
			} else if (currentColor === "rgb(0, 128, 0)") { //green -> blue
				$(this).css("color", "blue");
			}
		});

    }); // end of ready