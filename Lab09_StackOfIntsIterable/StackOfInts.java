public class StackOfInts {
	private int[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	/** Construct a stack with the default capacity */
	public StackOfInts() {
		this(DEFAULT_CAPACITY);
	}
	/** Construct a stack with the specified capacity */
	public StackOfInts(int capacity) {
		elements = new int[capacity];
	}

	/** Push a new integer into the top of the stack */
	public void push(int item) {
		// Your code here
	}

	/** Return and remove the top element from the stack */
	public int pop() {
		return elements[--size];
	}

	/** Return the top element from the stack */
	public int peek() {
		return elements[size() - 1];
	}

	/** Return true if the stack is empty */
	public boolean empty() {
		return size == 0;
	}

	/** Return the number of elements in the stack */
	public int size() {
		return size;
	}

        /** Return the capacity of the stack */
	public int capacity() {
		return elements.length;
	}

	/** Make the stack empty */
	public void clear() {
              // Your code here
        }
}
