package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemStoreScreen implements MouseListener{

	private JFrame frmItemStore;
	private GameEnviroment enviroment;
	private JTextField txtMoney;
	private final Action Back = new SwingAction();
	private JTextField txtName;
	private JTextField textItemDescription;
	
	private int index = 0;
	
	public ItemStoreScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmItemStore.setVisible(true);
	}
	
	public void closeWindow() {
		frmItemStore.dispose();
	}
	public void finishedWindow() {
		enviroment.closeItemStoreScreen(this);
	}
	
	public void refreshWindow() {
		frmItemStore.dispose();
		enviroment.launchItemStoreScreen();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemStoreScreen window = new ItemStoreScreen();
					window.frmItemStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ItemStoreScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmItemStore = new JFrame();
		frmItemStore.setTitle("Store");
		frmItemStore.setBounds(100, 100, 685, 488);
		frmItemStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmItemStore.getContentPane().setLayout(null);
		
		txtMoney = new JTextField();
		txtMoney.setBounds(573, 11, 86, 20);
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		frmItemStore.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(570, 415, 89, 23);
		btnBack.setAction(Back);
		frmItemStore.getContentPane().add(btnBack);
		
		txtName = new JTextField();
		txtName.setBounds(10, 11, 86, 20);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText(""+enviroment.getPlayerTeam().getName());
		txtName.setEditable(false);
		frmItemStore.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		textItemDescription = new JTextField();
		textItemDescription.setHorizontalAlignment(SwingConstants.CENTER);
		textItemDescription.setBounds(259, 97, 115, 49);
		frmItemStore.getContentPane().add(textItemDescription);
		textItemDescription.setColumns(10);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuy.setBounds(259, 208, 115, 63);
		frmItemStore.getContentPane().add(btnBuy);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
