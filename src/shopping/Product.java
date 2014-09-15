package shopping;

public class Product {
	private String productId;
	private String productName;
	private String productInfo;
	private double value;
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Product(String productId,String productName,String productInfo,double value){
		this.productId = productId;
		this.productName = productName;
		this.productInfo = productInfo;
		this.value = value;
	}

}
