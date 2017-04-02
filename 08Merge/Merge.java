import java.util.*;

public class Merge{
    public static void mergesort(int[] array){
	System.out.println(array.length);
	int[] left  = new int[array.length / 2];
	int[] right = new int[array.length - array.length / 2];
	    
	if (array.length < 2){
	    
	}

	else { 
	    int ltemp = 0;
	    while ( ltemp  < array.length / 2 ) {
		left[ltemp] = array[ltemp];
		ltemp++;
	    }
	    int rtemp = 0;
	    while ( rtemp < array.length - array.length / 2 ) {
		right[rtemp] = array[rtemp + array.length / 2];
		rtemp++;
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, array);
	}
    }

    public static void merge(int[]a, int[]b, int[]destination){
	int i = 0;
	int j = 0;
	for (int x = 0; x < destination.length; x++) {
	    
	    if(i <  a.length && (j >= b.length || a[i] <  b[j])) {
		destination[x] = a[i];
		i++;
	    }
	    else {
		destination[x] = b[j];
		j++;
	    }
	}
    }

    public static void main(String[] args){
	int[] hello = new int[]{1, 7, 10};
	int[] bitch = new int[]{4, 5, 6};
	int[] destibitchation = new int[6];
	merge(hello, bitch, destibitchation);
	System.out.println(Arrays.toString(destibitchation));
	
	int[] turcotti = new int[]{8,5,6,7,2,0,2,8,1,6,3,1,4,8,2,4,1,6,4,6,5,8,0,1,3,5,7,2};
	mergesort(turcotti);
	System.out.println(Arrays.toString(turcotti)); 
    }

}
/*
  int[] left = new int[array.length / 2];
  int[] right = new int[array.length - array.length / 2];
  
********/
