package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example001_새로운불면증치료법 {
	public static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		////////////알고리즘 구현부///////////
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(test_case).append(" ").append(sol(N)).append("\n");
			
		}
		System.out.println(sb);
	}
	
	public static int sol(int n) {
		check = new boolean[10];
		int cnt = 0;
		int addNum = n;
		while(true) {
			int num = n;
			while(num > 0) {
				if(check[num % 10] != true) {
					check[num % 10] = true;
					cnt++;
				}
				num /= 10;
			}
			if(cnt == 10) {
				return n;
			} else
				n = n + addNum;
		}
	}
}
