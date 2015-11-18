import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Djikstra {
	
	public LinkedList<Node> navigate(Node start, Node goal){
		Comparator<Node> comparator = new NodeComparator();
		Node current;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(10, comparator);
		start.setPriority(0);
		frontier.add(start);
		LinkedList<Node> temp = new LinkedList<Node>();
		LinkedList<Node> path = new LinkedList<Node>();
		LinkedList<Node> possibleNodes = new LinkedList<Node>();
		HashMap<Node, Node> cameFrom = new HashMap<Node, Node>();
		HashMap<Node, Integer> costSoFar = new HashMap<Node, Integer>();
		cameFrom.put(start, null);
		costSoFar.put(start, 0);
		
		while (!(frontier.isEmpty())){
			current = frontier.poll(); // possibly use remove
			if(current.equals(goal)){
				break;
			}
			possibleNodes = current.getPossibleNodes();
			Node next;
			for(int i = 0; i < possibleNodes.size(); i++){
				
				next = possibleNodes.get(i);
				Integer newCost = costSoFar.get(current) + current.getCost(next);
				if ((!costSoFar.containsKey(next)) ||  (newCost < costSoFar.get(next))){
					//costSoFar.remove(next);
					costSoFar.put(next, newCost);
					next.setPriority(newCost);
					frontier.add(next);
					cameFrom.put(next, current);
				}
			}
			
		}
		current = goal;
		temp.add(current);
		while (!(current.equals(start))){
			current = cameFrom.get(current);
			temp.add(current);
		}
		
		
		for(int i = temp.size() - 1; i >= 0; i--){
			System.out.println("i = " + i);
			System.out.println(temp.get(i).getName());
			path.add(temp.get(i));
		}
		return path;
	}
}