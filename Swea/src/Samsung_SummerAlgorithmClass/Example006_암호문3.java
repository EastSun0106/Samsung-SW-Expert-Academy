package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.ArrayList;

public class Example006_암호문3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=10; i++) {
			int N = Integer.parseInt(br.readLine());	// 원본 암호문 길이
			String[] str = br.readLine().split(" ");	// 원본 암호문
			int M = Integer.parseInt(br.readLine());	// 명령어 개수
			String[] order = br.readLine().split(" ");	// 명령어
			ArrayList<String> list = new ArrayList<String>();
			for(int num=0; num<str.length; num++) {
				list.add(str[num]);
			}
			for(int j=0; j<order.length; j++) {
				if(order[j].equals("I") || order[j].equals("A") || order[j].equals("D")) {
					if(order[j].equals("I")) {
						int x = Integer.parseInt(order[j+1]);	// x위치 바로 다음
						int y = Integer.parseInt(order[j+2]);	// y개의 숫자
						for(int k=0; k<y; k++, x++) {
							list.add(x, order[j+k+3]);
						}
					} else if(order[j].equals("A")) {
						int x = Integer.parseInt(order[j+1]);
						for(int k=0; k<x; k++) {
							list.add(list.size(), order[j+k+2]);
						}

					} else if(order[j].equals("D")) {
						int x = Integer.parseInt(order[j+1]);
						int y = Integer.parseInt(order[j+2]);
						for(int k=0; k<y; k++) {
							list.remove(x);
						}
					}
				}
			}
			sb.append("#").append(i).append(" ");
			for(int l=0; l<10; l++) {
				sb.append(list.get(l)).append(" ");
			}
			sb.append("\n");
				
		}
		System.out.print(sb);
	}

}
