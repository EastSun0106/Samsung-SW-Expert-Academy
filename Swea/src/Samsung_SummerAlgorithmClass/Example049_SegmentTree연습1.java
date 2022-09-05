package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example049_SegmentTree연습1 {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static Scanner sc;
	public static String[] str;
	public static int[] min_itree;
	public static int[] max_itree;
	public static int N, M, K, a, b, c, h, idx, left, right, gap, num, min_num, max_num, type;
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			simul();
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void simul() throws IOException {
		min_itree = new int[2222222];
		max_itree = new int[2222222];
		N=0; M=0; K=0; a=0; b=0; c=0; idx=0; left=0; right=0; num=0; min_num=0; max_num=0; type = 0;
	    h = 1;
	    gap = 1;
	    
	    N = sc.nextInt();
	    M = sc.nextInt();

	    while (N > (1 << h)) h++;
	    for (int i = 0; i < h; i++) {
	        gap *= 2;
	    }
	    for (int i = 0; i <= gap + N; i++) {
	        min_itree[i] = -1;
	        max_itree[i] = -1;
	    }
	    for (int i = 0; i < N; i++) {
	    	num = sc.nextInt();
	        min_itree[gap + i] = num;
	        max_itree[gap + i] = num;
	    }
	    for (int i = gap + N - 1; i > 1; i--) {
	        if (min_itree[i / 2] == -1 || min_itree[i / 2] > min_itree[i]) {
	            min_itree[i / 2] = min_itree[i];
	        }
	        if (max_itree[i / 2] == -1 || max_itree[i / 2] < max_itree[i]) {
	            max_itree[i / 2] = max_itree[i];
	        }
	    }

	    for (int i = 0; i < M; i++) {
	    	type = sc.nextInt();
	    	a = sc.nextInt();
	    	b = sc.nextInt();
	        if (type == 1) {
	        	
	            left = gap + a;
	            right = gap + b - 1;
	            min_num = min_itree[left];
	            max_num = max_itree[left];
	            if (min_num > min_itree[right]) min_num = min_itree[right];
	            if (max_num < max_itree[right]) max_num = max_itree[right];
	            while (left != right) {
	                if (left + 1 == right) {
	                    break;
	                }
	                if (left % 2 == 0 && min_num > min_itree[left + 1]) {
	                    min_num = min_itree[left + 1];
	                }
	                if (left % 2 == 0 && max_num < max_itree[left + 1]) {
	                    max_num = max_itree[left + 1];
	                }
	                left /= 2;
	                if (right % 2 != 0 && min_num > min_itree[right - 1]) {
	                    min_num = min_itree[right - 1];
	                }
	                if (right % 2 != 0 && max_num < max_itree[right - 1]) {
	                    max_num = max_itree[right - 1];
	                }
	                right /= 2;
	            }
	            sb.append(max_num - min_num).append(" ");
	        }
	        else {
	            idx = gap + a;
	            min_itree[idx] = b;
	            max_itree[idx] = b;
	            idx /= 2;
	            while (idx >= 1) {
	                if (min_itree[idx * 2 + 1] == -1 || min_itree[idx * 2] < min_itree[idx * 2 + 1]) {
	                    min_itree[idx] = min_itree[idx * 2];
	                }
	                else{
	                    min_itree[idx] = min_itree[idx * 2 + 1];
	                }
	                if (max_itree[idx * 2 + 1] == -1 || max_itree[idx * 2] > max_itree[idx * 2 + 1]) {
	                    max_itree[idx] = max_itree[idx * 2];
	                }
	                else{
	                    max_itree[idx] = max_itree[idx * 2 + 1];
	                }
	                idx /= 2;
	            }
	        }
	    }
	}
}
