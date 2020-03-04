package BST_A2;

public class BST implements BST_Interface {

	public BST_Node root;
	int size;

	public BST() {
		size = 0;
		root = null;
	}

	// used for testing, please leave as is
	public BST_Node getRoot() {
		return root;
	}

	public boolean insert(String s) {

		if (size == 0) {
			BST_Node newNode = new BST_Node(s);
			root = newNode;
			size++;
			return true;
		} else {
			if (root.insertNode(s)) {
				size++;
				return true;
			}
		}
		return false;
	}

	public boolean remove(String s) {
		if (root == null) {
			return false;
		} else if (root.removeNode(s)) {
			size--;
			return true;
		} else {
			return false;
		}
	}

	public String findMin() {
		if (root == null) {
			return "Tree is empty";
		} else {
			return root.findMin().getData();

		}
	}

	public String findMax() {
		if (root == null) {
			return "Tree is empty";
		} else {
			return root.findMax().getData();
		}

	}

	public boolean empty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean contains(String s) {
		if (root == null) {
			return false;
		}
		return root.containsNode(s);
	}

	public int size() {
		return size;
	}

	public int height() {
		if (root == null) {
			return -1;
		} else {
			return root.getHeight();
		}
	}

}
