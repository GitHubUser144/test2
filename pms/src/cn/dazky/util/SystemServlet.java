package cn.dazky.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

public class SystemServlet  extends HttpServlet{
    private static final Logger logger = Logger.getLogger(SystemServlet.class);
    
    private static final long serialVersionUID = -833322220864312415L;

    @Override
    public void init() throws ServletException {
        //��ȡ��·����web�ķ�����ַ��
        String rootPath = this.getServletContext().getRealPath("/");  
        //��info�ȼ���ӡ��·��
        logger.info(rootPath);
        
        //��web.xml�л�ȡparam-nameΪlog4j.root.path��ֵ--��ָ����log4j�������ַ
        String log4jPath = this.getServletConfig().getInitParameter("log4j.root.path");  
        //��û��ָ��log4j.root.path��ʼ��������ʹ��WEB�Ĺ���Ŀ¼--��web�ķ�����ַ  
        log4jPath = (log4jPath==null||"".equals(log4jPath))?rootPath:log4jPath;  
        //��log4j�Ĵ洢��ַ����Ϊϵͳ����
        System.setProperty("log4j.root.path", log4jPath);
        //��ʼ��
        super.init();  
    }
}
