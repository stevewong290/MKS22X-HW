import java.util.*;

public class Quick{
    


    /*
    public static int part(int[] data, int start, int end){
	Random rand = new Random();
	int pivotpoint = rand.nextInt(end - start + 1) + start;
	//	int[] temp = new int[end - start + 1];
	int begpos = 0;
	int endpos = end - start;
	int endret = 0;
      	int fastplsyea;
	}*/

    public static void quicksort(int[] data){
	if(data.length > 0){
	    quicksortH(data, 0, data.length - 1);
	}
    }

    public static void quicksortH(int[] data1, int low, int high){
	int lt = low;
	int gt = high;
	int pivotval = data1[low];
	int i = lt;

	/*	if(low == high){
	    System.exit(0);
	}
	*/
	while(i <= gt){
	    if(data1[i] == pivotval) {
		i++;
	    }
	    else if(data1[i] < pivotval) {
		swap(data1, i, lt);
		lt++;
		i++;
	    }
	    else if(data1[i] > pivotval){
		swap(data1, i, gt);
		gt--;
	    }
	}
	//	return pivotpoint;
	if(low < lt - 1){
	    quicksortH(data1, low, lt - 1);
	}
	if(gt + 1 < high){
	    quicksortH(data1, gt + 1, high);
	}
    }
    
    public static void swap(int[] array, int i, int j){
	int swappervalue;
	swappervalue = array[i];
	array[i] = array[j];
	array[j] = swappervalue;
    }
	/*
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
    /*	}
	for (int x = start; x < end + 1; x++){
	    data[x] = temp[x - start];
	}
	return endret;
*/
    

    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	return 1;
    }

    /* public String toString() {
    
    }
    */

    public static void main(String args[]){
	
	int[]ary = { 2, 10, 15, 23, 0,  5};
	//int[]ary = {0,1,2,3};
	//	swap(ary, 2,3);
	System.out.println(Arrays.toString(ary));
	quicksort(ary);
	System.out.println(Arrays.toString(ary));
	
		/*	System.out.println(part(ary, 0, 3));
	System.out.println(Arrays.toString(ary));
	*/
	/*	quickselect( ary , 0 );
	quickselect( ary , 1 ); 
	quickselect( ary , 2 );  
	quickselect( ary , 3 ); 
	quickselect( ary , 4 );  
	quickselect( ary , 5 ); */
    }


}
