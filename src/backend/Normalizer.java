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

//Oracle Doc: https://docs.oracle.com/javase/7/docs/technotes/guides/sound/programmer_guide/chapter6.html

public class Normalizer extends File {
	
	//TODO: Refactor this later, as per Open-Closed Principle
	FloatControl decibelLevel; //Vital variable: it gets decibel level, gets type, gets units, and sets value for files.
	Queue<File> fileQueue; //Add a second queue so that there is a file input queue and a file output queue? Easier for displaying position.
	File file;
	int requestedGain;
	
	//The final program will likely utilize either the default or the alternate constructor 
	//based on when the code is initialized, but both are included at this time 
	public Normalizer () {
		fileQueue = new LinkedList<File>();
		file = new File();
		requestedGain = 0;
		
	}//end of Default Constructor
	
	public Normalizer(Queue<File> fileQueue, int requestedGain) {
		this.fileQueue = fileQueue;
		file = new File();
		this.requestedGain = requestedGain;
		
		for (File files : fileQueue) {
			normalize(files);
		}//end of for loop
	}//end of Alternate Constructor

	private void normalize(File file) {
		AudioInputStream audin = new AudioInputStream((TargetDataLine) file); //Need a mixer as well? Maybe not because it's unbuffered.
			
		//TODO: iterate each file in the Queue with decibelLevel to: 1. display gain level, 
		//2. modify gain, and 3. display gain level after modification
		
	}//end of normalize method
	
	private void addFile(File file) {
		fileQueue.add(file);
	}//end of addFiles method
	
	//this method displays a file object's position in the queue.
	private void displayPosition() {
		//TODO: implement a second queue and use the size of that and the first to determine current status.
		
		//System.out.println("This file is in position " + file. + " of the queue.");
	}//end of displayPosition method
	
	//this method displays the size of the queue.
	private void displayTotalSize() {
		System.out.println("The queue is " + fileQueue.size() + " files large.");
	}//end of displayTotalSize method
	
}//end of Normalizer class
