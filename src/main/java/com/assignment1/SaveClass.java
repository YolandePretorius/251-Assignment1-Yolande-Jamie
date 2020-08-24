package com.assignment1;

import java.io.FileWriter;
import java.io.IOException;

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
