package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example023_자기방으로돌아가기 {
	public static int[][] room;
	public static int T;
	public static int N;
	public static String[] str;
	public static int start;
	public static int end;
	public static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			/////////////////////////////
			N = Integer.parseInt(br.readLine());
			room = new int[N][2];
			for(int i=0; i<N; i++) {
				str = br.readLine().split(" ");
				// 방 번호 입력이 역순일 수도 있음 ;;
				room[i][0] = Math.min(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
				room[i][1] = Math.max(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			}
			
			Arrays.sort(room, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);	// start 순으로 정렬
			
			cnt = 0;
			for(int i=0; i<N; i++) {
				if(room[i][0] != 0 && room[i][1] != 0) {		// 아직 못 돌아간 방
					cnt++;
					start = room[i][0];
					if(room[i][1] % 2 == 1)						// 도착지점이 홀수면 짝수로 가정
						end = room[i][1] + 1;
					else
						end = room[i][1];
					room[i][0] = 0;
					room[i][1] = 0;
				}
				for(int j=i+1; j<N; j++) {
					if(room[j][0] != 0 && room[j][1] != 0) {	// 아직 못 돌아간 방
						if(end < room[j][0]) {					// 동선 겹치지 않는 방
							if(room[j][1] % 2 == 1)				// 도착지점이 홀수면 짝수로 가정
								end = room[j][1] + 1;
							else
								end = room[j][1];
							room[j][0] = room[j][1] = 0;
						} else {								// 동선 겹치는 방
							continue;
						}
					}
				}
				
			}
			/////////////////////////////
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}

}
