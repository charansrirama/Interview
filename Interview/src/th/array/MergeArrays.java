package th.array;

public class MergeArrays {

    public static int[] merge(int[] a1, int[] a2) {
	int[] result = new int[a1.length + a2.length];
	int i = 0, j = 0;
	for (int k = 0; k < a1.length + a2.length; k++) {
	    if (i == a1.length)
		result[k] = a2[j++];
	    else if (j == a2.length)
		result[k] = a1[i++];
	    else if (a1[i] < a2[j])
		result[k] = a1[i++];
	    else if (a2[j] <= a1[i])
		result[k] = a2[j++];
	}

	return result;
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	int[] a = { 1, 3, 7, 9, 11 };
	int[] b = { 2, 4, 6, 7, 22 };

	int[] c = merge(a, b);
	for (int num : c) {
	    System.out.print(num + " ");
	}

    }
}
