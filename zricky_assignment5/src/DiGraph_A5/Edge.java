package DiGraph_A5;

public class Edge {
	private long idNum;
	private String sLabel;
	private String dLabel;
	private long weight;
	private String eLabel;
	
	
	public Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		this.idNum = idNum;
		this.sLabel = sLabel;
		this.dLabel = dLabel;
		this.weight = weight;
		this.eLabel = eLabel;
	}
	
	public long getidNum() {
		return idNum;
	}

	public String getsLabel() {
		return sLabel;
	}

	public String getdLabel() {
		return dLabel;
	}

	public long getweight() {
		return weight;
	}

	public String geteLabel() {
		return eLabel;
	}
}
