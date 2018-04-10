package com.pad.noob;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class AboutWindow {
	
	public AboutWindow(NoobPad noobPad) {
		JDialog frame = new JDialog();
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
		frame.setIconImage(noobPad.getLogo().getImage());
		frame.add(new JLabel(noobPad.getLogoX2()));
		frame.add(new JLabel("NoobPad v1"));
		frame.setTitle("About"); 
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

}
