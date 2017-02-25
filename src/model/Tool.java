/**
 * 
 */
package model;

/**
 * @author jilliantan
 *
 */
public class Tool {
	
	//initialize variables
		private int currentRoll = 0;
		private int purse = 1000;
		private int amount = 0;
		
		
	/**
	 * @param currentRoll
	 * @param purse
	 * @param amount
	 */
	public Tool(int currentRoll, int purse) {
		this.currentRoll = currentRoll;
		this.purse = purse;
	}
	
	public int getCurrentRoll() {
		return currentRoll;
	}
	
	public void setCurrentRoll(int currentRoll) {
		this.currentRoll = currentRoll;
	}
	
	public int getPurse() {
		return purse;
	}
	
	public void setPurse(int purse) {
		this.purse = purse;
	}
	
	public void addToPurse(int amount) {
		this.purse = this.purse + amount;
	}
	
	public void subtractFromPurse(int amount) {
		this.purse = this.purse - amount;
	}
	
	public void increment() {
		this.currentRoll++;
	}
		
}
