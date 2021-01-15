/**
 * 
 * DeliveryList class is used to hold delivery node objects
 * 
 *  @author Willie Xu
 *	email: xuwillie1@gmail.com
 *	Class CSE 214-R10
 */

import java.io.*;
import java.util.*;

public class DeliveryList {
	private DeliveryListNode head;
	private DeliveryListNode tail;
	private DeliveryListNode cursor;
	private int count;

	public DeliveryList() {
		this.head = null;
		this.tail = null;
		this.cursor = null;
		this.count = 0;
	}

	/**
	 * returns the number of nodes in the list
	 * 
	 * @return
	 */
	public int numDeliveries() {
		return count;
	}

	/**
	 * returns the node the cursor is pointing to
	 * 
	 * @return
	 */
	public Delivery getCursor() {
		return this.cursor.getData();
	}

	/**
	 * brings the cursor to the head of the list
	 */
	public void resetCursorToHead() {
		if (head != null) {
			this.cursor = this.head;
		} else {
			this.cursor = null;
		}
	}

	/**
	 * brings the cursor to the tail of the list
	 */
	public void resetCursortoTail() {
		if (tail != null) {
			this.cursor = this.tail;
		} else {
			this.cursor = null;
		}
	}

	/**
	 * moves cursor forward unless cursor is at tail or cursor is null
	 * 
	 * @throws EndOfListException
	 */
	public void cursorFoward() throws EndOfListException {
		if (this.cursor == this.tail || this.cursor == null && this.tail == null) {
			throw new EndOfListException();
		} else {
			this.cursor = cursor.getNext();
		}
	}

	/**
	 * moves cursor backward unless cursor is at head or cursor is null
	 * 
	 * @throws EndOfListException
	 */
	public void cursorBackward() throws EndOfListException {
		if (this.cursor == this.head || this.cursor == null && this.head == null) {
			throw new EndOfListException();
		} else {
			this.cursor = cursor.getPrev();
		}
	}

	/**
	 * method inserts delivery after cursor user specified delivery object
	 * 
	 * @param newDelivery
	 *            if newDelivery is null, exception is thrown
	 * @throws IllegalArgumentException
	 */
	public void insertAfterCursor(Delivery newDelivery) throws IllegalArgumentException {
		if (newDelivery != null) {
			DeliveryListNode temp = new DeliveryListNode(newDelivery);
			if (cursor == null) {
				this.cursor = temp;
				this.head = temp;
				this.tail = temp;
			} else if (cursor == tail) {
				this.cursor.setNext(temp);
				temp.setPrev(this.cursor);
				tail = temp;
			} else {
				DeliveryListNode new1 = this.cursor.getNext();
				new1.setPrev(temp);
				temp.setNext(new1);
				this.cursor.setNext(temp);
				temp.setPrev(this.cursor);
			}
			count++;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * method inserts delivery after tail user specified delivery object
	 * 
	 * @param newDelivery
	 *            if newDelivery is null, exception is thrown
	 * @throws IllegalArgumentException
	 */
	public void appendToTail(Delivery newDelivery) throws IllegalArgumentException {
		if (newDelivery != null) {
			DeliveryListNode temp = new DeliveryListNode(newDelivery);
			if (tail != null) {
				this.cursor = tail;
				this.cursor.setNext(temp);
				temp.setPrev(this.cursor);
			} else {
				this.head = temp;
				this.cursor = temp;
				this.tail = temp;
			}
			count++;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * removes and returns data at cursor
	 * 
	 * @return if data at cursor is null exception is thrown
	 * @throws EndOfListException
	 */
	public Delivery removeCursor() throws EndOfListException {
		if (this.cursor != null) {
			Delivery temp = this.cursor.getData();
			if (head == cursor && cursor == tail) {
				head = null;
				cursor = null;
				tail = null;
				return temp;
			} else if (this.cursor == head) {
				head = this.cursor.getNext();
				this.cursor = head;
				count--;
				return temp;
			} else if (this.cursor == tail) {
				tail = this.cursor.getPrev();
				this.cursor = tail;
				count--;
				return temp;
			} else {
				this.cursor.getNext().setPrev(cursor.getPrev());
				this.cursor.getPrev().setNext(cursor.getNext());
				System.out.println("Delivery removed");
				count--;
				return temp;
			}
		} else {
			throw new EndOfListException();
		}
	}

	/**
	 * prints out deliverylist
	 */
	public String toString() {
		DeliveryListNode dummy = head;
		String s = "";
		while (dummy != null) {
			if (dummy == this.cursor) {
				s += "->\n";
			} else {
				s += "~\n";
			}
			s += dummy + "\n";
			dummy = dummy.getNext();
		}
		return s;
	}
}
