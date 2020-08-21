package com.assignment1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EditMenu {


	static String TimeAndDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy\nHH:mm\n");  
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
		
	}

	

}
