package tree_stuff;

public class BinaryTreeNode<T> {
	protected T data;
	protected BinaryTreeNode<T> left;
	protected BinaryTreeNode<T> right;
	
	public BinaryTreeNode(T data) {
		this.data=data;
		left=null;
		right=null;
	}
	
	public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
		this.data=data;
		this.left=left;
		this.right=right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}
	
	// count children
	public int countDescendants() {
		int count = 0;
		if(this.right != null) {
			count++;
			count += right.countDescendants();
		}
		if(this.left != null) {
			count++;
			count += left.countDescendants();
		}
		return count;
	}
}
