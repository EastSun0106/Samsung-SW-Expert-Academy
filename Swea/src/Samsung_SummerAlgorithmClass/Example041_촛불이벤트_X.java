package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example041_촛불이벤트_X {
	public static long n, num, result, index;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			num = Long.parseLong(br.readLine());
			result = 0;
			index = -1;
			for (long n = (long) Math.sqrt(num * 2);; ++n) {
				result = (n * (n + 1)) / 2;
				if (result == num) {
					index = n;
					break;
				} else if (result > num) {
					break;
				}

			}
			sb.append("#").append(t).append(" ").append(index).append("\n");
		}
		System.out.print(sb);
	}
}
