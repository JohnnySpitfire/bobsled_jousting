package org.beansinc.bobsled_jousting;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class MainMenuScreen.
 */
public class MainMenuScreen {

	/** The frm mainmenu. */
	private JFrame frmMainmenu;
	
	/** The enviroment. */
	private GameEnviroment enviroment;
	
	/** The txt name. */
	private JTextField txtName;
	
	/** The text money. */
	private JTextField textMoney;
	
	/** The Inventory. */
	private final Action Inventory = new SwingAction();
	
	/** The Club. */
	private final Action Club = new SwingAction_1();
	
	/** The Store. */
	private final Action Store = new SwingAction_2();
	
	/** The Quit. */
	private final Action Quit = new SwingAction_3();
	
	/** The txt week. */
	private JTextField txtWeek;
	
	/** The txt weeks remaining. */
	private JTextField txtWeeksRemaining;
	
	/** The btn stadium. */
	private JButton btnStadium;
	
	/**
	 * Instantiates a new main menu screen.
	 *
	 * @param incomingEnviroment the incoming enviroment
	 */
	public MainMenuScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmMainmenu.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frmMainmenu.dispose();
	}
	
	/**
	 * Finished window.
	 */
	public void finishedWindow() {
		enviroment.closeMainMenuScreen(this);
	}

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
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
		
		txtWeek = new JTextField();
		txtWeek.setEditable(false);
		txtWeek.setHorizontalAlignment(SwingConstants.CENTER);
		txtWeek.setText("Week:"+enviroment.getCurrentWeek());
		txtWeek.setBounds(175, 11, 109, 20);
		frmMainmenu.getContentPane().add(txtWeek);
		txtWeek.setColumns(10);
		
		txtWeeksRemaining = new JTextField();
		txtWeeksRemaining.setEditable(false);
		txtWeeksRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		txtWeeksRemaining.setText("Weeks Remaining:"+(enviroment.getTotalWeeks() - enviroment.getCurrentWeek()));
		txtWeeksRemaining.setBounds(362, 11, 130, 20);
		frmMainmenu.getContentPane().add(txtWeeksRemaining);
		txtWeeksRemaining.setColumns(10);
		
		btnStadium = new JButton("Stadium");
		btnStadium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				enviroment.launchStadiumScreen();
			}
		});
		btnStadium.setBounds(234, 186, 170, 78);
		frmMainmenu.getContentPane().add(btnStadium);
	}
	
	/**
	 * The Class SwingAction.
	 */
	private class SwingAction extends AbstractAction {
		
		/**
		 * Instantiates a new swing action.
		 */
		public SwingAction() {
			putValue(NAME, "Inventory");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			enviroment.launchInventoryScreen();
			finishedWindow();
		}
	}
	
	/**
	 * The Class SwingAction_1.
	 */
	private class SwingAction_1 extends AbstractAction {
		
		/**
		 * Instantiates a new swing action 1.
		 */
		public SwingAction_1() {
			putValue(NAME, "Club");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			enviroment.launchClubScreen();
			finishedWindow();
		}
	}
	
	/**
	 * The Class SwingAction_2.
	 */
	private class SwingAction_2 extends AbstractAction {
		
		/**
		 * Instantiates a new swing action 2.
		 */
		public SwingAction_2() {
			putValue(NAME, "Store");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			enviroment.launchStoreScreen();
			finishedWindow();
		}
	}
	
	/**
	 * The Class SwingAction_3.
	 */
	private class SwingAction_3 extends AbstractAction {
		
		/**
		 * Instantiates a new swing action 3.
		 */
		public SwingAction_3() {
			putValue(NAME, "Quit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			finishedWindow();
		}
	}
}
