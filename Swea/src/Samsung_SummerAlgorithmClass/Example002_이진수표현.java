package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example002_이진수표현 {
	public static ArrayList<Boolean> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=TC; i++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);	// 체크할 비트 개수
			int M = Integer.parseInt(str[1]);	// 정수
			
			sb.append("#").append(i).append(" ").append(sol(N, M)).append("\n");
		}
		System.out.println(sb);
	}
	
	public static String sol(int n, int m) {
		if(m == 0)
			return "OFF";
		
		list = new ArrayList<Boolean>();
		
		while(m > 0) {
			if(m%2 == 1) {
				list.add(true);
				m /= 2;
			} else {
				list.add(false);
				m /= 2;
			}
		}
		
		if(list.size() < n)
			return "OFF";
		
		for(int i=0; i<n; i++) {
			if(list.get(i) == false) {
				return "OFF";
			}
		}
		return "ON";
	}
}
