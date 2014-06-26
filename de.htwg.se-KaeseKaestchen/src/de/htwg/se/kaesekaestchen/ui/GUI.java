package de.htwg.se.kaesekaestchen.ui;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;

import de.htwg.se.kaesekaestchen.controller.KaeseKaestchenControl;
import de.htwg.se.kaesekaestchen.util.IObserver;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements IObserver {

	private KaeseKaestchenControl theControl;
	public GUI(KaeseKaestchenControl pTheControl) {
		theControl = pTheControl;
		setBounds(100, 100, 568, 383);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel playPanel = new JPanel();
		getContentPane().add(playPanel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(40);
		textArea.setRows(5);
		textArea.setEditable(false);
		panel_2.add(textArea);
		
		this.setVisible(true);

	}
	
	public void drawPlayPanel(){
		
	}

	@Override
	public void refreshUI() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showWelcomeMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showWarning() {
		// TODO Auto-generated method stub
		
	}

}
