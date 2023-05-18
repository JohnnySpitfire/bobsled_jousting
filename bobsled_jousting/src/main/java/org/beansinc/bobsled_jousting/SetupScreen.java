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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SetupScreen implements ChangeListener{

	private JFrame frmSetupscreen;
	private GameEnviroment enviroment;
	private int dif;
	private String teamName;
	private int weeks;
	//private final Action Accept = new SwingAction();
	private JTextField TeamName;
	private ArrayList<Contestant> setupContestants;
	private JTextField textDifficulty;
	private JTextField textNumWeeks;
	private JSlider difficulty;
	private JSlider numWeeks;
	private final Action Accept = new SwingAction();
	
	
	public SetupScreen(GameEnviroment incomingEnviroment) {
		enviroment = incomingEnviroment;
		initialize();
		frmSetupscreen.setVisible(true);
	}
	
	public void closeWindow() {
		frmSetupscreen.dispose();
	}
	/*public void finishedWindow() {
		team.closeSetupScreen(this);
	}*/

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
		frmSetupscreen.setVisible(true);
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
		//btnAccept.setAction(Accept);
		btnAccept.setBounds(277, 415, 89, 23);
		frmSetupscreen.getContentPane().add(btnAccept);
		
		TeamName = new JTextField();
		TeamName.setHorizontalAlignment(SwingConstants.CENTER);
		TeamName.setBounds(280, 11, 86, 20);
		frmSetupscreen.getContentPane().add(TeamName);
		TeamName.setColumns(10);
		
		difficulty = new JSlider();
		
		difficulty.setMinimum(1);
		difficulty.setMinorTickSpacing(1);
		difficulty.setBounds(206, 78, 200, 49);
		frmSetupscreen.getContentPane().add(difficulty);
		
		textDifficulty = new JTextField();
		textDifficulty.setText(Integer.toString(difficulty.getValue()));
		textDifficulty.setEditable(false);
		textDifficulty.setBounds(430, 97, 86, 20);
		frmSetupscreen.getContentPane().add(textDifficulty);
		textDifficulty.setColumns(10);
		
		numWeeks = new JSlider();
		numWeeks.setValue(1);
		numWeeks.setSnapToTicks(true);
		numWeeks.setMinorTickSpacing(1);
		numWeeks.setMinimum(1);
		numWeeks.setMaximum(14);
		numWeeks.setBounds(172, 227, 200, 26);
		frmSetupscreen.getContentPane().add(numWeeks);
		
		textNumWeeks = new JTextField();
		textNumWeeks.setText(Integer.toString(numWeeks.getValue()));
		textNumWeeks.setEditable(false);
		textNumWeeks.setBounds(400, 237, 86, 20);
		frmSetupscreen.getContentPane().add(textNumWeeks);
		textNumWeeks.setColumns(10);
		
		difficulty.addChangeListener((ChangeListener) this);
		numWeeks.addChangeListener((ChangeListener) this);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		textNumWeeks.setText(Integer.toString(numWeeks.getValue()));
		textDifficulty.setText(Integer.toString(difficulty.getValue()));
	}
	
	public void finishedWindow() throws InvalidObjectAttributeType {
		 enviroment.closeSetupScreen(this);
		
	}

	public GameEnviroment getGameEnviroment() {
		return enviroment;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Accept");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String name = TeamName.getText();
			if (name.matches("[a-zA-Z]+")) {
					teamName = name;
					weeks = numWeeks.getValue();
					dif = difficulty.getValue();
					try {
						enviroment = new GameEnviroment(teamName, weeks, dif);
					} catch (InvalidObjectAttributeType e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						finishedWindow();
					} catch (InvalidObjectAttributeType e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			
		}
	}
}
