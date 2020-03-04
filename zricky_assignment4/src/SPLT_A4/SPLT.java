package SPLT_A4;

public class SPLT implements SPLT_Interface {
	private BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
	}

	public BST_Node getRoot() { // please keep this in here! I need your root node to test your tree!
		return root;
	}

	@Override
	public void insert(String s) {
		if (size == 0) {
			root = new BST_Node(s);
			size++;
		} else {
			root = root.insertNode(s);
			root.par = null;//
			if (root.getjustMade()) {
				size++;
			} else {
				root.setjustMade();
			}
		}
	}

	@Override
	public void remove(String s) {
		if (contains(s)) {

			BST_Node r = root.right;

			if (root.left != null) {
				root = root.left.findMax();
				root.right = r;
				if (root.right != null) {
					root.right.par = root;
				}
			} else {
				root = r;
			}

			if (root != null) {
				root.par = null;
			}
			size--;
		}
	}

	public String findMin() {
		if (root == null) {
			return null;
		} else {
			root = root.findMin();
			root.par = null;
			return root.getData();
		}
	}

	public String findMax() {
		if (root == null) {
			return null;
		} else {
			root = root.findMax();
			root.par = null;
			return root.getData();
		}
	}

	public boolean empty() {
		return (size == 0);
	}

	public boolean contains(String s) {
		if (size == 0) {
			return false;
		} else {
			root = root.containsNode(s);
			root.par = null;
			return (s.compareTo(root.getData()) == 0);

		}
	}

	public int size() {
		return size;
	}

	public int height() {
		if (size == 0) {
			return -1;
		} else {
			return root.getHeight();
		}
	}

}