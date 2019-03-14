package movie;

import java.util.Date;

public class movieVO {
	
	private int MV_NO;
	private String MV_SUBJECT;
	private String MV_GENRE;

	private String GENRE;
	private String MV_DIR; //감독
	private String MV_MAIN;
	private String MV_SUB;
	private String MV_PROD; //배급사
	private Date MV_DATE; //개봉날짜
	private int MV_GRADE; //영화등급
	private int MV_STATE; //국가분류
	private int MV_TIME; //러닝타임
	private String MV_SS; //간단보기내용
	private String MV_LS;
	private String MV_CHAIN; //시리즈유무
	private String MV_HASH; //검색유입어
	private int MV_TYPE; //영화상태분류
	private int MV_FRESH; //영화신선도
	private String MV_FILE_ORGNAME; //원본저장파일명
	private String MV_FILE_SAVNAME;
	
	
	private float MV_AVR;		//MOVIEC 로부터 받아온 평균값을 저장
					
	//추가된 변수 - search : 이놈을 받아서 비슷한 내용을 DB에서 뽑아올 예정.
	private String search;
	
	
	
	
	public String getGENRE() {
		return GENRE;
	}
	public void setGENRE(String gENRE) {
		GENRE = gENRE;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getMV_NO() {
		return MV_NO;
	}
	public String getMV_SUBJECT() {
		return MV_SUBJECT;
	}
	public String getMV_GENRE() {
		return MV_GENRE;
	}
	public String getMV_DIR() {
		return MV_DIR;
	}
	public String getMV_MAIN() {
		return MV_MAIN;
	}
	public String getMV_SUB() {
		return MV_SUB;
	}
	public String getMV_PROD() {
		return MV_PROD;
	}
	public Date getMV_DATE() {
		return MV_DATE;
	}
	public int getMV_GRADE() {
		return MV_GRADE;
	}
	public int getMV_STATE() {
		return MV_STATE;
	}
	public int getMV_TIME() {
		return MV_TIME;
	}
	public String getMV_SS() {
		return MV_SS;
	}
	public String getMV_LS() {
		return MV_LS;
	}
	public String getMV_CHAIN() {
		return MV_CHAIN;
	}
	public String getMV_HASH() {
		return MV_HASH;
	}
	public int getMV_TYPE() {
		return MV_TYPE;
	}
	public int getMV_FRESH() {
		return MV_FRESH;
	}
	public String getMV_FILE_ORGNAME() {
		return MV_FILE_ORGNAME;
	}
	public String getMV_FILE_SAVNAME() {
		return MV_FILE_SAVNAME;
	}
	public void setMV_NO(int mV_NO) {
		MV_NO = mV_NO;
	}
	public void setMV_SUBJECT(String mV_SUBJECT) {
		MV_SUBJECT = mV_SUBJECT;
	}
	public void setMV_GENRE(String mV_GENRE) {
		MV_GENRE = mV_GENRE;
	}
	public void setMV_DIR(String mV_DIR) {
		MV_DIR = mV_DIR;
	}
	public void setMV_MAIN(String mV_MAIN) {
		MV_MAIN = mV_MAIN;
	}
	public void setMV_SUB(String mV_SUB) {
		MV_SUB = mV_SUB;
	}
	public void setMV_PROD(String mV_PROD) {
		MV_PROD = mV_PROD;
	}
	public void setMV_DATE(Date mV_DATE) {
		MV_DATE = mV_DATE;
	}
	public void setMV_GRADE(int mV_GRADE) {
		MV_GRADE = mV_GRADE;
	}
	public void setMV_STATE(int mV_STATE) {
		MV_STATE = mV_STATE;
	}
	public void setMV_TIME(int mV_TIME) {
		MV_TIME = mV_TIME;
	}
	public void setMV_SS(String mV_SS) {
		MV_SS = mV_SS;
	}
	public void setMV_LS(String mV_LS) {
		MV_LS = mV_LS;
	}
	public void setMV_CHAIN(String mV_CHAIN) {
		MV_CHAIN = mV_CHAIN;
	}
	public void setMV_HASH(String mV_HASH) {
		MV_HASH = mV_HASH;
	}
	public void setMV_TYPE(int mV_TYPE) {
		MV_TYPE = mV_TYPE;
	}
	public void setMV_FRESH(int mV_FRESH) {
		MV_FRESH = mV_FRESH;
	}
	public void setMV_FILE_ORGNAME(String mV_FILE_ORGNAME) {
		MV_FILE_ORGNAME = mV_FILE_ORGNAME;
	}
	public void setMV_FILE_SAVNAME(String mV_FILE_SAVNAME) {
		MV_FILE_SAVNAME = mV_FILE_SAVNAME;
	}
	public float getMV_AVR() {
		return MV_AVR;
	}
	public void setMV_AVR(float mV_AVR) {
		MV_AVR = mV_AVR;
	}
	
	
}
