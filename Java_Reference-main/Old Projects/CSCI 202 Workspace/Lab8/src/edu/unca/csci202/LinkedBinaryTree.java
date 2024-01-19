package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Tree data structure
 *
 * @param <T>
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {	
	// instance variables
	protected BinaryTreeNode<T> root;
	protected int modCount; // 
	
	// Constructors
	public LinkedBinaryTree() {
		this.root = null;
	}
	public LinkedBinaryTree(T data) {
		this.root =  new BinaryTreeNode<T>(data);
	}
	public LinkedBinaryTree(T data, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
		this.root = new BinaryTreeNode<T>(data);
		if (left!=null) {
			this.root.setLeft( left.getRootNode()  );
		}
		if (right!=null) {
			this.root.setRight( right.getRootNode() );
		}
	}
	
	
	/**
	 * Print the tree
	 */
	public String toString() {
		return print(root, 0);
	}
	
	/** 
	 * Print a subtree
	 */
	String print(BinaryTreeNode<T> node, int level) {
		String ret = "";
		if(node != null) {
			for(int i=0;i<level;i++) {
				ret += "\t";
			}
			ret += node.getData();
			ret += "\n";
			// recurse left
			ret += print(node.getLeft(), level+1);
			// recurse right
			ret += print(node.getRight(), level+1);
		}
		return ret;
	}
	
	
	/** return the root node of this subtree
	 * 
	 * @return root node of sub tree
	 */
	public BinaryTreeNode<T> getRootNode(){
		return this.root;
	}

	@Override
	public T getRootElement() {
		if(root == null) {
			return null;
		}
		return this.root.getData();
	}

	@Override
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		return root.countDescendants() + 1;
	}

	@Override
	public boolean contains(T targetElement) {
		// implement this method
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) {
			if(itr.next().equals(targetElement)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public T find(T targetElement) throws ElementNotFoundException {
		// implement this method
		Iterator<T> itr = this.iterator();
		while(itr.hasNext()) {
			if(itr.next().equals(targetElement)) {
				return targetElement;
			}
		}
		throw new ElementNotFoundException(null);
	}

	@Override
	public Iterator<T> iterator() {
		// implement this method
		return iteratorInOrder();
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		// implement this method
		LinkedList<T> list = new LinkedList<T>();
		//Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
		traverseInOrder(root, list);
		return list.iterator();
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// implement this method
		LinkedList<T> list = new LinkedList<T>();
		traversePostOrder(root, list);
		return list.iterator();
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		//implement this method
		LinkedList<T> list = new LinkedList<T>();
		Queue<BinaryTreeNode<T>> que = new ArrayDeque<BinaryTreeNode<T>>();
		traverseLevelOrder(root, list, que);
		return list.iterator();
	}
		
	@Override
	public Iterator<T> iteratorPreOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traversePreOrder( root, list);
		return list.iterator();
	}

	/**
	 * Recursive helper method for iteratorPreOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in preorder
	 */
	private void traversePreOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if(node != null) {
			// visit node
			list.add( node.getData() );
			//recurse left
			traversePreOrder( node.getLeft(), list);
			//recurse right
			traversePreOrder( node.getRight(), list);
		}
	}
	/**
	 * Recursive helper method for iteratorInOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in inorder
	 */
	private void traverseInOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if(node != null) {
			//recurse left
			traverseInOrder(node.getLeft(), list);
			//visit node
			list.add(node.getData());
			//recurse right
			traverseInOrder(node.getRight(), list);
		}
	}
	/**
	 * Recursive helper method for iteratorPostOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in postorder
	 */
	private void traversePostOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		if(node != null) {
			traversePostOrder(node.getLeft(), list);
			traversePostOrder(node.getRight(), list);
			list.add(node.getData());
		}
	}

	/**
	 * Recursive helper method for iteratorLevelOrder
	 * 
	 * @param node the root of the subtree
	 * @param list list that is built in level order
	 * @param que a queue that contains level information
	 */
	private void traverseLevelOrder(BinaryTreeNode<T> node, LinkedList<T> list, Queue<BinaryTreeNode<T>> que) {
		if(node != null) { //I'm not sure if this is actually right
			list.add(node.getData());
			if(node.getLeft() != null) {
				que.add(node.getLeft());
			}
			if(node.getLeft() != null) {
				que.add(node.getRight());
			}
			while(!que.isEmpty()) {
				traverseLevelOrder(que.remove(), list, que);
			}
		}
	}
}
