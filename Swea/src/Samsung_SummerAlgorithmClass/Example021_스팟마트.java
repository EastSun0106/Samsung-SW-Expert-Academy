package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example021_스팟마트 {

	public static int T,N,M;
	public static int[][][] dp = new int[3002][102][102];
	public static int[] A;
	public static Integer[] B;
     
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
        Scanner sc = new Scanner(System.in);
        T = Integer.parseInt(br.readLine());
        
        for(int t= 1; t <= T; t++){
        	N = Integer.parseInt(br.readLine());
            A = new int[N];
            
            for(int i=0; i<N;i++) {
                A[i] = Integer.parseInt(br.readLine());
            }
            M = Integer.parseInt(br.readLine());
            
            B = new Integer[M];
            
            for(int i=0; i<M; i++) {
                B[i] = Integer.parseInt(br.readLine());
            }
             
            for(int i=0; i<3002; i++) {
                for(int j=0; j<102; j++) {
                    for(int s=0; s<102;s++) {
                        dp[i][j][s] = 0;
                    }
                }
            }
             
            Arrays.sort(B, Collections.reverseOrder());
            
            int result =cal(0, 0, 0, M);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
 
    static int cal(int idx, int n, int m, int k) {
        if(idx>=N+M)
            return 0;
        
        if(dp[n][m][k] != 0)
            return dp[n][m][k];
        
        int num = 0;
        
        if(n+1 < N) {
            num = Math.max(num, A[n]+cal(idx+2,n+2,m,k));
        }
        
        if(n < N && (m != k || idx == N+M-1)) {
            num = Math.max(num, A[n]+cal(idx+2,n+1,m,k-1));
        }
        
        if(m != k && (n < N || idx == N+M-1)) {
            num = Math.max(num, B[m]+cal(idx+2,n+1,m+1,k));
        }
        
        if(m < k-1) {
            num = Math.max(num, B[m] + cal(idx+2,n,m+1,k-1));
        }
        
        if(n < N) {
            num = Math.max(num, cal(idx+1,n+1,m,k));
        }
        
        if(m != k) {
            num = Math.max(num, cal(idx+1,n,m,k-1));
        }
        
        dp[n][m][k] = num;
        
        return num;
    }

}
