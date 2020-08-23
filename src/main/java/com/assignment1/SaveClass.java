package com.assignment1;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class SaveClass {


	public static void saveMethod(String fileName, String textArea) {		
		
		
				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter(fileName);
					fileWriter.write(textArea);
					fileWriter.close();		
				} catch (IOException e) {
					System.out.println("Couldn't save file");
				
				} 
				

		}

}
