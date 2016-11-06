import java.util.ArrayList;

/**contains order of a customer**/
public class Customer {

	/**may contain ID, order, price**/
	
	FoodOptions[] yourOrder;
	String ID;
	String password;
	
	/**sets ID and password and stores customer info in a hash table**/
	public Customer(String id, String pw) {
		ID = id;
		password = pw;
	}
	
	/**constructor creates an array of order**/
	public void setOrder(ArrayList<FoodOptions> list) {
		yourOrder = new FoodOptions[list.size()];
		list.toArray(yourOrder);
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i=0;i<yourOrder.length;i++) {
			s += yourOrder[i].name+", ";
		}
		return s;
	}
	
	public String getID() {
		return ID;
	}
}
