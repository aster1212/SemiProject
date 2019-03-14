package movie;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.File;
import java.io.Reader;
import java.util.Date;
import java.io.IOException;

public class commentDeleteAction extends ActionSupport {
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private moviecVO cClass = new moviecVO();
	private moviecVO cResult = new moviecVO();
	
	private int currentPage;
	
	private int MVC_NO;
	private int MV_NO;
	private String MVC_WRITER;
	private String MVC_CONTENT;
	private Date MVC_DATE;
	private int AVR;
	private int MEM_GRADE;
	private int MEM_GEN;
	
	public commentDeleteAction() throws IOException
	{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	public String execute() throws Exception {
		cClass = new moviecVO();
		cResult = new moviecVO();
		
		cClass.setMV_NO(getMV_NO());
		cClass.setMVC_NO(getMVC_NO());
		
		
		sqlMapper.delete("commentDelete", getMVC_NO());
		
		return SUCCESS;
	}

	public static Reader getReader() {
		return reader;
	}

	public static void setReader(Reader reader) {
		commentDeleteAction.reader = reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		commentDeleteAction.sqlMapper = sqlMapper;
	}

	public moviecVO getcClass() {
		return cClass;
	}

	public void setcClass(moviecVO cClass) {
		this.cClass = cClass;
	}

	public moviecVO getcResult() {
		return cResult;
	}

	public void setcResult(moviecVO cResult) {
		this.cResult = cResult;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMVC_NO() {
		return MVC_NO;
	}

	public void setMVC_NO(int mVC_NO) {
		MVC_NO = mVC_NO;
	}

	public int getMV_NO() {
		return MV_NO;
	}

	public void setMV_NO(int mV_NO) {
		MV_NO = mV_NO;
	}

	public String getMVC_WRITER() {
		return MVC_WRITER;
	}

	public void setMVC_WRITER(String mVC_WRITER) {
		MVC_WRITER = mVC_WRITER;
	}

	public String getMVC_CONTENT() {
		return MVC_CONTENT;
	}

	public void setMVC_CONTENT(String mVC_CONTENT) {
		MVC_CONTENT = mVC_CONTENT;
	}

	public Date getMVC_DATE() {
		return MVC_DATE;
	}

	public void setMVC_DATE(Date mVC_DATE) {
		MVC_DATE = mVC_DATE;
	}

	public int getAVR() {
		return AVR;
	}

	public void setAVR(int aVR) {
		AVR = aVR;
	}

	public int getMEM_GRADE() {
		return MEM_GRADE;
	}

	public void setMEM_GRADE(int mEM_GRADE) {
		MEM_GRADE = mEM_GRADE;
	}

	public int getMEM_GEN() {
		return MEM_GEN;
	}

	public void setMEM_GEN(int mEM_GEN) {
		MEM_GEN = mEM_GEN;
	}
	

}
