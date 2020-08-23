package com.assignment1;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;

public class SearchClass extends  myHighLighter {
	


	public SearchClass(Color color) {
		super(color);
		searchTextArea(null, null);
		
	}

	static void removeHighlighter(JTextComponent textArea) {
		Highlighter removeHighlighter = textArea.getHighlighter();
		Highlighter.Highlight[] remove = removeHighlighter.getHighlights();
		
		for (int i = 0; i < remove.length; i++) {
			if (remove[i].getPainter() instanceof myHighLighter) {
				removeHighlighter.removeHighlight(remove[i]);
			}
		}
		
	}

	static void searchTextArea(JTextComponent textArea,String textString) {
		
		removeHighlighter(textArea);
		
				
		try {
			Highlighter hilight = textArea.getHighlighter();
			Document doc = textArea.getDocument();
			
			String text = doc.getText(0, doc.getLength());
			
			int pos = 0;
			
			while((pos = text.toUpperCase().indexOf(textString.toUpperCase(),pos))>=0) {
				hilight.addHighlight(pos, pos + textString.length(), highlighter);
				pos += textString.length();
			}
			
		}catch (Exception e) {
			
		
	}

 }

}

// classs that creates highlighter	
	class myHighLighter extends DefaultHighlighter.DefaultHighlightPainter{
		
			public myHighLighter(Color color) {
				super(color);
			}
			static DefaultHighlighter.HighlightPainter highlighter = new myHighLighter(Color.GREEN);
				
	}
	
	

