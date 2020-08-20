package com.assignment1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JEditorPane;
import javax.swing.JMenuItem;

public class EditMenu {


	private static Clipboard clip;

	static String CutString(String string) {
        StringSelection cutClip = new StringSelection(string);
        clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        clip.setContents(cutClip, cutClip);
		return "";
	}
	
	static void CopyString(String string) {
        StringSelection cutClip = new StringSelection(string);
        clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        clip.setContents(cutClip, cutClip);
	}

	static String PasteString() {
		return null;
		
	}
	
	static String TimeAndDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy\nHH:mm\n");  
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
		
	}

	

}
