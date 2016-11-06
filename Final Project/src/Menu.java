import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

/**creates an arraylist of all menu items**/
public class Menu {

	/**menus**/
	ArrayList<FoodOptions> deli;  
	ArrayList<FoodOptions> grill;    
	ArrayList<String> test = new ArrayList<String>();

	/**initialize the array list**/
	public Menu() {
		deli  = new ArrayList<FoodOptions>();
		grill = new ArrayList<FoodOptions>(10);
		createGrillMenu();
		createDeliMenu();
	}

	/**adds items to grill array list**/
	public void createGrillMenu() {

		FoodOptions meltdown = new FoodOptions("Meltdown", 5.75);
		FoodOptions caesarWrap = new FoodOptions("Chicken Caesar Wrap", 5.5);
		FoodOptions chickenFingers = new FoodOptions("Chicken Fingers", 4.5);
		FoodOptions mozzarella = new FoodOptions("Mozzarella Sticks", 4.75);
		FoodOptions fries = new FoodOptions("Fries", 1.75);
		FoodOptions spicyFries = new FoodOptions("SpicyFries", 1.75);

		grill.add(meltdown);
		grill.add(caesarWrap);
		grill.add(chickenFingers);
		grill.add(mozzarella);
		grill.add(fries);
		grill.add(spicyFries);
	}

	/**adds items to deli menu**/
	public void createDeliMenu() {
		FoodOptions TurkeySandwich = new FoodOptions("Classic Turkey Club Sandwich", 5.75);
		FoodOptions PBJ = new FoodOptions("Peanut Butter and Jelly", 4.0);
		FoodOptions Veg = new FoodOptions("Vegan Triple Play", 4.5);
		FoodOptions CQues = new FoodOptions("Chicken Quesadilla", 5.0);
		FoodOptions cQues = new FoodOptions("Cheese Quesadilla", 4.5);
		FoodOptions vineyard = new FoodOptions("Vineyard", 4.0);

		deli.add(TurkeySandwich);
		deli.add(PBJ);
		deli.add(Veg);
		deli.add(CQues);
		deli.add(cQues);
		deli.add(vineyard);
	}

	/**make an array of strings to display menu options**/
	public String[] toStringNames(ArrayList<FoodOptions> list) {
		String s = "";
		String[] temp = new String[list.size()];
		for (int i = 0; i<list.size(); i++) {
			s = list.get(i).name;
			temp[i] = s;
		}
		return temp;
	}
	
	/**returns name of foodOptions**/
	public String toString(ArrayList<FoodOptions> list) {
		String s = "";
		//String[] temp = new String[list.size()];
		for (int i = 0; i<list.size(); i++) {
			s += "<html>"+list.get(i).name+" $"+list.get(i).price+"<br>";
			//s += list.get(i).name+" $"+list.get(i).price;
			//temp[i] = s;
		}
		return s;
	}
	
	/**searches for a FoodOption and returns it
	 * maybe include try/catch for else return null**/
	public FoodOptions search(String s, ArrayList<FoodOptions> list) {
		for (int i=0;i<list.size();i++) {
			if (s.equals(list.get(i).name)) {
				return list.get(i);
			}
		}
		return search(s, deli);
	}
	
	/**merge two arrays for display**/
	public String[] mergeArrays(String[] a, String[] b) {
		int size = a.length+b.length;
		String[] c = new String[size];
		int i = 0;
		int life = 0;
		for (i = 0; i<a.length;i++) {
			c[i] = a[i];
		}
		for (int j = i+1; j<size;j++) {
			
			c[j] = b[life];
			life ++;
		}
		
		return c;
	}
}
