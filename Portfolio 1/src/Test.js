import React, { Component } from 'react';
import './App.css';

class Main extends Component {
    constructor() {
        super();

        this.state = {
            values: [0,0,0,0,0,0,0,0,0],
            playerTurn: 1,
            gameOver: false
        };
    }

    checkCatsGame() {
        for(var i = 0; i<9; i++) {
            if(this.state.values[i] === 0)
                return false;
        }
        return !this.checkWin();
    }

    checkRow(rowNum) {
        var num = this.state.values[rowNum];
        for(var i = rowNum * 3; i<(rowNum * 3) + 3; i++) {
            if(this.state.values[i] !== num || this.state.values[i] === 0) return false;
        }
        return true;
    }

    checkCol(colNum) {
        var num = this.state.values[colNum];
        for(var i = colNum; i<9; i+=3) {
            if(this.state.values[i] !== num || this.state.values[i] === 0) return false;
        }
        console.log("Col " + colNum + " = true");
        return true;
    }

    checkLeftDiagonal() {
        var num = this.state.values[0];
        for(var i = 0; i<9; i+=4) {
            if(this.state.values[i] !== num || this.state.values[i] === 0) return false;
        }
        console.log("Left diagonal true");
        return true;
    }

    checkRightDiagonal() {
        var num = this.state.values[2];
        for(var i = 2; i<7; i+=2) {
            if(this.state.values[i] !== num || this.state.values[i] === 0) return false;
        }
        console.log("Right diagonal true");
        return true;
    }

    checkWin() {
        for (var i = 0; i < 3; i ++) {
            if (this.checkRow(i) || this.checkCol(i)) {
                return true;
            }
        }

        if (this.checkLeftDiagonal() || this.checkRightDiagonal()) {
            return true;
        }
    }

    handleButtonPressed(number) {
        if (this.state.gameOver) {
            console.log("Game already won. You cannot move.");
            return;
        }

        var newState = this.state.values;
        if(this.state.playerTurn === 1) {
            newState[number-1] = 1;
            var gameWon = this.checkWin();
            this.setState({values: newState, playerTurn: 2, gameOver: gameWon || this.checkCatsGame()});
        }
        else {
            newState[number-1] = 2;
            this.setState({values: newState, playerTurn: 1, gameOver: this.checkWin() || this.checkCatsGame()});
        }
    }

    resetGame() {
      console.log("Resetting game.");
      // this.setState({
      //   values: [0,0,0,0,0,0,0,0,0],
      //       playerTurn: 1,
      //       gameOver: false
      // });
    }

    render() {
        if (!this.state.gameOver) {
            return (
              <div id="board">
                <div id="title">
                    <h1>Tic Tac Toe</h1>
                </div>
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
                  <div id="reset">
                      <ResetButton turn={this.state.playerTurn} click={this.resetGame.bind(this)}/>
                  </div>
              </div>
            );
        } else if(this.checkCatsGame()) {
            return (
                <div id="board">
                <div id="title">
                    <h1>Tic Tac Toe</h1>
                </div>
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
                  <div id="gameover">
                    <h2>Cat's Game</h2>
                    <p>It's a tie!</p>
                  </div>
              </div>
              );
        } else {
            if (this.state.playerTurn === 1) {
                return(
                <div id="board">
                <div id="title">
                    <h1>Tic Tac Toe</h1>
                </div>
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
                  <div id="gameover">
                    <h2>Game Over</h2>
                    <p>Player O is the Winner!</p>
                  </div>
              </div>
              );
            } else {
                return(
                <div id="board">
                <div id="title">
                    <h1>Tic Tac Toe</h1>
                </div>
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
                  <div id="gameover">
                    <h2>Game Over</h2>
                    <p>Player X is the Winner!</p>
                  </div>
              </div>
              );
            }
        }
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
        var SquareStyle = {
            width: "30px",
            height: "30px",
            border: "5px solid black",
        };
        var id = "square" + this.props.num;
        return (
            <span style={SquareStyle} className="square" id={id} onClick={this.handleClick}>
                {this.state.displayValue}
            </span>
        );
    }
}

class ResetButton extends Component {
  constructor() {
    super();
    this.state = {
      // reset: false
    };
    this.handleClick = this.handleClick.bind(this);
  }
  handleClick() {
    console.log("Reset Button Pressed");
  }
  render() {
    return (
      <button onClick={this.handleClick}>Reset Game</button>
    );
  }
}

export default Main;
