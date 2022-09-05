package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example019_최장부분공통수열 {
	public static int[][] dp;
	public static String[] stringArr;
	public static char[] arr1;
	public static char[] arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			////////////////////////
			stringArr = br.readLine().split(" ");
			arr1 = new char[stringArr[0].length()];
			arr2 = new char[stringArr[1].length()];
			dp = new int[arr1.length][arr2.length];

			for (int j = 0; j < stringArr[0].length(); j++) {
				arr1[j] = stringArr[0].charAt(j);
			}

			for (int j = 0; j < stringArr[1].length(); j++) {
				arr2[j] = stringArr[1].charAt(j);
			}

			sb.append("#").append(i).append(" ").append(lcs(arr1.length - 1, arr2.length - 1)).append("\n");
			////////////////////////
		}
		System.out.print(sb);
	}

	public static int lcs(int x, int y) {
		if (x < 0 || y < 0)
			return 0;
		if (dp[x][y] == 0) {
			if (arr1[x] == arr2[y]) {
				dp[x][y] = lcs(x - 1, y - 1) + 1;
			} else {
				dp[x][y] = Math.max(lcs(x, y - 1), lcs(x - 1, y));
			}
		}
		return dp[x][y];
	}
}
