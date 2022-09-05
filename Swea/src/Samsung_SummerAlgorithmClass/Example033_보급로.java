package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;
 
class Position {
    int x;
    int y;
 
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
 
class Example033_보급로 {
    // 위, 아래, 왼쪽, 오른쪽
    static int[] xdir = {-1,1,0,0};
    static int[] ydir = {0,0,-1,1};
    static int n;
    static int[][] board;
    static int min;
    static boolean[][] visited;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++){
            n = Integer.parseInt(br.readLine());
 
            board = new int[n][n];
            
            for(int i=0; i<n; i++){
                String[] temp = br.readLine().split("");
                for(int j=0; j<n; j++){
                    board[i][j] = Integer.parseInt(temp[j]);
                }
            }
 
            min = Integer.MAX_VALUE;
            visited = new boolean[n][n];
             
            arr = new int[n][n];
            for(int i=0; i<n; i++)
                Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[0][0] = 0;
 
            bfs(0,0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
 
    private static void bfs(int x, int y){
        Queue<Position> queue = new LinkedList<>();
 
        queue.offer(new Position(x,y));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Position p = queue.poll();
            int a = p.x;
            int b = p.y;
 
            if(a == n-1 && b == n-1)
                min = min > arr[n-1][n-1] ? arr[n-1][n-1] : min;
            if(min <= arr[a][b])
                continue;
            for(int i=0; i<4; i++){
                int dx = a + xdir[i];
                int dy = b + ydir[i];
                if(validation(dx, dy)){
                    if(!visited[dx][dy] || arr[dx][dy] > arr[a][b] + board[dx][dy]){
                        visited[dx][dy] = true;
                        arr[dx][dy] = arr[a][b] + board[dx][dy];
                        queue.offer(new Position(dx, dy));
                    }
                }
            }
        }
    }
 
    private static boolean validation(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        return true;
    }

}
