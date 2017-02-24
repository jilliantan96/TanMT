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
	public Tool(int currentRoll, int purse, int amount) {
		this.currentRoll = currentRoll;
		this.purse = purse;
		this.amount = amount;
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
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void increment() {
		this.currentRoll++;
	}
		
}
