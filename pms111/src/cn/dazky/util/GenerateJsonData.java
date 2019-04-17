package cn.dazky.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class GenerateJsonData {
	/**
	 * ��list����ת��Ϊjson�ļ�������data�ļ�����
	 * @param list
	 * @throws FileNotFoundException
	 */
	public GenerateJsonData(List<?> list){
		//�����ȡ��ǰlist�ķ���
		Class<?> clazz=list.get(0).getClass();
		//��ȡ�ö������������
	    Field[] fields=clazz.getDeclaredFields();
	    String[] strs=new String[1];
	    /*
	     * ��set���Թ��˵�
	     * ��Ϊpojo�����а������������Set<?>
	     * set�������Բ��ܷ���ǰ̨ҳ����
	     * ����500:net.sf.json.JSONException: org.hibernate.LazyInitializationException: 
	     * 									 failed to lazily initialize a collection of role: X.X.X.X.X
	     */
	    for(Field f:fields) {
	    	//System.out.println(f.getType().toString());
	    	if(f.getType().toString().contains("Set")) {
	    		strs[0]=f.getName();
	    	}	    		
	    }
		JsonConfig jsonConfig = new JsonConfig();

		jsonConfig .setExcludes(strs) ;

		JSONArray jsonModel= JSONArray.fromObject(list, jsonConfig );
		String data="{\"code\":0,\"msg\":\"\",\"count\":"+list.size()+",\"data\":"+jsonModel.toString();
		data=data+"}";
		File fp=new File("D:\\EclipseWorkSpace\\pms\\WebContent\\data\\"+(list.get(0).getClass().getSimpleName()).toLowerCase()+".json");
		PrintWriter pfp = null ;
		try {
			pfp = new PrintWriter(fp);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("����json�����쳣");
		}
		pfp.print(data);
		pfp.flush();
		pfp.close();
//		System.out.println(data);
	}
	public static String castJson(List<?> list) {
		//�����ȡ��ǰlist�ķ���
				Class<?> clazz=list.get(0).getClass();
				//��ȡ�ö������������
			    Field[] fields=clazz.getDeclaredFields();
			    String[] strs=new String[1];
			    /*
			     * ��set���Թ��˵�
			     * ��Ϊpojo�����а������������Set<?>
			     * set�������Բ��ܷ���ǰ̨ҳ����
			     * ����500:net.sf.json.JSONException: org.hibernate.LazyInitializationException: 
			     * 									 failed to lazily initialize a collection of role: X.X.X.X.X
			     */
			    for(Field f:fields) {
			    	//System.out.println(f.getType().toString());
			    	if(f.getType().toString().contains("Set")) {
			    		strs[0]=f.getName();
			    	}	    		
			    }
				JsonConfig jsonConfig = new JsonConfig();

				jsonConfig .setExcludes(strs) ;

				JSONArray jsonModel= JSONArray.fromObject(list, jsonConfig );
				
				return jsonModel.toString();
	}
	
	/*
	 * public static void main(String[] args) { UserDao userDao=new UserDaoImpl();
	 * 
	 * try { new GenerateJsonData((List<Object>) userDao.selectAllUsers()); } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
}
