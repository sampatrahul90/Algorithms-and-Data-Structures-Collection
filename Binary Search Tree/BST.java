/**
 * 
 */
/**
 * @author {Rahul Sampat}
 * @file BST.java
 * {Algorithm Design and Analysis}
 */
public class BST implements Constants {

	/**
	 * @param args
	 */
	//Basic Variable Definition
	private static Node root;
	private static int inputValue,key;
	
	public static void main(String[] args) {
		
		System.out.println(ENTER_SIZE_INPUT_STRING);
		inputValue = sc.nextInt();
		
		System.out.println(ENTER_INPUT_STRING);
		for(int i = 0 ;i < inputValue;i++){
			insertNode(sc.nextInt());
		}
		
		System.out.print("Pre-order Traversel: ");
		preOrderWalk(root);
		System.out.println();
		System.out.print("Post-order Traversel: ");
		postOrderWalk(root);
		System.out.println();
		System.out.print("In-order Traversel: ");
		inOrderWalk(root);
		
		System.out.println("\n"+SEARCH_STRING);
		Node searchKeyOp = searchKey(sc.nextInt());
		if(searchKeyOp == null) System.out.print(NOT_FOUND);
		else System.out.println(searchKeyOp.getKey() + " Found.");
		
		System.out.println("\n"+DELETE_STRING);
		boolean deleteKeyOp = deleteNode(sc.nextInt());
		if(deleteKeyOp == true) System.out.print(NOT_FOUND);
		else System.out.println(" Deleted.");
		
	}

	private static void insertNode(int key){
		
		Node newNode = new Node(key);
		
		if(root == null){
			root = newNode;
		} else {
			
			Node currentNode,parent;
			currentNode = root;
			
			while(currentNode!=null){
				
				parent = currentNode;
				
				if(key < currentNode.getKey()){
					currentNode = currentNode.getLeft();
					
					if(currentNode == null){
						parent.left = newNode;
					}
				} else {
					currentNode = currentNode.getRight();
					
					if(currentNode == null){
						parent.right = newNode;
					}
				}
						
			}
			
		}
	}
	
	private static void preOrderWalk(Node root){
		if(root != null){
			System.out.print(root.getKey()+ " ");
			preOrderWalk(root.getLeft());
			preOrderWalk(root.getRight());
		}
	}
	private static void inOrderWalk(Node root) {
		if(root != null){
			inOrderWalk(root.getLeft());
			System.out.print(root.getKey()+ " ");
			inOrderWalk(root.getRight());
		}
	}
	private static void postOrderWalk(Node root) {
		if(root != null){
			postOrderWalk(root.getLeft());
			postOrderWalk(root.getRight());
			System.out.print(root.getKey()+ " ");
		}
	}
	
	private static boolean deleteNode(int key){
		
		Node deleteNode = root;
		Node parent = root;
		boolean isAtLeft = true;
		
		while(deleteNode != null){
			parent = deleteNode;
			
			if(key < deleteNode.getKey()){
				deleteNode = deleteNode.left;
				isAtLeft = true;
			} else {
				deleteNode = deleteNode.right;
				isAtLeft = false;
			}
		if(deleteNode == null){
			return false;
			}
		}
		
		//Delete the node if no child - left or right
		if(deleteNode.left == null && deleteNode.right == null){
			
			//Check if its root
			if(deleteNode == root) root = null;
			
			else if (isAtLeft) parent.left = null;
			
			else parent.right = null;
		}
		
		else if (deleteNode.right == null){
			
			//Check if the node is the root 
			if(deleteNode == root){
				root = deleteNode.left;
			}
			
			//Check if the left
			else if(isAtLeft)
				parent.left = deleteNode.left;
			
			//Only right child present
			else parent.right = deleteNode.left;
			}
		
		else if (deleteNode.left == null){
			
			//Check if the node is the root 
			if(deleteNode == root){
				root = deleteNode.right;
			}
			
			//Check if the left
			else if(isAtLeft)
				parent.left = deleteNode.right;
			
			//Only right child present
			else parent.right = deleteNode.right;
			}
		
		else {
			
			Node deleteTemp = findReplacement(deleteNode);
			
			if(deleteNode == root) root = deleteNode.right;
			else if(isAtLeft) parent.left = deleteTemp;
			else parent.right = deleteTemp;
			
			deleteTemp.left = deleteNode.left;
		}
		return true;
	}
	
	private static Node findReplacement(Node deleteNode) {
		
		Node temp = deleteNode;
		Node tempParent = deleteNode;
		
		deleteNode = deleteNode.right;
		
		while(deleteNode != null){
			tempParent = temp;
			temp = deleteNode;
			deleteNode = deleteNode.left;
		}
		
		if(temp != deleteNode.right){
			
			tempParent.left = temp.right;
			temp.right = deleteNode.right;
		}
		return temp;
	}

	private static Node searchKey(int key){
		
		Node traverseTree = root;
		while(traverseTree != null){
		if(traverseTree.getKey() == key){
			return traverseTree;
		}
		
		else if (key < traverseTree.getKey()){
			traverseTree = traverseTree.left;
		}
		
		else traverseTree = traverseTree.right;
	}
		return null;

	}
}