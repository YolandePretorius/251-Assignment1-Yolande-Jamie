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
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;


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
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New ");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open File");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Print");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Exit");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenu("Search");
		menuBar.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("View");
		menuBar.add(mnNewMenu_3);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JSeparator separator_3 = new JSeparator();
		editMenu.add(separator_3);
		
		JMenuItem cutMenuItem = new JMenuItem("Cut");
		editMenu.add(cutMenuItem);
		cutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editorPane.cut();
//				String s = EditMenu.CutString(editorPane.getSelectedText());
//				editorPane.replaceSelection(s);
			}
		});
		
		JMenuItem copyMenuItem = new JMenuItem("Copy");
		editMenu.add(copyMenuItem);
		
		JMenuItem pasteMenuItem = new JMenuItem("Paste");
		editMenu.add(pasteMenuItem);
		
		JSeparator separator_4 = new JSeparator();
		editMenu.add(separator_4);
		
		JMenuItem timeDateMenuItem = new JMenuItem("Time/Date");
		editMenu.add(timeDateMenuItem);
		
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		
		JMenuItem aboutMenuItem = new JMenuItem("About Text Pad");
		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpMenu.aboutPopUp();
			}
		});
		helpMenu.add(aboutMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		TextArea textArea = new TextArea();
		contentPane.add(textArea);
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
