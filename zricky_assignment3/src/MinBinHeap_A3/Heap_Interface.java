package MinBinHeap_A3;

public interface Heap_Interface {

	void insert(EntryPair entry);

	void delMin();

	EntryPair getMin();

	int size();

	void build(EntryPair[] entries);

	EntryPair[] getHeap();
}
