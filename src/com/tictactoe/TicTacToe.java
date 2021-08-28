package com.tictactoe;

public class TicTacToe {
	
	public Character[] createBoard() {
		Character[] charArr = new Character[10];
		for(int i=1;i<charArr.length;i++) {
			charArr[i]='_';
		}
		return charArr;
	}
}
