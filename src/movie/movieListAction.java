package movie;

import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
 
import java.util.*;
import java.io.Reader;
import java.io.IOException;

import movie.moviePagingAction;
import movie.movieVO;
import java.util.Date;

public class movieListAction extends ActionSupport{

	private Date MV_DATE;

	private int MV_TYPE; //무비타입,kdd
	
	public static Reader reader;
	public static SqlMapClient sqlMapper;

	private List<movieVO> list = new ArrayList<movieVO>();

	private List<movieVO> searchList = new ArrayList<movieVO>();
	
	private movieVO paramClass = new movieVO();
	private movieVO resultClass = new movieVO();
   
			//영화별 국가 기본값 =0
	private int MV_STATE=0;
	private int currentPage =1;
	private int totalCount;
	private int blockCount = 12;//한페이지의 게시물의 수
	private int blockPage=5; //한 화면에 보여줄 페이지 수
	private String pagingHtml;//페이징을 구현한 HTML
	private moviePagingAction page; //페이징 클래스
	private nowMoviePagingAction page2;
	private comingMoviePagingAction page3;
	
	private String[] MV_GENRE;
	
	private String MV_GENRE1;
	private String search;	//검색어
	

	//생성자 
	public movieListAction() throws IOException{
					//DB컨넥션 관련 내용으 가져옴
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		reader.close();

	}
	
	//영화메인 - 모든 영화(상영중, 상영종료, 상영예정 리스트 호출)
	public String execute() throws Exception{ 
		if(getSearch()!=null) {
			return search();
		}

			list = sqlMapper.queryForList("movieAll");
		
			totalCount = list.size(); //전체 글의 개수 구하기
			
			page = new moviePagingAction(currentPage, totalCount, blockCount, blockPage, search, MV_GENRE1, MV_TYPE, MV_STATE);
			//여기서 받은 객체값을 이용해 pagingAction bean 객체 값을 받아감

			pagingHtml = page.getPagingHtml().toString();
			//현재 페이지에서 보여줄 마지막 글의 번호 설정
			int lastCount = totalCount;

			if(page.getEndCount() < totalCount) 
				lastCount = page.getEndCount() +1;

			list = list.subList(page.getStartCount(), lastCount);
			//전체 리스트에서 현재 페이지 만큼의 리스트만 가져옴

			return SUCCESS;
		}


	//상영종료 영화리스트
		public String execute1() throws Exception{ 
			if(getSearch()!=null) { 
				return search();
			}
			
			//장르만 선택되었을 때
			if(getMV_GENRE()!=null && getMV_STATE()==0) {
				
				
				String gen = arrayJoin(",", getMV_GENRE());
				
				paramClass.setMV_GENRE("%"+gen+"%");
				paramClass.setMV_TYPE(3);
						
				list = sqlMapper.queryForList("selectGenre", paramClass);
				
				totalCount = list.size(); //전체 글의 개수 구하기
				page = new moviePagingAction(currentPage, totalCount, blockCount, blockPage, search, gen, MV_TYPE, MV_STATE);
				pagingHtml = page.getPagingHtml().toString();
				int lastCount = totalCount;
				
				if(page.getEndCount() < totalCount) 
					lastCount = page.getEndCount() +1;
				
				list = list.subList(page.getStartCount(), lastCount);
			
				return SUCCESS;
				
			//장르 + 국가 선택시
			}else if(getMV_STATE()!=0 && getMV_GENRE()!=null) {
				
				String gen = arrayJoin(",", getMV_GENRE());				
				paramClass.setMV_GENRE("%"+gen+"%");
				paramClass.setMV_TYPE(3);
				paramClass.setMV_STATE(getMV_STATE());
				
				list = sqlMapper.queryForList("selectStateByGenre", paramClass);
				
				totalCount = list.size(); //전체 글의 개수 구하기

				page = new moviePagingAction(currentPage, totalCount, blockCount, blockPage, search, gen, MV_TYPE, MV_STATE);
				//여기서 받은 객체값을 이용해 pagingAction bean 객체 값을 받아감

				pagingHtml = page.getPagingHtml().toString();
		
				//현재 페이지에서 보여줄 마지막 글의 번호 설정
				int lastCount = totalCount;

				if(page.getEndCount() < totalCount) 
					lastCount = page.getEndCount() +1;

				list = list.subList(page.getStartCount(), lastCount);
				//전체 리스트에서 현재 페이지 만큼의 리스트만 가져옴
		
					return SUCCESS;
					
				//국가만 선택시
			}else if(getMV_STATE()!=0 && getMV_GENRE()==null) {
				
				paramClass.setMV_TYPE(3);
				paramClass.setMV_STATE(getMV_STATE());
				/*resultClass.setMV_GENRE(getMV_GENRE());*/
				
				list = sqlMapper.queryForList("selectState", paramClass);
				
				totalCount = list.size(); //전체 글의 개수 구하기

				page = new moviePagingAction(currentPage, totalCount, blockCount, blockPage, search,MV_GENRE1, MV_TYPE, MV_STATE);
				//여기서 받은 객체값을 이용해 pagingAction bean 객체 값을 받아감

				pagingHtml = page.getPagingHtml().toString();
				//현재 페이지에서 보여줄 마지막 글의 번호 설정
				int lastCount = totalCount;

				if(page.getEndCount() < totalCount) 
					lastCount = page.getEndCount() +1;

				list = list.subList(page.getStartCount(), lastCount);
				//전체 리스트에서 현재 페이지 만큼의 리스트만 가져옴
		
					return SUCCESS;
				//일반리스트
			}else {
				
				list = sqlMapper.queryForList("movieTypeBy",3);
				
				totalCount = list.size(); //전체 글의 개수 구하기

				page = new moviePagingAction(currentPage, totalCount, blockCount, blockPage, search, MV_GENRE1,MV_TYPE, MV_STATE);
				//여기서 받은 객체값을 이용해 pagingAction bean 객체 값을 받아감

				pagingHtml = page.getPagingHtml().toString();
				//현재 페이지에서 보여줄 마지막 글의 번호 설정
				int lastCount = totalCount;

				if(page.getEndCount() < totalCount) 
					lastCount = page.getEndCount() +1;
				
				list = list.subList(page.getStartCount(), lastCount);
				//전체 리스트에서 현재 페이지 만큼의 리스트만 가져옴
				
				return SUCCESS;
			}
			
			}
		
	//상영중영화리스트 - 평점순 정렬
	public String execute2() throws Exception{ 
	
			list = sqlMapper.queryForList("movieTypeBy",2);
			
			totalCount = list.size(); //전체 글의 개수 구하기
			page2 = new nowMoviePagingAction(currentPage, totalCount, blockCount, blockPage, search, MV_GENRE1, 2, MV_STATE);
			pagingHtml = page2.getPagingHtml().toString();
			int lastCount = totalCount;
			
			if(page2.getEndCount() < totalCount) 
				lastCount = page2.getEndCount() +1;
			
			list = list.subList(page2.getStartCount(), lastCount);
		
			return SUCCESS;	
	}
	
	
	//상영예정리스트
	public String execute3() throws Exception{ 
		
			
			list = sqlMapper.queryForList("movieTypeBy", 1);
			
			totalCount = list.size(); //전체 글의 개수 구하기
			page3 = new comingMoviePagingAction(currentPage, totalCount, blockCount, blockPage, search, MV_GENRE1, 1, MV_STATE);
			pagingHtml = page3.getPagingHtml().toString();
			int lastCount = totalCount;
			
			if(page3.getEndCount() < totalCount) 
				lastCount = page3.getEndCount() +1;
			
			list = list.subList(page3.getStartCount(), lastCount);
		
			return SUCCESS;
	}
	
	
	
	//영화검색로직
		public String search() throws Exception{
			
			
			if(getMV_GENRE()!=null && getMV_TYPE()!=0) {
				String gen = arrayJoin(",", getMV_GENRE());				
				paramClass.setSearch("%"+getSearch()+"%");
				paramClass.setMV_GENRE(getMV_GENRE1());
				paramClass.setMV_TYPE(getMV_TYPE());

				list = sqlMapper.queryForList("searchMovieByGenre", paramClass);
				
				totalCount = list.size();
				page = new moviePagingAction(currentPage, totalCount, blockCount, blockPage, search, gen, MV_TYPE, MV_STATE);
				pagingHtml = page.getPagingHtml().toString();
				
				int lastCount = totalCount;
				
				if(page.getEndCount() < totalCount)
					lastCount = page.getEndCount() + 1;
				
				list = list.subList(page.getStartCount(), lastCount);
				return SUCCESS;
			}
			
			paramClass.setMV_TYPE(getMV_TYPE());
			paramClass.setSearch("%"+search+"%");
			
			list = sqlMapper.queryForList("searchMovie", paramClass);
			
			totalCount = list.size();
			page = new moviePagingAction(currentPage, totalCount, blockCount, blockPage, search, MV_GENRE1, MV_TYPE, MV_STATE);
			pagingHtml = page.getPagingHtml().toString();
			
			int lastCount = totalCount;
			
			if(page.getEndCount() < totalCount)
				lastCount = page.getEndCount() + 1;
			
			list = list.subList(page.getStartCount(), lastCount);
			return SUCCESS;
	
		}
		
		
		  public static String arrayJoin(String glue, String array[]) {
			    String result = "";

			    for (int i = 0; i < array.length; i++) {
			      result += array[i];
			      if (i < array.length - 1) result += glue;
			    }
			    return result;
			  }


	
	

		public int getMV_STATE() {
			return MV_STATE;
		}

		public void setMV_STATE(int mV_STATE) {
			MV_STATE = mV_STATE;
		}

		public movieVO getParamClass() {
			return paramClass;
		}

		public int getMV_TYPE() {
			return MV_TYPE;
		}

		public void setParamClass(movieVO paramClass) {
			this.paramClass = paramClass;
		}

		public void setMV_TYPE(int mV_TYPE) {
			MV_TYPE = mV_TYPE;
		}

		public Date getMV_DATE() {
			return MV_DATE;
		}

		public void setMV_DATE(Date mV_DATE) {
			MV_DATE = mV_DATE;
		}

		
	

		public String[] getMV_GENRE() {
			return MV_GENRE;
		}

		public String getMV_GENRE1() {
			return MV_GENRE1;
		}

		public void setMV_GENRE(String[] mV_GENRE) {
			MV_GENRE = mV_GENRE;
		}

		public void setMV_GENRE1(String mV_GENRE1) {
			MV_GENRE1 = mV_GENRE1;
		}

		public movieVO getResultClass() {
			return resultClass;
		}

	

		public void setResultClass(movieVO resultClass) {
			this.resultClass = resultClass;
		}

		public List<movieVO> getList() {
			return list;
		}

		public List<movieVO> getSearchList() {
			return searchList;
		}

		public static void setReader(Reader reader) {
			movieListAction.reader = reader;
		}

		public static void setSqlMapper(SqlMapClient sqlMapper) {
			movieListAction.sqlMapper = sqlMapper;
		}

		public void setList(List<movieVO> list) {
			this.list = list;
		}

		public void setSearchList(List<movieVO> searchList) {
			this.searchList = searchList;
		}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public static Reader getReader() {
		return reader;
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
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

	public moviePagingAction getPage() {
		return page;
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

	public void setPage(moviePagingAction page) {
		this.page = page;
	}



	}

