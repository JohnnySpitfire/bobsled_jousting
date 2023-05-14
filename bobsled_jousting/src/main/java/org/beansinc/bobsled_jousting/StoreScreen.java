package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class StoreScreen {

	private JFrame frmStore;
	private BaseTeam team;
	private JTextField txtMoney;
	private final Action Back = new SwingAction();
	private JTextField txtName;
	private JButton btnDown;
	private final Action Down = new SwingAction_1();
	private JButton btnUp;
	private final Action Up = new SwingAction_2();
	
	public StoreScreen(BaseTeam incomingTeam) {
		team = incomingTeam;
		initialize();
		frmStore.setVisible(true);
	}
	
	public void closeWindow() {
		frmStore.dispose();
	}
	public void finishedWindow() {
		team.closeStoreScreen(this);
	}
	
	public void refreshWindow() {
		frmStore.dispose();
		team.launchStoreScreen();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreScreen window = new StoreScreen();
					window.frmStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStore = new JFrame();
		frmStore.setTitle("Store");
		frmStore.setBounds(100, 100, 685, 488);
		frmStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStore.getContentPane().setLayout(null);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setText(Integer.toString(team.getMoney()));
		txtMoney.setBounds(573, 11, 86, 20);
		frmStore.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(Back);
		btnBack.setBounds(570, 415, 89, 23);
		frmStore.getContentPane().add(btnBack);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText(team.getName());
		txtName.setEditable(false);
		txtName.setBounds(10, 11, 86, 20);
		frmStore.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		btnDown = new JButton("Down");
		btnDown.setAction(Down);
		btnDown.setBounds(225, 271, 213, 117);
		frmStore.getContentPane().add(btnDown);
		
		btnUp = new JButton("Up");
		btnUp.setAction(Up);
		btnUp.setBounds(225, 106, 213, 126);
		frmStore.getContentPane().add(btnUp);
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
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Down");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			team.alterMoney(-100);
			refreshWindow();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Up");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			team.alterMoney(100);
			refreshWindow();
		}
	}
}
