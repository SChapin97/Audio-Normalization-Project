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

	public Normalizer() {
		
	}//end of Default Constructor
	
	private void normalize(Queue fileQueue) {
		//AudioInputStream audin = new AudioInputStream(fileQueue);
	}//end of normalize method
	
	private void fileQueue() {
		//TODO: Change to Queue
		LinkedList<File> fileQueue = new LinkedList<File>();
		//fileQueue.add(file.getFile());
		
	}//end of fileQueue class
	
	
}//end of Normalizer class
