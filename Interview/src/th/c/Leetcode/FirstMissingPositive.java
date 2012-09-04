package th.c.Leetcode;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
        int len = A.length;
        for(int i = 0; i < len; i++) {
            if(A[i] == i+1) continue;
            
            while(A[i] > 0 && A[i] <= len 
                && A[i] != i+1 && A[i] != A[A[i] -1])
                swap(A, i, A[i]-1);
        }
        for(int i = 0; i < len; i++) {
            if(A[i] != i+1) return i+1;
        }
        return len+1;
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
