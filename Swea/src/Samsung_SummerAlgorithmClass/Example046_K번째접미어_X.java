package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example046_K번째접미어_X {
	public static int k, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		StringBuilder result;
		String str;
		String[] wordArr = new String[400];

		for (int test_case = 1; test_case <= T; test_case++) {
			result = new StringBuilder().append("#").append(test_case).append(" ");
			N = Integer.parseInt(br.readLine());
			str = br.readLine();
			for (int i = 0, end = str.length(); i < end; i++) {
				wordArr[i] = str.substring(i);
			}
			Arrays.sort(wordArr, 0, str.length());

			if (N < str.length()) {
				result.append(wordArr[N - 1]);
			} else {
				result.append("none");
			}
			
			bw.write(result.append("\n").toString());
		}
		bw.flush();
		bw.close();
	}
}
