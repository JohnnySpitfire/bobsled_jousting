package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.Action;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollBar;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerSetupScreen.
 */
public class PlayerSetupScreen implements MouseListener, ActionListener {

	/** The frm playersetupscreen. */
	private JFrame frmPlayersetupscreen;
	
	/** The enviroment. */
	private GameEnviroment enviroment;
	
	/** The text name IN. */
	private JTextField textNameIN;
	
	/** The text offence IN. */
	private JTextField textOffenceIN;
	
	/** The text name var IN. */
	private JTextField textNameVarIN;
	
	/** The text modifiers IN. */
	private JTextField textModifiersIN;
	
	/** The text defence IN. */
	private JTextField textDefenceIN;
	
	/** The text stanima IN. */
	private JTextField textStanimaIN;
	
	/** The text offence var IN. */
	private JTextField textOffenceVarIN;
	
	/** The text defence var IN. */
	private JTextField textDefenceVarIN;
	
	/** The text stanima var IN. */
	private JTextField textStanimaVarIN;
	
	/** The text modifiers var IN. */
	private JTextField textModifiersVarIN;
	
	/** The text cost IN. */
	private JTextField textCostIN;
	
	/** The text cost var IN. */
	private JTextField textCostVarIN;
	
	/** The btn accept. */
	private JButton btnAccept;
	
	/** The text name act. */
	private JTextField textNameAct;
	
	/** The text offence act. */
	private JTextField textOffenceAct;
	
	/** The text name var act. */
	private JTextField textNameVarAct;
	
	/** The text modifiers act. */
	private JTextField textModifiersAct;
	
	/** The text defence act. */
	private JTextField textDefenceAct;
	
	/** The text stanima act. */
	private JTextField textStanimaAct;
	
	/** The text offence var act. */
	private JTextField textOffenceVarAct;
	
	/** The text defence var act. */
	private JTextField textDefenceVarAct;
	
	/** The text stanima var act. */
	private JTextField textStanimaVarAct;
	
	/** The text modifiers var act. */
	private JTextField textModifiersVarAct;
	
	/** The text cost act. */
	private JTextField textCostAct;
	
	/** The text cost var act. */
	private JTextField textCostVarAct;
	
	/** The text active num. */
	private JTextField textActiveNum;
	
	/** The Accept. */
	private final Action Accept = new SwingAction();
	
	/** The text money. */
	private JTextField textMoney;
	
	/** The initial contestants. */
	ArrayList<Contestant> initialContestants = new ArrayList<Contestant>();
	
	/** The initial index. */
	private int initialIndex = 0;
	
	/** The active index. */
	private int activeIndex = 0;
	
	/** The a L initial. */
	private final Action aLInitial = new SwingAction_2();
	
	/** The txt initial num. */
	private JTextField txtInitialNum;
	
	/** The btn RIN. */
	private JButton btnRIN;
	
	/** The a R initial. */
	private final Action aRInitial = new SwingAction_3();
	
	/** The Add IN. */
	private final Action AddIN = new SwingAction_1();
	
	/** The a L active. */
	private final Action aLActive = new SwingAction_4();
	
	/** The a R active. */
	private final Action aRActive = new SwingAction_5();
	
	/** The Remove act. */
	private final Action RemoveAct = new SwingAction_6();
	
	/** The text afford. */
	private JTextField textAfford;
	
	/** The text required players. */
	private JTextField textRequiredPlayers;

	
	/**
	 * Instantiates a new player setup screen.
	 *
	 * @param incomingEnviroment the incoming enviroment
	 * @throws InvalidObjectAttributeType the invalid object attribute type
	 */
	public PlayerSetupScreen(GameEnviroment incomingEnviroment) throws InvalidObjectAttributeType {
		enviroment = incomingEnviroment;
		for(int i=0; i<15; i++){
            Contestant randContestant = Utils.generateRandomContestant(enviroment.getRandom(), 0);
            initialContestants.add(randContestant);
        }
		
		initialize();
		frmPlayersetupscreen.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frmPlayersetupscreen.dispose();
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
					PlayerSetupScreen window = new PlayerSetupScreen();
					window.frmPlayersetupscreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerSetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlayersetupscreen = new JFrame();
		frmPlayersetupscreen.addMouseListener(this);
		frmPlayersetupscreen.setTitle("PlayerSetupScreen");
		frmPlayersetupscreen.setBounds(100, 100, 685, 488);
		frmPlayersetupscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayersetupscreen.getContentPane().setLayout(null);
		
		JPanel panelIN = new JPanel();
		panelIN.setLayout(null);
		panelIN.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelIN.setBounds(37, 35, 192, 322);
		frmPlayersetupscreen.getContentPane().add(panelIN);
		
		textNameIN = new JTextField();
		textNameIN.setText("Name:");
		textNameIN.setEditable(false);
		textNameIN.setColumns(10);
		textNameIN.setBounds(10, 11, 62, 20);
		panelIN.add(textNameIN);
		
		textOffenceIN = new JTextField();
		textOffenceIN.setText("OFFENCE:");
		textOffenceIN.setEditable(false);
		textOffenceIN.setColumns(10);
		textOffenceIN.setBounds(10, 42, 76, 20);
		panelIN.add(textOffenceIN);
		
		textNameVarIN = new JTextField();
		textNameVarIN.addActionListener(this);
		textNameVarIN.setHorizontalAlignment(SwingConstants.CENTER);
		textNameVarIN.setText(""+initialContestants.get(initialIndex).getName());
		textNameVarIN.setColumns(10);
		textNameVarIN.setBounds(68, 11, 114, 20);
		panelIN.add(textNameVarIN);
		
		textModifiersIN = new JTextField();
		textModifiersIN.setText("Modifiers:");
		textModifiersIN.setEditable(false);
		textModifiersIN.setColumns(10);
		textModifiersIN.setBounds(10, 126, 76, 20);
		panelIN.add(textModifiersIN);
		
		textDefenceIN = new JTextField();
		textDefenceIN.setText("DEFENCE:");
		textDefenceIN.setEditable(false);
		textDefenceIN.setColumns(10);
		textDefenceIN.setBounds(10, 68, 76, 20);
		panelIN.add(textDefenceIN);
		
		textStanimaIN = new JTextField();
		textStanimaIN.setText("STANIMA:");
		textStanimaIN.setEditable(false);
		textStanimaIN.setColumns(10);
		textStanimaIN.setBounds(10, 95, 76, 20);
		panelIN.add(textStanimaIN);
		
		textOffenceVarIN = new JTextField();
		textOffenceVarIN.setText(""+initialContestants.get(initialIndex).getAttribute(ContestantAttribute.OFFENCE));
		textOffenceVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceVarIN.setEditable(false);
		textOffenceVarIN.setColumns(10);
		textOffenceVarIN.setBounds(96, 42, 86, 20);
		panelIN.add(textOffenceVarIN);
		
		textDefenceVarIN = new JTextField();
		textDefenceVarIN.setText(""+initialContestants.get(initialIndex).getAttribute(ContestantAttribute.DEFENCE));
		textDefenceVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceVarIN.setEditable(false);
		textDefenceVarIN.setColumns(10);
		textDefenceVarIN.setBounds(96, 68, 86, 20);
		panelIN.add(textDefenceVarIN);
		
		textStanimaVarIN = new JTextField();
		textStanimaVarIN.setText(""+initialContestants.get(initialIndex).getAttribute(ContestantAttribute.MAX_STANIMA));
		textStanimaVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaVarIN.setEditable(false);
		textStanimaVarIN.setColumns(10);
		textStanimaVarIN.setBounds(96, 93, 86, 20);
		panelIN.add(textStanimaVarIN);
		
		textModifiersVarIN = new JTextField();
		textModifiersVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textModifiersVarIN.setText(""+initialContestants.get(initialIndex).getModifiers());
		textModifiersVarIN.setEditable(false);
		textModifiersVarIN.setColumns(10);
		textModifiersVarIN.setBounds(96, 126, 86, 38);
		panelIN.add(textModifiersVarIN);
		
		textCostIN = new JTextField();
		textCostIN.setText("Cost:");
		textCostIN.setEditable(false);
		textCostIN.setColumns(10);
		textCostIN.setBounds(10, 206, 76, 20);
		panelIN.add(textCostIN);
		
		textCostVarIN = new JTextField();
		textCostVarIN.setText(""+initialContestants.get(initialIndex).getValue());
		textCostVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textCostVarIN.setEditable(false);
		textCostVarIN.setColumns(10);
		textCostVarIN.setBounds(96, 206, 86, 20);
		panelIN.add(textCostVarIN);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(this);
		btnAdd.setAction(AddIN);
		btnAdd.setBounds(49, 230, 107, 23);
		panelIN.add(btnAdd);
		
		JButton btnLIN = new JButton("<==");
		btnLIN.setBounds(29, 264, 57, 23);
		panelIN.add(btnLIN);
		btnLIN.addMouseListener(this);
		btnLIN.setAction(aLInitial);
		
		btnRIN = new JButton("==>");
		btnRIN.setBounds(96, 264, 65, 23);
		panelIN.add(btnRIN);
		btnRIN.addMouseListener(this);
		btnRIN.setAction(aRInitial);
		
		txtInitialNum = new JTextField();
		txtInitialNum.setBounds(49, 298, 86, 20);
		panelIN.add(txtInitialNum);
		txtInitialNum.setHorizontalAlignment(SwingConstants.CENTER);
		txtInitialNum.setText(""+(initialIndex+1));
		txtInitialNum.setEditable(false);
		txtInitialNum.setColumns(10);
		
		btnAccept = new JButton("Accept");
		btnAccept.setAction(Accept);
		btnAccept.setBounds(289, 415, 89, 23);
		frmPlayersetupscreen.getContentPane().add(btnAccept);
		
		textMoney = new JTextField();
		textMoney.setHorizontalAlignment(SwingConstants.CENTER);
		textMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		textMoney.setEditable(false);
		textMoney.setBounds(573, 11, 86, 20);
		frmPlayersetupscreen.getContentPane().add(textMoney);
		textMoney.setColumns(10);
		
		textAfford = new JTextField();
		textAfford.setEditable(false);
		textAfford.setHorizontalAlignment(SwingConstants.CENTER);
		textAfford.setText("");
		textAfford.setBounds(89, 368, 86, 20);
		frmPlayersetupscreen.getContentPane().add(textAfford);
		textAfford.setColumns(10);
		
		textRequiredPlayers = new JTextField();
		textRequiredPlayers.setEditable(false);
		textRequiredPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		textRequiredPlayers.setText("");
		textRequiredPlayers.setBounds(227, 384, 212, 20);
		frmPlayersetupscreen.getContentPane().add(textRequiredPlayers);
		textRequiredPlayers.setColumns(10);
		
		JPanel panelIN_1 = new JPanel();
		panelIN_1.setLayout(null);
		panelIN_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelIN_1.setBounds(419, 35, 192, 322);
		frmPlayersetupscreen.getContentPane().add(panelIN_1);
		
		textNameAct = new JTextField();
		textNameAct.setText("Name:");
		textNameAct.setEditable(false);
		textNameAct.setColumns(10);
		textNameAct.setBounds(10, 11, 62, 20);
		panelIN_1.add(textNameAct);
		
		textOffenceAct = new JTextField();
		textOffenceAct.setText("OFFENCE:");
		textOffenceAct.setEditable(false);
		textOffenceAct.setColumns(10);
		textOffenceAct.setBounds(10, 42, 76, 20);
		panelIN_1.add(textOffenceAct);
		
		textNameVarAct = new JTextField();
		textNameVarAct.addActionListener(this);
		textNameVarAct.setText("");
		textNameVarAct.setHorizontalAlignment(SwingConstants.CENTER);
		textNameVarAct.setColumns(10);
		textNameVarAct.setBounds(68, 11, 114, 20);
		panelIN_1.add(textNameVarAct);
		
		textModifiersAct = new JTextField();
		textModifiersAct.setText("Modifiers:");
		textModifiersAct.setEditable(false);
		textModifiersAct.setColumns(10);
		textModifiersAct.setBounds(10, 126, 76, 20);
		panelIN_1.add(textModifiersAct);
		
		textDefenceAct = new JTextField();
		textDefenceAct.setText("DEFENCE:");
		textDefenceAct.setEditable(false);
		textDefenceAct.setColumns(10);
		textDefenceAct.setBounds(10, 68, 76, 20);
		panelIN_1.add(textDefenceAct);
		
		textStanimaAct = new JTextField();
		textStanimaAct.setText("STANIMA:");
		textStanimaAct.setEditable(false);
		textStanimaAct.setColumns(10);
		textStanimaAct.setBounds(10, 95, 76, 20);
		panelIN_1.add(textStanimaAct);
		
		textOffenceVarAct = new JTextField();
		textOffenceVarAct.setText("");
		textOffenceVarAct.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceVarAct.setEditable(false);
		textOffenceVarAct.setColumns(10);
		textOffenceVarAct.setBounds(96, 42, 86, 20);
		panelIN_1.add(textOffenceVarAct);
		
		textDefenceVarAct = new JTextField();
		textDefenceVarAct.setText("");
		textDefenceVarAct.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceVarAct.setEditable(false);
		textDefenceVarAct.setColumns(10);
		textDefenceVarAct.setBounds(96, 68, 86, 20);
		panelIN_1.add(textDefenceVarAct);
		
		textStanimaVarAct = new JTextField();
		textStanimaVarAct.setText("");
		textStanimaVarAct.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaVarAct.setEditable(false);
		textStanimaVarAct.setColumns(10);
		textStanimaVarAct.setBounds(96, 93, 86, 20);
		panelIN_1.add(textStanimaVarAct);
		
		textModifiersVarAct = new JTextField();
		textModifiersVarAct.setText("");
		textModifiersVarAct.setHorizontalAlignment(SwingConstants.RIGHT);
		textModifiersVarAct.setEditable(false);
		textModifiersVarAct.setColumns(10);
		textModifiersVarAct.setBounds(96, 126, 86, 42);
		panelIN_1.add(textModifiersVarAct);
		
		textCostAct = new JTextField();
		textCostAct.setText("Cost:");
		textCostAct.setEditable(false);
		textCostAct.setColumns(10);
		textCostAct.setBounds(10, 206, 76, 20);
		panelIN_1.add(textCostAct);
		
		textCostVarAct = new JTextField();
		textCostVarAct.setText("");
		textCostVarAct.setHorizontalAlignment(SwingConstants.RIGHT);
		textCostVarAct.setEditable(false);
		textCostVarAct.setColumns(10);
		textCostVarAct.setBounds(96, 206, 86, 20);
		panelIN_1.add(textCostVarAct);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addMouseListener(this);
		btnRemove.setAction(RemoveAct);
		btnRemove.addMouseListener(this);
		btnRemove.setBounds(49, 230, 107, 23);
		panelIN_1.add(btnRemove);
		
		JButton btnLAct = new JButton("<==");
		btnLAct.setAction(aLActive);
		btnLAct.addMouseListener(this);
		btnLAct.setBounds(29, 264, 57, 23);
		panelIN_1.add(btnLAct);
		
		JButton btnRAct = new JButton("==>");
		btnRAct.setAction(aRActive);
		btnRAct.addMouseListener(this);
		btnRAct.setBounds(96, 264, 65, 23);
		panelIN_1.add(btnRAct);
		
		textActiveNum = new JTextField();
		textActiveNum.setText("");
		textActiveNum.setHorizontalAlignment(SwingConstants.CENTER);
		textActiveNum.setEditable(false);
		textActiveNum.setColumns(10);
		textActiveNum.setBounds(49, 298, 86, 20);
		panelIN_1.add(textActiveNum);
		
		
		
		
		
	}
	
	/**
	 *  
	 *
	 * @throws InvalidObjectAttributeType the invalid object attribute type
	 * @throws InvalidTeamSize the invalid team size
	 */
	public void finishedWindow() throws InvalidObjectAttributeType, InvalidTeamSize {
		 enviroment.closePlayerSetupScreen(this);
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
			if (enviroment.getPlayerTeam().getActiveTeam().size() == 4) {
				try {
					finishedWindow();
				} catch (InvalidObjectAttributeType e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidTeamSize e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				textRequiredPlayers.setText("Atleast 4 Players Required to Start");
			}
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
			putValue(NAME, "<==");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			if (initialIndex == 0) {
				initialIndex = initialContestants.size() - 1;
			}
			else {
				initialIndex -= 1;
			}
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
			putValue(NAME, "==>");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			if (initialIndex == (initialContestants.size() - 1)) {
				initialIndex = 0;
			}
			else {
				initialIndex += 1;
			}
		}
	}
	
	/**
	 * The Class SwingAction_4.
	 */
	private class SwingAction_4 extends AbstractAction {
		
		/**
		 * Instantiates a new swing action 4.
		 */
		public SwingAction_4() {
			putValue(NAME, "<==");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			if (activeIndex == 0 && 0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
				activeIndex = enviroment.getPlayerTeam().getActiveTeam().size() - 1;
			}
			else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
				activeIndex -= 1;
			}
		}
	}
	
	/**
	 * The Class SwingAction_5.
	 */
	private class SwingAction_5 extends AbstractAction {
		
		/**
		 * Instantiates a new swing action 5.
		 */
		public SwingAction_5() {
			putValue(NAME, "==>");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			if (activeIndex == (enviroment.getPlayerTeam().getActiveTeam().size() - 1)) {
				activeIndex = 0;
			}
			else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())){
				activeIndex += 1;
			}
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
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			if (enviroment.getPlayerTeam().getActiveTeam().size() < 4 ){
					try {
						//enviroment.getPlayerTeam().modifyTotalFunds(-initialContestants.get(initialIndex).getValue());
						enviroment.getPlayerTeam().addActiveContestant(initialContestants.get(initialIndex));
				} 
					catch (InvalidTeamSize e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				
				initialContestants.remove(initialIndex);
				if (initialIndex == initialContestants.size() && initialIndex != 0) {
					initialIndex -= 1;
				}
			}
		}
	}
	
	/**
	 * The Class SwingAction_6.
	 */
	private class SwingAction_6 extends AbstractAction {
		
		/**
		 * Instantiates a new swing action 6.
		 */
		public SwingAction_6() {
			putValue(NAME, "Remove");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			if (enviroment.getPlayerTeam().getActiveTeam().size() > 0) {
				initialContestants.add(enviroment.getPlayerTeam().getActiveTeam().get(activeIndex));
				//enviroment.getPlayerTeam().modifyTotalFunds(enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getValue());
				enviroment.getPlayerTeam().removeActiveContestant(enviroment.getPlayerTeam().getActiveTeam().get(activeIndex));
				if (activeIndex == enviroment.getPlayerTeam().getActiveTeam().size() && activeIndex != 0) {
					activeIndex -= 1;
				}
			}
			
		}
	}

	/**
	 * Mouse clicked.
	 *
	 * @param e the e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		textNameVarIN.setText(""+initialContestants.get(initialIndex).getName());
		textOffenceVarIN.setText(""+initialContestants.get(initialIndex).getAttribute(ContestantAttribute.OFFENCE));
		textDefenceVarIN.setText(""+initialContestants.get(initialIndex).getAttribute(ContestantAttribute.DEFENCE));
		textStanimaVarIN.setText(""+initialContestants.get(initialIndex).getAttribute(ContestantAttribute.MAX_STANIMA));
		textModifiersVarIN.setText(""+initialContestants.get(initialIndex).getModifiers());
		textCostVarIN.setText(""+initialContestants.get(initialIndex).getValue());
		txtInitialNum.setText(""+(initialIndex+1));
		if (enviroment.getPlayerTeam().getActiveTeam().size() < 1) {
			textNameVarAct.setText("");
			textOffenceVarAct.setText("");
			textDefenceVarAct.setText("");
			textStanimaVarAct.setText("");
			textModifiersVarAct.setText("");
			textCostVarAct.setText("");
			textActiveNum.setText("");
		}
		else {
		textNameVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getName());
		textOffenceVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttribute(ContestantAttribute.OFFENCE));
		textDefenceVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttribute(ContestantAttribute.DEFENCE));
		textStanimaVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttribute(ContestantAttribute.MAX_STANIMA));
		textModifiersVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getModifiers());
		textCostVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getValue());
		textActiveNum.setText(""+(activeIndex+1));
		}
		textMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		textAfford.setText("");
		textRequiredPlayers.setText("");
		//initialContestants.get(initialIndex).setName(textNameVarIN.getText());
		//enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).setName(textNameVarAct.getText());
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (textNameVarIN.getText() != "" && textNameVarAct.getText() != "") {
			initialContestants.get(initialIndex).setName(textNameVarIN.getText());
			if (enviroment.getPlayerTeam().getActiveTeam().size() != 0) {
				enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).setName(textNameVarAct.getText());
			}
		}
		
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
