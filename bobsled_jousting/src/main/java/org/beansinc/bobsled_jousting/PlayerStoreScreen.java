package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;


public class PlayerStoreScreen {

	private JFrame frmPlayerStore;
	private GameEnviroment enviroment;
	private JTextField txtMoney;
	private final Action Back = new SwingAction();
	private JTextField txtName;
	
	private int contestantIndex = 0;
	
	public PlayerStoreScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmPlayerStore.setVisible(true);
	}
	
	public void closeWindow() {
		frmPlayerStore.dispose();
	}
	public void finishedWindow() {
		enviroment.closePlayerStoreScreen(this);
	}
	
	public void refreshWindow() {
		frmPlayerStore.dispose();
		enviroment.launchPlayerStoreScreen();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerStoreScreen window = new PlayerStoreScreen();
					window.frmPlayerStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerStoreScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerStore = new JFrame();
		frmPlayerStore.setTitle("Store");
		frmPlayerStore.setBounds(100, 100, 685, 488);
		frmPlayerStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerStore.getContentPane().setLayout(null);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		txtMoney.setBounds(573, 11, 86, 20);
		frmPlayerStore.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(Back);
		btnBack.setBounds(570, 415, 89, 23);
		frmPlayerStore.getContentPane().add(btnBack);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText(""+enviroment.getPlayerTeam().getName());
		txtName.setEditable(false);
		txtName.setBounds(10, 11, 86, 20);
		frmPlayerStore.getContentPane().add(txtName);
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
