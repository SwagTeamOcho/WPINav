import java.util.Comparator;
import java.util.LinkedList;

public class Node{
	
	private int x;
	private int y;
	//private NodeType type;
	private LinkedList<Node> possibleNodes;
	private String name;
	private LinkedList<Edge> EdgesList;
	private int priority;
//	private double distance;		//heuristic

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.name = "";
		this.possibleNodes = new LinkedList<Node>();
		this.EdgesList = new LinkedList<Edge>();
	}
	
	public Node(int x, int y, String name){
		this.x = x;
		this.y = y;
		this.name = name;
		this.possibleNodes = new LinkedList<Node>();
		this.EdgesList = new LinkedList<Edge>();
	}
	 
	
	public int getPriority(){
		return this.priority;
	}
	
	public void setPriority(int priority){ //>0
		this.priority = priority;
	}
	
	
	public void setEdgesList(LinkedList<Edge> EdgesList){
		this.EdgesList = EdgesList;
	}
	
	public LinkedList<Edge> getEdgesList(){
		return this.EdgesList;
	}
//	public LinkedList<Node> getPossibleNodes(LinkedList<Node> visited) {
//		LinkedList<Node> nodeList = new LinkedList<Node>();
//		for(int i = 0; i < possibleNodes.size(); i++) {
//			if(!visited.contains(possibleNodes.get(i))) {
//				nodeList.add(possibleNodes.get(i));
//			}
//		}
//		return nodeList;
//	}
	
	public LinkedList<Node> getPossibleNodes(){
		return this.possibleNodes;
	}
	
	public void setPossibleNodes(LinkedList<Node> possibleNodes) {
		this.possibleNodes = possibleNodes;
	}
	
	public void addPossibleNode(Node node) {
		this.possibleNodes.add(node);
	}

//	public NodeType getType() {
//		return type;
//	}
//
//	public void setType(NodeType type) {
//		this.type = type;
//	}
//	
	public boolean equals(Node n){
		return ((this.x == n.x) && (this.y == n.y));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Integer getCost(Node n2){
		for(int i = 0; i < this.EdgesList.size(); i++){
			if((this.equals(EdgesList.get(i).getNode1()) && n2.equals(EdgesList.get(i).getNode2())) ||
					(this.equals(EdgesList.get(i).getNode2()) && n2.equals(EdgesList.get(i).getNode1()))){
				return (Integer) EdgesList.get(i).getWeight();
			}
		}
		return -1;
	}
	
	public void addEdge(Edge edge){
		this.EdgesList.add(edge);
	}
}