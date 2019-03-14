package board;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.AllFilePath;

public class WriteAction extends ActionSupport{
	
	public static Reader reader; //���� ��Ʈ���� ���� reader.
	public static SqlMapClient sqlMapper; //SqlMapClient API�� ����ϱ� ���� sqlMapper ��ü.

	private BoardVO paramClass; //�Ķ���͸� ������ ��ü
	private BoardVO resultClass; //���� ��� ���� ������ ��ü

	private int currentPage; //���� ������

	private int bo_no;
	private String bo_genre;
	private String category;
	private String bo_subject;
	private String bo_writer;
	private String bo_content;
	private String bo_orgfile; //���ε� ������ ���� �̸�
	private String bo_savfile; //������ ������ ���ε� ������ �̸�. ���� ��ȣ�� �����Ѵ�.
	Calendar today = Calendar.getInstance(); //���� ��¥ ���ϱ�.

	private File upload; //���� ��ü
	private String uploadContentType; //������ Ÿ��
	private String uploadFileName; //���� �̸�
	private String fileUploadPath = AllFilePath.forboard;

	// ������
	public WriteAction() throws IOException {

		reader = Resources.getResourceAsReader("sqlMapConfig.xml"); // sqlMapConfig.xml ������ ���������� �����´�.
		Charset charset = Charset.forName("UTF-8");
		Resources.setCharset(charset);
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader); // sqlMapConfig.xml�� ������ ������ sqlMapper ��ü ����.
		reader.close();
	}

	public String form() throws Exception {
		//��� ��.
		if(resultClass!=null) {
			collector(resultClass.getBo_genre());
			cate(resultClass.getCategory());
		}
		return SUCCESS;
	}
	private String g1;
	private String g2;
	private String g3;
	private String g4;
	private String g5;
	private String g6;
	private String c1;
	private String c2;
	private String c3;
	
	public void cate(String str) {
		switch (str) {
		case "x":
			c1 = "selected='selected'";
			break;
		case "자유":
			c2 = "selected='selected'";
			break;
		case "스포":
			c3 = "selected='selected'";
			break;
		}
	}
		
	public void collector(String str) {
		switch (str) {
		case "액션":
			g1 = "selected='selected'";
			break;
		case "드라마/멜로":
			g2 = "selected='selected'";
			break;
		case "코미디":
			g3 = "selected='selected'";
			break;
		case "아동/가족":
			g4 = "selected='selected'";
			break;
		case "공포/범죄/스릴러":
			g5 = "selected='selected'";
			break;
		case "SF판타지":
			g6 = "selected='selected'";
			break;
		}
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	public String getC3() {
		return c3;
	}

	public void setC3(String c3) {
		this.c3 = c3;
	}

	public String getG1() {
		return g1;
	}

	public void setG1(String g1) {
		this.g1 = g1;
	}

	public String getG2() {
		return g2;
	}

	public void setG2(String g2) {
		this.g2 = g2;
	}

	public String getG3() {
		return g3;
	}

	public void setG3(String g3) {
		this.g3 = g3;
	}

	public String getG4() {
		return g4;
	}

	public void setG4(String g4) {
		this.g4 = g4;
	}

	public String getG5() {
		return g5;
	}

	public void setG5(String g5) {
		this.g5 = g5;
	}

	public String getG6() {
		return g6;
	}

	public void setG6(String g6) {
		this.g6 = g6;
	}

	// �Խ��� WRITE �׼�
	public String execute() throws Exception {

		//�Ķ���Ϳ� ����Ʈ ��ü ����.
		paramClass = new BoardVO();
		resultClass = new BoardVO();

		// ����� �׸� ����.
		paramClass.setCategory(getCategory());
		paramClass.setBo_genre(getBo_genre());
		paramClass.setBo_writer(getBo_writer());
		paramClass.setBo_subject(getBo_subject());
		paramClass.setBo_content(getBo_content());
		paramClass.setBo_date(today.getTime());
		
		resultClass.setBo_subject(getBo_subject());

		// ��� ���� ����.
		sqlMapper.insert("insertBoard", paramClass);

		// ÷�������� �����ߴٸ� ������ ���ε��Ѵ�.
		if (getUpload() != null) {
			

			//����� �� ��ȣ ��������.
			resultClass = (BoardVO) sqlMapper.queryForObject("boardselectLastNo");

			//���� ������ ����� ���� �̸��� Ȯ���� ����.
			String file_name = "board_" + resultClass.getBo_no();
			String file_ext = getUploadFileName().substring(
					getUploadFileName().lastIndexOf('.') + 1,
					getUploadFileName().length());
			
			System.out.println(getUploadFileName());

			//������ ���� ����.
			File destFile = new File(fileUploadPath + file_name + "."
					+ file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			
			System.out.println(destFile);

			//���� ���� �Ķ���� ����.
			paramClass.setBo_no(resultClass.getBo_no());
			paramClass.setBo_orgfile(getUploadFileName());//���� ���� �̸�
			paramClass.setBo_savfile(file_name + "." + file_ext);//������ ������ ���� �̸�

			//���� ���� ������Ʈ.
			sqlMapper.update("updateFile", paramClass);
		}

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

	public String getBo_orgfile() {
		return bo_orgfile;
	}

	public void setBo_orgfile(String bo_orgfile) {
		this.bo_orgfile = bo_orgfile;
	}

	public String getBo_savfile() {
		return bo_savfile;
	}

	public void setBo_savfile(String bo_savfile) {
		this.bo_savfile = bo_savfile;
	}

	public Calendar getToday() {
		return today;
	}

	public void setToday(Calendar today) {
		this.today = today;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
