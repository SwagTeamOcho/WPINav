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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

///**
//* Created by Lumbini on 11/7/2015.
// * */
//

public class EndUserGUI extends JPanel{

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

	//Combo Boxes on the GUI
	private JComboBox startBuildingSEL;
	private JComboBox startRoomSEL;
	private JComboBox endBuildingSEL;
	private JComboBox endRoomSEL;

	//Buttons on the UI
	private JButton searchButton;
	
	//List of buildings to be shown to the user
	private String[] buildings = {"Stratton Hall", "Project Centre", "Library", "Atwater Kent"}; 
	private String buildingSelectedSTART;	//track which building is selected to start in.
	private String buildingSelectedEND;		//track which building is selected to end in.
	//private Map selected;					//track which map to display


	//List of rooms respective of the buildings
	private String[] roomsStratton = {"101", "102A", "102B", "103", "104A", "104B", 
										"104C", "105A", "105B", "105C", "105D", "106", 
										"107", "107A", "108A", "109A", "109B", "110", "111-Bathroom(F)"};
	private String[] roomsProjectCentre = {"4", "5", "6"};
	private String[] roomsLibrary = {"7", "8", "9"};
	private String[] roomsAtwaterKent = {"10", "11", "12"};

	//Variable to track which room list to display
	private String[] roomsSelected = {};

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

		roomStart = new JLabel("Select Room:");
		roomStart.setBounds(762, 70, 132, 29);

		endPoint = new JLabel("TO");
		endPoint.setBounds(780, 126, 132, 29);

		buildingEnd = new JLabel("Select Building:");
		buildingEnd.setBounds(762, 146, 132, 29);

		roomEnd = new JLabel("Select Room:");
		roomEnd.setBounds(762, 190, 132, 29);

		//Add Labels to the uiPanel
		uiPanel.add(startPoint);
		uiPanel.add(buildingStart);
		uiPanel.add(roomStart);
		uiPanel.add(endPoint);
		uiPanel.add(buildingEnd);
		uiPanel.add(roomEnd);

		//Construct Combo boxes to select start point
		startBuildingSEL = new JComboBox(buildings);
		startBuildingSEL.setBounds(762, 46, 132, 29);
		startBuildingSEL.setEditable(false);
		startBuildingSEL.setVisible(true);

		startRoomSEL = new JComboBox(roomsSelected);
//		startRoomSEL.addItemListener((ItemListener) startBuildingSEL);
//		startRoomSEL.putClientProperty(buildings[1], roomsStratton);
//		startRoomSEL.putClientProperty(buildings[2], roomsProjectCentre);
//		startRoomSEL.putClientProperty(buildings[3], roomsLibrary);
//		startRoomSEL.putClientProperty(buildings[4], roomsAtwaterKent);
		startRoomSEL.setBounds(762, 90, 132, 29);
		startRoomSEL.setEditable(false);
		startRoomSEL.setVisible(true);

		//Construct Combo boxes to select end point
		endBuildingSEL = new JComboBox(buildings);
		endBuildingSEL.setBounds(762, 166, 132, 29);
		endBuildingSEL.setEditable(false);
		endBuildingSEL.setVisible(true);

		endRoomSEL = new JComboBox(roomsSelected);
//		endRoomSEL.addItemListener((ItemListener) endBuildingSEL);
//		endRoomSEL.putClientProperty(buildings[1], roomsStratton);
//		endRoomSEL.putClientProperty(buildings[2], roomsProjectCentre);
//		endRoomSEL.putClientProperty(buildings[3], roomsLibrary);
//		endRoomSEL.putClientProperty(buildings[4], roomsAtwaterKent);		
		endRoomSEL.setBounds(762, 210, 132, 29);
		endRoomSEL.setEditable(false);
		endRoomSEL.setVisible(true);

		//Add Combo Boxes to UIPanel
		uiPanel.add(startBuildingSEL);
		uiPanel.add(startRoomSEL);
		uiPanel.add(endBuildingSEL);
		uiPanel.add(endRoomSEL);
		
		//Construct button and add button to uiPanel
		searchButton = new JButton ("Search: ");
		searchButton.setBounds(762, 250, 132, 29);
		uiPanel.add(searchButton);

		//Construct button and add action listener
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});

		selectStartMap();
		selectEndMap();
		uiPanel.setVisible(true);
		frame.setVisible(true);
	}
	
	private void selectStartMap()
	{
		buildingSelectedSTART = (String) startBuildingSEL.getSelectedItem();
		startBuildingSEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				buildingSelectedSTART = (String) startBuildingSEL.getSelectedItem();
				switch(BUILDINGS.getEnum(buildingSelectedSTART)){
				case STRATTONHALL:
					roomsSelected = roomsStratton;
					break;
				case PROJECTCENTRE:
					roomsSelected = roomsProjectCentre;
					break;
				case LIBRARY:
					roomsSelected = roomsLibrary;
					break;
				case ATWATERKENT:
					roomsSelected = roomsAtwaterKent;
					break;
				} 
			}
		});
		uiPanel.repaint();
		frame.repaint();
	}
	
	public void selectEndMap()
	{
		buildingSelectedEND = (String) endBuildingSEL.getSelectedItem();
		endBuildingSEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				buildingSelectedEND = (String) endBuildingSEL.getSelectedItem();
				switch(BUILDINGS.getEnum(buildingSelectedEND)){
				case STRATTONHALL:
					roomsSelected = roomsStratton;
					break;
				case PROJECTCENTRE:
					roomsSelected = roomsProjectCentre;
					break;
				case LIBRARY:
					roomsSelected = roomsLibrary;
					break;
				case ATWATERKENT:
					roomsSelected = roomsAtwaterKent;
					break;
				} 
			}
		});
		uiPanel.repaint();
		frame.repaint();
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
			ImageIcon mapIcon = new ImageIcon("src/Background1.jpg");
			ImageIcon pathIcon = new ImageIcon();
			mapImage = mapIcon.getImage();
			pathImage = pathIcon.getImage();
			GeneralPath path = null;
			
			int width = mapImage.getWidth(this);
			int height = mapImage.getHeight(this);

			int w = width / 3;
			int h = height / 3;
			
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
            if (path==null) {
                path = new GeneralPath();
                path.moveTo(100, 20);
                path.lineTo(100, 300);
                path.lineTo(200, 100);
                path.lineTo(100, 80);
            }
            g2d.draw(path);
            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.RED);
            g2d.draw(path);
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

}
