package news;

// 페이징
public class pagingAction7 {


	private int currentPage;   // 현재페이지
	private int totalCount;	 // 전체 게시물 수
	private int totalPage;	 // 전체 페이지 수
	private int blockCount;	 // 한 페이지의  게시물의 수
	private int blockPage;	 // 한 화면에 보여줄 페이지 수
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private int startPage;	 // 시작 페이지
	private int endPage;	 // 마지막 페이지
	private StringBuffer pageHtml;
	
	public pagingAction7(int currentPage, int totalCount, int blockCount, int blockPage){
		
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		
		
		// 전체 페이지 수
		totalPage = (int)Math.ceil((double)totalCount / blockCount);
		if(totalPage == 0){
			totalPage = 1;
		}
		
		// 현재페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		
		// 현재 페이지의 처음과 마지막 글의 번호 가져오기
		startCount = (currentPage - 1) * blockPage;
		endCount = startCount + blockPage - 1;
		
		// 시작 페이지와 마지막 페이지 값 구하기
		startPage = (int)((currentPage -1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;
		
		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if(endPage > totalPage){
			endPage = totalPage;
		}
		
		// 페이지 번호, 현재 페이지는 다르게 표시
		pageHtml = new StringBuffer();
		for(int i = startPage; i <= endPage; i++){
			if(i > totalPage){
				break;
			}
			if (i == currentPage) {
				
				pageHtml.append("&nbsp;<b> <font color='red'>");
				pageHtml.append(i);
				pageHtml.append("</font></b>");
			} else {
				pageHtml
						.append("&nbsp;<a href='news7List.action?currentPage=");
				pageHtml.append(i);
				pageHtml.append("'>");
				pageHtml.append(i);
				pageHtml.append("</a>");
			}

			pageHtml.append("&nbsp;");
		}
		
		// 다음 block 페이지
		if(totalPage - startPage >= blockPage){
			pageHtml.append("<a class='page prv' href='news7List.action?currentPage=" + (endPage + 1));
			pageHtml.append("다음");
			pageHtml.append("</a>");
		}
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getStartCount() {
		return startCount;
	}
	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}
	public int getEndCount() {
		return endCount;
	}
	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public StringBuffer getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(StringBuffer pageHtml) {
		this.pageHtml = pageHtml;
	}
	
}
