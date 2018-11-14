import java.util.Iterator;
import java.util.Stack;

public class StackDriver6 {
	public static void main(String[] args) {
		Stack<Integer> is = new Stack<>();
		is.push(new Integer(3));
		is.push(1);
		is.push(6);
		System.out.println(is);

		Stack<String> ss = new Stack<>();
		ss.push("Why Not");
		ss.push("Change");
		ss.push("World?");
		System.out.println(ss);

		Stack<Object> as = new Stack<>();
		as.push(new Integer(3));
		as.push("Hello");
		as.push("World");
		System.out.println(as);

		for (Object o : as)
			System.out.print(o + " ");
		System.out.println();
		
		Iterator<String> it = ss.iterator();
		while (it.hasNext()) 
			System.out.print(it.next() + " ");
	}
}
