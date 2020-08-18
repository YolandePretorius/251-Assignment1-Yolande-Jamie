package com.assignment1;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAsClass {
	
	public static String SaveAsFunction(String filename, TextArea textArea, TextMainWindow textMainWindow) {
		
		FileDialog fileDialog = new FileDialog(textMainWindow, "Save File ", FileDialog.SAVE);	//Open window to safe file
		fileDialog.setVisible(true);
		
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
