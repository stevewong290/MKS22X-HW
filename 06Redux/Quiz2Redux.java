import java.util.*;

public class Quiz2Redux{

    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
		words.add("");
	help(words, s);
	Collections.sort(words);
	return words;
    }

    private static void help(ArrayList<String> words, String s){
	int len = words.size();
	if(s.length() == 0) {
	    //	    words.add("");
	}
	else {
	    for (int i = 0; i < len; i++){
		words.add(words.get(i) + s.charAt(0));
	    }
	    help(words, s.substring(1));
	}
    }

    public static void main(String[] args) {
	System.out.println(combinations("ab"));
	System.out.println(combinations("abc"));
	System.out.println(combinations("aa").size());
    }
}
