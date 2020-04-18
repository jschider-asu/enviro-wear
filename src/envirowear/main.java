package envirowear;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.Timer;
import javax.swing.*;

public class main {
	private static JLabel shirtEmergency = new JLabel();
	private static JLabel pantsEmergency = new JLabel();
	private static JLabel bodyTempShirt = new JLabel();
	private static JLabel bodyTempPants = new JLabel();
	private static int desiredShirtTemp = 0;
	private static int desiredPantsTemp = 0;
	private static JLabel desiredST = new JLabel();
	private static JLabel frontST = new JLabel();
	private static JLabel backST = new JLabel();
	private static JLabel desiredPT = new JLabel();
	private static JLabel frontPT = new JLabel();
	private static JLabel backPT = new JLabel();
	private static JLabel frontShirt = new JLabel();
	private static JLabel backShirt = new JLabel();
	private static JLabel frontPants = new JLabel();
	private static JLabel backPants = new JLabel();
	private static JLabel frontSH = new JLabel();
	private static JLabel frontSC = new JLabel();
	private static JLabel backSH = new JLabel();
	private static JLabel backSC = new JLabel();
	private static JLabel frontPH = new JLabel();
	private static JLabel frontPC = new JLabel();
	private static JLabel backPH = new JLabel();
	private static JLabel backPC = new JLabel();
	
	private static final String[] TEMP_LIST = {"60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80"};
	
	public static void main(String args[]) {
		EmergencySensorUnit esuShirt = new EmergencySensorUnit("shirt");
		EmergencySensorUnit esuPants = new EmergencySensorUnit("pants");
		
		
		JFrame m_frame = new JFrame();
		m_frame.setSize(900, 600);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel m_panel = new JPanel();
		m_panel.setLayout(null);
		m_panel.setSize(800,600);
		
		JLabel shirtLabel = new JLabel("Enter Desired Shirt Temp: ");
		shirtLabel.setBounds(10, 10, 200, 30);
		JLabel pantsLabel = new JLabel("Enter Desired Pants Temp: ");
		pantsLabel.setBounds(10, 50, 200, 30);
		//JTextArea shirtTemp = new JTextArea();
		JComboBox<String> shirtTemp = new JComboBox<String>(TEMP_LIST);
		shirtTemp.setSelectedIndex(12);
		shirtTemp.setBounds(170, 15, 150, 20);
		//JTextArea pantsTemp = new JTextArea();
		JComboBox<String> pantsTemp = new JComboBox<String>(TEMP_LIST);
		pantsTemp.setSelectedIndex(12);
		pantsTemp.setBounds(170, 55, 150, 20);
		JButton start_simulation = new JButton("Start");
		
		bodyTempShirt.setText("Shirt Body Temp: ");
		bodyTempShirt.setBounds(450, 10, 200, 30);
		bodyTempPants.setText("Pants Body Temp: ");
		bodyTempPants.setBounds(450, 50, 200, 30);
		shirtEmergency.setForeground(Color.GREEN);
		shirtEmergency.setBounds(650, 10, 300, 30);
		pantsEmergency.setForeground(Color.green);
		pantsEmergency.setBounds(650, 50, 300, 30);
		JButton lowerBodyTempShirt = new JButton("Lower Body Temp Shirt");
		lowerBodyTempShirt.setBounds(450, 100, 175, 30);
		JButton raiseBodyTempShirt = new JButton("Raise Body Temp Shirt");
		raiseBodyTempShirt.setBounds(650, 100, 175, 30);
		JButton lowerBodyTempPants = new JButton("Lower Body Temp Pants");
		lowerBodyTempPants.setBounds(450, 150, 175, 30);
		JButton raiseBodyTempPants = new JButton("Raise Body Temp Pants");
		raiseBodyTempPants.setBounds(650, 150, 175, 30);
		
		
		desiredST.setText("Shirts Desired Temp: ");
		desiredST.setBounds(10, 200, 200, 30);
		desiredPT.setText("Pants Desired Temp: ");
		desiredPT.setBounds(10, 250, 200, 30);
		frontST.setText("Shirt Front Current Temp: ");
		frontST.setBounds(200, 200, 200, 30);
		backST.setText("Shirt Back Current Temp: ");
		backST.setBounds(400, 200, 200, 30);
		frontPT.setText("Pants Front Current Temp:");
		frontPT.setBounds(200, 250, 200, 30);
		backPT.setText("Pants Back Current Temp: ");
		backPT.setBounds(400, 250, 200, 30);
		
		frontShirt.setText("Front Shirt: ");
		frontShirt.setBounds(10, 300, 200, 30);
		frontSH.setText("Heater: Off");
		frontSH.setBounds(200, 300, 200, 30);
		frontSC.setText("Cooler: Off");
		frontSC.setBounds(400, 300, 200, 30);
		backShirt.setText("Back Shirt: ");
		backShirt.setBounds(10, 350, 200, 30);
		backSH.setText("Heater: Off");
		backSH.setBounds(200, 350, 200, 30);
		backSC.setText("Cooler: Off");
		backSC.setBounds(400, 350, 200, 30);
		frontPants.setText("Front Pants: ");
		frontPants.setBounds(10, 400, 200, 30);
		frontPH.setText("Heater: Off");
		frontPH.setBounds(200, 400, 200, 30);
		frontPC.setText("Cooler: Off");
		frontPC.setBounds(400, 400, 200, 30);
		backPants.setText("Back Pants:");
		backPants.setBounds(10, 450, 200, 30);
		backPH.setText("Heater: Off");
		backPH.setBounds(200, 450, 200, 30);
		backPC.setText("Cooler: Off");
		backPC.setBounds(400, 450, 200, 30);
		
		
		m_panel.add(shirtLabel);
		m_panel.add(pantsLabel);
		m_panel.add(shirtTemp);
		m_panel.add(pantsTemp);
		m_panel.add(start_simulation);
		m_panel.add(bodyTempShirt);
		m_panel.add(bodyTempPants);
		m_panel.add(shirtEmergency);
		m_panel.add(pantsEmergency);
		m_panel.add(lowerBodyTempShirt);
		m_panel.add(raiseBodyTempShirt);
		m_panel.add(lowerBodyTempPants);
		m_panel.add(raiseBodyTempPants);
		m_panel.add(desiredST);
		m_panel.add(frontST);
		m_panel.add(backST);
		m_panel.add(desiredPT);
		m_panel.add(frontPT);
		m_panel.add(backPT);
		m_panel.add(frontShirt);
		m_panel.add(frontSH);
		m_panel.add(frontSC);
		m_panel.add(backShirt);
		m_panel.add(backSH);
		m_panel.add(backSC);
		m_panel.add(frontPants);
		m_panel.add(frontPH);
		m_panel.add(frontPC);
		m_panel.add(backPants);
		m_panel.add(backPH);
		m_panel.add(backPC);
		
		m_frame.add(m_panel);
		m_frame.setVisible(true);
		
		start_simulation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				desiredShirtTemp = Integer.parseInt(shirtTemp.getSelectedItem().toString());
				desiredPantsTemp = Integer.parseInt(pantsTemp.getSelectedItem().toString());
				
				esuShirt.setDesiredTemp(desiredShirtTemp);
				esuPants.setDesiredTemp(desiredPantsTemp);
				esuShirt.start();
				esuPants.start();
				
				shirtEmergency.setText("Body temerature within safe limits");
				pantsEmergency.setText("Body temerature within safe limits");
				
				desiredST.setText("Shrits Desired Temp: " + desiredShirtTemp);
				desiredPT.setText("Pants Desired Temp: " + desiredPantsTemp);
			}
		});
		start_simulation.setBounds(10, 100, 100, 30);
	
		lowerBodyTempShirt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(esuShirt.getOverride() == false) {
					esuShirt.lowerBodyTemp();
				} else {
					JOptionPane.showMessageDialog(m_frame, "This option is disabled until the emergency override is rescinded!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		raiseBodyTempShirt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(esuShirt.getOverride() == false) {
					esuShirt.raiseBodyTemp();
				} else {
					JOptionPane.showMessageDialog(m_frame, "This option is disabled until the emergency override is rescinded!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		lowerBodyTempPants.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(esuPants.getOverride() == false) {
					esuPants.lowerBodyTemp();
				} else {
					JOptionPane.showMessageDialog(m_frame, "This option is disabled until the emergency override is rescinded!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		raiseBodyTempPants.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(esuPants.getOverride() == false) {
					esuPants.raiseBodyTemp();
				} else {
					JOptionPane.showMessageDialog(m_frame, "This option is disabled until the emergency override is rescinded!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	
		
		
	}
	
	public static void setShirtBodyTemp(double body_temp) {
		bodyTempShirt.setText("Shirt Body Temp: " + body_temp);
	}
	
	public static void setPantsBodyTemp(double body_temp) {
		bodyTempPants.setText("Pants Body Temp: " + body_temp);
	}
	
	public static void setShirtEmergencyOverride(boolean override, String type) {
		if(override == true) {
			if(type.equals("cooling")) {
				shirtEmergency.setForeground(Color.BLUE);
				shirtEmergency.setText("<html>Body temperature too high!<br>Emergency cooling active!</html>");
			} else {
				shirtEmergency.setForeground(Color.RED);
				shirtEmergency.setText("<html>Body temperature too low!<br>Emergency heating active!</html>");
			}
		} else {
			shirtEmergency.setForeground(Color.GREEN);
			shirtEmergency.setText("<html>Body temperature restored!<br>Emergency override ended!</html>");
		}
	}
	
	public static void setPantsEmergencyOverride(boolean override, String type) {
		if(override == true) {
			if(type.equals("cooling")) {
				pantsEmergency.setForeground(Color.BLUE);
				pantsEmergency.setText("<html>Body temperature too high!<br>Emergency cooling active!</html>");
			} else {
				pantsEmergency.setForeground(Color.RED);
				pantsEmergency.setText("<html>Body temperature too low!<br>Emergency heating active!</html>");
			}
		} else {
			pantsEmergency.setForeground(Color.GREEN);
			pantsEmergency.setText("<html>Body temperature restored!<br>Emergency override ended!</html>");
		}
	}
	public static void setCurrentShirtFrontTemp(int temp) {
		frontST.setText("Shirt Front Current Temp:" + temp);
	}
	
	public static void setCurrentShirtBackTemp(int temp) {
		backST.setText("Shirt Back Current Temp:" + temp);
	}
	
	public static void setCurrentPantsFrontTemp(int temp) {
		frontPT.setText("Pants Front Current Temp:" + temp);
	}
	
	public static void setCurrentPantsBackTemp(int temp) {
		backPT.setText("Pants Back Current Temp:" + temp);
	}
	
	public static void setShirtHeaterFront(boolean status) {
		if(status == false) {
			frontSH.setForeground(Color.black);
			frontSH.setText("Heater: Off");
		} else {
			frontSH.setForeground(Color.GREEN);
			frontSH.setText("Heater: On");
		}
	}
	
	public static void setShirtHeaterBack(boolean status) {
		if(status == false) {
			backSH.setForeground(Color.black);
			backSH.setText("Heater: Off");
		} else {
			backSH.setForeground(Color.GREEN);
			backSH.setText("Heater: On");
		}
	}
	
	public static void setShirtCoolerFront(boolean status) {
		if(status == false) {
			frontSC.setForeground(Color.black);
			frontSC.setText("Cooler: Off");
		} else {
			frontSC.setForeground(Color.GREEN);
			frontSC.setText("Cooler: On");
		}
	}
	
	public static void setShirtCoolerBack(boolean status) {
		if(status == false) {
			backSC.setForeground(Color.black);
			backSC.setText("Cooler: Off");
		} else {
			backSC.setForeground(Color.GREEN);
			backSC.setText("Cooler: On");
		}
	}
	
	public static void setPantsHeaterFront(boolean status) {
		if(status == false) {
			frontPH.setForeground(Color.black);
			frontPH.setText("Heater: Off");
		} else {
			frontPH.setForeground(Color.GREEN);
			frontPH.setText("Heater: On");
		}
	}
	
	public static void setPantsHeaterBack(boolean status) {
		if(status == false) {
			backPH.setForeground(Color.black);
			backPH.setText("Heater: Off");
		} else {
			backPH.setForeground(Color.GREEN);
			backPH.setText("Heater: On");
		}
	}
	
	public static void setPantsCoolerFront(boolean status) {
		if(status == false) {
			frontPC.setForeground(Color.black);
			frontPC.setText("Cooler: Off");
		} else {
			frontPC.setForeground(Color.GREEN);
			frontPC.setText("Cooler: On");
		}
	}
	
	public static void setPantsCoolerBack(boolean status) {
		if(status == false) {
			backPC.setForeground(Color.black);
			backPC.setText("Cooler: Off");
		} else {
			backPC.setForeground(Color.GREEN);
			backPC.setText("Cooler: On");
		}
	}
	
}
