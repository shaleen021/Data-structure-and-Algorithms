package practice.linkedlist;


class ListNode {
	int data;
	ListNode next;
	
	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}

public class PrintZeroInStart {
	
	
	
	public static void printZeroInStart(ListNode root){
		ListNode head = root;
		ListNode prev = null;
		ListNode curr = root;
		
		if(curr == null)
			return;
		
		while(curr != null){
			
			if(prev == null){
				prev = curr;
				curr = curr.next;
			} else {
				if(curr.data == 0){
					ListNode node = new ListNode(0);
					node.next = head;
					head = node;
					prev.next = curr.next;
					curr = curr.next;
				}else {
					prev = curr;
					curr = curr.next;
				}
			}
			
		}
		
		ListNode ele = head;
		while(ele != null){
			System.out.print(ele.data + " ");
			ele = ele.next;
		}
		
	}
	
	public static void main(String args[]) {
		
		ListNode root = new ListNode(0);
		
		root.next = new ListNode(0);
		root.next.next = new ListNode(1);
		root.next.next.next = new ListNode(21);
		root.next.next.next.next = new ListNode(12);
		root.next.next.next.next.next = new ListNode(14);
		root.next.next.next.next.next.next = new ListNode(0);
		root.next.next.next.next.next.next.next = new ListNode(19);
		root.next.next.next.next.next.next.next.next = new ListNode(0);
		
		ListNode ele = root;
		
		while(ele != null){
			System.out.print(ele.data + " ");
			ele = ele.next;
		}
		
		System.out.println("");
		
		printZeroInStart(root);
		
	}

}
