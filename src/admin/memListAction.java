package admin;

import java.io.Reader;
import java.sql.SQLException;
import java.io.IOException;
import java.util.*;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.memberVO;

public class memListAction extends ActionSupport{
	public static Reader reader; // for File Stream reader
	public static SqlMapClient sqlMapper;
	// 페이징
	private int currentPage=1;
	private int totalCount;
	private int blockCount=20;
	private int blockPage=5;
	private String pagingHtml;
	private csPaging page;
	private String ActionName="memList";

	// 회원 하나
	private int memNo;
	
	private List<memberVO> list = new ArrayList<memberVO>();
	
	public memListAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	// 회원 리스트 액션
	public String execute() throws Exception{
		list = sqlMapper.queryForList("memSelectAll");
		//페이징
		totalCount = list.size();
		page = new csPaging(currentPage, totalCount, blockCount, blockPage, ActionName);
		pagingHtml = page.getPagingHtml().toString();
		int lastCount = totalCount;
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}
	
	// 회원 삭제 액션
	public String adminMemDel() throws Exception{
		sqlMapper.delete("adminMemDel",getMemNo());
		return SUCCESS;
	}

	public List<memberVO> getList() {
		return list;
	}

	public void setList(List<memberVO> list) {
		this.list = list;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
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

	public String getActionName() {
		return ActionName;
	}

	public void setActionName(String actionName) {
		ActionName = actionName;
	}
	
	
	
	
	
	
	
	
}
