package frontend;
import java.io.File;

public class fileQueue {
	
	private int maxSize;
	private int nItems;
	private File[] fileArray;
	private int front;
	private int rear;

	public fileQueue() {
		maxSize = 100;
		fileArray = new File[maxSize];
		nItems = 0;
		front = 0;
		rear = -1;
	}
	
	public void insert(File[] file) {
		for(File f : file) {
			if(rear == maxSize-1)
				rear = -1;
			fileArray[++rear] = f;
			nItems ++;
		}
	}

	public File remove() {
	   File temp = fileArray[front++];
	   if(front == maxSize)
	      front = 0;
	   nItems --;
	   return temp;
	}

	public boolean isEmpty() {
	   return (rear + 1 == front || (front + maxSize - 1 == rear));
	}
	
	public File peek() {
		return fileArray[front];
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public int size() {
		return nItems;
	}
	
	
	public String print() {
		String toString = "";
		for(File f : fileArray) {
			if (f != null) {
				toString += f.getName() + "\n";
			}
		}
		return toString;
	}

}
