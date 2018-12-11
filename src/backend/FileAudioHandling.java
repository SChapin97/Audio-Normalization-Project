package backend;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/* This class is used as an abstraction of AudioHandling. Its main purpose is to determine the decibel level of audio file(s)
 * to be modified by the Normalizer.
 */
public class FileAudioHandling extends AudioHandling{

	AudioInputStream ais;
	SourceDataLine line;
	LineListener lineListener;
	
	//This is the default constructor for FileAudioHandling, which takes in a file and a float number how loud the playback should be.
	//Default volume is 0, but can go as low as -80 (silent) or 6 (very slightly louder).
	public FileAudioHandling(File inFile, float vol) throws UnsupportedAudioFileException, IOException {
		
		//This instantiates the AudioInputStream, which grabs the provided input file and places it in its buffer to be used with the line later.
		this.ais = AudioSystem.getAudioInputStream(inFile);

		//The Sound API only works with 16-bit PCM signed integer wav format files, if (almost) anything else is given, audioFormat will throw
		//an UnsupportedAudioFileException.
		AudioFormat audioFormat = ais.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

		try {
			if (line == null) {
				//If the audio system (default is audio output through Eclipse/ the GUI) can support line playback, the following if statement is triggered.
				boolean bIsSupportedDirectly = AudioSystem.isLineSupported(info);
				if (!bIsSupportedDirectly) {
					//This is an (ugly) conversion between the initial file format and a format that is usable by the AIS.
					AudioFormat sourceFormat = audioFormat;
					AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sourceFormat.getSampleRate(), sourceFormat.getSampleSizeInBits(),
							sourceFormat.getChannels(), sourceFormat.getChannels() * ( sourceFormat.getSampleSizeInBits() / 8 ), sourceFormat.getSampleRate(),
							sourceFormat.isBigEndian());
					ais = AudioSystem.getAudioInputStream(targetFormat, ais);
					audioFormat = ais.getFormat();
				}//end of if statement
				//This instantiates the SourceDataLine line, which is the main (usable) stream for playback and manipulation of audio files in the play method.
				info = new DataLine.Info(SourceDataLine.class, audioFormat);
				line = (SourceDataLine) AudioSystem.getLine(info);
			}//end of if statement

			//LineListener can be used as an alert for when the line changes (open, close, drain, etc.).
			if (lineListener != null) {
				line.addLineListener(lineListener);
			}//end of if statement
			//Opening the line allows for data i/o, and is instantiated with the above stated audio file format.
			line.open(audioFormat);
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
			return;
		}//end of try/catch block
		System.out.println("File, Line, and AIS for playback instantiated.");
		
		play(vol);
	}//end of Alternate Constructor

	
	//Code taken from the run method in https://bit.ly/2ElbI4N
		public void play(float vol)  {
			//This boolean should stop playing the file when true, but cannot be changed currently.
			boolean exitRequested = false;
			line.start();
			
			//volControl changes the volume on the line (how loud it plays back), but this change cannot be written to a file.
			//The equation for Master Gain is linearScalar = pow(10.0, gainDB/20.0)
			FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
			System.out.println("Volume before value is set: " + volControl.getValue());
			volControl.setValue(vol);
			System.out.println("Volume after value is set: " + volControl.getValue());
			
			//The following block will play the instantiated file from the line to the default output for the system in use.
			//Right now, an 'f' will be printed to command-line every time the loop completes one cycle.
			int nRead = 0;	//When the var.read sets this variable to -1, there is no more data to be read.
			byte[] abData = new byte[65532];	//the byte array is instantiated to slightly less than the size of a 16bit PCM signed WAV file
			while ( ( nRead != -1 ) && ( !exitRequested )) {
				try {
					nRead = ais.read(abData, 0, abData.length);
				} catch (IOException ex) {
					Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
				}//end of try/catch block
				
				//This statement is what actually "plays" the audio file.
				if (nRead >= 0) {
					line.write(abData, 0, nRead);
				}//end of if statement
				System.out.print("f");
			}//end of while loop

			//if the exitRequested variable becomes true, the line will stop reading data and release all of the data it has stored.
			if (!exitRequested) {
				line.drain();
			}//end of if statement
			
			line.close();
			
			System.out.println("end of play method.");
		}//end of play method
}//end of FileAudioHandling class
