import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Djikstra  {

	
	public LinkedList<Node> navigate(Node start, Node goal){
		if(start == null || goal == null){
			throw new IllegalArgumentException();
		}
		
		Comparator<Node> comparator = new NodeComparator();
		Node current;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(100, comparator);
		start.setPriority(0);
		frontier.add(start);
		LinkedList<Node> temp = new LinkedList<Node>();
		LinkedList<Node> path = new LinkedList<Node>();
		if(start.equals(goal)){
			path.add(start);
			return path;
			}
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
		if(current != null){System.out.println("current not null");}
		if(start != null){System.out.println("start not null");}
		
		while (!(current.equals(start))){
			if(cameFrom.get(current) == null){break;}
			current = cameFrom.get(current);
			temp.add(current);
		}
		
		
		
		for(int i = temp.size() - 1; i >= 0; i--){
			path.add(temp.get(i));
		}
		
		
		
		
		return path;
	}
	
	public static int getDistance(LinkedList<Node> path){
		if(path.size() <= 1){
			throw new NoPathException("NO WAY");
		}
		System.out.println("path size = " + path.size());
		int total = 0;
		int nextCost = 0;
		for(int i = 0; i < path.size() - 1; i++){
			nextCost = path.get(i).getCost(path.get(i+1));
			System.out.println("nextCost = " + nextCost);
			if(nextCost<0){
				throw new NoPathException("NO WAY");
			}
			total+=nextCost;
		}
		return total;
	}
}
