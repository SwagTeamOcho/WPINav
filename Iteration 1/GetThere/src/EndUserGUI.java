import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Arrays;

///**
//* Created by Lumbini on 11/7/2015.
// * */
//

public class EndUserGUI extends JPanel implements ActionListener{

	private JFrame frame;		//Creates the main frame for the GUI
	private JPanel uiPanel;		//Panel to hold the interface buttons
	private JPanel mapPanel;	//Panel to hold the map
	private Image mapImage;		//Represents the map to be chosen
	private Image pathImage;	//Image that draws the path on the map

	//Labels on the GUI
	private JLabel startPoint;
	private JLabel buildingStart;
	private JLabel roomStart;
	private JLabel endPoint;
	private JLabel buildingEnd;
	private JLabel roomEnd;
	private JLabel floorStart;

	//Combo Boxes on the GUI
	private JComboBox startBuildingSEL;
	private JComboBox startRoomSEL;
	private JComboBox endBuildingSEL;
	private JComboBox endRoomSEL;
	private JComboBox startFloorSEL;

	//Buttons on the UI
	private JButton searchButton;
	Graphics g;
	Boolean updatePath = false;
	
	//Start-End Nodes
	private Node startNode;
	private Node endNode;
	private LinkedList<Node> listPath = new LinkedList<Node>();
	
	//List of buildings to be shown to the user
	private String[] buildings = { "Stratton Hall"}; 
	private String buildingSelectedSTART;	//track which building is selected to start in.
	private String roomSelectedSTART;
	private String floorSelectedSTART;
	private String buildingSelectedEND;		//track which building is selected to end in.
	//private Map selected;					//track which map to display
	public ImageIcon mapIcon;

	//List of rooms respective of the buildings
	private String[] roomsStratton = {" ", "001","002","003","004","006","007","009","009A","009B","010","011",
									"012","013","014", "101", "102A", "102B", "103", "104A", "104B", "104C", 
									"105A", "105B", "105C", "105D", "106", "107", "107A", "108A", "109A", "109B",
									"110", "111-Bathroom(F)", "201A", "201B", "201C", "202","202A", "202B", "202C",
									"202D", "202E", "203", "204", "205", "206", "207", "208", "209-Bathroom(M)"};
	private String[] floors = {" ", "Basement", "1st", "2nd", "Test"};
	private String[] roomsProjectCentre = {" ","100","101","102","103","104","105","106","106A","106B","106C","106D",
										"106E","106F","106G","107","108","109","109A","110","111","111A","112","113"};
	private String[] mapList = {"MapImages/StrattonHall-Basement.jpg", "MapImages/StrattonHall-1st.jpg", 
								"MapImages/StrattonHall-2nd.jpg","MapImages/Background1.jpg", "MapImages/Test.jpg"};
//	private String[] testRooms = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
//								"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
	private String[] testRooms = {"101", "102", "103", "104", "105", "106", "107"};
	//Array of test nodes

	//Test map nodes
   // Node one = new Node(1, 12, "Exit");
    Node two = new Node(3, 12);
    Node three = new Node(3, 13, "101");
    Node four = new Node(9, 12);
    Node five = new Node(9, 13, "102");
    Node six = new Node(15, 12);
	Node seven = new Node (15, 13, "103");
	Node eight = new Node (19, 12);
	//Node nine = new Node (19, 13, "104");
	Node ten = new Node (26, 12);
	Node eleven = new Node (26, 13, "104");
	Node twelve = new Node (28, 12);
	Node thirteen = new Node (28, 20, "Exit");
	Node fourteen = new Node (28, 2);
	Node fifteen = new Node (26, 2);
	Node sixteen = new Node (26, 3, "105");
	Node seventeen = new Node (19, 2);
	//Node eighteen = new Node (19, 3, "105");
	Node nineteen = new Node (9, 2);
	Node twenty = new Node (3, 2);
	Node twentyone = new Node (3, 3, "107");
	Node twentytwo = new Node (9, 6);
	Node twentythree = new Node (11, 6, "106");
    
    //Test map edges
   // Edge a = new Edge (one, two, 2*25);
    Edge b = new Edge (two, three, 1*25);
    Edge c = new Edge (two, four, 6*25);
    Edge d = new Edge (four, five, 1*25);
    Edge e = new Edge (four, six, 6*25);
    Edge f = new Edge (six, seven, 1*25);
    Edge gee = new Edge (six, eight, 4*25);
    //Edge h = new Edge (eight, nine, 1*25);
    Edge i = new Edge (eight, ten, 7*25);
    Edge j = new Edge (ten, eleven, 1*25);
    Edge k = new Edge (ten, twelve, 2*25);
    Edge l = new Edge (twelve, thirteen, 8*25);
    Edge m = new Edge (twelve, fourteen, 10*25);
    Edge n = new Edge (fourteen, fifteen, 2*25);
    Edge o = new Edge (fifteen, sixteen, 1*25);
    Edge p = new Edge (fifteen, seventeen, 7*25);
   // Edge q = new Edge (seventeen, eighteen, 1*25);
    Edge r = new Edge (seventeen, nineteen, 10*25);
    Edge s = new Edge (nineteen, twenty, 6*25);
    Edge t = new Edge (twenty, twentyone, 1*25);
    Edge u = new Edge (nineteen, twentytwo, 4*25);
    Edge v = new Edge (twentytwo, twentythree, 2*25);
    Edge w = new Edge (twentytwo, four, 6*25);
	Node[] testNodes = new Node[]{ two, three, four, five, six, seven, eight, ten, eleven, twelve,
										thirteen, fourteen, fifteen, sixteen, seventeen, nineteen, twenty, 
										twentyone, twentytwo, twentythree};
	private String currentMap;
//	private String[] roomsLibrary = {"7", "8", "9"};
//	private String[] roomsAtwaterKent = {"10", "11", "12"};

	//Variable to track which room list to display
	private String[] roomsSelected = {};
	private int floor = -1;

	protected enum BUILDINGS {
		STRATTONHALL, PROJECTCENTRE, LIBRARY, ATWATERKENT;
		public static BUILDINGS getEnum(String s){
			if(s.equals("Stratton Hall")){
				return STRATTONHALL;
			}else if(s.equals("Project Centre")){
				return PROJECTCENTRE;
			}else if(s.equals("Library")){
				return LIBRARY;
			}else if (s.equals("Atwater Kent")){
				return ATWATERKENT;
			}
			throw new IllegalArgumentException("No Enum specified for this string");
		}
	}


	/**
	 * Create the application.
	 */
	public EndUserGUI(){
		initialize();
	}

	//Launch the application. 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndUserGUI window = new EndUserGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		//Frame operations
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setTitle("Get There");
		frame.setResizable(false);
		frame.setVisible(true);
		
		currentMap = mapList[3];
		//Panel Operations
		uiPanel = new JPanel();
		frame.getContentPane().add(uiPanel);
		uiPanel.setLayout(null);

		mapPanel = new JPanel();
		mapPanel.setBounds(5, 5, 750, 650);
		uiPanel.add(mapPanel);
		mapPanel.add(new MyGraphics());

		//Creating Labels
		startPoint = new JLabel("FROM");
		startPoint.setBounds(780, 6, 132, 29);

		buildingStart = new JLabel("Select Building:");
		buildingStart.setBounds(762, 26, 132, 29);

		floorStart = new JLabel("Select Floor:");
		floorStart.setBounds(762, 70, 132, 29);
		
		roomStart = new JLabel("Select Room:");
		roomStart.setBounds(762, 110, 132, 29);

		endPoint = new JLabel("TO");
		endPoint.setBounds(780, 166, 132, 29);

//		buildingEnd = new JLabel("Select Building:");
//		buildingEnd.setBounds(762, 146, 132, 29);

		roomEnd = new JLabel("Select Room:");
		roomEnd.setBounds(762, 190, 132, 29);

		//Add Labels to the uiPanel
		uiPanel.add(startPoint);
		uiPanel.add(buildingStart);
		uiPanel.add(floorStart);
		uiPanel.add(roomStart);
		uiPanel.add(endPoint);
		//uiPanel.add(buildingEnd);
		uiPanel.add(roomEnd);

		//Construct Combo boxes to select start point
		startBuildingSEL = new JComboBox(buildings);
		startBuildingSEL.setBounds(762, 46, 132, 29);
		startBuildingSEL.setEditable(false);
		startBuildingSEL.setVisible(true);

		startFloorSEL = new JComboBox(floors);
		startFloorSEL.setBounds(762, 90, 132, 29);
		startFloorSEL.setEditable(false);
		startFloorSEL.setVisible(true);
		startFloorSEL.setSelectedIndex(0);
		startFloorSEL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				removeAll();
				int i;
				JComboBox cb = (JComboBox)e.getSource();
				floorSelectedSTART = (String)cb.getSelectedItem();
				if(floorSelectedSTART.equals("Basement")){
					removeAll();
					currentMap = mapList[0];
					roomsSelected = Arrays.copyOfRange(roomsStratton, 0, 15);
					startRoomSEL.removeAllItems();
					endRoomSEL.removeAllItems();
					for(i=0; i<roomsSelected.length; i++){
					startRoomSEL.addItem(roomsSelected[i]);
					endRoomSEL.addItem(roomsSelected[i]);
					}
					repaint();
					revalidate();
				}else if(floorSelectedSTART.equals("1st")){
					removeAll();
					currentMap = mapList[1];
					roomsSelected = Arrays.copyOfRange(roomsStratton, 15, 34);
					startRoomSEL.removeAllItems();
					endRoomSEL.removeAllItems();
					for(i=0; i<roomsSelected.length; i++){
					startRoomSEL.addItem(roomsSelected[i]);
					endRoomSEL.addItem(roomsSelected[i]);
					}
					repaint();
					revalidate();
				}else if(floorSelectedSTART.equals("2nd")){
					removeAll();
					currentMap = mapList[2];
					roomsSelected = Arrays.copyOfRange(roomsStratton, 34, 50);
					startRoomSEL.removeAllItems();
					endRoomSEL.removeAllItems();
					for(i=0; i<roomsSelected.length; i++){
					startRoomSEL.addItem(roomsSelected[i]);
					endRoomSEL.addItem(roomsSelected[i]);
					}
					repaint();
					revalidate();
				}else if(floorSelectedSTART.equals("Test")){
					removeAll();
					currentMap = mapList[4];
					roomsSelected = testRooms;
					startRoomSEL.removeAllItems();
					endRoomSEL.removeAllItems();
					for(i=0; i<roomsSelected.length; i++){
					startRoomSEL.addItem(roomsSelected[i]);
					endRoomSEL.addItem(roomsSelected[i]);
					}
					repaint();
					revalidate();
				}else{
					removeAll();
					currentMap = mapList[3];
					roomsSelected = Arrays.copyOfRange(roomsStratton, 0, 0);
					startRoomSEL.removeAllItems();
					endRoomSEL.removeAllItems();
					for(i=0; i<roomsSelected.length; i++){
					startRoomSEL.addItem(roomsSelected[i]);
					endRoomSEL.addItem(roomsSelected[i]);
					}
					repaint();
					revalidate();
				}
			}
		});

		startRoomSEL = new JComboBox(roomsStratton);
		startRoomSEL.setBounds(762, 130, 132, 29);
		startRoomSEL.setEditable(false);
		startRoomSEL.setVisible(true);

		//Construct Combo boxes to select end point
//		endBuildingSEL = new JComboBox(buildings);
//		endBuildingSEL.setBounds(762, 166, 132, 29);
//		endBuildingSEL.setEditable(false);
//		endBuildingSEL.setVisible(true);
		
		endRoomSEL = new JComboBox(roomsStratton);
		endRoomSEL.setBounds(762, 210, 132, 29);
		endRoomSEL.setEditable(false);
		endRoomSEL.setVisible(true);

		//Add Combo Boxes to UIPanel
		
		uiPanel.add(startBuildingSEL);
		uiPanel.add(startRoomSEL);
		uiPanel.add(startFloorSEL);
		//uiPanel.add(endBuildingSEL);
		uiPanel.add(endRoomSEL);

		//Construct button and add button to uiPanel
		searchButton = new JButton ("Search");
		searchButton.setBounds(762, 250, 132, 29);
		uiPanel.add(searchButton);
		
		JButton devGUI = new JButton ("DevMode");
		devGUI.setBounds(762, 420, 132, 29);
		uiPanel.add(devGUI);
		devGUI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				DevGUI devMode = new DevGUI();
				devMode.setDeveloperMode(true);;
			}
		});
		JButton userGUI = new JButton ("UserMode");
		userGUI.setBounds(762, 450, 132, 29);
		uiPanel.add(userGUI);
		userGUI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				EndUserGUI userMode = new EndUserGUI();
			}
		});

		//Construct button and add action listener
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i;
				if(startFloorSEL.getSelectedItem() == "Test"){
					updatePath = true;
				}else updatePath = false;
				uiPanel.setVisible(true);
				frame.setVisible(true);
				GeneralPath path = null;
				Djikstra pathCalc = new Djikstra();
				
				int startInt = Integer.parseInt((String)startRoomSEL.getSelectedItem()) -1;		//need to look up the nodes in the text file
				int endInt = Integer.parseInt((String)endRoomSEL.getSelectedItem()) -1;
				for (i=0; i<testNodes.length; i++){
					if(startRoomSEL.getSelectedItem() == testNodes[i].getName()){
						startNode = testNodes[i];
					}
					if(endRoomSEL.getSelectedItem() == testNodes[i].getName()){
						endNode = testNodes[i];
					}
				}
				
				
				System.out.println(startBuildingSEL.getSelectedItem());
				System.out.println(floor);
//				if (startNode == null){
//					System.out.println("Null startnode");
//				}
				listPath = pathCalc.navigate(startNode, endNode);
				System.out.println("check List: " + listPath.size());
				repaint();
				revalidate();
			}
		});

		uiPanel.setVisible(true);
		frame.setVisible(true);
	}
	
	public class MyGraphics extends JComponent implements MouseMotionListener{

		private static final long serialVersionUID = 1L;
		MyGraphics() {
			setPreferredSize(new Dimension(760, 666));
			addMouseMotionListener(this);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//selectStartMap();
			mapIcon = new ImageIcon(currentMap);
			ImageIcon pathIcon = new ImageIcon();
			mapImage = mapIcon.getImage();
			pathImage = pathIcon.getImage();
			GeneralPath path = null;
			
			int width = mapImage.getWidth(this);
			int height = mapImage.getHeight(this);

			int w = width / 3;
			int h = height / 3;
			repaint();
			revalidate();
			g.drawImage(mapImage, 0, 0, this);

			Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            BasicStroke s = new BasicStroke(
                    5.5f, 
                    BasicStroke.CAP_ROUND, 
                    BasicStroke.JOIN_ROUND);
            g2d.setStroke(s);
            g2d.setColor(Color.BLACK);
            if (path==null && updatePath == true) {
            	removeAll();
            	int i;
                path = new GeneralPath();
//                path.moveTo(0, 0);
//                path.lineTo(100, 100);
//                path.lineTo(300, 400);
                JLabel start = new JLabel("Start");
                JLabel end = new JLabel("End");
                start.setBounds((listPath.getFirst().getX()*25)-12, (listPath.getFirst().getY()*25)-60, 100, 100);
                end.setBounds((listPath.getLast().getX()*25)-8, (listPath.getLast().getY()*25)-60, 100, 100);
                path.moveTo(listPath.getFirst().getX()*25+20, listPath.getFirst().getY()*25); 
                for (i=0; i<listPath.size(); i++){
                	path.lineTo(listPath.get(i).getX()*25+20,listPath.get(i).getY()*25);
                }
            this.add(start);
            this.add(end);
            g2d.draw(path);
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.RED);
            g2d.draw(path);
            repaint();
			revalidate();
            }
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
			System.out.println("X: " + x + " Y: " +y);

		}
		public void mousePressed(MouseEvent evt) {
			int x = evt.getX();
			int y = evt.getY();
			System.out.println("X: " + x + " Y: " +y);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
