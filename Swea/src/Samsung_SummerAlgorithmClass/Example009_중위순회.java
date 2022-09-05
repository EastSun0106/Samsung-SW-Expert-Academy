package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example009_중위순회 {
	public static char[] binaryTree;
	public static int N;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for(int i=1; i<=10; i++) {
			N = Integer.parseInt(br.readLine());
			
			binaryTree = new char[N+1];
			
			for(int j=1; j<=N; j++) {
				String[] str = br.readLine().split(" ");
				binaryTree[j] = str[1].charAt(0);
			}
			sb.append("#").append(i).append(" ");
			inOrder(1);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static void inOrder(int num) {
		if(num > N)
			return;
		inOrder(2 * num);
		sb.append(binaryTree[num]);
		inOrder(2 * num + 1);
	}
}
