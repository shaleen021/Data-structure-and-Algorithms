package practice.linkedlist;

import java.util.Collections;

public class RemoveLoopFromLinkedList {
	static Node head;

	static class Node {
		int data;
		Node next;
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public static boolean detectAndRemoveLoop(Node head) {
		Node slow_ptr = head;
		Node fast_ptr = head;
		
		slow_ptr = slow_ptr.next;
		fast_ptr = fast_ptr.next.next;
		
		while(fast_ptr != null && fast_ptr.next != null){
			if(slow_ptr == fast_ptr){
				break;
			}
			
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		
		if(slow_ptr == fast_ptr){
			slow_ptr = head;
			while(slow_ptr.next != fast_ptr.next){
				slow_ptr = slow_ptr.next;
				fast_ptr = fast_ptr.next;
			}
			fast_ptr.next = null;
		}
		
		
		return false;
	}
	
	void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
	
	public static void main(String[] args) { 
		RemoveLoopFromLinkedList list = new RemoveLoopFromLinkedList(); 
        list.head = new Node(50); 
        list.head.next = new Node(20); 
        list.head.next.next = new Node(15); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(10); 
  
        // Creating a loop for testing  
        head.next.next.next.next.next = head; 
       System.out.println(detectAndRemoveLoop(head));
        //System.out.println("Linked List after removing loop : "); 
       list.printList(head); 
    } 
}
