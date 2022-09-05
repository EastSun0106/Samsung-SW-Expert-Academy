package Samsung_SummerAlgorithmClass;

import java.io.*;

public class Example023_최대상금 {
	public static int max;
	public static int len;
	public static char[] strs;
	public static String[] temp;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= tc ; i++) {
            temp = br.readLine().split(" ");
            String str = temp[0];
            int change = Integer.parseInt(temp[1]);
            strs = str.toCharArray();
            len = str.length();
        
            max = 0;
            
            play(0, change);
            sb.append("#").append(i).append(" ").append(max).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void swap(int a, int b) {
        char tmp = strs[a];
        strs[a] = strs[b];
        strs[b] = tmp;
    }
    
    static void play(int chgCnt, int cnt) {
 
        if(cnt%2 == 0)
            max = Math.max(max, Integer.parseInt(new String(strs)));
        
        if(cnt == 0) {
            return;
        }
        
        if(chgCnt == len-1) {
            if(cnt%2 == 1) {
                swap(len-2, len-1);
                max = Math.max(max, Integer.parseInt(new String(strs)));
                swap(len-2, len-1);
            }
            return;
        }
 
        play(chgCnt+1, cnt);
        
        int max_num = strs[chgCnt] - '0';
        for(int i = chgCnt+1 ; i < len ; i++) {
            if(max_num <= strs[i] - '0') {
                swap(i, chgCnt);
                play(chgCnt+1 , cnt-1);
                swap(i, chgCnt);
            }
        }
            
    }
    
}
