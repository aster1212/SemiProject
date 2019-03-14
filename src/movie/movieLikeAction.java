package movie;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;
import member.memberVO;



public class movieLikeAction extends ActionSupport implements SessionAware {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private likesVO paramClass = new likesVO();
	private likesVO resultClass = new likesVO();
	private memberVO memberClass = new memberVO();
	
	
	//mv_no를 전달받음
	private int MV_NO;
	private int MEM_NO;
	private int LIKES_NO;
	private int mem_like;
	private Map session;


	public movieLikeAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	
	
	public String execute() throws Exception {
		
/*		if (session.get("session_member_id")==null){
			return LOGIN;
		}*/

		
		//InsertLikes
		paramClass.setMV_NO(MV_NO);
		paramClass.setMEM_NO(MEM_NO);
		sqlMapper.insert("InsertLikes", paramClass);
		
		
		
		return SUCCESS;
	}
	

	
	



	public likesVO getParamClass() {
		return paramClass;
	}



	public void setParamClass(likesVO paramClass) {
		this.paramClass = paramClass;
	}



	public likesVO getResultClass() {
		return resultClass;
	}



	public void setResultClass(likesVO resultClass) {
		this.resultClass = resultClass;
	}



	public int getMV_NO() {
		return MV_NO;
	}



	public void setMV_NO(int mV_NO) {
		MV_NO = mV_NO;
	}



	public int getMEM_NO() {
		return MEM_NO;
	}



	public void setMEM_NO(int mEM_NO) {
		MEM_NO = mEM_NO;
	}



	public int getLIKES_NO() {
		return LIKES_NO;
	}



	public void setLIKES_NO(int lIKES_NO) {
		LIKES_NO = lIKES_NO;
	}



	public memberVO getMemberClass() {
		return memberClass;
	}



	public void setMemberClass(memberVO memberClass) {
		this.memberClass = memberClass;
	}



	public int getMem_like() {
		return mem_like;
	}



	public void setMem_like(int mem_like) {
		this.mem_like = mem_like;
	}



	@Override
	public void setSession(Map arg0) {
		// TODO Auto-generated method stub
		
	}



	public static Reader getReader() {
		return reader;
	}



	public static void setReader(Reader reader) {
		movieLikeAction.reader = reader;
	}



	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}



	public static void setSqlMapper(SqlMapClient sqlMapper) {
		movieLikeAction.sqlMapper = sqlMapper;
	}



	public Map getSession() {
		return session;
	}
	
	
	
	


	//getter setter

	
}
