package message;

import com.opensymphony.xwork2.ActionSupport;

import member.memberVO;
import message.messageVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;



public class messageWriteAction extends ActionSupport{
	public static Reader reader;	//���� ��Ʈ���� ���� reader
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper��ü
	
	private messageVO paramClass;	//�Ķ���͸� ������ ��ü
	private messageVO resultClass;	//���� ��� ���� ������ ��ü
	private memberVO paramClass2;	//�Ķ���͸� ������ ��ü
	private memberVO resultClass2;	//���� ��� ���� ������ ��ü
	private List<messageVO> list = new ArrayList<messageVO>();
	
	// 오류시
	private String errorMsg;
	
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	private int currentPage;	//���� ������
	
	private int msg_no;
	private String msg_give;
	private String msg_take;
	private String msg_content;
	private String session_id;
	
	private String memId;
	Calendar today = Calendar.getInstance();
	


	
	//������
	public messageWriteAction() throws IOException{
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");//sqlMapConfig.xml������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	//sqlMapConfig.xml�� ������ ������ sqlMapper��ü ����.
		
		reader.close();
	}
	
	public String form() throws Exception{
		//��� ��
		return SUCCESS;
	}
	
	
	//�Խ��� WRITE�׼�
	public String execute() throws Exception{
		
		//�Ķ���Ϳ� ����Ʈ ��ü ����
		paramClass=new messageVO();
		resultClass=new messageVO();
		paramClass2=new memberVO();
		resultClass2 = new memberVO();

		
		
		//����� �׸� ����
		paramClass.setMsg_give(getMsg_give());
		paramClass.setMsg_content(getMsg_content());
		paramClass.setMsg_take(getMsg_take());
		
		String taker = (String) sqlMapper.queryForObject("finTakeName", getMsg_take());
		
		if(taker == null){
			errorMsg = "닉네임을 찾을 수 없습니다.";
			return ERROR;
		}else{
		         sqlMapper.insert("WriteMessage", paramClass);
	    }
		
		//÷�������� �����ߴٸ� ������ ���ε��Ѵ�.
		return SUCCESS;
	}

	public messageVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(messageVO paramClass) {
		this.paramClass = paramClass;
	}

	public messageVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(messageVO resultClass) {
		this.resultClass = resultClass;
	}

	public memberVO getParamClass2() {
		return paramClass2;
	}

	public void setParamClass2(memberVO paramClass2) {
		this.paramClass2 = paramClass2;
	}

	public memberVO getResultClass2() {
		return resultClass2;
	}

	public void setResultClass2(memberVO resultClass2) {
		this.resultClass2 = resultClass2;
	}

	public List<messageVO> getList() {
		return list;
	}

	public void setList(List<messageVO> list) {
		this.list = list;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMsg_no() {
		return msg_no;
	}

	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}

	public String getMsg_give() {
		return msg_give;
	}

	public void setMsg_give(String msg_give) {
		this.msg_give = msg_give;
	}

	public String getMsg_take() {
		return msg_take;
	}

	public void setMsg_take(String msg_take) {
		this.msg_take = msg_take;
	}

	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}
	


	
	
	
}
