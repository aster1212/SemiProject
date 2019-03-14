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
	
	public static Reader reader;	//���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper;	//SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private List<BoardVO> list = new ArrayList<BoardVO>();
	private List<BoardVO> list_small = new ArrayList<BoardVO>();
	
	private String SearchKeyword;
	private int SearchNum;
	private int num=0;
	
	private int currentPage = 1;	//���� ������
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 10;	// �� ��������  �Խù��� ��
	private int blockPage = 3; 	// �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; 	//����¡�� ������ HTML
	private PagingAction page; 	// ����¡ Ŭ����
	
	// ������
	public ListAction() throws IOException {
		 
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");// sqlMapConfig.xml ������ ���������� �����´�.
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);  // �ɸ��ͼ� ����.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	// sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
		
		
	}

	// �Խ��� LIST �׼�
	public String execute() throws Exception {
		
		if(getSearchKeyword()!=null)
		{
			return search();
		}
		// ��� ���� ������ list�� �ִ´�.
		list = sqlMapper.queryForList("boardselectAll");
		list_small = sqlMapper.queryForList("smallboard");
		
			/*list_free = sqlMapper.queryForList("freeboardAll");*/

		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage,num,""); 
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
		//lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}
	public String freeSel() throws Exception
	{
		if(getSearchKeyword()!=null)
		{
			return search();
		}
		// ��� ���� ������ list�� �ִ´�.
		list = sqlMapper.queryForList("freeboardAll");
		
			/*list_free = sqlMapper.queryForList("freeboardAll");*/

		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage,num,""); 
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
		//lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		list = list.subList(page.getStartCount(), lastCount);

		return SUCCESS;
	}
	
	public String spoSel() throws Exception
	{
		if(getSearchKeyword()!=null)
		{
			return search();
		}
		// ��� ���� ������ list�� �ִ´�.
		list = sqlMapper.queryForList("spoboardAll");
		
			/*list_free = sqlMapper.queryForList("freeboardAll");*/

		totalCount = list.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new PagingAction(currentPage, totalCount, blockCount, blockPage,num,""); 
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
		//lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
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


