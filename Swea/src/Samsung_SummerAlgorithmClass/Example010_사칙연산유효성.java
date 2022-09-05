package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example010_사칙연산유효성 {
	public static int N;
	public static String[] binaryTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=10; i++) {
			N = Integer.parseInt(br.readLine());
			binaryTree = new String[N+1];
			int result = 1;
			for(int j=1; j<=N; j++) {
				String[] str = br.readLine().split(" ");
				if(str.length == 2) {	// 단말노드인 경우. 숫자만 와야됨.
					if(str[1].charAt(0) == '+' || str[1].charAt(0) == '-' || str[1].charAt(0) == '*' || str[1].charAt(0) == '/') {
						result = 0;
						continue;
					}
				} else if(str.length == 4) {	// 부모노드인 경우. 연산자가 와야됨.
					if(str[1].charAt(0) >= '0' && str[1].charAt(0) <= '9') {
						result = 0;
						continue;
					}
				}
			}
			sb.append("#").append(i).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
