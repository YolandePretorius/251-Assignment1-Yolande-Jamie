package com.assignment1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.FileWriter;
import java.io.IOException;

public class SaveClass {

	public static String saveMethod(String filename, TextArea textArea, Frame textMainWindow) {
		System.out.println("save file");
		
		FileDialog fileDialog = new FileDialog(textMainWindow, "Save File ", FileDialog.SAVE);	//Open window to safe file
		fileDialog.setVisible(false);
		
		// Get file name 
		if (fileDialog.getFile() != null) {
			filename = fileDialog.getDirectory() + fileDialog.getFile();
		}
		try {
			FileWriter fileWriter = new FileWriter(filename); // create new file
			fileWriter.write(textArea.getText());
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
			}
		return filename;
	}
			
	
}
