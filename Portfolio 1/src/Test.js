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
        var num = this.state.values[rowNum * 3];
        for(var i = rowNum * 3; i < (rowNum * 3) + 3; i++) {
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
        for (var i = 0; i < 3; i++) {
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
      this.setState({
        values: [0,0,0,0,0,0,0,0,0],
            playerTurn: 1,
            gameOver: false
      });
    }

    render() {
        var style = {
          height: '600px',
          width: '300px',
        };
        var gameMessageHeader = "";
        var gameMessageSubtitle = "";
        if (!this.state.gameOver) {
            if (this.state.playerTurn === 1) {
              gameMessageSubtitle = "Player X's Turn";
            } else {
              gameMessageSubtitle = "Player O's Turn";
            }
        } else if(this.checkCatsGame()) {
            gameMessageHeader = "Cat's Game";
            gameMessageSubtitle = "It's a tie!";
        } else {
            gameMessageHeader = "Game Over";

            if (this.state.playerTurn === 1) {
                gameMessageSubtitle = "Player O is the winner!";

            } else {
                gameMessageSubtitle = "Player X is the winner!";
            }
        }

        return (
                <div id="tictactoe">
                <div id="title">
                    <h1>Tic Tac Toe</h1>
                </div>
                  <div style={style} id="board">
                    <Square num="1" value={this.state.values[0]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                    <Square num="2" value={this.state.values[1]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                    <Square num="3" value={this.state.values[2]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                    <Square num="4" value={this.state.values[3]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                    <Square num="5" value={this.state.values[4]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                    <Square num="6" value={this.state.values[5]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                    <Square num="7" value={this.state.values[6]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                    <Square num="8" value={this.state.values[7]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                    <Square num="9" value={this.state.values[8]} turn={this.state.playerTurn} click={this.handleButtonPressed.bind(this)}/>
                  </div>
                  <div id="gameMessage">
                    <h2>{gameMessageHeader}</h2>
                    <p>{gameMessageSubtitle}</p>
                  </div>
                  <div id="reset">
                      <ResetButton click={this.resetGame.bind(this)}/>
                  </div>
              </div>
              );
    }
}

class Square extends Component {
    constructor() {
        super();

        this.state = {
            displayValue: " "
        };

        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        if(this.state.displayValue !== " ") return;

        if(this.props.turn === 1)
            this.setState({displayValue: "X"});
        else
            this.setState({displayValue: "O"});

        this.props.click(this.props.num); //runs handleButtonPressed method in main
    }

    render() {
      this.state.displayValue = " ";
      var value = this.props.value;
      console.log("Number " + this.props.num + ": " + value);
      if (this.props.value === 1) {
          this.state.displayValue = "X";
      } else if (this.props.value === 2) {
          this.state.displayValue = "O";
      }

        var SquareStyle = {
            width: '100px',
            height: '100px',
            outline: "1px solid",
            float: "left",
            textAlign: "center",
            lineHeight: "50px",
        };
        var id = "square" + this.props.num;
        return (
            <div style={SquareStyle} className="square" id={id} onClick={this.handleClick}>
                {this.state.displayValue}
            </div>
        );
    }
}

class ResetButton extends Component {
  constructor() {
    super();
    this.state = {
    };
    this.handleClick = this.handleClick.bind(this);
  }
  handleClick() {
    this.props.click();
  }
  render() {
    return (
      <button className="resetButton" onClick={this.handleClick}>Reset Game</button>
    );
  }
}

export default Main;
