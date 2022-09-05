package Samsung_SummerAlgorithmClass.example014_기초DFS연습;


public class UserSolution {
	public static int[][] edge;
	public static int kingPower;
	public static int curPower;
	public static int result;
	public void dfs_init(int N, int[][] path) {
		edge = new int[100][5];
		
		for(int i=0; i<N; i++) {
			int num1 = path[i][0];
			int num2 = path[i][1];
			for(int j=0; j<5; j++) {
				if(edge[num1][j] == 0) {
					edge[num1][j] = num2;
					break;
				}
			}
		}
	}
	
	public int dfs(int N) {
		kingPower = N;
		curPower = N;
		
		return playDfs(kingPower, curPower);
	}
	
	public int playDfs(int kingPower, int curPower) {
		int result = -1;
		for(int i=0; i<5 && edge[curPower][i] != 0; i++) {
			if(edge[curPower][i] > kingPower) {
				return edge[curPower][i];
			}
			result = playDfs(kingPower, edge[curPower][i]);
			if( result != -1) {
				return result;
			}
		}
		return result;
	}
}
