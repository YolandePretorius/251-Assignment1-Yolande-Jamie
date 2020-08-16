package com.assignment1;

import java.awt.EventQueue;

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
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import java.awt.TextField;
import javax.swing.JTextArea;
import java.awt.TextArea;

public class TextMainWindow extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=185,-16
	 */
	private final JEditorPane editorPane = new JEditorPane();

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
		setTitle("Text Pad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenuItem newMenu = new JMenuItem("New ");
		fileMenu.add(newMenu);
		
		JMenuItem openFileMenu = new JMenuItem("Open File");
		fileMenu.add(openFileMenu);
		
		JSeparator separator = new JSeparator();
		fileMenu.add(separator);
		
		JMenuItem saveMenu = new JMenuItem("Save");
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Save.saveMethod(null);
			}
		});
		fileMenu.add(saveMenu);
		
		JSeparator separator_1 = new JSeparator();
		fileMenu.add(separator_1);
		
		JMenuItem printMenu = new JMenuItem("Print");
		fileMenu.add(printMenu);
		
		JSeparator separator_2 = new JSeparator();
		fileMenu.add(separator_2);
		
		JMenuItem exitMenu = new JMenuItem("Exit");
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
		
		JMenuItem copyMenu = new JMenuItem("Copy");
		editMenu.add(copyMenu);
		
		JMenuItem pasteMenu = new JMenuItem("Paste");
		editMenu.add(pasteMenu);
		
		JSeparator separator_4 = new JSeparator();
		editMenu.add(separator_4);
		
		JMenuItem timeDateMenu = new JMenuItem("Time/Date");
		editMenu.add(timeDateMenu);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem about = new JMenuItem("About Text Pad");
		helpMenu.add(about);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		TextArea textArea = new TextArea();
		contentPane.add(textArea);
	}
}
