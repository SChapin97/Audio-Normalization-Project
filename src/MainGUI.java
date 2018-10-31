import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame{
		private static int WIDTH = 600;
		private static int HEIGHT = 600;
		private JButton fileSelect, submit, viewFile, export;
		private JComboBox decibelSelect;
		private JMenuBar menuBar;
		private JMenu file;
		private JMenuItem eMenuItem, hMenuItem;
		private JLabel progressField;
		private JLabel visualField;

		public MainGUI() {
			
			String[] decibel = {"72 -- Low", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84 -- Normal", "85",
					"86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96 -- High"};
			
			fileSelect = new JButton("File Select");
			submit = new JButton("Submit");
			viewFile = new JButton("View File");
			export = new JButton("Export");
			decibelSelect = new JComboBox(decibel);
			decibelSelect.setEditable(true);
			progressField = new JLabel("Current Progress: ", JLabel.CENTER);
			visualField = new JLabel("Visual Field", JLabel.CENTER);
			
			menuBar = new JMenuBar();
			file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			hMenuItem = new JMenuItem("Help");
			eMenuItem = new JMenuItem("Exit");
			menuBar.add(file);
			setJMenuBar(menuBar);		
			
			Container pane = this.getContentPane();
			pane.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();

			c.fill = GridBagConstraints.HORIZONTAL;
			c.ipady = 30;
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = 0;
			pane.add(fileSelect, c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 1;
			c.gridy = 0;
			pane.add(decibelSelect,c );
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 1;
			pane.add(submit,c );
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.ipady = 80;
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 2;
			pane.add(progressField, c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.ipady = 30;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 3;
			pane.add(viewFile, c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridx = 1;
			c.gridy = 3;
			pane.add(export, c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.ipady = 200;
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 4;
			pane.add(visualField, c);
			
			file.add(hMenuItem);
			file.add(eMenuItem);
			
			fileSelect.addActionListener(new fileSelectHandler());
			decibelSelect.addActionListener(new decibelSelectHandler());
			submit.addActionListener(new submitHandler());
			viewFile.addActionListener(new viewFileHandler());
			export.addActionListener(new exportHandler());
			eMenuItem.addActionListener(new eMenuItemHandler());
			hMenuItem.addActionListener(new hMenuItemHandler());;
			
			this.setTitle("Audio Normalization");
			this.setSize(WIDTH, HEIGHT);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
		
		public static void main(String[] args){
			MainGUI gui = new MainGUI();
		}
		
		private class fileSelectHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
			}
		}
		
		private class decibelSelectHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
			}
		}
		
		private class submitHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
			}
		}
		
		private class viewFileHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
			}
		}
		
		private class exportHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
			}
		}
		
		private class eMenuItemHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}
		}
		
		private class hMenuItemHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
			}
		}
		
		
}
