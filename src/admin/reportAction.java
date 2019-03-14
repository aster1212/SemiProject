package admin;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.memberVO;

public class reportAction extends ActionSupport{
	public static Reader reader; // for File Stream reader
	public static SqlMapClient sqlMapper;
	
	// 신고리스트
	private List<adminRPVO> list = new ArrayList<adminRPVO>();
	private int viewType;
	private String TypeName;
	private int rep_no;
	
	public reportAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	// report delete
	public String repDel() throws Exception{
		sqlMapper.delete("reportDelete",rep_no);
		return SUCCESS;
	}
	
	// list view
	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		if(getViewType()==0) {
			list = sqlMapper.queryForList("adminRpListAll");
		}else {
			list = sqlMapper.queryForList("adminRpListType",getViewType());
		}
		TypeName = typer(getViewType());
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
	
	// update rep_status
	public String updateStatus() throws Exception{
		System.out.println("action in");
		try {
			sqlMapper.update("adminRpStatusUpdate", getRep_no());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("action out");
		return SUCCESS;
	}
	
	public static String typer(int type) {
		String rstr;
		switch (type) {
		case 1:
			rstr = "게시판";
			break;
		case 2:
			rstr = "게시판 댓글";
			break;
		case 3:
			rstr = "영화";
			break;
		case 4:
			rstr = "영화 댓글";
			break;
		case 5:
			rstr = "건의사항";
			break;
		case 6:
			rstr = "버그리포트";
			break;
		case 7:
			rstr = "이용 관련";
			break;

		default:
			rstr = "전체";
			break;
		}
		return rstr;
	}
	
	
	public List<adminRPVO> getList() {
		return list;
	}

	public void setList(List<adminRPVO> list) {
		this.list = list;
	}

	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String TypeName) {
		this.TypeName = TypeName;
	}

	public int getRep_no() {
		return rep_no;
	}

	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}

	// 페이징
		private int currentPage=1;
		private int totalCount;
		private int blockCount=20;
		private int blockPage=5;
		private String pagingHtml;
		private csPaging page;
		private String ActionName="adminRpList";

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
