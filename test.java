import java.io.*;
import java.util.*;

public class test {
public static void main(String[]args) {
	DeliveryList test=new DeliveryList();
	Delivery delivery= new Delivery("source","dest","instruction");
	test.insertAfterCursor(delivery);
	Delivery delivery1= new Delivery("sourc1e","d1est","instr1uction");
	test.insertAfterCursor(delivery1);
	try {
	
	test.removeCursor();
	}catch(EndOfListException e){
	}
	test.resetCursorToHead();
	for(int i=test.numDeliveries();i>=0;i--) {
		System.out.println(test.getCursor().toString());
		}
	

	
	
}
}
