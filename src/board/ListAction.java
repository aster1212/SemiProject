package board;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {
	
	public static Reader reader;	//파일 스트림을 위한 reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API를 사용하기 위한 sqlMapper 객체.

	private List<BoardVO> list = new ArrayList<BoardVO>();
	private List<BoardVO> list_small = new ArrayList<BoardVO>();
	
	private String SearchKeyword;
	private int SearchNum;
	private int num=0;
	
	private int currentPage = 1;	//현재 페이지
	private int totalCount; 		// 총 게시물의 수
	private int blockCount = 10;	// 한 페이지의  게시물의 수
	private int blockPage = 3; 	// 한 화면에 보여줄 페이지 수
	private String pagingHtml; 	//페이징을 구현한 HTML
	private PagingAction page; 	// 페이징 클래스
	
	// 생성자
	public ListAction() throws IOException {
		 
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");// sqlMapConfig.xml 파일의 설정내용을 가져온다.
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);  // 케릭터셋 생성.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
		
		
	}

	// 게시판 LIST 액션
	public String execute() throws Exception {
		
		if(getSearchKeyword()!=null)
		{
			return search();
		}
		// 모든 글을 가져와 list에 넣는다.
		list = sqlMapper.queryForList("boardselectAll");
		list_small = sqlMapper.queryForList("smallboard");
		
			/*list_free = sqlMapper.queryForList("freeboardAll");*/

		totalCount = list.size(); // 전체 글 갯수를 구한다.
		// pagingAction 객체 생성.
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage,num,""); 
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 
		//lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		list = list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}
	public String freeSel() throws Exception
	{
		if(getSearchKeyword()!=null)
		{
			return search();
		}
		// 모든 글을 가져와 list에 넣는다.
		list = sqlMapper.queryForList("freeboardAll");
		
			/*list_free = sqlMapper.queryForList("freeboardAll");*/

		totalCount = list.size(); // 전체 글 갯수를 구한다.
		// pagingAction 객체 생성.
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage,num,""); 
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 
		//lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		list = list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}
	
	public String spoSel() throws Exception
	{
		if(getSearchKeyword()!=null)
		{
			return search();
		}
		// 모든 글을 가져와 list에 넣는다.
		list = sqlMapper.queryForList("spoboardAll");
		
			/*list_free = sqlMapper.queryForList("freeboardAll");*/

		totalCount = list.size(); // 전체 글 갯수를 구한다.
		// pagingAction 객체 생성.
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage,num,""); 
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 
		//lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		list = list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}

	public String search() throws Exception
	{
		
		if(SearchNum == 99){
			list = sqlMapper.queryForList("selectSearch99", "%"+getSearchKeyword()+"%");
		}
		if(SearchNum == 0){
			list = sqlMapper.queryForList("selectSearch0", "%"+getSearchKeyword()+"%");
		}
		if(SearchNum == 1){
			list = sqlMapper.queryForList("selectSearch1", "%"+getSearchKeyword()+"%");
		}
		if(SearchNum == 2){
			list = sqlMapper.queryForList("selectSearch2", "%"+getSearchKeyword()+"%");	
		}
		if(SearchNum == 3){
			list = sqlMapper.queryForList("selectSearch3", "%"+getSearchKeyword()+"%");	
		}
		if(SearchNum == 4){
			list = sqlMapper.queryForList("selectSearch4", "%"+getSearchKeyword()+"%");	
		}
		if(SearchNum == 5){
			list = sqlMapper.queryForList("selectSearch5", "%"+getSearchKeyword()+"%");	
		}
		if(SearchNum == 6){
			list = sqlMapper.queryForList("selectSearch6", "%"+getSearchKeyword()+"%");	
		}
		if(SearchNum == 7){
			list = sqlMapper.queryForList("selectSearch7", "%"+getSearchKeyword()+"%");	
		}
		if(SearchNum == 8){
			list = sqlMapper.queryForList("selectSearch8", "%"+getSearchKeyword()+"%");	
		}
		
		totalCount = list.size();
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage, SearchNum, getSearchKeyword());
		pagingHtml = page.getPagingHtml().toString();
		
		int lastCount = totalCount;
		
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;
		
		list = list.subList(page.getStartCount(), lastCount);
		return SUCCESS;
	}

	public List<BoardVO> getList() {
		return list;
	}

	public void setList(List<BoardVO> list) {
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

	public PagingAction getPage() {
		return page;
	}

	public void setPage(PagingAction page) {
		this.page = page;
	}

	public String getSearchKeyword() {
		return SearchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		SearchKeyword = searchKeyword;
	}

	public int getSearchNum() {
		return SearchNum;
	}

	public void setSearchNum(int searchNum) {
		SearchNum = searchNum;
	}

	public List<BoardVO> getList_small() {
		return list_small;
	}

	public void setList_small(List<BoardVO> list_small) {
		this.list_small = list_small;
	}

	
	
	
	
}


