import java.util.Arrays;

public class LoginInfoHashTable {

	/**hash table of customers to keep track of ID information**/
	protected LinkedList<Customer>[] myTable;
	public int numWords;

	/**size of hashTable**/
	public int myTableSize;

	/**initiliaze the hash table
	 * create the array and initialize the linked lists at each index
	 * @param size
	 */
	public LoginInfoHashTable(int size) {
		//numWords = size;
		myTableSize = size;
		myTable = new LinkedList[myTableSize];
	
		for (int i = 0; i< myTableSize; i++) {
			myTable[i] = new LinkedList<Customer>();
		}
	}

	/**take in a customer entry
	 * pass it into hash to get an array index
	 * and insertFirst in that index
	 * @param entry
	 */
	public void insert(Customer entry) {
		String word = entry.getID();
		int index = hash(word);

		//go to index in that array
		myTable[index].insertFirst(entry);

	}

	/**search for the ID in the array and return the Object
	public Customer search(String word) {
		//hash the word and get the index and look in that linked list
		int index = hash(word);

		//if the table is not big enough to hold the word?
		if (myTable[index].isEmpty()) {
			return "Word is not in table";
		}
		LinkedListNode<Customer> tempNode = new LinkedListNode<Customer>();
		tempNode = myTable[index].getFirstNode();
				
		//loop through the linked list
		for (int i = 0; i<myTable[index].size(); i++) {
			if (tempNode.getData().getID().equals(word)) {
				return tempNode.getData().getMeaning();
			}
			tempNode = tempNode.getNext();
		}

		return "Word could not be found";
	}**/

	/**loop through the hash table and delete the node**/
	public void delete(String word) {
		int index = hash(word);

		LinkedListNode<Customer> tempNode = new LinkedListNode<Customer>();
		tempNode = myTable[index].getFirstNode();
		if (tempNode.getData().getID().equals(word)) {
			myTable[index].deleteFirst();
			return;
		}
		for (int i = 1; i < myTable[index].size(); i++) {
			if (tempNode.getNext().getData().getID().equals(word)) {
				myTable[index].deleteNext(tempNode);
				return;
			}
		}
	}

	/**get an hash table index for the word**/
	public int hash(String word) {
		int hash = 0;
		int power = 1;
		char[] array = word.toCharArray();
		for(int i = 0; i < array.length; i++) {
			int ascii_code = (int) array[i];
			if( ascii_code >= 65 && ascii_code <= 90 )
				ascii_code += -64;
			else if( ascii_code >= 97 && ascii_code <= 122 )
				ascii_code += -96;
			else
				ascii_code = 0;
			hash += ascii_code * power;
			power = power * 27;
		}
		return hash % this.myTableSize;
	}
}
