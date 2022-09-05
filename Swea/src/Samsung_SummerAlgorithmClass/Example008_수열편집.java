package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example008_수열편집 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> list;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			list = new LinkedList<Integer>();
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);		// 수열의 길이
			int M = Integer.parseInt(str[1]);		// 연산 횟수
			int L = Integer.parseInt(str[2]);		// 출력 index no
			
			str = br.readLine().split(" ");
			for(int k=0; k<N; k++) {
				list.add(Integer.parseInt(str[k]));	// 수열 입력
			}
			
			for(int j=1; j<=M; j++) {
				str = br.readLine().split(" ");	// 명령 입력
				if(str[0].charAt(0) == 'D') {
					int num = Integer.parseInt(str[1]);
					list.remove(num);
				} else if(str[0].charAt(0) == 'I') {
					int num1 = Integer.parseInt(str[1]);
					int num2 = Integer.parseInt(str[2]);
					list.add(num1, num2);
				} else {
					int num1 = Integer.parseInt(str[1]);
					int num2 = Integer.parseInt(str[2]);
					list.set(num1, num2);
				}
			}
			if(list.size() <= L)
				sb.append("#").append(i).append(" ").append(-1).append("\n");
			else
				sb.append("#").append(i).append(" ").append(list.get(L)).append("\n");
		}
		System.out.println(sb);
	}

}
