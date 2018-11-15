package frontend;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class submitHandler implements ActionListener {

	private fileQueue fq;
	private String decibel;
	private decibelSelectHandler dsh;
	
	public submitHandler(fileSelectHandler fsh, decibelSelectHandler dsh){
		fq = fsh.getQueue();
		this.dsh = dsh;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		decibel = dsh.getSelection();
		// if statement handles null case if user does not opt to move from default setting
		if (decibel == null) {
			decibel = "84";
		}
		//needs to convert decibel to an integer
		//needs to call exception handlers for user cases putting in non integer values

		//remove these statements after completion
		System.out.println(fq.print());
		System.out.println(decibel);
		
		//needs to call the backend
	}

}
