
public class Edge {
	private Node node1;
	private Node node2;
	private int weight;
	
	public Edge(Node node1, Node node2, int weight){
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
		node1.addEdge(this);
		node2.addEdge(this);
		node1.addPossibleNode(node2);
		node2.addPossibleNode(node1);
	}
	
	public boolean equals(Edge edge){
		return (this.node1.equals(edge.node1) && this.node2.equals(edge.node2) && (this.weight == edge.weight));
	}
	
	public Node getNode1(){
		return this.node1;
	}
	
	public Node getNode2(){
		return this.node2;
	}
	
	public int getWeight(){
		return this.weight;
	}
}
