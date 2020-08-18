package com.assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class OpenFileClass{  // class used to open a file from file system
	
	
	static String openFunction(String filename){
			
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			
			
			String line = null;
			String lineCompoundFile = "";
			
			while ((line = reader.readLine()) != null) {
				lineCompoundFile = lineCompoundFile +  line; // read lines from file into lineCompound
			}
			
			
			reader.close();
			return(lineCompoundFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("File not found");
			e1.printStackTrace();
		}
		
		return filename;
	
	}
	

}
