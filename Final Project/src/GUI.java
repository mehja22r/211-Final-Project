import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**page will direct you to a login for student or employee**/
public class GUI extends JComponent{

	//creates a new hashtable to track student ID**/
	LoginInfoHashTable table = new LoginInfoHashTable(10);
	
	Menu menu = new Menu();
	
	JPanel loginPanel = new JPanel();
	
	/**this stores items user selected to order**/
	ArrayList<FoodOptions> orders = new ArrayList<FoodOptions>();
	
	JPanel orderPanel;
	
	static JFrame window;

	JLabel price = new JLabel();
	
	Customer customer;
	
	Queue<Customer> queue = new QueueLL<Customer>();
	
	
	public GUI() {
		super();
		this.setLayout(new BorderLayout());
		this.add(createGUI(), BorderLayout.CENTER);
	
		this.add(loginPanel, BorderLayout.CENTER);
	}

	public JPanel createGUI() {
		//panel to hold 2 Jtextareas and labels
		JPanel textPanel = new JPanel(new BorderLayout());
		JPanel labelPanel = new JPanel(new BorderLayout());
		JPanel tempPanel = new JPanel(new BorderLayout());

		JTextField name = new JTextField(20);
		JTextField password = new JTextField(20);

		textPanel.add(name, BorderLayout.NORTH);
		textPanel.add(password, BorderLayout.SOUTH);

		JLabel ID = new JLabel("Student ID");
		JLabel pass = new JLabel("Password");
		labelPanel.add(ID, BorderLayout.NORTH);
		labelPanel.add(pass, BorderLayout.SOUTH);

		tempPanel.add(labelPanel, BorderLayout.WEST);
		tempPanel.add(textPanel, BorderLayout.EAST);

		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = name.getText();
				String temp2 = password.getText();
				loginClicked(temp, temp2);
			}
		});
		
			
			loginPanel.add(tempPanel, BorderLayout.CENTER);
			loginPanel.add(login, BorderLayout.SOUTH);
			return loginPanel;
		
	}

	/**create new customer with id and password
	 * and displays menu in JPanel**/
	public void loginClicked(String s, String p) {
		customer = new Customer(s, p);
		table.insert(customer);
		takeToOrder();
	}

	/*update JPanel to display menu, buttons*/
	public void takeToOrder() {
		JPanel menuPage = new JPanel(new BorderLayout());
		
		JLabel menuItems = new JLabel();
		String s = menu.toString(menu.deli);
		String t = menu.toString(menu.grill);
		String temp = s+t;
		menuItems.setText(temp);
		menuItems.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuPage.add(menuItems, BorderLayout.CENTER);
		loginPanel.setVisible(false);

		String[] display = menu.mergeArrays(menu.toStringNames(menu.grill), menu.toStringNames(menu.deli));
		JComboBox foodOptions = new JComboBox(display);

		JButton addToBasket = new JButton("Add to list");
		addToBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String currentOrder = (String) foodOptions.getSelectedItem();

				//search this currentOrder in the grill array list
				orders.add(menu.search(currentOrder, menu.grill));
				showPrice();
			}	
		});

		JButton order = new JButton("Order");
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToQueue();
				addToBasket.setEnabled(false);
				order.setEnabled(false);
			}	
		});

		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.add(addToBasket, BorderLayout.EAST);
		buttonPanel.add(order, BorderLayout.WEST);

		menuPage.add(foodOptions, BorderLayout.NORTH);
		menuPage.add(buttonPanel, BorderLayout.SOUTH);
		this.add(menuPage, BorderLayout.CENTER);


	}

	/**add and display prices**/
	public void showPrice() {
		
		String cost2;
		Double cost = (double) 0;
		for (int i=0;i<orders.size();i++) {
			cost += orders.get(i).price;
		}
		cost2 = "Price: $"+cost.toString();
		System.out.println(cost2);
		price.setText(cost2);
		this.add(price, BorderLayout.EAST);
	}

	/**create a user object which stores them and their order in q queue**/
	public void addToQueue() {
		customer.setOrder(orders);
		queue.enqueue(customer);
		System.out.println("You have been added to the queue.");
		System.out.println("Your order is "+customer.toString());
	}

	public static void main (String[] args) {

		window = new JFrame("BLanchard Ordering System");
		window.add(new GUI());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setFocusable(true);
		window.setSize(500,600);
	}

}
