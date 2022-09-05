package Samsung_SummerAlgorithmClass.example015_기초BFS연습;

class UserSolution {
	public static int tempMap[][];
	public static boolean visited[][];
	public static int count[][];
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };
	public static int queueX[];
	public static int queueY[];
	public static int frontX;
	public static int rearX;
	public static int frontY;
	public static int rearY;
	public static int result;

	void bfs_init(int map_size, int map[][]) {
		tempMap = new int[11][11];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tempMap[i + 1][j + 1] = map[i][j];
			}
		}

	}

	int bfs(int x1, int y1, int x2, int y2) {
		visited = new boolean[11][11];
		count = new int[11][11];
		queueX = new int[100];
		queueY = new int[100];
		frontX = rearX = -1;
		frontY = rearY = -1;

		int tmp = 0;
		tmp = x1;
		x1 = y1;
		y1 = tmp;
		
		tmp = x2;
		x2 = y2;
		y2 = tmp;
		
		visited[x1][y1] = true;
		queueX[++rearX] = x1;
		queueY[++rearY] = y1;
		
		while (frontX != rearX || frontY != rearY) {
			int currX = queueX[++frontX];
			int currY = queueY[++frontY];
			for (int k = 1; k <= 4; k++) {
				int nextX = currX + dx[k - 1];
				int nextY = currY + dy[k - 1];
				if (nextX >= 1 && nextY >= 1 && nextX <= 10 && nextY <= 10 && tempMap[nextX][nextY] == 0
						&& visited[nextX][nextY] != true) {
					count[nextX][nextY] = count[currX][currY] + 1;
					if (nextX == x2 && nextY == y2) {
						return count[x2][y2];
					} else {
						visited[nextX][nextY] = true;
						queueX[++rearX] = nextX;
						queueY[++rearY] = nextY;
					}
				}
			}
		}
		return -1;
	}
}
