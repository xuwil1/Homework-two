/**
 * DeliveryListNode class is used to hold nodes of delivery list
 * 
 *  @author Willie Xu
 *	email: xuwillie1@gmail.com
 *	Class CSE 214-R10
 */
import java.io.*;
import java.util.*;

public class DeliveryListNode {
	private Delivery data; // object reference field called data
	private DeliveryListNode next; // first reference serving as link called next
	private DeliveryListNode prev; // second reference serving as link called prev

	/**
	 * Constructor for DeliveryListNode object
	 * 
	 * @param initData
	 */
	public DeliveryListNode() {
		this.next = null;
		this.prev = null;
		this.data = null;
	}

	public DeliveryListNode(Delivery initData) {
		this.next = null;
		this.prev = null;
		if (initData == null) {
			throw new IllegalArgumentException();
		} else {
			this.data = initData;
		}
	}

	/**
	 * sets data of of delivery object
	 * 
	 * @param data
	 */
	public void setData(Delivery data) {
		this.data = data;
	}

	/**
	 * allows user to set next parameter of DeliveryListNode object
	 * 
	 * @param next
	 */
	public void setNext(DeliveryListNode next) {
		this.next = next;
	}

	/**
	 * allows user to set prev parameter of DeliveryListNode object
	 * 
	 * @param prev
	 */
	public void setPrev(DeliveryListNode prev) {
		this.prev = prev;
	}

	/**
	 * returns data of object
	 * 
	 * @return
	 */
	public Delivery getData() {
		return this.data;
	}

	/**
	 * returns next parameter of DeliveryListNode object
	 * 
	 * @return
	 */
	public DeliveryListNode getNext() {
		return this.next;
	}

	/**
	 * returns prev of DeliveryListNode object
	 * 
	 * @return
	 */
	public DeliveryListNode getPrev() {
		return this.prev;
	}

	public String toString() {
		return data.toString();
	}
}
