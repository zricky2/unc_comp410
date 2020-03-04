package BST_A2;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;

	

	BST_Node(String data) {
		this.data = data;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	// --- end used for testing -------------------------------------------

	// --- fill in these methods ------------------------------------------
	//
	// at the moment, they are stubs returning false
	// or some appropriate "fake" value
	//
	// you make them work properly
	// add the meat of correct implementation logic to them

	// you MAY change the signatures if you wish...
	// make the take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public boolean containsNode(String s) {
		if (s.compareTo(getData()) == 0) {
			return true;
		} else if (s.compareTo(getData()) < 0) {
			if (getLeft() == null) {
				return false;
			} else {
				return getLeft().containsNode(s);
			}
		} else {
			if (s.compareTo(getData()) > 0) {
				if (getRight() == null) {
					return false;
				} else {
					return getRight().containsNode(s);
				}
			}
		}
		return false;
	}

	public boolean insertNode(String s) {
		// same value
		if (s.compareTo(getData()) == 0) {
			return false;
		// less than
		} else if (s.compareTo(getData()) < 0) {
			if (getLeft() == null) {
				left = new BST_Node(s);
				return true;
			} else {
				return left.insertNode(s);
			}
		// greater than
		} else {
			if (s.compareTo(getData()) > 0) {
				if (getRight() == null) {
					right = new BST_Node(s);
					return true;
				} else {
					return right.insertNode(s);
				}
			}
		}
		return false;
	}
	
	
	BST_Node prevNode = this;
	public boolean removeNode(String s) {
		// node is null
		if (s.compareTo(getData()) < 0) {
			if (left == null) {
				return false;
			} else {
				left.prevNode = this;
			return left.removeNode(s);
			}
		} else if (s.compareTo(getData()) > 0) {
			if (right == null) {
				return false;
			} else {
				right.prevNode = this;
			return right.removeNode(s);
			}
		
		// if the node is found
	} else if (s.compareTo(getData()) == 0) {
		System.out.println("Inside");
			// no children node
			if (left == null && right == null) {
				
				if (s.compareTo(prevNode.getData()) < 0) {
					prevNode.left = null;
					return true;
				} else {
					prevNode.right = null;
					return true;
				}
				// one child node
				// left child
			} else if (left != null && right == null) {
				if (left.data.compareTo(prevNode.getData()) < 0) {
					System.out.println("poiuytr");
					if (prevNode == this) {
						System.out.println("prevnode");
						prevNode = left;
					} else {
					prevNode.left = left;
					}
				} else {
					if (prevNode == this) {
						prevNode = left;
					} else {
					prevNode.right = left;
					}
				}
				return true;
				//right child
			} else if (left == null && right != null) {
				if (right.data.compareTo(prevNode.getData()) < 0) {
					if (prevNode == this) {
						prevNode = right;
					} else {
					prevNode.left = right;
					}
				} else {
					if (prevNode == this) {
						prevNode = right;
					} else {
					prevNode.right = right;
					}
				}
				
				return true;
				// two children node
			} else if (left != null && right != null) {
				// min right
				if (right.left == null) {
					if (left.right == null) {
						data = left.data;
						left = null;
						return true;
					}
					BST_Node parent = this;
					BST_Node current = left;
					while (current.right != null) {
						parent = current;
						current = current.right;
					}
					this.data = current.data; // replace the removed node
					parent.right = current.left; // change the link on the right
					return true;
				} else {
				BST_Node parent = this;
				BST_Node current = right;
				while (current.left != null) {
					parent = current;
					current = current.left;
				}
				this.data = current.data; // replace the removed node
				parent.left = current.right; // change the link on the right
				return true;
				}
			} else {
				return false;
			}
	}
			return false;
	
		}
	

	public BST_Node findMin() {
		if (getLeft() == null) {
			return this;
		} else {
			return getLeft().findMin();
		}
	}

	public BST_Node findMax() {
		if (getRight() == null) {
			return this;
		} else {
			return getRight().findMax();
		}
	}

	public int getHeight() {
		if (left == null && right == null) {
			return 0;
		} 
		int leftSide = 0;
			if (left != null) {
				leftSide = getLeft().getHeight();
			}
			int rightSide = 0;
			if (right != null) { 
				rightSide = getRight().getHeight();
			}
			
			if (leftSide >= rightSide) {
				
				return leftSide + 1;
			} else {
				
				return rightSide + 1;
		}
		
	}

	// --- end fill in these methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? left.data : "null") + ",Right: "
				+ ((this.right != null) ? right.data : "null");
	}

}