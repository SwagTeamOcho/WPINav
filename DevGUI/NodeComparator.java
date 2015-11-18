import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node node1, Node node2) {
		
		return node2.getPriority() - node1.getPriority();
	}
	
}
