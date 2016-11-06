/**class that contains name, price of a food item**/
public class FoodOptions {

	protected String name;
	protected Double price;
	
	/**construction sets name and price of the food**/
	public FoodOptions(String key, Double p) {
		name = key;
		price = p;
	}
}
