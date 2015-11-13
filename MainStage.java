///**
//* Created by Lumbini on 11/7/2015.
// * */
//
import java.awt.*;
import javax.swing.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Arrays;

import javax.swing.JList;

public class MainStage extends JPanel{
	private JFrame frame;
	private Image backgroundImage;
	private String[] buildings = {"Stratton Hall", "Project Centre", "Library", "Atwater Kent"};
	private Integer[] roomsStratton = {1, 2, 3, 4, 5, 6, 7, 8};
	private Integer[] roomsProjectCentre = {4, 5, 6};
	private Integer[] roomsLibrary = {7, 8, 9};
	private Integer[] roomsAtwaterKent = {10, 11, 12};
	private Integer[] roomsSelected = {};
	private String buildingSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainStage window = new MainStage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainStage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setTitle("Get There");
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 750, 650);
		panel.add(panel_1);
		
		panel_1.add(new MyGraphics());
		
		JLabel startingFrom = new JLabel("FROM");
		JLabel buildingEntry = new JLabel("Select Building:");
		JLabel roomEntry = new JLabel("Select Room:");

		startingFrom.setBounds(780, 6, 132, 29);
		buildingEntry.setBounds(762, 26, 132, 29);
		roomEntry.setBounds(762, 70, 132, 29);
		
		panel.add(buildingEntry);
		panel.add(startingFrom);
		panel.add(roomEntry);
		
		JLabel endingPoint = new JLabel("TO");
		JLabel buildingEndEntry = new JLabel("Select Building:");
		JLabel roomEndEntry = new JLabel("Select Room:");

		endingPoint.setBounds(780, 126, 132, 29);
		buildingEndEntry.setBounds(762, 146, 132, 29);
		roomEndEntry.setBounds(762, 190, 132, 29);
		
		panel.add(endingPoint);
		panel.add(buildingEndEntry);
		panel.add(roomEndEntry);
		
		//Construct combo box for selecting building
		JComboBox buildingList = new JComboBox(buildings);
		buildingList.setBounds(762, 46, 132, 29);
		buildingList.setEditable(true);
		buildingSelected = (String) buildingList.getSelectedItem();
		switch(buildingSelected){
		case "Stratton Hall":
			roomsSelected = Arrays.copyOfRange(roomsStratton, 0, 4);
			break;
		case "Project Centre":
			roomsSelected = null;
			roomsSelected = Arrays.copyOfRange(roomsStratton, 4, 8);
			break;
		case "Library":
			roomsSelected = roomsLibrary;
			break;
		case "Atwater Kent":
			roomsSelected = roomsAtwaterKent;
			break;
		} 
		
		buildingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				buildingSelected = (String) buildingList.getSelectedItem();
				switch(buildingSelected){
				case "Stratton Hall":
					roomsSelected = Arrays.copyOfRange(roomsStratton, 0, 4);
					break;
				case "Project Centre":
					roomsSelected = roomsProjectCentre;
					break;
				case "Library":
					roomsSelected = roomsLibrary;
					break;
				case "Atwater Kent":
					roomsSelected = roomsAtwaterKent;
					break;
				} 
			}
		});
		panel.add(buildingList);
		
		//Construct combo box for selecting room
		
		JComboBox roomList = new JComboBox(roomsSelected);
		roomList.setEditable(true);
		roomList.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("Make Neighbors Pushed");
		}
		});
		roomList.setBounds(762, 90, 132, 29);
		panel.add(roomList);

		
		JComboBox endBuildingList = new JComboBox(buildings);
		endBuildingList.setBounds(762, 166, 132, 29);
		endBuildingList.setEditable(true);
		panel.add(endBuildingList);

		endBuildingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				buildingSelected = (String) endBuildingList.getSelectedItem();
				switch(buildingSelected){
				case "Stratton Hall":
					roomsSelected = roomsStratton;
					break;
				case "Project Centre":
					roomsSelected = roomsProjectCentre;
					break;
				case "Library":
					roomsSelected = roomsLibrary;
					break;
				case "Atwater Kent":
					roomsSelected = roomsAtwaterKent;
					break;
				} 
			}
		});
		
		JComboBox endRoomList = new JComboBox(roomsSelected);
		endRoomList.setEditable(true);
		endRoomList.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("Make Neighbors Pushed");
		}
		});
		endRoomList.setBounds(762, 210, 132, 29);
		panel.add(endRoomList);

		//Construct button and add action listener
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Export Pushed");	
			}
			});
		
		searchButton.setBounds(762, 250, 132, 29);
		panel.add(searchButton);
	
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
	            g.fillRect(200, 62, 30, 10);
	            
	            
	            //TEST IMAGE
	            //Image img1 = Toolkit.getDefaultToolkit().getImage("/Users/BillySullivan/Downloads/walkingmap.jpg");
	            Image img1 = Toolkit.getDefaultToolkit().getImage("/Users/Lumbini/Documents/B Term/Soft Eng/WPINav/src/Background1.jpg");

			    int width = img1.getWidth(this);
			    int height = img1.getHeight(this);

			    int w = width / 3;
			    int h = height / 3;
			    // explicitly specify width (w) and height (h)
			    g.drawImage(img1, 0, 0, this);
			    g.setColor(Color.black);
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

//import java.awt.*;
//import javax.swing.*;
//
//public class MainStage extends JFrame
//{
//    public static void main(String[] args)
//    {
//        new MainStage();
//    }
//    public MainStage()
//    {
//        //This sets the size of the window
//        this.setSize(1380, 950);
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        Dimension dim = tk.getScreenSize();
//
//        //Centers the window with respect to the screen size
//        int xPos = (dim.width/2) - (this.getWidth()/2);
//        int yPos = (dim.height/2) - (this.getHeight()/2);
//        this.setLocation(xPos, yPos);
//        this.setResizable(false);
//
//        //Sets the close button
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setTitle("Get There");
//
//
//        JPanel scenePanel = new JPanel();   //Holds all other Panels
//        JPanel mapPanel = new JPanel();     //Displays the Map
//        JPanel nodePanel = new JPanel();    //Displays the search box
//        JPanel resultPanel = new JPanel();  //Displays the ETS, distance, turn by turn
//
//        scenePanel.setLayout(new GridBagLayout());  //Uses Grid Bag Layout
//        nodePanel.setLayout(new GridBagLayout());
//        mapPanel.setLayout(new GridBagLayout());
//        resultPanel.setLayout(new GridBagLayout());
//
//
//        JLabel startLabel = new JLabel("Start");
//        JLabel endLabel = new JLabel("End");
//        JLabel mapLabel = new JLabel("Name of Map here");
//        JLabel etaLabel = new JLabel("ETA: Time to destination will be displayed here");
//        JLabel distanceLabel = new JLabel("Distance: Distance to Destination will be displayed here");
//        JLabel instructLabel = new JLabel("Step by Step: ");
//
//        JButton searchButton = new JButton("Search");
//        JButton switchButton = new JButton("Switch");
//
//        JTextField startField = new JTextField("Starting Location...", 30);
//        JTextField endField = new JTextField("End Location...", 30);
//
//        JLabel wpiMap = new JLabel();
//        wpiMap.setIcon(new ImageIcon("C:\\Users\\Lumbini\\Documents\\B Term\\Soft Eng\\WPINav\\src\\WPI Aerial view.jpg"));
//
//        addComp(nodePanel, startLabel, 0, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
//        addComp(nodePanel, startField, 1, 0, 1, 1, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE);
//        addComp(nodePanel, endLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
//        addComp(nodePanel, endField, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
//        addComp(nodePanel, searchButton, 3, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
//        addComp(nodePanel, switchButton, 3, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
//        addComp(mapPanel, mapLabel, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE);
//        addComp(mapPanel, wpiMap, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
//        addComp(resultPanel, etaLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
//        addComp(resultPanel, distanceLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
//        addComp(resultPanel, instructLabel, 0, 3, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE);
//
//        addComp(scenePanel, resultPanel, 1, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
//        addComp(scenePanel, nodePanel, 0, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
//        addComp(scenePanel, mapPanel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
//
//        this.add(scenePanel);
//        this.setVisible(true);
//    }
//
//    private void addComp(JPanel thePanel, JComponent comp,
//                         int xPos, int yPos, int compHeight, int compWidth, int place, int stretch)
//    {
//        GridBagConstraints gridConstraints = new GridBagConstraints();
//
//        gridConstraints.gridx = xPos;
//        gridConstraints.gridy = yPos;
//        gridConstraints.gridwidth = compWidth;
//        gridConstraints.gridheight = compHeight;
//        gridConstraints.weightx = 500;
//        gridConstraints.weighty = 5;
//        gridConstraints.insets = new Insets(10, 10, 10, 10);
//        gridConstraints.anchor = place;
//        gridConstraints.fill = stretch;
//
//        thePanel.add(comp, gridConstraints);
//        validate();
//    }
//}