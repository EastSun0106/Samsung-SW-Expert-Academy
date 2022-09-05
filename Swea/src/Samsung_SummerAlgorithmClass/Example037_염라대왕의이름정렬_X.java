package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example037_염라대왕의이름정렬_X {

	static int N;
	static StringBuilder sb;
	static HashSet<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#" + tc + "\n");
			N = Integer.parseInt(br.readLine());
			set = new HashSet<String>();
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				set.add(str);
			}
			
			ArrayList<String> list = new ArrayList<String>(set);

			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						return o1.compareTo(o2);
					} else
						return o1.length() - o2.length();
				}
			});

			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i) + "\n");
			}

			System.out.print(sb);
		}
	}

}
