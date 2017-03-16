import java.util.Random;

public class Quick{
    



    public static int part(int[] data, int start, int end){
	Random rand = new Random();
	int pivotindex = rand.nextInt(end - start + 1) + start;
	int[] temp = new int[end - start + 1];
	int begpos = 0;
	int endpos = 0;
	for(int x = start; x < end + 1; x++){
	    if (data[x] < data[pivotindex]){
		temp[begpos] = data[x];
		begpos++;
	    }
	    if (data[x] > data[pivotindex]){
		temp[endpos] = data[x];
		endpos--;
	    }
	    if (x != pivotindex && data[x] = data[pivotindex]) {
		temp[begpos] = data[x];
	    }
	    if (begpos == endpos){
		temp[begpos] = data[pivotindex];
	    }
	}
	for (
    }

    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	return 1;
    }


    public static void main(String args[]){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(part(ary, 1, 3));
	/*	quickselect( ary , 0 );
	quickselect( ary , 1 ); 
	quickselect( ary , 2 );  
	quickselect( ary , 3 ); 
	quickselect( ary , 4 );  
	quickselect( ary , 5 ); */
    }


}
