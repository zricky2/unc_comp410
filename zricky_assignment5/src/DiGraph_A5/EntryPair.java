package DiGraph_A5;

import java.util.*;

public class EntryPair implements Comparable<EntryPair>{
	public String value;
	  public int distance;

	  public EntryPair(String aValue, int aPriority) {
	    value = aValue;
	    distance = aPriority;
	  }
	public String getvalue() {
		// TODO Auto-generated method stub
		return value;
	}

	public int getPriority() {
		// TODO Auto-generated method stub
		return distance;
	}
	
	public boolean equals(EntryPair other) {
		return getPriority() == (other.getPriority());
	}
	
	public int compareTo (EntryPair other) {
		if (equals(other)) {
			return 0;
		} else if (getPriority() > other.getPriority()) {
			return 1;
		} else {
			return -1;
		}
	}
}
