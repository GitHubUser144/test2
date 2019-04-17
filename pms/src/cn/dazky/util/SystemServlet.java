package cn.dazky.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class SystemServlet  extends HttpServlet{
    private static final Logger logger = Logger.getLogger(SystemServlet.class);
    
    private static final long serialVersionUID = -833322220864312415L;

    @Override
    public void init() throws ServletException {
        //获取根路径（web的发布地址）
        String rootPath = this.getServletContext().getRealPath("/");  
        //以info等级打印根路径
        logger.info(rootPath);
        
        //从web.xml中获取param-name为log4j.root.path的值--即指定的log4j的输出地址
        String log4jPath = this.getServletConfig().getInitParameter("log4j.root.path");  
        //若没有指定log4j.root.path初始参数，则使用WEB的工程目录--即web的发布地址  
        log4jPath = (log4jPath==null||"".equals(log4jPath))?rootPath:log4jPath;  
        //将log4j的存储地址设置为系统属性
        System.setProperty("log4j.root.path", log4jPath);
        //初始化
        super.init();  
    }
}
