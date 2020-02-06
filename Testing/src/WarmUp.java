
public class WarmUp {
	public static void main(String[] args) {
		warmUP8_2();
	}
	
	public static void warmUP8_1() {
		int[] a = new int[19];
		
		int n = 19;
		for(int i = 0; i<n; i++)
			a[i] = i+1;
		for(int i = 0, j = n-1; i <= j; i++, j--)
			a[(i+j)/2] -= (a[i] + a[j]) / 2;
		
		System.out.print(a[19/2]);
	} 
	
	public static void mysteryMix(Integer a, Integer b) {
		a = new Integer(2*a);
		b = a;		
	}
	
	public static void warmUP8_2() {
		Integer a = 1;
		Integer b = 2;
		mysteryMix(a, a);
		mysteryMix(a, b);
		System.out.println(a + " " + b);
	}
}
