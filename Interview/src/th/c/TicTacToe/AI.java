package th.c.TicTacToe;

public class AI {
	
	private Board board;
	private int len;
	private int[][] t;
	
	public AI(Board b) {
		this.board = b;
		this.t = board.getBoard();
		this.len = this.board.getBoard().length;
	}
	
	public void start() {
		if(attack()) {
		} else if(defend()) {
		} else if(center()) {
		} else {
			planB();
		}
	}
	
	public boolean attack() {
		return twoPieces(-1);
	}
	
	public boolean defend() {
		return twoPieces(1);
	}
	
	private boolean twoPieces(int f) {
		for(int i = 0; i < len; i++) {
			if(board.getBoard()[i][0] == board.getBoard()[i][1] && board.getBoard()[i][0] == f && board.getBoard()[i][2] == 0) {
				board.dropPiece(new PieceLocation(-1, i, 2));
				return true;
			} else if(board.getBoard()[i][0] == board.getBoard()[i][2] && board.getBoard()[i][0] == f && board.getBoard()[i][1] == 0) {
				board.dropPiece(new PieceLocation(-1, i, 1)); 
				return true;
			} else if(board.getBoard()[i][1] == board.getBoard()[i][2] && board.getBoard()[i][1] == f && board.getBoard()[i][0] == 0) {
				board.dropPiece(new PieceLocation(-1, i, 0)); 
				return true;
			} else if(board.getBoard()[0][i] == board.getBoard()[1][i] && board.getBoard()[0][i] == f && board.getBoard()[2][i] == 0) {
				board.dropPiece(new PieceLocation(-1, 2, i)); 
				return true;
			} else if(board.getBoard()[0][i] == board.getBoard()[2][i] && board.getBoard()[0][i] == f && board.getBoard()[1][i] == 0) {
				board.dropPiece(new PieceLocation(-1, 1, i)); 
				return true;
			} else if(board.getBoard()[1][i] == board.getBoard()[2][i] && board.getBoard()[1][i] == f && board.getBoard()[0][i] == 0) {
				board.dropPiece(new PieceLocation(-1, 0, i)); 
				return true;
			} 
		}
		if(board.getBoard()[0][0] == board.getBoard()[1][1] && board.getBoard()[0][0] == f && board.getBoard()[2][2] == 0) {
			board.dropPiece(new PieceLocation(-1, 2, 2)); 
			return true;
		} else if(board.getBoard()[1][1] == board.getBoard()[2][2] && board.getBoard()[1][1] == f && board.getBoard()[0][0] == 0) {
			board.dropPiece(new PieceLocation(-1, 0, 0)); 
			return true;
		} else if(board.getBoard()[0][2] == board.getBoard()[1][1] && board.getBoard()[0][2] == f && board.getBoard()[2][0] == 0) {
			board.dropPiece(new PieceLocation(-1, 2, 0)); 
			return true;
		} else if(board.getBoard()[2][0] == board.getBoard()[1][1] && board.getBoard()[2][0] == f && board.getBoard()[0][2] == 0) {
			board.dropPiece(new PieceLocation(-1, 0, 2)); 
			return true;
		} else {
			return false;
		}
	}
	
	public boolean center() {
		if(board.getBoard()[1][1] == 0) {
			board.dropPiece(new PieceLocation(-1, 1, 1));
			return true;
		} else {
			return false;
		}
	}
	
	public void planB() {
		if((board.getBoard()[0][0] == board.getBoard()[2][2] && board.getBoard()[0][0] == 1) || (board.getBoard()[0][2] == board.getBoard()[2][0] && board.getBoard()[0][2] == 1)) {
			if(board.getBoard()[0][2] == 0) {
				board.dropPiece(new PieceLocation(-1, 0, 2));
			} else {
				board.dropPiece(new PieceLocation(-1, 0, 0));
			}
		} else if((board.getBoard()[0][1] == 1 || board.getBoard()[1][2] == 1) && board.getBoard()[2][0] == 0) {
			board.dropPiece(new PieceLocation(-1, 2, 0));
		} else if((board.getBoard()[1][0] == 1 || board.getBoard()[2][1] == 1) && board.getBoard()[2][0] == 0) {
			board.dropPiece(new PieceLocation(-1, 2, 0));
		} else if(board.getBoard()[0][0] == 0) {
			board.dropPiece(new PieceLocation(-1, 0, 0));
		} else if(board.getBoard()[0][2] == 0) {
			board.dropPiece(new PieceLocation(-1, 0, 2));
		} else if(board.getBoard()[2][0] == 0) {
			board.dropPiece(new PieceLocation(-1, 2, 0));
		} else if(board.getBoard()[2][2] == 0) {
			board.dropPiece(new PieceLocation(-1, 2, 2));
		} else if(board.getBoard()[0][1] == 0) {
			board.dropPiece(new PieceLocation(-1, 0, 1));
		} else if(board.getBoard()[1][0] == 0) {
			board.dropPiece(new PieceLocation(-1, 1, 0));
		} else if(board.getBoard()[1][2] == 0) {
			board.dropPiece(new PieceLocation(-1, 1, 2));
		} else {
			board.dropPiece(new PieceLocation(-1, 2, 1));
		}
	}
}
