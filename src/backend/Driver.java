package backend;

import java.io.IOException;
import java.io.File;

import javax.sound.sampled.UnsupportedAudioFileException;

public class Driver {

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
		//File file = new File();
		//Normalizer nmz = new Normalizer();

		File gtbt = new File("gtbt3.wav");
		Normalizer nmz = new Normalizer(gtbt);
		nmz.setGain(6.0f);
		
		
	}//end of main method

}//end of Driver class
