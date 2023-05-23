package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndScreen {

	private JFrame frmEnd;
	private GameEnviroment enviroment;
	private JTextField textName;
	private JTextField textMoney;
	private JTextField textGameOver;
	private JTextField textScore;

	
	public EndScreen(GameEnviroment incomingEnviroment) throws InvalidObjectAttributeType {
		enviroment = incomingEnviroment;
		initialize();
		frmEnd.setVisible(true);
	}
	
	public void closeWindow() {
		frmEnd.dispose();
	}
	
	public void finishedWindow() {
		 enviroment.closeEndScreen(this);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndScreen window = new EndScreen();
					window.frmEnd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EndScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnd = new JFrame();
		frmEnd.setTitle("End");
		frmEnd.setBounds(100, 100, 685, 488);
		frmEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnd.getContentPane().setLayout(null);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setText("" + enviroment.getPlayerTeam().getName());
		textName.setEditable(false);
		textName.setBounds(10, 11, 86, 20);
		frmEnd.getContentPane().add(textName);
		textName.setColumns(10);
		
		textMoney = new JTextField();
		textMoney.setHorizontalAlignment(SwingConstants.CENTER);
		textMoney.setText("" + enviroment.getPlayerTeam().getTotalFunds());
		textMoney.setEditable(false);
		textMoney.setBounds(573, 11, 86, 20);
		frmEnd.getContentPane().add(textMoney);
		textMoney.setColumns(10);
		
		textGameOver = new JTextField();
		textGameOver.setEditable(false);
		textGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		textGameOver.setText("Game Over");
		textGameOver.setBounds(220, 11, 212, 63);
		frmEnd.getContentPane().add(textGameOver);
		textGameOver.setColumns(10);
		
		textScore = new JTextField();
		textScore.setEditable(false);
		textScore.setHorizontalAlignment(SwingConstants.CENTER);
		textScore.setText("Final Score: " + enviroment.getPlayerTeam().getScore());
		textScore.setBounds(220, 163, 212, 57);
		frmEnd.getContentPane().add(textScore);
		textScore.setColumns(10);
		
		JButton btnEndGame = new JButton("Done");
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnEndGame.setBounds(220, 365, 212, 42);
		frmEnd.getContentPane().add(btnEndGame);
	}
}
