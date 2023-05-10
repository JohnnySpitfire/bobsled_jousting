package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class MainMenuScreen {

	private JFrame frmMainmenu;
	private BaseTeam team;
	
	public MainMenuScreen(BaseTeam incomingTeam) {
		team = incomingTeam;
		initialize();
	}
	
	public void closeWindow() {
		frmMainmenu.dispose();
	}
	public void finishedWindow() {
		team.closeMainScreen(this);
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
		frmMainmenu.setBounds(100, 100, 450, 300);
		frmMainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainmenu.getContentPane().setLayout(null);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(165, 210, 89, 23);
		frmMainmenu.getContentPane().add(btnQuit);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setBounds(57, 116, 89, 23);
		frmMainmenu.getContentPane().add(btnInventory);
		
		JButton btnStore = new JButton("Store");
		btnStore.setBounds(279, 116, 89, 23);
		frmMainmenu.getContentPane().add(btnStore);
		
		JButton btnClub = new JButton("Club");
		btnClub.setBounds(165, 55, 89, 23);
		frmMainmenu.getContentPane().add(btnClub);
	}

}
