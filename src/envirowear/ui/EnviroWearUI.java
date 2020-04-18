package envirowear.ui;

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

@SuppressWarnings("serial")
public class EnviroWearUI extends JFrame implements ActionListener {

	private Container pane = getContentPane();
	private JPanel mainpnl;
	private JPanel mainLeftpnl;
	private JPanel mainRightpnl;
	private JPanel currentCirclepnl;
	private JPanel currentShirtpnl;
	private JPanel currentPantspnl;
	
	private JPanel radioBtnpnl;
	private JPanel overallpnl;
	private JPanel individualpnl;
	private JPanel overallTemppnl;
	private JPanel shirtTemppnl;
	private JPanel pantsTemppnl;
	
	private JPanel p;
	private JPanel jp;
	private JPanel jpl;
	
	private JComboBox<String> overallTempcbx;
	private JComboBox<String> shirtTempcbx;
	private JComboBox<String> pantsTempcbx;
	
	
	private JRadioButton overallBtn;
	private JRadioButton individualBtn;
	
	private JLabel overallTempLbl;
	private JLabel shirtTempLbl;
	private JLabel pantsTempLbl;
	private JLabel currentTempLbl;
	private JLabel currentShirtLbl;
	private JLabel currentPantsLbl;
	
	private String currentTempText;
	private String currentShirtText;
	private String currentPantsText;
	
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
		
		radioBtnpnl = new JPanel(new GridLayout(2,1));
		overallpnl = new JPanel(new GridLayout(2,1));
		individualpnl = new JPanel(new GridLayout(3,1));
		overallTemppnl = new JPanel(new FlowLayout());
		shirtTemppnl = new JPanel(new FlowLayout());
		pantsTemppnl = new JPanel(new FlowLayout());
		
		overallTempcbx = new JComboBox<String>(TEMP_LIST);
		overallTempcbx.setFont(BIG_FONT);
		overallTempcbx.setSelectedIndex(12);
		overallTempcbx.addActionListener(this);
		shirtTempcbx = new JComboBox<String>(TEMP_LIST);
		shirtTempcbx.setFont(BIG_FONT);
		shirtTempcbx.setSelectedIndex(12);
		shirtTempcbx.addActionListener(this);
		pantsTempcbx = new JComboBox<String>(TEMP_LIST);
		pantsTempcbx.setFont(BIG_FONT);
		pantsTempcbx.setSelectedIndex(12);
		pantsTempcbx.addActionListener(this);
		
		overallTempLbl = new JLabel("Select overall temperature:");
		overallTempLbl.setFont(BIG_FONT);
		shirtTempLbl = new JLabel("Select shirt temperature:");
		shirtTempLbl.setFont(BIG_FONT);
		pantsTempLbl = new JLabel("Select pants temperature:");
		pantsTempLbl.setFont(BIG_FONT);
		
		currentTempText = "Current Temperature: ";
		currentShirtText = "Current Shirt Temperature: ";
		currentPantsText = "Current Pants Temperature: ";
		
		currentTempLbl = new JLabel(currentTempText);
		currentTempLbl.setFont(BIG_FONT);
		currentShirtLbl = new JLabel(currentShirtText);
		currentShirtLbl.setFont(BIG_FONT);
		currentPantsLbl = new JLabel(currentShirtText);
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
	    
		p = new JPanel() {
				
				public void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Shape circle = new Ellipse2D.Double(0, 0, 80, 80);
					g2.setColor(getCurrentColor());
					g2.fill(circle);
					g2.draw(circle);
				}
		};
		
		jp = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Shape circle = new Ellipse2D.Double(0, 0, 80, 80);
				g2.setColor(getCurrentColor());
				g2.fill(circle);
				g2.draw(circle);
			}
		};
		
		jpl = new JPanel() {
			
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				Shape circle = new Ellipse2D.Double(0, 0, 80, 80);
				g2.setColor(getCurrentColor());
				g2.fill(circle);
				g2.draw(circle);
			}
		};
		
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

		pane.add(mainpnl);
		
		setTitle ("EnviroWear Control UI");
		setSize (900, 650);
		setLocationRelativeTo (null);
		setCurrentColor(Color.GREEN);
		
		setDefaultCloseOperation (EXIT_ON_CLOSE);
	}
	
	

	
	public static void main(String[] args) {
		
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
			
			currentTempLbl.setText(currentTempText + overallTempcbx.getSelectedItem().toString());
			currentShirtLbl.setText(currentShirtText + shirtTempcbx.getSelectedItem().toString());
			currentPantsLbl.setText(currentPantsText + pantsTempcbx.getSelectedItem().toString());
				
			p.repaint();
			jp.repaint();
			jpl.repaint();
		} else if (e.getSource() == shirtTempcbx) {
			colorRules(shirtTempcbx.getSelectedIndex());
			currentShirtLbl.setText(currentShirtText + shirtTempcbx.getSelectedItem().toString());
			
			jp.repaint();
		} else if (e.getSource() == pantsTempcbx) {
			colorRules(pantsTempcbx.getSelectedIndex());
			currentPantsLbl.setText(currentPantsText + pantsTempcbx.getSelectedItem().toString());
			
			jpl.repaint();
		}
	}
	

}
