/**
 * 
 */
package model;

import java.util.Random;

/**
 * @author jilliantan
 *
 */
public class Die {
	
	private int value;
	
	/**
	 * constructor that initializes a new die and sets a random die value
	 */
	public Die() {
		setRandom();
	}

	/**
	 * overloaded constructor that initializes a new die and assigns a value to it
	 * @param value
	 */
	public Die(int value) {
		this.value = value;
	}

	/**
	 * returns the current die value
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * sets a new value for the current instance
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * sets a random value for the die instance
	 */
	public void setRandom() {
		Random random = new Random();
		this.value = random.nextInt(6) + 1;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Die[value=" + value+ "]";
	}
}
