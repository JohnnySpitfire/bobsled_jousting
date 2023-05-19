package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class InventoryScreen {

	private JFrame frmInventory;
	private final Action Back = new SwingAction();
	private GameEnviroment enviroment;
	private JTextField textName;
	private JTextField txtMoney;
	private JTextField textSled;
	private JTextField txtSledName;
	private JTextField textRam;
	private JTextField txtArmour;
	private JTextField txtSpeed;
	private JTextField txtModifiers;
	private JTextField txtCost;

	
	public InventoryScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmInventory.setVisible(true);
	}
	
	public void closeWindow() {
		frmInventory.dispose();
	}
	public void finishedWindow() {
		enviroment.closeInventoryScreen(this);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen window = new InventoryScreen();
					window.frmInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventoryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventory = new JFrame();
		frmInventory.setTitle("Inventory");
		frmInventory.setBounds(100, 100, 685, 488);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setAction(Back);
		btnNewButton.setBounds(570, 415, 89, 23);
		frmInventory.getContentPane().add(btnNewButton);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setText(""+enviroment.getPlayerTeam().getName());
		textName.setEditable(false);
		textName.setBounds(10, 11, 86, 20);
		frmInventory.getContentPane().add(textName);
		textName.setColumns(10);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		txtMoney.setBounds(573, 11, 86, 20);
		frmInventory.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		textSled = new JTextField();
		textSled.setEditable(false);
		textSled.setHorizontalAlignment(SwingConstants.CENTER);
		textSled.setText("Sled");
		textSled.setBounds(92, 59, 86, 20);
		frmInventory.getContentPane().add(textSled);
		textSled.setColumns(10);
		
		JPanel panelSled = new JPanel();
		panelSled.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSled.setBounds(43, 91, 191, 302);
		frmInventory.getContentPane().add(panelSled);
		panelSled.setLayout(null);
		
		txtSledName = new JTextField();
		txtSledName.setEditable(false);
		txtSledName.setText(""+enviroment.getPlayerTeam().getSled().getName());
		txtSledName.setHorizontalAlignment(SwingConstants.CENTER);
		txtSledName.setBounds(10, 11, 171, 27);
		panelSled.add(txtSledName);
		txtSledName.setColumns(10);
		
		textRam = new JTextField();
		textRam.setEditable(false);
		textRam.setText("Ram:"+enviroment.getPlayerTeam().getSled().getRam());
		textRam.setHorizontalAlignment(SwingConstants.CENTER);
		textRam.setColumns(10);
		textRam.setBounds(10, 112, 171, 27);
		panelSled.add(textRam);
		
		txtArmour = new JTextField();
		txtArmour.setEditable(false);
		txtArmour.setText("Armour:"+enviroment.getPlayerTeam().getSled().getAttributes(SledAttribute.ARMOUR));
		txtArmour.setHorizontalAlignment(SwingConstants.CENTER);
		txtArmour.setColumns(10);
		txtArmour.setBounds(10, 150, 171, 27);
		panelSled.add(txtArmour);
		
		txtSpeed = new JTextField();
		txtSpeed.setEditable(false);
		txtSpeed.setText("Speed:"+enviroment.getPlayerTeam().getSled().getAttributes(SledAttribute.SPEED));
		txtSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		txtSpeed.setColumns(10);
		txtSpeed.setBounds(10, 188, 171, 27);
		panelSled.add(txtSpeed);
		
		txtModifiers = new JTextField();
		txtModifiers.setEditable(false);
		txtModifiers.setText("Modifiers:"+enviroment.getPlayerTeam().getSled().getModifiers());
		txtModifiers.setHorizontalAlignment(SwingConstants.CENTER);
		txtModifiers.setColumns(10);
		txtModifiers.setBounds(10, 226, 171, 27);
		panelSled.add(txtModifiers);
		
		txtCost = new JTextField();
		txtCost.setEditable(false);
		txtCost.setText("Cost:"+enviroment.getPlayerTeam().getSled().getValue());
		txtCost.setHorizontalAlignment(SwingConstants.CENTER);
		txtCost.setColumns(10);
		txtCost.setBounds(10, 264, 171, 27);
		panelSled.add(txtCost);
		
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			finishedWindow();
		}
	}
	
}

