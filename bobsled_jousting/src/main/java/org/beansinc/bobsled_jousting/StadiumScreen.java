package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StadiumScreen implements MouseListener{

	private JFrame frmStadium;
	
	private GameEnviroment enviroment;
	private JTextField textOffenceAct;
	private JTextField textDefenceAct;
	private JTextField textStanimaAct;
	private JTextField textOffenceActVar;
	private JTextField textDefenceActVar;
	private JTextField textStanimaActVar;
	private JTextField textCompTeamIndex;
	private JTextField textActiveTeamAvg;
	private JTextField textStanimaCompVar;
	private JTextField textStanimaComp;
	private JTextField textDefenceComp;
	private JTextField textDefenceCompVar;
	private JTextField textOffenceCompVar;
	private JTextField textOffenceComp;
	private JTextField textCompTeamAvg;
	private JTextField textActiveSled;
	private JTextField textArmourAct;
	private JTextField textSpeedAct;
	private JTextField textModifiersAct;
	private JTextField textCompSled;
	private JTextField textArmourComp;
	private JTextField textSpeedComp;
	private JTextField textModifiersComp;
	
	private int teamIndex;

	
	public StadiumScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmStadium.setVisible(true);
	}
	
	public void closeWindow() {
		frmStadium.dispose();
	}
	public void finishedWindow() {
		enviroment.closeStadiumScreen(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StadiumScreen window = new StadiumScreen();
					window.frmStadium.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public StadiumScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStadium = new JFrame();
		frmStadium.setTitle("Stadium");
		frmStadium.setBounds(100, 100, 685, 488);
		frmStadium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStadium.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNewButton.setBounds(570, 415, 89, 23);
		frmStadium.getContentPane().add(btnNewButton);
		
		JPanel panelAct = new JPanel();
		panelAct.setLayout(null);
		panelAct.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelAct.setBackground(SystemColor.menu);
		panelAct.setBounds(40, 43, 192, 327);
		frmStadium.getContentPane().add(panelAct);
		
		textOffenceAct = new JTextField();
		textOffenceAct.setText("OFFENCE:");
		textOffenceAct.setEditable(false);
		textOffenceAct.setColumns(10);
		textOffenceAct.setBounds(10, 43, 76, 20);
		panelAct.add(textOffenceAct);
		
		textDefenceAct = new JTextField();
		textDefenceAct.setText("DEFENCE:");
		textDefenceAct.setEditable(false);
		textDefenceAct.setColumns(10);
		textDefenceAct.setBounds(10, 74, 76, 20);
		panelAct.add(textDefenceAct);
		
		textStanimaAct = new JTextField();
		textStanimaAct.setText("STANIMA:");
		textStanimaAct.setEditable(false);
		textStanimaAct.setColumns(10);
		textStanimaAct.setBounds(10, 105, 76, 20);
		panelAct.add(textStanimaAct);
		
		textOffenceActVar = new JTextField();
		textOffenceActVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceActVar.setEditable(false);
		textOffenceActVar.setColumns(10);
		textOffenceActVar.setBounds(96, 43, 86, 20);
		panelAct.add(textOffenceActVar);
		
		textDefenceActVar = new JTextField();
		textDefenceActVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceActVar.setEditable(false);
		textDefenceActVar.setColumns(10);
		textDefenceActVar.setBounds(96, 74, 86, 20);
		panelAct.add(textDefenceActVar);
		
		textStanimaActVar = new JTextField();
		textStanimaActVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaActVar.setEditable(false);
		textStanimaActVar.setColumns(10);
		textStanimaActVar.setBounds(96, 105, 86, 20);
		panelAct.add(textStanimaActVar);
		
		textActiveTeamAvg = new JTextField();
		textActiveTeamAvg.setEditable(false);
		textActiveTeamAvg.setHorizontalAlignment(SwingConstants.CENTER);
		textActiveTeamAvg.setBounds(10, 11, 172, 20);
		panelAct.add(textActiveTeamAvg);
		textActiveTeamAvg.setColumns(10);
		
		textActiveSled = new JTextField();
		textActiveSled.setText("Your Sled");
		textActiveSled.setHorizontalAlignment(SwingConstants.CENTER);
		textActiveSled.setEditable(false);
		textActiveSled.setColumns(10);
		textActiveSled.setBounds(10, 143, 172, 20);
		panelAct.add(textActiveSled);
		
		textArmourAct = new JTextField();
		textArmourAct.setHorizontalAlignment(SwingConstants.CENTER);
		textArmourAct.setEditable(false);
		textArmourAct.setColumns(10);
		textArmourAct.setBounds(11, 174, 171, 27);
		panelAct.add(textArmourAct);
		
		textSpeedAct = new JTextField();
		textSpeedAct.setHorizontalAlignment(SwingConstants.CENTER);
		textSpeedAct.setEditable(false);
		textSpeedAct.setColumns(10);
		textSpeedAct.setBounds(11, 212, 171, 27);
		panelAct.add(textSpeedAct);
		
		textModifiersAct = new JTextField();
		textModifiersAct.setHorizontalAlignment(SwingConstants.CENTER);
		textModifiersAct.setEditable(false);
		textModifiersAct.setColumns(10);
		textModifiersAct.setBounds(11, 250, 171, 27);
		panelAct.add(textModifiersAct);
		
		JPanel panelAct_1 = new JPanel();
		panelAct_1.setLayout(null);
		panelAct_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelAct_1.setBackground(SystemColor.menu);
		panelAct_1.setBounds(437, 43, 192, 327);
		frmStadium.getContentPane().add(panelAct_1);
		
		textOffenceComp = new JTextField();
		textOffenceComp.setText("OFFENCE:");
		textOffenceComp.setEditable(false);
		textOffenceComp.setColumns(10);
		textOffenceComp.setBounds(10, 43, 76, 20);
		panelAct_1.add(textOffenceComp);
		
		textDefenceComp = new JTextField();
		textDefenceComp.setText("DEFENCE:");
		textDefenceComp.setEditable(false);
		textDefenceComp.setColumns(10);
		textDefenceComp.setBounds(10, 74, 76, 20);
		panelAct_1.add(textDefenceComp);
		
		textStanimaComp = new JTextField();
		textStanimaComp.setText("STANIMA:");
		textStanimaComp.setEditable(false);
		textStanimaComp.setColumns(10);
		textStanimaComp.setBounds(10, 105, 76, 20);
		panelAct_1.add(textStanimaComp);
		
		textOffenceCompVar = new JTextField();
		textOffenceCompVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceCompVar.setEditable(false);
		textOffenceCompVar.setColumns(10);
		textOffenceCompVar.setBounds(96, 43, 86, 20);
		panelAct_1.add(textOffenceCompVar);
		
		textDefenceCompVar = new JTextField();
		textDefenceCompVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceCompVar.setEditable(false);
		textDefenceCompVar.setColumns(10);
		textDefenceCompVar.setBounds(96, 74, 86, 20);
		panelAct_1.add(textDefenceCompVar);
		
		textStanimaCompVar = new JTextField();
		textStanimaCompVar.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaCompVar.setEditable(false);
		textStanimaCompVar.setColumns(10);
		textStanimaCompVar.setBounds(96, 105, 86, 20);
		panelAct_1.add(textStanimaCompVar);
		
		textCompTeamAvg = new JTextField();
		textCompTeamAvg.setEditable(false);
		textCompTeamAvg.setText("Oppenent Team's Average Stats");
		textCompTeamAvg.setHorizontalAlignment(SwingConstants.CENTER);
		textCompTeamAvg.setColumns(10);
		textCompTeamAvg.setBounds(10, 11, 172, 20);
		panelAct_1.add(textCompTeamAvg);
		
		textCompSled = new JTextField();
		textCompSled.setText("Oppenent's Sled");
		textCompSled.setHorizontalAlignment(SwingConstants.CENTER);
		textCompSled.setEditable(false);
		textCompSled.setColumns(10);
		textCompSled.setBounds(10, 143, 172, 20);
		panelAct_1.add(textCompSled);
		
		textArmourComp = new JTextField();
		textArmourComp.setHorizontalAlignment(SwingConstants.CENTER);
		textArmourComp.setEditable(false);
		textArmourComp.setColumns(10);
		textArmourComp.setBounds(11, 174, 171, 27);
		panelAct_1.add(textArmourComp);
		
		textSpeedComp = new JTextField();
		textSpeedComp.setHorizontalAlignment(SwingConstants.CENTER);
		textSpeedComp.setEditable(false);
		textSpeedComp.setColumns(10);
		textSpeedComp.setBounds(11, 212, 171, 27);
		panelAct_1.add(textSpeedComp);
		
		textModifiersComp = new JTextField();
		textModifiersComp.setHorizontalAlignment(SwingConstants.CENTER);
		textModifiersComp.setEditable(false);
		textModifiersComp.setColumns(10);
		textModifiersComp.setBounds(11, 250, 171, 27);
		panelAct_1.add(textModifiersComp);
		
		JButton btnRAct = new JButton("==>");
		btnRAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (teamIndex == (enviroment.getStadium().getAvalibleMatches().size() - 1)) {
					teamIndex = 0;
				}
				else if (0 != (enviroment.getStadium().getAvalibleMatches().size())){
					teamIndex += 1;
				}
			}
		});
		btnRAct.setBounds(117, 292, 65, 23);
		panelAct_1.add(btnRAct);
		
		JButton btnLAct = new JButton("<==");
		btnLAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (teamIndex == 0 && 0 != (enviroment.getStadium().getAvalibleMatches().size())) {
					teamIndex = enviroment.getStadium().getAvalibleMatches().size() - 1;
				}
				else if (0 != (enviroment.getStadium().getAvalibleMatches().size())) {
					teamIndex -= 1;
				}
			}
		});
		btnLAct.setBounds(10, 292, 57, 23);
		panelAct_1.add(btnLAct);
		
		textCompTeamIndex = new JTextField();
		textCompTeamIndex.setBounds(66, 292, 57, 20);
		panelAct_1.add(textCompTeamIndex);
		textCompTeamIndex.setHorizontalAlignment(SwingConstants.CENTER);
		textCompTeamIndex.setEditable(false);
		textCompTeamIndex.setColumns(10);
		
		
		
		mouseClicked(null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		textActiveTeamAvg.setText("DYNAMIC's Average Stats");
		textOffenceActVar.setText("0");
		textDefenceActVar.setText("0");
		textStanimaActVar.setText("0");
		textArmourAct.setText("Armour:0");
		textSpeedAct.setText("Speed:0");
		textModifiersAct.setText("Modifiers:[]");
		
		
		textOffenceCompVar.setText("0");
		textDefenceCompVar.setText("0");
		textStanimaCompVar.setText("0");
		textArmourComp.setText("Armour:0");
		textSpeedComp.setText("Speed:0");
		textModifiersComp.setText("Modifiers:[]");
		
		
		textCompTeamIndex.setText(""+(teamIndex + 1));
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
