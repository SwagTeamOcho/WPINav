import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Test;

public class AlgorithmTesting {
	
	

	@Test
	public void test() {
		Node x = new Node();
		Node y = new Node();
		x.setName("x");
		y.setName("y");
		LinkedList<Node> possibleNodesOfX = new LinkedList<Node>();
		LinkedList<Node> possibleNodesOfY = new LinkedList<Node>();
		possibleNodesOfX.add(y);
		possibleNodesOfY.add(x);
		x.setPossibleNodes(possibleNodesOfX);
		y.setPossibleNodes(possibleNodesOfY);
		System.out.println("YO1");
		LinkedList<Node> path = new LinkedList<Node>();
		System.out.println("YO2");
		AStar astar = new AStar();
		System.out.println("YO3");
		path = astar.navigate(x,y);
		System.out.println("YO");
		System.out.println("YO");
		System.out.println(path.getFirst().getName());
		System.out.println(path.getLast().getName());
		
		
		fail("Not yet implemented");
	}

}
