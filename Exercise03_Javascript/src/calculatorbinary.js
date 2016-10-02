// CALCULATORBINARY.JS
//
//
//

// 
var BinCalc = {

Model : {
  memory : undefined,
  operator : undefined,
  result : undefined
},


View : {
  binTextRow : {id: "binTextRow", type: "text", value: "", onclick:""},
  button0 : {id: "button0", type: "button", value: 0, onclick:""},
  button1 : {id: "button1", type: "button", value: 1, onclick:""},
  tildeButton : {id: "tildeButton", type: "button", value: "~", onclick:""},

  plusButton : {id: "plusButton", type: "button", value: "+", onclick:""},
  minusButton : {id: "minusButton", type: "button", value: "-", onclick:""},
  starButton : {id: "starButton", type: "button", value: "*", onclick:""},
  equalButton : {id: "equalButton", type: "button", value: "=", onclick:""},
  slashButton : {id: "slashButton", type: "button", value: "/", onclick:""},
  leftArrowButton : {id: "leftArrowButton", type: "button", value: "<<", onclick:""},
  rightArrowButton : {id: "rightArrowButton", type: "button", value: ">>", onclick:""},
  ampersandButton : {id: "ampersandButton", type: "button", value: "&", onclick:""},
  pipeButton : {id: "pipeButton", type: "button", value: "|", onclick:""},

  clearButton : {id: "clearButton", type: "button", value: "C", onclick:""},
  showMemoryButton : {id: "showMemoryButton", type: "button", value: "MR", onclick:""},
  subtractFromMemoryButton : {id: "subtractFromMemoryButton", type: "button", value: "M-", onclick:""},
  addToMemoryButton : {id: "addToMemoryButton", type: "button", value: "M+", onclick:""},
  clearMemoryButton : {id: "clearMemoryButton", type: "button", value: "MC", onclick:""}
},

Controller : {
  calculateElements : function() {
    if (BinCalc.Model.operator !== undefined) {
      console.log("Calculating elements.");

      var num1 = 0;
      if (BinCalc.Model.result !== undefined && BinCalc.Model.result !== "") {
        num1 = parseInt(BinCalc.Model.result, 2);
      }
      var num2 = parseInt(BinCalc.View.binTextRow.value, 2);

      if (BinCalc.Model.operator === "+") {
        var sum = num1 + num2;
        console.log(num1 + " + " + num2 + " = " + sum);
        BinCalc.Model.result = sum.toString(2);
      }
      else if (BinCalc.Model.operator === "-") {
        var diff = num1 - num2;
        console.log(num1 + " - " + num2 + " = " + diff);
        BinCalc.Model.result = diff.toString(2);
      }
  //     else if (BinCalc.Model.operator === "*") {
  //       var product = num1 * num2;
  //       console.log(num1 + " * " + num2 + " = " + product);
  //       Calc.Model.result = product.toString();
  //     }
  //     else if (BinCalc.Model.operator === "/") {
  //       var quotient = num1 / num2;
  //       console.log(num1 + " / " + num2 + " = " + quotient);
  //       Calc.Model.result = quotient.toString();
  //     }

      BinCalc.View.binTextRow.value = BinCalc.Model.result;
      console.log("Result: " + BinCalc.Model.result);
      BinCalc.Controller.updateTextRow();
    }
  },

  updateTextRow : function() {
    document.getElementById("binTextRow").value = BinCalc.View.binTextRow.value;
  }
},

run : function() {
  BinCalc.attachHandlers();
  console.log(BinCalc.display());
  return BinCalc.display();
},


displayElement : function (element) {
  var s = "<input ";
  s += " id=\"" + element.id + "\"";
  s += " type=\"" + element.type + "\"";
  s += " value= \"" + element.value + "\"";
  s += " onclick= \"" + element.onclick + "\"";
  s += ">";
  return s;

},

display : function() {
  var s;
  s = "<table id=\"myTable\" border=2>"
  s += "<tr><td>" + BinCalc.displayElement(BinCalc.View.binTextRow) + "</td></tr>";
  s += "<tr><td>";
  s += BinCalc.displayElement(BinCalc.View.button1);
  s += BinCalc.displayElement(BinCalc.View.button0);
  s += BinCalc.displayElement(BinCalc.View.tildeButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += BinCalc.displayElement(BinCalc.View.plusButton);
  s += BinCalc.displayElement(BinCalc.View.leftArrowButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += BinCalc.displayElement(BinCalc.View.rightArrowButton);
  s += BinCalc.displayElement(BinCalc.View.minusButton);
  s += BinCalc.displayElement(BinCalc.View.ampersandButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += BinCalc.displayElement(BinCalc.View.pipeButton);
  s += BinCalc.displayElement(BinCalc.View.starButton);
  s += BinCalc.displayElement(BinCalc.View.slashButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += BinCalc.displayElement(BinCalc.View.showMemoryButton);
  s += BinCalc.displayElement(BinCalc.View.subtractFromMemoryButton);
  s += BinCalc.displayElement(BinCalc.View.addToMemoryButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += BinCalc.displayElement(BinCalc.View.clearButton);
  s += BinCalc.displayElement(BinCalc.View.clearMemoryButton);
  s += BinCalc.displayElement(BinCalc.View.equalButton);
  s += "</tr></td></table>";
  return s;
},

attachHandlers : function() {
  BinCalc.View.button0.onclick = "BinCalc.button0Handler()";
  BinCalc.View.button1.onclick = "BinCalc.button1Handler()";
  BinCalc.View.tildeButton.onclick = "BinCalc.tildeButtonHandler()";

  BinCalc.View.plusButton.onclick = "BinCalc.plusButtonHandler()";
  BinCalc.View.leftArrowButton.onclick = "BinCalc.leftArrowButtonHandler()";

  BinCalc.View.rightArrowButton.onclick = "BinCalc.rightArrowButtonHandler()";
  BinCalc.View.minusButton.onclick = "BinCalc.minusButtonHandler()";
  BinCalc.View.ampersandButton.onclick = "BinCalc.ampersandButtonHandler()";

  BinCalc.View.pipeButton.onclick = "BinCalc.pipeButtonHandler()";
  BinCalc.View.starButton.onclick = "BinCalc.starButtonHandler()";
  BinCalc.View.slashButton.onclick = "BinCalc.slashButtonHandler()";

  BinCalc.View.showMemoryButton.onclick = "BinCalc.showMemoryButtonHandler()";
  BinCalc.View.subtractFromMemoryButton.onclick = "BinCalc.subtractFromMemoryButtonHandler()";
  BinCalc.View.addToMemoryButton.onclick = "BinCalc.addToMemoryButtonHandler()";

  BinCalc.View.clearButton.onclick = "BinCalc.clearButtonHandler()";
  BinCalc.View.clearMemoryButton.onclick = "BinCalc.clearMemoryButtonHandler()";
  BinCalc.View.equalButton.onclick = "BinCalc.equalButtonHandler()";
},

button0Handler : function() {
  BinCalc.View.binTextRow.value += 0;
  BinCalc.Controller.updateTextRow();
},

button1Handler : function() {
  BinCalc.View.binTextRow.value += 1;
  BinCalc.Controller.updateTextRow();
},

tildeButtonHandler : function() {
  console.log("Tilde Button Pressed.");
},

plusButtonHandler : function() {
  console.log("Plus Button Pressed.");
  BinCalc.Model.operator = "+";
  if (BinCalc.Model.result !== undefined && BinCalc.Model.result !== "") {
    BinCalc.Controller.calculateElements();
  } else {
    BinCalc.Model.result = BinCalc.View.binTextRow.value;
    BinCalc.View.binTextRow.value = "";
    BinCalc.Controller.updateTextRow();
  }
},

leftArrowButtonHandler : function() {
  console.log("Left Arrow Button Pressed.");
},

rightArrowButtonHandler : function() {
  console.log("Right Arrow Button Pressed.");
},

minusButtonHandler : function() {
  console.log("Minus Button Pressed.");
  BinCalc.Model.operator = "-";
  if (BinCalc.Model.result !== undefined && BinCalc.Model.result !== "") {
    BinCalc.Controller.calculateElements();
  } else {
    BinCalc.Model.result = BinCalc.View.binTextRow.value;
    BinCalc.View.binTextRow.value = "";
    BinCalc.Controller.updateTextRow();
  }
},

ampersandButtonHandler : function() {
  console.log("Ampersand Button Pressed.");
},

pipeButtonHandler : function() {
  console.log("Pipe Button Pressed.");
},

starButtonHandler : function() {
  console.log("Star Button Pressed.");
//   Calc.Model.operator = "*";
//   if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
//     Calc.Controller.calculateElements();
//   } else {
//     Calc.Model.result = Calc.View.textRow.value;
//     Calc.View.textRow.value = "";
//     Calc.Controller.updateTextRow();
//   }
},

slashButtonHandler : function(){
  console.log("Slash Button Pressed.");
//   Calc.Model.operator = "/";
//   if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
//     Calc.Controller.calculateElements();
//   } else {
//     Calc.Model.result = Calc.View.textRow.value;
//     Calc.View.textRow.value = "";
//     Calc.Controller.updateTextRow();
//   }
},

equalButtonHandler : function() {
  console.log("Equal Button Pressed.");
  BinCalc.Model.result = BinCalc.Controller.calculateElements();
},

clearButtonHandler : function() {
  console.log("Clear Button Pressed.")
  BinCalc.Model.result = "";
  BinCalc.View.binTextRow.value = "";
  BinCalc.Controller.updateTextRow();
},

showMemoryButtonHandler : function() {
//   console.log("Show Memory Button Pressed.");
//   Calc.View.textRow.value = Calc.Model.memory;
//   Calc.Controller.updateTextRow();
},

subtractFromMemoryButtonHandler : function() {
  console.log("Subtract From Memory Button Pressed.");
},

addToMemoryButtonHandler : function() {
  console.log("Add To Memory Button Pressed.");
  
//   if (Calc.View.textRow.value !== undefined && Calc.View.textRow.value !== "") {
//     var num1 = parseFloat(Calc.View.textRow.value);
//     var num2 = 0;
//     if (Calc.Model.memory !== undefined && Calc.Model.memory !== "") {
//       num2 = parseFloat(Calc.Model.memory);
    // }

//     var sum = num1 + num2;
//     Calc.Model.memory = sum.toString();
//   }
  
//   console.log("Memory : " + Calc.Model.memory);
// },

// clearMemoryButtonHandler : function() {
//   console.log("Clear Memory Button Pressed.");
//   Calc.Model.memory = "";
}

} // end of Calc;