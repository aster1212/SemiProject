package admin;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

import board.CboardVO;
import board.BoardVO;

public class ValidationAction extends ActionSupport {
	public static Reader reader; // for File Stream reader
	public static SqlMapClient sqlMapper;
	
	// for board
	private CboardVO bocVO;
	private BoardVO boVO;
	private int delCount;
	private int delType;
	private int numbers;
	private String delName;
	List<ValidationVO> list = new ArrayList<ValidationVO>();
	List<Integer> nullList = new ArrayList<Integer>();
	
	public ValidationAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}
	
	@SuppressWarnings("unchecked")
	public String bocValidation() throws Exception{
		delCount=0;
		delName="게시판 댓글 유효성 검사";
		//1. 보드씨 오리진 넘버를 모두 가져온다.(비중복)
		list = sqlMapper.queryForList("selectUniqueBocOriginno");
		
		//2. 오리진 넘버로 보드의 값을 검색한다.
		for (ValidationVO validationVO : list) {
			int i = validationVO.getNumbers();
			boVO = new BoardVO();
			boVO = (BoardVO) sqlMapper.queryForObject("boardselectOne",i);
			//3. 값이 없는 것들을 리스트에 넣는다
			if(boVO == null) {
				nullList.add(i);
			}
		}
		
		//4. 값이 없는 것들을 가진 보드씨 넘버를 지운다.
		for (Integer i : nullList) {
			try {
				int count = (int) sqlMapper.queryForObject("selectNullBocCount",i);
				delCount += count;
				sqlMapper.delete("deleteNullBocOriginno",i);
			} catch (SQLException e) {
				System.out.println("지우는데 에러가 났다.");
			}
		}
		
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public CboardVO getBocVO() {
		return bocVO;
	}

	public void setBocVO(CboardVO bocVO) {
		this.bocVO = bocVO;
	}

	public BoardVO getBoVO() {
		return boVO;
	}

	public void setBoVO(BoardVO boVO) {
		this.boVO = boVO;
	}

	public int getDelCount() {
		return delCount;
	}

	public void setDelCount(int delCount) {
		this.delCount = delCount;
	}

	public int getDelType() {
		return delType;
	}

	public void setDelType(int delType) {
		this.delType = delType;
	}

	public String getDelName() {
		return delName;
	}

	public void setDelName(String delName) {
		this.delName = delName;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public List<ValidationVO> getList() {
		return list;
	}

	public void setList(List<ValidationVO> list) {
		this.list = list;
	}
	
	
}
