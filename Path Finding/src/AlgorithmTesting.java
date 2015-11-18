import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class AlgorithmTesting {
	
	//Test map nodes
    Node one = new Node(1, 9, "Exit");
    Node two = new Node(3, 9);
    Node three = new Node(3, 8, "101");
    Node four = new Node(9, 9);
    Node five = new Node(9, 8, "102");
    Node six = new Node(15, 9);
	Node seven = new Node (15, 8, "103");
	Node eight = new Node (19, 9);
	Node nine = new Node (19, 8, "104");
	Node ten = new Node (26, 9);
	Node eleven = new Node (26, 8, "104");
	Node twelve = new Node (28, 9);
	Node thirteen = new Node (28, 1, "Exit");
	Node fourteen = new Node (28, 19);
	Node fifteen = new Node (26, 19);
	Node sixteen = new Node (26, 18, "105");
	Node seventeen = new Node (19, 19);
	Node eighteen = new Node (19, 18, "105");
	Node nineteen = new Node (9, 19);
	Node twenty = new Node (3, 19);
	Node twentyone = new Node (3, 18, "107");
	Node twentytwo = new Node (9, 15);
	Node twentythree = new Node (11, 15, "106");
    
    //Test map edges
    Edge a = new Edge (one, two, 2);
    Edge b = new Edge (two, three, 1);
    Edge c = new Edge (two, four, 6);
    Edge d = new Edge (four, five, 1);
    Edge e = new Edge (four, six, 6);
    Edge f = new Edge (six, seven, 1);
    Edge g = new Edge (six, eight, 4);
    Edge h = new Edge (eight, nine, 1);
    Edge i = new Edge (eight, ten, 7);
    Edge j = new Edge (ten, eleven, 1);
    Edge k = new Edge (ten, twelve, 2);
    Edge l = new Edge (twelve, thirteen, 8);
    Edge m = new Edge (twelve, fourteen, 10);
    Edge n = new Edge (fourteen, fifteen, 2);
    Edge o = new Edge (fifteen, sixteen, 1);
    Edge p = new Edge (fifteen, seventeen, 7);
    Edge q = new Edge (seventeen, eighteen, 1);
    Edge r = new Edge (seventeen, nineteen, 10);
    Edge s = new Edge (nineteen, twenty, 6);
    Edge t = new Edge (twenty, twentyone, 1);
    Edge u = new Edge (nineteen, twentytwo, 4);
    Edge v = new Edge (twentytwo, twentythree, 2);
    Edge w = new Edge (twentytwo, four, 6);

    //most optimal paths for the test cases
    LinkedList<Node> path1 = new LinkedList<Node>(Arrays.asList(one, two, four, twentytwo, nineteen, seventeen, fifteen));
    LinkedList<Node> path2 = new LinkedList<Node>(Arrays.asList(three, two, four, six, eight));
    LinkedList<Node> path3 = new LinkedList<Node>(Arrays.asList(nine, eight, six, four, twentytwo, twentythree));
    LinkedList<Node> path4 = new LinkedList<Node>(Arrays.asList(fourteen, fifteen, seventeen, nineteen, twenty, twentyone));
    LinkedList<Node> path5 = new LinkedList<Node>(Arrays.asList(twelve, ten, eight, six, four, twentytwo));
    LinkedList<Node> path6 = new LinkedList<Node>(Arrays.asList(thirteen, twelve, ten, eight, six, four, twentytwo));
    LinkedList<Node> path7 = new LinkedList<Node>(Arrays.asList(three, two, four, five));
    LinkedList<Node> path8 = new LinkedList<Node>(Arrays.asList(three, two, four, twentytwo, nineteen));
    LinkedList<Node> path9 = new LinkedList<Node>(Arrays.asList(twentythree, twentytwo, four, six, eight, ten, twelve, thirteen));
	
	@Test
	public void test1() {
		Node node1 = new Node(10,10);
		Node node2 = new Node(20,20);
		Node node3 = new Node(5,10);
		Node node4 = new Node(15,15);

		Edge edge1 = new Edge (node1, node3, 5);
		Edge edge2 = new Edge (node1, node4, 7);
		Edge edge3 = new Edge (node4, node2, 7);
		Edge edge4 = new Edge (node2, node3, 18);
		
		LinkedList<Node> path = new LinkedList<Node>();
		Djikstra djikstra = new Djikstra();
		path = djikstra.navigate(node1,node2);
		assertEquals(path.size(), 3);
		assertEquals(path.getFirst().getX(), 10);
		assertEquals(path.getFirst().getY(), 10);
		assertEquals(path.getLast().getX(), 20);
		assertEquals(path.getLast().getY(), 20);
		assertEquals(path.get(1).getX(), 15);
		assertEquals(path.get(1).getY(), 15);
		
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		Node node1 = new Node(10,10);
		Node node2 = new Node(20,20);
		Node node3 = new Node(15,15);
		Node node4 = new Node(5,10);

		Edge edge1 = new Edge (node1, node4, 5);
		Edge edge2 = new Edge (node1, node3, 7);
		Edge edge3 = new Edge (node3, node2, 7);
		Edge edge4 = new Edge (node2, node4, 18);
		
		LinkedList<Node> path = new LinkedList<Node>();
		Djikstra djikstra = new Djikstra();
		path = djikstra.navigate(node1,node2);
		assertEquals(path.size(), 3);
		assertEquals(path.getFirst().getX(), 10);
		assertEquals(path.getFirst().getY(), 10);
		assertEquals(path.getLast().getX(), 20);
		assertEquals(path.getLast().getY(), 20);
		assertEquals(path.get(1).getX(), 15);
		assertEquals(path.get(1).getY(), 15);
		djikstra.getDistance(path);
		
		//fail("Not yet implemented");
	}
	
	
	
	@Test
	public void test3() {
		Node node1 = new Node(10,10);
		Node node2 = new Node(20, 20);
		Node node3 = new Node(5, 10);
		Node node4 = new Node(15, 15);
		
		Edge edge1 = new Edge (node1, node3, 5);
		Edge edge2 = new Edge (node1, node4, 7);
		Edge edge3 = new Edge (node4, node2, 7);
		Edge edge4 = new Edge (node2, node3, 18);
		Edge edge5 = new Edge (node1, node2, 1);
		
		LinkedList<Node> path = new LinkedList<Node>();
		Djikstra djikstra = new Djikstra();
		path = djikstra.navigate(node1,node2);
		assertEquals(path.size(), 2);
		assertEquals(path.getFirst().getX(), 10);
		assertEquals(path.getFirst().getY(), 10);
		assertEquals(path.getLast().getX(), 20);
		assertEquals(path.getLast().getY(), 20);
		assertEquals((int)node1.getCost(node2), 1);
		djikstra.getDistance(path);
		//assertEquals(path.get(1).getX(), 15);
		//assertEquals(path.get(1).getY(), 15);
		
		//fail("Not yet implemented");
	}
	@Test
	public void test4() {
		Node node1 = new Node(10, 10);
		Node node2 = new Node(20, 20);

		Edge edge = new Edge (node1, node2, 14);
		LinkedList<Edge> edgesList = new LinkedList<Edge>();
		edgesList.add(edge);
		
		LinkedList<Node> path = new LinkedList<Node>();
		Djikstra djikstra = new Djikstra();
		path = djikstra.navigate(node1,node2);
		assertEquals(path.size(), 2);
		assertEquals(path.getFirst().getX(), 10);
		assertEquals(path.getFirst().getY(), 10);
		assertEquals(path.getLast().getX(), 20);
		assertEquals(path.getLast().getY(), 20);
		int distance;
		distance = node1.getCost(node2);
		assertEquals(distance, 14);
		djikstra.getDistance(path);
		
		//fail("Not yet implemented");
	}
	
	@Test(expected=NoPathException.class)
	public void test5(){
		Node start = new Node(5,5);
		Node goal = new Node(10,10);
		Djikstra djikstra = new Djikstra();
		LinkedList<Node> path = new LinkedList<Node>();
		path = djikstra.navigate(start, goal);
		djikstra.getDistance(path);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test6(){
		Djikstra djikstra = new Djikstra();
		LinkedList<Node> path = new LinkedList<Node>();
		path = djikstra.navigate(null, null);
		djikstra.getDistance(path);
		
	}
	
//	@Test
//    public void test100(){
//        LinkedList<Node> path = new LinkedList<Node>();
//        Djikstra djikstra = new Djikstra();
//        System.out.println("yo");
//        path = djikstra.navigate(one, sixteen);
//        System.out.println("TESTTT" + path.size());
//        for(int i = 0; i < path.size(); i++){
//        	System.out.println(path.get(i).getX());
//        	System.out.println(path.get(i).getY());
//        	System.out.println();
//        }
//        assertEquals(path, path1);
//    }

    @Test
    public void test101(){
        LinkedList<Node> path = new LinkedList<Node>();
        Djikstra djikstra = new Djikstra();
        path = djikstra.navigate(three, eight);
        assertEquals(path, path2);
        djikstra.getDistance(path);
    }

    @Test
    public void test102(){
        LinkedList<Node> path = new LinkedList<Node>();
        Djikstra djikstra = new Djikstra();
        path = djikstra.navigate(nine, twentythree);
      for(int i = 0; i < path.size(); i++){
    	System.out.println(path.get(i).getX());
    	System.out.println(path.get(i).getY());
    	System.out.println();
    
        
    }
      assertEquals(path, path3);
      djikstra.getDistance(path);
    }

    @Test
    public void test103(){
        LinkedList<Node> path = new LinkedList<Node>();
        Djikstra djikstra = new Djikstra();
        path = djikstra.navigate(fourteen, twentyone);
  for(int i = 0; i < path.size(); i++){
	System.out.println(path.get(i).getX());
	System.out.println(path.get(i).getY());
	System.out.println();
  }
        assertEquals(path, path4);
        djikstra.getDistance(path);
    
    }

    @Test
    public void test104(){
        LinkedList<Node> path = new LinkedList<Node>();
        Djikstra djikstra = new Djikstra();
        path = djikstra.navigate(twelve, twentytwo);
        assertEquals(path, path5);
        djikstra.getDistance(path);
    }

    @Test
    public void test105(){
        LinkedList<Node> path = new LinkedList<Node>();
        Djikstra djikstra = new Djikstra();
        path = djikstra.navigate(thirteen, twentytwo);
        assertEquals(path, path6);
        djikstra.getDistance(path);
    }

    @Test
    public void test106(){
        LinkedList<Node> path = new LinkedList<Node>();
        Djikstra djikstra = new Djikstra();
        path = djikstra.navigate(three, five);
        assertEquals(path, path7);
        djikstra.getDistance(path);
    }

    @Test
    public void test107(){
        LinkedList<Node> path = new LinkedList<Node>();
        Djikstra djikstra = new Djikstra();
        path = djikstra.navigate(three, nineteen);
        assertEquals(path, path8);
        djikstra.getDistance(path);
    }

    @Test
    public void test108(){
        LinkedList<Node> path = new LinkedList<Node>();
        Djikstra djikstra = new Djikstra();
        path = djikstra.navigate(twentythree, thirteen);
        assertEquals(path, path9);
        djikstra.getDistance(path);
    }

}
