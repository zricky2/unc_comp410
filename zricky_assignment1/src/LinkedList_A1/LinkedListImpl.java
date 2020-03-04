package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	private Node sentinel; // this will be the entry point to your linked list (the head)
	private int size =0;
	public LinkedListImpl() {// this constructor is needed for testing purposes. Please don't modify!
		sentinel = new Node(0); // Note that the root's data is not a true part of your data set!
	}

	// implement all methods in interface, and include the getRoot method we made
	// for testing purposes.
	// Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	public boolean insert(double elt, int index) {
		 if(index < 0 || index > size) {
			  return false;
		  }
		Node newNode = new Node(elt);
		Node currentNode = sentinel;
		// empty list
		if (size == 0) {
			sentinel.next = newNode;
			sentinel.prev = newNode;
			newNode.next = sentinel;
			newNode.prev = sentinel;
			size++;
			return true;
		}
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				Node prevNode = currentNode;
				Node nextNode = currentNode.getNext();
				newNode.next = nextNode;
				newNode.prev = prevNode;
				nextNode.prev = newNode;
				prevNode.next = newNode;
				size++;
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}

	public boolean remove(int index) {
		 if(index < 0 || index >= size) {
			  return false;
		  }
		Node currentNode = sentinel.getNext();
		Node prevNode;
		Node nextNode;
		// empty list
		if (size == 0) {
			return false;
		}
		// one element
		if (size == 1) {
			sentinel.next = null;
			sentinel.prev = null;
			size--;
			return true;
		}
		for (int i = 0; i <= index; i++) {
			if (currentNode == sentinel || currentNode == null) {
				return false;
			}
			if (i == index) {
				prevNode = currentNode.getPrev();
				nextNode = currentNode.getNext();
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				size--;
				return true;
			}
			currentNode = currentNode.getNext();
		}
		return false;
	}

	public double get(int index) {
		 if(index < 0 || index >= size) {
			  return Double.NaN;
		  }		 
		Node currentNode = sentinel.getNext();
		
		for (int i = 0; i <= index; i++) {
			if (currentNode == null || currentNode == sentinel) {
				return Double.NaN;
			}
			if (i == index) {
				return currentNode.getData();
			}
			currentNode = currentNode.getNext();
		}
		return Double.NaN;
	}

	public int size() {
		if (sentinel.getNext() == null) {
			return 0;
		} else {
			Node currentNode = sentinel.getNext();
			int i = 0;
			while (currentNode != sentinel) {
				i++;
				currentNode = currentNode.getNext();
			}
			return i;
		}

	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void clear() {
		sentinel.next = null;
		sentinel.prev = null;
		size = 0;
		return;
	}

}
