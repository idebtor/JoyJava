import java.util.Iterator;

public class StackDriver10 {
	public static void main(String[] args) {
		// StackGeneric3<String> s = new StackGeneric3<>();
		// StackGeneric4<String> s = new StackGeneric4<>();
		StackGeneric5<String> s = new StackGeneric5<>();
		s.push("Why not");
		s.push("Change");
		s.push("the World");
		System.out.println(s);

		// using for-each loop
		for (String it : s)
			System.out.print(it + " ");
		System.out.println();

		// using iterator
		Iterator<String> it = s.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
	}
}
