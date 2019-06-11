package com.deloitte.interview.tictactoe.solution.simple;

import com.deloitte.interview.tictactoe.solution.simple.TicTacToe.PlayerMarker;

public class Driver {
	public static void main(String[] args) {
		/*
		 * Driver code for game as shown in below graphic
		 * 
		 *  | |O|X|
		 *  | |X| |
		 *  |X|O|O|
		 */

		TicTacToe game = new TicTacToe(3);
		game.play(PlayerMarker.X, 0, 0);
		game.play(PlayerMarker.O, 1, 0);
		
		game.play(PlayerMarker.X, 1, 1);
		game.play(PlayerMarker.O, 1, 2);
		
		game.play(PlayerMarker.X, 2, 2);
		game.play(PlayerMarker.O, 2, 0);
	}
}
