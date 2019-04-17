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
	 * 将list集合转换为json文件保存在data文件夹下
	 * @param list
	 * @throws FileNotFoundException
	 */
	public GenerateJsonData(List<?> list){
		//反射获取当前list的泛型
		Class<?> clazz=list.get(0).getClass();
		//获取该对象的所有属性
	    Field[] fields=clazz.getDeclaredFields();
	    String[] strs=new String[1];
	    /*
	     * 将set属性过滤掉
	     * 因为pojo类中有包含外键的属性Set<?>
	     * set类型属性不能放在前台页面中
	     * 否则500:net.sf.json.JSONException: org.hibernate.LazyInitializationException: 
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
			System.err.println("生成json数据异常");
		}
		pfp.print(data);
		pfp.flush();
		pfp.close();
//		System.out.println(data);
	}
	public static String castJson(List<?> list) {
		//反射获取当前list的泛型
				Class<?> clazz=list.get(0).getClass();
				//获取该对象的所有属性
			    Field[] fields=clazz.getDeclaredFields();
			    String[] strs=new String[1];
			    /*
			     * 将set属性过滤掉
			     * 因为pojo类中有包含外键的属性Set<?>
			     * set类型属性不能放在前台页面中
			     * 否则500:net.sf.json.JSONException: org.hibernate.LazyInitializationException: 
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
