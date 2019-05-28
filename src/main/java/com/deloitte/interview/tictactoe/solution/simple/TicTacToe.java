package com.deloitte.interview.tictactoe.solution.simple;

public class TicTacToe {

	int boardSize;
	PlayerMarker[][] board;
	int moveCounter = 0;
	boolean gameOver = false;
	
	public TicTacToe(int boardSize) {
		this.boardSize = boardSize;
		this.board = new PlayerMarker[boardSize][boardSize];
	}
	
	public Result play(PlayerMarker marker, int x, int y) {
		if (gameOver) {
			System.out.println(Result.GAME_OVER);
			return Result.GAME_OVER;
		}
		
		board[x][y] = marker;
		moveCounter++;
		
		return checkBoard(marker);
	}
	
	private Result checkBoard(PlayerMarker marker) {
		// check if win condition achieved
		if (isWin(marker)) {
			System.out.println(Result.WIN);
			gameOver = true;
			return Result.WIN;
		}
		
		// check if board is full
		if (moveCounter == (boardSize * boardSize)) {
			System.out.println(Result.STALEMATE);
			gameOver = true;
			return Result.STALEMATE;
		}
		System.out.println(Result.NEXT_TURN);
		return Result.NEXT_TURN;
	}
	
	private boolean isWin(PlayerMarker marker) {
		// check straight lines
		for (int x = 0; x < boardSize; x++) {
			for (int y = 0; y < boardSize; y++) {
				if (board[x][y] != marker) {
					break;
				}
				if (y == boardSize -1) {
					return true;
				}
			}
		}
		
		// check horizontal, 0 to top-right
		for (int i = 0; i < boardSize; i++) {
			if (board[i][i] != marker) {
				break;
			}
			if (i == boardSize - 1) {
				return true;
			}
		}
		
		// check horizontal, top-left to bottom-right
		for (int i = 0; i < boardSize; i++) {
			if (board[i][boardSize - 1 - i] != marker) {
				break;
			}
			if (i == boardSize -1) {
				return true;
			}
		}
		return false;
	}
	
	public enum PlayerMarker {
		X,
		O;
	}
	
	public enum Result {
		WIN,
		STALEMATE,
		NEXT_TURN,
		GAME_OVER
	}
}
