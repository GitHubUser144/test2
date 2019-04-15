package cn.dazky.util;

import java.util.ArrayList;
import java.util.List;

import cn.dazky.dao.impl.RoleDaoImpl;
import cn.dazky.dao.impl.UserDaoImpl;

public class StringUtil {
	
	/**
	 * �ж��ַ����ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * �ж��ַ������ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * �ж�ĳһ���ַ����������Ƿ���ĳһ�ַ���
	 * @param str
	 * @param strArr
	 * @return
	 */
	public static boolean existStrArr(String str,String []strArr){
		for(int i=0;i<strArr.length;i++){
			if(strArr[i].equals(str)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ʹ�ö����и��ַ���
	 * @param str
	 * @return 
	 */
	public static List<Integer> splitByDot(String str){
		String[] elements=str.split(",");
		List<Integer> list=new ArrayList<Integer>();
		for(String sss:elements) {
			list.add(new Integer(sss));
		}
		return list;
	}
	
	  public static void main(String[] args) {
		  System.out.println(new UserDaoImpl().selectAllUsers());
	  System.out.println(new RoleDaoImpl().selectAllRoles());
	  }
}
