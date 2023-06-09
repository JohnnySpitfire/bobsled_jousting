package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

/**
 * The Class StoreScreen.
 */
public class StoreScreen {

	/** The frm store. */
	private JFrame frmStore;
	
	/** The enviroment. */
	private GameEnviroment enviroment;
	
	/** The txt money. */
	private JTextField txtMoney;
	
	/** The Back. */
	private final Action Back = new SwingAction();
	
	/** The txt name. */
	private JTextField txtName;
	
	/** The btn sled. */
	private JButton btnSled;
	
	/** The btn items. */
	private JButton btnItems;
	
	/**
	 * Instantiates a new store screen.
	 *
	 * @param incomingEnviroment the incoming enviroment
	 */
	public StoreScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmStore.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frmStore.dispose();
	}
	
	/**
	 * Finished window.
	 */
	public void finishedWindow() {
		enviroment.closeStoreScreen(this);
	}
	
	/**
	 * Refresh window.
	 */
	public void refreshWindow() {
		frmStore.dispose();
		enviroment.launchStoreScreen();
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
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		txtMoney.setBounds(573, 11, 86, 20);
		frmStore.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(Back);
		btnBack.setBounds(570, 415, 89, 23);
		frmStore.getContentPane().add(btnBack);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText(""+enviroment.getPlayerTeam().getName());
		txtName.setEditable(false);
		txtName.setBounds(10, 11, 86, 20);
		frmStore.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		btnSled = new JButton("Sled");
		btnSled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviroment.launchSledStoreScreen();
				closeWindow();
			}
		});
		btnSled.setBounds(227, 42, 213, 367);
		frmStore.getContentPane().add(btnSled);
		
		btnItems = new JButton("Items");
		btnItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviroment.launchItemStoreScreen();
				closeWindow();
			}
		});
		btnItems.setBounds(10, 42, 213, 367);
		frmStore.getContentPane().add(btnItems);
		
		JButton btnPlayers = new JButton("Players");
		btnPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviroment.launchPlayerStoreScreen();
				closeWindow();
			}
		});
		btnPlayers.setBounds(446, 42, 213, 367);
		frmStore.getContentPane().add(btnPlayers);
	}

	/**
	 * The Class SwingAction.
	 */
	private class SwingAction extends AbstractAction {
		
		/**
		 * Instantiates a new swing action.
		 */
		public SwingAction() {
			putValue(NAME, "Back");
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
