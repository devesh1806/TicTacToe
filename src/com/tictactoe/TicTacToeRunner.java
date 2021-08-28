package com.tictactoe;

public class TicTacToeRunner {
	public static void main(String[] args) {
		TicTacToe ticTacToeGame = new TicTacToe();
		Character[] board = ticTacToeGame.createBoard();
		char player = ticTacToeGame.chooseXorO();
		char computer = ( player == 'X')? 'O':'X';
		System.out.println("Player: "+player+" Computer: "+computer);
		ticTacToeGame.showBoard(board);
	}
}
