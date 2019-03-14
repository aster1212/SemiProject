package board;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.AllFilePath;

public class DeleteAction extends ActionSupport {
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private BoardVO paramClass; //�Ķ���͸� ������ ��ü
	private BoardVO resultClass; //���� ��� ���� ������ ��ü
	
	private CboardVO cClass = new CboardVO();
	private CboardVO cResult = new CboardVO();

	private int currentPage;	//���� ������
	
	private String fileUploadPath = AllFilePath.forboard;
	
	private int bo_no;
	private int boc_no;
	
	
	// ������
	public DeleteAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}

	// �Խñ� �� ����
	public String execute() throws Exception {
		
		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new BoardVO();
		resultClass = new BoardVO();
		
		// �ش� ��ȣ�� ���� �����´�.
		resultClass = (BoardVO) sqlMapper.queryForObject("boardselectOne", getBo_no());

		//���� ���� ����
		File deleteFile = new File(fileUploadPath + resultClass.getBo_savfile());
		deleteFile.delete();

		// ������ �׸� ����.
		paramClass.setBo_no(getBo_no());;
				
		// ���� ���� ����.
		sqlMapper.update("deleteBoard", paramClass);

		return SUCCESS;
	}
	
	public String execute2() throws Exception {
		cClass = new CboardVO();
		cResult = new CboardVO();
		
		System.out.println(cClass.getBoc_no());
		cClass.setBoc_no(getBoc_no());
		
		sqlMapper.delete("deleteComment",cClass);
		
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

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public int getBo_no() {
		return bo_no;
	}

	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
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

	public int getBoc_no() {
		return boc_no;
	}

	public void setBoc_no(int boc_no) {
		this.boc_no = boc_no;
	}

	
	
	

}
