/**
 * @author Joey Pham
 * @date 15 October 2018
 * @description this class represents a single die
 */
public class Die {
	/**
	 * represents the number of sides on the die
	 */
	private int sides;
	
	/**
	 * represents the value of the die
	 */
	private int dieVal;
	
	/**
	 * Constructor
	 * @param s the number of sides this die has
	 */
	public Die( int s ) {
		sides = s;
		dieVal = roll(); // assign a value 1-6 to this variable
	}
	
	/**
	 * rolls the die and returns the result
	 * @return result of the die roll
	 */
	public int roll(){ // rolls a random number 1-6
		dieVal = ( int )( Math.random() * sides ) + 1; // first goes 0-5, then adds 1 to make 1-6
		return dieVal;
	}
	
	/**
	 * Retrieves the value of the die
	 * @return value of the die
	 */
	public int getDieVal(){ 
		return dieVal;
	}
	
	/**
	 * Sets the die to the parameter value
	 * @param value value to set die to
	 * @return value of the die
	 */
	public boolean setDiceVal( int value ) {
		if ( value > 0 && value <= sides ) { // makes sure it's in the range
			dieVal = value;
			return true;
		}
		return false;
	}
	
	/**
	 * compares two dice to see if they have the same value
	 * @return true if they are equal, false if they are not
	 */
	@Override
	public boolean equals( Object o ) {
		if( o instanceof Die ) { // if thing passed in is a Die
			Die d = (Die) o; // assign to var
			return this.dieVal == d.dieVal; // if both values are the same
			}
		return false; // false if they're not the same value
	}
	
	/**
	 * compares the value of two dice and returns the difference 
	 * @param d die to be compared to
	 * @return the difference of the initial die minus the passed in die
	 */
	public int compareTo( Die d ) {
		int d1 = this.dieVal; //  assign
		int d2 = d.dieVal; // assign
		return d1 - d2;	 // returns (old number - new number)
		// when you call this function, it should look like
		// die[1].compareTo(die[2])
		// so it does die1 - die 2
	}
	
}