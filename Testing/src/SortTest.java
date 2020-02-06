import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {

		int[] a = { 5, 2, 6, 9, 1, 4, 3 };
		
		Arrays.sort(a);
		for(int x:a) { System.out.print(x +" "); }
		/*
		for (int i = 0; i < a.length; i++) {
			int j = i;
			int temp = a[j];
			System.out.println(">>j: " + j + ",temp: "+temp);
			
			while (j >= 1 && a[j - 1] > temp) {
				a[j] = a[j - 1];
				j--;
				for(int x:a) { System.out.print(x +" "); }
				System.out.println("");
				//System.out.println("a[j]: " + a[j] + ",j: "+j);
			}
			a[j] = temp;
		}
*/
		/*
		 * for (int j = 0; j < a.length; j++) { int temp = a[j]; int minLoc = j; int min
		 * = a[j];
		 * 
		 * System.out.println("***min: " + min + ",minLoc: "+minLoc);
		 * 
		 * for (int i = j + 1; i < a.length; i++) { if (min > a[i]) { min = a[i]; minLoc
		 * = i;
		 * 
		 * System.out.println("min: " + min + ",minLoc: "+minLoc); } } a[j] = min;
		 * a[minLoc] = temp;
		 * 
		 * for(int x:a) { System.out.print(x +" "); } }
		 * 
		 * for(int x:a) { System.out.print(x +" "); }
		 */
		
	}

}
