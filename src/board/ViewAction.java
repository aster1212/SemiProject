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

	private BoardVO paramClass = new BoardVO(); //파라미터를 저장할 객체
	private BoardVO resultClass = new BoardVO(); //쿼리 결과 값을 저장할 객체
	
	private List<CboardVO> commentlist =new ArrayList<CboardVO>();
	
	private CboardVO cClass = new CboardVO();
	private CboardVO cResult = new CboardVO();

	private int currentPage;
	
	private String SearchKeyword;
	private int SearchNum;
	private int num=0;
	private int totalCount; 		// 총 게시물의 수
	private int blockCount = 3;	// 한 페이지의  게시물의 수
	private int blockPage = 5; 	// 한 화면에 보여줄 페이지 수
	private String pagingHtml; 	//페이징을 구현한 HTML
	private CommentPagingAction page; 	// 페이징 클래스

	private int bo_no;
	private int boc_originno;
	private int boc_ref;

	private String fileUploadPath = "/WebContent/board/img";

	private InputStream inputStream;
	private String contentDisposition;
	private long contentLength;

	// 생성자
	public ViewAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}

	// 상세보기
	public String execute() throws Exception {
		paramClass = new BoardVO();
		resultClass = new BoardVO();
		// 해당 글의 조회수 +1.
		paramClass.setBo_no(getBo_no());
		sqlMapper.update("updateCnt", paramClass);

		// 해당 번호의 글을 가져온다.
		resultClass = (BoardVO) sqlMapper.queryForObject("boardselectOne", getBo_no());
		
		
		commentlist = sqlMapper.queryForList("commentSelectAll",getBo_no());
		
		totalCount = commentlist.size(); // 전체 글 갯수를 구한다.
		// pagingAction 객체 생성.
		page = new CommentPagingAction(currentPage, totalCount, blockCount, blockPage,getBo_no()); 
		pagingHtml = page.getPagingHtml().toString(); // 페이지 HTML 생성.

		// 현재 페이지에서 보여줄 마지막 글의 번호 설정.
		int lastCount = totalCount;

		// 현재 페이지의 마지막 글의 번호가 전체의 마지막 글 번호보다 작으면 
		//lastCount를 +1 번호로 설정.
		if (page.getEndCount() < totalCount)
			lastCount = page.getEndCount() + 1;

		// 전체 리스트에서 현재 페이지만큼의 리스트만 가져온다.
		commentlist = commentlist.subList(page.getStartCount(), lastCount);

		
		return SUCCESS;
	}
	

	// 첨부 파일 다운로드
	public String download() throws Exception {

		// 해당 번호의 파일 정보를 가져온다.
		resultClass = (BoardVO) sqlMapper.queryForObject("boardselectOne", getBo_no());

		// 파일 경로와 파일명을 file 객체에 넣는다.
		File fileInfo = new File(fileUploadPath + resultClass.getBo_savfile());

		// 다운로드 파일 정보 설정.
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
