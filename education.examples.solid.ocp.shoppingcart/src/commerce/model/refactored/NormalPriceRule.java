package commerce.model.refactored;

import commerce.model.Product;

public class NormalPriceRule implements IPriceRule {

	@Override
	public boolean isMatch(Product product) {
		return product.getSku().startsWith("EA");
	}

	@Override
	public double calculatePrice(Product product, int quantity) {
		return product.getPrice() * quantity;
	}

}
