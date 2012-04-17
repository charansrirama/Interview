package th.util;

public class Printer {
	public static void arrayPrinter(int input[]) {
		for(int i = 0; i < input.length; i++)
			System.out.print(input[i] + " ");
		
		System.out.println();
	}
	
	public static void matrixPrinter(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
