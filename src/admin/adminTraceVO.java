package admin;

import java.util.Date;

import oracle.sql.DATE;

public class adminTraceVO {
	
	//board
	
	private int bo_no;
	private String bo_genre;
	private String bo_subject;
	private String bo_writer;
	private int bo_cnt;
	private Date bo_date;
	private String bo_content;
	private String bo_orgfile;
	private String bo_savfile;
	private String category;
	
	//board comment
	
	private int boc_no;
	private int boc_originno;
	private String boc_writer;
	private String boc_content;
	private Date boc_date;
	private int boc_ref;
	private int boc_relevel;
	private int boc_restep;
	
	//member
	
	private int memNo;
	private String memId;
	private String memName;
	private String memPw;
	private String memHp;
	private int memGen;
	private int memGrade;
	private String memFavor;
	private String memLike;
	
	// movie comment
	
	private int MVC_NO; //��۹�ȣ
	private int MVC_AVR; //����
	private int MEM_GEN; //����
	private int MV_NO; //��ȭ������ ������ MV_NO
	private int MEM_GRADE; //ȸ�����
	private String MVC_WRITER; //�ۼ���
	private String MVC_CONTENT; //����
	private Date MVC_DATE;
	
	//movie
	// 무미씨랑 같음 private int MV_NO;
	
	private String MV_SUBJECT;
	private String MV_GENRE;
	private String MV_DIR;
	private String MV_MAIN;
	private String MV_SUB;
	private String MV_PROD; 
	private Date MV_DATE;
	private int MV_GRADE; 
	private int MV_STATE; 
	private int MV_TIME;
	private String MV_SS; 
	private String MV_LS;
	private String MV_CHAIN;
	private String MV_HASH;
	private int MV_TYPE;
	private int MV_FRESH; 
	private String MV_FILE_ORGNAME; 
	private String MV_FILE_SAVNAME;
	
	// trace
	
	private String tableName;
	private String colName;
	private int rep_ed_no;
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
	public int getBo_cnt() {
		return bo_cnt;
	}
	public void setBo_cnt(int bo_cnt) {
		this.bo_cnt = bo_cnt;
	}
	public Date getBo_date() {
		return bo_date;
	}
	public void setBo_date(Date bo_date) {
		this.bo_date = bo_date;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getBoc_no() {
		return boc_no;
	}
	public void setBoc_no(int boc_no) {
		this.boc_no = boc_no;
	}
	public int getBoc_originno() {
		return boc_originno;
	}
	public void setBoc_originno(int boc_originno) {
		this.boc_originno = boc_originno;
	}
	public String getBoc_writer() {
		return boc_writer;
	}
	public void setBoc_writer(String boc_writer) {
		this.boc_writer = boc_writer;
	}
	public String getBoc_content() {
		return boc_content;
	}
	public void setBoc_content(String boc_content) {
		this.boc_content = boc_content;
	}
	public Date getBoc_date() {
		return boc_date;
	}
	public void setBoc_date(Date boc_date) {
		this.boc_date = boc_date;
	}
	public int getBoc_ref() {
		return boc_ref;
	}
	public void setBoc_ref(int boc_ref) {
		this.boc_ref = boc_ref;
	}
	public int getBoc_relevel() {
		return boc_relevel;
	}
	public void setBoc_relevel(int boc_relevel) {
		this.boc_relevel = boc_relevel;
	}
	public int getBoc_restep() {
		return boc_restep;
	}
	public void setBoc_restep(int boc_restep) {
		this.boc_restep = boc_restep;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public int getMemGen() {
		return memGen;
	}
	public void setMemGen(int memGen) {
		this.memGen = memGen;
	}
	public int getMemGrade() {
		return memGrade;
	}
	public void setMemGrade(int memGrade) {
		this.memGrade = memGrade;
	}
	public String getMemFavor() {
		return memFavor;
	}
	public void setMemFavor(String memFavor) {
		this.memFavor = memFavor;
	}
	public String getMemLike() {
		return memLike;
	}
	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}
	public int getMVC_NO() {
		return MVC_NO;
	}
	public void setMVC_NO(int mVC_NO) {
		MVC_NO = mVC_NO;
	}
	public int getMVC_AVR() {
		return MVC_AVR;
	}
	public void setMVC_AVR(int mVC_AVR) {
		MVC_AVR = mVC_AVR;
	}
	public int getMEM_GEN() {
		return MEM_GEN;
	}
	public void setMEM_GEN(int mEM_GEN) {
		MEM_GEN = mEM_GEN;
	}
	public int getMV_NO() {
		return MV_NO;
	}
	public void setMV_NO(int mV_NO) {
		MV_NO = mV_NO;
	}
	public int getMEM_GRADE() {
		return MEM_GRADE;
	}
	public void setMEM_GRADE(int mEM_GRADE) {
		MEM_GRADE = mEM_GRADE;
	}
	public String getMVC_WRITER() {
		return MVC_WRITER;
	}
	public void setMVC_WRITER(String mVC_WRITER) {
		MVC_WRITER = mVC_WRITER;
	}
	public String getMVC_CONTENT() {
		return MVC_CONTENT;
	}
	public void setMVC_CONTENT(String mVC_CONTENT) {
		MVC_CONTENT = mVC_CONTENT;
	}
	public Date getMVC_DATE() {
		return MVC_DATE;
	}
	public void setMVC_DATE(Date mVC_DATE) {
		MVC_DATE = mVC_DATE;
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
	public Date getMV_DATE() {
		return MV_DATE;
	}
	public void setMV_DATE(Date mV_DATE) {
		MV_DATE = mV_DATE;
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
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public int getRep_ed_no() {
		return rep_ed_no;
	}
	public void setRep_ed_no(int rep_ed_no) {
		this.rep_ed_no = rep_ed_no;
	}
}
