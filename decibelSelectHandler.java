import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class decibelSelectHandler implements ActionListener {
	
	private JComboBox<String> dSelect;
	private String[] decibels;
	private String selection;
	
	public decibelSelectHandler(){
		decibels = new String [] {"72 -- Low", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84 -- Normal", "85",
				"86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96 -- High"};
	}
	
	public String[] getDecibels() {
		return decibels;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dSelect =(JComboBox<String>)e.getSource();
		selection = String.valueOf(dSelect.getSelectedItem());
	}

	public String getSelection(){
		return selection;
	}

}
