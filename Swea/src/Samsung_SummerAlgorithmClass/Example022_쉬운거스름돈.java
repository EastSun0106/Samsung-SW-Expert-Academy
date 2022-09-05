package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example022_쉬운거스름돈 {
	public static int N;
	public static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
	public static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			//////////////////////
			N = Integer.parseInt(br.readLine());
			result = new int[8];
			
			cal(N);
			
			sb.append("#").append(i).append("\n");
			for(int j=0; j<8; j++) {
				sb.append(result[j]).append(" ");
			}
			sb.append("\n");
			//////////////////////
		}
		System.out.print(sb);
	}

	public static void cal(int n) {
		int i=0;
		while (n != 0 && i < 8) {
			if (n - money[i] >= 0) {
				n -= money[i];
				result[i]++;
			} else {
				i++;
			}
		}
	}
}
