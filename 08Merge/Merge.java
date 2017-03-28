public class Merge(){
    public static void mergesort(int[] array){
	int[] left  = new int[array.length / 2];
	int[] right = new int[array.length - array.length / 2];
	    
	if (array.length < 2){
	    
	}

	else { 
	    int ltemp = 0;
	    while ( ltemp  < array.length / 2 ) {
		left[ltemp] = array[ltemp];
	    }
	    int rtemp = 0;
	    while ( rtemp < array.length - array.length / 2 ) {
		right[rtemp] = array[rtemp + array.length / 2];
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, array);
	}
    }

    public static void merge(int[]a, int[]b, int[]destination){

    }

}
/*
  int[] left = new int[array.length / 2];
  int[] right = new int[array.length - array.length / 2];
  
********/
