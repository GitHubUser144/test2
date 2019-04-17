package cn.dazky.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	
	/**
	 * 将日期格式化成String类型
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getTime(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
}
