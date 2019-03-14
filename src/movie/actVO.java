package movie;

import java.util.Date;

public class actVO {
	
	private int ACT_NO; 
	private String ACT_NAME; 
	private Date ACT_BIRTH; 
	private int ACT_TYPE;
	private String ACT_MV_NO; //배우가 출연한 모든 영화
	private String ACT_PROFILE; 
	private String PROFILE_ORGNAME;
	private String PROFILE_SAVNAME;
	private String ACT_FILE_ORGNAME; //기타사진
	private String ACT_FILE_SAVNAME; //기타사진(저장본)
	
	
	public String getPROFILE_ORGNAME() {
		return PROFILE_ORGNAME;
	}
	public String getPROFILE_SAVNAME() {
		return PROFILE_SAVNAME;
	}
	public void setPROFILE_ORGNAME(String pROFILE_ORGNAME) {
		PROFILE_ORGNAME = pROFILE_ORGNAME;
	}
	public void setPROFILE_SAVNAME(String pROFILE_SAVNAME) {
		PROFILE_SAVNAME = pROFILE_SAVNAME;
	}
	public int getACT_NO() {
		return ACT_NO;
	}
	public String getACT_NAME() {
		return ACT_NAME;
	}
	public Date getACT_BIRTH() {
		return ACT_BIRTH;
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
	public String getACT_FILE_ORGNAME() {
		return ACT_FILE_ORGNAME;
	}

	public void setACT_NO(int aCT_NO) {
		ACT_NO = aCT_NO;
	}
	public void setACT_NAME(String aCT_NAME) {
		ACT_NAME = aCT_NAME;
	}
	public void setACT_BIRTH(Date aCT_BIRTH) {
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
	public void setACT_FILE_ORGNAME(String aCT_FILE_ORGNAME) {
		ACT_FILE_ORGNAME = aCT_FILE_ORGNAME;
	}
	public String getACT_FILE_SAVNAME() {
		return ACT_FILE_SAVNAME;
	}
	public void setACT_FILE_SAVNAME(String aCT_FILE_SAVNAME) {
		ACT_FILE_SAVNAME = aCT_FILE_SAVNAME;
	}
	
	
	

}
