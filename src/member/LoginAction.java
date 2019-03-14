package member;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import board.BoardVO;
import board.PagingAction;
import movie.movieVO;
import movie.moviecVO;
import news.newsVO;
import news.pagingAction7;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends ActionSupport implements ServletResponseAware, ServletRequestAware{
	private String memId, memPw;
	private String errorStr;
	private int check=-1;
	memberVO paramClass,resultClass;
	List<memberVO> list = new ArrayList<memberVO>();
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	private int num=0;
	//게시판 띄우기
		private List<BoardVO> list_free = new ArrayList<BoardVO>();
		private List<BoardVO> list_spo = new ArrayList<BoardVO>();
		private int currentPage = 1;	
		private int totalCount; 		
		private int blockCount = 10;	
		private int blockPage = 3; 
		private String pagingHtml; 
		private PagingAction page; 	
		
		//뉴스 띄우기
		 private List<newsVO> newsList=new ArrayList<newsVO>();
		 private int currentPage2=1;
		 private int totalCount2;
		 private int blockCount2=9;
		 private int blockPage2=9;
		 private pagingAction7 page2;
		 private String pageHtml;
		 private int num2=0;
		 int cnt = 0;
		 
		 //영화관련
		 private List<movieVO> movieList = new ArrayList<movieVO>();
		 private List<movieVO> goodList = new ArrayList<movieVO>();
		 private moviecVO mainComment = new moviecVO();
		 private List<moviecVO> moviecommentList = new ArrayList<moviecVO>();
		 private List<moviecVO> moviecommentList2 = new ArrayList<moviecVO>();
		 private int m1;
		 private int m2;
		 private String s1;
		 private String s2;
		 private double mavr1;
		 private double mavr2;

		 private movieVO movie1;
		 private movieVO movie2;
		 private int[] gm1;

	// 세션 접근을 위해 
	ActionContext context;
	Map<String,String> session;
	
	// 회원가입에 필요한 추가 변수
	private String memName,memGen,memFavor,memHp,
	memFavor1,memFavor2,memFavor3,memFavor4,memFavor5,memFavor6;
	public String[] idArray;
	public String[] nameArray;
	
	// 회원 찾기에 필요한 변수
	private String findType;
	private String resultStr;
	
	// 아이디 기억하기 쿠키 관련
	private String idRemember,ckId;
	private int isRemember=-1;
	HttpServletResponse res = (HttpServletResponse)ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
	HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
	Cookie c[] = null;

	// 쿠키관련 인터페이스 구현
	@Override
	public void setServletRequest(HttpServletRequest req) {
		// TODO Auto-generated method stub
		this.req=req;
	}

	@Override
	public void setServletResponse(HttpServletResponse res) {
		// TODO Auto-generated method stub
		this.res=res;
	}

	// constructor 생성자
	public LoginAction() throws IOException{
			reader = Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
	}

	// 로그인 폼 가기
	public String form() throws Exception {
		try {
			c = req.getCookies();
			for(int i=0; i<c.length; i++){
				if(c[i].getName().equals("idHolder")){
					ckId = c[i].getValue();
					isRemember = 1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return SUCCESS;
	}

	//메인 가기
	public String main() throws Exception{
		//게시판띄우기
				list_free = sqlMapper.queryForList("freeboardAllmain");
				list_spo = sqlMapper.queryForList("spoboardAllmain");
				
				if(list_free.size()<10)
					list_free=list_free;
				else
					list_free=list_free.subList(0, 10);
				if(list_spo.size()<10)
					list_spo=list_spo;
				else
					list_spo=list_spo.subList(0, 10);
				
				newsList = sqlMapper.queryForList("selectAll-news");
				
				if(newsList.size()<10)
					newsList=newsList;
				else
					newsList = newsList.subList(0, 10);
				
				int cutSize = 20;
				for(int i=0;i<newsList.size();i++) {
					newsVO nvo = (newsVO)newsList.get(i);
					if(nvo.getNEWS_SUBJECT().length() > 20) {
						nvo.setNEWS_SUBJECT(nvo.getNEWS_SUBJECT().substring(0, cutSize)+"...");
					}
				}
				
				movieList = sqlMapper.queryForList("mainSelectAll");
				
				movie1 = new movieVO();
				movie2 = new movieVO();
				
				int cnt=0;
				for (movieVO vo : movieList) {
					if(cnt==0)
						movie1 = vo;
					if(cnt==1)
						movie2 = vo;
					if(cnt==2)
						break;
					cnt++;
				}
				m1 = movie1.getMV_NO();
				s1 = movie1.getMV_SUBJECT();
				mavr1 = movie1.getMV_AVR();
				m2 = movie2.getMV_NO();
				s2 = movie2.getMV_SUBJECT();
				mavr2 = movie2.getMV_AVR();
				
				moviecommentList = sqlMapper.queryForList("movieCommentMain", movie1.getMV_NO());
				moviecommentList2 = sqlMapper.queryForList("movieCommentMain", movie2.getMV_NO());
				
				if(moviecommentList.size()<5)
					{moviecommentList=moviecommentList;}
				else
					{moviecommentList = moviecommentList.subList(0, 5);}
				
				if(moviecommentList2.size()<5)
					{moviecommentList2=moviecommentList2;}
				else
					{moviecommentList2 = moviecommentList2.subList(0, 5);}
				
				int cutSize2 = 18;
				for(int i=0;i<moviecommentList.size();i++) {
					moviecVO mcvo = (moviecVO)moviecommentList.get(i);
					if(mcvo.getMVC_CONTENT().length() > cutSize2) {
						mcvo.setMVC_CONTENT(mcvo.getMVC_CONTENT().substring(0, cutSize2)+"...");
					}
				}
				int cutSize3 = 18;
				for(int i=0;i<moviecommentList2.size();i++) {
					moviecVO mcvo2 = (moviecVO)moviecommentList2.get(i);
					if(mcvo2.getMVC_CONTENT().length() > cutSize2) {
						mcvo2.setMVC_CONTENT(mcvo2.getMVC_CONTENT().substring(0, cutSize2)+"...");
					}
				}
				
				goodList = sqlMapper.queryForList("goodMovie");
				gm1 = new int[goodList.size()];
				int i=0;
				for (movieVO vo : goodList) {
						gm1[i] = vo.getMV_NO();
						i++;				
				}
		
				
		return SUCCESS;
	}

	// 로그인 액션
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		resultClass = new memberVO();
		String tempId = getMemId();
		String tempPassword = getMemPw();
		// for session
		context = ActionContext.getContext();
		session =(Map<String,String>)context.getSession();
		
		try {
			resultClass = (memberVO) sqlMapper.queryForObject("selectPass", tempId);
		}catch (SQLException e) {
			e.printStackTrace();
			errorStr = "서버가 불안정 합니다.";
			return ERROR;
		}catch(Exception e) {
			e.printStackTrace();
			errorStr = "알 수 없는 오류";
			return ERROR;
		}
		
		if(resultClass!=null) {// resultClass에 값이 있으면 == 아이디에 맞는 비밀번호를 찾았으면
			
			// 입력한 비번과 가져온 비번 비교
			if(resultClass.getMemPw().equals(tempPassword)) {// 로그인 성공
				
				// 세션에 회원 번호, 아이디, 닉네임, 프사 이름 올리기
				String tempNo = String.valueOf(resultClass.getMemNo());
				session.put("mem_no", tempNo);
				session.put("mem_id", resultClass.getMemId());
				session.put("mem_name",resultClass.getMemName());
				session.put("mem_profile", resultClass.getMemProfilePhoto());
				
				context.setSession(session);
				
				// 쿠키전 관리자 설정 관리자는 쿠키를 가지면 안된다
				if(resultClass.getMemGrade()==99) {
					return LOGIN;
				}
				
				// 쿠키 설정
				if(getIdRemember()!=null) { // 체크박스를 눌럿을 때
					Cookie ck = new Cookie("idHolder", resultClass.getMemId());
					ck.setPath("/");
					ck.setMaxAge((1000 * 60) * 2);
					res.addCookie(ck);
				}else { // 체크박스를 누르지 않았을 때
					try {
						c = req.getCookies();
						for(int i=0; i<c.length; i++){
							if(c[i].getName().equals("idHolder")){
								Cookie delck = new Cookie("idHolder", "");
								delck.setPath("/");
								delck.setMaxAge(0);
								res.addCookie(delck);
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				return SUCCESS;
				
			}else {// 비밀번호 다름
				check = 0;// 0은 비밀번호 오류
				errorStr = "비밀번호 오류";
				return INPUT;
			}
		}else{// 없는 아이디
			check = 1; // 1은 아이디 오류
			errorStr = "아이디 오류";
			return INPUT;
		}
	}
	
	// 로그아웃
	@SuppressWarnings("unchecked")
	public String logout() throws Exception {
		// for session
		context = ActionContext.getContext();
		session =(Map<String,String>)context.getSession();
		
		if(session.get("mem_no")!=null) {
			session.remove("mem_no");
			session.remove("mem_id");
			session.remove("mem_name");
			session.remove("mem_profile");
		}
		context.setSession(session);
		return SUCCESS;
	}
	
	// 회원가입 폼
	public String join() throws Exception{
		list = sqlMapper.queryForList("memSelectAll");
		idArray = new String[list.size()];
		nameArray = new String[list.size()];
		int i = 0;
		for (memberVO vo : list) {
			idArray[i] = vo.getMemId();
			nameArray[i] = vo.getMemName();
			i++;
		}
		return SUCCESS;
	}
	
	// 회원가입 액션
	public String doJoin() throws Exception{
		paramClass = new memberVO();

		// 장르 선택 입력
		memFavor = "";
		int cnt = 0;
		String[] strArray = new String[6];
		if(getMemFavor1()!=null){cnt++; strArray[0]=getMemFavor1(); }
		if(getMemFavor2()!=null){cnt++; strArray[1]=getMemFavor2(); }
		if(getMemFavor3()!=null){cnt++; strArray[2]=getMemFavor3(); }
		if(getMemFavor4()!=null){cnt++; strArray[3]=getMemFavor4(); }
		if(getMemFavor5()!=null){cnt++; strArray[4]=getMemFavor5(); }
		if(getMemFavor6()!=null){cnt++; strArray[5]=getMemFavor6(); }
		for(int i=0;i<6;i++) {
			if(strArray[i]!=null) {
				memFavor += strArray[i];
				if(cnt>1) {
					memFavor+=",";
					cnt--;
				}
			}
		}

		paramClass.setMemId(getMemId());
		paramClass.setMemPw(getMemPw());
		paramClass.setMemName(getMemName());
		paramClass.setMemGen(Integer.parseInt(getMemGen()));
		paramClass.setMemFavor(memFavor);
		paramClass.setMemHp(getMemHp());
		
		try {
			sqlMapper.insert("joinSQL",paramClass);
		}catch (Exception e) {
			e.printStackTrace();
			errorStr = "입력 실패";
		}
		
		return SUCCESS;
	}
	
	// 회원 찾기 폼
	public String findForm() throws Exception{
		return SUCCESS;
	}
	
	// 회원 찾기 액션
	public String findAction() throws Exception{
		String typeIs= getFindType();
		paramClass = new memberVO();
		resultClass = new memberVO();
		paramClass.setMemHp(getMemHp());
		
		if(typeIs.equals("idFind")) {// 타입이 아이디이면
			paramClass.setMemName(getMemName());
			resultClass = (memberVO) sqlMapper.queryForObject("findId",paramClass);
			if(resultClass.getMemId()!=null) {
				resultStr = resultClass.getMemId();
			}else {
				resultStr = "아이디를 찾지 못했습니다.";
			}
		}else if(typeIs.equals("pwFind")) {
			paramClass.setMemId(getMemId());
			resultClass = (memberVO) sqlMapper.queryForObject("findPw",paramClass);
			if(resultClass.getMemPw()!=null) {
				resultStr = resultClass.getMemPw();
			}else {
				resultStr = "비밀번호를 찾지 못했습니다.";
			}
		}else {
			resultStr = "타입을 가져오지 못함";
		}
		
		return SUCCESS;
	}
	
	//관리자 페이지
	public String admin() throws Exception{
		return SUCCESS;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getErrorStr() {
		return errorStr;
	}

	public void setErrorStr(String errorStr) {
		this.errorStr = errorStr;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public memberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(memberVO paramClass) {
		this.paramClass = paramClass;
	}

	public memberVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(memberVO resultClass) {
		this.resultClass = resultClass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemGen() {
		return memGen;
	}

	public void setMemGen(String memGen) {
		this.memGen = memGen;
	}

	public String getMemFavor() {
		return memFavor;
	}

	public void setMemFavor(String memFavor) {
		this.memFavor = memFavor;
	}

	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

	public String getMemFavor1() {
		return memFavor1;
	}

	public void setMemFavor1(String memFavor1) {
		this.memFavor1 = memFavor1;
	}

	public String getMemFavor2() {
		return memFavor2;
	}

	public void setMemFavor2(String memFavor2) {
		this.memFavor2 = memFavor2;
	}

	public String getMemFavor3() {
		return memFavor3;
	}

	public void setMemFavor3(String memFavor3) {
		this.memFavor3 = memFavor3;
	}

	public String getMemFavor4() {
		return memFavor4;
	}

	public void setMemFavor4(String memFavor4) {
		this.memFavor4 = memFavor4;
	}

	public String getMemFavor5() {
		return memFavor5;
	}

	public void setMemFavor5(String memFavor5) {
		this.memFavor5 = memFavor5;
	}

	public String getMemFavor6() {
		return memFavor6;
	}

	public void setMemFavor6(String memFavor6) {
		this.memFavor6 = memFavor6;
	}

	public String getIdRemember() {
		return idRemember;
	}

	public void setIdRemember(String idRemember) {
		this.idRemember = idRemember;
	}

	public String getCkId() {
		return ckId;
	}

	public void setCkId(String ckId) {
		this.ckId = ckId;
	}

	public int getIsRemember() {
		return isRemember;
	}

	public void setIsRemember(int isRemember) {
		this.isRemember = isRemember;
	}


	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	public String getFindType() {
		return findType;
	}

	public void setFindType(String findType) {
		this.findType = findType;
	}

	public List<memberVO> getList() {
		return list;
	}

	

	public String[] getIdArray() {
		return idArray;
	}

	public void setIdArray(String[] idArray) {
		this.idArray = idArray;
	}

	public String[] getNameArray() {
		return nameArray;
	}

	public void setNameArray(String[] nameArray) {
		this.nameArray = nameArray;
	}

	public static Reader getReader() {
		return reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}

	public int getNum() {
		return num;
	}

	

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public PagingAction getPage() {
		return page;
	}

	public List<newsVO> getNewsList() {
		return newsList;
	}

	public int getCurrentPage2() {
		return currentPage2;
	}

	public int getTotalCount2() {
		return totalCount2;
	}

	public int getBlockCount2() {
		return blockCount2;
	}

	public int getBlockPage2() {
		return blockPage2;
	}

	public pagingAction7 getPage2() {
		return page2;
	}

	public String getPageHtml() {
		return pageHtml;
	}

	public int getNum2() {
		return num2;
	}

	public int getCnt() {
		return cnt;
	}

	public ActionContext getContext() {
		return context;
	}

	public Map<String, String> getSession() {
		return session;
	}

	public HttpServletResponse getRes() {
		return res;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public Cookie[] getC() {
		return c;
	}

	public static void setReader(Reader reader) {
		LoginAction.reader = reader;
	}

	public static void setSqlMapper(SqlMapClient sqlMapper) {
		LoginAction.sqlMapper = sqlMapper;
	}

	public void setNum(int num) {
		this.num = num;
	}



	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	public void setPage(PagingAction page) {
		this.page = page;
	}

	public void setNewsList(List<newsVO> newsList) {
		this.newsList = newsList;
	}

	public void setCurrentPage2(int currentPage2) {
		this.currentPage2 = currentPage2;
	}

	public void setTotalCount2(int totalCount2) {
		this.totalCount2 = totalCount2;
	}

	public void setBlockCount2(int blockCount2) {
		this.blockCount2 = blockCount2;
	}

	public void setBlockPage2(int blockPage2) {
		this.blockPage2 = blockPage2;
	}

	public void setPage2(pagingAction7 page2) {
		this.page2 = page2;
	}

	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public void setContext(ActionContext context) {
		this.context = context;
	}

	public void setSession(Map<String, String> session) {
		this.session = session;
	}

	public void setRes(HttpServletResponse res) {
		this.res = res;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public void setC(Cookie[] c) {
		this.c = c;
	}

	

	public void setList(List<memberVO> list) {
		this.list = list;
	}

	public List<BoardVO> getList_free() {
		return list_free;
	}

	public void setList_free(List<BoardVO> list_free) {
		this.list_free = list_free;
	}

	public List<BoardVO> getList_spo() {
		return list_spo;
	}

	public void setList_spo(List<BoardVO> list_spo) {
		this.list_spo = list_spo;
	}
	public List<movieVO> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<movieVO> movieList) {
		this.movieList = movieList;
	}
	

	public List<moviecVO> getMoviecommentList() {
		return moviecommentList;
	}

	public void setMoviecommentList(List<moviecVO> moviecommentList) {
		this.moviecommentList = moviecommentList;
	}

	public moviecVO getMainComment() {
		return mainComment;
	}

	public void setMainComment(moviecVO mainComment) {
		this.mainComment = mainComment;
	}
	public movieVO getMovie1() {
		return movie1;
	}

	public void setMovie1(movieVO movie1) {
		this.movie1 = movie1;
	}

	public movieVO getMovie2() {
		return movie2;
	}

	public void setMovie2(movieVO movie2) {
		this.movie2 = movie2;
	}

	public List<moviecVO> getMoviecommentList2() {
		return moviecommentList2;
	}

	public void setMoviecommentList2(List<moviecVO> moviecommentList2) {
		this.moviecommentList2 = moviecommentList2;
	}

	public int getM1() {
		return m1;
	}

	public void setM1(int m1) {
		this.m1 = m1;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public double getMavr1() {
		return mavr1;
	}

	public void setMavr1(double mavr1) {
		this.mavr1 = mavr1;
	}

	public double getMavr2() {
		return mavr2;
	}

	public void setMavr2(double mavr2) {
		this.mavr2 = mavr2;
	}

	public List<movieVO> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<movieVO> goodList) {
		this.goodList = goodList;
	}

	public int[] getGm1() {
		return gm1;
	}

	public void setGm1(int[] gm1) {
		this.gm1 = gm1;
	}

	
	
	
	
	
}
