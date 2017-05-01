import java.util.*;

public class MyDeque{
    int head, tail;
    String[] dequebody;
    
    public MyDeque(int initialCapacity){
	dequebody  = new String[initialCapacity];
	// This is for adding the first element 
	head = -1;
	tail = 0;
    }

    public MyDeque(){
	this(16);
    }

    //makes stuff more convenient
    public int size(){
	return head - tail + 1;
    }
    
    //makeReal turns my fake array into my real array in respect to the indices
    private int makeReal(int index){
	return Math.floorMod( index, dequebody.length ); 
    }

    public String getFirst(){
	sizeChecker();
	return dequebody[makeReal(head)];
    }

    public String getLast(){
	sizeChecker();
	return dequebody[makeReal(tail)];
    }

    public String removeFirst(){
	sizeChecker();
	return dequebody[makeReal(head--)];
    }

    public String removeLast(){
	sizeChecker();
	return dequebody[makeReal(tail++)];
    }

    public void addFirst(String thingtoadd){
	if(thingtoadd == null){
	    throw new NullPointerException();
	}
	if (size() == dequebody.length){
	    String[] newArray = new String[dequebody.length * 2];
	    for(int x = head; x >= tail; x--){
		newArray[Math.floorMod(x, newArray.length)] = dequebody[makeReal(x)];
	    }
	    dequebody = newArray;
	}
	dequebody[makeReal(++head)] = thingtoadd; 
    }

    public void addLast(String thingtoadd){
	if(thingtoadd == null){
	    throw new NullPointerException();
	}
	if (size() == dequebody.length){
	    String[] newArray = new String[dequebody.length * 2];
	    for(int x = head; x >= tail; x--){
		newArray[Math.floorMod(x, newArray.length)] = dequebody[makeReal(x)];
	    }
	    dequebody = newArray;
	}
	dequebody[makeReal(--tail)] = thingtoadd;
    }

    private void sizeChecker(){
	if (size() == 0){
	    throw new NoSuchElementException("your size is 0?!");
	}
    }

    public String toString(){
	String[] bullshit = new String[size()];
	int bullshitIndexCounter = 0;
	for (int x = head; x >= tail; x--){
	    bullshit[bullshitIndexCounter++] = dequebody[makeReal(x)];
	}
	return Arrays.toString(bullshit);
    }
    
    public static void main(String[] args) {
	MyDeque md = new MyDeque();
	for(int i = 0; i<32; md.addFirst("apple")) {i++;}
	System.out.println(" size: " + md.size());
	for (int i=0; i<256; md.addLast(md.removeFirst())) {i++;}
	System.out.println(" size: " + md.size());
	while (true)
	    try {
		md.removeFirst();
		md.removeLast();
	    } catch (NoSuchElementException e) {
		break;
	    }
	md.addFirst("banana");
	for (int i=0; i<16; md.addFirst(md.getFirst() + "na")) {i++;}
	System.out.println(" size: " + md.size());
	for (int i=0; i<8; md.addLast(md.getLast() + "na")) {i++;}
	System.out.println(" size: " + md.size());
    }

}
