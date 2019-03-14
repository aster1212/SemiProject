package movie;

public class nowMoviePagingAction {

	private int currentPage;   // 현재페이지
	private int totalCount;	 // 전체 게시물 수
	private int totalPage;	 // 전체 페이지 수
	private int blockCount;	 // 한 페이지의  게시물의 수
	private int blockPage;	 // 한 화면에 보여줄 페이지 수
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private int startPage;	 // 시작 페이지
	private int endPage;	 // 마지막 페이지
	private String search;
	private String MV_GENRE;
	private int MV_TYPE;
	private StringBuffer pagingHtml;	//연산된 모든결과는 StringBuffer에 넣어줄것 : 그냥 jsp에 넣을 페이징 코드를 여기에 떄려박음
	private int MV_STATE;
	// 페이징 생성자
	
	//추가하기 -mv_state
	public nowMoviePagingAction(int currentPage, int totalCount, int blockCount,
			int blockPage, String search, String MV_GENRE, int MV_TYPE, int MV_STATE) {

		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.search = search;
		this.MV_GENRE = MV_GENRE;
		this.MV_TYPE = MV_TYPE;
		this.MV_STATE = MV_STATE;
		
		// 전체 페이지 수 = 전체게시물수 / 한 페이지에 보여줄 게시물 수
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// 현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// 현재 페이지의 처음과 마지막 글의 번호 가져오기.
		//한 페이지의 시작 게시물 번호 = (현재 페이지-1) * 한페이지 게시물 수(10)
		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount - 1;
		//마지막 게시물 번호 = 시작 게시물 번호 + 한페이지 게시물(10-1) 


		// 시작 페이지와 마지막 페이지 값 구하기.
							//1~10까지는 무조건 0이 나오는 로직
							//11~20이면 11~20(게시물 수) 출력
							//21~30 이면 21~30
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;
				
		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// 이전 block 페이지
		pagingHtml = new StringBuffer();
		
		//일반 리스트
		if (currentPage > blockPage) {
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (startPage - 1) +"&MV_TYPE="+getMV_TYPE()+">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		
		//일반리스트에서 검색어만 입력된경우
		}else if(currentPage > blockPage && search!=null) {
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (startPage - 1)+"&search="+getSearch()+"&MV_TYPE="+getMV_TYPE()+">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		
		//장르만 선택된 경우
		}else if(currentPage > blockPage && MV_GENRE!=null){
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (startPage - 1)+"&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE()+">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		//검색어 + 장르가 입력된 경우
		}else if(currentPage > blockPage && search!=null && MV_GENRE!=null) {
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (startPage - 1)+"&search="+getSearch()+"&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE()+">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		}else if(currentPage > blockPage && MV_GENRE !=null && MV_STATE!=0){
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (startPage - 1)+"&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE()+"&MV_STATE="+getMV_STATE()+">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		}else if(currentPage > blockPage && MV_GENRE ==null && MV_STATE!=0) {
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (startPage - 1)+"&MV_TYPE="+getMV_TYPE()+"&MV_STATE="+getMV_STATE()+">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		}

		pagingHtml.append("&nbsp;|&nbsp;");

		
		
		
		
		
		
			for (int i = startPage; i <= endPage; i++) {
				if (i > totalPage) {
					break;
				}		
				
				if (i == currentPage) {
					pagingHtml.append("&nbsp;<b> <font color='red'>");
					pagingHtml.append(i);
					pagingHtml.append("</font></b>");
				}else {
					//장르만 입력된 경우
					if(MV_GENRE!=null && search == null) {
					pagingHtml.append("&nbsp;<a href='npMovieList.action?currentPage=");
					pagingHtml.append(i);
					pagingHtml.append("&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE());
					pagingHtml.append("'>");
					pagingHtml.append(i);
					pagingHtml.append("</a>");
					}else if(MV_GENRE==null && search != null) {
						pagingHtml.append("&nbsp;<a href='npMovieList.action?currentPage=");
						pagingHtml.append(i);
						pagingHtml.append("&search="+getSearch()+"&MV_TYPE="+getMV_TYPE());
						pagingHtml.append("'>");
						pagingHtml.append(i);
						pagingHtml.append("</a>");
					}else if(MV_GENRE != null && search != null) {
						pagingHtml.append("&nbsp;<a href='npMovieList.action?currentPage=");
						pagingHtml.append(i);
						pagingHtml.append("&search="+getSearch());
						pagingHtml.append("&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE());
						pagingHtml.append("'>");
						pagingHtml.append(i);
						pagingHtml.append("</a>");
					}else if(MV_GENRE ==null && search==null){
						pagingHtml.append("&nbsp;<a href='npMovieList.action?currentPage=");
						pagingHtml.append(i);
						pagingHtml.append("&MV_TYPE="+getMV_TYPE());
						pagingHtml.append("'>");
						pagingHtml.append(i);
						pagingHtml.append("</a>");
					}else if(MV_GENRE !=null && MV_STATE!=0){
						pagingHtml.append("&nbsp;<a href='npMovieList.action?currentPage=");
						pagingHtml.append(i);
						pagingHtml.append("&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE()+"&MV_STATE="+getMV_STATE());
						pagingHtml.append("'>");
						pagingHtml.append(i);
						pagingHtml.append("</a>");
					}else if(MV_GENRE ==null && MV_STATE!=0){
						pagingHtml.append("&nbsp;<a href='npMovieList.action?currentPage=");
						pagingHtml.append(i);
						pagingHtml.append("&MV_TYPE="+getMV_TYPE()+"&MV_STATE="+getMV_STATE());
						pagingHtml.append("'>");
						pagingHtml.append(i);
						pagingHtml.append("</a>");
					}
					pagingHtml.append("&nbsp;");
				}
				pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");
			}

		//페이지 번호.현재 페이지는 빨간색으로 강조하고 링크를 제거.
		
		//일반리스트의 "다음"
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (endPage + 1) + ">");
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		//검색어가 있을경우
		}else if(totalPage - startPage >= blockPage && search!=null) {
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (endPage + 1)+getSearch()+"&MV_TYPE="+getMV_TYPE()+ ">");
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		}else if(totalPage - startPage >= blockPage && search!=null && MV_GENRE!=null) {
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (endPage + 1)+getSearch()+"&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE()+">");
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		}else if(totalPage - startPage >= blockPage && MV_GENRE!=null) {
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (endPage + 1)+"&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE()+">");
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		}else if(totalPage - startPage >= blockPage && MV_GENRE !=null && MV_STATE!=0){
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (endPage + 1)+"&MV_GENRE="+getMV_GENRE()+"&MV_TYPE="+getMV_TYPE()+"&MV_STATE="+getMV_STATE()+">");
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		}else if(totalPage - startPage >= blockPage && MV_GENRE ==null && MV_STATE!=0){
			pagingHtml.append("<a href=npMovieList.action?currentPage="
					+ (endPage + 1)+"&MV_TYPE="+getMV_TYPE()+"&MV_STATE="+getMV_STATE()+">");
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		}
	}
	
	
	public int getMV_STATE() {
		return MV_STATE;
	}




	public void setMV_STATE(int mV_STATE) {
		MV_STATE = mV_STATE;
	}




	public String getMV_GENRE() {
		return MV_GENRE;
	}
	public int getMV_TYPE() {
		return MV_TYPE;
	}

	public void setMV_TYPE(int mV_TYPE) {
		MV_TYPE = mV_TYPE;
	}

	public void setMV_GENRE(String mV_GENRE) {
		MV_GENRE = mV_GENRE;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public int getStartCount() {
		return startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public String getSearch() {
		return search;
	}

	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setPagingHtml(StringBuffer pagingHtml) {
		this.pagingHtml = pagingHtml;
	}

	
}