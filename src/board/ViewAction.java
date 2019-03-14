package board;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;


public class ViewAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private BoardVO paramClass = new BoardVO(); //�Ķ���͸� ������ ��ü
	private BoardVO resultClass = new BoardVO(); //���� ��� ���� ������ ��ü
	
	private List<CboardVO> commentlist =new ArrayList<CboardVO>();
	
	private CboardVO cClass = new CboardVO();
	private CboardVO cResult = new CboardVO();

	private int currentPage;
	
	private String SearchKeyword;
	private int SearchNum;
	private int num=0;
	private int totalCount; 		// �� �Խù��� ��
	private int blockCount = 3;	// �� ��������  �Խù��� ��
	private int blockPage = 5; 	// �� ȭ�鿡 ������ ������ ��
	private String pagingHtml; 	//����¡�� ������ HTML
	private CommentPagingAction page; 	// ����¡ Ŭ����

	private int bo_no;
	private int boc_originno;
	private int boc_ref;

	private String fileUploadPath = "/WebContent/board/img";

	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;

	// ������
	public ViewAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}

	// �󼼺���
	public String execute() throws Exception {
		paramClass = new BoardVO();
		resultClass = new BoardVO();
		// �ش� ���� ��ȸ�� +1.
		paramClass.setBo_no(getBo_no());
		sqlMapper.update("updateCnt", paramClass);

		// �ش� ��ȣ�� ���� �����´�.
		resultClass = (BoardVO) sqlMapper.queryForObject("boardselectOne", getBo_no());
		
		
		commentlist = sqlMapper.queryForList("commentSelectAll",getBo_no());
		
		totalCount = commentlist.size(); // ��ü �� ������ ���Ѵ�.
		// pagingAction ��ü ����.
		page = new CommentPagingAction(currentPage, totalCount, blockCount, blockPage,getBo_no()); 
		pagingHtml = page.getPagingHtml().toString(); // ������ HTML ����.

		// ���� ���������� ������ ������ ���� ��ȣ ����.
		int lastCount = totalCount;

		// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
		//lastCount�� +1 ��ȣ�� ����.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
		commentlist = commentlist.subList(page.getStartCount(), lastCount);

		
		return SUCCESS;
	}
	

	// ÷�� ���� �ٿ�ε�
	public String download() throws Exception {

		// �ش� ��ȣ�� ���� ������ �����´�.
		resultClass = (BoardVO) sqlMapper.queryForObject("boardselectOne", getBo_no());

		// ���� ��ο� ���ϸ��� file ��ü�� �ִ´�.
		File fileInfo = new File(fileUploadPath + resultClass.getBo_savfile());

		// �ٿ�ε� ���� ���� ����.
		setContentLength(fileInfo.length());
		setContentDisposition("attachment;filename="
				+ URLEncoder.encode(resultClass.getBo_orgfile(), "UTF-8"));
		setInputStream(new FileInputStream(fileUploadPath
				+ resultClass.getBo_savfile()));

		return SUCCESS;
	}

	public BoardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(BoardVO paramClass) {
		this.paramClass = paramClass;
	}

	public BoardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(BoardVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBo_no() {
		return bo_no;
	}

	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public int getBoc_originno() {
		return boc_originno;
	}

	public void setBoc_originno(int boc_originno) {
		this.boc_originno = boc_originno;
	}

	public List<CboardVO> getCommentlist() {
		return commentlist;
	}

	public void setCommentlist(List<CboardVO> commentlist) {
		this.commentlist = commentlist;
	}

	public CboardVO getcClass() {
		return cClass;
	}

	public void setcClass(CboardVO cClass) {
		this.cClass = cClass;
	}

	public CboardVO getcResult() {
		return cResult;
	}

	public void setcResult(CboardVO cResult) {
		this.cResult = cResult;
	}

	public int getBoc_ref() {
		return boc_ref;
	}

	public void setBoc_ref(int boc_ref) {
		this.boc_ref = boc_ref;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public CommentPagingAction getPage() {
		return page;
	}

	public void setPage(CommentPagingAction page) {
		this.page = page;
	}

	

	

}
