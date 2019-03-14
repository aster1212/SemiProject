package cmt;

import java.util.Date;

public class cmtVO {
	private int 
	boardno, //보드 시퀀스 넘버
	no, //댓글 시퀀스 넘버
	originno, // 보드시퀀스 넘버를 가져온 넘버
	ref, //원글이면 내 댓글 시퀀스넘버 답글이면 원글 시퀀스 넘버
	re_level, // 원글에서 얼마나 떨어져있는지의 정도
	re_step; // 리스트에서 몇번째로 보여질지 나타내는 정도 순서
	private String
	writer, //쓴이
	content; //내용
	private Date regdate; //쓴 날자
	
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOriginno() {
		return originno;
	}
	public void setOriginno(int originno) {
		this.originno = originno;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
