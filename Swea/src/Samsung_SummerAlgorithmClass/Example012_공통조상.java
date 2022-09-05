package Samsung_SummerAlgorithmClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Example012_공통조상 {
	static int[] edge;
	static int[][] edge2;
	static ArrayList<ArrayList<Integer>> edgeList;
	static boolean[] visited;
	static String[] str;
	static int commonParent;
	static int V;
	static int E;
	static int result;
	static int num1;
	static int num2;
	static int parent;
	static int child;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			//////////////////////////
			str = br.readLine().split(" ");
			V = Integer.parseInt(str[0]);	// 정점의 수
			E = Integer.parseInt(str[1]);	// 간선의 수(V-1)
			num1 = Integer.parseInt(str[2]);	// 정점1
			num2 = Integer.parseInt(str[3]);	// 정점2
			commonParent = 0;
			result = 0;
			edge = new int[V+1];
			//edge2 = new int[V+1][V+1];
			edgeList = new ArrayList<ArrayList<Integer>>();
			visited = new boolean[V+1];
			
			str = br.readLine().split(" ");
			for(int j=0; j<V+1; j++) {
				edgeList.add(new ArrayList<>());
			}
			for(int j=1; j<=E*2; j+=2) {
				parent = Integer.parseInt(str[j-1]);		// 부모 노드
				child = Integer.parseInt(str[j]);			// 자식 노드
				edge[child] = parent;		// 정점 child의 parent는 edge[child]
				//edge2[parent][child] = 1;
				edgeList.get(parent).add(child);
			}
			
			// 정점1의 조상노드 탐색(root까지)
			int curNode = num1;
			int curParent;
			while(curNode != 1) {
				curParent = edge[curNode];
				curNode = curParent;
				visited[curNode] = true;
			}
			
			// 정점2의 조상노드 탐색(정점1과의 공통조상까지)
			curNode = num2;
			while(curNode != 1) {
				curParent = edge[curNode];
				if(visited[curParent] == true) {
					commonParent = curParent;
					break;
				}
				curNode = curParent;
				visited[curNode] = true;
			}
			visited = new boolean[V+1];
			sb.append("#").append(i).append(" ").append(commonParent).append(" ").append(getCount(commonParent)).append("\n");
		}
		System.out.print(sb);
	}
	/*public static int getCount(int n) {
		result++;
		visited[n] = true;
		for(int i=1; i<=V; i++) {
			if(edge2[n][i] == 1 && visited[i] == false) {
				getCount(i);
			}
		}
		return result;
	}*/
	public static int getCount(int n) {
		result++;
		if(n > V)
			return result;
		visited[n] = true;
		for(int nv : edgeList.get(n)) {
			if(visited[nv] == false) {
				getCount(nv);
			}
		}
		return result;
	}
}