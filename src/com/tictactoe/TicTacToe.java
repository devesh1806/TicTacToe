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
		
		return charArr[position]=='_';
	}
	
	public Character[] makeMove(Character[] charArr,char gameCurrentPlayer) {
		Scanner sc = new Scanner(System.in);
		
		int position = 0;
		while (true) {
			System.out.print("Enter position: ");
			position = sc.nextInt();
			if (position <= 9 && position>0) {
				if (isEmpty(charArr, position)) {
					charArr[position] = gameCurrentPlayer;
					break;
				}
			}
			else System.out.println("Enter valid position (1-9):");
		}
		return charArr;
	}
	
	public String toss() {
		Scanner sc = new Scanner(System.in);
		
		int check = (int)((Math.random()*10)%2);
		System.out.println("Enter choice 1.Heads 2.Tails:");
		int choice = sc.nextInt();
		int heads = 1,tails = 0;
		
		if (check == heads && choice == 1) {
			System.out.println("You won toss,You start:");
			return "player";
		}
		else if (check==tails && choice == 0) {
			System.out.println("You won toss, You start:");
			return "player";
		}
		else {
			System.out.println("You lost the toss, Computer starts:");
			return "computer";
		}
	}

	public boolean winning(Character[] board,char playerCharacter) {
		for(int i=1;i<board.length;i++) {
			if (i<=3) {
				if ( i+2 <4 && board[i].equals(playerCharacter) && board[i+1].equals(playerCharacter) && board[i+2].equals(playerCharacter)) {
					return true;
				}
				else if (i+8<=9 && board[i].equals(playerCharacter) && board[i+4].equals(playerCharacter) && board[i+8].equals(playerCharacter)) {
					return true;
				}
				else if (i+6<=9 && board[i].equals(playerCharacter) && board[i+3].equals(playerCharacter) && board[i+6].equals(playerCharacter)) {
					return true;
				}
			}
			else if (i>3 && i<=6) {
				if ( i+2 <7 && board[i].equals(playerCharacter) && board[i+1].equals(playerCharacter) && board[i+2].equals(playerCharacter)) {
					return true;
				}
			}
			else {
				if ( i+2 <=9 && board[i].equals(playerCharacter) && board[i+1].equals(playerCharacter) && board[i+2].equals(playerCharacter)) {
					return true;
				}
				else if (i-4<4 && board[i].equals(playerCharacter) && board[i-2].equals(playerCharacter) && board[i-4].equals(playerCharacter)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean emptySpace(Character[] board) {
		for(int i=1;i<10;i++) {
			if (board[i].equals('_')) return true;
		}
		return false;
	}
	
	private int checkComputerWin(Character[] board, char computer) {
		for(int i=1;i<board.length;i++) {
			if(board[i] == '_') {
				board[i] = computer;
				if(winning(board, computer)) return i;
				else board[i] = '_';
			}
		}		
		return 0;
	}
	
	public Character[] computerMove(Character[] board, char gameCharacter) {
		if (checkComputerWin(board, gameCharacter)!=0) {
			board[checkComputerWin(board, gameCharacter)]=gameCharacter;
			return board;
		}
		char opponentCharacter = (gameCharacter == 'X')? 'O':'X';
		int index = opponentWin(board, opponentCharacter,gameCharacter);
		if (index!=0) {
			board[index]=gameCharacter;
			return board;
		}
		if(board[1] == '_' || board[3] == '_' || board[7] == '_' || board[9] == '_') {
			if(board[1] == '_') board[1] = gameCharacter;
			else if (board[3] == '_')  board[3] = gameCharacter;
			else if (board[7] == '_')  board[7] = gameCharacter;
			else board[9] = gameCharacter;
		}
		else if(board[5] == '_') board[5] = gameCharacter;
		else {
			if(board[2] == '_') board[2] = gameCharacter;
			else if (board[4] == '_')  board[4] = gameCharacter;
			else if (board[6] == '_')  board[6] = gameCharacter;
			else board[8] = gameCharacter;
		}
		return board;
	}
	
	private int opponentWin(Character[] board,char opponentCharacter,char gameCharacter) {
		
		for(int i=1;i<board.length;i++) {
			if(board[i] == '_') {
				board[i] = opponentCharacter;
				if(winning(board, opponentCharacter)) {
					return i;
				}
				else board[i] = '_';
			}
		}		
		return 0;
	}
}
