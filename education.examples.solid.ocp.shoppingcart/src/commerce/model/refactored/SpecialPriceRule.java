package commerce.model.refactored;

import commerce.model.Product;

public class SpecialPriceRule implements IPriceRule {

	@Override
	public boolean isMatch(Product product) {
		return product.getSku().startsWith("SP");
	}

	@Override
	public double calculatePrice(Product product, int quantity) {
		int setsOfThree = quantity / 3;
		return (product.getPrice() * quantity) * (1 - (setsOfThree<3 ? 0.2d*setsOfThree : 0.5d));
	}

}
