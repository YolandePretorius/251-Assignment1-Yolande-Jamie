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


public class TextMainWindow extends JFrame implements Printable {
	
	String filename;

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=185,-16
	 */
	private final JEditorPane editorPane = new JEditorPane();
	private final JTextArea textArea = new JTextArea();
	//public TextArea textArea; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextMainWindow frame = new TextMainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TextMainWindow() {
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
				
				filename = OpenFileClass.openFunction(filename,textArea,TextMainWindow.this); //Class: Open a file 
				setTitle(filename);
					
				}
			});
	
		
		fileMenu.add(openFileMenu);
		
		JSeparator separator = new JSeparator();
		fileMenu.add(separator);
		
		JMenuItem saveMenu = new JMenuItem("Save");
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				filename = SaveClass.saveMethod(filename,textArea, TextMainWindow.this);
				setTitle(filename);
				
			}
		});
		
		
		fileMenu.add(saveMenu);
		
		JMenuItem SaveAs = new JMenuItem("Save As");
		SaveAs .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				filename = SaveAsClass.SaveAsFunction(filename,textArea,TextMainWindow.this); //Class: save a file 
				setTitle(filename);
			}
		});
		fileMenu.add(SaveAs);
		
		
		JSeparator separator_1 = new JSeparator();
		fileMenu.add(separator_1);
		
		
		JMenuItem printMenu = new JMenuItem("Print");
		printMenu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PrintUtilities.printComponent(textArea);     // Print class 
	
			}
		});
	
		fileMenu.add(printMenu);
		
		JSeparator separator_2 = new JSeparator();
		fileMenu.add(separator_2);
		
		
		
		JMenuItem exitMenu = new JMenuItem("Exit");           // Exit text editor
		exitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		fileMenu.add(exitMenu);
		
		
		JMenuItem searchMenu = new JMenu("Search");
		menuBar.add(searchMenu);
		
		JMenu viewMenu = new JMenu("View");
		menuBar.add(viewMenu);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JSeparator separator_3 = new JSeparator();
		editMenu.add(separator_3);
		

		JMenuItem cutMenu = new JMenuItem("Cut");
		editMenu.add(cutMenu);
		cutMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String s = EditMenu.CutString(textArea.getSelectedText());
//				textArea.replaceSelection(s);
				textArea.copy();
			}
		});

		JMenuItem copyMenu = new JMenuItem("Copy");
		editMenu.add(copyMenu);
		copyMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				EditMenu.CopyString(textArea.getSelectedText());
				textArea.cut();
			}
		});

		JMenuItem pasteMenu = new JMenuItem("Paste");
		editMenu.add(pasteMenu);
		pasteMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});
		
		JSeparator separator_4 = new JSeparator();
		editMenu.add(separator_4);
		
		JMenuItem timeDateMenu = new JMenuItem("Time/Date");
		editMenu.add(timeDateMenu);
		timeDateMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.insert(EditMenu.TimeAndDate(), 0);
			}
		});
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem about = new JMenuItem("About Text Pad");
		
		helpMenu.add(about);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		// Add text area to window frame
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.add(textArea);
		
		
	
	}


	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		return 0;
	}



}
