package com.assignment1;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JEditorPane;
import java.awt.TextField;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextArea;
import java.awt.TextArea;

import java.awt.Cursor;
import javax.swing.JTextPane;
import javax.swing.RepaintManager;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;


import java.awt.Cursor;
import javax.swing.JTextPane;
import javax.swing.RepaintManager;
import javax.swing.JTextField;
import javax.swing.DropMode;


public class TextMainWindow extends JFrame  {
	
	JMenuBar menuBar;
	//JFrame window;
	//JTextArea textArea;
	JScrollPane scrollPane;
	String filename;

	private JPanel contentPane;
	 JTextArea textArea = new JTextArea();
	
	private JTextField textField;
	//public TextArea textArea; 
	protected TextMainWindow window;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextMainWindow window = new TextMainWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public TextMainWindow() {							//Constructor		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 850, 700);
		setTitle("Textpad");
				
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		
		JMenuItem newMenu = new JMenuItem("New");
		newMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filename = null;
				textArea.setText(" ");
				setTitle(filename);
				
			}
		});
		
		
		
		fileMenu.add(newMenu);	
		JMenuItem openFileMenu = new JMenuItem("Open File");
		openFileMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				filename = OpenFileClass.openFunction(filename,textArea,window); //Class: Open a file 
				setTitle(filename);
					
				}
			});
	
		

		fileMenu.add(openFileMenu);
		
		JSeparator separator = new JSeparator();
		fileMenu.add(separator);
		

		//Save Class
		
		JMenuItem saveMenu = new JMenuItem("Save");
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				filename = SaveClass.saveMethod(filename,textArea, window);
				setTitle(filename);
				
			}
		});
		
		
		fileMenu.add(saveMenu);
		

		//Save As class
		

		JMenuItem SaveAs = new JMenuItem("Save As");
		SaveAs .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				filename = SaveAsClass.SaveAsFunction(filename,textArea,window); //Class: save a file 
				setTitle(filename);
			}
		});
		fileMenu.add(SaveAs);
		
		
		JSeparator separator_1 = new JSeparator();
		fileMenu.add(separator_1);
		
		

		 // Print class
		
		JMenuItem printMenu = new JMenuItem("Print");
		printMenu.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {

		PrintClass.printComponent(textArea);
			    

	
			}
		});
	
		fileMenu.add(printMenu);
		
		JSeparator separator_2 = new JSeparator();
		fileMenu.add(separator_2);
		
		

		// Exit text editor
		
		JMenuItem exitMenu = new JMenuItem("Exit");           
		exitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		fileMenu.add(exitMenu);

		
		//view Class
		JMenu viewMenu = new JMenu("View");
		menuBar.add(viewMenu);
		
		JMenu editMenu = new JMenu("Edit");  //create Edit menu

		menuBar.add(editMenu);
		
		JSeparator separator_3 = new JSeparator();
		editMenu.add(separator_3);

		// cut selected text and send to system clipboard
		JMenuItem cutMenu = new JMenuItem("Cut");
		editMenu.add(cutMenu);
		cutMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});

		// copy selected text and send to system clipboard
		JMenuItem copyMenu = new JMenuItem("Copy");
		editMenu.add(copyMenu);
		copyMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});

		// paste from system clipboard
		JMenuItem pasteMenu = new JMenuItem("Paste");
		editMenu.add(pasteMenu);
		pasteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});
		
		JSeparator separator_4 = new JSeparator();
		editMenu.add(separator_4);
		
		// insert date and time at top of text area
		JMenuItem timeDateMenu = new JMenuItem("Time/Date");
		editMenu.add(timeDateMenu);
		timeDateMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.insert(EditMenu.TimeAndDate(), 0);
			}
		});
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		// pop-up message box with information on text pad program created
		JMenuItem aboutMenuItem = new JMenuItem("About Text Pad");
		helpMenu.add(aboutMenuItem);
		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpMenu.aboutPopUp();
			}
		});
			
				final JButton SearchButton = new JButton("Search");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  
			    if (textField.getText().equals("")) {
			    	SearchClass.removeHighlighter(textArea);
			    }else {
			    	SearchClass.searchTextArea(textArea, textField.getText());
			    }
			}
		});
		menuBar.add(SearchButton);
		
		// search text field used to add text searching for
		textField = new JTextField();
		menuBar.add(textField);
		textField.setColumns(1);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		

		
		
		// text area functions: scroll and set cursor
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1);
		scrollPane_1.setViewportView(textArea);
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		
	
	}


	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}  

	}



}
