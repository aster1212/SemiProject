package cmt;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class cmtAction extends ActionSupport{
	public static Reader reader; // for File Stream reader
	public static SqlMapClient sqlMapper;
	
	cmtVO paramClass;
	cmtVO resultClass;
	
	cmtVO cmtParam;
	cmtVO cmtResult;
	List<cmtVO> list = new ArrayList<cmtVO>();
	
	// 상세보기
	String bwriter;
	String bcontent;

	// 생성자
	public cmtAction() throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	// 댓글 쓰기
	public String cmtWrite() throws Exception{
		cmtParam = new cmtVO();
		cmtParam.setOriginno(getBoardno());
		cmtParam.setWriter(getWriter());
		cmtParam.setContent(getContent());
		
		if(getRef()==0) {//본 댓글이면
			sqlMapper.insert("insertCmt1",cmtParam);
		}else {//대댓글이면
			cmtParam.setRef(getRef());
			cmtParam.setRe_level(getRe_level()+1);
			cmtParam.setRe_step(getRe_step());
			sqlMapper.update("refUpdate",cmtParam);
			sqlMapper.insert("insertCmt2",cmtParam);
		}
		
		return SUCCESS;
	}
	
	public String cmtList() throws Exception{
		list = sqlMapper.queryForList("cmtAll");
		return SUCCESS;
	}

	@Override//상세보기 + 리스트 액션
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		resultClass = new cmtVO();
		bwriter = "상세보기 쓴이";
		bcontent = "상세보기 컨텐츠";
		resultClass.setBoardno(getBoardno());
		
		list = sqlMapper.queryForList("cmtAll");
		return SUCCESS;
	}
	
	
	private int 
	boardno, //보드 시퀀스 넘버
	no, //댓글 시퀀스 넘버
	originno, // 보드시퀀스 넘버를 가져온 넘버
	ref, //원글이면 내 댓글 시퀀스넘버 답글이면 원글 시퀀스 넘버
	re_level, // 원글에서 얼마나 떨어져있는지의 정도
	re_step; // 리스트에서 몇번째로 보여질지 나타내는 정도 순서
	private String
	writer, //쓴이
	content; //내용
	private Date regdate; //쓴 날자
	
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOriginno() {
		return originno;
	}
	public void setOriginno(int originno) {
		this.originno = originno;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public cmtVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(cmtVO paramClass) {
		this.paramClass = paramClass;
	}

	public cmtVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(cmtVO resultClass) {
		this.resultClass = resultClass;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public cmtVO getCmtParam() {
		return cmtParam;
	}

	public void setCmtParam(cmtVO cmtParam) {
		this.cmtParam = cmtParam;
	}

	public cmtVO getCmtResult() {
		return cmtResult;
	}

	public void setCmtResult(cmtVO cmtResult) {
		this.cmtResult = cmtResult;
	}

	public List<cmtVO> getList() {
		return list;
	}

	public void setList(List<cmtVO> list) {
		this.list = list;
	}
	
}
