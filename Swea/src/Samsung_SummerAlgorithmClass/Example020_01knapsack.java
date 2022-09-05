package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example020_01knapsack {
	public static int[] V;	// 부피
	public static int[] C;	// 가치
	public static int[][] dp;
	public static int N, K;	// 물건 개수, 가방 부피
	public static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			////////////////////
			str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			V = new int[N+1];
			C = new int[N+1];
			dp = new int[N+1][K+1];
			
			for(int j=1; j<=N; j++) {
				str = br.readLine().split(" ");
				V[j] = Integer.parseInt(str[0]);
				C[j] = Integer.parseInt(str[1]);
			}
			sb.append("#").append(i).append(" ").append(knapsack()).append("\n");
			////////////////////
		}
		System.out.println(sb);
	}
	
	public static int knapsack() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j-V[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-V[i]] + C[i]);
				}
			}
		}
		return dp[N][K];
	}
}
