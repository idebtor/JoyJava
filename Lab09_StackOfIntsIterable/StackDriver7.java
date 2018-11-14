
public class StackDriver7 {
	public static void main(String[] args) {
		StackGeneric s = new StackGeneric();
		s.push(3);
		s.push(1);
		s.push(s.peek() + 5);
		s.push(s.peek());

		System.out.println("peek:" + s.peek());
		System.out.println("size:" + s.size());
		System.out.println("stack:" + s);

		if (!s.empty()) s.clear();
	}
}
