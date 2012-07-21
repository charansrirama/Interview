package amazon;

public class MinimumWindowSubstring {
	public static String minWindow(String S, String T) {
		int minWindowBegin = 0, minWindowEnd = 0;
		int sLen = S.length();
		int tLen = T.length();
		
		int needToFind[] = new int[256];
		for(int i = 0; i < T.length(); i++) {
			needToFind[T.charAt(i)]++;
		}
		
		int hasFound[] = new int[256];
		int minWindowLen = Integer.MAX_VALUE;
		int count = 0;
		
		for(int begin = 0, end = 0; end < sLen; end++) {
			if(needToFind[S.charAt(end)] == 0) continue;
			hasFound[S.charAt(end)]++;
			if(hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
				count++;
			
			if(count == tLen) {
				while(needToFind[S.charAt(end)] == 0 ||
						hasFound[S.charAt(end)] > needToFind[S.charAt(end)]) {
					if(hasFound[S.charAt(end)] > needToFind[S.charAt(end)]) 
						hasFound[S.charAt(end)]--;
					begin++;
				}
				int windowLen = end - begin + 1;
				if(windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				}
			}	
		}
		if(count == tLen) 
			return S.substring(minWindowBegin+1, minWindowEnd+1);
		else 
			return "";
		
	}
	
	public static void main(String[] args) {
		System.out.println(minWindow("bba", "ab"));
	}
}
