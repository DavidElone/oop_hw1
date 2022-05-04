package hw1_package;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import javax.swing.*;

/**
 * Main application class for exercise #1.
 * This application allows the user to add shapes to a graphical window and
 * to animate them.
 */
@SuppressWarnings("serial")
public class Animator extends JFrame implements ActionListener {

	// preferred frame width and height.
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;

	// graphical components
	private JMenuBar menuBar;
	private JMenu fileMenu, insertMenu, helpMenu;
	private JMenuItem newItem, exitItem,
						rectangleItem, roundedRectangleItem, ovalItem,triangleItem,
						numberedOvalItem, sectorItem, aboutItem;
	private JCheckBoxMenuItem animationCheckItem;
	private JPanel mainPanel;

	// shapes that have been added to this
	
	// TODO: Add and initialize a container of shapes called shapes.
	private Set<Shape> shapes;
	

	/**
	 * @modifies this
	 * @effects Initializes the GUI and enables a timer that steps animation
	 * 			of all shapes in this 25 times per second while animation
	 * 			checkbox is selected.
	 */
	public Animator() {
		super("hw1_package.Animator");
		shapes = new HashSet<Shape>();
		// create main panel and menubar
		mainPanel = (JPanel)createMainPanel();
		getContentPane().add(mainPanel);
		menuBar = (JMenuBar)createMenuBar();
        setJMenuBar(menuBar);

        // enable animation timer (ticks 25 times per second)
		// If the animation doesn't work on your computer, increase the first argument of the Timer constructor
		// until you see the animation. Return the number to 40 before submitting the code.
        Timer timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (animationCheckItem.isSelected()) {
                	// TODO: Add code for making one animation step for all
                	// 		 shapes in this
					Iterator<Shape> itr = shapes.iterator();
					while(itr.hasNext()) {
//						if (Animatable.class.isAssignableFrom(itr.next().getClass())) {
						Animatable actualShape =(Animatable)itr.next();
						actualShape.step(screen.getBounds());
//						}
					}

            		repaint();	// make sure that the shapes are redrawn
                }
            }
        });
        timer.start();
	}


	/**
	 * @return main GUI panel.
	 */
	private JComponent createMainPanel() {
    	JPanel mainPanel = new JPanel();
    	mainPanel.setPreferredSize(
    			new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
    	mainPanel.setBorder(BorderFactory.createLoweredBevelBorder());
    	mainPanel.setBackground(Color.WHITE);

    	return mainPanel;
	}


	/**
	 * @return main GUI menubar.
	 */
	private JMenuBar createMenuBar() {
    	JMenuBar menuBar = new JMenuBar();

    	fileMenu = new JMenu("File");
    	newItem = new JMenuItem("New");
    	newItem.addActionListener(this);
    	fileMenu.add(newItem);
    	animationCheckItem = new JCheckBoxMenuItem("Animation");
    	fileMenu.add(animationCheckItem);
    	exitItem = new JMenuItem("Exit");
    	exitItem.addActionListener(this);
    	fileMenu.add(exitItem);
    	menuBar.add(fileMenu);

    	insertMenu = new JMenu("Insert");
    	rectangleItem = new JMenuItem("Rectangle");
    	rectangleItem.addActionListener(this);
    	insertMenu.add(rectangleItem);
    	roundedRectangleItem = new JMenuItem("Rounded Rectangle");
    	roundedRectangleItem.addActionListener(this);
    	insertMenu.add(roundedRectangleItem);
    	ovalItem = new JMenuItem("Oval");
    	ovalItem.addActionListener(this);
    	insertMenu.add(ovalItem);
    	numberedOvalItem = new JMenuItem("Numbered Oval");
    	numberedOvalItem.addActionListener(this);
    	insertMenu.add(numberedOvalItem);
    	sectorItem = new JMenuItem("Sector");
    	sectorItem.addActionListener(this);
    	insertMenu.add(sectorItem);
    	menuBar.add(insertMenu);

    	helpMenu = new JMenu("Help");
    	aboutItem = new JMenuItem("About");
    	aboutItem.addActionListener(this);
    	helpMenu.add(aboutItem);
    	menuBar.add(helpMenu);

    	return menuBar;
	}


	/**
	 * @modifies g
	 * @effects Paint this including all its shapes to g. This method is
	 * 			invoked by Swing to draw components. It should not be invoked
	 * 			directly, but the repaint method should be used instead in
	 * 			order to schedule the component for redrawing.
	 */
	public void paint(Graphics g) {
		super.paint(g);

		//TODO: Add code for drawing all shapes in this
		Iterator<Shape> itr = this.shapes.iterator();
		while(itr.hasNext()){
			itr.next().draw(g);
		}

		
	}


	/**
	 * @modifies this
	 * @effects Invoked when the user selects an action from the menubar
	 * 			and performs the appropriate operation.
	 */
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem)(e.getSource());

		// File->New : clear all shapes
		if (source.equals(newItem)) {
			shapes.clear();
			repaint();
			
			//TODO  Add code for number of LocationChangingNumerOval = 0
			LocationChangingNumberedOval.resetNumberOfNumberedOval();
		}

		// File->Exit: close application
		else if (source.equals(exitItem)) {
        	dispose();
        }

		// Insert a shape
		else if ((source.equals(roundedRectangleItem)) ||
      		 	 (source.equals(ovalItem)) ||
      		 	 (source.equals(numberedOvalItem)) ||
      		 	 (source.equals(sectorItem))) {

			// TODO: Add code for creating the appropriate shape such that:
			// 		 it is completely inside the window's bounds &&
			//		 its location and size are randomly selected &&
			//		 1/10*WINDOW_WIDTH <= shape.width < 3/10*WINDOW_WIDTH &&
			//		 1/10*WINDOW_HEIGHT <= shape.height < 3/10*WINDOW_HEIGHT

			int width = (int)(new Random().nextInt((int)(0.3*WINDOW_WIDTH)+1) + 0.1*WINDOW_WIDTH) ;
			int height = (int)(new Random().nextInt((int)(0.3*WINDOW_HEIGHT)+1) + 0.1*WINDOW_HEIGHT) ;

			int x = new Random().nextInt(WINDOW_WIDTH+1);
			int y = new Random().nextInt(WINDOW_HEIGHT+1);

			Rectangle window = new Rectangle(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
			Rectangle boundingBoxShape = new Rectangle(x,y,width,height);

			while(!window.contains(boundingBoxShape))
			{
				x = new Random().nextInt(WINDOW_WIDTH+1);
				y = new Random().nextInt(WINDOW_HEIGHT+1);
				boundingBoxShape.setLocation(x, y);
			}
			Color c = LocationAndColorChangingShape.getRandomColor();
			if(source.equals(roundedRectangleItem)){
				LocationAndColorChangingTriangle s = new LocationAndColorChangingTriangle(boundingBoxShape.getLocation(),c,boundingBoxShape.getSize());
				this.shapes.add(s);
			}
			else if(source.equals(ovalItem)) {
				LocationChangingOval s = new LocationChangingOval(boundingBoxShape.getLocation(),c,boundingBoxShape.getSize());
				this.shapes.add(s);
			}
			else if(source.equals(numberedOvalItem)) {
				LocationChangingNumberedOval s = new LocationChangingNumberedOval(boundingBoxShape.getLocation(),c,boundingBoxShape.getSize());
				this.shapes.add(s);
			}
			else {//sectorItem
				int angle = new Random().nextInt(359)+1;
				int sectorAngle = new Random().nextInt(359)+1;
				AngleChangingSector s = new AngleChangingSector(boundingBoxShape.getLocation(),c,angle,sectorAngle,boundingBoxShape.getSize());
				this.shapes.add(s);
			}
			
			repaint();
		}

		// Help->About : show about message dialog
		else if (source.equals(aboutItem)){
			JOptionPane.showMessageDialog(
					this,
					"hw1_package.Animator - 1st" +
					" homework assignment",
					"About",
					JOptionPane.INFORMATION_MESSAGE);
		}
    }


	/**
	 * @effects hw1_package.Animator application.
	 */
	public static void main(String[] args) {
        Animator application = new Animator();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setResizable(false);
        application.pack();
        application.setVisible(true);
	}
}
