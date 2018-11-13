package backend;

import java.util.LinkedList;
import java.util.Queue;

/*This is the Java Sound API, which handles audio files, audio streams, and MIDI devices.
 *The sampled package in the Sound API handles audio files and audio streams while the midi package handles MIDI i/o.
 *The sampled package mainly handles real-time audio, but is used for audio file manipulation in this case.
*/
import javax.sound.sampled.*;
import java.io.InputStream;

/* This is the Normalizer class, which handles the detection, and modification, of decibel levels. The main goal of the Audio
 * Normalization Project is to modify audio files (unbuffered audio streams), but a side goal is to encorporate live audio streams
 * (buffered audio streams) for modification of live decibel levels.
 */

public class Normalizer extends File{

	//https://docs.oracle.com/javase/7/docs/technotes/guides/sound/programmer_guide/chapter6.html
	
	FloatControl decibelLevel; //Vital variable: it gets decibel level, gets type, gets units, and sets value for files.
	Queue<File> fileQueue;
	File file;
	
	//The final program will likely utilize either the default or the alternate constructor 
	//based on when the code is initialized, but both are included at this time 
	public Normalizer () {
		fileQueue = new LinkedList<File>();
		file = new File();
		
	}//end of Default Constructor
	
	public Normalizer(Queue<File> fileQueue) {
		this.fileQueue = fileQueue;
		file = new File();
		
		
		for (File files : fileQueue) {
			normalize(files);
		}//end of for loop
	}//end of Alternate Constructor
	
	private void normalize(File file) {
		AudioInputStream audin = new AudioInputStream((TargetDataLine) file);
			
		//TODO: iterate each file in the Queue with decibelLevel to: 1. display gain level, 
		//2. modify gain, and 3. display gain level after modification
		
	}//end of normalize method
	
	
	private void addFile() {
		while (file != null) {
			//fileQueue.add(getFile());
		}//end of while loop
	}//end of addFiles method
	
}//end of Normalizer class
