
public class StackDriver2 {
	public static void main(String[] args) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		// StackOfInts s = new StackOfInts();
		System.out.println("DEAFULT size:" + s.size() + "  capacity:" + s.capacity());
		
		// make the stack full
		for (int i = 0, n = s.capacity(); i < n; i++) s.push(i);
		
		// add one more element to the stack, the capacity must be doubled.
		s.push(99);
		System.out.println("FULL+1 size:" + s.size() + "  capacity:" + s.capacity());
		
		// clear the stack and set the capacity to its size.
		s.clear();
		s.trimToSize();
		System.out.println("AFTER  clear() & trimTosize()");
		System.out.println("       size:" + s.size() + "  capacity:" + s.capacity());
		
		// push elements one by one and observe how the capacity changes.
		for (int i = 0; i < 9; i++) {
			s.push(i);
			System.out.println("size:" + s.size() + "  capacity:" + s.capacity());
		}
	}
}
