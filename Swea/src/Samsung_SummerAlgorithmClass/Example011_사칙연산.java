package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example011_사칙연산 {
	static String[] vertex;
	static int[][] edge;
	static int n;
	static int[] visited;
	static Stack <Integer> stack;
	static StringBuilder sb;
	public static void operation(String s) {
		if(s.equals("+")) {
			int num1 = stack.pop();
			int num2 = stack.pop();
			stack.push(num2+num1);
		}
		else if(s.equals("-")) {
			int num1 = stack.pop();
			int num2 = stack.pop();
			stack.push(num2-num1);
		}
		else if(s.equals("*")) {
			int num1 = stack.pop();
			int num2 = stack.pop();
			stack.push(num2*num1);
		}
		else if(s.equals("/")) {
			int num1 = stack.pop();
			int num2 = stack.pop();
			stack.push(num2/num1);
		}
		else {
			int num = Integer.parseInt(s);
			stack.push(num);
		}
	}
	
	public static void dfs(int x) {
		visited[x] = 1;
		
		for(int i = 1; i <= n; i++) {
			if(edge[x][i] == 1 && visited[i] == 0)
				dfs(i);
		}
		operation(vertex[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			edge = new int[n + 1][n + 1];
			vertex = new String[n+1];
			visited = new int[n + 1];
			stack = new Stack<>();
			
			for(int i = 0; i < n; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(tk.nextToken());
				vertex[from] = tk.nextToken(); 
				
				for(int j = 0; j < 2; j++) {
					if(tk.hasMoreTokens()) {
						int to = Integer.parseInt(tk.nextToken());
						edge[from][to] = 1;
					}
				}
			}
			dfs(1);
			System.out.println("#" + t + " " + stack.pop());
		}
	}
}
