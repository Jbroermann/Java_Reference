package linked_list_excersie_lab;

import java.util.Stack;

public class Main {

	public static void printListIterative(LinearNode head) {
		//iterative version
		LinearNode current=head;
		while (current!=null) {
			System.out.print(current.getElement());
			if (current.getNext()!=null) {
				System.out.print(", ");
			}
			current=current.getNext();
		}
		System.out.println();
	}
	
	public static void printListRecursive(LinearNode head) {
		//System.out.println("printListRecursive being implemented: ");
		System.out.print(head.getElement() + ", ");
		if(head.getNext() != null) {
			printListRecursive(head.getNext());
		} 
		else {
			System.out.println();
		}
	}
		
	public static LinearNode reverseList(LinearNode oldHead) {
		
		Stack<LinearNode> revStack = new Stack<LinearNode>();
		while(oldHead != null) {
			revStack.push(oldHead);
			oldHead = oldHead.getNext();
		}
		oldHead = revStack.pop(); //needs if case
		LinearNode current = oldHead;
		while(!revStack.isEmpty()) {
			current.setNext(revStack.pop());
			current = current.getNext();
		}
		
		return oldHead;
		/*if(!revStack.isEmpty()) {
			LinearNode newHead = revStack.pop();
			LinearNode temp = revStack.pop();
			newHead.setNext(temp);
			while(!revStack.isEmpty()) {
				temp=temp.getNext();
				temp.setNext(revStack.pop());
			}
			return newHead;
		}
		else {
			return null;
		}*/
	}
	
	public static void main(String[] args) {
		// create a linked list
		LinearNode n1 = new LinearNode(1);
		LinearNode n2 = new LinearNode(2);
		LinearNode n3 = new LinearNode(3);
		LinearNode n4 = new LinearNode(4);
		LinearNode n5 = new LinearNode(5);
		LinearNode n6 = new LinearNode(6);
		LinearNode n7 = new LinearNode(7);
		
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		
		//alias n1 as head
		LinearNode head = n1;
		printListIterative(head);
		printListRecursive(head);
		head = reverseList(head);
		System.out.println("printing reversed list:");
		printListIterative(head);
		printListRecursive(head);
		
		//time permitting: write a recursive method that prints the list in reverse
		// (without actually reversing the list)
//		System.out.println("now print in reverse (without reversing):");
//		printListReverseRecursive(head);
//		System.out.println("done.");
	}

}
