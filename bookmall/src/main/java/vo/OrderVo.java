package vo;

public class OrderVo {
	private String no;
	private String price;
	private String address;
	private int member_no;
	private int orders_no;
	

	private int book_no;
	private String amount;
	private String book_title;
	private String orders_booktitle;
	private String name;
	private String mail;
	
	public String getBook_title() {
		return book_title;
	}

	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

	public int getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(int orders_no) {
		this.orders_no = orders_no;
	}
	

	public String getOrders_booktitle() {
		return orders_booktitle;
	}

	public void setOrders_booktitle(String orders_booktitle) {
		this.orders_booktitle = orders_booktitle;
	}

	@Override
	public String toString() {
		return book_title+ " " + amount+ " " + price;
	}
	

}