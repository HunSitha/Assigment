package ckcc.hibernate;

public class Purchase {
	
	private String orderNo;
	private Product product;
	private double qty;
	private double discount;
	
	public Purchase(String orderNo, Product product, double qty, double discount) {
		this.orderNo = orderNo;
		this.product = product;
		this.qty = qty;
		this.discount = discount;
	}
	
	public double getPrice() {
		double purchasedPrice = this.qty * this.product.getPrice();
		if(this.discount > 0) {
			purchasedPrice = this.qty * this.product.getPrice() - getDiscount();
		}
		return purchasedPrice;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public Product getProduct() {
		return product;
	}

	public double getQty() {
		return qty;
	}

	public double getDiscount() {
		return this.qty*this.product.getPrice()*this.discount/100;
	}
	public double getDiscountRate(){
		return this.discount;
	}

	public String toString() {
		String discount = (this.discount * 100) + "%";
		return this.orderNo + "\t'" + this.product.getName() + "'\t" + this.qty + "\t" + this.product.getPrice() + "\t" + discount + "\t" + this.getPrice();
	}

}
