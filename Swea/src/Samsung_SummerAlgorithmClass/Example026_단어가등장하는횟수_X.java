package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example026_단어가등장하는횟수_X {
	static String strA;
	static String strB;
	static StringBuilder sb;
	static int[] pi;
	static int result;
	private static void pivot() {
		int len2 = strB.length();
		char[] B = strB.toCharArray();
		int j = 0;

		for (int i = 1; i < len2; i++) {
			while (j > 0 && B[i] != B[j]) {
				j = pi[j - 1];
			}
			if (B[i] == B[j]) {
				pi[i] = ++j;
			}
		}
	}

	private static void kmp() {

		int len1 = strA.length();
		int len2 = strB.length();

		char[] A = strA.toCharArray();
		char[] B = strB.toCharArray();

		int j = 0;

		for (int i = 0; i < len1; i++) {
			while (j > 0 && A[i] != B[j]) {
				j = pi[j - 1];
			}

			if (A[i] == B[j]) {
				if (j == len2 - 1) {
					result++;
					j = pi[j];
				} else {
					j++;
				}
			}
		}
	}

	public static void play() {

		result = 0;
		pi = new int[strB.length()];

		pivot();
		kmp();

		sb.append(result).append("\n");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			strA = br.readLine();
			strB = br.readLine();
			sb.append("#").append(tc).append(" ");
			play();
		}
		System.out.print(sb);
	}

}
