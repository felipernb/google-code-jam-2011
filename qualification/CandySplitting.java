import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CandySplitting {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		for (int i = 0; i < t; i++) {
			int[] n = new int[Integer.parseInt(in.nextLine())];
			StringTokenizer st = new StringTokenizer(in.nextLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				n[j++] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(n);
			boolean hasSolution = false;
			for (j = 0; j < n.length-1; j++) {
				int patrick = xorSubArray(n, 0, j);
				int sean = xorSubArray(n, j+1);
				if ( patrick == sean ) {
					hasSolution = true;
					break;
				}
			}
			System.out.println("Case #"+(i+1)+": "+ (hasSolution?sumSubArray(n, j+1):"NO"));
		}
	}
	
	private static int xorSubArray(int[] n, int start) {
		return xorSubArray(n, start, n.length-1);
	}
	private static int xorSubArray(int[] n, int start, int end) {
		int xor = 0;
		for(int i = start; i <= end; i++) {
			xor ^= n[i];
		}
		return xor;
	}
	
	private static int sumSubArray(int[] n, int start) {
		int sum = 0;
		for(int i = start; i < n.length; i++) {
			sum += n[i];
		}
		return sum;
	}
}
