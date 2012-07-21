package amazon;

public class RemoveDuplicate {
	
	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	// AC
	// Remove Duplicate 
	// Appear only once
	public int removeDuplicates(int[] A) {
		if(A.length <= 1) return A.length;
		int curr = A[0];
		int hole = 1;
		for(int i = 1; i < A.length; i++) {
			if(A[i] != curr) {
				curr = A[i];
				swap(A, i, hole);
				hole++;
			}
		}
		return hole;
    }
	
	public int removeDuplicatesII(int[] A) {
		if(A.length <= 1) return A.length;
		int curr = A[0];
		int hole = 1;
		int count = 1;
		for(int i = 1; i < A.length; i++) {
			if(A[i] != curr) {
				curr = A[i];
				A[hole] = A[i];
				hole++;
				count = 1;
			} else {
				if(count < 2) {
					A[hole] = A[i];
					count++; 
					hole++;
				}
			}
		}
		return hole;
    }
}
