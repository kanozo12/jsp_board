package model;

public class BoardDTO {
	private int no;
	private String title;
	private String writer;
	private String content;
	private String fileName;

	public BoardDTO() {

	}

	public BoardDTO(int no, String title, String writer) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
	}

	public BoardDTO(int no, String title, String writer, String content) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public BoardDTO(int no, String title, String writer, String content, String fileName) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", fileName="
				+ fileName + "]";
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

}
