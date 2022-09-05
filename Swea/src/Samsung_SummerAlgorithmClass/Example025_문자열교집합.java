package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example025_문자열교집합 {
	public static HashSet<String> set;
	public static int N, M;
	public static String[] str;
	public static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			result = 0;
			set = new HashSet<String>();
			str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			
			str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				set.add(str[j]);
			}
			
			str = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				if(set.contains(str[j])) {
					result++;
				}
			}
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
