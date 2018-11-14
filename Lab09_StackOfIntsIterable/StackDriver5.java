
public class StackDriver5 {
	public static void main(String[] args) {
		// java.util.Stack<Integer> s = new java.util.Stack<>();
		StackOfInts s = new StackOfInts();
		s.push(2);
		s.push(8);
		s.push(1);
		s.push(9);
		System.out.println(s);

		// pop more elements than its size to see an Exception
		for (int i = 0, n = s.size() + 1; i < n; i++)
			s.pop();
	}
}
