// Author: Youngsup Kim, idebtor@gmail.com
// Warming-up program for java.util.Stack
public class StackDriver {
	public static void main(String[] args) {
		// java.util.Stack<Integer> s = new java.util.Stack<>();
		StackOfInts s = new StackOfInts();
		System.out.println("size:" + s.size() + "  capacity:" + s.capacity());
		s.push(7);
		s.push(4);
		s.push(s.peek() + 2);
		s.pop();
		s.push(s.peek());

		System.out.println("peek:" + s.peek());
		System.out.println("size:" + s.size() + "  capacity:" + s.capacity());
		System.out.println("stack:" + s);

		if (!s.empty()) s.clear();
	}
}
