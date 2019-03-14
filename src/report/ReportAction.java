package report;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Calendar;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import board.BoardVO;
import board.CboardVO;
import movie.movieVO;
import movie.moviecVO;

public class ReportAction extends ActionSupport{
	
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private ReportVO reportParam; //�Ķ���͸� ������ ��ü
	private ReportVO reportResult; //���� ��� ���� ������ ��ü
	
	private BoardVO boardResult;
	private CboardVO CboardResult; 
	private movieVO movieResult;
	private moviecVO CmovieResult;
	private int currentPage; //���� ������
	private int MVC_NO;
	private int MV_NO;
	private int bo_no;
	private int type;
	private int boc_no;
	private int typenumber;
	private String TableName;
	
	private int rep_no;
	private int rep_ed_no;
	private String rep_writer;
	private int rep_ed_type;
	private String rep_content;
	private String rep_ed_content;
	Calendar today = Calendar.getInstance(); //���� ��¥ ���ϱ�.

	// ������
	public ReportAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}

	public String form() throws Exception {
		//��� ��.
		 switch (type) {
	      case 1:
	    	  boardResult = new BoardVO();
	    	  boardResult = (BoardVO)sqlMapper.queryForObject("boardselectOne",getBo_no());
	    	  TableName = boardResult.getBo_subject();
	    	  typenumber =type;
	         break;
	      case 2:
	    	  CboardResult = new CboardVO();
	    	  CboardResult = (CboardVO)sqlMapper.queryForObject("commentSelectOne",getBoc_no());
	    	  TableName = CboardResult.getBoc_content();
	    	  typenumber = type;
	         break;
	      case 3:
	    	  movieResult = new movieVO();
	    	  movieResult = (movieVO)sqlMapper.queryForObject("selectAll",getMV_NO());
	    	  TableName = movieResult.getMV_SUBJECT();
	    	  typenumber = type;
	         break;
	      case 4:
	    	  CmovieResult = new moviecVO();
	    	  CmovieResult = (moviecVO)sqlMapper.queryForObject("mcommentSelectOne",getMVC_NO());
	    	  TableName = CmovieResult.getMVC_CONTENT();
	    	  typenumber = type;
	         break;
	      case 5:
	            typenumber = type;
	            break;
	      default:
	         break;
	      }
		
		return SUCCESS;
	}

	public String execute() throws Exception {

		reportParam = new ReportVO();
		reportResult = new ReportVO();
		
		reportParam.setRep_no(getRep_no());
		reportParam.setRep_ed_content(getRep_ed_content());
		reportParam.setRep_writer(getRep_writer());
		reportParam.setRep_content(getRep_content());
		reportParam.setRep_date(today.getTime());
		reportParam.setRep_ed_type(getRep_ed_type());
		reportParam.setRep_ed_no(getRep_ed_no());
		
		sqlMapper.insert("insertReport", reportParam);

		return SUCCESS;
	}

	public ReportVO getReportParam() {
		return reportParam;
	}

	public void setReportParam(ReportVO reportParam) {
		this.reportParam = reportParam;
	}

	public ReportVO getReportResult() {
		return reportResult;
	}

	public void setReportResult(ReportVO reportResult) {
		this.reportResult = reportResult;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRep_no() {
		return rep_no;
	}

	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}

	public String getRep_writer() {
		return rep_writer;
	}

	public void setRep_writer(String rep_writer) {
		this.rep_writer = rep_writer;
	}

	public String getRep_content() {
		return rep_content;
	}

	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
	}

	public BoardVO getBoardResult() {
		return boardResult;
	}

	public void setBoardResult(BoardVO boardResult) {
		this.boardResult = boardResult;
	}

	public int getBo_no() {
		return bo_no;
	}

	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
	}

	public CboardVO getCboardResult() {
		return CboardResult;
	}

	public void setCboardResult(CboardVO cboardResult) {
		CboardResult = cboardResult;
	}
	
	public int getBoc_no() {
		return boc_no;
	}

	public void setBoc_no(int boc_no) {
		this.boc_no = boc_no;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTableName() {
		return TableName;
	}

	public void setTableName(String tableName) {
		TableName = tableName;
	}

	public int getRep_ed_type() {
		return rep_ed_type;
	}

	public void setRep_ed_type(int rep_ed_type) {
		this.rep_ed_type = rep_ed_type;
	}

	public String getRep_ed_content() {
		return rep_ed_content;
	}

	public void setRep_ed_content(String rep_ed_content) {
		this.rep_ed_content = rep_ed_content;
	}

	public int getTypenumber() {
		return typenumber;
	}

	public void setTypenumber(int typenumber) {
		this.typenumber = typenumber;
	}

	public int getRep_ed_no() {
		return rep_ed_no;
	}

	public void setRep_ed_no(int rep_ed_no) {
		this.rep_ed_no = rep_ed_no;
	}

	public movieVO getMovieResult() {
		return movieResult;
	}

	public void setMovieResult(movieVO movieResult) {
		this.movieResult = movieResult;
	}

	public int getMV_NO() {
		return MV_NO;
	}

	public void setMV_NO(int mV_NO) {
		MV_NO = mV_NO;
	}

	public moviecVO getCmovieResult() {
		return CmovieResult;
	}

	public void setCmovieResult(moviecVO cmovieResult) {
		CmovieResult = cmovieResult;
	}

	public int getMVC_NO() {
		return MVC_NO;
	}

	public void setMVC_NO(int mVC_NO) {
		MVC_NO = mVC_NO;
	}
	


	

}
