package Samsung_SummerAlgorithmClass.example031_기초PartialSort연습;

public class UserSolution {
	public static int[][] arr;
	public static int addCnt;
	public void init() {
		addCnt = 0;
		arr = new int[11][2];	//[uId][income]
	}
	
	public void addUser(int uID, int income) {
		addCnt++;
		int tempId = 0;
		int tempIncome = 0;
		arr[10][0] = uID;
		arr[10][1] = income;
		for(int i=9; i>=0; i--) {
			if(arr[i+1][1] > arr[i][1]) {
				tempId = arr[i][0];
				tempIncome = arr[i][1];
				arr[i][0] = arr[i+1][0];
				arr[i][1] = arr[i+1][1];
				arr[i+1][0] = tempId;
				arr[i+1][1] = tempIncome;
			} else {
				break;
			}
		}
	}
	
	int getTop10(int[] result) {
		for(int i=0; i<10; i++) {
			result[i] = arr[i][0];
		}
		int cnt = 0;
		if(addCnt > 10)
			return 10;
		else
			return addCnt;
	}
}