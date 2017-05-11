import java.util.*;


public class MyHeap{
    String[] heap;
    boolean max;
    int heapsize;
    public MyHeap(){
	heap  = new String[16];
	heapsize = 0;
    }
    public MyHeap(boolean b){
	max = b;
	heap = new String[16];
	heapsize = 0;
    }

    public void add(String s){
	if (heapsize == heap.length){
	    heap = Arrays.copyOf(heap, heap.length*2);
	}
	heap[++heapsize] = s;
	pushUp(heapsize);
    }

    public String remove(){
	if(heapsize == 0){
	    throw new NoSuchElementException();
	}
	String str = peek();
	heap[1] = heap[heapsize--];
	pushDown(1);
	return str;
    }

    public String peek(){
	return heap[1];
    }

    private void pushUp(int index){
	if(index == 1){
	    return;
	}
	if(max == true){
	    if((heap[index/2].compareTo(heap[index]) < 0)){
		swap(index/2, index);
		pushUp(index/2);
	    }  
	}
	else {
	    if((heap[index/2].compareTo(heap[index]) < 0)){
		swap(index/2, index);
		pushUp(index/2);
	    }  
	}
    }

    private void pushDown(int index){
	if(index*2 > heapsize){
	    return;
	}
		
	if(max == true){
	    if(heap[index*2].compareTo(heap[index*2 + 1]) > 0){
		if((heap[index].compareTo(heap[index*2]) < 0)){
		    swap(index*2, index);
		    pushDown(index*2);
		}
	    }
	    else if(heap[index].compareTo(heap[index*2+1]) < 0){
		swap(index*2 + 1, index);
		pushDown(index*2);
	    }
	}
	else{
	    if(heap[index*2].compareTo(heap[index*2 + 1]) < 0){
		if((heap[index].compareTo(heap[index*2]) > 0)){
		    swap(index*2, index);
		    pushDown(index*2);
		}
	    }
	    else if(heap[index].compareTo(heap[index*2+1]) > 0){
		swap(index*2 + 1, index);
		pushDown(index*2);
	    }
	}
    }

    private void swap(int x, int y){
	String temp = heap[y];
	heap[y] = heap[x];
	heap[x] = temp;
    }
    


    public static void main(String[] args){
	MyHeap a = new MyHeap();
	System.out.println(a);
	a.add("1");
	a.add("5");
	a.add("346");
	a.add("12345");
	a.add("4");
	a.add("235r");
	a.add("45y73");
	while (true){
	    System.out.println(a.remove());
	}
    }
}
