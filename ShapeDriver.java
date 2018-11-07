import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShapeDriver {
	public static void main(String[] args) throws InterruptedException {
		// create four objects by one second apart
		Circle s1 = new Circle(2);
		Thread.sleep(1000);          // delay one second
		Square s2 = new Square(6);
		Thread.sleep(1000);
		Triangle s3 = new Triangle(3);
		Thread.sleep(1000);
		Point s4 = new Point(0, 0);
		
		// create an array of three Shape objects and 
		// initialize the array with the Shape objects created above; 
		Shape[] myArr = new Shape[] {s1, s2, s3, s4};
		System.out.println(myArr);
		
		// print the array which looks like a list format in one line.
		// Use a function in Arrays.
		System.out.println(Arrays.asList(myArr));
			
		// create an arraylist using an existing array
		// instead of using add() one by one, use Arrays.asList()
		// to form a List object from an array 
		List<Shape> arrList = new ArrayList<>(Arrays.asList(myArr));
		System.out.println(arrList);
		
		// Use ArrayList's method to sort shapes by area
		System.out.println("\n---Comparable interface:natural order---");
		arrList.sort(null);
		System.out.println("By area:" + arrList);
		
		System.out.println("\n=========Comparator interface=========");
		// sort by using Comparator interface, implemented as a class
		System.out.println("\n---Using anoymous object---");
		Collections.sort(arrList, new SortByArea());
		System.out.println("By area:" + arrList);
		Collections.sort(arrList, new SortByTime());
		System.out.println("By time:" + arrList);
			
		// A static object is created by 'new SortByArea()'.
		// Since it is a static object, it is invoked using 
		// in the form of Classname.object
		System.out.println("\n---Using static object---");
		Collections.sort(arrList, Shape.AreaComparator);
		System.out.println("By area:" + arrList);
		Collections.sort(arrList, Shape.TimeComparator);
		System.out.println("By time:" + arrList);

		// Using an anonymous class and anonymous object  
		// sort arrList. Use Collections.sort() and make an object
		// that overrides compare()
		System.out.println("\n---Using anonymous class---");
		
		System.out.println("\n---your code here---");
		System.out.println("By area:" + arrList);
		
		System.out.println("\n---your code here---");
		System.out.println("By time:" + arrList);
		
		System.out.println("\n---Using Lambda expreesion---");
		System.out.println("\n---your code here---");
		System.out.println("By area:" + arrList);
		
		System.out.println("\n---forEach() & Lambda expreesion---");
		arrList.forEach((s) -> System.out.println(s));
	}
}

// class SortByArea  ---your code here---

// class SortByTime  ---your code here---

