package message;

import com.opensymphony.xwork2.ActionSupport;

import message.messageVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;

import java.io.IOException;



public class messageViewAction<freeBoardc_VO> extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private messageVO paramClass = new messageVO();	//파라미터를 저장할 객체
	private messageVO resultClass = new messageVO();	//쿼리 결과 값을 저장할 객체



	

	private int currentPage;
	
	private int msg_no;
	


	//생성자
	public messageViewAction() throws IOException{
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");	//sqlMapConfig.xml파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);	//sqlMapConfig.xml의 내용을 적용한 sqlMapper객체 생성
		
		reader.close();
	}
	
	//상세보기
	public String execute() throws Exception{
		
		
		paramClass = new messageVO();
		//해당 글의 조회수 +1
		paramClass.setMsg_no(getMsg_no());
		System.out.println(paramClass.getMsg_no());
		//해당 번호의 글을 가져온다.
		resultClass = (messageVO)sqlMapper.queryForObject("Msg-selectOne", getMsg_no());

		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		messageViewAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		messageViewAction.sqlMapper = sqlMapper;
	}

	public messageVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(messageVO paramClass) {
		this.paramClass = paramClass;
	}

	public messageVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(messageVO resultClass) {
		this.resultClass = resultClass;
	}



	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMsg_no() {
		return msg_no;
	}

	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}

	

}
