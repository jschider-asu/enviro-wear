package envirowear.ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EnviroWearUI extends JFrame implements ActionListener {

	private Container pane = getContentPane();
	private JPanel mainpnl;
	private JPanel mainLeftpnl;
	private JPanel mainRightpnl;
	private JPanel currentCirclepnl;
	private JPanel currentShirtpnl;
	private JPanel currentPantspnl;
	
	
	private JPanel mainNorthpnl;
	private JPanel mainCenterpnl;
	private JPanel mainWestpnl;
	private JPanel mainSouthpnl;
	private JPanel radioBtnpnl;
	private JPanel overallpnl;
	private JPanel individualpnl;
	private JPanel overallTemppnl;
	private JPanel shirtTemppnl;
	private JPanel pantsTemppnl;
	
	private JPanel p;
	private JPanel jp;
	private JPanel jpl;
	
	private JComboBox overallTempcbx;
	private JComboBox shirtTempcbx;
	private JComboBox pantsTempcbx;
	
	
	private JRadioButton overallBtn;
	private JRadioButton individualBtn;
	
	private JLabel overallTempLbl;
	private JLabel shirtTempLbl;
	private JLabel pantsTempLbl;
	private JLabel currentTempLbl;
	private JLabel currentShirtLbl;
	private JLabel currentPantsLbl;
	
	private Color currentColor;
	
	private static final Font BIG_FONT = new Font("Arial",Font.BOLD, 16);
	private static final String[] TEMP_LIST = {"60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80"};
	
	public Color getCurrentColor() {
		return currentColor;
	}
	
	public void setCurrentColor(Color color) {
		currentColor = color;
	}
	
	public EnviroWearUI() {
		//mainpnl = new JPanel(new BorderLayout());
		mainpnl = new JPanel(new GridLayout(1,2));
		mainLeftpnl = new JPanel(new GridLayout(3,1));
		mainRightpnl = new JPanel(new GridLayout(3,1));
		currentCirclepnl = new JPanel(new GridLayout(2,1));
		currentShirtpnl = new JPanel(new GridLayout(2,1));
		currentPantspnl = new JPanel(new GridLayout(2,1));
		
		mainNorthpnl = new JPanel(new FlowLayout());
		mainCenterpnl = new JPanel(new GridLayout(2,1));
		mainWestpnl = new JPanel(new GridLayout(2,1));
		mainSouthpnl = new JPanel(new FlowLayout());
		radioBtnpnl = new JPanel(new GridLayout(2,1));
		overallpnl = new JPanel(new GridLayout(2,1));
		individualpnl = new JPanel(new GridLayout(3,1));
		overallTemppnl = new JPanel(new FlowLayout());
		shirtTemppnl = new JPanel(new FlowLayout());
		pantsTemppnl = new JPanel(new FlowLayout());
		
		overallTempcbx = new JComboBox(TEMP_LIST);
		overallTempcbx.setFont(BIG_FONT);
		overallTempcbx.setSelectedIndex(12);
		overallTempcbx.addActionListener(this);
		shirtTempcbx = new JComboBox(TEMP_LIST);
		shirtTempcbx.setFont(BIG_FONT);
		shirtTempcbx.setSelectedIndex(12);
		shirtTempcbx.addActionListener(this);
		pantsTempcbx = new JComboBox(TEMP_LIST);
		pantsTempcbx.setFont(BIG_FONT);
		pantsTempcbx.setSelectedIndex(12);
		pantsTempcbx.addActionListener(this);
		
		overallTempLbl = new JLabel("Select overall temperature:");
		overallTempLbl.setFont(BIG_FONT);
		shirtTempLbl = new JLabel("Select shirt temperature:");
		shirtTempLbl.setFont(BIG_FONT);
		pantsTempLbl = new JLabel("Select pants temperature:");
		pantsTempLbl.setFont(BIG_FONT);
		currentTempLbl = new JLabel("Current Temperature:");
		currentTempLbl.setFont(BIG_FONT);
		currentShirtLbl = new JLabel("Current Shirt Temperature:");
		currentShirtLbl.setFont(BIG_FONT);
		currentPantsLbl = new JLabel("Current Pants Temperature:");
		currentPantsLbl.setFont(BIG_FONT);
		
		ButtonGroup group = new ButtonGroup();
		overallBtn = new JRadioButton("Overall Temp");
		overallBtn.setFont(BIG_FONT);	
		overallBtn.setSelected(true);
		individualBtn = new JRadioButton("Individual Temp");
		individualBtn.setFont(BIG_FONT);
		group.add(overallBtn);
		group.add(individualBtn);
	     
	    overallBtn.addActionListener(this);
	    individualBtn.addActionListener(this);
	    
	    overallTemppnl.add(overallTempLbl);
	    overallTemppnl.add(overallTempcbx);
	    
	    overallpnl.add(overallBtn);
	    overallpnl.add(overallTemppnl);
	    
	    shirtTemppnl.add(shirtTempLbl);
	    shirtTemppnl.add(shirtTempcbx);
	    
	    pantsTemppnl.add(pantsTempLbl);
	    pantsTemppnl.add(pantsTempcbx);
	    
	    individualpnl.add(individualBtn);
	    individualpnl.add(shirtTemppnl);
	    individualpnl.add(pantsTemppnl);
	    
	    radioBtnpnl.add(overallpnl);
	    radioBtnpnl.add(individualpnl);
	    
	    mainLeftpnl.add(overallpnl);
	    mainLeftpnl.add(individualpnl);
	    
	    //mainLeftpnl.add(radioBtnpnl);
				
		setTitle ("EnviroWear Control UI");
		setSize (900, 650);
		setLocationRelativeTo (null);
		//JLabel lblHelloWorld = new JLabel ("Hello World\nWhy no show?");
		//mainNorthpnl.add(lblHelloWorld);
		
		currentColor = Color.GREEN;
		setCurrentColor(Color.GREEN);
		
		p = new JPanel() {
				
				public void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					//Shape line = new Line2D.Double(3, 3, 303, 303);
					//Shape rect = new Rectangle(3, 3, 303, 303);
					Shape circle = new Ellipse2D.Double(5, 5, 75, 75);
					g2.setColor(getCurrentColor());
					g2.fill(circle);
					//Shape roundRect = new RoundRectangle2D.Double(20, 20, 250, 250, 5, 25);
					//g2.draw(line);
					//g2.draw(rect);
					g2.draw(circle);
					//g2.draw(roundRect);
				}
		};
		
		jp = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				//Shape line = new Line2D.Double(3, 3, 303, 303);
				//Shape rect = new Rectangle(3, 3, 303, 303);
				Shape circle = new Ellipse2D.Double(5, 5, 75, 75);
				g2.setColor(getCurrentColor());
				g2.fill(circle);
				//Shape roundRect = new RoundRectangle2D.Double(20, 20, 250, 250, 5, 25);
				//g2.draw(line);
				//g2.draw(rect);
				g2.draw(circle);
				//g2.draw(roundRect);
			}
		};
		
		jpl = new JPanel() {
					
					public void paintComponent(Graphics g) {
						Graphics2D g2 = (Graphics2D) g;
						//Shape line = new Line2D.Double(3, 3, 303, 303);
						//Shape rect = new Rectangle(3, 3, 303, 303);
						Shape circle = new Ellipse2D.Double(5, 5, 75, 75);
						g2.setColor(getCurrentColor());
						g2.fill(circle);
						//Shape roundRect = new RoundRectangle2D.Double(20, 20, 250, 250, 5, 25);
						//g2.draw(line);
						//g2.draw(rect);
						g2.draw(circle);
						//g2.draw(roundRect);
					}
		};
		
		
		//mainWestpnl.add(currentTempLbl);
		//mainWestpnl.add(p);
		
		//BufferedImage myPicture = null;
		//BufferedImage myPants = null;
		//try {
		//	myPicture = ImageIO.read(new File("c:\\Users\\jschider\\Downloads\\shirt.png"));
		//	myPants = ImageIO.read(new File("c:\\Users\\jschider\\Downloads\\pants.png"));
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		//mainCenterpnl.add(picLabel);
		//mainCenterpnl.add(p);
		//JLabel pantsLabel = new JLabel(new ImageIcon(myPants));
		//mainCenterpnl.add(pantsLabel);
		//mainCenterpnl.add(p);
		//mainNorthpnl.add(mainWestpnl);
		currentCirclepnl.add(currentTempLbl);
		currentCirclepnl.add(p);
		
		currentShirtpnl.add(currentShirtLbl);
		currentShirtpnl.add(jp);
		
		currentPantspnl.add(currentPantsLbl);
		currentPantspnl.add(jpl);
		
		mainRightpnl.add(currentCirclepnl);
		mainRightpnl.add(currentShirtpnl);
		mainRightpnl.add(currentPantspnl);
		
		mainpnl.add(mainLeftpnl);
		mainpnl.add(mainRightpnl);
		//mainpnl.add(mainWestpnl);
		pane.add(mainpnl);
		//pane.add(p);
		
		setDefaultCloseOperation (EXIT_ON_CLOSE);
	}
	
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//Get the winodows look and feel from Windows
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		}
		catch(Exception e) {
			//If not a windows machine use JFrame look and feel
			e.printStackTrace();
			JFrame.setDefaultLookAndFeelDecorated(true);
		}
		
		
        javax.swing.SwingUtilities.invokeLater (new Runnable () {
				@Override
				public void run () {	
				
				EnviroWearUI ui = new EnviroWearUI();
				ui.setVisible (true);
				
				}
				} );
		}  //end of void main


	public void colorRules(int i) {
		if(i > 14)
			setCurrentColor(Color.RED);
		else if(i > 12 && i <= 14)
			setCurrentColor(Color.ORANGE);
		else if(i <= 12 && i > 5)
			setCurrentColor(Color.GREEN);
		else if(i <= 5)
			setCurrentColor(Color.BLUE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == overallTempcbx) {
			
			colorRules(overallTempcbx.getSelectedIndex());
			
			shirtTempcbx.setSelectedIndex(overallTempcbx.getSelectedIndex());
			pantsTempcbx.setSelectedIndex(overallTempcbx.getSelectedIndex());
				
			//System.out.println("Change color");
			p.repaint();
			jp.repaint();
			jpl.repaint();
		} else if (e.getSource() == shirtTempcbx) {
			colorRules(shirtTempcbx.getSelectedIndex());
			
			//System.out.println("change jp");
			jp.repaint();
		} else if (e.getSource() == pantsTempcbx) {
			colorRules(pantsTempcbx.getSelectedIndex());
			
			//System.out.println("change jp");
			jpl.repaint();
		}
	}
	

}
