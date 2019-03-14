package movie;

//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class actViewAction extends ActionSupport { 

	public static Reader reader;
	public static SqlMapClient sqlMapper;
 
	private movieVO paramClass;
	private actVO paramClass2;
	private actVO resultClass;
	private String movies;
	private List<actVO> actList = new ArrayList<actVO>();
	private List<movieVO> movieList = new ArrayList<movieVO>();
	private List photoList = new ArrayList<>();
	private String[] movieArray;

	private int currentPage;
	private int MV_NO;
	private int NO;
	private String MV_GENRE;
	private String ACT_NAME;
	private int ACT_NO;
	private String ACT_FILE_SAVNAME;
	private String MV_DIR;
	private String photos;
	private String[] photoArray;
	private int ACT_TYPE;
	private String PROFILE_SAVNAME;
	// 생성자
	public actViewAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	
	//기존 상세보기 + 배우리스트 및 상세보기
	public String execute() throws Exception {
		resultClass = new actVO();
		resultClass = (actVO)sqlMapper.queryForObject("selectAct", getACT_NO());
		

	
		
		//사진 출력을 위한 로직
	/*	photos = resultClass.getPROFILE_SAVNAME().toString();
		photoArray = photos.split(",");
		
		for(int i=0; i<photoArray.length; i++) {	
		
			photoList.add(photoArray[i]);
		}*/
		
		
		movieList = new ArrayList<movieVO>();
		
		//배우가 출연한 영화들을 영화테이블에서 재구성하는 로직
		movies = resultClass.getACT_MV_NO().toString();
		movieArray = movies.split(",");
		
		// 장하다, addAll
		for(int i=0; i<movieArray.length; i++) {
			movieList.addAll(i, sqlMapper.queryForList("movieAllByNo", movieArray[i]));
			
			System.out.println("movieArray값 : "+movieArray[i]);
		}
		
		
	
		return SUCCESS;
	}
	
	
	//배우사진 상세보기
	public String execute2() throws Exception {
		
		String getPhoto=getPROFILE_SAVNAME();
		
		resultClass = new actVO();
		resultClass = (actVO)sqlMapper.queryForObject("selectAct", getACT_NO());
	
		
	/*	photoArray = resultClass.getACT_FILE_SAVNAME().toString().split(",");
		
		for(int i=0; i<photoArray.length; i++) {
		if(photoArray[i].equals(getPhoto)) {
			String viewPhoto = photoArray[i];	
			resultClass.setACT_FILE_SAVNAME(viewPhoto);
			}
		}*/
	
	return SUCCESS;
	}
	
	
	//배우 및 감독 '더보기'
	public String execute3() throws Exception {
		
		//해당 MV_NO에 해당하는 배우 모두 불러오기
		String no= getMV_NO()+",";
		int no2 = getMV_NO();
		actList = sqlMapper.queryForList("selectActList", "%"+no+"%");
		
		paramClass = new movieVO();
		paramClass = (movieVO)sqlMapper.queryForObject("movieAllByNo", no2);
		
		String dir = paramClass.getMV_DIR();
		
		
		
		paramClass2 = new actVO();
		paramClass2.setACT_TYPE(2);
		paramClass2.setACT_NAME(dir);
		
		resultClass = new actVO();
		resultClass = (actVO)sqlMapper.queryForObject("selectDir",paramClass2);
		
		if(resultClass==null) {
			return ERROR;
		}else
			
		//감독의 작품 뽑아오기
		movieList = new ArrayList<movieVO>();
		movies = resultClass.getACT_MV_NO().toString();
		
	
		movieArray = movies.split(",");
	
		for(int i=0; i<movieArray.length; i++) {
			movieList.addAll(i, sqlMapper.queryForList("movieAllByNo", movieArray[i]));
		}
		
		
			
		return SUCCESS;
}
	
	
	
	
	
	
	
	public String getPROFILE_SAVNAME() {
		return PROFILE_SAVNAME;
	}


	public void setPROFILE_SAVNAME(String pROFILE_SAVNAME) {
		PROFILE_SAVNAME = pROFILE_SAVNAME;
	}


	public actVO getParamClass2() {
		return paramClass2;
	}


	public int getACT_TYPE() {
		return ACT_TYPE;
	}


	public void setParamClass2(actVO paramClass2) {
		this.paramClass2 = paramClass2;
	}


	public void setACT_TYPE(int aCT_TYPE) {
		ACT_TYPE = aCT_TYPE;
	}


	public String getMV_DIR() {
		return MV_DIR;
	}


	public void setMV_DIR(String mV_DIR) {
		MV_DIR = mV_DIR;
	}


	public movieVO getParamClass() {
		return paramClass;
	}


	public void setParamClass(movieVO paramClass) {
		this.paramClass = paramClass;
	}


	public String getMovies() {
		return movies;
	}


	public List<movieVO> getMovieList() {
		return movieList;
	}


	public String[] getMovieArray() {
		return movieArray;
	}


	public void setMovies(String movies) {
		this.movies = movies;
	}


	public void setMovieList(List<movieVO> movieList) {
		this.movieList = movieList;
	}


	public void setMovieArray(String[] movieArray) {
		this.movieArray = movieArray;
	}


	public List getPhotoList() {
		return photoList;
	}


	public void setPhotoList(List photoList) {
		this.photoList = photoList;
	}


	public String[] getPhotoArray() {
		return photoArray;
	}


	public void setPhotoArray(String[] photoArray) {
		this.photoArray = photoArray;
	}


	public String getPhotos() {
		return photos;
	}


	public void setPhotos(String photos) {
		this.photos = photos;
	}


	public String getACT_FILE_SAVNAME() {
		return ACT_FILE_SAVNAME;
	}


	public void setACT_FILE_SAVNAME(String aCT_FILE_SAVNAME) {
		ACT_FILE_SAVNAME = aCT_FILE_SAVNAME;
	}


	public int getACT_NO() {
		return ACT_NO;
	}


	public void setACT_NO(int aCT_NO) {
		ACT_NO = aCT_NO;
	}


	public static Reader getReader() {
		return reader;
	}


	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}



	public actVO getResultClass() {
		return resultClass;
	}


	public List<actVO> getActList() {
		return actList;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getMV_NO() {
		return MV_NO;
	}


	public int getNO() {
		return NO;
	}


	public String getMV_GENRE() {
		return MV_GENRE;
	}


	public String getACT_NAME() {
		return ACT_NAME;
	}


	public static void setReader(Reader reader) {
		actViewAction.reader = reader;
	}


	public static void setSqlMapper(SqlMapClient sqlMapper) {
		actViewAction.sqlMapper = sqlMapper;
	}


	public void setResultClass(actVO resultClass) {
		this.resultClass = resultClass;
	}


	public void setActList(List<actVO> actList) {
		this.actList = actList;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public void setMV_NO(int mV_NO) {
		MV_NO = mV_NO;
	}


	public void setNO(int nO) {
		NO = nO;
	}


	public void setMV_GENRE(String mV_GENRE) {
		MV_GENRE = mV_GENRE;
	}


	public void setACT_NAME(String aCT_NAME) {
		ACT_NAME = aCT_NAME;
	}
	
}
