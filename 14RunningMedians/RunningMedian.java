public class RunningMedian{
    private MyHeap min;
    private MyHeap max;
    private int sizeMin;
    private int sizeMax;

    
    public RunningMedian(){
	min = new MyHeap(false);
	max = new MyHeap(true);
	sizeMin = 0;
	sizeMax = 0;
    }

    public void add(int num){
	if(sizeMin + sizeMax == 0){
	    min.add(num);
	    sizeMin++;
	}
	else {
	    if(min.peek() >= num){
		max.add(num);
		sizeMax++;
	    }
	    else{
		min.add(num);
		sizeMin++;
	    }
	}
	if (sizeMin - sizeMax >= 2){
	    max.add(min.remove());
	    sizeMin--;
	    sizeMax++;
	}
	else if(sizeMax - sizeMin >=2){
	    min.add(max.remove());
	    sizeMin++;
	    sizeMax--;
	}
    }

    public double getMedian(){
	if(sizeMin == sizeMax){
	    return (min.peek() + max.peek()) / 2.0;
	}

	else if (sizeMin > sizeMax){
	    return 0.0 + min.peek();
	}
	else {
	    return 0.0 + max.peek();
	}
    }

    public static void main(String[]args){
	RunningMedian runMed = new RunningMedian();
	try{
	    System.out.println(runMed.getMedian());
	}
	catch(NullPointerException e){
	    System.out.println("Passed.");
	}
	runMed.add(0);
	System.out.println(runMed.getMedian()); //0
	runMed.add(2);
	System.out.println(runMed.getMedian()); //1
	runMed.add(1);
	System.out.println(runMed.getMedian()); //1
	runMed.add(3);
	System.out.println(runMed.getMedian()); //1.5
	runMed.add(1);
	System.out.println(runMed.getMedian()); //1
	runMed.add(5);
	System.out.println(runMed.getMedian()); //1.5
	runMed.add(4);
	System.out.println(runMed.getMedian()); //2
    }
}
