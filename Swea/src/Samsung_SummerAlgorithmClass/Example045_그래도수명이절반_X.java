package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example045_그래도수명이절반_X {

	static int[] W, S;
	static int N, K, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		W = new int[200001];
		S = new int[200001];

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				W[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			result = 200000;

			pSearch();

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}

	private static void pSearch() {
		int left = 1;
		int right = 200000;

		while (left < right) {
			int mid = (left + right) / 2;

			if (isOk(mid)) {
				right = mid;
				result = right;
			} else {
				left = mid + 1;
			}
		}
	}

	private static boolean isOk(int mid) {
		int data = 1;
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			if (W[i] <= mid) {
				cnt++;
			} else {
				cnt = 0;
			}

			if (cnt == S[data]) {
				data++;
				cnt = 0;
				if (data > K) {
					return true;
				}
			}
		}
		return false;
	}

}
