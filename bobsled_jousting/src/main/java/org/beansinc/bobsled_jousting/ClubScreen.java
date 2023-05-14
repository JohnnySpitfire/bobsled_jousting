package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.SwingConstants;

public class ClubScreen {

	private JFrame frmClub;
	private JTextField textName;
	private BaseTeam team;
	private final Action Back = new SwingAction();
	private JTextField textMoney;

	
	public ClubScreen(BaseTeam incomingTeam) {
		team = incomingTeam;
		initialize();
		frmClub.setVisible(true);
	}
	
	public void closeWindow() {
		frmClub.dispose();
	}
	public void finishedWindow() {
		team.closeClubScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubScreen window = new ClubScreen();
					window.frmClub.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClubScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClub = new JFrame();
		frmClub.setTitle("Club");
		frmClub.setBounds(100, 100, 685, 488);
		frmClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClub.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(Back);
		btnBack.setBounds(570, 415, 89, 23);
		frmClub.getContentPane().add(btnBack);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setText(team.getName());
		textName.setEditable(false);
		textName.setBounds(10, 11, 86, 20);
		frmClub.getContentPane().add(textName);
		textName.setColumns(10);
		
		textMoney = new JTextField();
		textMoney.setHorizontalAlignment(SwingConstants.CENTER);
		textMoney.setEditable(false);
		textMoney.setText(Integer.toString(team.getMoney()));
		textMoney.setBounds(573, 11, 86, 20);
		frmClub.getContentPane().add(textMoney);
		textMoney.setColumns(10);
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
