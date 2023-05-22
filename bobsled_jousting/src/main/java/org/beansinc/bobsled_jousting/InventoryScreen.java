package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.beansinc.bobsled_jousting.BSExceptions.ItemNotFound;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class InventoryScreen.
 */
public class InventoryScreen implements MouseListener{

	/** The frm inventory. */
	private JFrame frmInventory;
	
	/** The Back. */
	private final Action Back = new SwingAction();
	
	/** The enviroment. */
	private GameEnviroment enviroment;
	
	/** The text name. */
	private JTextField textName;
	
	/** The txt money. */
	private JTextField txtMoney;
	
	/** The text sled. */
	private JTextField textSled;
	
	/** The txt sled name. */
	private JTextField txtSledName;
	
	/** The txt sled armour. */
	private JTextField txtSledArmour;
	
	/** The txt sled speed. */
	private JTextField txtSledSpeed;
	
	/** The txt sled modifiers. */
	private JTextField txtSledModifiers;
	
	/** The txt sled cost. */
	private JTextField txtSledCost;
	
	/** The btn sell. */
	private JButton btnSell;

	private JTextField textItemInformation;
	
	/** The text item value. */
	private JTextField textItemValue;
	
	/** The text item name. */
	private JTextField textItemName;
	
	/** The btn right. */
	private JButton btnRight;

	
	/** The item index. */
	private int itemIndex;
	private int contIndex;
	private JTextField textNameCont;
	private JTextField textOffenceCont;
	private JTextField textNameContVar;
	private JTextField textModifiersCont;
	private JTextField textDefenceCont;
	private JTextField textStanimaCont;
	private JTextField textOffenceContVar;
	private JTextField textDefenceContVar;
	private JTextField textStanimaContVar;
	private JTextField textModifiersContVar;
	private JButton btnLeft;
	
	/**
	 * Instantiates a new inventory screen.
	 *
	 * @param incomingEnviroment the incoming enviroment
	 */
	public InventoryScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmInventory.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frmInventory.dispose();
	}
	
	/**
	 * Finished window.
	 */
	public void finishedWindow() {
		enviroment.closeInventoryScreen(this);
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
					InventoryScreen window = new InventoryScreen();
					window.frmInventory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventoryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventory = new JFrame();
		frmInventory.setTitle("Inventory");
		frmInventory.setBounds(100, 100, 685, 488);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		JPanel panelCont = new JPanel();
		panelCont.setBounds(369, 214, 191, 224);
		frmInventory.getContentPane().add(panelCont);
		panelCont.setLayout(null);
		panelCont.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelCont.setBackground(SystemColor.menu);
		
		textNameCont = new JTextField();
		textNameCont.setText("Name:");
		textNameCont.setEditable(false);
		textNameCont.setColumns(10);
		textNameCont.setBounds(10, 11, 62, 20);
		panelCont.add(textNameCont);
		
		textOffenceCont = new JTextField();
		textOffenceCont.setText("OFFENCE:");
		textOffenceCont.setEditable(false);
		textOffenceCont.setColumns(10);
		textOffenceCont.setBounds(10, 42, 76, 20);
		panelCont.add(textOffenceCont);
		
		textNameContVar = new JTextField();
		textNameContVar.setEditable(false);
		textNameContVar.setHorizontalAlignment(SwingConstants.CENTER);
		textNameContVar.setColumns(10);
		textNameContVar.setBounds(68, 11, 114, 20);
		panelCont.add(textNameContVar);
		
		textModifiersCont = new JTextField();
		textModifiersCont.setText("Modifiers:");
		textModifiersCont.setEditable(false);
		textModifiersCont.setColumns(10);
		textModifiersCont.setBounds(10, 126, 76, 20);
		panelCont.add(textModifiersCont);
		
		textDefenceCont = new JTextField();
		textDefenceCont.setText("DEFENCE:");
		textDefenceCont.setEditable(false);
		textDefenceCont.setColumns(10);
		textDefenceCont.setBounds(10, 68, 76, 20);
		panelCont.add(textDefenceCont);
		
		textStanimaCont = new JTextField();
		textStanimaCont.setText("STANIMA:");
		textStanimaCont.setEditable(false);
		textStanimaCont.setColumns(10);
		textStanimaCont.setBounds(10, 95, 76, 20);
		panelCont.add(textStanimaCont);
		
		textOffenceContVar = new JTextField();
		textOffenceContVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceContVar.setEditable(false);
		textOffenceContVar.setColumns(10);
		textOffenceContVar.setBounds(96, 42, 86, 20);
		panelCont.add(textOffenceContVar);
		
		textDefenceContVar = new JTextField();
		textDefenceContVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceContVar.setEditable(false);
		textDefenceContVar.setColumns(10);
		textDefenceContVar.setBounds(96, 68, 86, 20);
		panelCont.add(textDefenceContVar);
		
		textStanimaContVar = new JTextField();
		textStanimaContVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaContVar.setEditable(false);
		textStanimaContVar.setColumns(10);
		textStanimaContVar.setBounds(96, 93, 86, 20);
		panelCont.add(textStanimaContVar);
		
		textModifiersContVar = new JTextField();
		textModifiersContVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textModifiersContVar.setEditable(false);
		textModifiersContVar.setColumns(10);
		textModifiersContVar.setBounds(96, 126, 86, 20);
		panelCont.add(textModifiersContVar);
		
		JButton btnLeftCont = new JButton("<==");
		btnLeftCont.addMouseListener(this);
		btnLeftCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contIndex == 0 && 0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
					contIndex = enviroment.getPlayerTeam().getActiveTeam().size() - 1;
				}
				else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
					contIndex -= 1;
				}
			}
		});
		btnLeftCont.setBounds(29, 167, 57, 23);
		panelCont.add(btnLeftCont);
		
		JButton btnRightCont = new JButton("==>");
		btnRightCont.addMouseListener(this);
		btnRightCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contIndex == (enviroment.getPlayerTeam().getActiveTeam().size() - 1)) {
					contIndex = 0;
				}
				else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())){
					contIndex += 1;
				}
			}
		});
		btnRightCont.setBounds(96, 167, 65, 23);
		panelCont.add(btnRightCont);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setAction(Back);
		btnNewButton.setBounds(570, 415, 89, 23);
		frmInventory.getContentPane().add(btnNewButton);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setText(""+enviroment.getPlayerTeam().getName());
		textName.setEditable(false);
		textName.setBounds(10, 11, 86, 20);
		frmInventory.getContentPane().add(textName);
		textName.setColumns(10);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setBounds(573, 11, 86, 20);
		frmInventory.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		textSled = new JTextField();
		textSled.setEditable(false);
		textSled.setHorizontalAlignment(SwingConstants.CENTER);
		textSled.setText("Sled");
		textSled.setBounds(92, 59, 86, 20);
		frmInventory.getContentPane().add(textSled);
		textSled.setColumns(10);
		
		JPanel panelSled = new JPanel();
		panelSled.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSled.setBounds(43, 91, 191, 302);
		frmInventory.getContentPane().add(panelSled);
		panelSled.setLayout(null);
		
		txtSledName = new JTextField();
		txtSledName.setEditable(false);
		
		txtSledName.setHorizontalAlignment(SwingConstants.CENTER);
		txtSledName.setBounds(10, 11, 171, 27);
		panelSled.add(txtSledName);
		txtSledName.setColumns(10);
		
		txtSledArmour = new JTextField();
		txtSledArmour.setEditable(false);
		txtSledArmour.setHorizontalAlignment(SwingConstants.CENTER);
		txtSledArmour.setColumns(10);
		txtSledArmour.setBounds(10, 150, 171, 27);
		panelSled.add(txtSledArmour);
		
		txtSledSpeed = new JTextField();
		txtSledSpeed.setEditable(false);
		txtSledSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		txtSledSpeed.setColumns(10);
		txtSledSpeed.setBounds(10, 188, 171, 27);
		panelSled.add(txtSledSpeed);
		
		txtSledModifiers = new JTextField();
		txtSledModifiers.setEditable(false);
		txtSledModifiers.setHorizontalAlignment(SwingConstants.CENTER);
		txtSledModifiers.setColumns(10);
		txtSledModifiers.setBounds(10, 226, 171, 27);
		panelSled.add(txtSledModifiers);
		
		txtSledCost = new JTextField();
		txtSledCost.setEditable(false);
		
		txtSledCost.setHorizontalAlignment(SwingConstants.CENTER);
		txtSledCost.setColumns(10);
		txtSledCost.setBounds(10, 264, 171, 27);
		panelSled.add(txtSledCost);
		
		btnSell = new JButton("Sell");
		btnSell.addMouseListener(this);
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if (enviroment.getPlayerTeam().getItems().size() != 0) {
						try {
							enviroment.getMarket().sellAsset(enviroment.getPlayerTeam(), enviroment.getPlayerTeam().getItems().get(itemIndex));
						} catch (ItemNotFound e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (itemIndex == enviroment.getPlayerTeam().getItems().size() && enviroment.getPlayerTeam().getItems().size() != 0) {
							itemIndex -= 1;
						}
					}
			}
		});
		btnSell.setBounds(414, 304, 115, 63);
		frmInventory.getContentPane().add(btnSell);
		
		textItemInformation = new JTextField();
		textItemInformation.setHorizontalAlignment(SwingConstants.CENTER);
		textItemInformation.setEditable(false);
		textItemInformation.setColumns(10);
		textItemInformation.setBounds(261, 151, 398, 30);
		frmInventory.getContentPane().add(textItemInformation);
		
		textItemValue = new JTextField();
		textItemValue.setHorizontalAlignment(SwingConstants.CENTER);
		textItemValue.setEditable(false);
		textItemValue.setColumns(10);
		textItemValue.setBounds(421, 123, 86, 20);
		frmInventory.getContentPane().add(textItemValue);
		
		textItemName = new JTextField();
		textItemName.setHorizontalAlignment(SwingConstants.CENTER);
		textItemName.setEditable(false);
		textItemName.setColumns(10);
		textItemName.setBounds(404, 59, 115, 49);
		frmInventory.getContentPane().add(textItemName);
		
		JButton btnUse = new JButton("Use Item");
		btnUse.addMouseListener(this);
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.getPlayerTeam().getItems().size() > 0 && enviroment.getPlayerTeam().getActiveTeam().size() > 0 && enviroment.getPlayerTeam().getItems().get(itemIndex) != Item.SLIME_BOMB) {
					panelCont.setVisible(true);
					btnSell.setVisible(false);
					btnUse.setVisible(false);
					
					textNameContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getName());
					textOffenceContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getAttribute(ContestantAttribute.OFFENCE));
					textStanimaContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getAttribute(ContestantAttribute.STANIMA));
					textDefenceContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getAttribute(ContestantAttribute.DEFENCE));
					textModifiersContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getModifiers());
				}
				
			}
		});
		btnUse.setBounds(414, 234, 115, 63);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addMouseListener(this);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.getPlayerTeam().getItems().get(itemIndex) != Item.SLIME_BOMB) {
					if (enviroment.getPlayerTeam().getItems().get(itemIndex) != Item.HEALTH_POTION)
					Item.applyItemToContestant(enviroment.getPlayerTeam().getActiveTeam().get(contIndex), enviroment.getPlayerTeam().getItems().get(itemIndex));
				}else if (enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getModifiers().contains(ContestantModifer.INJURED)) {
					Item.applyItemToContestant(enviroment.getPlayerTeam().getActiveTeam().get(contIndex), enviroment.getPlayerTeam().getItems().get(itemIndex));
				}
				panelCont.setVisible(false);
				btnSell.setVisible(true);
				btnUse.setVisible(true);
			}
		});
		btnApply.setBounds(49, 190, 86, 23);
		panelCont.add(btnApply);
		frmInventory.getContentPane().add(btnUse);
		
		btnLeft = new JButton("<==");
		btnLeft.addMouseListener(this);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemIndex == 0 && 0 != (enviroment.getPlayerTeam().getItems().size())) {
					itemIndex = enviroment.getPlayerTeam().getItems().size() - 1;
				}
				else if (0 != (enviroment.getPlayerTeam().getItems().size())) {
					itemIndex -= 1;
				}
				panelCont.setVisible(false);
				btnSell.setVisible(true);
				btnUse.setVisible(true);
			}
		});
		btnLeft.setBounds(346, 192, 73, 23);
		frmInventory.getContentPane().add(btnLeft);
		
		btnRight = new JButton("==>");
		btnRight.addMouseListener(this);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (itemIndex == (enviroment.getPlayerTeam().getItems().size() - 1)) {
					itemIndex = 0;
				}
				else if (0 != (enviroment.getPlayerTeam().getItems().size())){
					itemIndex += 1;
				}
				panelCont.setVisible(false);
				btnSell.setVisible(true);
				btnUse.setVisible(true);
			}
		});
		btnRight.setBounds(523, 192, 60, 23);
		frmInventory.getContentPane().add(btnRight);
		
		panelCont.setVisible(false);
		mouseClicked(null);  //Text Manager
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
		txtSledName.setText(""+enviroment.getPlayerTeam().getSled().getName());
		txtSledCost.setText("Cost:"+enviroment.getPlayerTeam().getSled().getValue());
		txtSledArmour.setText("Armour:"+enviroment.getPlayerTeam().getSled().getAttribute(SledAttribute.ARMOUR));
		txtSledSpeed.setText("Speed:"+enviroment.getPlayerTeam().getSled().getAttribute(SledAttribute.SPEED));
		txtSledModifiers.setText("Modifiers:"+enviroment.getPlayerTeam().getSled().getModifiers());
		
		if (enviroment.getPlayerTeam().getItems().size() > 0) {
			textItemName.setText(""+enviroment.getPlayerTeam().getItems().get(itemIndex).name());
			textItemValue.setText(""+enviroment.getPlayerTeam().getItems().get(itemIndex).value);
			textItemInformation.setText(""+enviroment.getPlayerTeam().getItems().get(itemIndex).description);
		}else {
			textItemName.setText("No Items Owned");
			textItemValue.setText("");
			textItemInformation.setText("");
			
		}
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		textNameContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getName());
		textOffenceContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getAttribute(ContestantAttribute.OFFENCE));
		textStanimaContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getAttribute(ContestantAttribute.STANIMA));
		textDefenceContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getAttribute(ContestantAttribute.DEFENCE));
		textModifiersContVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(contIndex).getModifiers());
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

