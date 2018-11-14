
public class StackDriver31 {
	public static void main(String[] args) {
		// java.util.Stack<Integer> s = new java.util.Stack<>();
		StackOfInts s = new StackOfInts();
		s.trimToSize();
		// push 1000 elements to the stack (size = 0, capacity = 0)
		for (int i = 0; i < 1000; i++) s.push(i);
		System.out.println("size:" + s.size() + "  capacity:" + s.capacity());

		// pop 1000 elements from the stack and observe how the capacity changes
		for (int i = 0; i < 1000; i++) {
			int before = s.capacity();
			s.pop();
			int after = s.capacity();
			if (before != after)
				System.out.println("NEW  size:" + s.size() + "  capacity:" + s.capacity());
		}
		System.out.println("LAST size:" + s.size() + "  capacity:" + s.capacity());
	}
}
