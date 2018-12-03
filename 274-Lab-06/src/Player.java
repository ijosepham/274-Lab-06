/**
 * @author Joey Pham
 * @date 15 October 2018
 * @description this represents the game and checks for the pairs, triples, and series 
 *
 */
public class Player {
	/**
	 * array of 3 dice the player may roll
	 */
	private Die [] rolls = new Die[ 3 ];
	
	/**
	 * the number of points the player has
	 */
	private int playersPoints = 0;
	
	/**
	 * Constructor = create 3 6 sided dice
	 */
	public Player() { // initialize dice
		for ( int i = 0; i < 3; i++ ) {
			rolls[ i ] = new Die ( 6 );
		}
	}
	
	/**
	 * sorts the array in order from lowest to highest values
	 */
	public void sort() {
		// moves the highest value to the last position of the array
		for ( int i = 0; i < 2; i++ ) { // check current place and next place 
			if ( rolls[ i ].compareTo( rolls[ i + 1 ] ) > 0 ) { // if current die is greater than next die 
				Die replaced = rolls[ i + 1 ]; // hold on to lower value
				rolls[ i + 1 ] = rolls[ i ]; // move higher value up
				rolls[ i ] = replaced; // replace old spot with lower value
			}
		}
		// this checks the first two after finishing the above
		// if you start with [3, 2, 1]
		// you end up with [2, 1, 3] after the above fn
		// below fn returns [1, 2, 3], checks the first two vals
		if ( rolls[ 0 ].compareTo( rolls[ 1 ] ) > 0 ) {
			Die replaced = rolls[ 1 ];
			rolls[ 1 ] = rolls[ 0 ];
			rolls[ 0 ] = replaced;
		}
	}
	
	/**
	 * checks if any two of the dice are the same value
	 * @return returns true if a pair exists, false if one doesn't
	 */
	public boolean checkPair() {
		// checks if any of the three dice are the same value
		if ( ( rolls[ 0 ].equals( rolls[ 1 ] ) ) || ( rolls[ 0 ].equals( rolls[ 2 ] ) ) || ( rolls[ 1 ].equals( rolls[ 2 ] ) ) ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * checks if all three values are the same
	 * @return true if a triple exists, false if not
	 */
	public boolean checkTriple() {
		// checks if die 1 == die 2 == die 3
		if ( rolls[ 0 ].equals( rolls[ 1 ] ) && ( rolls[ 1 ].equals( rolls[ 2 ] ) ) ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * check for a series, ex. 1, 2, 3
	 * @return true if a series exists, false if not
	 */
	public boolean checkSeries() {
		// if die 3 - die 2 == 1, which means die 3 is greater than die 2 by 1
		// if die 3 - die 1 == 2, which means die 3 is greater than die 1 by 2
		if ( ( rolls[ 2 ].compareTo( rolls[ 1 ] ) == 1 ) && ( rolls[ 1 ].compareTo( rolls[ 0 ] ) == 1 ) ) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * displays the 3 values that the user rolled
	 * @return rollDisplay string of what to say, which displays the rolls
	 */
	@Override
	public String toString() {
		String rollDisplay = "\nYou rolled...\n" + rolls[ 0 ].getDieVal() +  ", " + rolls[ 1 ].getDieVal() + ", " + rolls[ 2 ].getDieVal() + "\n";
		return rollDisplay;
	}
	
	/**
	 * gets the player's points
	 * @return int value of the player's point
	 */
	public int getPlayersPoints() {
		return playersPoints;
	}
	
	/**
	 * player takes turn - rolls dice and checks win conditions
	 */
	public void takeTurn() {
		// rolls 3 dice
		for ( int i = 0; i < 3; i++ ) {
			rolls[ i ] = new Die ( 6 );
		}
		// sort the dice
		sort();
		// prints the dice values
		System.out.print( toString() );
		// check for win conditions
		if ( checkTriple() ) {
			// add 3 points for a triple
			playersPoints += 3;
			System.out.print( "You got three of a kind!" );
		} else if ( checkPair() ) {
			// add 1 point for a pair
			playersPoints += 1;
			System.out.print( "You got a pair!" );
		} else if ( checkSeries() ) {
			// add 2 points for a series
			playersPoints += 2;
			System.out.print( "You got a series of three!" );
		} else {
			// if none of the win conditions are met
			System.out.print( "Aww, you got nothing." );
		}
		// display points
		System.out.print( "\n" + "Score = " + getPlayersPoints() );
	}
}
