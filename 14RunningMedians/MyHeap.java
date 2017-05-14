
 public class MyHeap{
    private int[] heap;
    private boolean max; // true is max, min is false
    private int size;
    
	public MyHeap(){
	    max = true;
	    heap = new int[1];
	    size = 0;
	}

	public MyHeap(boolean m){
	    max = m;
	    heap = new int[1];
	    size = 0;
	}
    
	public int peek(){
	    if (size > 0){
		return heap[1];
	    }
	    else{
		throw new NullPointerException("empty heap");
	    }
	}

	private void doubleSize(){
	    int[] temp = new int[heap.length * 2];
	    for (int i = 1; i <= size; i ++){
		temp[i] = heap[i];
	    }
	    heap = temp;
	}

	public String toString(){
	    String str = "";
	    for (int i = 1; i <= size; i = i * 2){
		for (int j = i; j < i * 2; j ++){
		    str += heap[j] + " ";
		}
		str += "\n";
	    }
	    return str;
	}

	//retry of add, remove, pushUp, and pushDown
	//add uses pushUp, remove uses pushDown
	//pushUp checks parent
	//pushDown checks children

	public void add(int s){
	    if (size + 1 == heap.length){
		doubleSize();
	    }
	    size ++;
	    heap[size] = s;
	    pushUp();
	}

	public int remove(){
	    int old = heap[1];
	    heap[1] = heap[size];
	    heap[size] = 0;
	    size --;
	    pushDown();
	    return old;
	}

	private void pushUp(){
	    int parent;
	    for (int index = size; index > 1; index = index / 2){
		parent = index / 2;
		if (max){
		    if (heap[parent] < heap[index]){
			swap(parent, index);
		    }
		    else{
			index = 1;
		    }
		}
		else{
		    if (heap[parent] > heap[index]){
			swap(parent, index);
		    }
		    else{
			index = 1;
		    }
		}
	    }
	}

	private void pushDown(){
	    int index = 1;
	    int right;
	    int left;
	    while (index * 2 < size){
		right = index * 2 + 1;
		left = index * 2;
		if (max){
		    if (heap[right] > heap[left]){
			if (heap[right] > heap[index]){
			    swap(right, index);
			    index = right;
			}
			else{
			    index = size;
			}
		    }
		    else{
			if (heap[left] > heap[index]){
			    swap(left , index);
			    index = left;
			}
			else{
			    index = size;
			}
		    }
		}
		else{
		    if (heap[right] < heap[left]){
			if (heap[right] < heap[index]){
			    swap(right, index);
			    index = right;
			}
			else{
			    index = size;
			}
		    }
		    else{
			if (heap[left] < heap[index]){
			    swap(left , index);
			    index = left;
			}
			else{
			    index = size;
			}
		    }
		}
	    }
	    if (index * 2 == size){
		if (max && heap[index * 2] > heap[index]){
		    swap(index * 2, index);
		}
		else if (!max && heap[index * 2] < heap[index]){
		    swap(index * 2, index);
		}
	    }
	}
	private void swap(int index1, int index2){
	    int temp = heap[index1];
	    heap[index1] = heap[index2];
	    heap[index2] = temp;
	}
    } 
