package Samsung_SummerAlgorithmClass;

import java.util.*;
import java.io.*;

public class Example035_수만들기 {
	public static String[] str;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; ++tc) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			str = br.readLine().split(" ");
			int K = Integer.parseInt(br.readLine());

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(str[i]);
				min = Math.min(A[i], min);
			}

			Queue<Node> pqueue = new PriorityQueue<Node>();
			pqueue.add(new Node(K, 0));

			int cnt = K;

			while (!pqueue.isEmpty()) {
				Node node = pqueue.poll();

				if (node.left == 0) {
					cnt = node.cnt;
					break;
				}

				pqueue.add(new Node(0, node.cnt + node.left));

				for (int i = 0; i < N; i++) {
					pqueue.add(new Node(node.left / A[i], node.cnt + node.left % A[i]));
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}

	static class Node implements Comparable<Node> {
		int left, cnt;

		public Node(int left, int cnt) {
			this.left = left;
			this.cnt = cnt;
		}

		public int compareTo(Node node) {
			if (this.cnt > node.cnt)
				return 1;
			if (this.cnt == node.cnt)
				return 0;

			return -1;
		}
	}
}
