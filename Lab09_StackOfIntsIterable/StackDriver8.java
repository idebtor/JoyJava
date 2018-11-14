
public class StackDriver8 {
	public static void main(String[] args) {
		StackGeneric2<Integer> is = new StackGeneric2<>();
		is.push(new Integer(3));
		is.push(1);
		is.push(6);
		System.out.println(is);
		StackGeneric2<String> ss = new StackGeneric2<>();
		ss.push("Why Not");
		ss.push("Change");
		ss.push("World?");
		System.out.println(ss);

		StackGeneric2<Object> as = new StackGeneric2<>();
		as.push(new Integer(3));
		as.push("Hello");
		as.push("World");
		System.out.println(as);
	}
}
