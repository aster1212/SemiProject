package message;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import admin.csPaging;
import message.messagePagingAction;
import message.messageVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;
import member.memberVO;

public class messageListAction extends ActionSupport {

	public static Reader reader; // ���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; // SqkMapClient API�� ����ϱ� ���� sqlMapper��ü.

	private List<messageVO> list = new ArrayList<messageVO>();

	ActionContext context;
	Map<String, String> session;

	private int currentPage = 1; // ���� ������
	private int totalCount; // �� �Խù��� ��
	private int blockCount = 15; // �� �������� �Խù��� ��
	private int blockPage = 5; // �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; // ����¡�� ������ HTML
	private csPaging page; // ����¡ Ŭ����

	private messageVO paramClass;
	private String msg_give;
	private String msg_take;

	private int num = 0;
	private String searchKeyword;
	private int searchNum;

	// ������
	public messageListAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml������ ���� ������ �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper��ü
																	// ����.

		reader.close();
	}

	// �Խ��� LIST�׼�
	public String execute() throws Exception {
		// ��� ���� ������ list�� �ִ´�.

		paramClass = new messageVO();

		context = ActionContext.getContext();
		session = (Map<String, String>) context.getSession();

		list = new ArrayList<messageVO>();

		String msg_give = session.get("session_ID");
		msg_give = session.get("mem_name");

		if (getSearchKeyword() != null) // �˻�� ������
		{
			return search(); // search()�� ����
		}
		list = sqlMapper.queryForList("Msg-select_Rec", msg_give);

		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new csPaging(currentPage, totalCount, blockCount, blockPage, "Msg_Rec_list");
		pagingHtml = page.getPagingHtml().toString();
		int lastCount = totalCount;
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}

	public String execute2() throws Exception {
		// ��� ���� ������ list�� �ִ´�.

		paramClass = new messageVO();
		list = new ArrayList<messageVO>();

		context = ActionContext.getContext();
		session = (Map<String, String>) context.getSession();

		msg_give = session.get("mem_name");

		if (getSearchKeyword() != null) // �˻�� ������
		{
			return search(); // search()�� ����
		}
		list = sqlMapper.queryForList("Msg-select_Wrt", msg_give);

		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new csPaging(currentPage, totalCount, blockCount, blockPage, "Msg_Wrt_list");
		pagingHtml = page.getPagingHtml().toString();
		int lastCount = totalCount;
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}

	public String search() throws Exception { // �� ����(execute.if()��) �˻�� ������(null�� �ƴҶ�)����� ����

		if (searchNum == 0) { // boardList.jsp�� select Name.searchNum�κп� option value�� 0�϶�
			list = sqlMapper.queryForList("Msg-selectSearchW", "%" + getSearchKeyword() + "%");
			// �ۼ���(writer)�÷��� ��ġŰ���尡 ���Ե� ��� �� ������ list�� ����
		}
		if (searchNum == 1) { // option value�� 1�϶�
			list = sqlMapper.queryForList("Msg-selectSearchC", "%" + getSearchKeyword() + "%");
			// ���� (Content)�÷��� ��ġŰ���尡 ���Ե� ��� �� ������ list�� ����
		}
		if (searchNum == 2) { // option value�� 2�϶�
			list = sqlMapper.queryForList("Msg-selectSearchD", "%" + getSearchKeyword() + "%");
			// ����(content)�÷��� ��ġŰ���尡 ���Ե� ��� �� ������ list�� ����
		}

		totalCount = list.size();
		/*page = new messagePagingAction(currentPage, totalCount, blockCount, blockPage, searchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();

		int lastCount = totalCount;

		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		list = list.subList(page.getStartCount(), lastCount);

*/		return SUCCESS;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public ActionContext getContext() {
		return context;
	}

	public void setContext(ActionContext context) {
		this.context = context;
	}

	public Map<String, String> getSession() {
		return session;
	}

	public void setSession(Map<String, String> session) {
		this.session = session;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public csPaging getPage() {
		return page;
	}

	public void setPage(csPaging page) {
		this.page = page;
	}

	public messageVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(messageVO paramClass) {
		this.paramClass = paramClass;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(int searchNum) {
		this.searchNum = searchNum;
	}

}
