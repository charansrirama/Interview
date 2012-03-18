package th.array;

public class ArrayPrintPuzzle {
	
	public static void normalPrint(int array[][]) {
		System.out.println("Normal Print");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void snakePrint(int array[][]) {
		System.out.println("Snake Print");
		for (int i = 0; i < array.length; i++) {
			int j;
			if(i % 2 == 0) {
				for(j = 0; j < array[i].length; j++) {
					System.out.print(array[i][j] + "\t");
				}
			} else if(i % 2 == 1) {
				for(j = array[i].length-1; j >= 0; j--) {
					System.out.print(array[i][j] + "\t");
				}
			}
			System.out.println();
		}
	}

	
	public static void spiderPrint(int array[][]) {
		System.out.println("Spider Print");
		int startX = 0, endX = array.length-1;
		int startY = 0, endY = array[0].length-1;
		
		int i;
		while(startX <= endX && startY <= endY) {
			for(i = startX; i <= endX; i++)
				System.out.print(array[startY][i] + " ");
			startY++;
			
			for(i = startY; i <= endY; i++) {
				System.out.print(array[i][endX] + " ");
			}
			endX--;
			
			for(i = endX; i >= startX; i--){
				System.out.print(array[endY][i] + " ");
			}
			endY--;
			
			for(i = endY; i >= startY; i--) {
				System.out.print(array[startX][i] + " ");
			}
			startX++;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		int array[][] = new int[5][5];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = count++;
			}
		}
		
		ArrayPrintPuzzle.normalPrint(array);
		ArrayPrintPuzzle.snakePrint(array);
		ArrayPrintPuzzle.spiderPrint(array);
	}

}
