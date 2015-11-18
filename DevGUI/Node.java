import java.util.Comparator;
import java.util.LinkedList;

public class Node{
	
	private int x;
	private int y;
	private NodeType type;
	private Node parent;
	private LinkedList<Node> possibleNodes;
	private String name;
	private int number;
	private LinkedList<Edge> EdgesList = new LinkedList<Edge>();
	private int priority;
//	private double distance;		//heuristic

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
//	public Node(int x, int y, Node goal) {
//		this.x = x;
//		this.y = y;
//		this.distance = Math.sqrt((this.getX()-goal.getX())+(this.getY()-goal.getY()));
//	}
	
	
	public Node() {
		
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	public void setPriority(int priority){ //>0
		this.priority = priority;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setParent(Node node) {
		this.parent = node;
	}
	
	public void setEdgesList(LinkedList<Edge> EdgesList){
		this.EdgesList = EdgesList;
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

	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}
	
	public int compareTo(Node n) {
		return getType().compareTo(n.getType());
	}
	
//	public boolean equals(Node n) {
//		return (this.getNumber() == n.getNumber()); 
//	}

	public boolean equals(Node n){
		return ((this.x == n.x) && (this.y == n.y));
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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
			if((this.equals(EdgesList.get(i).node1) && n2.equals(EdgesList.get(i).node2)) ||
					(this.equals(EdgesList.get(i).node2) && n2.equals(EdgesList.get(i).node1))){
				return (Integer) EdgesList.get(i).weight;
			}
		}
		return 0;
	}
	
public int compare(Node node1, Node node2) {
		
		return node2.getPriority() - node1.getPriority();
	}
//	public double getDistance() {
//		//this.distance = Math.sqrt((this.getX()-goal.getX())+(this.getY()-goal.getY()));
//		return distance;
//	}
//	public void setDistance(Node goal) {
//		this.distance = Math.sqrt((this.getX()-goal.getX())+(this.getY()-goal.getY()));
//	}
//	
//	public int compareTo(Node compareNode) {
//		int compareDistance = (int) compareNode.getDistance();
//		
//		return (int) this.getDistance() - compareDistance;
//	}
}