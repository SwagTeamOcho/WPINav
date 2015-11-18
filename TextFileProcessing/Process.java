import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;



//Text files should be formatted as one edge per line, where each line is
//Node1x 10 Node1y 20 Node2x 30 Node2y 40 Weight 50
//
//To read a text file into edges, use 
//File file1 = new File("src/map1.txt");
//Process process1 = new Process(file1);
//
//To get the list of edges, use
//process1.getEdges();

public class Process {
	private Scanner inFile;
	private File file;
	private LinkedList<Edge> edgeList = new LinkedList<Edge>();
	
	
	public Process(File file){
		
		this.file = file;
		
		try{
		inFile = new Scanner(file);
		}catch(FileNotFoundException e){
			System.out.println("e");
		}
		while (inFile.hasNextLine()){
			String tempStr;
			int tempIntx;
			int tempInty;
			int tempIntx2;
			int tempInty2;
			int tempIntWeight;
			Node node;
			Node node2;
			Edge edge;
			
			tempStr = inFile.next();
			tempIntx = inFile.nextInt();
			//System.out.println("Node x:");
			//System.out.println(tempIntx);
			tempStr = inFile.next();
			tempInty = inFile.nextInt();
			//System.out.println("Node y:");
			//System.out.println(tempInty);
			tempStr = inFile.next();
			tempIntx2 = inFile.nextInt();
			//System.out.println("Node x:");
			//System.out.println(tempIntx2);
			tempStr = inFile.next();
			tempInty2 = inFile.nextInt();
			//System.out.println("Node y:");
			//System.out.println(tempInty2);
			tempStr = inFile.next();
			tempIntWeight = inFile.nextInt();
			//System.out.println("Edge Weight");
			//System.out.println(tempIntWeight);
			
			node = new Node(tempIntx, tempInty);
			node2 = new Node(tempIntx2, tempInty2);
			
			edge = new Edge(node, node2, tempIntWeight);
			this.edgeList.add(edge);
		}
		
		inFile.close();
	}
	
	public LinkedList<Edge> getEdges(){
		return edgeList;
	}
	
}
