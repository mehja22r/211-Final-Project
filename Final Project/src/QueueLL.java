public class QueueLL<T> implements Queue<T> {
		
		LinkedList<T> queue;
		
		public QueueLL () {
			queue = new LinkedList<T>();
		}

		@Override
		public boolean isEmpty() {
			//if head is null there are no nodes in the list
			 if (queue.getFirst() == null) {
				 return true;
			 }
			 //return false if there are items
			 return false;
			}
		
		/**see the value at the top of the stack**/

		
		public String toString() {
			return queue.toString();
		}

		@Override
		public T dequeue() {
			T data = queue.getFirst();
			queue.deleteFirst();
			return data;
		}

		@Override
		public void enqueue(T data) {
			queue.insertLast(data);
		}

		@Override
		public T peek() {
			return queue.getFirst();
		}

}
