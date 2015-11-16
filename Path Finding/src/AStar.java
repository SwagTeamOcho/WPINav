
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class AStar {
	
	//sudo code for AStar algorithm
	public LinkedList<Node> navigate(Node goal, Node start) {
		LinkedList<Node> frontier = new LinkedList<Node>();
		LinkedList<Node> path = new LinkedList<Node>();
		LinkedList<Node> visited = new LinkedList<Node>();
		HashMap<Node, Node> cameFrom = new HashMap<Node, Node>();
		cameFrom.put(start, null);
		Node current = start;
		System.out.println("hello");
		while (!current.getName().equals(goal.getName())) {
			//getNeighbors
			System.out.println("hello1");
			LinkedList<Node> neighbors = new LinkedList<Node>();
			neighbors = getNeighbors(current, visited);
			frontier.remove(current);
			frontier.addAll(neighbors); 
			visited.add(current);
			System.out.println("hello2");
			frontier = organize(goal, neighbors);
			System.out.println("hello3");
			System.out.println(neighbors.size());
			for (int i = 0; i < neighbors.size(); i++){
				System.out.println("i = " + i);
				cameFrom.put(neighbors.get(i), current);
				System.out.println("i = " + i);
			}
			current = frontier.get(0);
		}
		System.out.println("hello4");
		current = goal;
		path.add(current);
		
		while (current.getName() != start.getName()){
			current = cameFrom.get(current);
			path.add(current);
		}
		LinkedList<Edge> shortestPath = shortestPath(start, goal, path);
		
		return shortestPath;
	}
	
	public LinkedList<Node> getNeighbors(Node current, LinkedList<Node> visited) {
		LinkedList<Node> neighbors = new LinkedList<Node>();
		neighbors.addAll(current.getPossibleNodes(visited));
		return neighbors;
	}
	
	//this is the heuristic done by AStar 
	public LinkedList<Node> organize(Node goal, LinkedList<Node> currentSet) {
		LinkedList<Node> frontiers = new LinkedList<Node>();
		//need to organize list by distance to goal + amount traveled
		return frontiers;
	}
	
	
	public LinkedList<Edge> shortestPath (Node start, Node last, LinkedList<Node> path) {
		LinkedList<Edge> shortPath = new LinkedList<Edge>();
		Node recent = new Node();
		recent = last;
		while (!recent.equals(start)) {
			Edge anEdge = new Edge(recent, recent.getParent());
			shortPath.add(anEdge);
			recent = recent.getParent();
		}
		return shortPath;
	}
	
}
