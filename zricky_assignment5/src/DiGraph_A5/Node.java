package DiGraph_A5;

import java.util.*;

public class Node {
	
	private long idNum;
	private String label;
	private HashMap <String, Node> destin = new HashMap<String, Node>();
	//string: destination, Node: destination node
	private HashMap<String, Edge> edges = new HashMap<String, Edge>();
	// string: destination 
	
	
	
	public Node (long idNum, String label) {
		this.idNum = idNum;
		this.label = label;     
		
	}
	
	public long getidNum() {
		return idNum;
	}
	
	public String getLabel() {
		return label;
	}
	
	public boolean containsDestin(String s) {
		return destin.containsKey(s);
	}
	
	public void addDestin(String s, Node node) {
		destin.put(s,node);
	}
	
	public HashMap<String, Node> getDestin() {
		return destin;
	}
	public Node [] getDestinations() {
		Node[] destins = new Node[destin.size()];
		int i=0;
		for (Node n : destin.values()) {
			destins[i] = n;
			i++;
		}
		return destins;
	}
	
	public void addEdge(String s, Edge e) {
		edges.put(s,e);
	}
	
	public Edge getEdge(String s) {
		return edges.get(s);
	}
	
	public HashMap<String, Edge> getEdges() {
		return edges;
	}
	
	public void setDestin(HashMap<String, Node> hash) {
		destin = hash;
	}
	public void setEdges(HashMap<String, Edge> hash) {
		edges = hash;
	}
	public void removeDestin(String s) {
		destin.remove(s);
	}
	public void removeEdge(String s) {
		edges.remove(s);
	}
	public int numEdges() {
		return edges.size();
	}
}
