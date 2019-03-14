package board;

import java.util.Date;

public class BoardVO {
	
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
}