package de.htwg.se.kaesekaestchen.ui.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import de.htwg.se.kaesekaestchen.controller.IKaeseKaestchenControl;
import de.htwg.se.kaesekaestchen.event.Event;
import de.htwg.se.kaesekaestchen.util.IObserver;

public class KaeseKaestchenFrame extends JFrame implements IObserver {
	
	private static final int DEFAULT_X = 600;
	private static final int DEFAULT_Y = 700;
	private IKaeseKaestchenControl controller;
	private Container pane;
	
	public KaeseKaestchenFrame(IKaeseKaestchenControl theControl){
	
		JMenuBar menuBar;
		
		JMenu fileMenu;
		JMenuItem newMenuItem, loadMenuItem, saveMenuItem, quitMenuItem;
		
		setTitle("HTWG Kaesekaestchen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_X, DEFAULT_Y);
		pane = getContentPane();
		pane.setLayout(new BorderLayout());
		
		menuBar = new JMenuBar();
		
		/* 
		 * File Menu
		 */
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		newMenuItem = new JMenu("New");
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		//newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		
		fileMenu.add(newMenuItem);
		setJMenuBar(menuBar);
		this.add(fileMenu);
		
		constructKaeseKaestchenPane();
		
		
		
		
	}
	
	public void constructKaeseKaestchenPane() {
		this.setVisible(true);
	}

	@Override
	public void update(Event somethingHappend) {
		// TODO Auto-generated method stub
		
	}

}
