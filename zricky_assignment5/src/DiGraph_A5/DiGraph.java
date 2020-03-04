package DiGraph_A5;

import java.util.*;

public class DiGraph implements DiGraphInterface {

	private HashMap<String, Node> nodes = new HashMap<String, Node>();
	private HashSet<Long> nodeId = new HashSet<Long>();
	private HashSet<Long> edgeId = new HashSet<Long>();

	public DiGraph() {
	}

	@Override
	public boolean addNode(long idNum, String label) {
		if (idNum < 0 || nodeId.contains(idNum) || label == null || nodes.containsKey(label)) {
			return false;
		} else {
			nodeId.add(idNum);
			nodes.put(label, new Node(idNum, label));
			return true;
		}
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		if (idNum < 0 || edgeId.contains(idNum) || !nodes.containsKey(sLabel) || !nodes.containsKey(dLabel)
				|| nodes.get(sLabel).containsDestin(dLabel)) {
			return false;
		} else {
			edgeId.add(idNum);

			Node newNode = nodes.get(sLabel);
			newNode.addDestin(dLabel, nodes.get(dLabel));
			newNode.addEdge(dLabel, new Edge(idNum, sLabel, dLabel, weight, eLabel));
			nodes.replace(sLabel, newNode);
			return true;
		}
	}

	public boolean addEdge(long idNum, String sLabel, String dLabel) {
		return addEdge(idNum, sLabel, dLabel, 1, null);
	}

	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight) {
		return addEdge(idNum, sLabel, dLabel, weight, null);
	}

	@Override
	public boolean delNode(String label) {
		if (!nodes.containsKey(label)) {
			return false;
		} else {
			for (Edge value : nodes.get(label).getEdges().values()) {
				edgeId.remove(value.getidNum());
			}
			nodeId.remove(nodes.get(label).getidNum());
			nodes.remove(label);
			return true;
		}
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		if (!nodes.containsKey(sLabel) || !nodes.containsKey(dLabel) || !nodes.get(sLabel).containsDestin(dLabel)) {
			return false;
		} else {
			edgeId.remove(nodes.get(sLabel).getEdge(dLabel).getidNum());

			HashMap<String, Edge> newEdges = nodes.get(sLabel).getEdges();
			newEdges.remove(dLabel);

			HashMap<String, Node> newDestin = nodes.get(sLabel).getDestin();
			newDestin.remove(dLabel);

			Node newNode = nodes.get(sLabel);
			newNode.setEdges(newEdges);
			newNode.setDestin(newDestin);
			nodes.replace(sLabel, newNode);

			return true;
		}
	}

	@Override
	public long numNodes() {

		return nodes.size();
	}

	@Override
	public long numEdges() {
		int count = 0;
		for (Node n : nodes.values()) {
			count += n.numEdges();
		}
		return count;
	}

	// in: string label for start vertex return: array of ShortestPathInfo objects
	// (ShortestPathInfo) length of this array should be numNodes (as you will put
	// in all shortest paths including from source to itself) See ShortestPathInfo
	// class for what each field of this object should contain

	public ShortestPathInfo[] shortestPath(String label) {
		if (!nodes.containsKey(label)) {
			System.out.println("Input given does not exist");
			return null;
		}
		HashMap<String, Integer> distances = new HashMap<String, Integer>();
		HashMap<String, Node> unvisited = new HashMap<String, Node>();
		PriorityQueue<EntryPair> shortPath = new PriorityQueue<EntryPair>();
		
		for (Node n : nodes.values()) {
			unvisited.put(n.getLabel(), n);
			if (n.getLabel() != label) {
				distances.put(n.getLabel(), (int) Double.POSITIVE_INFINITY);
			} else {
				distances.put(n.getLabel(), 0);
				shortPath.add(new EntryPair(n.getLabel(), 0));
			}
		}
		
		while (!shortPath.isEmpty()) {
			Node current = nodes.get(shortPath.peek().getvalue());
			shortPath.remove();
			if (!unvisited.containsKey(current.getLabel())) {
				continue;
			} else {
				for (Node n : current.getDestinations()) {
					long total = distances.get(current.getLabel()) + current.getEdge(n.getLabel()).getweight();
					long vWeight = distances.get(n.getLabel());
					if (total < vWeight) {
						distances.replace(n.getLabel(),(int) total);
						shortPath.add(new EntryPair(n.getLabel(),(int) total));
					}
				}
			
				unvisited.remove(current.getLabel());
			}
			
		}
		
		System.out.println("Start vertex: " + label);
		ShortestPathInfo[] shortestPath = new ShortestPathInfo[(int) numNodes()];
		int i =0;
		for (Node n : nodes.values()) {
			if (unvisited.containsKey(n.getLabel())) {
				shortestPath[i] = new ShortestPathInfo(n.getLabel(), (long) -1);
			} else {
			shortestPath[i] = new ShortestPathInfo(n.getLabel(), distances.get(n.getLabel()));
			}
			System.out.println(shortestPath[i].toString());
			i++;
		}
		
		return shortestPath;
	}

}
