import java.util.*;

public class Quick{
    



    public static int part(int[] data, int start, int end){
	Random rand = new Random();
	int pivotpoint = rand.nextInt(end - start + 1) + start;
	int[] temp = new int[end - start + 1];
	int begpos = 0;
	int endpos = end - start;
	int endret = 0;
	for(int x = start; x < end + 1; x++){
	    if (begpos > endpos){
		temp[begpos] = data[pivotpoint];
		endret = begpos; 
	    }
	    if (data[x] < data[pivotpoint]){
		temp[begpos] = data[x];
		begpos++;
	    }
	    if (data[x] > data[pivotpoint]){
		temp[endpos] = data[x];
		endpos--;
	    }
	    if (x != pivotpoint && data[x] == data[pivotpoint]) {
		temp[begpos] = data[x];
		begpos++;
	    }
	    // if ()
	    /*  if (begpos == endpos){
		temp[begpos] = data[pivotpoint];
		begpos = endret;
		}*/
	}
	for (int x = start; x < end + 1; x++){
	    data[x] = temp[x - start];
	}
	return endret;
    }

    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	return 1;
    }

    /* public String toString() {
    
    }
    */

    public static void main(String args[]){
	//	int[]ary = { 2, 10, 15, 23, 0,  5};
	int[]ary = {0,1,2,3};
	System.out.println(part(ary, 0, 3));
	System.out.println(Arrays.toString(ary));
	
	/*	quickselect( ary , 0 );
	quickselect( ary , 1 ); 
	quickselect( ary , 2 );  
	quickselect( ary , 3 ); 
	quickselect( ary , 4 );  
	quickselect( ary , 5 ); */
    }


}
