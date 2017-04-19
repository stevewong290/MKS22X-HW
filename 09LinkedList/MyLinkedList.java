import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    LNode start;
    LNode end;
    int size;

    private class MyLinkedListIterator implements Iterator<Integer>{
	MyLinkedList bullshit;
	LNode x;
	private MyLinkedListIterator(MyLinkedList nah){
	    bullshit = nah;
	    x = nah.start;
	}

	public Integer next(){
	    int i = x.value;
	    x = x.next;
	    return i;
	}
	public boolean hasNext(){
	    return (x!= bullshit.end);
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
	
    }
    
    private class LNode{
	int   value;
	LNode next;
	LNode prev;
	private LNode(int v){
	    value = v;
	} 
	
	private void addAfter(LNode lnode){
	    if (next != null){
		lnode.next = next;
		next.prev = lnode;
		next = lnode;
		lnode.prev = this;
	    }
	    else {
		lnode.prev = this;
		next = lnode;
	    }
	}
	private void addBefore(LNode lnode){
	    if (prev != null){
		lnode.prev = prev;
		prev.next = lnode;
		prev = lnode;
		lnode.next = this;
	    }
	    else {
		lnode.next = this;
		this.prev = lnode;
	    }
	}   
    }

    public Iterator<Integer> iterator(){
	return new MyLinkedListIterator(this);
    }
    
    public boolean add(int value){
	add(size, value);
	return true;
    }
    
    public int size(){
	return size;
    }

    private LNode getNthNode(int n){
	if (n < 0 || n >= size){
	    throw new IndexOutOfBoundsException();
	}
	LNode x = start;
	while (n-- > 0) {
	    x = x.next;
	}
	return x;
    }

    public void add(int index, int value){
	if (size == 0){
	    start = new LNode(value);
	    end = start;
	}
	if (index == 0) {
	    start.addBefore(new LNode(value));
	    start = start.prev;
	}
	else {
	    LNode x = getNthNode(index - 1);
	    x.addAfter(new LNode(value));
	    if (x == end) {
		end = end.next;
	    }
	}
	size++;
	
    }

    public int get(int index){
	return getNthNode(index).value;
    }
    
    public int set(int index, int newValue){
	LNode x = getNthNode(index);
	int y = x.value;
	x.value = newValue;
	return y;
    }

    public int indexOf(int value){
	int i = 0;
	for (LNode x = start; x != end; x = x.next){
	    if(x.value == value){
		return i;
	    }
	    i++;
	}
	return -1;
    }
    
    public int remove(int index){
	if (index == 0){
	    int bullshit = start.value;
	    start = start.next;
	    start.prev = null;
	    size--;
	    return bullshit;
	}
	if (index == size - 1){
	    int morebullshit = end.value;
	    end = end.prev;
	    end.next = null;
	    size--;
	    return morebullshit;
	}
	LNode x = getNthNode(index);
	x.prev.next = x.next;
	x.next.prev = x.prev;
	size--;
	return x.value;
    }
    public String toString() {
	LNode current = start.next;
        if (current == null)
            return "[]";

        StringBuilder out = new StringBuilder();
        out.append('[');

        for (;; current = current.next) {
            out.append(current.value);
            if (current.next == null)
                return out.append(']').toString();
            out.append(", ");
        }
    }

    public static void main(String[] args) {
	MyLinkedList mll = new MyLinkedList();
	for (int i=0; i<10; i++)
	    mll.add(i);
	/*	System.out.println(mll);
	mll.add(5, 10);
	mll.add(mll.size(), 10);
	System.out.println(mll);
	System.out.println(mll.indexOf(10));
	mll.remove(mll.indexOf(10));
	System.out.println(mll);
	System.out.println(mll.indexOf(10));
	mll.set(0, 10);
	System.out.println(mll);
	System.out.println(mll.indexOf(10));
	System.out.println(mll.indexOf(11));
*/
	for(int x: mll){
	    System.out.println(x);
	}
    }
}
