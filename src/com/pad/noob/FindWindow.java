package com.pad.noob;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class FindWindow {
	private JDialog frame = new JDialog();
	private JTextField textField = new JTextField(15);
	private JButton nextBtn = new JButton("Next");
	private int keepSearch = 0;
	
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
	      
		nextBtn.addActionListener(ev-> {
			    // removing previous highlight when clicking on Next button
			    highlighter.removeAllHighlights();
			    
			    String userInput = new String(textField.getText().toLowerCase());
			    String textFile = new String(noobPad.getTextArea().getText().toLowerCase());
			    int indexStart = textFile.indexOf(userInput, keepSearch);
			    int indexEnd = indexStart + userInput.length();
			    
			    if(indexStart != -1) {
			    	try {
			    		highlighter.addHighlight(indexStart, indexEnd, painter);
			    	} catch (BadLocationException e) {
			    		e.printStackTrace();
			    	}
			    }
			    else {
			    	JOptionPane.showMessageDialog(noobPad, "Cannot find \"" + textField.getText() + "\"");
			    }
			    keepSearch = indexEnd -1;
		});
		
		// reseting highlighter and search index when closing the Find window
		frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent ev) {
		    	  highlighter.removeAllHighlights();
		    	  frame.dispose();
		    	  keepSearch = 0;
		        }
		});
	}
	
	

}
