import java.util.*;
import java.io.*;

public class wordBank{
    public static ArrayList<String> allWords;
    public static ArrayList<String> two;
    public static ArrayList<String> three;
    public static ArrayList<String> four;
    public static ArrayList<String> five;
    public static ArrayList<String> six;
    public static ArrayList<String> seven;
    public static ArrayList<String> eight;
    public static ArrayList<String> nine;
    public static ArrayList<String> ten;
    public static ArrayList<String> eleven;
    public static ArrayList<String> twelve;
    public static ArrayList<String> thirteen;
    public static ArrayList<String> fourteen;
    public static ArrayList<String> fifteen;
    
    
    //
    public wordBank(String filename){
	try{
	    allWords = new ArrayList<String>();
	    File text = new File(filename);
	    Scanner infile = new Scanner(text);
	    while(infile.hasNextLine()){
		String line = infile.nextLine();
		allWords.add(line);
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("Missing File");

	}
    }

    public String toString(){
	int x = allWords.size() - 1;
	String y = "";
	while(x >= 0){
	    y += allWords.get(x);
	    x--;
	}
	return y;
    }

    public static boolean checkWord(String s){
	return search(s);
    }
    
    public static String longestWord(ArrayList<String> a){
	String ans = "";
	for(int x = a.size() - 1; x >= 0; x--){
	    if (a.get(x).length() > ans.length()){
		ans = a.get(x);
	    }
	}
	
   	return ans;
    }

    public static void sort(ArrayList<String> a){
	two=       new ArrayList<String>();
	three =    new ArrayList<String>();
	four =     new ArrayList<String>();
	five =     new ArrayList<String>();
	six =      new ArrayList<String>();
	seven =    new ArrayList<String>();
	eight =    new ArrayList<String>();
	nine =     new ArrayList<String>();
	ten =      new ArrayList<String>();
	eleven =   new ArrayList<String>();
	twelve =   new ArrayList<String>();
	thirteen = new ArrayList<String>();
	fourteen = new ArrayList<String>();
	fifteen =  new ArrayList<String>();
	for(int x = 0; x < a.size(); x++){
 
	    if(a.get(x).length() == 2){
		two.add(a.get(x));
	    }
	    else if(a.get(x).length() == 3){
		three.add(a.get(x));
	    }
	    else if(a.get(x).length() == 4){
		four.add(a.get(x));
	    }
	    else if(a.get(x).length() == 5){
		five.add(a.get(x));
	    }
	    else if(a.get(x).length() == 6){
		six.add(a.get(x));
	    }
	    else if(a.get(x).length() == 7){
		seven.add(a.get(x));
	    }
	    else if(a.get(x).length() == 8){
		eight.add(a.get(x));
	    }
	    else if(a.get(x).length() == 9){
		nine.add(a.get(x));
	    }
	    else if(a.get(x).length() == 10){
		ten.add(a.get(x));
	    }
	    else if(a.get(x).length() == 11){
		eleven.add(a.get(x));
	    }
	    else if(a.get(x).length() == 12){
		twelve.add(a.get(x));
	    }
	    else if(a.get(x).length() == 13){
		thirteen.add(a.get(x));
	    }
	    else if(a.get(x).length() == 14){
		fourteen.add(a.get(x));
	    }
	    else{
		fifteen.add(a.get(x));
	    }
	}
    }

    /*  public static String listToString(ArrayList<String> a){
        return a.get(0);
	}
    */

    public static boolean search(String s){
	if(s.length() < 2 || s.length() > 15){
	    return false;
	}
	else{
	    if(s.length() == 2){
		return binarySearch(two, s, 0, two.size() - 1);
	    }
	    return false;
	}
    }

    public static boolean binarySearch(ArrayList<String> a, String s, int lower, int upper){
	int lowerBound = lower;
	int upperBound = upper;
	if(s.length() < 2 || s.length() > 15){
	    return false;
	}
	else if(lowerBound > upperBound){
	    return false;
	}
	else{
	    if(upperBound - lowerBound == 1){
		if(s.equals(a.get(lowerBound))){
		    return true;
		}
		else if(s.equals(a.get(upperBound))){
		    return true;
		}
		else{
		    return false;
		}
	    }
	    else{
		if(s.compareTo(a.get((lowerBound + upperBound) / 2)) > 0){
		    lowerBound = (((lowerBound + upperBound) / 2));
		    return binarySearch(a, s, lowerBound, upperBound);
		}
		else if(s.compareTo(a.get((lowerBound + upperBound) / 2)) < 0){
		    upperBound = (((lowerBound + upperBound) / 2));
		    return binarySearch(a, s, lowerBound, upperBound);
		}
		else {
		    if(s.equals(a.get((lowerBound + upperBound) / 2))){
			return true;
		    }
		    else {
			return false;
		    }
		}
	    }
	}
	
    } 
    
    public static void main(String[] args){
	wordBank s = new wordBank("words.txt");
        System.out.println(longestWord(allWords));
	sort(allWords);
	System.out.println(two.size());
	System.out.println(two.get(0));
	System.out.println(two);
	System.out.println(three.size());
	System.out.println(four.size());
	System.out.println(five.size());
	System.out.println(six.size());
	System.out.println(seven.size());
	System.out.println(eight.size());
	System.out.println(nine.size());
	System.out.println(ten.size());
	System.out.println(eleven.size());
	System.out.println(twelve.size());
	System.out.println(thirteen.size());
	System.out.println(fourteen.size());
	System.out.println(fifteen.size());
	System.out.println(search("A"));
	System.out.println(search("ED"));
	System.out.println(search("EG"));
	System.out.println(checkWord("EG"));
	System.out.println(checkWord("ED"));
	//System.out.println(s);

    }
    
}
