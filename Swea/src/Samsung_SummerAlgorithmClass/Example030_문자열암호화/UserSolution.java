package Samsung_SummerAlgorithmClass.Example030_문자열암호화;

public class UserSolution {
	public static char[] str;
	public void init(int len, char[] init_string) {
		str = new char[len];
		for(int i=0; i<len; i++) {
			str[i] = init_string[i];
		}
	}
	
	public int change(char[] string_A, char[] string_B) {
		int changeCnt = 0;
		for(int i=0; i<str.length-2; i++) {
			if(string_A[0] == str[i] && string_A[1] == str[i+1] && string_A[2] == str[i+2]) {
				str[i] = string_B[0];
				str[i+1] = string_B[1];
				str[i+2] = string_B[2];
				i += 2;
				changeCnt++;
			}
		}
		return changeCnt;
	}
	
	public void result(char[] ret) {
		for(int i=0; i<str.length; i++) {
			ret[i] = str[i];
		}
	}
	
}
