package news;

// ����¡
public class pagingAction365 {


	private int currentPage;   // ����������
	private int totalCount;	 // ��ü �Խù� ��
	private int totalPage;	 // ��ü ������ ��
	private int blockCount;	 // �� ��������  �Խù��� ��
	private int blockPage;	 // �� ȭ�鿡 ������ ������ ��
	private int startCount;	 // �� ���������� ������ �Խñ��� ���� ��ȣ
	private int endCount;	 // �� ���������� ������ �Խñ��� �� ��ȣ
	private int startPage;	 // ���� ������
	private int endPage;	 // ������ ������
	private StringBuffer pageHtml;
	
	public pagingAction365(int currentPage, int totalCount, int blockCount, int blockPage){
		
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		
		
		// ��ü ������ ��
		totalPage = (int)Math.ceil((double)totalCount / blockCount);
		if(totalPage == 0){
			totalPage = 1;
		}
		
		// ������������ ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if(currentPage > totalPage){
			currentPage = totalPage;
		}
		
		// ���� �������� ó���� ������ ���� ��ȣ ��������
		startCount = (currentPage - 1) * blockPage;
		endCount = startCount + blockPage - 1;
		
		// ���� �������� ������ ������ �� ���ϱ�
		startPage = (int)((currentPage -1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;
		
		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if(endPage > totalPage){
			endPage = totalPage;
		}
		
		// ������ ��ȣ, ���� �������� �ٸ��� ǥ��
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
						.append("&nbsp;<a href='news365List.action?currentPage=");
				pageHtml.append(i);
				pageHtml.append("'>");
				pageHtml.append(i);
				pageHtml.append("</a>");
			}

			pageHtml.append("&nbsp;");
		}
		
		// ���� block ������
		if(totalPage - startPage >= blockPage){
			pageHtml.append("<a class='page prv' href='news365List.action?currentPage=" + (endPage + 1));
			pageHtml.append("����");
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
