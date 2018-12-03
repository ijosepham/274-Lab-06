/**
 * @author Joey Pham
 * @date 15 October 2018
 * @description dice game where you accumulate points from getting pairs, triples, and series
 */

public class Lab6 {
	public static void main ( String [] args ) {
		System.out.print( "Yacht-z" + "\n" );
		boolean gameOver = false; // keep track if game is done
		// start the game
		Player g1 = new Player();
		while ( !gameOver ) { // if the player hasn't quit yet
			g1.takeTurn(); // roll the dice
			System.out.print( "\n" + "Play again? (Y/N): " );
			if ( CheckInput.getYesNo() == 0 ) { // if user said no
				gameOver = true; // game over, break through
			}
		}
		System.out.print( "\n" + "Final Score = " + g1.getPlayersPoints() );
		System.out.print( "\n" + "Goodbye!" );
	}
}