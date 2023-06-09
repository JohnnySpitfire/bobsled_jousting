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
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;


/**
 * The Class PlayerStoreScreen.
 */
public class PlayerStoreScreen implements MouseListener{

	/** The frm player store. */
	private JFrame frmPlayerStore;
	
	/** The enviroment. */
	private GameEnviroment enviroment;
	
	/** The txt money. */
	private JTextField txtMoney;
	
	/** The Back. */
	private final Action Back = new SwingAction();
	
	/** The txt name. */
	private JTextField txtName;
	
	
	/** The text name. */
	private JTextField textName;
	
	/** The text offence. */
	private JTextField textOffence;
	
	/** The text name var. */
	private JTextField textNameVar;
	
	/** The text modifiers. */
	private JTextField textModifiers;
	
	/** The text defence. */
	private JTextField textDefence;
	
	/** The text stanima. */
	private JTextField textStanima;
	
	/** The text offence var. */
	private JTextField textOffenceVar;
	
	/** The text defence var. */
	private JTextField textDefenceVar;
	
	/** The text stanima var. */
	private JTextField textStanimaVar;
	
	/** The text modifiers var. */
	private JTextField textModifiersVar;
	
	/** The text cost. */
	private JTextField textCost;
	
	/** The text cost var. */
	private JTextField textCostVar;
	
	/** The text index. */
	private JTextField textIndex;
	
	/** The contestant index. */
	private int contestantIndex = 0;
	
	/** The text no money. */
	private JTextField textNoMoney;
	
	/** The text players full. */
	private JTextField textPlayersFull;
	
	/**
	 * Instantiates a new player store screen.
	 *
	 * @param incomingEnviroment the incoming enviroment
	 */
	public PlayerStoreScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmPlayerStore.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frmPlayerStore.dispose();
	}
	
	/**
	 * Finished window.
	 */
	public void finishedWindow() {
		enviroment.closePlayerStoreScreen(this);
	}
	
	/**
	 * Refresh window.
	 */
	public void refreshWindow() {
		frmPlayerStore.dispose();
		enviroment.launchPlayerStoreScreen();
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
					PlayerStoreScreen window = new PlayerStoreScreen();
					window.frmPlayerStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerStoreScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayerStore = new JFrame();
		frmPlayerStore.setTitle("Store");
		frmPlayerStore.setBounds(100, 100, 685, 488);
		frmPlayerStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayerStore.getContentPane().setLayout(null);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		txtMoney.setBounds(573, 11, 86, 20);
		frmPlayerStore.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setAction(Back);
		btnBack.setBounds(570, 415, 89, 23);
		frmPlayerStore.getContentPane().add(btnBack);
		
		txtName = new JTextField();
		txtName.setText(""+enviroment.getPlayerTeam().getName());
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setEditable(false);
		txtName.setBounds(10, 11, 86, 20);
		frmPlayerStore.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JPanel panelAct = new JPanel();
		panelAct.setLayout(null);
		panelAct.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelAct.setBackground(SystemColor.menu);
		panelAct.setBounds(209, 74, 192, 322);
		frmPlayerStore.getContentPane().add(panelAct);
		
		textName = new JTextField();
		textName.setText("Name:");
		textName.setEditable(false);
		textName.setColumns(10);
		textName.setBounds(10, 11, 62, 20);
		panelAct.add(textName);
		
		textOffence = new JTextField();
		textOffence.setText("OFFENCE:");
		textOffence.setEditable(false);
		textOffence.setColumns(10);
		textOffence.setBounds(10, 42, 76, 20);
		panelAct.add(textOffence);
		
		textNameVar = new JTextField();
		textNameVar.setEditable(false);
		textNameVar.setHorizontalAlignment(SwingConstants.CENTER);
		textNameVar.setColumns(10);
		textNameVar.setBounds(68, 11, 114, 20);
		panelAct.add(textNameVar);
		
		textModifiers = new JTextField();
		textModifiers.setText("Modifiers:");
		textModifiers.setEditable(false);
		textModifiers.setColumns(10);
		textModifiers.setBounds(10, 126, 76, 20);
		panelAct.add(textModifiers);
		
		textDefence = new JTextField();
		textDefence.setText("DEFENCE:");
		textDefence.setEditable(false);
		textDefence.setColumns(10);
		textDefence.setBounds(10, 68, 76, 20);
		panelAct.add(textDefence);
		
		textStanima = new JTextField();
		textStanima.setText("STANIMA:");
		textStanima.setEditable(false);
		textStanima.setColumns(10);
		textStanima.setBounds(10, 95, 76, 20);
		panelAct.add(textStanima);
		
		textOffenceVar = new JTextField();
		textOffenceVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceVar.setEditable(false);
		textOffenceVar.setColumns(10);
		textOffenceVar.setBounds(96, 42, 86, 20);
		panelAct.add(textOffenceVar);
		
		textDefenceVar = new JTextField();
		textDefenceVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceVar.setEditable(false);
		textDefenceVar.setColumns(10);
		textDefenceVar.setBounds(96, 68, 86, 20);
		panelAct.add(textDefenceVar);
		
		textStanimaVar = new JTextField();
		textStanimaVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaVar.setEditable(false);
		textStanimaVar.setColumns(10);
		textStanimaVar.setBounds(96, 93, 86, 20);
		panelAct.add(textStanimaVar);
		
		textModifiersVar = new JTextField();
		textModifiersVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textModifiersVar.setEditable(false);
		textModifiersVar.setColumns(10);
		textModifiersVar.setBounds(96, 126, 86, 38);
		panelAct.add(textModifiersVar);
		
		textCost = new JTextField();
		textCost.setText("Cost:");
		textCost.setEditable(false);
		textCost.setColumns(10);
		textCost.setBounds(10, 201, 76, 20);
		panelAct.add(textCost);
		
		textCostVar = new JTextField();
		textCostVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textCostVar.setEditable(false);
		textCostVar.setColumns(10);
		textCostVar.setBounds(96, 201, 86, 20);
		panelAct.add(textCostVar);
		
		JButton btnLeft = new JButton("<==");
		btnLeft.addMouseListener(this);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contestantIndex == 0 && 0 != (enviroment.getMarket().getContestantSaleArray().size())) {
					contestantIndex = enviroment.getMarket().getContestantSaleArray().size() - 1;
				}
				else if (0 != (enviroment.getMarket().getContestantSaleArray().size())) {
					contestantIndex -= 1;
				}
			}
		});
		btnLeft.setBounds(29, 264, 57, 23);
		panelAct.add(btnLeft);
		
		JButton btnRight = new JButton("==>");
		btnRight.addMouseListener(this);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contestantIndex == (enviroment.getMarket().getContestantSaleArray().size() - 1)) {
					contestantIndex = 0;
				}
				else if (0 != (enviroment.getMarket().getContestantSaleArray().size())){
					contestantIndex += 1;
				}
			}
		});
		btnRight.setBounds(96, 264, 65, 23);
		panelAct.add(btnRight);
		
		textIndex = new JTextField();
		textIndex.setHorizontalAlignment(SwingConstants.CENTER);
		textIndex.setEditable(false);
		textIndex.setColumns(10);
		textIndex.setBounds(49, 298, 86, 20);
		panelAct.add(textIndex);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addMouseListener(this);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.getPlayerTeam().getReserveTeam().size() < 5) {
					if (enviroment.getMarket().getContestantSaleArray().size() != 0 && enviroment.getPlayerTeam().getTotalFunds() >= enviroment.getMarket().getContestantSaleArray().get(contestantIndex).getValue()) {
						try {
							enviroment.getMarket().buyAsset(enviroment.getPlayerTeam(), enviroment.getMarket().getContestantSaleArray().get(contestantIndex));
						} catch (InvalidTeamSize e1) {
							e1.printStackTrace();
						}
						if (contestantIndex == enviroment.getMarket().getContestantSaleArray().size() && enviroment.getMarket().getContestantSaleArray().size() != 0) {
							contestantIndex -= 1;
						}
					}
				}
			}
		});
		btnPurchase.setBounds(254, 407, 116, 39);
		frmPlayerStore.getContentPane().add(btnPurchase);
		
		textNoMoney = new JTextField();
		textNoMoney.setEditable(false);
		textNoMoney.setHorizontalAlignment(SwingConstants.CENTER);
		textNoMoney.setBounds(47, 215, 124, 20);
		frmPlayerStore.getContentPane().add(textNoMoney);
		textNoMoney.setColumns(10);
		
		textPlayersFull = new JTextField();
		textPlayersFull.setEditable(false);
		textPlayersFull.setHorizontalAlignment(SwingConstants.CENTER);
		textPlayersFull.setBounds(469, 215, 130, 20);
		frmPlayerStore.getContentPane().add(textPlayersFull);
		textPlayersFull.setColumns(10);
		
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
		if (enviroment.getMarket().getContestantSaleArray().size() != 0) {
			textNameVar.setText(""+enviroment.getMarket().getContestantSaleArray().get(contestantIndex).getName());
			textOffenceVar.setText(""+enviroment.getMarket().getContestantSaleArray().get(contestantIndex).getAttribute(ContestantAttribute.OFFENCE));
			textDefenceVar.setText(""+enviroment.getMarket().getContestantSaleArray().get(contestantIndex).getAttribute(ContestantAttribute.DEFENCE));
			textStanimaVar.setText(""+enviroment.getMarket().getContestantSaleArray().get(contestantIndex).getAttribute(ContestantAttribute.MAX_STANIMA));
			textCostVar.setText(""+enviroment.getMarket().getContestantSaleArray().get(contestantIndex).getValue());
			
			
			if (enviroment.getMarket().getContestantSaleArray().get(contestantIndex).getValue() > enviroment.getPlayerTeam().getTotalFunds()) {
				textNoMoney.setText("Insufficient Funds");
			}else {
				textNoMoney.setText("");
			}
			
		}else {
			textNameVar.setText("No More Players");
			textOffenceVar.setText("");
			textDefenceVar.setText("");
			textStanimaVar.setText("");
			textCostVar.setText("");
		}
		if (enviroment.getPlayerTeam().getActiveTeam().size() + enviroment.getPlayerTeam().getReserveTeam().size() > 8) {
			textPlayersFull.setText("Team is Full");
		}else {
			textPlayersFull.setText("");
		}
		
		
		
		
		txtMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		textIndex.setText(""+(contestantIndex+1));
	}

	/**
	 * Mouse pressed.
	 *
	 * @param e the e
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	/**
	 * Mouse released.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	/**
	 * Mouse entered.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	/**
	 * Mouse exited.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
