package commerce.model.refactored;

import commerce.model.Product;

public interface IPricingCalculator {
	public double calculatePrice(Product product, int quantity);
}
