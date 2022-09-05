package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example040_영어공부_X {
	public static boolean[] visited;
	public static int N, P, max;
	public static String[] str;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			P = Integer.parseInt(str[1]);

			str = br.readLine().split(" ");

			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);

			visited = new boolean[1000001];
			max = P + 1;
			for (int day : arr)
				visited[day] = true;

			int start = 1;
			int end = 1;
			int cnt = 0;
			while (end < visited.length) {
				if (visited[end]) {
					cnt++;
					end++;
					max = Math.max(max, cnt);
				} else {
					if (P == 0) {
						max = Math.max(max, cnt);
						if (!visited[start])
							P++;
						start++;
						cnt--;
					} else {
						P--;
						cnt++;
						end++;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}

}
