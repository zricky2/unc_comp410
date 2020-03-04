package MinBinHeap_A3;
public class MinBinHeap_Playground {
public static void main(String[] args){   
    //Add more tests as methods and call them here!!
    //TestBuild();
    MinBinHeap test = new MinBinHeap();
    EntryPair [] t = new EntryPair[11];
    /*t[0] = new EntryPair("a", 5);
    t[1] = new EntryPair("b", 4);
    t[2] = new EntryPair("c", 3);
    t[3] = new EntryPair("d", 2);
    t[4] = new EntryPair("e", 1);
    */
    
    t[0] = new EntryPair("e", 10);
    t[1] = new EntryPair("heart failure", 1);
    t[2] = new EntryPair("c", 8);
    t[3] = new EntryPair("b", 16);
    t[4] = new EntryPair("a", 4);
    t[5] = new EntryPair("paper cut", 40);
    t[6] = new EntryPair("a", 13);
    t[7] = new EntryPair("a", 6);
    t[8] = new EntryPair("a", 12);
    t[9] = new EntryPair("a", 7);
    t[10] = new EntryPair("j", 3);
    test.build(t);
    EntryPair one1 = new EntryPair("lo",23);
    EntryPair one2 = new EntryPair("brain trauma",2);
    EntryPair one3 = new EntryPair("c",30);
    EntryPair one4 = new EntryPair("broken hand",11);
    EntryPair one5 = new EntryPair("e",131);
    EntryPair one6 = new EntryPair("f",5);
    test.insert(one1);
    test.insert(one2);
    test.insert(one3);
    test.insert(one4);
    //test.delMin();
    test.insert(one5);
    //test.delMin();
    test.insert(one6);
    //test.delMin();
    //test.delMin();
    //test.size(); 
    //test.delMin();
	
    //test.build(t);
    printHeapCollection(test.array);
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
    MinBinHeap mbh= new MinBinHeap();
    EntryPair[] collection= new EntryPair[8];
    collection[0]=new EntryPair("i",3);
    collection[1]=new EntryPair("b",5);
    collection[2]=new EntryPair("c",1);
    collection[3]=new EntryPair("d",0);
    collection[4]=new EntryPair("e",46);
    collection[5]=new EntryPair("f",5);
    collection[6]=new EntryPair("g",6);
    collection[7]=new EntryPair("h",17);
    mbh.build(collection);
    printHeapCollection(collection);
    printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=1;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
}