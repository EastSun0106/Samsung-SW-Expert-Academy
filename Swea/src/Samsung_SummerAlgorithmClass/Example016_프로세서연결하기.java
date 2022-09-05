package Samsung_SummerAlgorithmClass;
/**
 * 
 * @author Dongil
 * dfs+bruteForce?
 * 	-벽에 인접해있는 코어는 제외한다
 *  -선이 겹치면 안된다
 *  +연결된 코어 개수별 총 전선 길이를 저장할 linkCore[13]
 *  +각 코어별 상하좌우 이동 이력을 남길 것이 필요하다!
 *	1. i+1, j+1부터 N-1까지 2중 for를 돌면서 1이 발견되면 dfs 시작
 *	2. visit한 부분은 -1 처리
 *	3. -1, 1이 아닌 부분만 탐색하면서 dist++, 벽에 닿으면 dfs 종료 후 cnt++
 */

import java.io.*;
import java.util.*;

public class Example016_프로세서연결하기 {
	public static int N;
	public static int[][] map;
	public static int maxCore;	// 이전 연결된 코어 최대 개수
	public static int minLen;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static ArrayList<Core> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			//////////////////////////
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			maxCore = 0;
			minLen = 1000000;
			list = new ArrayList<Core>();	// 코어 위치 저장
			
			for(int i=0; i<N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
					if(map[i][j] == 1 && i!=0 && i!=N-1 && j!=0 && j!=N-1) {	// 연결해야 할 코어 위치 저장
						list.add(new Core(i, j));
					}
				}
			}
				//Core core = list.get(0);
				dfs(0, 0, 0);
			////////////////////
			sb.append("#").append(tc).append(" ").append(minLen).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void dfs(int currCore, int len, int index) {
		if(index == list.size()) {	// 종료조건
			if(maxCore < currCore) {
				maxCore = currCore;
				minLen = len;
			} else if(maxCore == currCore) {
				minLen = Math.min(minLen, len);
			}
			return;
		}
		Core core = list.get(index);
		int curX = core.x;
		int curY = core.y;
		int curLen = 0;
		
		for(int i=0; i<4; i++) {
			int nextX = curX;
			int nextY = curY;
			boolean isOk = true;
			curLen = 0;
			while(true) {
				nextX += dx[i];
				nextY += dy[i];
				if(nextX >= 0 && nextY >= 0 && nextX <= N-1 && nextY <= N-1) { // map의 범위를 벗어나지 않고
					// 코어나 전선 위치가 아니고 가장자리에 닿았을 때
					if(map[nextX][nextY] != 1 && (nextX == 0 || nextY == 0 || nextX == N-1 || nextY == N-1)) {
						map[nextX][nextY] = 1;
						curLen++;
						break;
					}
					// 코어나 전선 위치가 아니고 다음 칸으로 이동 가능하면
					if(map[nextX][nextY] != 1) {
						map[nextX][nextY] = 1;
						curLen++;
					} else {	// 코어 or 전선위치
						isOk = false;
						break;
					}
				}
				
			}
			if(isOk) {
				dfs(currCore+1, len+curLen, index+1);
				int tempX = curX;
				int tempY = curY;
				for(int k=1; k<=curLen; k++) {
					tempX += dx[i];
					tempY += dy[i];
					map[tempX][tempY] = 0;
				}
				
			} else {
				int tempX = curX;
				int tempY = curY;
				for(int k=1; k<=curLen; k++) {
					tempX += dx[i];
					tempY += dy[i];
					map[tempX][tempY] = 0;
				}
				dfs(currCore, len, index+1);
			}
			
			
		}
	}	
	// 코어의 좌표
	public static class Core {
		int x;
		int y;
		
		Core(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
