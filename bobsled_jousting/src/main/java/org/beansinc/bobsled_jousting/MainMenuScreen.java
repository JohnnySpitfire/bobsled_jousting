package org.beansinc.bobsled_jousting;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JTree;
import javax.swing.SwingConstants;

public class MainMenuScreen {

	private JFrame frmMainmenu;
	private GameEnviroment enviroment;
	private JTextField txtName;
	private JTextField textMoney;
	private final Action Inventory = new SwingAction();
	private final Action Club = new SwingAction_1();
	private final Action Store = new SwingAction_2();
	private final Action Quit = new SwingAction_3();
	
	public MainMenuScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmMainmenu.setVisible(true);
	}
	
	public void closeWindow() {
		frmMainmenu.dispose();
	}
	public void finishedWindow() {
		enviroment.closeMainMenuScreen(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuScreen window = new MainMenuScreen();
					window.frmMainmenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainmenu = new JFrame();
		frmMainmenu.setTitle("MainMenu");
		frmMainmenu.setBounds(100, 100, 685, 488);
		frmMainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainmenu.getContentPane().setLayout(null);
		
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setAction(Quit);
		btnQuit.setBounds(570, 415, 89, 23);
		frmMainmenu.getContentPane().add(btnQuit);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setAction(Inventory);
		btnInventory.setBounds(10, 415, 89, 23);
		frmMainmenu.getContentPane().add(btnInventory);
		
		JButton btnStore = new JButton("Store");
		btnStore.setAction(Store);
		btnStore.setBounds(391, 415, 89, 23);
		frmMainmenu.getContentPane().add(btnStore);
		
		JButton btnClub = new JButton("Club");
		btnClub.setAction(Club);
		btnClub.setBounds(175, 415, 89, 23);
		frmMainmenu.getContentPane().add(btnClub);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText(""+enviroment.getPlayerTeam().getName());
		txtName.setEditable(false);
		txtName.setBounds(10, 11, 86, 20);
		frmMainmenu.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		textMoney = new JTextField();
		textMoney.setHorizontalAlignment(SwingConstants.CENTER);
		textMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		textMoney.setEditable(false);
		textMoney.setBounds(573, 11, 86, 20);
		frmMainmenu.getContentPane().add(textMoney);
		textMoney.setColumns(10);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Inventory");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			enviroment.launchInventoryScreen();
			finishedWindow();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Club");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			enviroment.launchClubScreen();
			finishedWindow();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Store");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			enviroment.launchStoreScreen();
			finishedWindow();
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Quit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			finishedWindow();
		}
	}
}
