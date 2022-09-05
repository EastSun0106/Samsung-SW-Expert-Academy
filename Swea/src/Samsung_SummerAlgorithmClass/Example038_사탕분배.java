package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example038_사탕분배 {
	public static String[] str;
	public static int a, b, k, c;
	public static long e, result;
	static long[] lookup = new long[31];

	static {
		lookup[0] = 2;
	}

	static long mod(int exp, int k) {
		result = 1;
		for (int i = 0; i < lookup.length; i++) {
			if ((exp & 1 << i) != 0) {
				result = (result * lookup[i]) % k;
			}
		}
		return result;
	}

	static long candy(int a, int b, int k) {
		c = a + b;
		e = mod(k, a + b);
		return Math.min((a * e) % c, (b * e) % c);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			str = br.readLine().split(" ");
			a = Integer.parseInt(str[0]);
			b = Integer.parseInt(str[1]);
			k = Integer.parseInt(str[2]);

			for (int i = 0; i < lookup.length-1; i++) {
				lookup[i+1] = (lookup[i] * lookup[i]) % (a + b);
			}
			sb.append("#").append(tc).append(" ").append(candy(a, b, k)).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
