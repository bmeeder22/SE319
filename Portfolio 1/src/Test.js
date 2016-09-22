import React, { Component } from 'react';
import './App.css';

class Main extends Component {
    constructor() {
        super();

        this.state = {
            values: [0,0,0,0,0,0,0,0,0],
            playerTurn: 1
        };
    }

    checkCatsgame() {
        for(var i = 0; i<9; i++) {
            if(this.state.values[i] === 0)
                return false;
        }
        return true;
    }

    checkRow(rowNum) {
        var num = this.state.values[rowNum];
        for(var i = rowNum; i<rowNum+3; i++) {
            if(this.state.values[i] != num) return false;
        }
        return true;
    }

    checkCol(colNum) {
        var num = this.state.values[colNum];
        for(var i = colNum; i<9; i+=3) {
            if(this.state.values[i] != num) return false;
        }
        return true;
    }

    checkWin() {

        console.log(this.checkRow(3));

        // if (this.checkRow(0) || this.checkRow(3) || this.checkRow(6)) console.log("1WIN!");
        //
        // else if(this.checkCol(0) || this.checkCol(1) || this.checkCol(2)) console.log("2WIN!");
        //
        // else if(this.checkCatsgame()) console.log("CATS");
    }

    handleButtonPressed(number) {
        var newState = this.state.values;
        if(this.state.playerTurn === 1) {
            newState[number-1] = 1;
            this.setState({values: newState, playerTurn: 2}, this.checkWin(number));
        }
        else {
            newState[number-1] = 2;
            this.setState({values: newState, playerTurn: 1}, this.checkWin(number));
        }
    }

    render() {
        return (
          <div id="board">
              <div id="row1">
                  <Square num="1" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                  <Square num="2" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                  <Square num="3" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
              </div>
              <div id="row2">
                  <Square num="4" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                  <Square num="5" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                  <Square num="6" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
              </div>
              <div id="row3">
                  <Square num="7" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                  <Square num="8" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                  <Square num="9" turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
              </div>
          </div>
        );
    }
}

class Square extends Component {
    constructor() {
        super();

        this.state = {
            displayValue: "-"
        };

        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        if(this.state.displayValue !== "-") return;

        if(this.props.turn === 1)
            this.setState({displayValue: "X"});
        else
            this.setState({displayValue: "O"});

        this.props.click(this.props.num);
    }

    render() {
        return (
            <button id="test" onClick={this.handleClick}>
                {this.state.displayValue}
            </button>
        );
    }
}



export default Main;
