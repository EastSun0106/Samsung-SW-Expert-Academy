package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example047_K번째문자열_X {
	public static int k, j, subCnt;
	public static int[] lcp;
	public static String str;
	public static String[] strArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			k = Integer.parseInt(br.readLine());
			str = br.readLine();
			strArr = new String[str.length()];
			lcp = new int[str.length()];

			for (int i = 0; i < str.length(); i++)
				strArr[i] = str.substring(i);

			Arrays.sort(strArr);
			lcp[0] = 0;
			for (int i = 1; i < str.length(); i++) {
				String prev = strArr[i - 1];
				String cur = strArr[i];
				j = 0;
				while (j < prev.length() && j < cur.length() && prev.charAt(j) == cur.charAt(j))
					j++;
				lcp[i] = j;
			}

			subCnt = 0;
			for (int i = 0; i < str.length(); i++) {
				subCnt += strArr[i].length() - lcp[i];
				if (subCnt >= k) {
					System.out.printf("#%d %s\n", t, strArr[i].substring(0, strArr[i].length() - (subCnt - k)));
					break;
				}
			}
			if (subCnt < k)
				System.out.printf("#%d none\n", t);
		}
	}
}
