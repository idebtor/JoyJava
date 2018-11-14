
public class StackDriver3 {
	public static void main(String[] args) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		s.trimToSize();
		// push 1000 elements to the stack (size = 0, capacity = 0)
		for (int i = 0; i < 1000; i++) s.push(i);
		System.out.println("size:" + s.size() + "  capacity:" + s.capacity());

		// pop 1000 elements from the stack and observe how the capacity changes
		for (int i = 0; i < 1000; i++) s.pop();
		System.out.println("size:" + s.size() + "  capacity:" + s.capacity());
	}
}

