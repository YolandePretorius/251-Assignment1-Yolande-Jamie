package com.assignment1;

import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.TextArea;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class SaveAsClass {
	

	public static String SaveAsFunction(String filename, JTextArea textArea, TextMainWindow window) {
		
		FileDialog fileDialog = new FileDialog(window, "Save File ", FileDialog.SAVE);	//Open window to safe file
		fileDialog.setVisible(true);
	
		
		// Get file name 
		if (fileDialog.getFile() != null) {
			filename = fileDialog.getDirectory() + fileDialog.getFile();
		}
		if (filename != null){
			try {
				FileWriter fileWriter = new FileWriter(filename); // create new file
				fileWriter.write(textArea.getText());
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("File not found");
				
			}
		}
		return filename;
	

	}
}
