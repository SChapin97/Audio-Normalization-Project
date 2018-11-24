package backend;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/*This is the Java Sound API, which handles audio files, audio streams, and MIDI devices.
 *The sampled package in the Sound API handles audio files and audio streams while the midi package handles MIDI i/o.
 *The sampled package mainly handles real-time audio, but is used for audio file manipulation in this case.
 */
import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;

/* This is the Normalizer class, which handles the detection, and modification, of decibel levels. The main goal of the Audio
 * Normalization Project is to modify audio files (unbuffered audio streams), but a side goal is to incorporate live audio streams
 * (buffered audio streams) for modification of live decibel levels.
 */

//Oracle Doc: https://docs.oracle.com/javase/7/docs/technotes/guides/sound/programmer_guide/chapter6.html

public class Normalizer {
	
	//TODO: Refactor this later, as per Open-Closed Principle
	Queue<File> fileInputQueue;
	Queue<File> fileOutputQueue;
	File file;
	AudioInputStream ais;
	SourceDataLine line;
	LineListener lineListener;
	int requestedGain;
	
	//run on a separate thread than the GUI
	//might not need it
	
	//The final program will likely utilize either the default or the alternate constructor 
	//based on when the code is initialized, but both are included at this time 
	public Normalizer () throws IOException, UnsupportedAudioFileException{ 
		//fileInputQueue = new LinkedList<File>();
		//fileOutputQueue = new LinkedList<File>();
		//requestedGain = 0;
	}//end of Default Constructor
	
	public Normalizer(File file) throws UnsupportedAudioFileException, IOException {
		//this.fileInputQueue = fileInputQueue;
		
		//this.requestedGain = requestedGain;
		this.file = file;
		
		if (file.exists()) System.out.println("audio file exists :)");
		this.ais = AudioSystem.getAudioInputStream(file);
	}//end of Alternate Constructor

	
	//from https://www.programcreek.com/java-api-examples/?api=javax.sound.sampled.FloatControl
	public void setGain(float fGain) {
		
		boolean exitRequested = false;
		
		AudioFormat audioFormat = ais.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		
		System.out.println("right before try/catch block :)");
		try {
			if (line == null) {
				boolean bIsSupportedDirectly = AudioSystem.isLineSupported(info);
				if (!bIsSupportedDirectly) {
					AudioFormat sourceFormat = audioFormat;
					AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, sourceFormat.getSampleRate(), sourceFormat.getSampleSizeInBits(),
							sourceFormat.getChannels(), sourceFormat.getChannels() * ( sourceFormat.getSampleSizeInBits() / 8 ), sourceFormat.getSampleRate(),
							sourceFormat.isBigEndian());
					
					ais = AudioSystem.getAudioInputStream(targetFormat, ais);
					audioFormat = ais.getFormat();
				}
				info = new DataLine.Info(SourceDataLine.class, audioFormat);
				line = (SourceDataLine) AudioSystem.getLine(info);
			}
			if (lineListener != null) {
				line.addLineListener(lineListener);
			}
			line.open(audioFormat);
		} catch (Exception ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
			return;
		}
		System.out.println("Right after try/catch block :)");
		
		
		line.start();
		System.out.println("line format: " + line.getFormat());
		FloatControl gainControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
		//The algorithm for Master Gain is linearScalar = pow(10.0, gainDB/20.0)
		
		System.out.println("line toString: " + line.toString());
		
		try {
			System.out.println("ais availability: " + ais.available());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ais get format: " + ais.getFormat());
		
		System.out.println(gainControl.getUnits());
		System.out.println(gainControl.getValue());
		//gainControl.setValue(1.0f);
		System.out.println(gainControl.getValue());
		//setGain(getGainValue());
		
		System.out.println("right after setgain :)");
		int nRead = 0;
		gainControl.setValue(0.0f);
		
		float vol = 0f;
		byte[] abData = new byte[65532];
		while ( ( nRead != -1 ) && ( !exitRequested )) {
			try {
				nRead = ais.read(abData, 0, abData.length);
			} catch (IOException ex) {
				Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
			}
			if (nRead >= 0) {
				line.write(abData, 0, nRead);
			}
			System.out.print("f");
		}
		
		System.out.println("\ngain level: " + gainControl.getValue());
		
		if (!exitRequested) {
			line.drain();
		}
		
		System.out.println("end of run method :)");
		line.close();
	}//end of setGain method
	
	private void addFile(File file) {
		fileInputQueue.add(file);
	}//end of addFiles method
	
	//this method displays a file object's position in the queue.
	private void displayPosition() {
		System.out.println("This file is in position " + fileOutputQueue.size() + " of the queue.");
	}//end of displayPosition method
	
	//this method displays the size of the queue.
	private void displayTotalSize() {
		System.out.println("The queue is " + (fileInputQueue.size() + fileOutputQueue.size()) + " files large.");
	}//end of displayTotalSize method
	
}//end of Normalizer class
