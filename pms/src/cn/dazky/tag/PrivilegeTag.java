package cn.dazky.tag;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import cn.dazky.util.StringUtil;
public class PrivilegeTag extends TagSupport {
	//Privilege��Ȩ
	private static final long serialVersionUID = -532517444654109642L;

	private String operationId; // ��ӦAttribute,����set������
	private String name;      // ��ť������ӣ�
	private String clazz;     // ��ʽ
	private String iconCls;   // ͼ��
	private String onClick;   // ����¼�
	
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClazz(String classes) {
		this.clazz = classes;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	/**
	 * ������ǩ���γ�ԭ�е�a��ǩ
	 * <a href="javascript:reserveRole()" class="easyui-linkbutton" iconCls="icon-ok" >����</a>
	 */
	public int doStartTag() throws JspException {
		String currentOperationIds = (String) pageContext.getSession().getAttribute("currentOperationIds");
		if (StringUtil.isNotEmpty(currentOperationIds) && StringUtil.existStrArr(operationId, currentOperationIds.split(","))) {
			StringBuffer sb = new StringBuffer();
			sb.append("<a href=\"javascript:");
			sb.append(onClick + "\"");
			sb.append("class=\""+clazz+"\"");
			sb.append("iconCls=\""+iconCls+"\"");
			sb.append("plain=\"true\" >");
			sb.append(name +"</a>");
			try {
				pageContext.getOut().write(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return EVAL_PAGE;
		}
		return SKIP_BODY; // ����body,body���ֲ�����ʾ
		/* ����Ĭ��ֵ */
	}
	
}
