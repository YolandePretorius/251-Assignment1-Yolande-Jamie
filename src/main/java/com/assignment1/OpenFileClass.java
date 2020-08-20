package com.assignment1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;



public class OpenFileClass{  // class used to open a file from file system
	
	
	public static String openFunction(String filename,JTextArea textArea, TextMainWindow window){
		
		String lineCompound = "";
		
		FileDialog fileDialog = new FileDialog(window, "Open File ",FileDialog.LOAD);
		fileDialog.setVisible(true);
		
		// set file name at the top of the window
		if (fileDialog.getFile() != null) {
			filename = fileDialog.getDirectory() + fileDialog.getFile();
			}
		if (filename != null){	
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filename));
				
				
				String line = null;
				String lineCompoundFile = "";
				
				while ((line = reader.readLine()) != null) {
					lineCompoundFile = lineCompoundFile +  line; // read lines from file into lineCompound
				}
				
				reader.close();
				textArea.setText(lineCompoundFile.toString()); // Set text read from file on textArea 
			
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("File not found");
				e1.printStackTrace();
			}
		}
		return filename;
	
	}

	

	

	

}
