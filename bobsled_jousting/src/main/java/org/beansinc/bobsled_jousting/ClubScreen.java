package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import org.beansinc.bobsled_jousting.BSExceptions.InvalidTeamSize;
import org.beansinc.bobsled_jousting.BSExceptions.ItemNotFound;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.SystemColor;

public class ClubScreen implements MouseListener, ActionListener {

	private JFrame frmClub;
	private JTextField textName;
	private GameEnviroment enviroment;
	private JTextField textMoney;
	private JPanel panelAct;
	private JTextField textNameAct;
	private JTextField textOffenceAct;
	private JTextField textNameActVar;
	private JTextField textModifiersAct;
	private JTextField textDefenceAct;
	private JTextField textStanimaAct;
	private JTextField textOffenceActVar;
	private JTextField textDefenceActVar;
	private JTextField textStanimaActVar;
	private JTextField textModifiersActVar;
	private JTextField textCostAct;
	private JTextField textCostActVar;
	private JButton btnLAct;
	private JButton btnRAct;
	private JTextField textActiveIndex;
	
	private JPanel panelAct_1;
	private JTextField textNameRes;
	private JTextField textOffenceRes;
	private JTextField textNameResVar;
	private JTextField textModifiersRes;
	private JTextField textDefenceRes;
	private JTextField textStanimaRes;
	private JTextField textOffenceResVar;
	private JTextField textDefenceResVar;
	private JTextField textStanimaResVar;
	private JTextField textModifiersResVar;
	private JTextField textCostRes;
	private JTextField textCostResVar;
	private JButton btnSellRes;
	private JButton btnLRes;
	private JButton btnRRes;
	private JTextField textReserveIndex;
	private JTextField txtResState;
	private JTextField txtActState;
	
	private int activeIndex = 0;
	private int reserveIndex = 0;
	private JButton btnSwapAct;

	
	public ClubScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmClub.setVisible(true);
	}
	
	public void closeWindow() {
		frmClub.dispose();
	}
	public void finishedWindow() {
		enviroment.closeClubScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubScreen window = new ClubScreen();
					window.frmClub.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClubScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClub = new JFrame();
		frmClub.setTitle("Club");
		frmClub.setBounds(100, 100, 685, 488);
		frmClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClub.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnBack.setBounds(570, 415, 89, 23);
		frmClub.getContentPane().add(btnBack);
		
		textName = new JTextField();
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setText(""+enviroment.getPlayerTeam().getName());
		textName.setEditable(false);
		textName.setBounds(10, 11, 86, 20);
		frmClub.getContentPane().add(textName);
		textName.setColumns(10);
		
		textMoney = new JTextField();
		textMoney.setHorizontalAlignment(SwingConstants.CENTER);
		textMoney.setEditable(false);
		textMoney.setBounds(573, 11, 86, 20);
		frmClub.getContentPane().add(textMoney);
		textMoney.setColumns(10);
		
		panelAct = new JPanel();
		panelAct.setBackground(new Color(240, 240, 240));
		panelAct.setLayout(null);
		panelAct.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelAct.setBounds(61, 74, 192, 322);
		frmClub.getContentPane().add(panelAct);
		
		textNameAct = new JTextField();
		textNameAct.setText("Name:");
		textNameAct.setEditable(false);
		textNameAct.setColumns(10);
		textNameAct.setBounds(10, 11, 62, 20);
		panelAct.add(textNameAct);
		
		textOffenceAct = new JTextField();
		textOffenceAct.setText("OFFENCE:");
		textOffenceAct.setEditable(false);
		textOffenceAct.setColumns(10);
		textOffenceAct.setBounds(10, 42, 76, 20);
		panelAct.add(textOffenceAct);
		
		textNameActVar = new JTextField();
		textNameActVar.addActionListener(this);
		textNameActVar.setHorizontalAlignment(SwingConstants.CENTER);
		textNameActVar.setColumns(10);
		textNameActVar.setBounds(68, 11, 114, 20);
		panelAct.add(textNameActVar);
		
		textModifiersAct = new JTextField();
		textModifiersAct.setText("Modifiers:");
		textModifiersAct.setEditable(false);
		textModifiersAct.setColumns(10);
		textModifiersAct.setBounds(10, 126, 76, 20);
		panelAct.add(textModifiersAct);
		
		textDefenceAct = new JTextField();
		textDefenceAct.setText("DEFENCE:");
		textDefenceAct.setEditable(false);
		textDefenceAct.setColumns(10);
		textDefenceAct.setBounds(10, 68, 76, 20);
		panelAct.add(textDefenceAct);
		
		textStanimaAct = new JTextField();
		textStanimaAct.setText("STANIMA:");
		textStanimaAct.setEditable(false);
		textStanimaAct.setColumns(10);
		textStanimaAct.setBounds(10, 95, 76, 20);
		panelAct.add(textStanimaAct);
		textOffenceActVar = new JTextField();
		
		textOffenceActVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceActVar.setEditable(false);
		textOffenceActVar.setColumns(10);
		textOffenceActVar.setBounds(96, 42, 86, 20);
		panelAct.add(textOffenceActVar);
		
		textDefenceActVar = new JTextField();
		
		textDefenceActVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceActVar.setEditable(false);
		textDefenceActVar.setColumns(10);
		textDefenceActVar.setBounds(96, 68, 86, 20);
		panelAct.add(textDefenceActVar);
		
		textStanimaActVar = new JTextField();
		textStanimaActVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaActVar.setEditable(false);
		textStanimaActVar.setColumns(10);
		textStanimaActVar.setBounds(96, 93, 86, 20);
		panelAct.add(textStanimaActVar);
		
		textModifiersActVar = new JTextField();
		textModifiersActVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textModifiersActVar.setEditable(false);
		textModifiersActVar.setColumns(10);
		textModifiersActVar.setBounds(96, 126, 86, 38);
		panelAct.add(textModifiersActVar);
		
		textCostAct = new JTextField();
		textCostAct.setText("Cost:");
		textCostAct.setEditable(false);
		textCostAct.setColumns(10);
		textCostAct.setBounds(10, 201, 76, 20);
		panelAct.add(textCostAct);
		
		textCostActVar = new JTextField();
		textCostActVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textCostActVar.setEditable(false);
		textCostActVar.setColumns(10);
		textCostActVar.setBounds(96, 201, 86, 20);
		panelAct.add(textCostActVar);
		
		btnLAct = new JButton("<==");
		btnLAct.addMouseListener(this);
		btnLAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (activeIndex == 0 && 0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
					activeIndex = enviroment.getPlayerTeam().getActiveTeam().size() - 1;
				}
				else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())) {
					activeIndex -= 1;
				}
			}
		});
		btnLAct.setBounds(29, 264, 57, 23);
		panelAct.add(btnLAct);
		
		btnRAct = new JButton("==>");
		btnRAct.addMouseListener(this);
		btnRAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (activeIndex == (enviroment.getPlayerTeam().getActiveTeam().size() - 1)) {
					activeIndex = 0;
				}
				else if (0 != (enviroment.getPlayerTeam().getActiveTeam().size())){
					activeIndex += 1;
				}
			}
		});
		btnRAct.setBounds(96, 264, 65, 23);
		panelAct.add(btnRAct);
		
		textActiveIndex = new JTextField();
		textActiveIndex.setText(""+activeIndex);
		textActiveIndex.setHorizontalAlignment(SwingConstants.CENTER);
		textActiveIndex.setEditable(false);
		textActiveIndex.setColumns(10);
		textActiveIndex.setBounds(49, 298, 86, 20);
		panelAct.add(textActiveIndex);
		
		JButton btnSwapRes = new JButton("Swap");
		btnSwapRes.addMouseListener(this);
		btnSwapRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.getPlayerTeam().getReserveTeam().size() > 0 && enviroment.getPlayerTeam().getActiveTeam().size() < 4) {
					try {
						enviroment.getPlayerTeam().swapContestantTeam(enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex));
						if (reserveIndex == enviroment.getPlayerTeam().getReserveTeam().size() && enviroment.getPlayerTeam().getReserveTeam().size() != 0) {
							reserveIndex -= 1;
						}
					} catch (InvalidTeamSize e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSwapRes.setBounds(418, 399, 116, 39);
		frmClub.getContentPane().add(btnSwapRes);
		
		panelAct_1 = new JPanel();
		panelAct_1.setLayout(null);
		panelAct_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelAct_1.setBackground(SystemColor.menu);
		panelAct_1.setBounds(389, 74, 192, 322);
		frmClub.getContentPane().add(panelAct_1);
		
		textNameRes = new JTextField();
		textNameRes.setText("Name:");
		textNameRes.setEditable(false);
		textNameRes.setColumns(10);
		textNameRes.setBounds(10, 11, 62, 20);
		panelAct_1.add(textNameRes);
		
		textOffenceRes = new JTextField();
		textOffenceRes.setText("OFFENCE:");
		textOffenceRes.setEditable(false);
		textOffenceRes.setColumns(10);
		textOffenceRes.setBounds(10, 42, 76, 20);
		panelAct_1.add(textOffenceRes);
		
		textNameResVar = new JTextField();
		textNameResVar.addActionListener(this);
		textNameResVar.setHorizontalAlignment(SwingConstants.CENTER);
		textNameResVar.setColumns(10);
		textNameResVar.setBounds(68, 11, 114, 20);
		panelAct_1.add(textNameResVar);
		
		textModifiersRes = new JTextField();
		textModifiersRes.setText("Modifiers:");
		textModifiersRes.setEditable(false);
		textModifiersRes.setColumns(10);
		textModifiersRes.setBounds(10, 126, 76, 20);
		panelAct_1.add(textModifiersRes);
		
		textDefenceRes = new JTextField();
		textDefenceRes.setText("DEFENCE:");
		textDefenceRes.setEditable(false);
		textDefenceRes.setColumns(10);
		textDefenceRes.setBounds(10, 68, 76, 20);
		panelAct_1.add(textDefenceRes);
		
		textStanimaRes = new JTextField();
		textStanimaRes.setText("STANIMA:");
		textStanimaRes.setEditable(false);
		textStanimaRes.setColumns(10);
		textStanimaRes.setBounds(10, 95, 76, 20);
		panelAct_1.add(textStanimaRes);
		
		textOffenceResVar = new JTextField();
		textOffenceResVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceResVar.setEditable(false);
		textOffenceResVar.setColumns(10);
		textOffenceResVar.setBounds(96, 42, 86, 20);
		panelAct_1.add(textOffenceResVar);
		
		textDefenceResVar = new JTextField();
		textDefenceResVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceResVar.setEditable(false);
		textDefenceResVar.setColumns(10);
		textDefenceResVar.setBounds(96, 68, 86, 20);
		panelAct_1.add(textDefenceResVar);
		
		textStanimaResVar = new JTextField();
		textStanimaResVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaResVar.setEditable(false);
		textStanimaResVar.setColumns(10);
		textStanimaResVar.setBounds(96, 93, 86, 20);
		panelAct_1.add(textStanimaResVar);
		
		textModifiersResVar = new JTextField();
		textModifiersResVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textModifiersResVar.setEditable(false);
		textModifiersResVar.setColumns(10);
		textModifiersResVar.setBounds(96, 126, 86, 38);
		panelAct_1.add(textModifiersResVar);
		
		textCostRes = new JTextField();
		textCostRes.setEditable(false);
		textCostRes.setColumns(10);
		textCostRes.setBounds(10, 206, 76, 20);
		panelAct_1.add(textCostRes);
		
		textCostResVar = new JTextField();
		textCostResVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textCostResVar.setEditable(false);
		textCostResVar.setColumns(10);
		textCostResVar.setBounds(96, 206, 86, 20);
		panelAct_1.add(textCostResVar);
		
		btnSellRes = new JButton("Sell");
		btnSellRes.addMouseListener(this);
		btnSellRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.getPlayerTeam().getReserveTeam().size() != 0) {
					try {
						enviroment.getMarket().sellAsset(enviroment.getPlayerTeam(), enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex));
						if (reserveIndex == enviroment.getPlayerTeam().getReserveTeam().size() && enviroment.getPlayerTeam().getReserveTeam().size() != 0) {
							reserveIndex -= 1;
						}
					} catch (ItemNotFound e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSellRes.setBounds(68, 230, 62, 23);
		panelAct_1.add(btnSellRes);
		
		btnLRes = new JButton("<==");
		btnLRes.addMouseListener(this);
		btnLRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reserveIndex == 0 && 0 != (enviroment.getPlayerTeam().getReserveTeam().size())) {
					reserveIndex = enviroment.getPlayerTeam().getReserveTeam().size() - 1;
				}
				else if (0 != (enviroment.getPlayerTeam().getReserveTeam().size())) {
					reserveIndex -= 1;
				}
			}
		});
		btnLRes.setBounds(29, 264, 57, 23);
		panelAct_1.add(btnLRes);
		
		btnRRes = new JButton("==>");
		btnRRes.addMouseListener(this);
		btnRRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (reserveIndex == (enviroment.getPlayerTeam().getReserveTeam().size() - 1)) {
					reserveIndex = 0;
				}
				else if (0 != (enviroment.getPlayerTeam().getReserveTeam().size())){
					reserveIndex += 1;
				}
			}
		});
		btnRRes.setBounds(96, 264, 65, 23);
		panelAct_1.add(btnRRes);
		
		textReserveIndex = new JTextField();
		textReserveIndex.setHorizontalAlignment(SwingConstants.CENTER);
		textReserveIndex.setEditable(false);
		textReserveIndex.setColumns(10);
		textReserveIndex.setBounds(49, 298, 86, 20);
		panelAct_1.add(textReserveIndex);
		
		txtResState = new JTextField();
		txtResState.setEditable(false);
		txtResState.setHorizontalAlignment(SwingConstants.CENTER);
		txtResState.setBounds(427, 43, 107, 20);
		frmClub.getContentPane().add(txtResState);
		txtResState.setColumns(10);
		
		txtActState = new JTextField();
		txtActState.setEditable(false);
		txtActState.setHorizontalAlignment(SwingConstants.CENTER);
		txtActState.setBounds(93, 43, 116, 20);
		frmClub.getContentPane().add(txtActState);
		txtActState.setColumns(10);
		
		btnSwapAct = new JButton("Swap");
		btnSwapAct.addMouseListener(this);
		btnSwapAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enviroment.getPlayerTeam().getActiveTeam().size() > 0 && enviroment.getPlayerTeam().getReserveTeam().size() < 6) {
					try {
						enviroment.getPlayerTeam().swapContestantTeam(enviroment.getPlayerTeam().getActiveTeam().get(activeIndex));
						if (activeIndex == enviroment.getPlayerTeam().getActiveTeam().size() && enviroment.getPlayerTeam().getActiveTeam().size() != 0) {
							activeIndex -= 1;
						}
					} catch (InvalidTeamSize e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnSwapAct.setBounds(93, 399, 116, 39);
		frmClub.getContentPane().add(btnSwapAct);

		
		mouseClicked(null); //Initial text Management
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (enviroment.getPlayerTeam().getActiveTeam().size() != 0) {
			textNameActVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getName());
			textOffenceActVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttribute(ContestantAttribute.OFFENCE));
			textDefenceActVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttribute(ContestantAttribute.DEFENCE));
			textStanimaActVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getAttribute(ContestantAttribute.MAX_STANIMA));
			textModifiersActVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getModifiers());
			textCostActVar.setText(""+enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).getValue());
			textActiveIndex.setText(""+(activeIndex+1));
		}
		
		if (enviroment.getPlayerTeam().getReserveTeam().size() != 0) {
			textNameResVar.setText(""+enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex).getName());
			textOffenceResVar.setText(""+enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex).getAttribute(ContestantAttribute.OFFENCE));
			textDefenceResVar.setText(""+enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex).getAttribute(ContestantAttribute.DEFENCE));
			textStanimaResVar.setText(""+enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex).getAttribute(ContestantAttribute.MAX_STANIMA));
			textModifiersResVar.setText(""+enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex).getModifiers());
			textCostResVar.setText(""+enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex).getValue());
			textReserveIndex.setText(""+(reserveIndex+1));
		}
		
		if (enviroment.getPlayerTeam().getActiveTeam().size() == 0) {
			textNameActVar.setText("");
			textOffenceActVar.setText("");
			textDefenceActVar.setText("");
			textStanimaActVar.setText("");
			textModifiersActVar.setText("");
			textCostActVar.setText("");
			textActiveIndex.setText(""+(activeIndex+1));
			txtActState.setText("No Active Players");
		}else if (enviroment.getPlayerTeam().getActiveTeam().size() == 4) {
			txtActState.setText("Active Team Full");
		}else {
			txtActState.setText("");
		}
		
		if (enviroment.getPlayerTeam().getReserveTeam().size() == 0) {
			textNameResVar.setText("");
			textOffenceResVar.setText("");
			textDefenceResVar.setText("");
			textStanimaResVar.setText("");
			textModifiersResVar.setText("");
			textCostResVar.setText("");
			textReserveIndex.setText(""+(reserveIndex+1));
			txtResState.setText("No Reserves");
		}else if (enviroment.getPlayerTeam().getReserveTeam().size() == 5) {
			txtResState.setText("Reserves Full");
			txtResState.setForeground(Color.BLACK);
		}else if (enviroment.getPlayerTeam().getReserveTeam().size() == 6){
			txtResState.setText("Reserves Full");
			txtResState.setForeground(Color.RED);
		}else {
			txtResState.setText("");
			txtResState.setForeground(Color.BLACK);
		}
		
		
		textMoney.setText(""+enviroment.getPlayerTeam().getTotalFunds());
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
			if (enviroment.getPlayerTeam().getActiveTeam().size() != 0 && textNameActVar.getText().matches("[a-zA-Z]+")) {
				enviroment.getPlayerTeam().getActiveTeam().get(activeIndex).setName(textNameActVar.getText());
			}
			if (enviroment.getPlayerTeam().getReserveTeam().size() != 0 && textNameResVar.getText().matches("[a-zA-Z]+")) {
				enviroment.getPlayerTeam().getReserveTeam().get(reserveIndex).setName(textNameResVar.getText());
			
		}
		
	}
}
