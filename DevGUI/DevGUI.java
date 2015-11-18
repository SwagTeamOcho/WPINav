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
import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;



///**
//* Created by Lumbini on 11/7/2015.
//* modified by Billy
// * */
//




public class DevGUI extends JPanel{
    
    String outputVar = "output.txt";
    String inputVar = "output.txt";

    boolean createNodes = false;
    boolean createEdges = false;
    
    private boolean developerMode = true;

    private JFrame frame;       //Creates the main frame for the GUI
    private JPanel uiPanel;     //Panel to hold the interface buttons
    private JPanel mapPanel;    //Panel to hold the map
    private Image mapImage;     //Represents the map to be chosen
    private Image pathImage;    //Image that draws the path on the map

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
    //private String[] buildings = {"Stratton Hall", "Project Centre", "Library", "Atwater Kent"}; 
    private String[] buildings =  {"Stratton Hall Basement", "Stratton Hall First Floor", "Stratton Hall Second Floor"};
    private String buildingSelectedSTART;   //track which building is selected to start in.
    private String buildingSelectedEND;     //track which building is selected to end in.
    //private Map selected;                 //track which map to display

    //List of rooms respective of the buildings
    //private String[] roomsStratton = {"101", "102A", "102B", "103", "104A", "104B", 
      //      "104C", "105A", "105B", "105C", "105D", "106", 
        //    "107", "107A", "108A", "109A", "109B", "110", "111-Bathroom(F)"};
    private String[] strattonBase = {"001","002","003","004","006","007","009","009A","009B","010","011",
									"012","013","014"}
    private String[] strattonFirst ={"101", "102A", "102B", "103", "104A", "104B", 
            "104C", "105A", "105B", "105C", "105D", "106", 
            "107", "107A", "108A", "109A", "109B", "110", "111-Bathroom(F)"}
    private String[] strattonSecond = {"201A", "201B", "201C", "202","202A", "202B", "202C",
									"202D", "202E", "203", "204", "205", "206", "207", "208", "209-Bathroom(M)"}
    private String[] roomsProjectCentre = {"4", "5", "6"};
    private String[] roomsLibrary = {"7", "8", "9"};
    private String[] roomsAtwaterKent = {"10", "11", "12"};

    //Variable to track which room list to display
    private String[] roomsSelected = {};
    
    private static String startBuilding;
    private String endBuilding;

    protected enum BUILDINGS {
        /*STRATTONHALL, PROJECTCENTRE, LIBRARY, ATWATERKENT;
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
        }*/
    	STRATTONHALLBASE, STRATTONHALLFIRST, STRATTONHALLSECOND;
        public static BUILDINGS getEnum(String s){
            if(s.equals("Stratton Hall Basement")){
                startBuilding = "Stratton Hall Basement";
            	return STRATTONHALLBASE;
            }else if(s.equals("Stratton Hall First Floor")){
            	startBuilding = "Stratton Hall First Floor";
                return STRATTONHALLFIRST;
            }else if(s.equals("Stratton Hall Second Floor")){
            	startBuilding = "Stratton Hall Second Floor";
            	return STRATTONHALLSECOND;
            }
            throw new IllegalArgumentException("No Enum specified for this string");
        }
    }

    private Edge edge;
    private Node node1;
    private Node node2;
    private LinkedList<Edge> edgeList = new LinkedList<Edge>();
    private LinkedList<Node> nodeList = new LinkedList<Node>();
    File file1;
    Process process1;
    File output;
    Writer filewriter;
    
    
    /**
     * Create the application.
     */
    public DevGUI(){
        initialize();
    }

    //Launch the application. 
    public static void main(String[] args) {
        
        
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        DevGUI window = new DevGUI();
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
        MouseEvents m1 = new MouseEvents();
        mapPanel.add(m1);

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
        //      startRoomSEL.addItemListener((ItemListener) startBuildingSEL);
        //      startRoomSEL.putClientProperty(buildings[1], roomsStratton);
        //      startRoomSEL.putClientProperty(buildings[2], roomsProjectCentre);
        //      startRoomSEL.putClientProperty(buildings[3], roomsLibrary);
        //      startRoomSEL.putClientProperty(buildings[4], roomsAtwaterKent);
        startRoomSEL.setBounds(762, 90, 132, 29);
        startRoomSEL.setEditable(false);
        startRoomSEL.setVisible(true);

        //Construct Combo boxes to select end point
        endBuildingSEL = new JComboBox(buildings);
        endBuildingSEL.setBounds(762, 166, 132, 29);
        endBuildingSEL.setEditable(false);
        endBuildingSEL.setVisible(true);

        endRoomSEL = new JComboBox(roomsSelected);
        //      endRoomSEL.addItemListener((ItemListener) endBuildingSEL);
        //      endRoomSEL.putClientProperty(buildings[1], roomsStratton);
        //      endRoomSEL.putClientProperty(buildings[2], roomsProjectCentre);
        //      endRoomSEL.putClientProperty(buildings[3], roomsLibrary);
        //      endRoomSEL.putClientProperty(buildings[4], roomsAtwaterKent);       
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

        if(developerMode)
        {

            JButton btnCreateNodes = new JButton("Create Nodes");
            btnCreateNodes.setBounds(762, 300, 132, 29);
            uiPanel.add(btnCreateNodes);
            btnCreateNodes.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) 
                    {
                        System.out.println("Create Nodes Pushed");
                        createNodes = true;
                        createEdges = false;
                        

                    }
                });

            //Construct button and add action listener
            JButton btnMakeNeighbors = new JButton("Make Neighbors");
            btnMakeNeighbors.setBounds(762, 330, 132, 29);
            uiPanel.add(btnMakeNeighbors);
            btnMakeNeighbors.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    {
                        System.out.println("Make Neighbors Pushed");
                        createNodes = false;
                        createEdges = true;

                    }
                });

            //Construct button and add action listener
            JButton btnExport = new JButton("Export");
            btnExport.setBounds(762, 360, 132, 29);
            uiPanel.add(btnExport);
            btnExport.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) 
                    {
                        System.out.println("Export Pushed");
                        //m1.produceNodes();
                        //m1.produceEdges();
                        
                        try{
                        output = new File(outputVar);
                        output.createNewFile();
                        
                        filewriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputVar), "utf-8"));
                        StringBuilder sb = new StringBuilder();
                     
                        
                        
                        for (int i = 0; i < edgeList.size(); i++){
                            if (i > 0){
                                sb.append("\n");
                            }
                            sb.append("Nodex ");
                            sb.append(edgeList.get(i).getNode1().getX());
                            sb.append(" Nodey ");
                            sb.append(edgeList.get(i).getNode1().getY());
                            sb.append(" Node2x ");
                            sb.append(edgeList.get(i).getNode2().getX());
                            sb.append(" Node2y ");
                            sb.append(edgeList.get(i).getNode2().getY());
                            sb.append(" Weight ");
                            sb.append(edgeList.get(i).getWeight());
                            
                        }
                        
                        String everything = sb.toString();
                        filewriter.write(everything);
                        filewriter.close();
                        }catch(IOException f){
                            System.out.println(f);
                        }

                    }
                });
           JButton btnImport = new JButton("Import");
            btnImport.setBounds(762, 390, 132, 29);
            uiPanel.add(btnImport);
            btnImport.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                    System.out.println("Import Pushed");
                    file1 = new File(inputVar);
                    process1 = new Process(file1);
                    nodeList.addAll(process1.getNodes());
                    edgeList.addAll(process1.getEdges());
                    repaint();
                    
                    int x;
                    int y;
                    for(int i = 0; i < nodeList.size(); i++){
                        x = (nodeList.get(i).getX());
                        y = (nodeList.get(i).getY());
                    }

                }
            });     
                
            


        }     

            
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
                    case STRATTONHALLBASE:
                        roomsSelected = roomsStratton;
                        break;
                    case STRATTONHALLFIRST:
                        roomsSelected = roomsProjectCentre;
                        break;
                    case STRATTONHALLSECOND:
                        roomsSelected = roomsLibrary;
                        break;
                        /*case ATWATERKENT:       //rest of floor cases
                        roomsSelected = roomsAtwaterKent;
                        break;*/
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
                    switch(BUILDINGS.getEnum(buildingSelectedSTART)){
                        case STRATTONHALLBASE:
                        roomsSelected = roomsStratton;
                        break;
                        case STRATTONHALLFIRST:
                        roomsSelected = roomsProjectCentre;
                        break;
                        case STRATTONHALLSECOND:
                        roomsSelected = roomsLibrary;
                        break;
                        /*case ATWATERKENT:       //rest of floor cases
                        roomsSelected = roomsAtwaterKent;
                        break;*/
                    } 
                }
            });
        uiPanel.repaint();
        frame.repaint();
    }
    
    
    
    public class MouseEvents extends JComponent implements MouseMotionListener{
        private static final long serialVersionUID = 1L;

    
        private static final int SquareWidth = 5;

        private static final int Max = 1000;

        public Rectangle[] squares = new Rectangle[Max];
        
        private Line2D[] lines = new Line2D[Max];

        private int squareCount = 0;
        private int lineCount = 0;

        private int currentSquareIndex = -1;
        private int currentLineIndex = -1;

        // private BufferedImage image;

        public String nodes;

        private int count = 0;
        private int startingX = 0;
        private int startingY = 0;
       // private int 
         
        

        MouseEvents() {
            setPreferredSize(new Dimension(760, 666));
            addMouseMotionListener(this);
            addMouseListener(new MouseAdapter() 
                {
                    public void mousePressed(MouseEvent evt) {
                        int x = evt.getX();
                        int y = evt.getY();
                        int startingX = 0;
                        int startingY = 0;
                        currentSquareIndex = getSquare(x, y);
                        if(createNodes)
                        {
                            if (currentSquareIndex < 0) {// not inside a square
                                add(x, y);
                                nodeList.add(new Node(x, y));
                                //evt.getComponent();
                            }
                        }
                        else if (createEdges)
                        {
                            for (int i = 0; i < nodeList.size(); i++){
                                add(nodeList.get(i).getX(), nodeList.get(i).getY());
                            }
                            if(count == 0)
                            {
                                startingX = (int) squares[currentSquareIndex].getX();
                                startingY = (int) squares[currentSquareIndex].getY();
                                count++;
                            }
                            else if (count == 1)
                            {
                                createEdge(startingX, startingY, x, y);
                                node1 = new Node(startingX, startingY);
                                node2 = new Node(x, y);
                                edge = new Edge(node1, node2, (int) calcDistance(startingX, startingY, x, y));
                                edgeList.add(edge);
                                System.out.println("Create Edge: " + startingX +" "+ startingY +"\t"+ x + " " + y +"\nDistance: "+ calcDistance(startingX, startingY, x, y));
                                count = 0;
                            }
                        }
                    }

                    public void mouseClicked(MouseEvent evt) {
                        int x = evt.getX();
                        int y = evt.getY();

                        System.out.println("\nX: " + x + "\t Y: " + y);
                        repaint();

                        if (evt.getClickCount() >= 2) {
                         //   remove(currentSquareIndex);
                        }
                    }
                });
            addMouseMotionListener(this);

        }
        
        
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon mapIcon = new ImageIcon();
            if(startBuilding.equals("Stratton Hall Basement")) {
            	mapIcon = new ImageIcon("StrattonHall-Basement.jpg");
            }
            if(startBuilding.equals("Stratton Hall First Floor")) {
            	mapIcon = new ImageIcon("StrattonHall_FirstFloor.jpg");
            }
            if(startBuilding.equals("Stratton Hall Second Floor")) {
            	mapIcon = new ImageIcon("StrattonHall-2nd.jpg");
            }
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
                    1.5f, 
                    BasicStroke.CAP_ROUND, 
                    BasicStroke.JOIN_ROUND);
            g2d.setStroke(s);
            g2d.setColor(Color.BLACK);
//             if (path==null) {
//                 path = new GeneralPath();
//                 path.moveTo(100, 20);
//                 path.lineTo(100, 300);
//                 path.lineTo(200, 100);
//                 path.lineTo(100, 80);
//             }
//             g2d.draw(path);
//             g2d.setStroke(new BasicStroke(3));
//             g2d.setColor(Color.RED);
//             g2d.draw(path);

            for (int i = 0; i < nodeList.size(); i++){
                ((Graphics2D)g).draw(new Rectangle (nodeList.get(i).getX(), nodeList.get(i).getY(), SquareWidth, SquareWidth));
            }
            
            for (int i = 0; i < edgeList.size(); i++){
                ((Graphics2D)g).draw(new Line2D.Double(edgeList.get(i).getNode1().getX(), edgeList.get(i).getNode1().getY(),edgeList.get(i).getNode2().getX(),edgeList.get(i).getNode2().getY() ));
                }
        }
        
        public double calcDistance(int x1, int y1, int x2, int y2)
        {
            return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        }
        
        public double calcDistance(int x1, int y1, int x2, int y2, int scale)
        {
            return (Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2))) * scale;
        }

        public void printSquareInfo()
        {
            System.out.println(squares);
        }

        public int getSquare(int x, int y) {
            for (int i = 0; i < squareCount; i++)
                if(squares[i].contains(x,y))
                    return i;
            return -1;
        }
        
        
        
        
        public int getLines(int x, int y) {
            for (int i = 0; i < lineCount; i++)
                if(lines[i].contains(x,y))
                    return i;
            return -1;
        }
        

        public void add(int x, int y) {
            if (squareCount < Max) {
                squares[squareCount] = new Rectangle(x, y,SquareWidth,SquareWidth);
                currentSquareIndex = squareCount;
                squareCount++;
                repaint();
            }
        }
        
        

          public void createEdge(int x1, int y1, int x2, int y2)
           {
                
                if (lineCount < Max) {
                    lines[lineCount] = new Line2D.Double(squares[getSquare(x1, y1)].getX(),
                                                         squares[getSquare(x1, y1)].getY(),
                                                         squares[getSquare(x2, y2)].getX(),
                                                         squares[getSquare(x2, y2)].getY());
                                                    
                                                    
                                                    
                                                    
                    currentLineIndex = lineCount;
                    lineCount++;
                    repaint();
                    }
                
                 ;
            
            
               
              // Graphics g = new Graphics();
               
              
              
//                GeneralPath path = null;
//                path = new GeneralPath();
//                
//              
//                
//                path.moveTo(x1, y1);
// 
//                path.lineTo(x2, y2);
//                
//                g2d.draw(path);
//                g2d.setStroke(new BasicStroke(3));
//                g2d.setColor(Color.RED);
//                g2d.draw(path);
              

               
               
               
              // distance =  Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
           }
        
        
        
        
        
        
        
        
        public void removeLinesAtSquare(int x, int y)
        {
            for (int i = 0; i < lineCount; i++)
            {
                int sqX1 = (int) lines[i].getX1();
                int sqY1 = (int) lines[i].getY1();
                int sqX2 = (int) lines[i].getX2();
                int sqY2 = (int) lines[i].getY2();
                int tolarance = 5;
                
            if(((x-tolarance <=  sqX1) && (sqX1 <= x+tolarance)) && ((y-tolarance <=  sqY1 ) && ( sqY1 <= y+tolarance)) 
              || (((x-tolarance <=  sqX2) && (sqX2 <= x+tolarance)) && ((y-tolarance <=  sqY2) && (sqY2 <= y+tolarance))))
            {
                System.out.println("Remove line: " +i);
                
                if (i < 0 || i >= lineCount)
                    return;
                lineCount--;
                lines[i] = lines[lineCount];
                if (currentLineIndex == i)
                    currentLineIndex = -1;
                repaint();
                }
            }
            
        }
        
        
        

        public void remove(int n) {
            
            if (n < 0 || n >= squareCount)
                return;
            removeLinesAtSquare((int)squares[n].getX(), (int)squares[n].getY());
            squareCount--;
            squares[n] = squares[squareCount];
            if (currentSquareIndex == n)
                currentSquareIndex = -1;
            repaint();
            
            
        }

        public void produceNodes(){
            nodes = "";
            for (int i = 0; i < squareCount; i++){
                nodes = nodes +"\nX: " + squares[i].getX() + "  Y: " + squares[i].getY();
            }
            System.out.print(nodes);
        }
        
        
        public void produceEdges(){
            nodes = "";
            int lineArrSize = lines.length;
            
            for (int i = 0; i < lineArrSize; i++){
                nodes = nodes +"\nX: " + squares[i].getX() + "  Y: " + squares[i].getY();
            }
            System.out.print(nodes);
        }
        
        

        public void mouseMoved(MouseEvent evt) {
            int x = evt.getX();
            int y = evt.getY();

            if (getSquare(x, y) >= 0)
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            else
                setCursor(Cursor.getDefaultCursor());
            
//            
//            if (getLines(x, y) >= 0)
//                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//            else
//                setCursor(Cursor.getDefaultCursor());    
                
                
        }
//        public int getConnectedLineIndex(int x, int y)
//        {
//            return getLines();
//        }
//        
        
       
        
        

        public void mouseDragged(MouseEvent evt) {
//            int x = evt.getX();
//            int y = evt.getY();
//
//            if (currentSquareIndex >= 0) {
//                Graphics g = getGraphics();
//                g.setXORMode(getBackground());
//                ((Graphics2D)g).draw(squares[currentSquareIndex]);
//                squares[currentSquareIndex].x = x;
//                squares[currentSquareIndex].y = y;
//                ((Graphics2D)g).draw(squares[currentSquareIndex]);
//                g.dispose();
//            }
        }
    }

}
