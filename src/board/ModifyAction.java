package board;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.AllFilePath;

public class ModifyAction extends ActionSupport{
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private BoardVO paramClass; //�Ķ���͸� ������ ��ü
	private BoardVO resultClass; //���� ��� ���� ������ ��ü

	private int currentPage;	//���� ������
	
	private int bo_no;
	private String bo_genre;
	private String bo_subject;
	private String bo_writer;
	private String bo_content;
	private String old_file;

	private File upload; //���� ��ü
	private String uploadContentType; //������ Ÿ��
	private String uploadFileName; //���� �̸�
	private String fileUploadPath = AllFilePath.forboard;

	// ������
	public ModifyAction() throws IOException {
		
		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}

	// �Խñ� ����
	public String execute() throws Exception {
		
		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new BoardVO();
		resultClass = new BoardVO();

		// ������ �׸� ����.
		paramClass.setBo_no(getBo_no());;
		paramClass.setBo_genre(getBo_genre());
		paramClass.setBo_subject(getBo_subject());
		paramClass.setBo_writer(getBo_writer());
		paramClass.setBo_content(getBo_content());

		// �ϴ� �׸� �����Ѵ�.
		sqlMapper.update("updateBoard", paramClass);

		// ������ ������ ���ε� �Ǿ��ٸ� ������ ���ε��ϰ� DB�� file �׸��� ������.
		if (getUpload() != null) {
			
			//���� ������ ����� ���� �̸��� Ȯ���� ����.
			String file_name = "file_" + getBo_no();
		           String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,getUploadFileName().length());
			
			//���� ���� ����
			File deleteFile = new File(fileUploadPath + getOld_file());
			deleteFile.delete();
			
			//�� ���� ���ε�
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			//���� ���� �Ķ���� ����.
			paramClass.setBo_orgfile(getUploadFileName());
			paramClass.setBo_savfile(file_name + "." + file_ext);
			
			//���� ���� ������Ʈ.
			sqlMapper.update("updateFile", paramClass);
		}

		// ������ ������ view �������� �̵�.
		resultClass = (BoardVO) sqlMapper.queryForObject("boardselectOne", getBo_no());

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

	public int getBo_no() {
		return bo_no;
	}

	public void setBo_no(int bo_no) {
		this.bo_no = bo_no;
	}

	public String getBo_genre() {
		return bo_genre;
	}

	public void setBo_genre(String bo_genre) {
		this.bo_genre = bo_genre;
	}

	public String getBo_subject() {
		return bo_subject;
	}

	public void setBo_subject(String bo_subject) {
		this.bo_subject = bo_subject;
	}

	public String getBo_writer() {
		return bo_writer;
	}

	public void setBo_writer(String bo_writer) {
		this.bo_writer = bo_writer;
	}

	public String getBo_content() {
		return bo_content;
	}

	public void setBo_content(String bo_content) {
		this.bo_content = bo_content;
	}

	public String getOld_file() {
		return old_file;
	}

	public void setOld_file(String old_file) {
		this.old_file = old_file;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}
	
	

}
