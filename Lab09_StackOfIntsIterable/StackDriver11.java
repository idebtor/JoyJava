import java.util.Iterator;

public class StackDriver11 {
	public static void main(String[] args) {
		StackOfIntsIterable s = new StackOfIntsIterable();
		// push() and print stack
		s.push(3);
		s.push(1);
		s.push(6);
		System.out.println(s);

		for (Integer it: s)
			System.out.print(it + " ");
		System.out.println();

		Iterator<Integer> it = s.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
	}
}
