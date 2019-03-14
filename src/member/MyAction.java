package member;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import admin.adminMVVO;
import movie.movieVO;
import member.AllFilePath;

public class MyAction extends ActionSupport {
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private memberVO paramClass;
	private memberVO resultClass;
	private StringTokenizer mvst;
	private List<adminMVVO> mvList = new ArrayList<adminMVVO>();
	private List<memberLikeVO> mlList = new ArrayList<memberLikeVO>();
	private String[] fullLike;
	private String[] shortLike;

	// 세션 접근을 위해
	ActionContext context;
	Map<String, String> session;
	// 멤버 수정을 위해
	private int memNo;
	private String oldProfile;
	private String memPw;
	private String memFavor, memHp, memFavor1, memFavor2, memFavor3, memFavor4, memFavor5, memFavor6, checker1,
			checker2, checker3, checker4, checker5, checker6;
	// 파일 업로드용
	private File upload; // 업로드 받기
	private String uploadContentType; // 업로드 확장자
	private String uploadFileName; // 업로드할 네임
	private String fileUploadPath = AllFilePath.forprofile; // 경로

	public MyAction() throws IOException {
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();
	}

	// 마이페이지 접근
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		resultClass = new memberVO();
		// for session
		context = ActionContext.getContext();
		session = (Map<String, String>) context.getSession();

		// 멤버 하나 가져옴
		int memNo = Integer.parseInt(session.get("mem_no"));
		resultClass = (memberVO) sqlMapper.queryForObject("mem-select-one", memNo);

		// 멤버의 관심있는 영화 토크나이저 하기 및 리스트에 넣기
		/*if (resultClass.getMemLike() != null) {// 관심있는 영화가 있으면
			mvst = new StringTokenizer(resultClass.getMemLike(), ",");
			mvList = mvListgetter(mvst, 1);
		}*/
		
		// 멤버의 관심있는 영화 리스트에 넣기
		mlList = sqlMapper.queryForList("mem-like-byNo", memNo);
		if (mlList.size() > 0) {
			int cnt=0;
			for (memberLikeVO vo : mlList) {
				if(cnt++>3) {break;}
				adminMVVO mvo = new adminMVVO();
				mvo = (adminMVVO) sqlMapper.queryForObject("adminMvOne", vo.getMv_no());
				mvList.add(mvo);
			}
		}

		return SUCCESS;
	}

	// 관심있는 영화 더 보기
	@SuppressWarnings("unchecked")
	public String moreLike() throws Exception {
		resultClass = new memberVO();
		// for session
		context = ActionContext.getContext();
		session = (Map<String, String>) context.getSession();

		// 멤버 하나 가져옴
		int memNo = Integer.parseInt(session.get("mem_no"));
		resultClass = (memberVO) sqlMapper.queryForObject("mem-select-one", memNo);

		/*mvst = new StringTokenizer(resultClass.getMemLike(), ",");
		mvList = mvListgetter(mvst, 2);*/
		
		// 관심있는 영화 모두 가져오기
		mlList = sqlMapper.queryForList("mem-like-byNo", memNo);
		if (mlList.size() > 0) {
			for (memberLikeVO vo : mlList) {
				adminMVVO mvo = new adminMVVO();
				mvo = (adminMVVO) sqlMapper.queryForObject("adminMvOne", vo.getMv_no());
				mvList.add(mvo);
			}
		}

		return SUCCESS;
	}

	// 회원 정보 수정 폼
	public String myModifyForm() throws Exception {
		resultClass = new memberVO();
		// for session
		context = ActionContext.getContext();
		session = (Map<String, String>) context.getSession();

		// 멤버 하나 가져옴
		int memNo = Integer.parseInt(session.get("mem_no"));
		resultClass = (memberVO) sqlMapper.queryForObject("mem-select-one", memNo);

		// 멤버 취향 분리해서 적용시키기
		if (resultClass.getMemFavor() != null) {
			StringTokenizer st = new StringTokenizer(resultClass.getMemFavor(), ",");
			while (st.hasMoreTokens()) {
				// 숫자화
				int j = Integer.parseInt(st.nextToken());
				// 이프문
				if (j == 1)
					checker1 = "checked='checked'";
				if (j == 2)
					checker2 = "checked='checked'";
				if (j == 3)
					checker3 = "checked='checked'";
				if (j == 4)
					checker4 = "checked='checked'";
				if (j == 5)
					checker5 = "checked='checked'";
				if (j == 6)
					checker6 = "checked='checked'";
			}
		}

		return SUCCESS;
	}

	// 회원 정보 수정 액션
	public String myModifyAction() throws Exception {
		paramClass = new memberVO();

		// 장르 선택 입력
		memFavor = "";
		int cnt = 0;
		String[] strArray = new String[6];
		if (getMemFavor1() != null) {cnt++;strArray[0] = getMemFavor1();}
		if (getMemFavor2() != null) {cnt++;strArray[1] = getMemFavor2();}
		if (getMemFavor3() != null) {cnt++;strArray[2] = getMemFavor3();}
		if (getMemFavor4() != null) {cnt++;strArray[3] = getMemFavor4();}
		if (getMemFavor5() != null) {cnt++;strArray[4] = getMemFavor5();}
		if (getMemFavor6() != null) {cnt++;strArray[5] = getMemFavor6();}
		for (int i = 0; i < 6; i++) {
			if (strArray[i] != null) {
				memFavor += strArray[i];
				if (cnt > 1) {
					memFavor += ",";
					cnt--;
				}
			}
		}
		paramClass.setMemFavor(memFavor);
		paramClass.setMemNo(getMemNo());
		paramClass.setMemHp(getMemHp());
		sqlMapper.update("mem-basic-update",paramClass);
		
		// 비밀번호 업데이트 여부
		if(getMemPw()!=null && !(getMemPw().equals(""))) {
			paramClass.setMemPw(getMemPw());
			sqlMapper.update("mem-pass-update",paramClass);
		}
		
		// 프로필 업데이트 여부
		if(getUpload() != null) {
			String file_name = "profile_"+getMemNo();
			String file_ext = getUploadFileName().substring(getUploadFileName().lastIndexOf('.')+1,
					getUploadFileName().length());
			
			// 전 프로필 삭제
			File deleteFile = new File(fileUploadPath + "profile"+getOldProfile());
			deleteFile.delete();
			// 새 파일 생성
			File destFile = new File(fileUploadPath + file_name + "." + file_ext);
			FileUtils.copyFile(getUpload(), destFile);
			// 디비전송
			paramClass.setMemProfilePhoto(file_name+"."+file_ext);
			sqlMapper.update("mem-profile-update",paramClass);
			
			session.put("mem_profile", paramClass.getMemProfilePhoto());
			context.setSession(session);
			
		}
		

		return SUCCESS;
	}

	// 토크나이저와 상태를 받아 리스트를 반환해주는 메소드
	public List<movieVO> mvListgetter(StringTokenizer st, int status) throws SQLException {
		// status== 1-4개 보여줄 어레이 리스트, 2-전부 보여줄 어레이 리스트
		List<movieVO> arraylist = new ArrayList<movieVO>();

		for (int i = 0; i < st.countTokens(); i++) {
			movieVO vo = new movieVO();
			int mvNo = Integer.parseInt(st.nextToken());
			// 하나하나 검색해서 리스트에 담는다
			vo = (movieVO) sqlMapper.queryForObject("adminMvOne", mvNo);
			arraylist.add(vo);
			// 조건
			if (status == 1 && i == 3)
				break;
		}
		return arraylist;
	}
	// 회원 탈퇴 액션
	public String myMemQuitAction() throws Exception{
		// for session
		context = ActionContext.getContext();
		session = (Map<String, String>) context.getSession();
		
		// 회원 삭제
		int memNo = Integer.parseInt(session.get("mem_no"));
		sqlMapper.delete("adminMemDel",memNo);
		
		// 회원 로그아웃 시키기
		if(session.get("mem_no")!=null) {
			session.remove("mem_no");
			session.remove("mem_id");
			session.remove("mem_name");
			session.remove("mem_profile");
		}
		context.setSession(session);
		
		return SUCCESS;
	}
	// 히스토리 보기
	public String history() throws Exception{
		
		return SUCCESS;
	}

	// getset

	public memberVO getResultClass() {
		return resultClass;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
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

	public memberVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(memberVO paramClass) {
		this.paramClass = paramClass;
	}

	public void setResultClass(memberVO resultClass) {
		this.resultClass = resultClass;
	}

	public StringTokenizer getMvst() {
		return mvst;
	}

	public void setMvst(StringTokenizer mvst) {
		this.mvst = mvst;
	}

	public List<adminMVVO> getMvList() {
		return mvList;
	}

	public void setMvList(List<adminMVVO> mvList) {
		this.mvList = mvList;
	}

	public String[] getFullLike() {
		return fullLike;
	}

	public void setFullLike(String[] fullLike) {
		this.fullLike = fullLike;
	}

	public String[] getShortLike() {
		return shortLike;
	}

	public void setShortLike(String[] shortLike) {
		this.shortLike = shortLike;
	}

	public ActionContext getContext() {
		return context;
	}

	public void setContext(ActionContext context) {
		this.context = context;
	}

	public Map<String, String> getSession() {
		return session;
	}

	public void setSession(Map<String, String> session) {
		this.session = session;
	}

	public String getChecker1() {
		return checker1;
	}

	public void setChecker1(String checker1) {
		this.checker1 = checker1;
	}

	public String getChecker2() {
		return checker2;
	}

	public void setChecker2(String checker2) {
		this.checker2 = checker2;
	}

	public String getChecker3() {
		return checker3;
	}

	public void setChecker3(String checker3) {
		this.checker3 = checker3;
	}

	public String getChecker4() {
		return checker4;
	}

	public void setChecker4(String checker4) {
		this.checker4 = checker4;
	}

	public String getChecker5() {
		return checker5;
	}

	public void setChecker5(String checker5) {
		this.checker5 = checker5;
	}

	public String getChecker6() {
		return checker6;
	}

	public void setChecker6(String checker6) {
		this.checker6 = checker6;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getFileUploadPath() {
		return fileUploadPath;
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public String getOldProfile() {
		return oldProfile;
	}

	public void setOldProfile(String oldProfile) {
		this.oldProfile = oldProfile;
	}
}
