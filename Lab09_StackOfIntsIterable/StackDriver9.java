
public class StackDriver9 {
	public static void main(String[] args) {
		// java.util.Stack<Integer> s = new java.util.Stack<>();
		StackOfInts s = new StackOfInts();
		s.push(3);
		s.push(1);
		s.push(6);
		System.out.println(s);

		// using for-each loop
		for (int i : s)
			System.out.print(i + " ");
	}
}
