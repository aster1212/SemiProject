package movie;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;



public class movieDeleteLikeAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private likesVO paramClass = new likesVO();
	private likesVO resultClass = new likesVO();
	
	
	//mv_no를 전달받음
	int MV_NO;
	int MEM_NO;
	int LIKES_NO;


	public movieDeleteLikeAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml 파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	
	
	public String delete() throws Exception {
		
		
		//DeleteLikes
		paramClass.setMV_NO(getMV_NO());
		paramClass.setMEM_NO(getMEM_NO());
		paramClass.setLIKES_NO(getLIKES_NO());
		
		sqlMapper.delete("DeleteLikes", paramClass);
		
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
	


	
}
