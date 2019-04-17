package cn.dazky.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String url;
	
	static {
		Properties pros = new Properties();
		InputStream in = PropertiesUtil.class.getResourceAsStream("/log4j.properties");
		try {
			pros.load(in);
			url= pros.getProperty("log4j.appender.file.File");
		} catch (Exception e) {
			System.out.println("�����ļ�����ʧ��");
			e.printStackTrace();
		}
	}
	
	
}

