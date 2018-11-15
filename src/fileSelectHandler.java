import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class fileSelectHandler implements ActionListener {

	private JLabel warn;
	private int WIDTH = 300;
	private int HEIGHT = 200;
	private File[] file;
	private JFrame FH;
	private FileDialog fd;
	private fileQueue fQ;
	private JLabel fileList;
	private String[] medlist;
	
	public fileSelectHandler() {
		FH = new JFrame();
		warn = new JLabel("No File Was Chosen", JLabel.CENTER);
		fd = new FileDialog(new JFrame(), "Choose a file", FileDialog.LOAD);
		fQ = new fileQueue();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fd.setDirectory("");
		fd.setFile("*.mp3");
		fd.setMultipleMode(true);
		fd.setVisible(true);
		file = fd.getFiles();
		//currently allows same file to be added multiple times
		fQ.insert(file);
		FH.setSize(WIDTH, HEIGHT);
		fileList = new JLabel(toString(), JLabel.CENTER);
		
		if (fQ.peek() == null) {
			FH.add(warn);
			FH.setVisible(true);
			FH.remove(fileList);
		}
		else {
			//this will be removed when the fileField scroll pane is working 
			FH.add(fileList);
			FH.setVisible(true);
			FH.remove(warn);
		}
		
	}
	
	public fileQueue getQueue(){
		return fQ;
	}
	
	public String toString() {
		String toString = "<html>You choose: <br>";
		if (fQ.peek() != null) {
			for(File f : file) {
				toString += f.getName() + "<br>";
			}
		}
		toString += "</html>";
		return toString;
	}
	
	public String[] getFileNames() {
		int x = 0;
		for (File f : file) {
			medlist[x++] = f.getName();
		}
		return medlist;
	}
}
