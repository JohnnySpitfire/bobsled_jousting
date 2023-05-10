package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class SetupScreen {

	private JFrame frmSetupscreen;
	private BaseTeam team;
	
	public void closeWindow() {
		frmSetupscreen.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frmSetupscreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetupscreen = new JFrame();
		frmSetupscreen.setTitle("SetupScreen");
		frmSetupscreen.setBounds(100, 100, 450, 300);
		frmSetupscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupscreen.getContentPane().setLayout(null);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(169, 227, 89, 23);
		frmSetupscreen.getContentPane().add(btnAccept);
	}
}
