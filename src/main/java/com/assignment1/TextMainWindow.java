package com.assignment1;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;

import javax.swing.JTextArea;
import java.awt.Cursor;
import javax.swing.JTextField;



public class TextMainWindow extends JFrame  {
	
	JMenuBar menuBar;
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
				FileDialog fileDialog = new FileDialog(window, "Open File ",FileDialog.LOAD);
				fileDialog.setVisible(true);
				
				// set file name at the top of the window
				if (fileDialog.getFile() != null) {
					filename = fileDialog.getDirectory() + fileDialog.getFile();
					}
				
				String fileContent = OpenFileClass.openFunction(filename); //Class: Open a file 
				
				textArea.setText(fileContent); // Set text read from file on textArea
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

				if (filename != null) {					
					SaveClass.saveMethod(filename,textArea.getText());
					
				}else {
					filename = SaveAsClass.SaveAsFunction(filename, textArea.getText(), window);
				}setTitle(filename);
				
			}
		});
		
		
		fileMenu.add(saveMenu);
		

		//Save As class
		

		JMenuItem SaveAs = new JMenuItem("Save As");
		SaveAs .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				filename = SaveAsClass.SaveAsFunction(filename,textArea.getText(),window); //Class: save a file 

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
				textArea.insert(EditMenu.timeAndDate(), 0);
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


}
