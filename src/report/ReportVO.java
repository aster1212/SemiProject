package report;

import java.util.Date;

public class ReportVO {
	
	private int rep_no;
	private String rep_writer;
	private String rep_content;
	private Date rep_date;
	private int rep_ed_type;
	private int rep_ed_no;
	private String rep_ed_content;
	private int rep_status;
	
	public int getRep_no() {
		return rep_no;
	}
	public void setRep_no(int rep_no) {
		this.rep_no = rep_no;
	}
	public String getRep_writer() {
		return rep_writer;
	}
	public void setRep_writer(String rep_writer) {
		this.rep_writer = rep_writer;
	}
	public Date getRep_date() {
		return rep_date;
	}
	public void setRep_date(Date rep_date) {
		this.rep_date = rep_date;
	}
	public String getRep_content() {
		return rep_content;
	}
	public void setRep_content(String rep_content) {
		this.rep_content = rep_content;
	}
	public int getRep_ed_type() {
		return rep_ed_type;
	}
	public void setRep_ed_type(int rep_ed_type) {
		this.rep_ed_type = rep_ed_type;
	}
	public int getRep_ed_no() {
		return rep_ed_no;
	}
	public void setRep_ed_no(int rep_ed_no) {
		this.rep_ed_no = rep_ed_no;
	}
	public String getRep_ed_content() {
		return rep_ed_content;
	}
	public void setRep_ed_content(String rep_ed_content) {
		this.rep_ed_content = rep_ed_content;
	}
	public int getRep_status() {
		return rep_status;
	}
	public void setRep_status(int rep_status) {
		this.rep_status = rep_status;
	}
	
	

}
