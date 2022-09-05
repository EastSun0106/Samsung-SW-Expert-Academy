package Samsung_SummerAlgorithmClass.example028_연락처DB;

import java.util.*;

class UserSolution {
	public static int cnt;
	public static ArrayList<Record> recordList;
	public static HashMap<String, ArrayList<Record>> map;
	public static HashMap<Integer, HashMap<String, ArrayList<Record>>> recordMap;
	public class Record{
		String name, number, birthday, email, memo;
		
		public Record(String name, String number, String birthday, String email, String memo) {
			this.name = name;
			this.number = number;
			this.birthday = birthday;
			this.email = email;
			this.memo = memo;
		}
	}
	
	void InitDB()
	{
		recordList = new ArrayList<Record>();
		map = new HashMap<String, ArrayList<Record>>();
		recordMap = new HashMap<Integer, HashMap<String, ArrayList<Record>>>();		// <field(0-5, 0:name...), map<pk, recordList>>
	}

	void Add(String name, String number, String birthday, String email, String memo)
	{
		//System.out.println(name + " " + number + " " + birthday + " " + email + " " + memo);
		Record record = new Record(name, number, birthday, email, memo);
		recordList.add(record);
		for(int i=0; i<5; i++) {
			map.clear();
			if(i==0) {	// name
				map.put(name, recordList);
				recordMap.put(i, map);
				
			} else if(i==1) {
				map.put(number, recordList);
				recordMap.put(i, map);
				
			} else if(i==2) {
				map.put(birthday, recordList);
				recordMap.put(i, map);
				
			} else if(i==3) {
				map.put(email, recordList);
				recordMap.put(i, map);
			} else {
				map.put(memo, recordList);
				recordMap.put(i, map);
			}
		}
	}

	int Delete(int field, String str)
	{	
		cnt = 0;
		System.out.println("@@@@" + recordMap.get(field).get(str).get(0).name);
		if(!recordMap.get(field).containsKey(str))
			return cnt;
		
		for(int i=0; i<recordList.size(); i++) {
			if(field == 0) {
				if(recordMap.get(field).remove(str) != null) {
					cnt++;
				}
			} else if(field == 1) {
				
			} else if(field == 2) {
				
			}else if(field == 3) {
				
			} else {
				
			}
		}
		return cnt;
	}

	int Change(int field, String str, int changefield, String changestr)
	{
		return -1;
	}

	Solution.Result Search(int field, String str, int returnfield)
	{
		Solution.Result result = new Solution.Result();
		result.count = -1;

		return result;
	}
}

