package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example043_광고시간정하기_X {
	public static int L, N, s, max;
	public static ArrayList<PeekTime> list;
	public static String[] str;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			L = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<PeekTime>();

			s = 0;
			for (int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);
				s += y - x;
				list.add(new PeekTime(x, y, s));
			}

			max = -1;

			for (int i = 0; i < N; i++) {
				int sum = 0;
				int begin = list.get(i).begin;
				int end = begin + L;
				PeekTime lastPeek = findTime(list, end);

				sum = lastPeek.sum - list.get(i).sum + list.get(i).end - list.get(i).begin;

				if (lastPeek.end > end && lastPeek.begin < end) {
					sum -= lastPeek.end - end;
				} else if (lastPeek.end > end) {
					sum -= lastPeek.end - lastPeek.begin;
				}

				max = Math.max(max, sum);
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}

	static PeekTime findTime(ArrayList<PeekTime> list, int target) { // end가 target 이상인 peek
		int start = 0, end = list.size() - 1;

		while (end > start) {
			int mid = (start + end) / 2;

			if (list.get(mid).end >= target)
				end = mid;
			else
				start = mid + 1;
		}

		return list.get(end);
	}

	static class PeekTime {
		int begin, end, sum;

		public PeekTime(int begin, int end, int sum) {
			this.begin = begin;
			this.end = end;
			this.sum = sum;
		}
	}
}
