package admin;

import java.util.Date;

public class adminMVVO {

	private int
	MV_NO,				//영화 시퀀스번호
	MV_GRADE,			//영화 등급
	MV_STATE,			//영화 나라
	MV_TIME,			//영화 상영시간
	MV_TYPE,			//영화 상영중,상영종료,상영예정
	MV_FRESH,			//영화 신선도
	MV_AVR;				//영화 평점
	private String
	MV_SUBJECT,			//제목
	MV_GENRE,			//장르
	MV_DIR,				//감독
	MV_MAIN,			//주연
	MV_SUB,				//조연
	MV_PROD,			//배급사
	MV_SS,				//짧은소개
	MV_LS,				//긴소개
	MV_CHAIN,			//시리즈 여부
	MV_HASH,			//검색 유입어
	MV_FILE_ORGNAME,	//포스터 이름
	MV_FILE_SAVNAME,
	Sdate;	//포스터 디비이름
	private Date 
	MV_DATE;			//영화 개봉 날짜
	
	
	public String getSdate() {
		return Sdate;
	}
	public void setSdate(String sdate) {
		Sdate = sdate;
	}
	public int getMV_NO() {
		return MV_NO;
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
	public Date getMV_DATE() {
		return MV_DATE;
	}
	public void setMV_DATE(Date mV_DATE) {
		MV_DATE = mV_DATE;
	}
	
	
}
