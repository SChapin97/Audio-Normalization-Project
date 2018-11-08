import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.Object.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FileDialog.*;
import java.awt.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.JList.*;

public class fileSelectHandler implements ActionListener {
	private JLabel warn[];
	private int sWIDTH = 300;
	private int sHEIGHT = 100;
	private static int WIDTH = 600;
	private static int HEIGHT = 600;
	private File[] file;
	private JFrame FH;
	private Container sFH;
	private List medfile;
	
	public fileSelectHandler() {
		FH = new JFrame();
		sFH = new JFrame();
		warn= new JLabel[2];
		warn[0]= new JLabel("No File Was Choosen...", JLabel.CENTER);
		warn[1]= new JLabel("You chose: ", JLabel.CENTER);
		file= new File[5];
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		sFH.setSize(sWIDTH, sHEIGHT);
		sFH.setLayout(new GridBagLayout());
		GridBagConstraints sC = new GridBagConstraints();
		//pane doesn't show full JLabel
		sC.fill = GridBagConstraints.CENTER;
		sC.weightx = 0.5;
		sC.ipady = 200;
		sC.gridwidth = 2;
		sC.gridx = 0;
		sC.gridy = 8;
		
		FH.setSize(WIDTH, HEIGHT);
		FH.setLayout(null);
		FH.setVisible(true);
		FH.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		FileDialog FD = new FileDialog(FH,"Choose A File:", FileDialog.LOAD);
		FD.setDirectory("");
		FD.setFile("*.mp3");
		FD.setVisible(true);
		medfile= new List();
		medfile.add(FD.getFile());
		
		if(file == null) {
			sFH.add(warn[0], sC);
			sFH.setVisible(true);
		}
		else {
			sFH.add(warn[1],sC);
			sFH.setVisible(true);
		}
		
	}
	
	public List gtFiles() {
		return medfile;
	}	

}
