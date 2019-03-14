package movie;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.util.*;
import java.io.Reader;
import java.io.IOException;

public class movieCommentWrite extends ActionSupport {

   public static Reader reader;
   public static SqlMapClient sqlMapper;

   private moviecVO paramClass;
   private moviecVO resultClass;
   

	//영화별 평균을 끌어오기 위한 변수
	private tempMVVO avgClass;
	

   private int currentPage;

   private int MVC_NO;
   private int MV_NO;
   private String MVC_WRITER;
   private String MVC_CONTENT;
   private Date MVC_DATE;
   private int MVC_;
   private int MEM_GRADE;
   private int MEM_GEN;
   private int mem_no;
   
   public int getMem_no() {
	return mem_no;
}
public void setMem_no(int mem_no) {
	this.mem_no = mem_no;
}
   
   Calendar today = Calendar.getInstance();

   public movieCommentWrite() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();

   }
   public String form() throws Exception {
      
      return SUCCESS;

   }
   
   // ASD
   @Override
   public String execute() throws Exception {
      paramClass = new moviecVO();
      resultClass = new moviecVO();
                           
      
      paramClass.setMV_NO(getMV_NO());
    /*  paramClass.setMEM_GEN(getMEM_GEN());
      paramClass.setMEM_GRADE(getMEM_GRADE());*/
      paramClass.setMVC_AVR(getMVC_());
      paramClass.setMVC_CONTENT(getMVC_CONTENT());
      paramClass.setMVC_NO(getMVC_NO());
      paramClass.setMVC_WRITER(getMVC_WRITER());
      paramClass.setMVC_DATE(today.getTime());
      paramClass.setMem_no(getMem_no());
      
      sqlMapper.insert("insertMoviec", paramClass);
      
      

      //코멘트 작성시 넣은 별점으로 영화별 평점 업뎃
     avgClass = new tempMVVO();
     avgClass.setTempMV_NO1(getMV_NO());
     avgClass.setTempMV_NO2(getMV_NO());
     
		sqlMapper.update("updateAvg", avgClass);
		
		

      return SUCCESS;
   }
   
   
   public static Reader getReader() {
      return reader;
   }


   public static void setReader(Reader reader) {
      movieCommentWrite.reader = reader;
   }
   public static SqlMapClient getSqlMapper() {
      return sqlMapper;
   }
   public static void setSqlMapper(SqlMapClient sqlMapper) {
      movieCommentWrite.sqlMapper = sqlMapper;
   }
   public moviecVO getParamClass() {
      return paramClass;
   }
   public void setParamClass(moviecVO paramClass) {
      this.paramClass = paramClass;
   }
   public moviecVO getResultClass() {
      return resultClass;
   }
   public void setResultClass(moviecVO resultClass) {
      this.resultClass = resultClass;
   }
   public int getCurrentPage() {
      return currentPage;
   }
   public void setCurrentPage(int currentPage) {
      this.currentPage = currentPage;
   }
   public int getMVC_NO() {
      return MVC_NO;
   }
   public void setMVC_NO(int mVC_NO) {
      MVC_NO = mVC_NO;
   }
   public int getMV_NO() {
      return MV_NO;
   }
   public void setMV_NO(int mV_NO) {
      MV_NO = mV_NO;
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

 
   public int getMEM_GRADE() {
      return MEM_GRADE;
   }
   public void setMEM_GRADE(int mEM_GRADE) {
      MEM_GRADE = mEM_GRADE;
   }
   public int getMEM_GEN() {
      return MEM_GEN;
   }
   public void setMEM_GEN(int mEM_GEN) {
      MEM_GEN = mEM_GEN;
   }
   public Calendar getToday() {
      return today;
   }
   public void setToday(Calendar today) {
      this.today = today;
   }


public tempMVVO getAvgClass() {
	return avgClass;
}
public void setAvgClass(tempMVVO avgClass) {
	this.avgClass = avgClass;
}
public int getMVC_() {
	return MVC_;
}
public void setMVC_(int mVC_) {
	MVC_ = mVC_;
}
   
   
   

   
}