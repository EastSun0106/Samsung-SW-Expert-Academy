package Samsung_SummerAlgorithmClass;

import java.io.*;
import java.util.*;

public class Example003_동아리실관리하기 {
	public static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			// 구현부
			String str = br.readLine();
			sb.append("#").append(i).append(" ").append(sol(str)).append("\n");
		}
		System.out.println(sb);
	}
	//0001=1 : A, 0010=2 : B, 0100=4 : C, 1000=8 : D
	public static int sol(String str) {
		int N = str.length();
		dp = new int[N+1][16];
		dp[0][3] = 1;
		dp[0][7] = 1;
		dp[0][11] = 1;
		dp[0][15] = 1;
		for(int day = 1; day <= N; day++) {
			for(int bit = 1; bit <= 15; bit++) {
				char ch = str.charAt(day-1);
				int val = 0;
				if(ch == 'A')
					val = 1;
				else if(ch == 'B')
					val = 2;
				else if(ch == 'C')
					val = 4;
				else
					val = 8;
				if((bit & val) > 0) {
					for(int preBit=1; preBit <=15; preBit++) {
						if((bit & preBit) > 0) {
							dp[day][bit] = dp[day][bit]%1000000007 + dp[day-1][preBit]%1000000007;
						}
					}
				}
			}
		}
		int sum = 0;
		for(int i=1; i<=15; i++) {
			sum += dp[N][i];
		}
		return sum;
	}
}

/*
for(int day = 1; day <= N; day++) {
    for (int bit = 1; bit <= 15; bit++) {
        if (bit & 책임자) {
            for (int pre_bit = 1; pre_bit <= 15; pre_bit+) {
                if (bit & pre_bit) {
                    dp[day][bit] += dp[day - 1][pre_bit]
                }
            }
        }
    }
}
*/
/*
1일차 key : A소유
BC 입력

조건 : 다음 날엔 전 날에 있던 사람 중 최소 1명은 꼭 있어야 함 + 담당자

1일차
1 A B
2 A B C
3 A B D
4 A B C D

2일차
1 C A	 : 전날 키 소유자 +1명, +1명이 다음 날 담당자가 아닐 때
  C B
  C A B
  C A D
  C A B D
2 C		: 전날 키 소유자 +2명, +2명 중 한 명이 다음 날 담당자일 때
  C A
  C B
  C A B
  C A D
  C A B D
3 C A	: 전날 키 소유자 +2명, +2명 둘 다 다음 날 담당자가 아닐 때
  C B
  C D
  C A B
  C A D
  C A B D
4 C		: 전날 키 소유자 +3명
  C A
  C B
  C D
  C A B
  C A D
  C B D
  C A B D
CASE 1 : 담당자만 있을 때 		CASE 2 : 담당자+1명		CASE 3 : 담당자+2명		CASE 4 : 담당자+3명
*/