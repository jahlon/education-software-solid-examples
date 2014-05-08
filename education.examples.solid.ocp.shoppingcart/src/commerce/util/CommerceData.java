package commerce.util;

import commerce.model.Product;

public interface CommerceData {
	
	public static final Product[] PRODUCTS =  {
			new Product("SP001", "Candybar", "An imported candy bar", 2d),
			new Product("SP002", "Chocolate Browni", "A delicious chocolate browni ", 3d),
			new Product("SP003", "Bottle of water", "A  refreshing bottle of water", 1.5d),
			new Product("EA001", "Laptop", "A Samsung Laptop with high performance capabilities", 850d),
			new Product("EA002", "iPhone 5", "A smartphone made by apple", 625d),
			new Product("EA003", "Memory Stick", "A 8GB memory stick", 12d),
			new Product("EA004", "Plastic Table", "A table to use in the backyard", 25d),
			new Product("WE001", "Apple", "Red apples per gram", 0.005d),
			new Product("WE002", "Rice", "Good quality rice per gram", 0.003d),
			new Product("WE003", "Peanuts", "Brazilian peanuts per gram", 0.007d)
		};
}
