package commerce.model.refactored;

import java.util.ArrayList;
import java.util.List;

import commerce.model.Product;

public class PricingCalculator implements IPricingCalculator {
	
	private List<IPriceRule> priceRules;
	
	public PricingCalculator() {
		priceRules = new ArrayList<IPriceRule>();
		priceRules.add(new NormalPriceRule());
		priceRules.add(new SpecialPriceRule());
		priceRules.add(new WeightPriceRule());
	}
	
	@Override
	public double calculatePrice(Product product, int quantity) {
		for (IPriceRule priceRule : priceRules) {
			if(priceRule.isMatch(product)){
				return priceRule.calculatePrice(product, quantity);
			}
		}
		return 0;
	}

}
