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

public class PlayerSetupScreen implements MouseListener, ActionListener {

	private JFrame frmPlayersetupscreen;
	private GameEnviroment enviroment;
	private JTextField textNameIN;
	private JTextField textOffenceIN;
	private JTextField textPositionIN;
	private JTextField textNameVarIN;
	private JTextField textModifiersIN;
	private JTextField textDefenceIN;
	private JTextField textStanimaIN;
	private JTextField textOffenceVarIN;
	private JTextField textDefenceVarIN;
	private JTextField textStanimaVarIN;
	private JTextField textPositionVarIN;
	private JTextField textModifiersVarIN;
	private JTextField textCostIN;
	private JTextField textCostVarIN;
	private JButton btnAccept;
	
	private JTextField textNameAct;
	private JTextField textOffenceAct;
	private JTextField textPositionAct;
	private JTextField textNameVarAct;
	private JTextField textModifiersAct;
	private JTextField textDefenceAct;
	private JTextField textStanimaAct;
	private JTextField textOffenceVarAct;
	private JTextField textDefenceVarAct;
	private JTextField textStanimaVarAct;
	private JTextField textPositionVarAct;
	private JTextField textModifiersVarAct;
	private JTextField textCostAct;
	private JTextField textCostVarAct;
	private JTextField textActiveNum;
	
	private final Action Accept = new SwingAction();
	private JTextField textMoney;
	
	ArrayList<Contestant> initialContestants = new ArrayList<Contestant>();
	private int initialIndex = 0;
	private int activeIndex = 0;
	private final Action aLInitial = new SwingAction_2();
	private JTextField txtInitialNum;
	private JButton btnRIN;
	private final Action aRInitial = new SwingAction_3();
	private final Action AddIN = new SwingAction_1();
	private final Action aLActive = new SwingAction_4();
	private final Action aRActive = new SwingAction_5();
	private final Action RemoveAct = new SwingAction_6();
	private JTextField textAfford;
	private JTextField textRequiredPlayers;

	
	public PlayerSetupScreen(GameEnviroment incomingEnviroment) throws InvalidObjectAttributeType {
		enviroment = incomingEnviroment;
		for(int i=0; i<15; i++){
            Contestant randContestant = Utils.generateRandomContestant(enviroment.getRandom());
            initialContestants.add(randContestant);
        }
		for(int i = 0; i < initialContestants.size(); i++) {   
		    System.out.print(initialContestants.get(i));
		} 
		initialize();
		frmPlayersetupscreen.setVisible(true);
	}
	
	public void closeWindow() {
		frmPlayersetupscreen.dispose();
	}
	/**
	 * Launch the application.
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
		
		textPositionIN = new JTextField();
		textPositionIN.setText("Position:");
		textPositionIN.setEditable(false);
		textPositionIN.setColumns(10);
		textPositionIN.setBounds(10, 126, 76, 20);
		panelIN.add(textPositionIN);
		
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
		textModifiersIN.setBounds(10, 157, 76, 20);
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
		textOffenceVarIN.setText(""+initialContestants.get(initialIndex).getAttributes(ContestantAttribute.OFFENCE));
		textOffenceVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceVarIN.setEditable(false);
		textOffenceVarIN.setColumns(10);
		textOffenceVarIN.setBounds(96, 42, 86, 20);
		panelIN.add(textOffenceVarIN);
		
		textDefenceVarIN = new JTextField();
		textDefenceVarIN.setText(""+initialContestants.get(initialIndex).getAttributes(ContestantAttribute.DEFENCE));
		textDefenceVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceVarIN.setEditable(false);
		textDefenceVarIN.setColumns(10);
		textDefenceVarIN.setBounds(96, 68, 86, 20);
		panelIN.add(textDefenceVarIN);
		
		textStanimaVarIN = new JTextField();
		textStanimaVarIN.setText(""+initialContestants.get(initialIndex).getAttributes(ContestantAttribute.STANIMA));
		textStanimaVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaVarIN.setEditable(false);
		textStanimaVarIN.setColumns(10);
		textStanimaVarIN.setBounds(96, 93, 86, 20);
		panelIN.add(textStanimaVarIN);
		
		textPositionVarIN = new JTextField();
		textPositionVarIN.setText(""+initialContestants.get(initialIndex).getPosition());
		textPositionVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textPositionVarIN.setEditable(false);
		textPositionVarIN.setColumns(10);
		textPositionVarIN.setBounds(96, 126, 86, 20);
		panelIN.add(textPositionVarIN);
		
		textModifiersVarIN = new JTextField();
		textModifiersVarIN.setHorizontalAlignment(SwingConstants.RIGHT);
		textModifiersVarIN.setText(""+initialContestants.get(initialIndex).getModifiers());
		textModifiersVarIN.setEditable(false);
		textModifiersVarIN.setColumns(10);
		textModifiersVarIN.setBounds(96, 157, 86, 38);
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
		txtInitialNum.setText(""+initialIndex);
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
		
		textPositionAct = new JTextField();
		textPositionAct.setText("Position:");
		textPositionAct.setEditable(false);
		textPositionAct.setColumns(10);
		textPositionAct.setBounds(10, 126, 76, 20);
		panelIN_1.add(textPositionAct);
		
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
		textModifiersAct.setBounds(10, 157, 76, 20);
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
		
		textPositionVarAct = new JTextField();
		textPositionVarAct.setText("");
		textPositionVarAct.setHorizontalAlignment(SwingConstants.RIGHT);
		textPositionVarAct.setEditable(false);
		textPositionVarAct.setColumns(10);
		textPositionVarAct.setBounds(96, 126, 86, 20);
		panelIN_1.add(textPositionVarAct);
		
		textModifiersVarAct = new JTextField();
		textModifiersVarAct.setText("");
		textModifiersVarAct.setHorizontalAlignment(SwingConstants.RIGHT);
		textModifiersVarAct.setEditable(false);
		textModifiersVarAct.setColumns(10);
		textModifiersVarAct.setBounds(96, 157, 86, 38);
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
	public void finishedWindow() {
		 enviroment.closePlayerSetupScreen(this);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Accept");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (enviroment.getPlayerTeam().getActiveTeam().size() == 4) {
				finishedWindow();
			}
			else {
				textRequiredPlayers.setText("Atleast 4 Players Required to Start");
			}
		}
	}
	
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "<==");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (initialIndex == 0) {
				initialIndex = initialContestants.size() - 1;
			}
			else {
				initialIndex -= 1;
			}
		}
	}
	
	private class SwingAction_3 extends AbstractAction {

		public SwingAction_3() {
			putValue(NAME, "==>");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (initialIndex == (initialContestants.size() - 1)) {
				initialIndex = 0;
			}
			else {
				initialIndex += 1;
			}
		}
	}
	
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "<==");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (activeIndex == 0 && 0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
				activeIndex = enviroment.getPlayerTeam().getActiveTeam().size() - 1;
			}
			else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
				activeIndex -= 1;
			}
		}
	}
	
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "==>");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (activeIndex == (enviroment.getPlayerTeam().getActiveTeam().size() - 1)) {
				activeIndex = 0;
			}
			else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())){
				activeIndex += 1;
			}
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (enviroment.getPlayerTeam().getActiveTeam().size() < 4 ){
				if (enviroment.getPlayerTeam().getTotalFunds() < initialContestants.get(initialIndex).getValue())  {
					textAfford.setText("Insufficient Funds");
				}
				else {
					try {
						enviroment.getPlayerTeam().modifyTotalFunds(-initialContestants.get(initialIndex).getValue());
						enviroment.getPlayerTeam().addActiveContestant(initialContestants.get(initialIndex));
				} 
					catch (InvalidTeamSize e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
				
				initialContestants.remove(initialIndex);
				if (initialIndex == initialContestants.size() && initialIndex != 0) {
					initialIndex -= 1;
				}
			}
		}
	}
	
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Remove");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (enviroment.getPlayerTeam().getActiveTeam().size() > 0) {
				initialContestants.add(enviroment.getPlayerTeam().getActiveTeam().get(activeIndex));
				enviroment.getPlayerTeam().modifyTotalFunds(enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getValue());
				enviroment.getPlayerTeam().removeActiveContestant(enviroment.getPlayerTeam().getActiveTeam().get(activeIndex));
				if (activeIndex == enviroment.getPlayerTeam().getActiveTeam().size() && activeIndex != 0) {
					activeIndex -= 1;
				}
			}
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		textNameVarIN.setText(""+initialContestants.get(initialIndex).getName());
		textOffenceVarIN.setText(""+initialContestants.get(initialIndex).getAttributes(ContestantAttribute.OFFENCE));
		textDefenceVarIN.setText(""+initialContestants.get(initialIndex).getAttributes(ContestantAttribute.DEFENCE));
		textStanimaVarIN.setText(""+initialContestants.get(initialIndex).getAttributes(ContestantAttribute.STANIMA));
		textPositionVarIN.setText(""+initialContestants.get(initialIndex).getPosition());
		textModifiersVarIN.setText(""+initialContestants.get(initialIndex).getModifiers());
		textCostVarIN.setText(""+initialContestants.get(initialIndex).getValue());
		txtInitialNum.setText(""+initialIndex);
		if (enviroment.getPlayerTeam().getActiveTeam().size() < 1) {
			textNameVarAct.setText("");
			textOffenceVarAct.setText("");
			textDefenceVarAct.setText("");
			textStanimaVarAct.setText("");
			textPositionVarAct.setText("");
			textModifiersVarAct.setText("");
			textCostVarAct.setText("");
			textActiveNum.setText("");
		}
		else {
		textNameVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getName());
		textOffenceVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttributes(ContestantAttribute.OFFENCE));
		textDefenceVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttributes(ContestantAttribute.DEFENCE));
		textStanimaVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttributes(ContestantAttribute.STANIMA));
		textPositionVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getPosition());
		textModifiersVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getModifiers());
		textCostVarAct.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getValue());
		textActiveNum.setText(""+activeIndex);
		}
		textMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		textAfford.setText("");
		textRequiredPlayers.setText("");
		//initialContestants.get(initialIndex).setName(textNameVarIN.getText());
		//enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).setName(textNameVarAct.getText());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (textNameVarIN.getText() != "" && textNameVarAct.getText() != "") {
			initialContestants.get(initialIndex).setName(textNameVarIN.getText());
			if (enviroment.getPlayerTeam().getActiveTeam().size() != 0) {
				enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).setName(textNameVarAct.getText());
			}
		}
		
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
