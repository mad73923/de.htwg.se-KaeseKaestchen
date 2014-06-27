package de.htwg.se.kaesekaestchen.ui;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.kaesekaestchen.util.IObserver;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame implements IObserver {

	private KaeseKaestchenControl theControl;
	private List<ActionListener> listener;
	private JPanel playPanel;
	private JTextArea textArea;
	
	private JButton[][] buttons;
	
	public GUI(KaeseKaestchenControl pTheControl) {
		theControl = pTheControl;
		theControl.addObserver(this);
		Color[] colors= {Color.black, Color.blue};
		String names[] = {"Spieler1", "Spieler2"};
		
		
		setBounds(100, 100, 568, 383);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		playPanel = new JPanel();
		getContentPane().add(playPanel, BorderLayout.CENTER);
		playPanel.setLayout(null);
		
		theControl.startNewGame(names, colors, 5, 5);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Undo");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		textArea = new JTextArea();
		textArea.setColumns(40);
		textArea.setRows(5);
		textArea.setEditable(false);
		panel_2.add(textArea);
		
		this.setVisible(true);
		
		drawPlayPanel();
		
		this.setTitle("KaeseKaestchen");
		

	}
	

	public void drawPlayPanel(){
		if(buttons != null){
			for(int i=0; i<buttons.length; i++){
				for(int j=0; j<buttons[i].length; j++){
					playPanel.remove(buttons[i][j]);
				}
			}
		}
		int columns = theControl.getPlayField().getNumberOfColumns();
		int rows = theControl.getPlayField().getNumberOfRows();
		buttons = new JButton[columns+1][rows+1];
		for(int i=0; i<columns; i++){
			for(int j=0; j<rows; j++){
				buttons[i][j+1] = new JButton();
				buttons[i][j+1].setBounds(50*i+i*20+25, 50*j+75+j*10, 50, 20);
				
				if(theControl.isLineSet(i, j, i+1, j)){
					buttons[i][j+1].setBackground(Color.black);
					buttons[i][j+1].setEnabled(false);
				}else{
					buttons[i][j+1].addActionListener(new KaeseListener(i, j, true));
				}
				playPanel.add(buttons[i][j+1]);
				
				buttons[i+1][j+1] = new JButton();
				buttons[i+1][j+1].setBounds(50*i+75+i*20, 50*j+25+j*10, 20, 50);
				if(theControl.isLineSet(i, j, i, j+1)){
					buttons[i+1][j+1].setBackground(Color.black);
					buttons[i+1][j+1].setEnabled(false);
				}else{
					buttons[i+1][j+1].addActionListener(new KaeseListener(i, j, false));
				}
				playPanel.add(buttons[i+1][j+1]);
				
				if(i==0){
					buttons[i][j] = new JButton();
					buttons[i][j].setBounds(5, 50*j+25+j*10, 20, 50);
					buttons[i][j].setBackground(Color.black);
					buttons[i][j].setEnabled(false);
					playPanel.add(buttons[i][j]);
				}
				
				if(j==0){
					buttons[i+1][j] = new JButton();
					buttons[i+1][j].setBounds(50*i+i*20+25, 10, 50, 20);
					buttons[i+1][j].setBackground(Color.black);
					buttons[i+1][j].setEnabled(false);
					playPanel.add(buttons[i+1][j]);
				}
				
			}
		}
		this.repaint();
	}

	@Override
	public void refreshUI() {
		drawPlayPanel();		
	}

	@Override
	public void showWelcomeMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMessage() {
		textArea.append(theControl.getStatusMessage());		
	}

	@Override
	public void showWarning() {
		textArea.append(theControl.getWarningMessage());	
	}
	
	private class KaeseListener implements ActionListener{
		
		private int i; 
		private int j;
		private boolean horiz;
		
		public KaeseListener(int pi, int pj, boolean horizontal){
			i = pi;
			j = pj;
			horiz = horizontal;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(horiz){
				theControl.newMove(i, j, i+1, j);
			}else{
				theControl.newMove(i, j, i, j+1);
			}
			
		}
		
	}

}
