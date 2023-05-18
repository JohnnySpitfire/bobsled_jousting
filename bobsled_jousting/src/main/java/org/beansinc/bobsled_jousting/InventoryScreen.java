package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InventoryScreen {

	private JFrame frmInventory;
	private final Action Back = new SwingAction();
	private BaseTeam team;
	private JTextField textName;
	private JTextField txtMoney;

	
	public InventoryScreen(BaseTeam incomingTeam) {
		team = incomingTeam;
		initialize();
		frmInventory.setVisible(true);
	}
	
	public void closeWindow() {
		frmInventory.dispose();
	}
	public void finishedWindow() {
		team.closeInventoryScreen(this);
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
		textName.setText(team.getName());
		textName.setEditable(false);
		textName.setBounds(10, 11, 86, 20);
		frmInventory.getContentPane().add(textName);
		textName.setColumns(10);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setText(Integer.toString(team.getMoney()));
		txtMoney.setBounds(573, 11, 86, 20);
		frmInventory.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		
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
