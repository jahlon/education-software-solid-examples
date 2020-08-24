package commerce.model.refactored;

import commerce.model.Product;

public class OtherRule implements IPriceRule {

	@Override
	public boolean isMatch(Product product) {
		return true;
	}

	@Override
	public double calculatePrice(Product product, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
