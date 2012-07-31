package amazon.leetcode;

// AC
public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        int i = 0;
        int tail = A.length-1;
        while(i <= tail) {
            if(A[i] == elem) {
                A[i] = A[tail];
                tail--;
            } else {
                i++;
            }
        }
        return i;
    }
}
