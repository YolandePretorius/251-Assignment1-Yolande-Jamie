package com.assignment1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EditMenu {


	static String timeAndDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy\nHH:mm\n");  
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
		
	}

	

}
