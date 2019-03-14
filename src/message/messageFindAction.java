package message;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;

import member.memberVO;

public class messageFindAction  extends ActionSupport{

	private String memName;
	private String errorStr;
	private int check=-1;
	memberVO paramClass,resultClass;
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	// ȸ�� ã�⿡ �ʿ��� ����
	private String findType;
	private String resultStr;
	
	//�г��Ӱ˻� ��
		public String nicFindForm() throws Exception{
			return SUCCESS;
		}
	
	//�г��Ӱ˻� �׼�
	public String nicFindAction() throws Exception{
		String typeIs= getFindType();
		paramClass = new memberVO();
		resultClass = new memberVO();
		
		if(typeIs.equals("nicFind")) {// Ÿ���� ���̵��̸�
			paramClass.setMemName(getMemName());
			resultClass = (memberVO) sqlMapper.queryForObject("findMsgId",paramClass);
			if(resultClass.getMemName()!=null) {
				resultStr = resultClass.getMemName();
			}else {
				resultStr = "���̵� ã�� ���߽��ϴ�.";
			}
		}
		return SUCCESS;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getErrorStr() {
		return errorStr;
	}

	public void setErrorStr(String errorStr) {
		this.errorStr = errorStr;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public memberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(memberVO paramClass) {
		this.paramClass = paramClass;
	}

	public memberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(memberVO resultClass) {
		this.resultClass = resultClass;
	}

	public String getFindType() {
		return findType;
	}

	public void setFindType(String findType) {
		this.findType = findType;
	}

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}
	
	
}
