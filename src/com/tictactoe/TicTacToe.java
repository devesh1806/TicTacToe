package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	
	public Character[] createBoard() {
		Character[] charArr = new Character[10];
		for(int i=1;i<charArr.length;i++) {
			charArr[i]='_';
		}
		return charArr;
	}
	
	public char chooseXorO() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose X or O");
		char choose = sc.nextLine().charAt(0);
		return Character.toUpperCase(choose);
	}
}
