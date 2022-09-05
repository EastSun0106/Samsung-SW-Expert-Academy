package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example017_파핑파핑지뢰찾기 {
	public static int T, N;
	public static int answer;
	public static int[][] adj;
	public static boolean[][] isBoom;
	public static boolean[][] checked;
	public static BufferedReader br;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		play();
	}

	public static void init() throws IOException {
		answer = 0;
		adj = new int[302][302];
		isBoom = new boolean[302][302];
		checked = new boolean[302][302];
		N = Integer.parseInt(br.readLine());
		char[] dataString = new char[302];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i][j] = 0;
				checked[i][j] = false;
			}
		}
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				dataString[j] = str.charAt(j);
			}
			int dx[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
			int dy[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
			int adjX, adjY;
			for (int j = 0; j < N; j++) {
				if (dataString[j] == '*') {
					isBoom[i][j] = true;
					for (int d = 0; d < 8; d++) {
						adjX = i + dx[d];
						adjY = j + dy[d];
						if (adjX < 0 || adjX >= N || adjY < 0 || adjY >= N) {
							continue;
						}
						adj[adjX][adjY]++;
					}
				} else {
					isBoom[i][j] = false;
				}
			}
		}
		answer = 0;
	}

	public static void dfs(int x, int y) {
		int dx[] = { 1, -1, 0, 0, 1, 1, -1, -1 };
		int dy[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
		int adjX, adjY;
		for (int d = 0; d < 8; d++) {
			adjX = x + dx[d];
			adjY = y + dy[d];
			if (adjX < 0 || adjX >= N || adjY < 0 || adjY >= N || checked[adjX][adjY] || isBoom[adjX][adjY]) {
				continue;
			}
			checked[adjX][adjY] = true;
			if (adj[adjX][adjY] == 0) {
				dfs(adjX, adjY);
			}
		}
	}

	public static void zeroAdjCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isBoom[i][j] || checked[i][j]) {
					continue;
				}
				if (adj[i][j] == 0) {
					answer++;
					checked[i][j] = true;
					dfs(i, j);
				}
			}
		}
	}

	public static void residueCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isBoom[i][j] || checked[i][j]) {
					continue;
				}
				answer++;
				checked[i][j] = true;
			}
		}
	}

	public static void play() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();
			sb.append("#").append(tc).append(" ");
			zeroAdjCheck();
			residueCheck();
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
