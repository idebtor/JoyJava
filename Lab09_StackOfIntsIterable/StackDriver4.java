
public class StackDriver4 {
	public static void main(String[] args) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		// StackOfInts s = new StackOfInts();
		s.push(2);
		s.push(8);
		s.push(1);
		s.push(9);
		System.out.println("stack:" + s);
		System.out.println("stack:" + s.toString());
	}
}
