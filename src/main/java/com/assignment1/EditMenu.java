package com.assignment1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JMenuItem;

public class EditMenu implements ActionListener {


	private static Clipboard clip;

	static String CutString(String string) {
		// move text to the clipboard and delete selection
//        JMenuItem area = (JMenuItem) string.getSource();
//        String s = area.
        StringSelection cutClip = new StringSelection(string);
        clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        clip.setContents(cutClip, cutClip);
		System.out.print("cut");
		return "";
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
