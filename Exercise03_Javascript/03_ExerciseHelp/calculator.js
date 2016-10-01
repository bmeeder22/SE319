// CALCULATOR.JS
//
//
//

// 
var Calc = {

Model : {
  memory : undefined,
  operator : undefined,
  result : undefined
},


View : {
  textRow : {id: "textRow", type: "text", value: "", onclick:""},
  button0 : {id: "button7", type: "button", value: 0, onclick:""},
  button1 : {id: "button7", type: "button", value: 1, onclick:""},
  button2 : {id: "button7", type: "button", value: 2, onclick:""},
  button3 : {id: "button7", type: "button", value: 3, onclick:""},
  button4 : {id: "button7", type: "button", value: 4, onclick:""},
  button5 : {id: "button7", type: "button", value: 5, onclick:""},
  button6 : {id: "button7", type: "button", value: 6, onclick:""},
  button7 : {id: "button7", type: "button", value: 7, onclick:""},
  button8 : {id: "button8", type: "button", value: 8, onclick:""},
  button9 : {id: "button9", type: "button", value: 9, onclick:""},

  plusButton : {id: "plusButton", type: "button", value: "+", onclick:""},
  minusButton : {id: "minusButton", type: "button", value: "-", onclick:""},
  starButton : {id: "starButton", type: "button", value: "*", onclick:""},
  decimalButton : {id: "decimalButton", type: "button", value: ".", onclick:""},
  equalButton : {id: "equalButton", type: "button", value: "=", onclick:""},
  slashButton : {id: "slashButton", type: "button", value: "/", onclick:""},

  clearButton : {id: "clearButton", type: "button", value: "C", onclick:""},
  showMemoryButton : {id: "showMemoryButton", type: "button", value: "MR", onclick:""},
  subtractFromMemoryButton : {id: "subtractFromMemoryButton", type: "button", value: "M-", onclick:""},
  addToMemoryButton : {id: "addToMemoryButton", type: "button", value: "M+", onclick:""},
  clearMemoryButton : {id: "clearMemoryButton", type: "button", value: "MC", onclick:""}
},

Controller : {
  calculateElements : function() {
    if (Calc.Model.operator !== undefined) {
      //TODO: Calculate whatever the operation is
      console.log("Calculating elements.");

      var num1 = 0;
      if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
        num1 = parseFloat(Calc.Model.result);
      }
      var num2 = parseFloat(Calc.View.textRow.value);

      if (Calc.Model.operator === "+") {
        var sum = num1 + num2;
        console.log(num1 + " + " + num2 + " = " + sum);
        Calc.Model.result = sum.toString();
      }
      else if (Calc.Model.operator === "-") {
        var diff = num1 - num2;
        console.log(num1 + " - " + num2 + " = " + diff);
        Calc.Model.result = diff.toString();
      }
      else if (Calc.Model.operator === "*") {
        var product = num1 * num2;
        console.log(num1 + " * " + num2 + " = " + product);
        Calc.Model.result = product.toString();
      }
      else if (Calc.Model.operator === "/") {
        var quotient = num1 / num2;
        console.log(num1 + " / " + num2 + " = " + quotient);
        Calc.Model.result = quotient.toString();
      }

      Calc.View.textRow.value = Calc.Model.result;
      console.log("Result: " + Calc.Model.result);
      Calc.Controller.updateTextRow();
    }
  },

  updateTextRow : function() {
    document.getElementById("textRow").value = Calc.View.textRow.value;
  }
},

run : function() {
  Calc.attachHandlers();
  console.log(Calc.display());
  return Calc.display();
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
  s += "<tr><td>" + Calc.displayElement(Calc.View.textRow) + "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button7);
  s += Calc.displayElement(Calc.View.button8);
  s += Calc.displayElement(Calc.View.button9);
  s += Calc.displayElement(Calc.View.plusButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button4);
  s += Calc.displayElement(Calc.View.button5);
  s += Calc.displayElement(Calc.View.button6);
  s += Calc.displayElement(Calc.View.minusButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button1);
  s += Calc.displayElement(Calc.View.button2);
  s += Calc.displayElement(Calc.View.button3);
  s += Calc.displayElement(Calc.View.starButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button0);
  s += Calc.displayElement(Calc.View.decimalButton);
  s += Calc.displayElement(Calc.View.equalButton);
  s += Calc.displayElement(Calc.View.slashButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.clearButton);
  s += Calc.displayElement(Calc.View.showMemoryButton);
  s += Calc.displayElement(Calc.View.subtractFromMemoryButton);
  s += Calc.displayElement(Calc.View.addToMemoryButton);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.clearMemoryButton);
  s += "</tr></td></table>";
  return s;
},

attachHandlers : function() {
  Calc.View.button0.onclick = "Calc.button0Handler()";
  Calc.View.button1.onclick = "Calc.button1Handler()";
  Calc.View.button2.onclick = "Calc.button2Handler()";
  Calc.View.button3.onclick = "Calc.button3Handler()";
  Calc.View.button4.onclick = "Calc.button4Handler()";
  Calc.View.button5.onclick = "Calc.button5Handler()";
  Calc.View.button6.onclick = "Calc.button6Handler()";
  Calc.View.button7.onclick = "Calc.button7Handler()";
  Calc.View.button8.onclick = "Calc.button8Handler()";
  Calc.View.button9.onclick = "Calc.button9Handler()";

  Calc.View.plusButton.onclick ="Calc.plusButtonHandler()";
  Calc.View.minusButton.onclick ="Calc.minusButtonHandler()";
  Calc.View.starButton.onclick ="Calc.starButtonHandler()";
  Calc.View.decimalButton.onclick ="Calc.decimalButtonHandler()";
  Calc.View.equalButton.onclick ="Calc.equalButtonHandler()";
  Calc.View.slashButton.onclick ="Calc.slashButtonHandler()";

  Calc.View.clearButton.onclick ="Calc.clearButtonHandler()";
  Calc.View.showMemoryButton.onclick ="Calc.showMemoryButtonHandler()";
  Calc.View.subtractFromMemoryButton.onclick ="Calc.subtractFromMemoryButtonHandler()";
  Calc.View.addToMemoryButton.onclick ="Calc.addToMemoryButtonHandler()";
  Calc.View.clearMemoryButton.onclick ="Calc.clearMemoryButtonHandler()";
},

button0Handler : function() {
  Calc.View.textRow.value += 0;
  Calc.Controller.updateTextRow();
},

button1Handler : function() {
  Calc.View.textRow.value += 1;
  Calc.Controller.updateTextRow();
},

button2Handler : function() {
  Calc.View.textRow.value += 2;
  Calc.Controller.updateTextRow();
},

button3Handler : function() {
  Calc.View.textRow.value += 3;
  Calc.Controller.updateTextRow();
},

button4Handler : function() {
  Calc.View.textRow.value += 4;
  Calc.Controller.updateTextRow();
},

button5Handler : function() {
  Calc.View.textRow.value += 5;
  Calc.Controller.updateTextRow();
},

button6Handler : function() {
  Calc.View.textRow.value += 6;
  Calc.Controller.updateTextRow();
},

button7Handler : function() {
  Calc.View.textRow.value += 7;
  Calc.Controller.updateTextRow();
},

button8Handler : function() {
  Calc.View.textRow.value += 8;
  Calc.Controller.updateTextRow();
},

button9Handler : function() {
  Calc.View.textRow.value += 9;
  Calc.Controller.updateTextRow();
},

plusButtonHandler : function() {
  console.log("Plus Button Pressed.");
  Calc.Model.operator = "+";
  if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
    Calc.Controller.calculateElements();
  } else {
    Calc.Model.result = Calc.View.textRow.value;
    Calc.View.textRow.value = "";
    Calc.Controller.updateTextRow();
  }
},

minusButtonHandler : function() {
  console.log("Minus Button Pressed.");
  Calc.Model.operator = "-";
  if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
    Calc.Controller.calculateElements();
  } else {
    Calc.Model.result = Calc.View.textRow.value;
    Calc.View.textRow.value = "";
    Calc.Controller.updateTextRow();
  }
},

starButtonHandler : function() {
  console.log("Star Button Pressed.");
  Calc.Model.operator = "*";
  if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
    Calc.Controller.calculateElements();
  } else {
    Calc.Model.result = Calc.View.textRow.value;
    Calc.View.textRow.value = "";
    Calc.Controller.updateTextRow();
  }
},

decimalButtonHandler : function() {
  console.log("Decimal Button Pressed.");
  if (!Calc.View.textRow.value.includes(".")) { //Don't allow the user to input multiple decimal points
    Calc.View.textRow.value += ".";
    Calc.Controller.updateTextRow();
  }
},

equalButtonHandler : function() {
  console.log("Equal Button Pressed.");
  Calc.Model.result = Calc.Controller.calculateElements();
},

slashButtonHandler : function(){
  console.log("Slash Button Pressed.");
  Calc.Model.operator = "/";
  if (Calc.Model.result !== undefined && Calc.Model.result !== "") {
    Calc.Controller.calculateElements();
  } else {
    Calc.Model.result = Calc.View.textRow.value;
    Calc.View.textRow.value = "";
    Calc.Controller.updateTextRow();
  }
},

clearButtonHandler : function() {
  console.log("Clear Button Pressed.")
  Calc.Model.result = "";
  Calc.View.textRow.value = "";
  Calc.Controller.updateTextRow();
},

showMemoryButtonHandler : function() {

},

subtractFromMemoryButtonHandler : function() {

},

addToMemoryButtonHandler : function() {
  
},

clearMemoryButtonHandler : function() {

}

} // end of Calc;
