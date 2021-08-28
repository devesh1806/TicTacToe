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

	public void showBoard(Character[] charArr) {
		for(int i=1;i<charArr.length;i=i+3) {
			System.out.println(charArr[i]+ " "+charArr[i+1]+ " "+charArr[i+2] );
		}
	}
	
	public boolean isEmpty(Character[] charArr, int position) {
		for (int i=1;i<charArr.length;i++) {
			if (i==position && charArr[i]=='_') {
				return true;
			}
		}
		return false;
	}
	
	public Character[] makeMove(Character[] charArr,char player,char computer) {
		Scanner sc = new Scanner(System.in);
		int position = 0;
		System.out.println("Enter position: ");
		position = sc.nextInt();
		if (position > 9 || position<=0) {
			System.out.println("Enter valid position(1-9)"); 
			position = sc.nextInt();
		}
		
		if (isEmpty(charArr, position)) {
			charArr[position]=player;
		}
		return charArr;
	}
}
