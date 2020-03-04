package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	EntryPair[] array; // load this array
	private int size = 0;
	private static final int arraySize = 10000; // Everything in the array will initially
												// be null. This is ok! Just build out
												// from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); // 0th will be unused for simplicity
													// of child/parent computations...
													// the book/animation page both do this.
	}

	// Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}

	public void insert(EntryPair entry) {
		// O(log N)
		if (size == 0) {
			array[1] = entry;
			size++;
			return;
		} else {
			// swap values or bubble up

			array[size + 1] = entry;
			// bubble up
			int i = size + 1;
			while (array[i].priority < array[(int) Math.floor(i / 2)].priority) {

				EntryPair temp = array[(int) Math.floor(i / 2)];
				array[(int) Math.floor(i / 2)] = array[i];
				array[i] = temp;
				i = (int) Math.floor(i / 2);

			}
			size++;
			return;
		}

	}

	public void delMin() {
		// O(logN)
		if (size == 0) {
			return;
		} else {
			// bubble down
			// decrease size
			for (int i = 1; i < arraySize; i++) {
				if (array[i + 1] == null) {
					array[1] = array[i];
					array[i] = null;
					break;
				}
			}

			int i = 1;
			while (i < arraySize) {
				int z = 0;
				EntryPair temp;
				if (array[i * 2] != null && array[i * 2 + 1] != null) {
					if (array[i * 2 + 1].priority > array[i * 2].priority) {
						temp = array[i * 2];
						z = i * 2;
					} else {
						temp = array[i * 2 + 1];
						z = i * 2 + 1;
					}
					if (array[i].priority > array[z].priority) {
						array[z] = array[i];
						array[i] = temp;
						i = z;
					} else {
						break;
					}
				} else if (array[i * 2] != null) {
					if (array[i].priority > array[i * 2].priority) {
						temp = array[i * 2];
						array[i * 2] = array[i];
						array[i] = temp;
						i = i * 2;
					} else {
						break;
					}
				} else {
					break;
				}

			}
		}
		size--;

	}

	public EntryPair getMin() {
		// O(1)
		if (size == 0) {
			return null;
		} else {
			return array[1];
		}
	}

	public int size() {
		if (size < 0) {
			throw new IllegalArgumentException("Size is negative");
		} else {
			return size;
		}
	}

	public void build(EntryPair[] entries) {
		// O(N)+O(NlogN)
		if (entries == null) {
			return;
		}

		size = entries.length;
		// put the entries into the array
		// O(N)
		for (int i = 0; i < entries.length; i++) {
			array[i + 1] = entries[i];
		}
		// going up from leaf
		// O(N)

		int j = ((int) Math.floor(entries.length / 2));
		for (int i = j; i >= 1; i--) {
			int x = i;
			int z = 0;
			EntryPair temp;

			while (array[x * 2] != null) {
				if (array[x * 2] != null && array[x * 2 + 1] != null) {
					if (array[x * 2 + 1].priority > array[x * 2].priority) {
						temp = array[x * 2];
						z = x * 2;
					} else {
						temp = array[x * 2 + 1];
						z = x * 2 + 1;
					}
					if (array[x].priority > array[z].priority) {
						array[z] = array[x];
						array[x] = temp;
						x = z;
					} else {
						break;
					}
				} else if (array[x * 2] != null) {
					if (array[x].priority > array[x * 2].priority) {
						temp = array[x * 2];
						array[x * 2] = array[x];
						array[x] = temp;
						x = x * 2;
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}

	}

}
