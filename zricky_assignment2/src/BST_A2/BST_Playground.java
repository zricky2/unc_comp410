package BST_A2;

public class BST_Playground {
	/*
	 * you will test your own BST implementation in here
	 *
	 * we will replace this with our own when grading, and will
	 * do what you should do in here... create BST objects,
	 * put data into them, take data out, look for values stored
	 * in it, checking size and height, and looking at the BST_Nodes
	 * to see if they are all linked up correctly for a BST
	 * 
	*/
	  
	  public static void main(String[]args){

	   // you should test your BST implementation in here
	   // it is up to you to test it thoroughly and make sure
	   // the methods behave as requested above in the interface
	  
	   // do not simple depend on the oracle test we will give
	   // use the oracle tests as a way of checking AFTER you have done
	   // your own testing

	   // one thing you might find useful for debugging is a print tree method
	   // feel free to use the printLevelOrder method to verify your trees manually
	   // or write one you like better
	   // you may wish to print not only the node value, and indicators of what
	   // nodes are the left and right subtree roots,
	   // but also which node is the parent of the current node
		  BST tree = new BST();
		  BST tree1 = new BST();
		  /* System.out.println(tree. insert("E")); // true
		  System.out.println(tree. insert("A")); // true
		  System.out.println(tree. insert("D")); //true
		  System.out.println(tree. insert("C")); //true
		  System.out.println(tree. insert("E")); //false
		  System.out.println(tree. insert("B")); // true
		  System.out.println(tree. insert("A")); // false
		  System.out.println(tree. insert("K")); //true
		  System.out.println(tree. insert("R")); //true
		  System.out.println(tree. insert("X")); // true
		  System.out.println(tree. remove("B")); //true
		  System.out.println(tree. insert("F")); // true
		  System.out.println(tree. insert("To"));
		  System.out.println(tree. insert("Pop"));
		  System.out.println(tree. insert("F"));
		  System.out.println(tree. insert("N"));
		  System.out.println(tree. insert("T"));
		  System.out.println(tree.remove("K")); // true
		  System.out.println(tree.remove("R"));
		  System.out.println(tree.remove("E"));
		  System.out.println(tree.remove("C"));
		  System.out.println(tree.remove("F"));
		  System.out.println(tree. height()); //4
		  System.out.println(tree. size());
		
		  printInOrder(tree.root);
		  */
		  System.out.println(tree1.insert("D"));
		  System.out.println(tree1. insert("A"));
		  printInOrder(tree1.root);
		  System.out.println(tree1. remove("D"));
		  printInOrder(tree1.root);
		  System.out.println(tree1. remove("D"));
		  printInOrder(tree1.root);
		  System.out.println(tree1. insert("Y"));
		  System.out.println(tree1. size());
		  
	  }

	  static void printLevelOrder(BST tree){ 
	  //will print your current tree in Level-Order...
	  //https://en.wikipedia.org/wiki/Tree_traversal
	    int h=tree.getRoot().getHeight();
	    for(int i=0;i<=h;i++){
	      printGivenLevel(tree.getRoot(), i);
	    }
	    
	  }
	  static void printGivenLevel(BST_Node root,int level){
	    if(root==null)return;
	    if(level==0)System.out.print(root.data+" ");
	    else if(level>0){
	      printGivenLevel(root.left,level-1);
	      printGivenLevel(root.right,level-1);
	    }
	  }
	  static void printInOrder(BST_Node root){
	  //will print your current tree In-Order
	  if(root!=null){
	    printInOrder(root.getLeft());
	    System.out.print(root.getData() + " ");
	    printInOrder(root.getRight());
	  }
	  
	  
	  
	  }
	}
