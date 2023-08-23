package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;

	public Book() {
	}

	public Book(int bookNo, String title, String author) {
		super();
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", title=" + title + ", author=" + author + ", stateCode=" + stateCode + "]";
	}

	public void rent() {
		System.out.println(title + "이(가) 대여 됐습니다.");

		this.stateCode = 0;
	}

	public void print() {
		String state = stateCode == 1 ? "재고있음" : "대여중";

		System.out.println("책 제목:" + title + " , 작가:" + author + ", 대여 유무:" + state);
	}

}
