package org.beansinc.bobsled_jousting;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JTextField;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingConstants;
import javax.swing.JSlider;

/**
 * The Class SetupScreen.
 */
public class SetupScreen implements ChangeListener{

	/** The frm setupscreen. */
	private JFrame frmSetupscreen;
	
	/** The enviroment. */
	private GameEnviroment enviroment;
	
	/** The dif. */
	private int dif;
	
	/** The team name. */
	private String teamName;
	
	/** The weeks. */
	private int weeks;
	
	/** The Team name. */
	//private final Action Accept = new SwingAction();
	private JTextField TeamName;
	
	/** The setup contestants. */
	private ArrayList<Contestant> setupContestants;
	
	/** The text difficulty. */

	private JTextField textDifficulty;
	
	/** The text num weeks. */
	private JTextField textNumWeeks;
	
	/** The difficulty. */
	private JSlider difficulty;
	
	/** The num weeks. */
	private JSlider numWeeks;
	
	/** The Accept. */
	private final Action Accept = new SwingAction();
	private JTextField textDifficultyInfo;
	private JTextField textWeekInfo;
	private JTextField textNameInfo;
	private JTextField textNameInfo2;
	
	
	/**
	 * Instantiates a new setup screen.
	 *
	 * @param incomingEnviroment the incoming enviroment
	 */
	public SetupScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmSetupscreen.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frmSetupscreen.dispose();
	}
	/*public void finishedWindow() {
		team.closeSetupScreen(this);
	}*/

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
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
		frmSetupscreen.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetupscreen = new JFrame();
		frmSetupscreen.setTitle("SetupScreen");
		frmSetupscreen.setBounds(100, 100, 685, 488);
		frmSetupscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupscreen.getContentPane().setLayout(null);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setAction(Accept);
		//btnAccept.setAction(Accept);
		btnAccept.setBounds(251, 389, 129, 49);
		frmSetupscreen.getContentPane().add(btnAccept);
		
		TeamName = new JTextField();
		TeamName.setHorizontalAlignment(SwingConstants.CENTER);
		TeamName.setBounds(277, 55, 86, 20);
		frmSetupscreen.getContentPane().add(TeamName);
		TeamName.setColumns(10);
		
		difficulty = new JSlider();
		
		difficulty.setMinimum(1);
		difficulty.setMinorTickSpacing(1);
		difficulty.setBounds(392, 208, 200, 49);
		frmSetupscreen.getContentPane().add(difficulty);
		
		textDifficulty = new JTextField();
		textDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		textDifficulty.setText(Integer.toString(difficulty.getValue()));
		textDifficulty.setEditable(false);
		textDifficulty.setBounds(456, 268, 86, 20);
		frmSetupscreen.getContentPane().add(textDifficulty);
		textDifficulty.setColumns(10);
		
		numWeeks = new JSlider();
		numWeeks.setValue(1);
		numWeeks.setSnapToTicks(true);
		numWeeks.setMinorTickSpacing(1);
		numWeeks.setMinimum(7);
		numWeeks.setMaximum(14);
		numWeeks.setBounds(56, 215, 200, 26);
		frmSetupscreen.getContentPane().add(numWeeks);
		
		textNumWeeks = new JTextField();
		textNumWeeks.setText(Integer.toString(numWeeks.getValue()));
		textNumWeeks.setEditable(false);
		textNumWeeks.setBounds(128, 252, 86, 20);
		frmSetupscreen.getContentPane().add(textNumWeeks);
		textNumWeeks.setColumns(10);
		
		textDifficultyInfo = new JTextField();
		textDifficultyInfo.setText("Select Difficulty: 1-100");
		textDifficultyInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textDifficultyInfo.setEditable(false);
		textDifficultyInfo.setBounds(395, 181, 197, 23);
		frmSetupscreen.getContentPane().add(textDifficultyInfo);
		textDifficultyInfo.setColumns(10);
		
		textWeekInfo = new JTextField();
		textWeekInfo.setText("Select Season Weeks: 7-14");
		textWeekInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textWeekInfo.setEditable(false);
		textWeekInfo.setColumns(10);
		textWeekInfo.setBounds(53, 181, 197, 23);
		frmSetupscreen.getContentPane().add(textWeekInfo);
		
		textNameInfo = new JTextField();
		textNameInfo.setHorizontalAlignment(SwingConstants.CENTER);
		textNameInfo.setText("Enter A Team Name");
		textNameInfo.setEditable(false);
		textNameInfo.setBounds(237, 11, 159, 20);
		frmSetupscreen.getContentPane().add(textNameInfo);
		textNameInfo.setColumns(10);
		
		textNameInfo2 = new JTextField();
		textNameInfo2.setText("No Special Characters");
		textNameInfo2.setHorizontalAlignment(SwingConstants.CENTER);
		textNameInfo2.setEditable(false);
		textNameInfo2.setColumns(10);
		textNameInfo2.setBounds(237, 31, 159, 20);
		frmSetupscreen.getContentPane().add(textNameInfo2);
		
		difficulty.addChangeListener((ChangeListener) this);
		numWeeks.addChangeListener((ChangeListener) this);
	}
	
	/**
	 *  
	 *
	 * @param e the e
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		textNumWeeks.setText(Integer.toString(numWeeks.getValue()));
		textDifficulty.setText(Integer.toString(difficulty.getValue()));
	}
	
	/**
	 * Finished window.
	 *
	 * @throws InvalidObjectAttributeType the invalid object attribute type
	 */
	public void finishedWindow() throws InvalidObjectAttributeType {
		 enviroment.closeSetupScreen(this);
		
	}

	/**
	 * Gets the game enviroment.
	 *
	 * @return the game enviroment
	 */
	public GameEnviroment getGameEnviroment() {
		return enviroment;
	}
	
	/**
	 * The Class SwingAction.
	 */
	private class SwingAction extends AbstractAction {
		
		/**
		 * Instantiates a new swing action.
		 */
		public SwingAction() {
			putValue(NAME, "Accept");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			String name = TeamName.getText();
			if (name.matches("[a-zA-Z]+")) {
					teamName = name;
					weeks = numWeeks.getValue();
					dif = difficulty.getValue();
					try {
						enviroment = new GameEnviroment(teamName, weeks, dif);
					} catch (InvalidObjectAttributeType e2) {
						e2.printStackTrace();
					}
					try {
						finishedWindow();
					} catch (InvalidObjectAttributeType e1) {
						e1.printStackTrace();
					}
			}
			
		}
	}
}
