package cn.dazky.util;


public class ButtonPermissions {
	public static boolean judge(int operationid,String operationids){
		if(operationids==null){
			return false;
		}
		String[] sss=operationids.split(",");
		for(String aaa:sss) {
			if(Integer.parseInt(aaa)==operationid)
				return true;
		}
		return false;
	}

}
