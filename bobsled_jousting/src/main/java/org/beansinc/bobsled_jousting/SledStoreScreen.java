package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

import java.awt.Color;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * The Class SledStoreScreen.
 */
public class SledStoreScreen implements MouseListener{

	/** The frm sled store. */
	private JFrame frmSledStore;
	
	/** The enviroment. */
	private GameEnviroment enviroment;
	
	/** The txt money. */
	private JTextField txtMoney;
	
	/** The Back. */
	private final Action Back = new SwingAction();
	
	/** The txt name. */
	private JTextField txtName;
	
	/** The text your sled. */
	private JTextField textYourSled;
	
	/** The panel sled. */
	private JPanel panelSled;
	
	/** The text armour curr. */
	private JTextField textArmourCurr;
	
	/** The text speed curr. */
	private JTextField textSpeedCurr;
	
	/** The text modifiers curr. */
	private JTextField textModifiersCurr;
	
	/** The text cost curr. */
	private JTextField textCostCurr;
	
	/** The txt purchasable sled. */
	private JTextField txtPurchasableSled;
	
	/** The panel sled 1. */
	private JPanel panelSled_1;
	
	/** The text armour shop. */
	private JTextField textArmourShop;
	
	/** The text speed shop. */
	private JTextField textSpeedShop;
	
	/** The text modifiers shop. */
	private JTextField textModifiersShop;
	
	/** The text cost shop. */
	private JTextField textCostShop;
	
	/** The text index. */
	private JTextField textIndex;
	
	/** The index. */
	private int index;
	
	/** The btn purchase. */
	private JButton btnPurchase;
	
	/** The text funds. */
	private JTextField textFunds;
	
	/**
	 * Instantiates a new sled store screen.
	 *
	 * @param incomingEnviroment the incoming enviroment
	 */
	public SledStoreScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmSledStore.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frmSledStore.dispose();
	}
	
	/**
	 * Finished window.
	 */
	public void finishedWindow() {
		enviroment.closeSledStoreScreen(this);
	}
	
	/**
	 * Refresh window.
	 */
	public void refreshWindow() {
		frmSledStore.dispose();
		enviroment.launchSledStoreScreen();
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
					SledStoreScreen window = new SledStoreScreen();
					window.frmSledStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SledStoreScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSledStore = new JFrame();
		frmSledStore.setTitle("Store");
		frmSledStore.setBounds(100, 100, 685, 488);
		frmSledStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSledStore.getContentPane().setLayout(null);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setBounds(573, 11, 86, 20);
		frmSledStore.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(Back);
		btnBack.setBounds(570, 415, 89, 23);
		frmSledStore.getContentPane().add(btnBack);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText(""+enviroment.getPlayerTeam().getName());
		txtName.setEditable(false);
		txtName.setBounds(10, 11, 86, 20);
		frmSledStore.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		panelSled = new JPanel();
		panelSled.setLayout(null);
		panelSled.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSled.setBounds(46, 53, 191, 302);
		frmSledStore.getContentPane().add(panelSled);
		
		textArmourCurr = new JTextField();
		textArmourCurr.setHorizontalAlignment(SwingConstants.CENTER);
		textArmourCurr.setEditable(false);
		textArmourCurr.setColumns(10);
		textArmourCurr.setBounds(10, 107, 171, 27);
		panelSled.add(textArmourCurr);
		
		textSpeedCurr = new JTextField();
		textSpeedCurr.setHorizontalAlignment(SwingConstants.CENTER);
		textSpeedCurr.setEditable(false);
		textSpeedCurr.setColumns(10);
		textSpeedCurr.setBounds(10, 145, 171, 27);
		panelSled.add(textSpeedCurr);
		
		textModifiersCurr = new JTextField();
		textModifiersCurr.setHorizontalAlignment(SwingConstants.CENTER);
		textModifiersCurr.setEditable(false);
		textModifiersCurr.setColumns(10);
		textModifiersCurr.setBounds(10, 183, 171, 27);
		panelSled.add(textModifiersCurr);
		
		textCostCurr = new JTextField();
		textCostCurr.setHorizontalAlignment(SwingConstants.CENTER);
		textCostCurr.setEditable(false);
		textCostCurr.setColumns(10);
		textCostCurr.setBounds(10, 221, 171, 27);
		panelSled.add(textCostCurr);
		
		textYourSled = new JTextField();
		textYourSled.setBounds(10, 11, 171, 33);
		panelSled.add(textYourSled);
		textYourSled.setText("Current Sled");
		textYourSled.setHorizontalAlignment(SwingConstants.CENTER);
		textYourSled.setEditable(false);
		textYourSled.setColumns(10);
		
		panelSled_1 = new JPanel();
		panelSled_1.setLayout(null);
		panelSled_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSled_1.setBounds(424, 53, 191, 302);
		frmSledStore.getContentPane().add(panelSled_1);
		
		textArmourShop = new JTextField();
		textArmourShop.setHorizontalAlignment(SwingConstants.CENTER);
		textArmourShop.setEditable(false);
		textArmourShop.setColumns(10);
		textArmourShop.setBounds(10, 108, 171, 27);
		panelSled_1.add(textArmourShop);
		
		textSpeedShop = new JTextField();
		textSpeedShop.setHorizontalAlignment(SwingConstants.CENTER);
		textSpeedShop.setEditable(false);
		textSpeedShop.setColumns(10);
		textSpeedShop.setBounds(10, 146, 171, 27);
		panelSled_1.add(textSpeedShop);
		
		textModifiersShop = new JTextField();
		textModifiersShop.setHorizontalAlignment(SwingConstants.CENTER);
		textModifiersShop.setEditable(false);
		textModifiersShop.setColumns(10);
		textModifiersShop.setBounds(10, 184, 171, 27);
		panelSled_1.add(textModifiersShop);
		
		textCostShop = new JTextField();
		textCostShop.setHorizontalAlignment(SwingConstants.CENTER);
		textCostShop.setEditable(false);
		textCostShop.setColumns(10);
		textCostShop.setBounds(10, 222, 171, 27);
		panelSled_1.add(textCostShop);
		
		txtPurchasableSled = new JTextField();
		txtPurchasableSled.setBounds(10, 11, 171, 32);
		panelSled_1.add(txtPurchasableSled);
		txtPurchasableSled.setText("Purchasable Sled");
		txtPurchasableSled.setHorizontalAlignment(SwingConstants.CENTER);
		txtPurchasableSled.setEditable(false);
		txtPurchasableSled.setColumns(10);
		
		textIndex = new JTextField();
		textIndex.setEditable(false);
		textIndex.setHorizontalAlignment(SwingConstants.CENTER);
		textIndex.setBounds(67, 271, 53, 20);
		panelSled_1.add(textIndex);
		textIndex.setColumns(10);
		
		JButton btnLeft = new JButton("<==");
		btnLeft.addMouseListener(this);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index == 0 && 0 != (enviroment.getMarket().getSledSaleArray().size())) {
					index = enviroment.getMarket().getSledSaleArray().size() - 1;
				}
				else if (0 != (enviroment.getMarket().getSledSaleArray().size())) {
					index -= 1;
				}
			}
		});
		btnLeft.setBounds(4, 270, 63, 23);
		panelSled_1.add(btnLeft);
		
		JButton btnRight = new JButton("==>");
		btnRight.addMouseListener(this);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (index == enviroment.getMarket().getSledSaleArray().size() - 1) {
					index = 0;
				}
				else if (0 != (enviroment.getMarket().getSledSaleArray().size())){
					index += 1;
				}
			}
		});
		btnRight.setBounds(120, 270, 61, 23);
		panelSled_1.add(btnRight);
		
		btnPurchase = new JButton("<==      Purchase    <==");
		btnPurchase.addMouseListener(this);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.getPlayerTeam().getTotalFunds() > enviroment.getMarket().getSledSaleArray().get(index).getValue() - enviroment.getPlayerTeam().getSled().getValue()) {
					try {
						enviroment.getMarket().buyAsset(enviroment.getPlayerTeam(), enviroment.getMarket().getSledSaleArray().get(index));
					} catch (InvalidTeamSize e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					enviroment.getPlayerTeam().getSled().setName(enviroment.getPlayerTeam().getName() + "'s Sled");
				}
				
			}
		});
		btnPurchase.setBounds(247, 192, 167, 50);
		frmSledStore.getContentPane().add(btnPurchase);
		
		textFunds = new JTextField();
		textFunds.setEditable(false);
		textFunds.setHorizontalAlignment(SwingConstants.CENTER);
		textFunds.setBounds(272, 280, 118, 50);
		frmSledStore.getContentPane().add(textFunds);
		textFunds.setColumns(10);
		
		mouseClicked(null);
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

	
	/**
	 *  
	 *
	 * @param e the e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (enviroment.getPlayerTeam().getTotalFunds() < enviroment.getMarket().getSledSaleArray().get(index).getValue() - enviroment.getPlayerTeam().getSled().getValue()) {
			textFunds.setText("Need More Funds");
		}else {
			textFunds.setText("");
		}
		
		
		
		textArmourCurr.setText("Armour: " + enviroment.getPlayerTeam().getSled().getAttribute(SledAttribute.ARMOUR));
		textSpeedCurr.setText("Speed: " + enviroment.getPlayerTeam().getSled().getAttribute(SledAttribute.SPEED));
		textModifiersCurr.setText("Modifiers: " + enviroment.getPlayerTeam().getSled().getModifiers());
		textCostCurr.setText("Cost: " + enviroment.getPlayerTeam().getSled().getValue());
		
		textArmourShop.setText("Armour:" + enviroment.getMarket().getSledSaleArray().get(index).getAttribute(SledAttribute.ARMOUR));
		textSpeedShop.setText("Speed: " + enviroment.getMarket().getSledSaleArray().get(index).getAttribute(SledAttribute.SPEED));
		textModifiersShop.setText("Modifiers: " + enviroment.getMarket().getSledSaleArray().get(index).getModifiers());
		textCostShop.setText("Cost: " + enviroment.getMarket().getSledSaleArray().get(index).getValue());
		
		textIndex.setText(""+(index + 1));
		
		
		
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
	}

	/**
	 * Mouse pressed.
	 *
	 * @param e the e
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Mouse released.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Mouse entered.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Mouse exited.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
