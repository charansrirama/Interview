package th.c.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
	
	private static void showBoard(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			System.out.print("Row" + (i+1) + " ");
			for(int j = 0; j < board[i].length; j++) {
				System.out.printf("%2d	", board[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new Board(3);
		AI ai = new AI(board);
		int flag = 1;
		Scanner s = new Scanner(System.in);
		int x, y;
		
		System.out.println("Who first? --- Player(1)/AI(-1)");
		flag = s.nextInt();
		if(flag == 1) {
			System.out.println("Player first.");
		} else {
			System.out.println("AI first");
			ai.start();
			flag = -flag;
		}
		showBoard(board.getBoard());
		
		while(flag != 2) {
			System.out.println("Please drop your piece: > ");
			x = s.nextInt()-1;
			y = s.nextInt()-1;
			while(x<0 || x>2 || y<0 || y>2 || board.getBoard()[x][y] != 0) {
				System.out.println("Wrong Location.");
				x = s.nextInt()-1;
				y = s.nextInt()-1;
			}
			board.dropPiece(new PieceLocation(1, x, y));
			showBoard(board.getBoard());
			System.out.println();
			flag = -flag;
			
			ai.start();
			showBoard(board.getBoard());
			flag = -flag;
			
			if(board.check() == 1) {
				System.out.println("Player Win!"); 
				flag = 2;
			} else if(board.check() == -1) {
				System.out.println("AI Win!");
				flag = 2;
			} else if(board.check() == 3) {
				System.out.println("Nect Turn!");
			} else {
				System.out.println("Draw!");
				flag = 2;
			}
		}
	}

}
