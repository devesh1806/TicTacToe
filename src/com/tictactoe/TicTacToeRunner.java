package com.tictactoe;
import java.util.Scanner;

public class TicTacToeRunner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TicTacToe ticTacToeGame = new TicTacToe();
		
		while(true) {
			
			Character[] board = ticTacToeGame.createBoard();
			
			char player = ticTacToeGame.chooseXorO();
			char computer = ( player == 'X')? 'O':'X';
			System.out.println("Player: "+player+" Computer: "+computer);
			ticTacToeGame.showBoard(board);
			
			int chance = (ticTacToeGame.toss()=="player")? 1:0;
			while(true) {
				if (ticTacToeGame.emptySpace(board)) {
					if (chance == 1) {
						System.out.print("Player ");
						board = ticTacToeGame.makeMove(board, player);
						if (ticTacToeGame.winning(board,player)) {
							System.out.println("Player won.");
							break;
						}
						else {
							//condition for changing turn.
							chance = 0;
						}
					}
					else {
						board = ticTacToeGame.computerMove(board, computer);
						if (ticTacToeGame.winning(board,computer)) {
							System.out.println("Computer won.");
							break;
						}
						else {
							chance = 1;
						}
					}
					System.out.println();
					ticTacToeGame.showBoard(board);
				}
				else {
					System.out.println("Game Tie.");
					break;
				}
				
			}
			System.out.println("Do you wish to play another game: 1.Yes 2.No");
			if (sc.nextInt()==2) break;
		}
	}
}
