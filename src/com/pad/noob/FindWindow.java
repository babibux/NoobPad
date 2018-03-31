package com.pad.noob;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class FindWindow {
	JFrame frame = new JFrame();
	JTextField textField = new JTextField(15);
	JButton nextBtn = new JButton("Next");
	
	public FindWindow(NoobPad noobPad) {
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		frame.setIconImage(noobPad.getLogo().getImage());
		frame.add(new JLabel("Find :"));
		frame.add(textField);
		frame.add(nextBtn);
		frame.setTitle("Find");
		frame.setLocationRelativeTo(null); 
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
		
		Highlighter highlighter = noobPad.getTextArea().getHighlighter();
	    HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.lightGray);
		
	    /* 
	    Still not 100% working :
	    - the highlighted text isn't focused by the cursor
	    - if there's more than one occurrence, the program keeps highlighting the first one
	    */
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			    // removing previous highlight when clicking on Next button
			    highlighter.removeAllHighlights();
			    
				int indexStart = noobPad.getTextArea().getText().indexOf(textField.getText());
				int indexEnd = indexStart + textField.getText().length();
				try {
					highlighter.addHighlight(indexStart, indexEnd, painter);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		});
		
		// removing previous highlight when closing the Find window
		frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent ev) {
		    	  highlighter.removeAllHighlights();
		    	  frame.dispose();
		        }
		});
	}
	
	

}
