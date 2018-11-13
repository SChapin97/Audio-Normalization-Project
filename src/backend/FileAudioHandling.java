package backend;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/* This class is used as an abstraction of AudioHandling. Its main purpose is to determine the decibel level of audio file(s)
 * to be modified by the Normalizer.
 */
public class FileAudioHandling extends AudioHandling{

	/*
	 * //Bit taken from https://docs.oracle.com/javase/7/docs/technotes/guides/sound/programmer_guide/chapter7.html 
		int totalFramesRead = 0;
		File fileIn = new File(somePathName);
		// somePathName is a pre-existing string whose value was
		// based on a user selection.
		  AudioInputStream audioInputStream = 
		    AudioSystem.getAudioInputStream(fileIn);
		  int bytesPerFrame = 
		    audioInputStream.getFormat().getFrameSize();
		  // Set an arbitrary buffer size of 1024 frames.
		  int numBytes = 1024 * bytesPerFrame; 
		  byte[] audioBytes = new byte[numBytes];
		  
		  int numBytesRead = 0;
		  int numFramesRead = 0;
		  // Try to read numBytes bytes from the file.
		  while ((numBytesRead = audioInputStream.read(audioBytes)) != -1) {
		    // Calculate the number of frames actually read.
		    numFramesRead = numBytesRead / bytesPerFrame;
		    totalFramesRead += numFramesRead;
		    // Here, do something useful with the audio data that's 
		    // now in the audioBytes array...
		  }//end of while loop
	 */
	
}//end of FileAudioHandling class
