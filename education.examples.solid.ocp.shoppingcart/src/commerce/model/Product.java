package commerce.model;

public class Product {
	
	private String sku;
	private String name;
	private String description;
	private double price;
	
	public Product(String sku, String name, String description, double price) {
		super();
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
