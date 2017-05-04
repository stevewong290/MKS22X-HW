import java.util.*;

String[] heap;
boolean max;


public class MyHeap{
    public MyHeap(){
	heap  = new String[1];
    }
    public MyHeap(boolean b){
	max = b;
	heap = newString[1]; 
    }

    public void add(String s){
	if(max == true){

	}
	else {

	}
    }

    public String remove(){
	if(max == true){

	}
	else {

	}
    }

    public String peek(){
	return heap[1];
    }

    private String pushUp(int index){
	if(max == true){
	    if((heap[index/2].compareTo(heap[index]) > 0)){
		    
	    }  
	}
	else{

	}
    }

    private String pushDown(int index){

    }

    private void swap(int x, int y){
	int temp = heap[y];
	heap[y] = heap[x];
	heap[x] = temp;
    }
    
    public String toString(){
	
    }
}
