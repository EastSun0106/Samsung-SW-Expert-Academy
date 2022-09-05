package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example042_사탕가방_X {
	public static int N; 
	public static long M, minValue, maxValue, mid, cnt;
	public static long[] arr;
	public static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Long.parseLong(str[1]);
			
			str = br.readLine().split(" ");
			arr = new long[N];
			for(int i=0; i<N; i++) {
				arr[i] = Long.parseLong(str[i]);
			}
			
			play();
			sb.append("#").append(tc).append(" ").append(maxValue).append("\n");
		}
		System.out.print(sb);
	}
	public static void play() {
		Arrays.sort(arr);
		minValue = 1;
		maxValue = arr[N-1];
		
		while(minValue <= maxValue) {
			mid = (minValue + maxValue) / 2;
			cnt = 0;
			for(long a : arr) {
				cnt += a / mid;
			}
			
			if(cnt < M)
				maxValue = mid - 1;
			else
				minValue = mid + 1;
		}
	}
}
