package board;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class CommentWriteAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private CboardVO paramClass;
	private CboardVO resultClass;
	private List<CboardVO> copylist = new ArrayList<CboardVO>();
	private int bo_no;
	

	public int getBo_no() {
		return bo_no;
	}

	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
	}

	private int boc_no;
	private int currentPage;

	private String boc_writer;
	private String boc_content;
	private int boc_originno;
	private int mem_no;
	private int boc_ref;
	private int boc_restep;
	private int boc_relevel;

	Calendar today = Calendar.getInstance();

	public CommentWriteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();

	}
	
	public String form() throws Exception
	{
		return SUCCESS;
		
	}

	public String execute() throws Exception {
		
		paramClass = new CboardVO();
		resultClass = new CboardVO();
		
		System.out.println("execute --> ������");
		
		if(boc_ref==0)
		{
			paramClass.setBoc_restep(0);
			paramClass.setBoc_relevel(0);
		}
		
		else
		{
			System.out.println("ref,restep,relevel �÷��ִ� ������ ------->>>");
			
			paramClass.setBoc_ref(getBoc_ref());
			paramClass.setBoc_restep(getBoc_restep());
			sqlMapper.update("updateReplyStep",paramClass);
			
			paramClass.setBoc_restep(getBoc_restep()+1);
			paramClass.setBoc_relevel(getBoc_relevel()+1);
			paramClass.setBoc_ref(getBoc_ref());
		}
		
		paramClass.setBoc_originno(getBoc_originno());
		paramClass.setMem_no(getMem_no());
		paramClass.setBoc_writer(getBoc_writer());
		paramClass.setBoc_content(getBoc_content());
		paramClass.setBoc_date(today.getTime());
		
		if(boc_ref==0)
		{
			System.out.println("�Ϲ� ��� ������ ���ư�~~~~");
			sqlMapper.insert("insertComment", paramClass);
		
		}
		else
		{
			System.out.println("���� ������ ���ư�~~");
			sqlMapper.insert("insertReplyComment",paramClass);
		}
			

		return SUCCESS;
	}
	public String copyComment() throws Exception
	{
		copylist = sqlMapper.queryForList("copyAll");
		return SUCCESS;
	}

	public CboardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(CboardVO paramClass) {
		this.paramClass = paramClass;
	}

	public CboardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(CboardVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getBoc_no() {
		return boc_no;
	}

	public void setBoc_no(int boc_no) {
		this.boc_no = boc_no;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getBoc_writer() {
		return boc_writer;
	}

	public void setBoc_writer(String boc_writer) {
		this.boc_writer = boc_writer;
	}

	public String getBoc_content() {
		return boc_content;
	}

	public void setBoc_content(String boc_content) {
		this.boc_content = boc_content;
	}

	public int getBoc_originno() {
		return boc_originno;
	}

	public void setBoc_originno(int boc_originno) {
		this.boc_originno = boc_originno;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public int getBoc_ref() {
		return boc_ref;
	}

	public void setBoc_ref(int boc_ref) {
		this.boc_ref = boc_ref;
	}

	public int getBoc_restep() {
		return boc_restep;
	}

	public void setBoc_restep(int boc_restep) {
		this.boc_restep = boc_restep;
	}

	public int getBoc_relevel() {
		return boc_relevel;
	}

	public void setBoc_relevel(int boc_relevel) {
		this.boc_relevel = boc_relevel;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public List<CboardVO> getCopylist() {
		return copylist;
	}

	public void setCopylist(List<CboardVO> copylist) {
		this.copylist = copylist;
	}
	
	

}
