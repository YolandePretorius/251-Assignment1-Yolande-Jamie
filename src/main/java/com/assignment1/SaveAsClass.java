package com.assignment1;

import java.awt.FileDialog;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAsClass {
	
	public static String SaveAsFunction(String filename,String  textArea, TextMainWindow window) {

		FileDialog fileDialog = new FileDialog(window, "Save File ", FileDialog.SAVE);	//Open window to safe file
		fileDialog.setVisible(true);
	
		
		// Get file name 
		if (fileDialog.getFile() != null) {
			filename = fileDialog.getDirectory() + fileDialog.getFile();
		}
		if (filename != null){
			try {
				FileWriter fileWriter = new FileWriter(filename); // create new file
				fileWriter.write(textArea);
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("File not found");
				
			}
		}
		return filename;
	

	}
}
