package SPLT_A4;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par; // parent...not necessarily required, but can be useful in splay tree
	private boolean justMade; // could be helpful if you change some of the return types on your BST_Node
	// insert.
	// I personally use it to indicate to my SPLT insert whether or not we increment
	// size.

	BST_Node(String data) {
		this.data = data;
		this.justMade = true;
	}

	BST_Node(String data, BST_Node left, BST_Node right, BST_Node par) { // feel free to modify this constructor to suit
																			// your needs
		this.data = data;
		this.left = left;
		this.right = right;
		this.par = par;
		this.justMade = true;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is (meaning also make sure they do in fact
	// return data,left,right respectively)

	public String getData() {
		return data;
	}

	public BST_Node getLeft() {
		return left;
	}

	public BST_Node getRight() {
		return right;
	}

	public boolean getjustMade() {
		return justMade;
	}

	public void setjustMade() {
		justMade = false;
	}

	// --- end used for testing -------------------------------------------

	// --- Some example methods that could be helpful
	// ------------------------------------------
	//
	// add the meat of correct implementation logic to them if you wish

	// you MAY change the signatures if you wish...names too (we will not grade on
	// delegation for this assignment)
	// make them take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public BST_Node containsNode(String s) {
		if (s.compareTo(getData()) == 0) {
			return splay(this);
			// return this;
		} else if (s.compareTo(getData()) < 0) {
			if (getLeft() == null) {
				return splay(this);
			} else {
				return getLeft().containsNode(s);
			}
		} else {
			if (s.compareTo(getData()) > 0) {
				if (getRight() == null) {
					return splay(this);
				} else {
					return getRight().containsNode(s);
				}
			}
		}
		return null;
	}
	// note: I personally find it easiest to make this return a Node,(that being the
	// node splayed to root), you are however free to do what you wish.

	public BST_Node insertNode(String s) {
		if (s.compareTo(getData()) == 0) {
			this.justMade = false;
			return splay(this);
			// less than
		} else if (s.compareTo(getData()) < 0) {
			if (getLeft() == null) {
				left = new BST_Node(s);
				left.par = this;
				return splay(left);

			} else {
				return left.insertNode(s);
			}
			// greater than
		} else {
			if (s.compareTo(getData()) > 0) {
				if (getRight() == null) {
					right = new BST_Node(s);
					right.par = this;
					return splay(right);

				} else {
					return right.insertNode(s);
				}
			}
		}
		return null;
	}

	public boolean removeNode(String s) {
		return false;
	}

	public BST_Node findMin() {
		if (getLeft() == null) {
			return splay(this);
		} else {
			return getLeft().findMin();
		}
	}

	public BST_Node findMax() {
		if (getRight() == null) {
			return (splay(this));
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

	private BST_Node splay(BST_Node toSplay) {
		while (toSplay.par != null) {
			if (toSplay.par.par == null) {
				if (toSplay == toSplay.par.left) {
					rotateRight(toSplay);
				} else {
					rotateLeft(toSplay);
				}
			} else if (toSplay.par == toSplay.par.par.left && toSplay == toSplay.par.left) {
				zigZigLeft(toSplay);
			} else if (toSplay.par == toSplay.par.par.right && toSplay == toSplay.par.right) {
				zigZigRight(toSplay);
			} else if (toSplay.par == toSplay.par.par.left && toSplay == toSplay.par.right) {
				zigZagLeft(toSplay);
			} else {
				zigZagRight(toSplay);
			}
		}
		return toSplay;

	}

	private void rotateRight(BST_Node node) {
		BST_Node temp = node.right;
		node.par.left = temp;
		node.right = node.par;

		node.right.par = node;
		if (node.right.left != null) {
			node.right.left.par = node.right;
		}
		node.par = null;

	}

	private void rotateLeft(BST_Node node) {
		BST_Node temp = node.left;
		node.par.right = temp;
		node.left = node.par;

		node.left.par = node;//
		if (node.left.right != null) {
			node.left.right.par = node.left;
		}
		node.par = null;

	}

	private void zigZigLeft(BST_Node toSplay) {
		BST_Node temp = toSplay.par.par.par;
		if (toSplay.par.right != null) {
			toSplay.par.right.par = toSplay.par.par;
		}
		toSplay.par.par.left = toSplay.par.right;
		if (toSplay.right != null) {
			toSplay.right.par = toSplay.par;
		}
		toSplay.par.left = toSplay.right;
		
		toSplay.par.right = toSplay.par.par;
		
		toSplay.right = toSplay.par;

		if (toSplay.par.par.par != null) {
			if (toSplay.par.par.par.left == toSplay.par.par) {
				toSplay.par.par.par.left = toSplay;
			} else {
				toSplay.par.par.par.right = toSplay;
			}
			toSplay.par.par.par = toSplay.par;
			toSplay.par.par = toSplay;
			toSplay.par = temp;

		} else {
			toSplay.par.par.par = toSplay.par;
			toSplay.par.par = toSplay;
			toSplay.par = null;

		}
	}

	private void zigZigRight(BST_Node toSplay) {
		BST_Node temp = toSplay.par.par.par;
		if (toSplay.par.left != null) {
			toSplay.par.left.par = toSplay.par.par;
		}
		toSplay.par.par.right = toSplay.par.left;
		if (toSplay.left != null) {
			toSplay.left.par = toSplay.par;
		}
		toSplay.par.right = toSplay.left;
		
		toSplay.par.left = toSplay.par.par;
		
		toSplay.left = toSplay.par;

		if (toSplay.par.par.par != null) {
			if (toSplay.par.par.par.left == toSplay.par.par) {
				toSplay.par.par.par.left = toSplay;
			} else {
				toSplay.par.par.par.right = toSplay;
			}
			toSplay.par.par.par = toSplay.par;
			toSplay.par.par = toSplay;
			toSplay.par = temp;

		} else {
			toSplay.par.par.par = toSplay.par;
			toSplay.par.par = toSplay;
			toSplay.par = null;

		}
	}

	private void zigZagLeft(BST_Node toSplay) {
		BST_Node temp = toSplay.par.par.par;
		if (toSplay.right != null) {
			toSplay.right.par = toSplay.par.par;
		}
		toSplay.par.par.left = toSplay.right;
		if (toSplay.left != null) {
			toSplay.left.par = toSplay.par;
		}
		toSplay.par.right = toSplay.left;
		
		toSplay.left = toSplay.par;
		
		toSplay.right = toSplay.par.par;

		if (toSplay.par.par.par != null) {
			if (toSplay.par.par.par.left == toSplay.par.par) {
				toSplay.par.par.par.left = toSplay;
			} else {
				toSplay.par.par.par.right = toSplay;
			}
			toSplay.par.par.par = toSplay;
			toSplay.par.par = toSplay;
			toSplay.par = temp;

		} else {
			toSplay.par.par.par = toSplay;
			toSplay.par.par = toSplay;
			toSplay.par = null;
		}

	}

	private void zigZagRight(BST_Node toSplay) {
		BST_Node temp = toSplay.par.par.par;
		if (toSplay.left != null) {
			toSplay.left.par = toSplay.par.par;
		}
		toSplay.par.par.right = toSplay.left;
		if (toSplay.right != null) {
			toSplay.right.par = toSplay.par;
		}
		toSplay.par.left = toSplay.right;
		
		toSplay.left = toSplay.par.par;

		toSplay.right = toSplay.par;

		if (toSplay.par.par.par != null) {
			if (toSplay.par.par.par.left == toSplay.par.par) {
				toSplay.par.par.par.left = toSplay;
			} else {
				toSplay.par.par.par.right = toSplay;
			}
			toSplay.par.par.par = toSplay;
			toSplay.par.par = toSplay;
			toSplay.par = temp;

		} else {
			toSplay.par.par.par = toSplay;
			toSplay.par.par = toSplay;
			toSplay.par = null;
		}
	}

}
