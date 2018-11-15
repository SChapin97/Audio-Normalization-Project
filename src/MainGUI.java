import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static int WIDTH = 600;
		private static int HEIGHT = 600;
		private JButton fileSelect, submit, viewFile, export;
		private JComboBox<String> decibelSelect;
		private JMenuBar menuBar;
		private JMenu file;
		private JMenuItem eMenuItem, hMenuItem;
		private JLabel progressField;
		private JLabel visualField;
		private JScrollPane fileField;
		private fileSelectHandler fsh;
		private decibelSelectHandler dsh;
		private submitHandler sbth;
		
		public MainGUI() {
			
			fsh = new fileSelectHandler();
			dsh = new decibelSelectHandler();
			sbth = new submitHandler(fsh, dsh);

			Font size = new Font("Arial", Font.PLAIN, 20);
			
			fileSelect = new JButton("File Select");
			submit = new JButton("Submit");
			viewFile = new JButton("View File");
			export = new JButton("Export");
			decibelSelect = new JComboBox<String>(dsh.getDecibels());
			decibelSelect.setSelectedIndex(12);
			decibelSelect.setEditable(true);
			progressField = new JLabel("Current Progress: ", JLabel.CENTER);
			visualField = new JLabel("Visual Field", JLabel.CENTER);
			fileField = new JScrollPane();
			menuBar = new JMenuBar();
			file = new JMenu("File");
			file.setMnemonic(KeyEvent.VK_F);
			hMenuItem = new JMenuItem("Help");
			eMenuItem = new JMenuItem("Exit");
			menuBar.add(file);
			setJMenuBar(menuBar);
			
			fileSelect.setFont(size);
			submit.setFont(size);
			viewFile.setFont(size);
			export.setFont(size);
			decibelSelect.setFont(size);
			progressField.setFont(size);
			file.setFont(size);
			hMenuItem.setFont(size);
			eMenuItem.setFont(size);
			
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
			pane.add(decibelSelect, c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.gridwidth = 2;
			c.gridx = 0;
			c.gridy = 1;
			pane.add(submit, c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.ipady = 80;
			c.gridwidth = 1;
			c.gridx = 0;
			c.gridy = 2;
			pane.add(fileField, c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 0.5;
			c.ipady = 80;
			c.gridwidth = 1;
			c.gridx = 1;
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
			
			fileSelect.addActionListener(fsh);
			submit.addActionListener(sbth);
			decibelSelect.addActionListener(dsh);
			viewFile.addActionListener(new viewFileHandler());
			export.addActionListener(new exportHandler());
			eMenuItem.addActionListener(new eMenuItemHandler());
			hMenuItem.addActionListener(new hMenuItemHandler());;
			
			this.setTitle("Audio Normalization");
			this.setSize(WIDTH, HEIGHT);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setVisible(true);
			
		}
		
}
