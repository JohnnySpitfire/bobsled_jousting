package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemStoreScreen implements MouseListener{

	private JFrame frmItemStore;
	private GameEnviroment enviroment;
	private JTextField txtMoney;
	private final Action Back = new SwingAction();
	private JTextField txtName;
	private JTextField textItemName;
	
	private int itemIndex = 0;
	
	
	private int index = 0;
	private JButton btnLeft;
	private JButton btnRight;
	private JTextField textPrice;
	private JTextField textInformation;
	
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
		
		textItemName = new JTextField();
		textItemName.setEditable(false);
		textItemName.setHorizontalAlignment(SwingConstants.CENTER);
		textItemName.setBounds(259, 97, 115, 49);
		frmItemStore.getContentPane().add(textItemName);
		textItemName.setColumns(10);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addMouseListener(this);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (enviroment.getPlayerTeam().getTotalFunds() >= enviroment.getMarket().getItemSaleArray().get(itemIndex).value) {
						enviroment.getMarket().buyAsset(enviroment.getPlayerTeam(), enviroment.getMarket().getItemSaleArray().get(itemIndex));
						if (itemIndex == enviroment.getMarket().getItemSaleArray().size() && enviroment.getMarket().getItemSaleArray().size() != 0) {
							itemIndex -= 1;
						}
						
					}
					
					
				} catch (InvalidTeamSize e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuy.setBounds(271, 375, 115, 63);
		frmItemStore.getContentPane().add(btnBuy);
		
		btnLeft = new JButton("<==");
		btnLeft.addMouseListener(this);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemIndex == 0 && 0 != (enviroment.getMarket().getItemSaleArray().size())) {
					itemIndex = enviroment.getMarket().getItemSaleArray().size() - 1;
				}
				else if (0 != (enviroment.getMarket().getItemSaleArray().size())) {
					itemIndex -= 1;
				}
			}
		});
		btnLeft.setBounds(216, 234, 60, 23);
		frmItemStore.getContentPane().add(btnLeft);
		
		btnRight = new JButton("==>");
		btnRight.addMouseListener(this);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemIndex == (enviroment.getMarket().getItemSaleArray().size() - 1)) {
					itemIndex = 0;
				}
				else if (0 != (enviroment.getMarket().getItemSaleArray().size())){
					itemIndex += 1;
				}
			}
		});
		btnRight.setBounds(364, 234, 60, 23);
		frmItemStore.getContentPane().add(btnRight);
		
		textPrice = new JTextField();
		textPrice.setEditable(false);
		textPrice.setHorizontalAlignment(SwingConstants.CENTER);
		textPrice.setBounds(269, 154, 86, 20);
		frmItemStore.getContentPane().add(textPrice);
		textPrice.setColumns(10);
		
		textInformation = new JTextField();
		textInformation.setHorizontalAlignment(SwingConstants.CENTER);
		textInformation.setEditable(false);
		textInformation.setBounds(112, 185, 398, 30);
		frmItemStore.getContentPane().add(textInformation);
		textInformation.setColumns(10);
		
		if (enviroment.getMarket().getItemSaleArray().size() > 0) {
			textItemName.setText(""+enviroment.getMarket().getItemSaleArray().get(itemIndex));
			textPrice.setText(""+enviroment.getMarket().getItemSaleArray().get(itemIndex).value);
			textInformation.setText(""+enviroment.getMarket().getItemSaleArray().get(itemIndex).description);
		}
		
		if (enviroment.getMarket().getItemSaleArray().size() == 0) {
			textItemName.setText("No More Items");
			textPrice.setText("");
			textInformation.setText("");
		}
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
		if (enviroment.getMarket().getItemSaleArray().size() > 0) {
			textItemName.setText(""+enviroment.getMarket().getItemSaleArray().get(itemIndex));
			textPrice.setText(""+enviroment.getMarket().getItemSaleArray().get(itemIndex).value);
			textInformation.setText(""+enviroment.getMarket().getItemSaleArray().get(itemIndex).description);
		}
		
		if (enviroment.getMarket().getItemSaleArray().size() == 0) {
			textItemName.setText("No More Items");
			textPrice.setText("");
			textInformation.setText("");
		}
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
