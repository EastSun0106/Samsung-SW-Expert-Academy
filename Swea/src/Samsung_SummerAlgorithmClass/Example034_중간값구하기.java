package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example034_중간값구하기 {
	public static int N, A;
	public static int num1, num2, result;
	public static String[] str;
	public static PriorityQueue<Integer> pqueue;
	public static Queue<Integer> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; ++tc){
			String[] arr = br.readLine().split(" ");
			Queue<Integer> minHeap = new PriorityQueue<Integer>();
			Queue<Integer> maxHeap = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));
			
			int N = Integer.parseInt(arr[0]), midValue = Integer.parseInt(arr[1]), result = 0;
			
			for (int i = 0; i < N; i++){
				arr = br.readLine().split(" ");
				int A = Integer.parseInt(arr[0]);
				int B = Integer.parseInt(arr[1]);

				if (A < midValue) 
					maxHeap.add(A);
				else 
					minHeap.add(A);

				if (B < midValue) 
					maxHeap.add(B);
				else 
					minHeap.add(B);

				while (minHeap.size() < maxHeap.size()){
					minHeap.add(midValue);
					midValue = maxHeap.poll();
				}

				while (maxHeap.size() < minHeap.size()){
					maxHeap.add(midValue);
					midValue = minHeap.poll();
				}
				
				result = (result + midValue) % 20171109;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
}
