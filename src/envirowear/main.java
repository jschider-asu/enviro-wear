package envirowear;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;
import java.util.Timer;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class main {
	private static JLabel shirtEmergencylbl = new JLabel();
	private static JLabel pantsEmergencylbl = new JLabel();
	private static JLabel shirtEmergencyStatus = new JLabel();
	private static JLabel pantsEmergencyStatus = new JLabel();
	private static JLabel bodyTempShirtlbl = new JLabel();
	private static JLabel bodyTempPantslbl = new JLabel();
	private static JLabel bodyTempShirt = new JLabel();
	private static JLabel bodyTempPants = new JLabel();
	private static JLabel btcShirtlbl = new JLabel();
	private static JLabel btcPantslbl = new JLabel();
	private static JLabel btsShirtlbl = new JLabel();
	private static JLabel btsPantslbl = new JLabel();
	private static int desiredShirtTemp = 75;
	private static int desiredPantsTemp = 75;
	private static JLabel dtcShirtlbl = new JLabel();
	private static JLabel dtcPantslbl = new JLabel();
	private static JLabel desiredshirtTemp = new JLabel();
	private static JLabel desiredpantsTemp = new JLabel();
	private static JLabel ctcShirtTempFront = new JLabel();
	private static JLabel ctcShirtTempBack = new JLabel();
	private static JLabel ctcPantsTempFront = new JLabel();
	private static JLabel ctcPantsTempBack = new JLabel();
	
	private static JLabel scFrontHeater = new JLabel();
	private static JLabel scBackHeater = new JLabel();
	private static JLabel scFrontCooler = new JLabel();
	private static JLabel scBackCooler = new JLabel();
	private static JLabel scFrontHeaterStatus = new JLabel();
	private static JLabel scBackHeaterStatus = new JLabel();
	private static JLabel scFrontCoolerStatus = new JLabel();
	private static JLabel scBackCoolerStatus = new JLabel();
	
	
	private static JLabel pcFrontHeater = new JLabel();
	private static JLabel pcBackHeater = new JLabel();
	private static JLabel pcFrontCooler = new JLabel();
	private static JLabel pcBackCooler = new JLabel();
	private static JLabel pcFrontHeaterStatus = new JLabel();
	private static JLabel pcBackHeaterStatus = new JLabel();
	private static JLabel pcFrontCoolerStatus = new JLabel();
	private static JLabel pcBackCoolerStatus = new JLabel();

	private static boolean running;
	
	public static void main(String args[]) {
		TitledBorder title;
		EmergencySensorUnit esuShirt = new EmergencySensorUnit("shirt");
		EmergencySensorUnit esuPants = new EmergencySensorUnit("pants");
		running = false;
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JFrame m_frame = new JFrame();
		m_frame.setSize(650, 750);
		m_frame.setLayout(null);
		m_frame.setLocationRelativeTo(null);
		m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-----------Power Panel & Components---------------------//
		
		JPanel power_panel = new JPanel();
		power_panel.setLayout(null);
		power_panel.setBounds(5, 5, 75, 85);
		title = BorderFactory.createTitledBorder(loweredetched, "System");
		power_panel.setBorder(title);
		
		ButtonGroup system = new ButtonGroup();
		JRadioButton on = new JRadioButton("On");
		on.setSelected(false);
		on.setBounds(10, 20, 50, 30);

		JRadioButton off = new JRadioButton("Off");
		off.setSelected(true);
		off.setBounds(10, 45, 50, 30);
		
		power_panel.add(on);
		system.add(on);
		power_panel.add(off);
		system.add(off);
		
		
		//------Emergency Panel & Components-----------------//
		
		JPanel emergency_panel = new JPanel();
		emergency_panel.setLayout(null);
		emergency_panel.setBounds(100, 5, 200, 85);
		title = BorderFactory.createTitledBorder(loweredetched, "Emergency Status");
		emergency_panel.setBorder(title);
		
		shirtEmergencylbl.setText("Shirt State:");
		shirtEmergencylbl.setBounds(5, 20, 75, 30);
		pantsEmergencylbl.setText("Pants State:");
		pantsEmergencylbl.setBounds(5, 50, 75, 30);
		
		
		shirtEmergencyStatus.setForeground(Color.GREEN);
		shirtEmergencyStatus.setBounds(80, 20, 100, 30);
		pantsEmergencyStatus.setForeground(Color.GREEN);
		pantsEmergencyStatus.setBounds(80, 50, 100, 30);
		
		emergency_panel.add(shirtEmergencylbl);
		emergency_panel.add(pantsEmergencylbl);
		emergency_panel.add(shirtEmergencyStatus);
		emergency_panel.add(pantsEmergencyStatus);
		
		//---Body Temperature Status Panel & Components------------------------//
		JPanel bts = new JPanel();
		bts.setLayout(null);
		bts.setBounds(325, 5, 175, 85);
		title = BorderFactory.createTitledBorder(loweredetched, "Body Temperature Status");
		bts.setBorder(title);
		
		btsShirtlbl.setBounds(5, 20, 150, 30);
		btsPantslbl.setBounds(5, 50, 150, 30);
		
		bts.add(btsShirtlbl);
		bts.add(btsPantslbl);
		
		
//----------Temperatures---------------------//
		
		JPanel temperatures = new JPanel();
		temperatures.setLayout(null);
		temperatures.setBounds(5, 125, 500, 150);
		title = BorderFactory.createTitledBorder(loweredetched, "Temperatures");
		temperatures.setBorder(title);
		
		//----Body Temperature Panel & Components----------------//
		
		JPanel body_temp = new JPanel();
		body_temp.setLayout(null);
		body_temp.setBounds(15, 40, 125, 85);
		title = BorderFactory.createTitledBorder(loweredetched, "Body Temperature");
		body_temp.setBorder(title);
		
		bodyTempShirtlbl.setText("Shirt: ");
		bodyTempShirtlbl.setBounds(5, 20, 40, 30);
		bodyTempPantslbl.setText("Pants: ");
		bodyTempPantslbl.setBounds(5, 50, 40, 30);
		
		bodyTempShirt.setText("");
		bodyTempShirt.setBounds(40, 20, 50, 30);
		bodyTempPants.setText("");
		bodyTempPants.setBounds(45, 50, 50, 30);
		
		body_temp.add(bodyTempShirtlbl);
		body_temp.add(bodyTempPantslbl);
		body_temp.add(bodyTempShirt);
		body_temp.add(bodyTempPants);
		
		
		//----Current Temperature Panel & Components----------//
		JPanel ctc = new JPanel();
		ctc.setLayout(null);
		ctc.setBounds(200, 40, 250, 85);
		title = BorderFactory.createTitledBorder(loweredetched, "Clothing Current Temperature");
		ctc.setBorder(title);
		
		ctcShirtTempFront.setText("Shirt Front: ");
		ctcShirtTempFront.setBounds(5, 20, 150, 30);
		ctcShirtTempBack.setText("Shirt Back: ");
		ctcShirtTempBack.setBounds(125, 20, 150, 30);
		ctcPantsTempFront.setText("Pants Front: ");
		ctcPantsTempFront.setBounds(5, 50, 150, 30);
		ctcPantsTempBack.setText("Pants Back: ");
		ctcPantsTempBack.setBounds(125, 50, 150, 30);
		
		ctc.add(ctcShirtTempFront);
		ctc.add(ctcShirtTempBack);
		ctc.add(ctcPantsTempFront);
		ctc.add(ctcPantsTempBack);
		
		temperatures.add(body_temp);
		temperatures.add(ctc);
		
//--------Components Panel------------------//
		JPanel components = new JPanel();
		components.setLayout(null);
		components.setBounds(5, 310, 600, 150);
		title = BorderFactory.createTitledBorder(loweredetched, "Components");
		components.setBorder(title);		

		//----Shirt Components Panel----------//
		JPanel sc = new JPanel();
		sc.setLayout(null);
		sc.setBounds(15, 40, 250, 85);
		title = BorderFactory.createTitledBorder(loweredetched, "Shirt Components Status");
		sc.setBorder(title);
		
		scFrontHeater.setText("Front Heater: ");
		scFrontHeater.setBounds(5, 20, 150, 30);
		scFrontHeaterStatus.setText("Off");
		scFrontHeaterStatus.setBounds(85, 20, 50, 30);
		scBackHeater.setText("Back Heater: ");
		scBackHeater.setBounds(5, 50, 150, 30);
		scBackHeaterStatus.setText("Off");
		scBackHeaterStatus.setBounds(85, 50, 50, 30);
		scFrontCooler.setText("Front Cooler: ");
		scFrontCooler.setBounds(125, 20, 150, 30);
		scFrontCoolerStatus.setText("Off");
		scFrontCoolerStatus.setBounds(205, 20, 50, 30);
		scBackCooler.setText("Back Cooler: ");
		scBackCooler.setBounds(125, 50, 150, 30);
		scBackCoolerStatus.setText("Off");
		scBackCoolerStatus.setBounds(205, 50, 50, 30);
		
		sc.add(scFrontHeater);
		sc.add(scFrontHeaterStatus);
		sc.add(scBackHeater);
		sc.add(scBackHeaterStatus);
		sc.add(scFrontCooler);
		sc.add(scFrontCoolerStatus);
		sc.add(scBackCooler);
		sc.add(scBackCoolerStatus);

		//----Pants Component Panel---------//

		JPanel pc = new JPanel();
		pc.setLayout(null);
		pc.setBounds(325, 40, 250, 85);
		title = BorderFactory.createTitledBorder(loweredetched, "Pants Components Status");
		pc.setBorder(title);
		
		pcFrontHeater.setText("Front Heater: ");
		pcFrontHeater.setBounds(5, 20, 150, 30);
		pcFrontHeaterStatus.setText("Off");
		pcFrontHeaterStatus.setBounds(85, 20, 50, 30);
		pcBackHeater.setText("Back Heater: ");
		pcBackHeater.setBounds(5, 50, 150, 30);
		pcBackHeaterStatus.setText("Off");
		pcBackHeaterStatus.setBounds(85, 50, 50, 30);
		pcFrontCooler.setText("Front Cooler: ");
		pcFrontCooler.setBounds(125, 20, 150, 30);
		pcFrontCoolerStatus.setText("Off");
		pcFrontCoolerStatus.setBounds(205, 20, 50, 30);
		pcBackCooler.setText("Back Cooler: ");
		pcBackCooler.setBounds(125, 50, 150, 30);
		pcBackCoolerStatus.setText("Off");
		pcBackCoolerStatus.setBounds(205, 50, 50, 30);
		
		pc.add(pcFrontHeater);
		pc.add(pcFrontHeaterStatus);
		pc.add(pcBackHeater);
		pc.add(pcBackHeaterStatus);
		pc.add(pcFrontCooler);
		pc.add(pcFrontCoolerStatus);
		pc.add(pcBackCooler);
		pc.add(pcBackCoolerStatus);
		
		components.add(sc);
		components.add(pc);
		
		//----------------USER CONTROLS-----------------------------------//
				JPanel user_controls = new JPanel();
				user_controls.setLayout(null);
				user_controls.setBounds(5, 500, 600, 200);
				title = BorderFactory.createTitledBorder(loweredetched, "Settings");
				user_controls.setBorder(title);
				
				//---Body Temperature Controls Panel & Components-------------//
				
				JPanel btc = new JPanel();
				btc.setLayout(null);
				btc.setBounds(15, 40, 210, 125);
				title = BorderFactory.createTitledBorder(loweredetched, "Body Temperature Control");
				btc.setBorder(title);
				
				btcShirtlbl.setText("Shirt:");
				btcShirtlbl.setBounds(5, 30, 40, 30);
				btcPantslbl.setText("Pants:");
				btcPantslbl.setBounds(5, 75, 40, 30);
				
				JButton lowerBodyTempShirt = new JButton("Lower");
				lowerBodyTempShirt.setBounds(45, 30, 70, 30);
				lowerBodyTempShirt.setEnabled(false);
				JButton raiseBodyTempShirt = new JButton("Raise");
				raiseBodyTempShirt.setBounds(125, 30, 70, 30);
				raiseBodyTempShirt.setEnabled(false);
				JButton lowerBodyTempPants = new JButton("Lower");
				lowerBodyTempPants.setBounds(45, 75, 70, 30);
				lowerBodyTempPants.setEnabled(false);
				JButton raiseBodyTempPants = new JButton("Raise");
				raiseBodyTempPants.setBounds(125, 75, 70, 30);
				raiseBodyTempPants.setEnabled(false);
				
				btc.add(btcShirtlbl);
				btc.add(btcPantslbl);
				btc.add(lowerBodyTempShirt);
				btc.add(raiseBodyTempShirt);
				btc.add(lowerBodyTempPants);
				btc.add(raiseBodyTempPants);
				

				//----Desired Temperature Panel & Components----------//
				JPanel dtc = new JPanel();
				dtc.setLayout(null);
				dtc.setBounds(300, 40, 200, 125);
				title = BorderFactory.createTitledBorder(loweredetched, "Desired Temeprature Control");
				dtc.setBorder(title);
				
				dtcShirtlbl.setText("Shirt:");
				dtcShirtlbl.setBounds(5, 30, 50, 30);
				JButton shirttempdec = new JButton("\u2b9C");
				shirttempdec.setBounds(50, 35, 45, 20);
				desiredshirtTemp.setText(desiredShirtTemp + "F");
				desiredshirtTemp.setBounds(108, 30, 40, 30);
				JButton shirttempinc = new JButton("\u2b9e");
				shirttempinc.setBounds(140, 35, 45, 20);
				
				dtcPantslbl.setText("Pants:");
				dtcPantslbl.setBounds(5, 70, 50, 30);
				JButton pantstempdec = new JButton("\u2b9C");
				pantstempdec.setBounds(50, 75, 45, 20);
				desiredpantsTemp.setText(desiredPantsTemp + "F");
				desiredpantsTemp.setBounds(108, 70, 40, 30);
				JButton pantstempinc = new JButton("\u2b9e");
				pantstempinc.setBounds(140, 75, 45, 20);
				
				dtc.add(dtcShirtlbl);
				dtc.add(shirttempdec);
				dtc.add(desiredshirtTemp);
				dtc.add(shirttempinc);
				dtc.add(dtcPantslbl);
				dtc.add(pantstempdec);
				dtc.add(desiredpantsTemp);
				dtc.add(pantstempinc);
				
				user_controls.add(btc);
				user_controls.add(dtc);
		
		m_frame.add(power_panel);
		m_frame.add(emergency_panel);
		m_frame.add(bts);
		m_frame.add(temperatures);
		m_frame.add(components);
		m_frame.add(user_controls);
		m_frame.setVisible(true);
		
		on.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(running == false) {
					
					esuShirt.setDesiredTemp(desiredShirtTemp);
					esuPants.setDesiredTemp(desiredPantsTemp);
					esuShirt.start();
					esuPants.start();	
					
					shirtEmergencyStatus.setText("Normal");
					pantsEmergencyStatus.setText("Normal");
					
					btsShirtlbl.setText("Shirt Status: Idle");
					btsPantslbl.setText("Pants Status: Idle");
						
					lowerBodyTempShirt.setEnabled(true);
					raiseBodyTempShirt.setEnabled(true);
					lowerBodyTempPants.setEnabled(true);
					raiseBodyTempPants.setEnabled(true);
					
					

					running = true;
				}
			}
				
		});
		
		off.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(running != false) {
					esuShirt.setRunning(false);
					esuPants.setRunning(false);
					running = false;
					System.exit(0);
				}
			}
		});
		

		
	
		lowerBodyTempShirt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(esuShirt.getOverride() == false) {
					btsShirtlbl.setText("Shirt Status: Lowering");
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
					btsShirtlbl.setText("Shirt Status: Raising");
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
					btsPantslbl.setText("Pants Status: Lowering");
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
					btsPantslbl.setText("Pants Status: Raising");
					esuPants.raiseBodyTemp();
				} else {
					JOptionPane.showMessageDialog(m_frame, "This option is disabled until the emergency override is rescinded!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		shirttempdec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(desiredShirtTemp > 60)
				desiredShirtTemp--;	
				desiredshirtTemp.setText(desiredShirtTemp + "F");
				esuShirt.updateDesiredTemp(desiredShirtTemp);
			}
		});
	
		shirttempinc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(desiredShirtTemp < 90)
				desiredShirtTemp++;
				desiredshirtTemp.setText(desiredShirtTemp + "F");
				esuShirt.updateDesiredTemp(desiredShirtTemp);
			}
		});
	
		pantstempdec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(desiredPantsTemp > 60)
				desiredPantsTemp--;	
				desiredpantsTemp.setText(desiredPantsTemp + "F");
				esuPants.updateDesiredTemp(desiredPantsTemp);
			}
		});
	
		pantstempinc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(desiredPantsTemp < 90)
			    desiredPantsTemp++;	
				desiredpantsTemp.setText(desiredPantsTemp + "F");
				esuPants.updateDesiredTemp(desiredPantsTemp);
			}
		});
	
		
		
	}
	
	public static void setShirtBodyTemp(double body_temp) {
		bodyTempShirt.setText(String.valueOf(body_temp));
	}
	
	public static void setPantsBodyTemp(double body_temp) {
		
		bodyTempPants.setText(String.valueOf(body_temp));
	}
	
	public static void setShirtEmergencyOverride(boolean override, String type) {
		if(override == true) {
			shirtEmergencyStatus.setForeground(Color.RED);
			shirtEmergencyStatus.setText("Emergency");
			btsShirtlbl.setText("Shirt Status: Idle");
		} else {
			shirtEmergencyStatus.setForeground(Color.GREEN);
			shirtEmergencyStatus.setText("Normal");
		}
	}
	
	public static void setPantsEmergencyOverride(boolean override, String type) {
		if(override == true) {
			pantsEmergencyStatus.setForeground(Color.RED);
			pantsEmergencyStatus.setText("Emergency");
			btsPantslbl.setText("Pants Status: Idle");
		} else {
			pantsEmergencyStatus.setForeground(Color.GREEN);
			pantsEmergencyStatus.setText("Normal");
		}
	}
	public static void setCurrentShirtFrontTemp(int temp) {
		ctcShirtTempFront.setText("Shirt Front: " + temp + "F");
	}
	
	public static void setCurrentShirtBackTemp(int temp) {
		ctcShirtTempBack.setText("Shirt Back: " + temp + "F");
	}
	
	public static void setCurrentPantsFrontTemp(int temp) {
		ctcPantsTempFront.setText("Pants Front: " + temp + "F");
	}
	
	public static void setCurrentPantsBackTemp(int temp) {
		ctcPantsTempBack.setText("Pants Back: " + temp + "F");
	}
	
	public static void setShirtHeaterFront(boolean status) {
		if(status == false) {
			scFrontHeaterStatus.setForeground(Color.black);
			scFrontHeaterStatus.setText("Off");
		} else {
			scFrontHeaterStatus.setForeground(Color.GREEN);
			scFrontHeaterStatus.setText("On");
		}
	}
	
	public static void setShirtHeaterBack(boolean status) {
		if(status == false) {
			scBackHeaterStatus.setForeground(Color.black);
			scBackHeaterStatus.setText("Off");
		} else {
			scBackHeaterStatus.setForeground(Color.GREEN);
			scBackHeaterStatus.setText("On");
		}
	}
	
	public static void setShirtCoolerFront(boolean status) {
		if(status == false) {
			scFrontCoolerStatus.setForeground(Color.black);
			scFrontCoolerStatus.setText("Off");
		} else {
			scFrontCoolerStatus.setForeground(Color.GREEN);
			scFrontCoolerStatus.setText("On");
		}
	}
	
	public static void setShirtCoolerBack(boolean status) {
		if(status == false) {
			scBackCoolerStatus.setForeground(Color.black);
			scBackCoolerStatus.setText("Off");
		} else {
			scBackCoolerStatus.setForeground(Color.GREEN);
			scBackCoolerStatus.setText("On");
		}
	}
	
	public static void setPantsHeaterFront(boolean status) {
		if(status == false) {
			pcFrontHeaterStatus.setForeground(Color.black);
			pcFrontHeaterStatus.setText("Off");
		} else {
			pcFrontHeaterStatus.setForeground(Color.GREEN);
			pcFrontHeaterStatus.setText("On");
		}
	}
	
	public static void setPantsHeaterBack(boolean status) {
		if(status == false) {
			pcBackHeaterStatus.setForeground(Color.black);
			pcBackHeaterStatus.setText("Off");
		} else {
			pcBackHeaterStatus.setForeground(Color.GREEN);
			pcBackHeaterStatus.setText("On");
		}
	}
	
	public static void setPantsCoolerFront(boolean status) {
		if(status == false) {
			pcFrontCoolerStatus.setForeground(Color.black);
			pcFrontCoolerStatus.setText("Off");
		} else {
			pcFrontCoolerStatus.setForeground(Color.GREEN);
			pcFrontCoolerStatus.setText("On");
		}
	}
	
	public static void setPantsCoolerBack(boolean status) {
		if(status == false) {
			pcBackCoolerStatus.setForeground(Color.black);
			pcBackCoolerStatus.setText("Off");
		} else {
			pcBackCoolerStatus.setForeground(Color.GREEN);
			pcBackCoolerStatus.setText("On");
		}
	}
	
}
