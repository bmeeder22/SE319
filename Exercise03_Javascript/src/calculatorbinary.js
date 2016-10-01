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
  //   if (Calc.Model.operator !== undefined) {
  //     //TODO: Calculate whatever the operation is
  //     console.log("Calculating elements.");

  //     var num1 = 0;
  //     if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
  //       num1 = parseFloat(Calc.Model.result);
  //     }
  //     var num2 = parseFloat(Calc.View.textRow.value);

  //     if (Calc.Model.operator === "+") {
  //       var sum = num1 + num2;
  //       console.log(num1 + " + " + num2 + " = " + sum);
  //       Calc.Model.result = sum.toString();
  //     }
  //     else if (Calc.Model.operator === "-") {
  //       var diff = num1 - num2;
  //       console.log(num1 + " - " + num2 + " = " + diff);
  //       Calc.Model.result = diff.toString();
  //     }
  //     else if (Calc.Model.operator === "*") {
  //       var product = num1 * num2;
  //       console.log(num1 + " * " + num2 + " = " + product);
  //       Calc.Model.result = product.toString();
  //     }
  //     else if (Calc.Model.operator === "/") {
  //       var quotient = num1 / num2;
  //       console.log(num1 + " / " + num2 + " = " + quotient);
  //       Calc.Model.result = quotient.toString();
  //     }

  //     Calc.View.textRow.value = Calc.Model.result;
  //     console.log("Result: " + Calc.Model.result);
  //     Calc.Controller.updateTextRow();
  //   }
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
},

button0Handler : function() {
  BinCalc.View.binTextRow.value += 0;
  BinCalc.Controller.updateTextRow();
},

button1Handler : function() {
  BinCalc.View.binTextRow.value += 1;
  BinCalc.Controller.updateTextRow();
},

// plusButtonHandler : function() {
//   console.log("Plus Button Pressed.");
//   Calc.Model.operator = "+";
//   if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
//     Calc.Controller.calculateElements();
//   } else {
//     Calc.Model.result = Calc.View.textRow.value;
//     Calc.View.textRow.value = "";
//     Calc.Controller.updateTextRow();
//   }
// },

// minusButtonHandler : function() {
//   console.log("Minus Button Pressed.");
//   Calc.Model.operator = "-";
//   if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
//     Calc.Controller.calculateElements();
//   } else {
//     Calc.Model.result = Calc.View.textRow.value;
//     Calc.View.textRow.value = "";
//     Calc.Controller.updateTextRow();
//   }
// },

// starButtonHandler : function() {
//   console.log("Star Button Pressed.");
//   Calc.Model.operator = "*";
//   if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
//     Calc.Controller.calculateElements();
//   } else {
//     Calc.Model.result = Calc.View.textRow.value;
//     Calc.View.textRow.value = "";
//     Calc.Controller.updateTextRow();
//   }
// },

// equalButtonHandler : function() {
//   console.log("Equal Button Pressed.");
//   Calc.Model.result = Calc.Controller.calculateElements();
// },

// slashButtonHandler : function(){
//   console.log("Slash Button Pressed.");
//   Calc.Model.operator = "/";
//   if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
//     Calc.Controller.calculateElements();
//   } else {
//     Calc.Model.result = Calc.View.textRow.value;
//     Calc.View.textRow.value = "";
//     Calc.Controller.updateTextRow();
//   }
// },

// clearButtonHandler : function() {
//   console.log("Clear Button Pressed.")
//   Calc.Model.result = "";
//   Calc.View.textRow.value = "";
//   Calc.Controller.updateTextRow();
// },

// showMemoryButtonHandler : function() {
//   console.log("Show Memory Button Pressed.");
//   Calc.View.textRow.value = Calc.Model.memory;
//   Calc.Controller.updateTextRow();
// },

// subtractFromMemoryButtonHandler : function() {
//   console.log("Subtract From Memory Button Pressed.");
// },

// addToMemoryButtonHandler : function() {
//   console.log("Add To Memory Button Pressed.");
  
//   if (Calc.View.textRow.value !== undefined && Calc.View.textRow.value !== "") {
//     var num1 = parseFloat(Calc.View.textRow.value);
//     var num2 = 0;
//     if (Calc.Model.memory !== undefined && Calc.Model.memory !== "") {
//       num2 = parseFloat(Calc.Model.memory);
//     }

//     var sum = num1 + num2;
//     Calc.Model.memory = sum.toString();
//   }
  
//   console.log("Memory : " + Calc.Model.memory);
// },

// clearMemoryButtonHandler : function() {
//   console.log("Clear Memory Button Pressed.");
//   Calc.Model.memory = "";
// }

} // end of Calc;