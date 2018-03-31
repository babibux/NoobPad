package com.pad.noob;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class NoobPad extends JFrame implements ActionListener {
	private JTextArea textArea = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu menuFile = new JMenu("File");
	private JMenu menuEdit = new JMenu("Edit");
	private JMenu menuQuestionMark = new JMenu("?");
	
	private JMenuItem itemNew = new JMenuItem("New");
	private JMenuItem itemOpen = new JMenuItem("Open");
	private JMenuItem itemSave = new JMenuItem("Save");
	private JMenuItem itemExit = new JMenuItem("Exit");
	private JMenuItem itemFind = new JMenuItem("Find");
	private JMenuItem itemAbout = new JMenuItem("About");
	
	private ImageIcon logo = new ImageIcon("ressources\\NoobPad_logo.png");
	private ImageIcon logoX2 = new ImageIcon("ressources\\NoobPad_logo_x2.png");
	
	private String appName = new String("NoobPad");
	
	
	public NoobPad() {
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuQuestionMark);
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.addSeparator();
		menuFile.add(itemExit);
		menuEdit.add(itemFind);
		menuQuestionMark.add(itemAbout);
		
		// keyboard shortcuts
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
		
		this.setJMenuBar(menuBar);
		this.add(new JScrollPane(textArea));
		
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);
		itemFind.addActionListener(this);
		itemAbout.addActionListener(this);
	}
	
	
	public ImageIcon getLogo() {
		return this.logo;
	}
	
	public ImageIcon getLogoX2() {
		return this.logoX2;
	}
		
	public String getAppName() {
		return this.appName;
	}
	
	public JTextArea getTextArea() {
		return this.textArea;
	}
	
	
	public void newFile() {
		this.setTitle(appName + " - " + "new.txt");
		textArea.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == itemNew)
			newFile();
		else if (ev.getSource() == itemOpen)
			new OpenFileWindow(this);
		else if (ev.getSource() == itemSave)
			new SaveFileWindow(this);
		else if (ev.getSource() == itemAbout)
			new AboutWindow(this);
		else if (ev.getSource() == itemFind)
			new FindWindow(this);
		else 
			System.exit(0);
	}	
}

