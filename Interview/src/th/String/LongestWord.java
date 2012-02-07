package th.String;
/**
 * shijinliang
 * Feb 6, 2012
 * Interview
 **/
public class LongestWord {

    public String findLongestWord(String sentense) {
	String longest = "";
	
	int i = sentense.indexOf(' ');
	if(i == -1)
	    return sentense;
	String first = sentense.substring(0, i);
	first = first.trim();
	String rest = sentense.substring(i);
	rest = rest.trim();
	longest = stringCompare(first, findLongestWord(rest));
	
	return longest;
    }
    
    private String stringCompare(String str1, String str2) {
	if(str1.length() > str2.length())
	    return str1;
	else 
	    return str2;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	LongestWord lw = new LongestWord();
	System.out.println(lw.findLongestWord("this is a test sentense."));
    }

}
