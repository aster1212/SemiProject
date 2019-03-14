package admin;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import board.BoardVO;
import board.CboardVO;
import member.memberVO;
import movie.movieVO;
import movie.moviecVO;

public class reportTraceAction extends ActionSupport {
	public static Reader reader; // for File Stream reader
	public static SqlMapClient sqlMapper;

	// 추적용
	private int rep_ed_no;
	private int rep_ed_type;
	String tableName;
	String colName;
	private adminTraceVO paramClass;
	private adminTraceVO resultClass;
	private adminTraceVO resultParent;
	private adminTraceVO paramParent;
	private memberVO memVO;
	private BoardVO bdVO;
	private CboardVO cbdVO;
	private moviecVO cmvVO;
	private movieVO mvVO;

	public reportTraceAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	@Override
	public String execute() throws Exception {
		// 신고된 글 추적하기
		paramClass = new adminTraceVO();
		resultClass = new adminTraceVO();
		tableName = tableTyper(getRep_ed_type());
		colName = tableTyper(tableName);

		paramClass.setTableName(tableName);
		paramClass.setColName(colName);
		paramClass.setRep_ed_no(getRep_ed_no());

		resultClass = (adminTraceVO) sqlMapper.queryForObject("adminTcSQL", paramClass);
		
		boolean found = resultClass == null;
		System.out.println("resultClass is empty : "+found);
		
		if (!found) {
			resultClass.setTableName(tableName);
			resultClass.setColName(colName);

			if (resultClass.getTableName().equals("BOARDC") || resultClass.getTableName().equals("MOVIEC")) {// 신고된 글이 댓글이면
				paramParent = new adminTraceVO();
				resultParent = new adminTraceVO();
				
				if (resultClass.getTableName().equals("BOARDC")) {// 댓글이고 테이블이 게시판이면
					paramParent.setTableName("BOARD");
					paramParent.setColName("BO_NO");
					paramParent.setRep_ed_no(resultClass.getBoc_originno());
				} 
				else if(resultClass.getTableName().equals("MOVIEC")){ // '' 영화이면
					paramParent.setTableName("MOVIE");
					paramParent.setColName("MV_NO");
					paramParent.setRep_ed_no(resultClass.getMV_NO());
				}
				resultParent = (adminTraceVO) sqlMapper.queryForObject("adminTcSQL", paramParent);
				
				if(resultParent != null) {
					resultParent.setTableName(paramParent.getTableName());
					resultParent.setColName(paramParent.getColName());
				}
			}
		}
		return SUCCESS;
	}

	public static String tableTyper(int type) {
		String tableName;
		switch (type) {
		case 1:
			tableName = "BOARD";
			break;
		case 2:
			tableName = "BOARDC";
			break;
		case 3:
			tableName = "MOVIE";
			break;
		case 4:
			tableName = "MOVIEC";
			break;
		default:
			tableName = "*";
			break;
		}
		return tableName;
	}

	public static String tableTyper(String tableName) {
		String colName;
		switch (tableName) {
		case "BOARD":
			colName = "BO_NO";
			break;
		case "BOARDC":
			colName = "BOC_NO";
			break;
		case "MOVIE":
			colName = "MV_NO";
			break;
		case "MOVIEC":
			colName = "MVC_NO";
			break;
		default:
			colName = "*";
			break;
		}
		return colName;
	}

	public void setRep_ed_no(int rep_ed_no) {
		this.rep_ed_no = rep_ed_no;
	}

	public int getRep_ed_type() {
		return rep_ed_type;
	}

	public void setRep_ed_type(int rep_ed_type) {
		this.rep_ed_type = rep_ed_type;
	}

	public memberVO getMemVO() {
		return memVO;
	}

	public void setMemVO(memberVO memVO) {
		this.memVO = memVO;
	}

	public BoardVO getBdVO() {
		return bdVO;
	}

	public adminTraceVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(adminTraceVO paramClass) {
		this.paramClass = paramClass;
	}

	public adminTraceVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(adminTraceVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getRep_ed_no() {
		return rep_ed_no;
	}

	public void setBdVO(BoardVO bdVO) {
		this.bdVO = bdVO;
	}

	public CboardVO getCbdVO() {
		return cbdVO;
	}

	public void setCbdVO(CboardVO cbdVO) {
		this.cbdVO = cbdVO;
	}

	public moviecVO getCmvVO() {
		return cmvVO;
	}

	public void setCmvVO(moviecVO cmvVO) {
		this.cmvVO = cmvVO;
	}

	public movieVO getMvVO() {
		return mvVO;
	}

	public void setMvVO(movieVO mvVO) {
		this.mvVO = mvVO;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public adminTraceVO getResultParent() {
		return resultParent;
	}

	public void setResultParent(adminTraceVO resultParent) {
		this.resultParent = resultParent;
	}

	public adminTraceVO getParamParent() {
		return paramParent;
	}

	public void setParamParent(adminTraceVO paramParent) {
		this.paramParent = paramParent;
	}

}
