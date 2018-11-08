 package backend;

import java.io.*;

/* This class is used to create File objects for use with unbuffered audio streams to manage the decibel level of files that are
 * to be modified by the Normalizer class.
 */

//this is a test commit, this is the only change



public class File {

	//TODO: delete this later, move to constructor as per Open-Closed Principle
	private FileInputStream in;
	private FileOutputStream out;
	
	public File() {
		instantiateFileIO();
	}//end of Default Constructor
	
	public void instantiateFileIO() {
		in = null;
		out = null;
	}//end of instantiateFileIO method
	
	public void instantiateFileIO(FileInputStream in, FileOutputStream out) {
		//TODO: implement the i/o streams with dynamically allocated file directories.
		this.in = in;
		this.out = out;
	}//end of instantiateFileIO method
	
}//end of File class
