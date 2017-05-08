import java.util.*;


public class MyHeap{
    String[] heap;
    boolean max;
    public MyHeap(){
	heap  = new String[1];
    }
    public MyHeap(boolean b){
	max = b;
	heap = new String[1]; 
    }

    public void add(String s){
	if(max == true){

	}
	else {
	    
	}
    }

    public String remove(){
	if(max == true){
	    return "hi";
	}
	else {
	    return "hi";
	}
    }

    public String peek(){
	return heap[1];
    }

    private String pushUp(int index){
	if(max == true){
	    if((heap[index/2].compareTo(heap[index]) > 0)){
		String temp = heap[index];
		heap[index] = heap[index/2];
		heap[index/2] = temp;
		return pushUp(index/2);
	    }  
	    return "working";
	}
	else{
	    if((heap[index/2].compareTo(heap[index]) < 0)){
		String temp = heap[index];
		heap[index] = heap[index/2];
		heap[index/2] = temp;
		return pushUp(index/2);
	    }  
	    return "working";   
	}
    }

    private String pushDown(int index){
	return "hi";
    }

    private void swap(int x, int y){
	String temp = heap[y];
	heap[y] = heap[x];
	heap[x] = temp;
    }
    
    private int length(){
	return heap.length;
    }
    
    public String toString(){
	String s = "[";
	for(int x = 0; x < heap.length; x++){
	    s += heap[x] + ", ";
	}
	return s + "]";
    }

    public static void main(String[] args){
	MyHeap a = new MyHeap();
	System.out.println(a);
	System.out.println(a.length);
    }
}
