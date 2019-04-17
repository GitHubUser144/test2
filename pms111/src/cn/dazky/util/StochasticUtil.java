package cn.dazky.util;

import java.util.Random;
import java.util.UUID;

/**
 *@author: 
 *@date: 
 *@version:
 *@description�������������/�ַ���/uuid�ȹ���
 */
public class StochasticUtil {

	/**
	 * �������
	 * @param num
	 * @return
	 */
	public static int getRandom(int num){
		Random random = new Random();
		return random.nextInt(num);
	}
	
	
	/**
	 * �����ĸ
	 * @param num
	 * @return
	 */
	public static String getRandom(double num){
		String pool = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		String str = "";
		for (long i = 0; i < num; i++) {
			int j = new Random().nextInt(pool.length());
			str += pool.charAt(j);
		}
		return str;
	}
	
	
	/**
	 * �������UUID
	 * @return
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	
	
	/**
	 * �����ַ������ɹ̶�uuid
	 * @param name
	 * @return
	 */
	public static String getUUID(String name){
		UUID uuid=UUID.nameUUIDFromBytes(name.getBytes());
	    return uuid.toString().replace("-", "");
	}

}
