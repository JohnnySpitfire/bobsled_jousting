package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SledStoreScreen {

	private JFrame frmSledStore;
	private GameEnviroment enviroment;
	private JTextField txtMoney;
	private final Action Back = new SwingAction();
	private JTextField txtName;
	
	public SledStoreScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmSledStore.setVisible(true);
	}
	
	public void closeWindow() {
		frmSledStore.dispose();
	}
	public void finishedWindow() {
		enviroment.closeSledStoreScreen(this);
	}
	
	public void refreshWindow() {
		frmSledStore.dispose();
		enviroment.launchSledStoreScreen();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SledStoreScreen window = new SledStoreScreen();
					window.frmSledStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SledStoreScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSledStore = new JFrame();
		frmSledStore.setTitle("Store");
		frmSledStore.setBounds(100, 100, 685, 488);
		frmSledStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSledStore.getContentPane().setLayout(null);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		txtMoney.setBounds(573, 11, 86, 20);
		frmSledStore.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(Back);
		btnBack.setBounds(570, 415, 89, 23);
		frmSledStore.getContentPane().add(btnBack);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText(""+enviroment.getPlayerTeam().getName());
		txtName.setEditable(false);
		txtName.setBounds(10, 11, 86, 20);
		frmSledStore.getContentPane().add(txtName);
		txtName.setColumns(10);
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
