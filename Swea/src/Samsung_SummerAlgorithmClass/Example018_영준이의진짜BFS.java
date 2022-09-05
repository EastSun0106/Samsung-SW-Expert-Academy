package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example018_영준이의진짜BFS {

	static Map<Long, Integer> map;

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; ++tc){
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			List<Node> node = new ArrayList<Node>();
			map = new HashMap<Long, Integer>();

			node.add(new Node());

			for (int i = 1; i < N; i++){
				int p = Integer.parseInt(arr[i - 1]) - 1;
				node.add(new Node(node, p));
				node.get(p).children.add(i);
			}

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(0);
			int to = 0;
			long cnt = 0;

			while (!queue.isEmpty()){
				int id = queue.poll(), len = node.get(id).children.size(), lca = lca(node, id, to);

				cnt += node.get(to).dep - node.get(lca).dep;
				cnt += node.get(id).dep - node.get(lca).dep;

				to = id;
				for (int i = 0; i < len; i++) queue.add(node.get(id).children.get(i));
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}

	public static int lca(List<Node> node, int a, int b){
		if (a == b) return a;

		int parentNode = node.get(a).dep, childNode = node.get(b).dep;

		if (parentNode > childNode){
			int c = a;
			a = b;
			b = c;
			c = parentNode;
			parentNode = childNode;
			childNode = c;
		}

		while (parentNode < childNode){
			b = node.get(b).parent;
			childNode--;
		}

		return lca2(node, a, b);
	}

	public static int lca2(List<Node> node, int a, int b){
		if (a == b) return a;
	
		long key = (long)a * 100000 + (long)b;
		if (map.containsKey(key)){
			return map.get(key);
		}

		a = node.get(a).parent;
		b = node.get(b).parent;

		int result = lca2(node, a, b);

		map.put(key, result);

		return result;
	}

	public static class Node{
		int parent, dep;
		List<Integer> children = new ArrayList<Integer>();

		public Node(){
			parent = 0;
			dep = 0;
		}

		public Node(List<Node> node, int parent){
			this.parent = parent;
			this.dep = node.get(parent).dep + 1;
		}
	}

}
