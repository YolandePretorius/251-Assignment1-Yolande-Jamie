package com.assignment1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


	

}
