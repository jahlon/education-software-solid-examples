package commerce.model.refactored;

import commerce.model.Product;

public class WeightPriceRule implements IPriceRule {

	@Override
	public boolean isMatch(Product product) {
		return product.getSku().startsWith("WE");
	}

	@Override
	public double calculatePrice(Product product, int quantity) {
		return product.getPrice() * quantity * 1000d;
	}

}
