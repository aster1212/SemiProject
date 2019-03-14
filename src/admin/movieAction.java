package admin;

import java.awt.print.Printable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import member.AllFilePath;
import sun.security.util.Length;

public class movieAction extends ActionSupport {
	public static Reader reader; // for File Stream reader
	public static SqlMapClient sqlMapper;
	
	StringTokenizer posterST;

	public StringTokenizer getPosterST() {
		return posterST;
	}

	public void setPosterST(StringTokenizer posterST) {
		this.posterST = posterST;
	}

	adminMVVO paramClass;
	adminMVVO resultClass;

	adminActVO paramClass2;
	adminActVO resultClass2;
	
	private int currentPage=1;
	private int totalCount;
	private int blockCount=10;
	private int blockPage=5;
	private String ActionName="adminMvList";
	csPaging page;
	private String pagingHtml;

	private List<adminActVO> actList = new ArrayList<adminActVO>();
	private List<adminMVVO> list = new ArrayList<adminMVVO>();
	private File[] upload;
	private File poster;

	private String posterFileName;

	private String[] uploadContentType;
	private String[] uploadFileName;
	private String fileUploadPath = AllFilePath.forposter;
	private String posterName;
	private String old_file;
	private String Sdate;
	private String[] file_name;
	private String sumFileNames = "";

	private int ACT_NO;
	private String ACT_NAME;
	private String ACT_BIRTH;
	private int ACT_TYPE;
	private String ACT_MV_NO;
	private String ACT_PROFILE;
	private String PROFILE_ORGNAME;
	private String PROFILE_SAVNAME;
	private String ACT_FILE_ORGNAME;
	private String ACT_FILE_SAVNAME;

	public movieAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	public String execute() throws Exception {

		// actList추가
		actList = sqlMapper.queryForList("adminActAll");
		list = sqlMapper.queryForList("adminMvAll");
		// paging
		totalCount = list.size();
		page = new csPaging(currentPage, totalCount, blockCount, blockPage, ActionName);
		pagingHtml = page.getPagingHtml().toString();
		int lastCount = totalCount;
		if(page.getEndCount() < totalCount)
			lastCount = page.getEndCount()+1;
		list = list.subList(page.getStartCount(), lastCount);
		
		return SUCCESS;
	}

	public String insertMovieForm() throws Exception {

		return SUCCESS;
	}

	public String insertMovieAction() throws Exception {
		paramClass = new adminMVVO();
		paramClass.setMV_SUBJECT(getMV_SUBJECT());
		paramClass.setMV_FRESH(getMV_FRESH());
		paramClass.setMV_GENRE(getMV_GENRE());
		paramClass.setMV_TYPE(getMV_TYPE());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		paramClass.setMV_DATE(sf.parse(getMV_DATE()));
		paramClass.setMV_DIR(getMV_DIR());
		paramClass.setMV_MAIN(getMV_MAIN());
		paramClass.setMV_SUB(getMV_SUB());
		paramClass.setMV_GRADE(getMV_GRADE());
		paramClass.setMV_STATE(getMV_STATE());
		paramClass.setMV_TIME(getMV_TIME());
		paramClass.setMV_PROD(getMV_PROD());
		paramClass.setMV_SS(getMV_SS());
		paramClass.setMV_LS(getMV_LS());
		paramClass.setMV_CHAIN(getMV_CHAIN());
		paramClass.setMV_HASH(getMV_HASH());

		sqlMapper.insert("adminMvInsert", paramClass);

		if (getUpload() != null) {
			resultClass = new adminMVVO();
			resultClass = (adminMVVO) sqlMapper.queryForObject("adminMvLastOne");

			// 포스터를 위한(맨 첫번째 업로드 대상) 확장자
			String file_ext0 = getUploadFileName()[0].substring(getUploadFileName()[0].lastIndexOf('.') + 1,
					getUploadFileName()[0].length());

			// 포스터이름 : MV_NO.jpg
			String posterName = resultClass.getMV_NO() + "." + file_ext0;

			File destFile = new File(fileUploadPath + posterName);
			FileUtils.copyFile(getUpload()[0], destFile);

			int cnt = 1;

			/* if(upload.length > 0) { */

			for (int i = 1; i < upload.length; i++) {

				// 각 업로드 파일들의 확장자
				String file_ext = getUploadFileName()[i].substring(getUploadFileName()[i].lastIndexOf('.') + 1,
						getUploadFileName()[i].length());

				// 업로드될 각 파일들의 이름 : 영화번호_1~3
				String fileNames = resultClass.getMV_NO() + "_" + i + "." + file_ext;
				/*
				 * if(getUploadFileName()[i]==paramClass.getMV_SUBJECT()+"."+file_ext){
				 * posterName=getUploadFileName()[i];
				 * 
				 * }
				 */
				File destFile2 = new File(fileUploadPath + fileNames);
				FileUtils.copyFile(getUpload()[i], destFile2);

				sumFileNames += ("," + fileNames);
				System.out.println("sumFileNames의 값 : " + sumFileNames);
			}

			String FILE_ORGNAME = Arrays.toString(getUploadFileName());
			String FILE_SAVNAME = posterName + sumFileNames;

			paramClass.setMV_NO(resultClass.getMV_NO());
			paramClass.setMV_FILE_ORGNAME(FILE_ORGNAME.substring(1, FILE_ORGNAME.length() - 1));
			paramClass.setMV_FILE_SAVNAME(FILE_SAVNAME);

			sqlMapper.update("updatePoster", paramClass);
		}

		return SUCCESS;
	}

	public String updateMovieForm() throws Exception {
		resultClass = new adminMVVO();
		resultClass = (adminMVVO) sqlMapper.queryForObject("adminMvOne", getMV_NO());
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		setSdate(sf.format(resultClass.getMV_DATE()));
		
		if(resultClass.getMV_FILE_ORGNAME()!=null)
			posterST = new StringTokenizer(resultClass.getMV_FILE_ORGNAME(), ",");
		return SUCCESS;
	}

	public String updateMovieAction() throws Exception {
		paramClass = new adminMVVO();
		paramClass.setMV_NO(getMV_NO());
		paramClass.setMV_SUBJECT(getMV_SUBJECT());
		paramClass.setMV_FRESH(getMV_FRESH());
		paramClass.setMV_GENRE(getMV_GENRE());
		paramClass.setMV_TYPE(getMV_TYPE());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		paramClass.setMV_DATE(sf.parse(getMV_DATE()));
		paramClass.setMV_DIR(getMV_DIR());
		paramClass.setMV_MAIN(getMV_MAIN());
		paramClass.setMV_SUB(getMV_SUB());
		paramClass.setMV_GRADE(getMV_GRADE());
		paramClass.setMV_STATE(getMV_STATE());
		paramClass.setMV_TIME(getMV_TIME());
		paramClass.setMV_PROD(getMV_PROD());
		paramClass.setMV_SS(getMV_SS());
		paramClass.setMV_LS(getMV_LS());
		paramClass.setMV_CHAIN(getMV_CHAIN());
		paramClass.setMV_HASH(getMV_HASH());

		sqlMapper.update("adminMvUpdate", paramClass);

		if (getUpload() != null) {
			//String file_name = ""+getMV_NO();

			resultClass = new adminMVVO();
			resultClass = (adminMVVO) sqlMapper.queryForObject("adminMvOne",getMV_NO());

			// 포스터를 위한(맨 첫번째 업로드 대상) 확장자
			String file_ext0 = getUploadFileName()[0].substring(getUploadFileName()[0].lastIndexOf('.') + 1,
					getUploadFileName()[0].length());

			// 포스터이름 : MV_NO.jpg
			String posterName = resultClass.getMV_NO() + "." + file_ext0;

			File destFile = new File(fileUploadPath + posterName);
			FileUtils.copyFile(getUpload()[0], destFile);

			int cnt = 1;

			/* if(upload.length > 0) { */

			for (int i = 1; i < upload.length; i++) {

				// 각 업로드 파일들의 확장자
				String file_ext = getUploadFileName()[i].substring(getUploadFileName()[i].lastIndexOf('.') + 1,
						getUploadFileName()[i].length());

				// 업로드될 각 파일들의 이름 : 영화번호_1~3
				String fileNames = resultClass.getMV_NO() + "_" + i + "." + file_ext;
				/*
				 * if(getUploadFileName()[i]==paramClass.getMV_SUBJECT()+"."+file_ext){
				 * posterName=getUploadFileName()[i];
				 * 
				 * }
				 */
				File destFile2 = new File(fileUploadPath + fileNames);
				FileUtils.copyFile(getUpload()[i], destFile2);

				sumFileNames += ("," + fileNames);
				System.out.println("sumFileNames의 값 : " + sumFileNames);
			}

			String FILE_ORGNAME = Arrays.toString(getUploadFileName());
			String FILE_SAVNAME = posterName + sumFileNames;

			paramClass.setMV_NO(resultClass.getMV_NO());
			paramClass.setMV_FILE_ORGNAME(FILE_ORGNAME.substring(1, FILE_ORGNAME.length() - 1));
			paramClass.setMV_FILE_SAVNAME(FILE_SAVNAME);

			sqlMapper.update("updatePoster", paramClass);
		}

		return SUCCESS;
	}

	public String deleteMovieAction() throws Exception {
		sqlMapper.delete("adminMvDel", getMV_NO());
		return SUCCESS;
	}

	private int MV_NO, MV_GRADE, MV_STATE, MV_TIME, MV_TYPE, MV_FRESH, MV_AVR;
	private String MV_SUBJECT, MV_GENRE, MV_DIR, MV_MAIN, MV_SUB, MV_PROD, MV_SS, MV_LS, MV_CHAIN, MV_HASH,
			MV_FILE_ORGNAME, MV_FILE_SAVNAME;
	private String MV_DATE;

	// 등록폼
	public String insertActForm() throws Exception {

		return SUCCESS;
	}

	// 배우 등록

	public String insertActAction() throws Exception {

		paramClass2 = new adminActVO();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		paramClass2.setACT_NAME(getACT_NAME());
		System.out.println("출력값1 : " + paramClass2.getACT_NAME());
		paramClass2.setACT_BIRTH(sf.parse(getACT_BIRTH()));
		System.out.println("출력값2 : " + paramClass2.getACT_BIRTH());
		paramClass2.setACT_TYPE(getACT_TYPE());
		System.out.println("출력값3 : " + paramClass2.getACT_TYPE());
		paramClass2.setACT_MV_NO(getACT_MV_NO());
		System.out.println("출력값4 : " + paramClass2.getACT_MV_NO());
		paramClass2.setACT_PROFILE(getACT_PROFILE());
		System.out.println("출력값5 : " + paramClass2.getACT_PROFILE());

		sqlMapper.insert("adminActInsert", paramClass2);

		// 포스터 업로드
		if (getPoster() != null) {
			resultClass2 = new adminActVO();
			resultClass2 = (adminActVO) sqlMapper.queryForObject("adminActLastOne");

			String file_name = "actor_" + resultClass2.getACT_NO();
			String file_ext = getPosterFileName().substring(getPosterFileName().lastIndexOf('.') + 1,
					getPosterFileName().length());

			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getPoster(), destFile);

			paramClass2.setACT_NO(resultClass2.getACT_NO());

			System.out.println("막 받아온 act_NO의 값 : " + resultClass2.getACT_NO());

			paramClass2.setPROFILE_ORGNAME(getPosterFileName());

			System.out.println("getPosterFileName의 값 : " + getPosterFileName());

			paramClass2.setPROFILE_SAVNAME(file_name + "." + file_ext);

			System.out.println("sav 값 : " + file_name + "." + file_ext);

			sqlMapper.insert("updateActPoster", paramClass2);
		}

		return SUCCESS;
	}

	public String updateActForm() throws Exception {
		resultClass2 = new adminActVO();
		resultClass2 = (adminActVO) sqlMapper.queryForObject("adminActOne", getACT_NO());

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		setSdate(sf.format(resultClass2.getACT_BIRTH()));

		return SUCCESS;
	}

	public String updateActAction() throws Exception {
		paramClass2 = new adminActVO();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		paramClass2.setACT_NAME(getACT_NAME());
		paramClass2.setACT_BIRTH(sf.parse(getACT_BIRTH()));
		paramClass2.setACT_TYPE(getACT_TYPE());
		paramClass2.setACT_MV_NO(getACT_MV_NO());
		paramClass2.setACT_PROFILE(getACT_PROFILE());
		paramClass2.setACT_NO(getACT_NO());

		sqlMapper.update("adminActUpdate", paramClass2);

		// 포스터 업로드
		if (getPoster() != null) {
			resultClass2 = new adminActVO();
			resultClass2 = (adminActVO) sqlMapper.queryForObject("adminActLastOne");

			String file_name = "actor_" + resultClass2.getACT_NO();
			String file_ext = getPosterFileName().substring(getPosterFileName().lastIndexOf('.') + 1,
					getPosterFileName().length());

			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getPoster(), destFile);

			paramClass2.setACT_NO(resultClass2.getACT_NO());

			paramClass2.setPROFILE_ORGNAME(getPosterFileName());

			paramClass2.setPROFILE_SAVNAME(file_name + "." + file_ext);

			sqlMapper.update("updateActPoster", paramClass2);
		}

		return SUCCESS;
	}

	public String deleteActAction() throws Exception {
		sqlMapper.delete("adminActDel", getACT_NO());
		return SUCCESS;
	}

	public String getPosterFileName() {
		return posterFileName;
	}

	public void setPosterFileName(String posterFileName) {
		this.posterFileName = posterFileName;
	}

	public static Reader getReader() {
		return reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public String getSumFileNames() {
		return sumFileNames;
	}

	public int getACT_NO() {
		return ACT_NO;
	}

	public String getACT_NAME() {
		return ACT_NAME;
	}

	public int getACT_TYPE() {
		return ACT_TYPE;
	}

	public String getACT_MV_NO() {
		return ACT_MV_NO;
	}

	public String getACT_PROFILE() {
		return ACT_PROFILE;
	}

	public String getPROFILE_ORGNAME() {
		return PROFILE_ORGNAME;
	}

	public String getPROFILE_SAVNAME() {
		return PROFILE_SAVNAME;
	}

	public String getACT_FILE_ORGNAME() {
		return ACT_FILE_ORGNAME;
	}

	public String getACT_FILE_SAVNAME() {
		return ACT_FILE_SAVNAME;
	}

	public static void setReader(Reader reader) {
		movieAction.reader = reader;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		movieAction.sqlMapper = sqlMapper;
	}

	public void setSumFileNames(String sumFileNames) {
		this.sumFileNames = sumFileNames;
	}

	public void setACT_NO(int aCT_NO) {
		ACT_NO = aCT_NO;
	}

	public void setACT_NAME(String aCT_NAME) {
		ACT_NAME = aCT_NAME;
	}

	public String getACT_BIRTH() {
		return ACT_BIRTH;
	}

	public void setACT_BIRTH(String aCT_BIRTH) {
		ACT_BIRTH = aCT_BIRTH;
	}

	public void setACT_TYPE(int aCT_TYPE) {
		ACT_TYPE = aCT_TYPE;
	}

	public void setACT_MV_NO(String aCT_MV_NO) {
		ACT_MV_NO = aCT_MV_NO;
	}

	public void setACT_PROFILE(String aCT_PROFILE) {
		ACT_PROFILE = aCT_PROFILE;
	}

	public void setPROFILE_ORGNAME(String pROFILE_ORGNAME) {
		PROFILE_ORGNAME = pROFILE_ORGNAME;
	}

	public void setPROFILE_SAVNAME(String pROFILE_SAVNAME) {
		PROFILE_SAVNAME = pROFILE_SAVNAME;
	}

	public void setACT_FILE_ORGNAME(String aCT_FILE_ORGNAME) {
		ACT_FILE_ORGNAME = aCT_FILE_ORGNAME;
	}

	public void setACT_FILE_SAVNAME(String aCT_FILE_SAVNAME) {
		ACT_FILE_SAVNAME = aCT_FILE_SAVNAME;
	}

	public int getMV_NO() {
		return MV_NO;
	}

	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public String getSdate() {
		return Sdate;
	}

	public void setSdate(String sdate) {
		Sdate = sdate;
	}

	public void setMV_NO(int mV_NO) {
		MV_NO = mV_NO;
	}

	public int getMV_GRADE() {
		return MV_GRADE;
	}

	public void setMV_GRADE(int mV_GRADE) {
		MV_GRADE = mV_GRADE;
	}

	public int getMV_STATE() {
		return MV_STATE;
	}

	public void setMV_STATE(int mV_STATE) {
		MV_STATE = mV_STATE;
	}

	public int getMV_TIME() {
		return MV_TIME;
	}

	public void setMV_TIME(int mV_TIME) {
		MV_TIME = mV_TIME;
	}

	public int getMV_TYPE() {
		return MV_TYPE;
	}

	public void setMV_TYPE(int mV_TYPE) {
		MV_TYPE = mV_TYPE;
	}

	public int getMV_FRESH() {
		return MV_FRESH;
	}

	public void setMV_FRESH(int mV_FRESH) {
		MV_FRESH = mV_FRESH;
	}

	public int getMV_AVR() {
		return MV_AVR;
	}

	public void setMV_AVR(int mV_AVR) {
		MV_AVR = mV_AVR;
	}

	public String getMV_SUBJECT() {
		return MV_SUBJECT;
	}

	public void setMV_SUBJECT(String mV_SUBJECT) {
		MV_SUBJECT = mV_SUBJECT;
	}

	public String getMV_GENRE() {
		return MV_GENRE;
	}

	public void setMV_GENRE(String mV_GENRE) {
		MV_GENRE = mV_GENRE;
	}

	public String getMV_DIR() {
		return MV_DIR;
	}

	public void setMV_DIR(String mV_DIR) {
		MV_DIR = mV_DIR;
	}

	public String getMV_MAIN() {
		return MV_MAIN;
	}

	public void setMV_MAIN(String mV_MAIN) {
		MV_MAIN = mV_MAIN;
	}

	public String getMV_SUB() {
		return MV_SUB;
	}

	public void setMV_SUB(String mV_SUB) {
		MV_SUB = mV_SUB;
	}

	public String getMV_PROD() {
		return MV_PROD;
	}

	public void setMV_PROD(String mV_PROD) {
		MV_PROD = mV_PROD;
	}

	public String getMV_SS() {
		return MV_SS;
	}

	public void setMV_SS(String mV_SS) {
		MV_SS = mV_SS;
	}

	public String getMV_LS() {
		return MV_LS;
	}

	public void setMV_LS(String mV_LS) {
		MV_LS = mV_LS;
	}

	public String getMV_CHAIN() {
		return MV_CHAIN;
	}

	public void setMV_CHAIN(String mV_CHAIN) {
		MV_CHAIN = mV_CHAIN;
	}

	public String getMV_HASH() {
		return MV_HASH;
	}

	public void setMV_HASH(String mV_HASH) {
		MV_HASH = mV_HASH;
	}

	public String getMV_FILE_ORGNAME() {
		return MV_FILE_ORGNAME;
	}

	public void setMV_FILE_ORGNAME(String mV_FILE_ORGNAME) {
		MV_FILE_ORGNAME = mV_FILE_ORGNAME;
	}

	public String getMV_FILE_SAVNAME() {
		return MV_FILE_SAVNAME;
	}

	public void setMV_FILE_SAVNAME(String mV_FILE_SAVNAME) {
		MV_FILE_SAVNAME = mV_FILE_SAVNAME;
	}

	public String getMV_DATE() {
		return MV_DATE;
	}

	public void setMV_DATE(String mV_DATE) {
		MV_DATE = mV_DATE;
	}

	public adminMVVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(adminMVVO paramClass) {
		this.paramClass = paramClass;
	}

	public adminMVVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(adminMVVO resultClass) {
		this.resultClass = resultClass;
	}

	public List<adminMVVO> getList() {
		return list;
	}

	public void setList(List<adminMVVO> list) {
		this.list = list;
	}

	public File[] getUpload() {
		return upload;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	protected String getOld_file() {
		return old_file;
	}

	protected void setOld_file(String old_file) {
		this.old_file = old_file;
	}

	public String[] getFile_name() {
		return file_name;
	}

	public void setFile_name(String[] file_name) {
		this.file_name = file_name;
	}

	public adminActVO getParamClass2() {
		return paramClass2;
	}

	public adminActVO getResultClass2() {
		return resultClass2;
	}

	public List<adminActVO> getActList() {
		return actList;
	}

	public File getPoster() {
		return poster;
	}

	public void setParamClass2(adminActVO paramClass2) {
		this.paramClass2 = paramClass2;
	}

	public void setResultClass2(adminActVO resultClass2) {
		this.resultClass2 = resultClass2;
	}

	public void setActList(List<adminActVO> actList) {
		this.actList = actList;
	}

	public void setPoster(File poster) {
		this.poster = poster;
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

	public String getActionName() {
		return ActionName;
	}

	public void setActionName(String actionName) {
		ActionName = actionName;
	}

	public csPaging getPage() {
		return page;
	}

	public void setPage(csPaging page) {
		this.page = page;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

}
