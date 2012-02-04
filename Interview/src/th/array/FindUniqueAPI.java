package th.array;

public class FindUniqueAPI {
    public static void findUniqueMember(char[] array) {
	String arrayString = "";

	for (int i = 0; i < array.length; i++) {
	    arrayString += array[i];
	}

	System.out.println("The arrayString is: " + arrayString);

	for (int j = 0; j < array.length; j++) {
	    String tempString = arrayString.replaceAll(array[j] + "", "");

	    if ((arrayString.length() - tempString.length()) == 1) {
		System.out.println("The unique member is: " + array[j] + "\n");
		return;
	    }
	}
	// System.out.println(array[array.length]);
	System.out.println("There is no unique member in this array!\n");
    }

    public static void main(String args[]) {
	char[] array1 = { 'a', 'b', 'c', 'd', 'e', 'f' };
	char[] array2 = { 'a', 'a', 'd', 'd', 'e', 'f' };
	char[] array3 = { 'a', 'b', 'c', 'd', 'e', 'a' };
	char[] array4 = { 'a', 'a', 'a', 'a', 'a', 'a' };

	findUniqueMember(array1);
	findUniqueMember(array2);
	findUniqueMember(array3);
	findUniqueMember(array4);
    }
}
