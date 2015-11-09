import java.util.LinkedList;

public class Node implements Comparable<Node>{
	
	private int x;
	private int y;
	private Node parent;
	private LinkedList<Node> possibleNodes;
	private double distance;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Node(int x, int y, Node goal) {
		this.x = x;
		this.y = y;
		this.distance = Math.sqrt((this.getX()-goal.getX())+(this.getY()-goal.getY()));
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public void setParent(Node node) {
		this.parent = node;
	}

	public LinkedList<Node> getPossibleNodes(LinkedList<Node> visited) {
		LinkedList<Node> nodeList = new LinkedList<Node>();
		for(int i = 0; i < possibleNodes.size()-1; i++) {
			if(!visited.contains(possibleNodes.get(i))) {
				nodeList.add(possibleNodes.get(i));
			}
		}
		return nodeList;
	}

	public void setPossibleNodes(LinkedList<Node> possibleNodes) {
		this.possibleNodes = possibleNodes;
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
	public double getDistance() {
		//this.distance = Math.sqrt((this.getX()-goal.getX())+(this.getY()-goal.getY()));
		return distance;
	}
	public void setDistance(Node goal) {
		this.distance = Math.sqrt((this.getX()-goal.getX())+(this.getY()-goal.getY()));
	}
	public int compareTo(Node compareNode) {
		int compareDistance = (int) compareNode.getDistance();
		
		return (int) this.getDistance() - compareDistance;
	}
}