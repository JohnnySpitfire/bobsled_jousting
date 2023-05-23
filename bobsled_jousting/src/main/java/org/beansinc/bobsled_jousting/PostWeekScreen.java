package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.beansinc.bobsled_jousting.BSExceptions.ContestantNotFound;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JCheckBox;

public class PostWeekScreen implements MouseListener{

	private GameEnviroment enviroment;
	private JFrame frmPostweek;
	private JTextField textName;
	private JTextField textNameVar;
	private JTextField textStanima;
	private JTextField textStanimaVar;
	private JTextField textIndex;
	private JTextField textOutcome;
	private JTextField textTeamName;
	private JTextField txtTeamMoney;
	private JTextField textScore;
	private JTextField textMaxStanimaVar;
	private JTextField textMaxStanima;
	private JButton btnContinue;
	private JTextField textOffenceQuit;
	private JTextField textDefenceQuit;
	private JTextField textStanimaQuit;
	private JTextField textOffenceQuitVar;
	private JTextField textDenfenceQuitVar;
	private JTextField textStanimaQuitVar;
	private JTextField textNameQuit;
	private JTextField textOffenceOld;
	private JTextField textDefenceOld;
	private JTextField textStanimaOld;
	private JTextField textOffenceOldVar;
	private JTextField textDefenceOldVar;
	private JTextField textStanimaOldVar;
	private JTextField textNameOld;
	private JPanel panelNew;
	private JTextField textOffenceNew;
	private JTextField textDefenceNew;
	private JTextField textStanimaNew;
	private JTextField textOffenceNewVar;
	private JTextField textDefenceNewVar;
	private JTextField textStanimaNewVar;
	private JTextField textNameNew;

	private int index = 0;
	
	private Contestant playerQuit;
	private ArrayList<Contestant[]> leveledUp;
	private int levelUpIndex = 0;
	private int selectIndex = 0;
	private JPanel panelOld;
	private JPanel panelSelect;
	private JTextField textOffenceSelect;
	private JTextField textDefenceSelect;
	private JTextField textStanimaSelect;
	private JTextField textOffenceSelectVar;
	private JTextField textDefenceSelectVar;
	private JTextField textStanimaSelectVar;
	private JTextField textNameSelect;
	private JTextField textQuit;
	private JTextField textUpgrade;
	private JTextField textLeveledUp;
	private JButton btnLeftSelect;
	private JButton btnRightSelect;
	private JButton btnSelectToUpgrade;
	private JButton btnRightLeveledUp;
	private JButton btnLeftLeveledUp;
	
	
	public PostWeekScreen(GameEnviroment incomingEnviroment) throws InvalidObjectAttributeType, ContestantNotFound, InvalidTeamSize {
		enviroment = incomingEnviroment;
		initialize();
		frmPostweek.setVisible(true);
	}
	
	public void closeWindow() {
		frmPostweek.dispose();
	}
	
	public void finishedWindow() throws InvalidObjectAttributeType, InvalidTeamSize {
		 enviroment.closePostWeekScreen(this);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostWeekScreen window = new PostWeekScreen();
					window.frmPostweek.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InvalidTeamSize 
	 * @throws ContestantNotFound 
	 * @throws InvalidObjectAttributeType 
	 */
	public PostWeekScreen() throws InvalidObjectAttributeType, ContestantNotFound, InvalidTeamSize {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InvalidTeamSize 
	 * @throws ContestantNotFound 
	 * @throws InvalidObjectAttributeType 
	 */
	private void initialize() throws InvalidObjectAttributeType, ContestantNotFound, InvalidTeamSize {
		
		
		frmPostweek = new JFrame();
		frmPostweek.setTitle("PostWeek");
		frmPostweek.setBounds(100, 100, 685, 488);
		frmPostweek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPostweek.getContentPane().setLayout(null);
		
		textTeamName = new JTextField();
		textTeamName.setText(""+enviroment.getPlayerTeam().getName());
		textTeamName.setEditable(false);
		textTeamName.setBounds(10, 11, 86, 20);
		frmPostweek.getContentPane().add(textTeamName);
		textTeamName.setColumns(10);
		
		txtTeamMoney = new JTextField();
		txtTeamMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTeamMoney.setEditable(false);
		txtTeamMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		txtTeamMoney.setBounds(573, 11, 86, 20);
		frmPostweek.getContentPane().add(txtTeamMoney);
		txtTeamMoney.setColumns(10);
		
		btnContinue = new JButton("CONTINUE");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnContinue.setBounds(233, 379, 170, 40);
		frmPostweek.getContentPane().add(btnContinue);
		
		
		if (enviroment.getPlayedMatch()) {
			JPanel panelTeam = new JPanel();
			panelTeam.setLayout(null);
			panelTeam.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			panelTeam.setBounds(219, 170, 212, 162);
			frmPostweek.getContentPane().add(panelTeam);
			
			
			
			textName = new JTextField();
			textName.setText("Name:");
			textName.setEditable(false);
			textName.setColumns(10);
			textName.setBounds(10, 11, 87, 20);
			panelTeam.add(textName);
			
			textNameVar = new JTextField();
			textNameVar.setEditable(false);
			textNameVar.setHorizontalAlignment(SwingConstants.CENTER);
			textNameVar.setColumns(10);
			textNameVar.setBounds(98, 11, 104, 20);
			panelTeam.add(textNameVar);
			
			textStanima = new JTextField();
			textStanima.setText("STANIMA:");
			textStanima.setEditable(false);
			textStanima.setColumns(10);
			textStanima.setBounds(10, 42, 87, 20);
			panelTeam.add(textStanima);
			
			textStanimaVar = new JTextField();
			textStanimaVar.setHorizontalAlignment(SwingConstants.RIGHT);
			textStanimaVar.setEditable(false);
			textStanimaVar.setColumns(10);
			textStanimaVar.setBounds(98, 42, 104, 20);
			panelTeam.add(textStanimaVar);
			
			JButton btnLeft = new JButton("<==");
			btnLeft.addMouseListener(this);
			btnLeft.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (index == 0 && 0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
						index = enviroment.getPlayerTeam().getActiveTeam().size() - 1;
					}
					else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
						index -= 1;
					}
				}
			});
			btnLeft.setBounds(40, 97, 57, 23);
			panelTeam.add(btnLeft);
			
			JButton btnRight = new JButton("==>");
			btnRight.addMouseListener(this);
			btnRight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (index == (enviroment.getPlayerTeam().getActiveTeam().size() - 1)) {
						index = 0;
					}
					else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())){
						index += 1;
					}
				}
			});
			btnRight.setBounds(107, 97, 65, 23);
			panelTeam.add(btnRight);
			
			textIndex = new JTextField();
			textIndex.setHorizontalAlignment(SwingConstants.CENTER);
			textIndex.setEditable(false);
			textIndex.setColumns(10);
			textIndex.setBounds(61, 131, 86, 20);
			panelTeam.add(textIndex);
			
			textMaxStanimaVar = new JTextField();
			textMaxStanimaVar.setHorizontalAlignment(SwingConstants.RIGHT);
			textMaxStanimaVar.setEditable(false);
			textMaxStanimaVar.setColumns(10);
			textMaxStanimaVar.setBounds(98, 66, 104, 20);
			panelTeam.add(textMaxStanimaVar);
			
			textMaxStanima = new JTextField();
			textMaxStanima.setText("MAX STANIMA:");
			textMaxStanima.setEditable(false);
			textMaxStanima.setColumns(10);
			textMaxStanima.setBounds(10, 66, 87, 20);
			panelTeam.add(textMaxStanima);
			
			textOutcome = new JTextField();
			textOutcome.setEditable(false);
			textOutcome.setHorizontalAlignment(SwingConstants.CENTER);
			textOutcome.setBounds(223, 11, 192, 40);
			frmPostweek.getContentPane().add(textOutcome);
			textOutcome.setColumns(10);
			
			textScore = new JTextField();
			textScore.setHorizontalAlignment(SwingConstants.CENTER);
			textScore.setEditable(false);
			textScore.setColumns(10);
			textScore.setBounds(233, 62, 170, 28);
			frmPostweek.getContentPane().add(textScore);
		}else{
			
		playerQuit = enviroment.getPlayerTeam().randomContestantQuit(enviroment.getDifficulty());
		leveledUp = enviroment.getPlayerTeam().randomContestantStatIncrease(enviroment.getDifficulty());
		enviroment.getPlayerTeam().onWeekEnd();
		panelOld = new JPanel();
		panelOld.setLayout(null);
		panelOld.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelOld.setBackground(SystemColor.menu);
		panelOld.setBounds(135, 42, 192, 140);
		frmPostweek.getContentPane().add(panelOld);
		
		textOffenceOld = new JTextField();
		textOffenceOld.setText("OFFENCE:");
		textOffenceOld.setEditable(false);
		textOffenceOld.setColumns(10);
		textOffenceOld.setBounds(10, 43, 76, 20);
		panelOld.add(textOffenceOld);
		
		textDefenceOld = new JTextField();
		textDefenceOld.setText("DEFENCE:");
		textDefenceOld.setEditable(false);
		textDefenceOld.setColumns(10);
		textDefenceOld.setBounds(10, 74, 76, 20);
		panelOld.add(textDefenceOld);
		
		textStanimaOld = new JTextField();
		textStanimaOld.setText("STANIMA:");
		textStanimaOld.setEditable(false);
		textStanimaOld.setColumns(10);
		textStanimaOld.setBounds(10, 105, 76, 20);
		panelOld.add(textStanimaOld);
		
		textOffenceOldVar = new JTextField();
		textOffenceOldVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceOldVar.setEditable(false);
		textOffenceOldVar.setColumns(10);
		textOffenceOldVar.setBounds(96, 43, 86, 20);
		panelOld.add(textOffenceOldVar);
		
		textDefenceOldVar = new JTextField();
		textDefenceOldVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceOldVar.setEditable(false);
		textDefenceOldVar.setColumns(10);
		textDefenceOldVar.setBounds(96, 74, 86, 20);
		panelOld.add(textDefenceOldVar);
		
		textStanimaOldVar = new JTextField();
		textStanimaOldVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaOldVar.setEditable(false);
		textStanimaOldVar.setColumns(10);
		textStanimaOldVar.setBounds(96, 105, 86, 20);
		panelOld.add(textStanimaOldVar);
		
		textNameOld = new JTextField();
		textNameOld.setHorizontalAlignment(SwingConstants.CENTER);
		textNameOld.setEditable(false);
		textNameOld.setColumns(10);
		textNameOld.setBounds(10, 11, 172, 20);
		panelOld.add(textNameOld);
		
		panelNew = new JPanel();
		panelNew.setLayout(null);
		panelNew.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelNew.setBackground(SystemColor.menu);
		panelNew.setBounds(326, 42, 192, 140);
		frmPostweek.getContentPane().add(panelNew);
		
		textOffenceNew = new JTextField();
		textOffenceNew.setText("OFFENCE:");
		textOffenceNew.setEditable(false);
		textOffenceNew.setColumns(10);
		textOffenceNew.setBounds(10, 43, 76, 20);
		panelNew.add(textOffenceNew);
		
		textDefenceNew = new JTextField();
		textDefenceNew.setText("DEFENCE:");
		textDefenceNew.setEditable(false);
		textDefenceNew.setColumns(10);
		textDefenceNew.setBounds(10, 74, 76, 20);
		panelNew.add(textDefenceNew);
		
		textStanimaNew = new JTextField();
		textStanimaNew.setText("STANIMA:");
		textStanimaNew.setEditable(false);
		textStanimaNew.setColumns(10);
		textStanimaNew.setBounds(10, 105, 76, 20);
		panelNew.add(textStanimaNew);
		
		textOffenceNewVar = new JTextField();
		textOffenceNewVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceNewVar.setEditable(false);
		textOffenceNewVar.setColumns(10);
		textOffenceNewVar.setBounds(96, 43, 86, 20);
		panelNew.add(textOffenceNewVar);
		
		textDefenceNewVar = new JTextField();
		textDefenceNewVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceNewVar.setEditable(false);
		textDefenceNewVar.setColumns(10);
		textDefenceNewVar.setBounds(96, 74, 86, 20);
		panelNew.add(textDefenceNewVar);
		
		textStanimaNewVar = new JTextField();
		textStanimaNewVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaNewVar.setEditable(false);
		textStanimaNewVar.setColumns(10);
		textStanimaNewVar.setBounds(96, 105, 86, 20);
		panelNew.add(textStanimaNewVar);
		
		textNameNew = new JTextField();
		textNameNew.setHorizontalAlignment(SwingConstants.CENTER);
		textNameNew.setEditable(false);
		textNameNew.setColumns(10);
		textNameNew.setBounds(10, 11, 172, 20);
		panelNew.add(textNameNew);
		
		btnLeftLeveledUp = new JButton("<==");
		btnLeftLeveledUp.addMouseListener(this);
		btnLeftLeveledUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (levelUpIndex == 0 && 0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
					levelUpIndex = enviroment.getPlayerTeam().getActiveTeam().size() - 1;
				}
				else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
					levelUpIndex -= 1;
				}
			}
		});
		btnLeftLeveledUp.setBounds(262, 193, 65, 23);
		frmPostweek.getContentPane().add(btnLeftLeveledUp);
		
		btnRightLeveledUp = new JButton("==>");
		btnRightLeveledUp.addMouseListener(this);
		btnRightLeveledUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (levelUpIndex == (enviroment.getPlayerTeam().getActiveTeam().size() - 1)) {
					levelUpIndex = 0;
				}
				else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())){
					levelUpIndex += 1;
				}
			}
		});
		btnRightLeveledUp.setBounds(326, 193, 65, 23);
		frmPostweek.getContentPane().add(btnRightLeveledUp);
		
		if (leveledUp.size() < 2) {
			btnRightLeveledUp.setVisible(false);
			btnLeftLeveledUp.setVisible(false);
		}
		
		panelSelect = new JPanel();
		panelSelect.setLayout(null);
		panelSelect.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelSelect.setBackground(SystemColor.menu);
		panelSelect.setBounds(467, 220, 192, 186);
		frmPostweek.getContentPane().add(panelSelect);
		
		textOffenceSelect = new JTextField();
		textOffenceSelect.setText("OFFENCE:");
		textOffenceSelect.setEditable(false);
		textOffenceSelect.setColumns(10);
		textOffenceSelect.setBounds(10, 43, 76, 20);
		panelSelect.add(textOffenceSelect);
		
		textDefenceSelect = new JTextField();
		textDefenceSelect.setText("DEFENCE:");
		textDefenceSelect.setEditable(false);
		textDefenceSelect.setColumns(10);
		textDefenceSelect.setBounds(10, 74, 76, 20);
		panelSelect.add(textDefenceSelect);
		
		textStanimaSelect = new JTextField();
		textStanimaSelect.setText("STANIMA:");
		textStanimaSelect.setEditable(false);
		textStanimaSelect.setColumns(10);
		textStanimaSelect.setBounds(10, 105, 76, 20);
		panelSelect.add(textStanimaSelect);
		
		textOffenceSelectVar = new JTextField();
		textOffenceSelectVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceSelectVar.setEditable(false);
		textOffenceSelectVar.setColumns(10);
		textOffenceSelectVar.setBounds(96, 43, 86, 20);
		panelSelect.add(textOffenceSelectVar);
		
		textDefenceSelectVar = new JTextField();
		textDefenceSelectVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceSelectVar.setEditable(false);
		textDefenceSelectVar.setColumns(10);
		textDefenceSelectVar.setBounds(96, 74, 86, 20);
		panelSelect.add(textDefenceSelectVar);
		
		textStanimaSelectVar = new JTextField();
		textStanimaSelectVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaSelectVar.setEditable(false);
		textStanimaSelectVar.setColumns(10);
		textStanimaSelectVar.setBounds(96, 105, 86, 20);
		panelSelect.add(textStanimaSelectVar);
		
		textNameSelect = new JTextField();
		textNameSelect.setHorizontalAlignment(SwingConstants.CENTER);
		textNameSelect.setEditable(false);
		textNameSelect.setColumns(10);
		textNameSelect.setBounds(10, 11, 172, 20);
		panelSelect.add(textNameSelect);
		
		btnLeftSelect = new JButton("<==");
		btnLeftSelect.addMouseListener(this);
		btnLeftSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectIndex == 0 && 0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
					selectIndex = enviroment.getPlayerTeam().getActiveTeam().size() - 1;
				}
				else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
					selectIndex -= 1;
				}
			}
		});
		btnLeftSelect.setBounds(32, 125, 65, 23);
		panelSelect.add(btnLeftSelect);
		
		btnRightSelect = new JButton("==>");
		btnRightSelect.addMouseListener(this);
		btnRightSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectIndex == (enviroment.getPlayerTeam().getActiveTeam().size() - 1)) {
					selectIndex = 0;
				}
				else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())){
					selectIndex += 1;
				}
			}
		});
		btnRightSelect.setBounds(96, 125, 65, 23);
		panelSelect.add(btnRightSelect);
		
		btnSelectToUpgrade = new JButton("Select to Upgrade");
		btnSelectToUpgrade.addMouseListener(this);
		btnSelectToUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviroment.getPlayerTeam().trainContestant(enviroment.getPlayerTeam().getActiveTeam().get(selectIndex));
				panelSelect.setVisible(false);
				textUpgrade.setVisible(false);
			}
		});
		btnSelectToUpgrade.setBounds(10, 152, 172, 23);
		panelSelect.add(btnSelectToUpgrade);
		
		JPanel panelQuit = new JPanel();
		panelQuit.setBounds(10, 220, 192, 140);
		frmPostweek.getContentPane().add(panelQuit);
		panelQuit.setLayout(null);
		panelQuit.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelQuit.setBackground(SystemColor.menu);
		
		textOffenceQuit = new JTextField();
		textOffenceQuit.setText("OFFENCE:");
		textOffenceQuit.setEditable(false);
		textOffenceQuit.setColumns(10);
		textOffenceQuit.setBounds(10, 43, 76, 20);
		panelQuit.add(textOffenceQuit);
		
		textDefenceQuit = new JTextField();
		textDefenceQuit.setText("DEFENCE:");
		textDefenceQuit.setEditable(false);
		textDefenceQuit.setColumns(10);
		textDefenceQuit.setBounds(10, 74, 76, 20);
		panelQuit.add(textDefenceQuit);
		
		textStanimaQuit = new JTextField();
		textStanimaQuit.setText("STANIMA:");
		textStanimaQuit.setEditable(false);
		textStanimaQuit.setColumns(10);
		textStanimaQuit.setBounds(10, 105, 76, 20);
		panelQuit.add(textStanimaQuit);
		
		textOffenceQuitVar = new JTextField();
		textOffenceQuitVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceQuitVar.setEditable(false);
		textOffenceQuitVar.setColumns(10);
		textOffenceQuitVar.setBounds(96, 43, 86, 20);
		panelQuit.add(textOffenceQuitVar);
		
		textDenfenceQuitVar = new JTextField();
		textDenfenceQuitVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDenfenceQuitVar.setEditable(false);
		textDenfenceQuitVar.setColumns(10);
		textDenfenceQuitVar.setBounds(96, 74, 86, 20);
		panelQuit.add(textDenfenceQuitVar);
		
		textStanimaQuitVar = new JTextField();
		textStanimaQuitVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaQuitVar.setEditable(false);
		textStanimaQuitVar.setColumns(10);
		textStanimaQuitVar.setBounds(96, 105, 86, 20);
		panelQuit.add(textStanimaQuitVar);
		
		textNameQuit = new JTextField();
		textNameQuit.setHorizontalAlignment(SwingConstants.CENTER);
		textNameQuit.setEditable(false);
		textNameQuit.setColumns(10);
		textNameQuit.setBounds(10, 11, 172, 20);
		panelQuit.add(textNameQuit);
		
		textQuit = new JTextField();
		textQuit.setEditable(false);
		textQuit.setHorizontalAlignment(SwingConstants.CENTER);
		textQuit.setBounds(10, 194, 192, 20);
		frmPostweek.getContentPane().add(textQuit);
		textQuit.setColumns(10);
		
		textUpgrade = new JTextField();
		textUpgrade.setHorizontalAlignment(SwingConstants.CENTER);
		textUpgrade.setText("Select a Player to  Upgrade");
		textUpgrade.setEditable(false);
		textUpgrade.setBounds(467, 193, 192, 20);
		frmPostweek.getContentPane().add(textUpgrade);
		textUpgrade.setColumns(10);
		
		textLeveledUp = new JTextField();
		textLeveledUp.setHorizontalAlignment(SwingConstants.CENTER);
		textLeveledUp.setEditable(false);
		textLeveledUp.setBounds(233, 11, 192, 20);
		frmPostweek.getContentPane().add(textLeveledUp);
		textLeveledUp.setColumns(10);
			
		}
		
		
		
		mouseClicked(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (enviroment.getPlayedMatch()) {
			textScore.setText("Current Score: "+enviroment.getPlayerTeam().getScore());
			if (enviroment.getMatchOutcome()) {
				textOutcome.setText("YOU WON!");
			}else {
				textOutcome.setText("YOU LOST!");
			}
			textNameVar.setText("" + enviroment.getPlayerTeam().getActiveTeam().get(index).getName());
			textStanimaVar.setText("" + enviroment.getPlayerTeam().getActiveTeam().get(index).getAttribute(ContestantAttribute.STANIMA));
			textMaxStanimaVar.setText("" + enviroment.getPlayerTeam().getActiveTeam().get(index).getAttribute(ContestantAttribute.MAX_STANIMA));
			textIndex.setText(""+(index + 1));
		}else {
			if(playerQuit.getName() == "null") {
				textNameQuit.setText("");
				textOffenceQuitVar.setText("");
				textDenfenceQuitVar.setText("");
				textStanimaQuitVar.setText("");
				textQuit.setText("No Leaving Players");
			}else {
				textNameQuit.setText(playerQuit.getName() + "'s Stats");
				textOffenceQuitVar.setText("" + playerQuit.getAttribute(ContestantAttribute.OFFENCE));
				textDenfenceQuitVar.setText("" + playerQuit.getAttribute(ContestantAttribute.DEFENCE));
				textStanimaQuitVar.setText("" + playerQuit.getAttribute(ContestantAttribute.STANIMA));
				textQuit.setText("Player Who Has Left The Team:");
			}
			
			textNameSelect.setText(enviroment.getPlayerTeam().getActiveTeam().get(selectIndex).getName() + "'s Stats");
			textOffenceSelectVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(selectIndex).getAttribute(ContestantAttribute.OFFENCE));
			textDefenceSelectVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(selectIndex).getAttribute(ContestantAttribute.DEFENCE));
			textStanimaSelectVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(selectIndex).getAttribute(ContestantAttribute.STANIMA));

			
			if (leveledUp.size() != 0) {
				textNameOld.setText(leveledUp.get(levelUpIndex)[1].getName() + "'s Old Stats");
				textOffenceOldVar.setText("" + leveledUp.get(levelUpIndex)[1].getAttribute(ContestantAttribute.OFFENCE));
				textDefenceOldVar.setText("" + leveledUp.get(levelUpIndex)[1].getAttribute(ContestantAttribute.DEFENCE));
				textStanimaOldVar.setText("" + leveledUp.get(levelUpIndex)[1].getAttribute(ContestantAttribute.STANIMA));
				textNameNew.setText(leveledUp.get(levelUpIndex)[0].getName() + "'s New Stats");
				textOffenceNewVar.setText("" + leveledUp.get(levelUpIndex)[0].getAttribute(ContestantAttribute.OFFENCE));
				textDefenceNewVar.setText("" + leveledUp.get(levelUpIndex)[0].getAttribute(ContestantAttribute.DEFENCE));
				textStanimaNewVar.setText("" + leveledUp.get(levelUpIndex)[0].getAttribute(ContestantAttribute.STANIMA));
				textLeveledUp.setText("Leveled Up players");
			}else {
				textNameOld.setText("");
				textOffenceOldVar.setText("");
				textDefenceOldVar.setText("");
				textStanimaOldVar.setText("");
				textNameNew.setText("");
				textOffenceNewVar.setText("");
				textDefenceNewVar.setText("");
				textStanimaNewVar.setText("");
				textLeveledUp.setText("No Leveled Up Players");
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
