package hashing;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberOfEmployeeUnderManager {
		static Map<String,Integer> resultSet=new HashMap<String,Integer>();
	
	public static void main(String[] args) {
		Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
        getNumbers(dataSet);
        System.out.println(resultSet);
	}

	 static void getNumbers(Map<String, String> dataSet) {
		Map<String,List<String>> managerData=new HashMap<String,List<String>>();
		for(Map.Entry<String, String> entry:dataSet.entrySet()){
			String emp=entry.getKey();
			String manager=entry.getValue();
			if(!emp.equals(manager)){
				List<String> list=managerData.get(manager);
				if(list==null)
					list=new ArrayList<String>();
				list.add(emp);
				managerData.put(manager, list);
			}
		}
		for(String manager:managerData.keySet()){
			getEmpNumbers(manager,managerData);
		}
		
	}

	 static int getEmpNumbers(String manager, Map<String, List<String>> managerData) {
		int count =0;
		if(!managerData.containsKey(manager)){
			resultSet.put(manager, 0);
			return 0;
		}
		else if(resultSet.containsKey(manager)){
			count=resultSet.get(manager);
		}
		else{
			List<String> list=managerData.get(manager);
			count=list.size();
			for(String a:list){
				count+=getEmpNumbers(a,managerData);
			}
			resultSet.put(manager, count);
		}
		return count;
	}

}
