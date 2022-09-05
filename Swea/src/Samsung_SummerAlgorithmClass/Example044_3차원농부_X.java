package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example044_3차원농부_X {
	public static int N, M, dx, min, count, hPos, cIdx, cPos, dz;
	public static int[] cows;
	public static void main(String args[]) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			dx = Math.abs(sc.nextInt() - sc.nextInt());

			cows = new int[N];
			for (int i = 0; i < N; i++) {
				cows[i] = sc.nextInt();
			}
			Arrays.sort(cows);

			min = Integer.MAX_VALUE;
			count = 0;

			for (int i = 0; i < M; i++) {
				hPos = sc.nextInt();
				cIdx = binarySearch(cows, hPos);

				if (0 <= cIdx && cIdx < N) {
					int cPos = cows[cIdx];
					int dz = Math.abs(cPos - hPos);
					if (min > dz) {
						min = dz;
						count = 1;
					} else if (min == dz) {
						count++;
					}
				}
				
				if (0 < cIdx && cIdx < N && cows[cIdx] != hPos) {
					cPos = cows[cIdx - 1];
					dz = Math.abs(cPos - hPos);
					if (min > dz) {
						min = dz;
						count = 1;
					} else if (min == dz) {
						count++;
					}

				}
			}
			sb.append("#").append(test_case).append(" ").append(dx + min).append(" ").append(count).append("\n");
		}
		sc.close();
		System.out.print(sb);
	}

	private static int binarySearch(int[] arr, int value) {
		int left = 0;
		int right = arr.length - 1;
		int mid = (left + right) / 2;

		if (value < arr[left])
			return 0;
		if (arr[right] < value)
			return arr.length - 1;

		while (left <= right) {
			mid = (left + right) / 2;

			if (arr[mid] == value) {
				return mid;
			} else if (arr[mid] < value) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if (arr[mid] < value)
			mid++;

		return mid;
	}
}
