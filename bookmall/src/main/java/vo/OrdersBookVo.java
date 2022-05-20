package vo;

public class OrdersBookVo {

	private String orders_no;
	private int book_no;
	private String amount;
	private int price;

	public String getOrders_no() {
		return orders_no;
	}

	public void setOrders_no(String orders_no) {
		this.orders_no = orders_no;
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
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrdersBookVo [orders_no=" + orders_no + ", book_no=" + book_no + ", amount=" + amount + ", price="
				+ price + "]";
	}

}
