package org.beansinc.bobsled_jousting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JTextField;

import org.beansinc.bobsled_jousting.BSExceptions.InvalidObjectAttributeType;
import javax.swing.JDesktopPane;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SetupScreen {

	private JFrame frmSetupscreen;
	private BaseTeam team;
	private final Action Accept = new SwingAction();
	private JTextField TeamName;
	private JTextField txtMoney;
	private JTextField txtName1;
	private JTextField txtOffence1;
	private JTextField txtPosition1;
	private JTextField txtEditiableName1;
	private JTextField txtModifiers1;
	private JTextField txtDefence1;
	private JTextField txtStanima1;
	private JTextField textOffenceVar1;
	private JTextField textDefenceVar1;
	private JTextField textStanimaVar1;
	private JTextField textPositionVar1;
	private JTextField txtModifiersVar1;
	private JTextField txtCost1;
	private JTextField textField1;
	private ArrayList<Contestant> setupContestants;
	
	public SetupScreen(BaseTeam incomingTeam) {
		team = incomingTeam;
		initialize();
		frmSetupscreen.setVisible(true);
	}
	
	public void closeWindow() {
		frmSetupscreen.dispose();
	}
	public void finishedWindow() {
		team.closeSetupScreen(this);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frmSetupscreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetupscreen = new JFrame();
		frmSetupscreen.setTitle("SetupScreen");
		frmSetupscreen.setBounds(100, 100, 685, 488);
		frmSetupscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetupscreen.getContentPane().setLayout(null);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setAction(Accept);
		btnAccept.setBounds(277, 415, 89, 23);
		frmSetupscreen.getContentPane().add(btnAccept);
		
		TeamName = new JTextField();
		TeamName.setHorizontalAlignment(SwingConstants.CENTER);
		TeamName.setBounds(280, 11, 86, 20);
		frmSetupscreen.getContentPane().add(TeamName);
		TeamName.setColumns(10);
		
		txtMoney = new JTextField();
		txtMoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtMoney.setEditable(false);
		txtMoney.setText(Integer.toString(team.getMoney()));
		txtMoney.setBounds(573, 11, 86, 20);
		frmSetupscreen.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel1.setBounds(20, 69, 151, 230);
		frmSetupscreen.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		txtName1 = new JTextField();
		txtName1.setText("Name:");
		txtName1.setEditable(false);
		txtName1.setBounds(10, 11, 44, 20);
		panel1.add(txtName1);
		txtName1.setColumns(10);
		
		txtOffence1 = new JTextField();
		txtOffence1.setEditable(false);
		txtOffence1.setText("OFFENCE:");
		txtOffence1.setBounds(10, 42, 62, 20);
		panel1.add(txtOffence1);
		txtOffence1.setColumns(10);
		
		txtPosition1 = new JTextField();
		txtPosition1.setEditable(false);
		txtPosition1.setText("Position:");
		txtPosition1.setBounds(10, 104, 62, 20);
		panel1.add(txtPosition1);
		txtPosition1.setColumns(10);
		
		txtEditiableName1 = new JTextField();
		txtEditiableName1.setText("NameGoesHere");
		txtEditiableName1.setColumns(10);
		txtEditiableName1.setBounds(52, 11, 93, 20);
		panel1.add(txtEditiableName1);
		
		txtModifiers1 = new JTextField();
		txtModifiers1.setEditable(false);
		txtModifiers1.setText("Modifiers:");
		txtModifiers1.setColumns(10);
		txtModifiers1.setBounds(10, 134, 62, 20);
		panel1.add(txtModifiers1);
		
		txtDefence1 = new JTextField();
		txtDefence1.setEditable(false);
		txtDefence1.setText("DEFENCE:");
		txtDefence1.setColumns(10);
		txtDefence1.setBounds(10, 61, 62, 20);
		panel1.add(txtDefence1);
		
		txtStanima1 = new JTextField();
		txtStanima1.setEditable(false);
		txtStanima1.setText("STANIMA:");
		txtStanima1.setColumns(10);
		txtStanima1.setBounds(10, 80, 62, 20);
		panel1.add(txtStanima1);
		
		textOffenceVar1 = new JTextField();
		textOffenceVar1.setEditable(false);
		textOffenceVar1.setHorizontalAlignment(SwingConstants.RIGHT);
		textOffenceVar1.setText("0");
		textOffenceVar1.setColumns(10);
		textOffenceVar1.setBounds(76, 42, 69, 20);
		panel1.add(textOffenceVar1);
		
		textDefenceVar1 = new JTextField();
		textDefenceVar1.setEditable(false);
		textDefenceVar1.setHorizontalAlignment(SwingConstants.RIGHT);
		textDefenceVar1.setText("0");
		textDefenceVar1.setColumns(10);
		textDefenceVar1.setBounds(76, 61, 69, 20);
		panel1.add(textDefenceVar1);
		
		textStanimaVar1 = new JTextField();
		textStanimaVar1.setEditable(false);
		textStanimaVar1.setHorizontalAlignment(SwingConstants.RIGHT);
		textStanimaVar1.setText("0");
		textStanimaVar1.setColumns(10);
		textStanimaVar1.setBounds(76, 80, 69, 20);
		panel1.add(textStanimaVar1);
		
		textPositionVar1 = new JTextField();
		textPositionVar1.setHorizontalAlignment(SwingConstants.RIGHT);
		textPositionVar1.setText("Posted up");
		textPositionVar1.setEditable(false);
		textPositionVar1.setColumns(10);
		textPositionVar1.setBounds(76, 104, 69, 20);
		panel1.add(textPositionVar1);
		
		txtModifiersVar1 = new JTextField();
		txtModifiersVar1.setText("Modifiers");
		txtModifiersVar1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtModifiersVar1.setEditable(false);
		txtModifiersVar1.setColumns(10);
		txtModifiersVar1.setBounds(76, 134, 69, 38);
		panel1.add(txtModifiersVar1);
		
		txtCost1 = new JTextField();
		txtCost1.setText("Cost:");
		txtCost1.setEditable(false);
		txtCost1.setColumns(10);
		txtCost1.setBounds(10, 175, 62, 20);
		panel1.add(txtCost1);
		
		textField1 = new JTextField();
		textField1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField1.setText("100");
		textField1.setEditable(false);
		textField1.setColumns(10);
		textField1.setBounds(76, 175, 69, 20);
		panel1.add(textField1);
		
		JToggleButton tglbtnSelect1 = new JToggleButton("Select");
		tglbtnSelect1.setBounds(18, 200, 121, 23);
		panel1.add(tglbtnSelect1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Accept");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			String name = TeamName.getText();
			if (name.matches("[a-zA-Z]+")) {
				
				try {
					team.setName(name);
				} catch (InvalidObjectAttributeType e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
				finishedWindow();
		}
	}
	}
}
