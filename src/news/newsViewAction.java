package news;

//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.io.IOException;

public class newsViewAction extends ActionSupport { 

	public static Reader reader;
	public static SqlMapClient sqlMapper;
 
	private newsVO paramClass;
	private newsVO resultClass;
	

	private int currentPage=1;
	private int NEWS_NO;
	private int NO;

	// »ý¼ºÀÚ
	public newsViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	
	public String execute() throws Exception {
		resultClass = new newsVO();
		resultClass = (newsVO)sqlMapper.queryForObject("selectAll-list", getNEWS_NO());
		
/*		int maxsize = 252;
		if(resultClass.getMV_LS().length() > maxsize) {
			resultClass.setMV_LS(resultClass.getMV_LS().substring(0, maxsize)+"...");
		}*/
		return SUCCESS;
	}
	
	


	public newsVO getParamClass() {
		return paramClass;
	}


	public void setParamClass(newsVO paramClass) {
		this.paramClass = paramClass;
	}


	public newsVO getResultClass() {
		return resultClass;
	}


	public void setResultClass(newsVO resultClass) {
		this.resultClass = resultClass;
	}


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}



	public int getNEWS_NO() {
		return NEWS_NO;
	}


	public void setNEWS_NO(int nEWS_NO) {
		NEWS_NO = nEWS_NO;
	}


	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}


	public static Reader getReader() {
		return reader;
	}


	public static void setReader(Reader reader) {
		newsViewAction.reader = reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) {
		newsViewAction.sqlMapper = sqlMapper;
	}

	
	


}
