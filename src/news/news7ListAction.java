package news;

import com.opensymphony.xwork2.ActionSupport;

import news.pagingAction7;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;





public class news7ListAction extends ActionSupport {
	
 public static Reader reader;
 public static SqlMapClient sqlMapper;
 
 private List<newsVO> list=new ArrayList<newsVO>();
 private int currentPage=1;
 private int totalCount;
 private int blockCount=9;
 private int blockPage=9;
 private pagingAction7 page;
 private String pageHtml;
 private int num=0;
 
 int cnt = 0;

 
 
 public news7ListAction()throws IOException{
  reader=Resources.getResourceAsReader("sqlMapConfig.xml");
  sqlMapper=SqlMapClientBuilder.buildSqlMapClient(reader);
  reader.close();
 }
 
 
 public String execute() throws Exception{
	 
	 
	// ��� ���� ������ list�� �ִ´�.
	list = sqlMapper.queryForList("selectAll-7day");
	
	
	//��ü �� ������ ���Ѵ�.
	totalCount = list.size(); 
	
	//pagingAction7 ��ü ����
	page = new pagingAction7(currentPage, totalCount, blockCount, blockPage); 
	pageHtml = page.getPageHtml().toString(); // ������ HTML ����.
	
	// ���� ���������� ������ ������ ���� ��ȣ ����.
	int lastCount = totalCount;
	  
	// ���� �������� ������ ���� ��ȣ�� ��ü�� ������ �� ��ȣ���� ������ 
	//lastCount�� +1 ��ȣ�� ����.
	if(page.getEndCount()<totalCount){
	   lastCount=page.getEndCount()+1;
	}
	
	// ��ü ����Ʈ���� ���� ��������ŭ�� ����Ʈ�� �����´�.
	list=list.subList(page.getStartCount(), lastCount);
	
	for(int i=0;i<list.size();i++) {
		newsVO tmp = (newsVO)list.get(i);
		int maxsize = 22;
		if(tmp.getNEWS_SUBJECT().length() > maxsize) {
			tmp.setNEWS_SUBJECT(tmp.getNEWS_SUBJECT().substring(0, maxsize)+"...");
		}
	}
	
	return SUCCESS;
 }
 



public pagingAction7 getPage() {
	return page;
}

public void setPage(pagingAction7 page) {
	this.page = page;
}

public List<newsVO> getList() {
	return list;
}

public void setList(List<newsVO> list) {
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

public String getPageHtml() {
	return pageHtml;
}

public void setPageHtml(String pageHtml) {
	this.pageHtml = pageHtml;
}

public static Reader getReader() {
	return reader;
}


public static SqlMapClient getSqlMapper() {
	return sqlMapper;
}


public int getNum() {
	return num;
}


public void setNum(int num) {
	this.num = num;
}




public static void setReader(Reader reader) {
	newsListAction.reader = reader;
}


public static void setSqlMapper(SqlMapClient sqlMapper) {
	newsListAction.sqlMapper = sqlMapper;
}


public int getCnt() {
	return cnt;
}


public void setCnt(int cnt) {
	this.cnt = cnt;
}



} 
