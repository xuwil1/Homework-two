/**
 * Delivery class is used to hold delivery object
 * 
 *  @author Willie Xu
 *	email: xuwillie1@gmail.com
 *	Class CSE 214-R10
 */

import java.io.*;
import java.util.*;

public class Delivery {
	private String source; // user specified location of deliverer
	private String dest; // user specified location of delivery
	private String instruction; // user specified instructions for delivery

	public Delivery() {
		this.source = null;
		this.dest = null;
		this.instruction = null;
	}

	/**
	 * user input string for source of delivery object
	 * 
	 * @param source
	 *            user input string for dest of delivery object
	 * @param dest
	 *            user input string for instruction of delivery object
	 * @param instruction
	 */
	public Delivery(String source, String dest, String instruction) {
		this.source = source;
		this.dest = dest;
		this.instruction = instruction;
	}

	/**
	 * getter that returns source of delivery object
	 * 
	 * @return
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * getter that returns dest of delivery object
	 * 
	 * @return
	 */
	public String getDest() {
		return this.dest;
	}

	/**
	 * getter that returns instruction of delivery object
	 * 
	 * @return
	 */
	public String getInstruction() {
		return this.instruction;
	}

	/**
	 * setter that allows user to input source of delivery object
	 * 
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * setter that allows user to input destination of delivery object
	 * 
	 * @param dest
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}

	/**
	 * setter that allows user to input instruction of delivery object
	 * 
	 * @param instruction
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	/**
	 * returns parameters of delivery object in a string
	 * 
	 * @return
	 */
	public String toString() {
		return String.format("To: %-15s | From: %-15s\nInstruction: %-30s", this.dest, this.source, this.instruction);
	}
}
