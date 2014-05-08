package commerce.model.refactored;

import commerce.model.Product;

public interface IPriceRule {
	public boolean isMatch(Product product);
	public double calculatePrice(Product product, int quantity);
	
}
