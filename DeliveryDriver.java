/**
 * DeliveryDriver class is the main program that allows for user interactions
 * 
 *  @author Willie Xu
 *	email: xuwillie1@gmail.com
 *	Class CSE 214-R10
 */

import java.io.*;
import java.util.*;

public class DeliveryDriver {
	public static void main(String[] args) {
		DeliveryList list1 = new DeliveryList();
		DeliveryList list2 = new DeliveryList();
		DeliveryList dummy = list1;
		Scanner sc = new Scanner(System.in);
		boolean quit = true;				//variable used to terminate program
		boolean copy=false;					//makes sure that paste option can only be used after cut option has been used
		Delivery cut=new Delivery();		//used to hold delivery object data after cut option is used
		System.out.println("Welcome to Delivery Dealz.\n");
		System.out.println("Menu:\n\tA) Add a Delivery After Cursor\n"
				+ "\tR) Remove Delivery At Cursor\n\tX) Cut Cursor\n" + "\tV) Paste After Cursor\n\tH) Cursor to Head\n"
				+ "\tT) Cursor to Tail\n\tF) Cursor Forward\n" + "\tB) Cursor Backward\n\tS) Switch Delivery Lists\n"
				+ "\tP) Print current list\n\tQ) Quit\n");
		while (quit) {
			System.out.print("Please select an option: ");
			char choice = sc.nextLine().charAt(0); // choice variable is user specified letter
			if (choice == 'A' || choice == 'a') {
				System.out.print("Please enter a source: ");
				String src = sc.nextLine();
				System.out.print("Please enter a destination: ");
				String dest = sc.nextLine();
				System.out.print("Please enter any special instructions: ");
				String special = sc.nextLine();
				Delivery delivery= new Delivery(src,dest,special);
				dummy.insertAfterCursor(delivery);
				System.out.println("\nOrder inserted.\n");
			}
			if (choice == 'R' || choice == 'r') { // Remove Delivery At Cursor
				try {
				dummy.removeCursor();
				System.out.println("Delivery removed\n");
				}catch (EndOfListException e){
					System.out.println("EndOfListException error!");
				}
			}
			if (choice == 'X' || choice == 'x') { // Cut Cursor
				try {
				copy=true;
				cut=dummy.removeCursor();
				System.out.println("Cursor is cut.\n");
				}catch(EndOfListException e) {
					
				}
			}
			if (choice == 'V' || choice == 'v') { // Paste After Cursor
				if(copy==true) {
					dummy.insertAfterCursor(cut);
					System.out.println("Delivery has been pasted!\n");
				}else {
					System.out.println("Option invalid. Nothing to paste!");
				}

			}
			if (choice == 'H' || choice == 'h') { // Cursor to Head
				dummy.resetCursorToHead();
				System.out.println("Cursor is at head.\n");
			}
			if (choice == 'T' || choice == 't') { // Cursor to Tail
				dummy.resetCursortoTail();
				System.out.println("Cursor is at tail.\n");
			}
			if (choice == 'F' || choice == 'f') { // Cursor Forward
				try {
				System.out.println("Cursor moved forward.\n");
				dummy.cursorFoward();
				} catch(EndOfListException e) {
					System.out.println("EndOfListException error!");
				}
			}
			if (choice == 'B' || choice == 'b') {
				try {
				dummy.cursorBackward();
				System.out.println("Cursor moved backward.\n");
				}catch( EndOfListException e){
					System.out.println("EndOfListException error!");
				}
			}
			if (choice == 'S' | choice == 's') { // Switch Delivery Lists
				if (dummy == list1) {
					System.out.println("Biz Billy's list is selected.\n");
					dummy = list2;
				} else {
					System.out.println("Money Mike's list is selected.\n");
					dummy = list1;
				}
			}
			if (choice == 'P' | choice == 'p') { // Print Current Delivery Route
				if (dummy == list1) {
					System.out.println("Money Mike's Delivery");
					System.out.println("----------------------------------------------------");
				} else {
					System.out.println("Biz Billy's Delivery");
					System.out.println("----------------------------------------------------");
				}
					System.out.print(dummy.toString());
				System.out.println("----------------------------------------------------");
			}
		if(choice== 'Q'||choice=='q') {			//Quit option
			System.out.println("Thank you for your service!");
			quit=false;
		}
		}
	}

}
