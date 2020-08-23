package com.assignment1;

import javax.swing.JOptionPane;

public class HelpMenu {

	public static void aboutPopUp() {
		String about = "ASSIGNMENT 1 TEAM"
				+ "\nYolande Pretorius\n"
				+ "Jamie Weddell\n\n"
				+ "\nThis is a text editor created for Massey University paper 159.251\n"
				+ "for the first assignment. This is to showcase our skills not only\n"
				+ "with java, but with git repositories, working as a team, noting issues,\n"
				+ "finding bugs, and working with metrics.\n\n\n";
		JOptionPane.showMessageDialog(null, about);

	}

}
