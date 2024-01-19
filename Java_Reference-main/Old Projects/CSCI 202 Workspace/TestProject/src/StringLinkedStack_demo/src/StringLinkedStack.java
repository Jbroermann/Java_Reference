package StringLinkedStack_demo.src;


public class StringLinkedStack {
	private StringLinkedNode top;
	
	public StringLinkedStack() {
		top=null;
	}
	
	public void push(String elem) {
		StringLinkedNode node = new StringLinkedNode(elem);
		node.setNext(top);
		top = node;
	}
	
	public String pop() {
		StringLinkedNode n = top;
		top = top.getNext();
		return n.getElement();
	}

	public int size() {
		if (top == null) {
			return 0;
		}
		int size = 1;
		StringLinkedNode node = top;
		while(node.getNext() != null) {
			size++;
			node = node.getNext();
		}
		return size;
	}
	
	@Override
	public String toString() {
		if (top == null) {
			return "Stack Empty";
		}
		StringLinkedNode node = top;
		String string = node.getElement();
		while(node.getNext() != null) {
			node = node.getNext();
			string = String.join("-->", string, node.getElement());
		}
		
		return string;
	}
	
	
}
