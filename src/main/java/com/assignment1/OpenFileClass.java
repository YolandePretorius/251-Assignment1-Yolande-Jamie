package com.assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class OpenFileClass{  // class used to open a file from file system
	
	
	public static String openFunction(String filename){
		
		 //Create a String that will store all text in the text file  
		  String storeAllString="";  
	  	if (filename != null){
	  		try {
	  			
	  			BufferedReader readTextFile = new BufferedReader(new FileReader(filename));
	  		 		  
	  		  //Create a scanner object from FileReader  
	  		  Scanner fileReaderScan=new Scanner(readTextFile);  
	  		  	 
	  		  
	  		  //Put all text from text file into created String  
	  		  while(fileReaderScan.hasNextLine())  
	  		  {  
	  		   String temp=fileReaderScan.nextLine()+"\n";  
	  		    
	  		   storeAllString=storeAllString+temp;  
	  		  }  
	  		return storeAllString;
	  			
	  		} catch (FileNotFoundException e1) {
	  	}
	  		
	  }
	  	return storeAllString;

	}
	
	
}
	
