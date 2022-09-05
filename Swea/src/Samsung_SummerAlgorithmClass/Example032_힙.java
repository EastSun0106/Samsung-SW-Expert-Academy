package Samsung_SummerAlgorithmClass;

import java.util.*;

public class Example032_힙 {
	public static StringBuilder sb;
    static void cal(int num, Scanner sc) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int d = 0; d < num; d++) {
            int type = sc.nextInt();
            if(type == 1) {
            	int value = sc.nextInt();
                queue.add(value);
            } else if(type == 2) {
            	int result;
                if (queue.isEmpty())
                    result = -1;
                else
                    result = queue.poll();
                sb.append(result).append(" ");
            }
        }
        sb.append("\n");
    }
    
    public static void main(String[] args) {
    	sb = new StringBuilder();
    	Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            int num = sc.nextInt();
            sb.append("#").append(t).append(" ");
            cal(num, sc);
        }
        System.out.print(sb);
    }

}
