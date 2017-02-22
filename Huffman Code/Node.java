/**
 * 
 */

/**
 * @author {Rahul Sampat}
 * @file BSTNode.java
 * {Algorithm Design and Analysis}
 * {The Basic Structure of a node with references}
 */
public class Node {
	
	Node left;
	Node right;
	private int key;
	
	//This is used to initialise the tree
	Node(int key){
		left = null;
		right = null;
		this.setKey(key);
	}

	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	
}