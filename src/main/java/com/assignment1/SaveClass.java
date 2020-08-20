package com.assignment1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class SaveClass {

	public static String saveMethod(String filename, JTextArea textArea, TextMainWindow textMainWindow) {
		
		
		if (filename == null) {
			filename = SaveAsClass.SaveAsFunction(filename, textArea, textMainWindow);
		}
		
		else {
		
		FileDialog fileDialog = new FileDialog(textMainWindow, "Save File ", FileDialog.SAVE);	//Open window to safe file
		fileDialog.setVisible(false);
		filename = fileDialog.getDirectory() + fileDialog.getFile();
		
		if (filename != null){
			try {
				FileWriter fileWriter = new FileWriter(filename); // create new file
				fileWriter.write(textArea.getText());
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("File not found");
				e.printStackTrace();
				}
			}
		}
		return filename;
	}

	
			
	
}