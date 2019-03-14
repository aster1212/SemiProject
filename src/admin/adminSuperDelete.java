package admin;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class adminSuperDelete extends ActionSupport{
	public static Reader reader; // for File Stream reader
	public static SqlMapClient sqlMapper;
	public adminSuperDelete() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	// for delete
	private adminTraceVO allVO;
	private int rep_ed_no;
	private int rep_ed_type;
	String tableName;
	String colName;
	
	
	// delete action
	@Override
	public String execute() throws Exception {
		allVO = new adminTraceVO();
		tableName = reportTraceAction.tableTyper(getRep_ed_type());
		colName = reportTraceAction.tableTyper(tableName);
		allVO.setTableName(tableName);
		allVO.setColName(colName);
		allVO.setRep_ed_no(getRep_ed_no());
		
		sqlMapper.delete("adminTcDelete",allVO);
		
		return SUCCESS;
	}


	public adminTraceVO getAllVO() {
		return allVO;
	}


	public void setAllVO(adminTraceVO allVO) {
		this.allVO = allVO;
	}


	public int getRep_ed_no() {
		return rep_ed_no;
	}


	public void setRep_ed_no(int rep_ed_no) {
		this.rep_ed_no = rep_ed_no;
	}


	public int getRep_ed_type() {
		return rep_ed_type;
	}


	public void setRep_ed_type(int rep_ed_type) {
		this.rep_ed_type = rep_ed_type;
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
	
	
	

}
