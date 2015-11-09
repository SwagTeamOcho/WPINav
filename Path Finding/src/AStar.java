import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStar {
	
	//sudo code for AStar algorithm
	public LinkedList<Node> navigate(Node goal, Node start) {
		LinkedList<Node> frontier = new LinkedList<Node>();
		LinkedList<Node> path = new LinkedList<Node>();
		LinkedList<Node> visited = new LinkedList<Node>();
		Node current = start;
		while (!start.equals(goal)) {
			//getNeighbors
			LinkedList<Node> neighbors = new LinkedList<Node>();
			neighbors = getNeighbors(current, visited);
			frontier.remove(current);
			frontier.addAll(neighbors);
			visited.add(current);
			frontier = organize(goal, neighbors);
		}
		
		return path;
	}
	
	public LinkedList<Node> getNeighbors(Node current, LinkedList<Node> visited) {
		LinkedList<Node> neighbors = new LinkedList<Node>();
		neighbors.addAll(current.getPossibleNodes(visited));
		return neighbors;
	}
	
	public LinkedList<Node> organize(Node goal, LinkedList<Node> currentSet) {
		LinkedList<Node> frontiers = new LinkedList<Node>();
		//need to organize list by shortest distance, currently pure heuristic
		return frontiers;
	}
	
}
