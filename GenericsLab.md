
# Lab for Generics

Generics enable you to detect errors at compile time rather than at runtime. A generic class or method permits you to specify allowable types of objects that the class, method or interface can work with. If you attempt to use an incompatible object, the compiler detect that error.

This Lab is based on the Shape class and its subclasses you have implemented before.

## Generics Lab 1. Rewrite equalArea() method using generics.

A generic type can be specified as a subtype of another type. Such a generic type is called _bounded_.  The following method tests whether two Shape objects have the same area. Rewrite equalArea() method using generics.

```
public static boolean equalArea(Shape o1, Shape o2) {
  return o1.getArea() == o2.getArea();
}
```



## Generics Lab 2. Rewrite drawAll() method using generics.
Consider a simple drawing application that can draw shapes such as rectangles and circles. To represent these shapes within the program, you could define a class hierarchy such as this:

```
public abstract class Shape {
    private java.util.Date time;

    public abstract void draw(Canvas c);
      ...
}

public class Circle extends Shape {
    private int radius;

    @Override
    public void draw(Canvas c) {
        ...
    }
}

public class Square extends Shape {
    private int side;

    @Override
    public void draw(Canvas c) {
        ...
    }
}
```

These classes can be drawn on a canvas:

```
public class Canvas {
    public void draw(Shape s) {
        s.draw(this);
   }
}
```

Any drawing will typically contain a number of shapes. Assuming that they are represented as a list, it would be convenient to have a method in Canvas that draws them all:

```
public void drawAll(List<Shape> shapes) {
    for (Shape s: shapes) {
        s.draw(this);
   }
}
```

Now, the type rules say that drawAll() can only be called on lists of exactly Shape: it cannot, for instance, be called on a List<Circle>. That is unfortunate, since all the method does is read shapes from the list, so it could just as well be called on a List<Circle>. What we really want is for the method to accept a list of __any kind__ of shape:

Rewrite the drawAll() method such that it accept lists of any subclass Shape, so we can now call it on a List<Circle> if we want.

To make the test simple for this particular Lab, the following Canvas class contains the Generics Lab 1 and Lab 2.

```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Canvas {
	public void draw(Shape s) {
		s.draw(this);
	}

  ////////////// Rewrite drawAll method /////////////////
	public void drawAll(List<Shape> shapes) {
		for (Shape s: shapes) {
			s.draw(this);
		}
	}

  ////////////// Rewrite equalArea method ///////////////
  public static boolean equalArea(Shape o1, Shape o2) {
    return o1.getArea() == o2.getArea();
  }

	public static void main(String[] args) {
		Canvas myCanvas = new Canvas();

		// create four objects
		Circle s1 = new Circle(2);
		Square s2 = new Square(6);
		Triangle s3 = new Triangle(3);
		Point s4 = new Point(0, 0);
    Circle s5 = new Circle(2);

		myCanvas.draw(s1);

		// create an array of three Shape objects and
		// initialize the array with the Shape objects created above;
		Shape[] myArr = new Shape[] {s1, s2, s3, s4};

		// create an arraylist using an existing array
		// instead of using add() one by one, use Arrays.asList()
		// to form a List object from an array
		List<Shape> arrList = new ArrayList<>(Arrays.asList(myArr));
		System.out.println(arrList);

		Circle[] cirArr = new Circle[] {new Circle(1), new Circle(2)};

		List<Circle> cirList = new ArrayList<>(Arrays.asList(cirArr));
		// myCanvas.drawAll(arrList);
		// myCanvas.drawAll(cirList);

    // System.out.println("equalArea(s1, s2)=" + Canvas.equalArea(s1, s2));
    // System.out.println("equalArea(s1, s5)=" + Canvas.equalArea(s1, s5));
	}
}
```

__Hint:__ This is an example of a _bounded wildcard_. The ? stands for an unknown type, just like the wildcards we saw earlier. However, in this case, we know that this unknown type is in fact a subtype of Shape. (Note: It could be Shape itself, or some subclass; it need not literally extend Shape.) We say that Shape is the upper bound of the wildcard.

## Generics Lab 3. Chanage the following code such that the max method returns the max value in the stack.

```
public class WildCardLab {
  public static void main(String[] args ) {
    GenericStack<Integer> intStack = new GenericStack<>();
    intStack.push(1); // 1 is autoboxed into new Integer(1)
    intStack.push(2);
    intStack.push(-2);

    System.out.print("The max number is " + max(intStack)); // Error: 
  }

  /** Find the maximum in a stack of numbers */
  public static double max(GenericStack<Number> stack) {
    double max = stack.pop().doubleValue(); // initialize max

    while (!stack.isEmpty()) {
      double value = stack.pop().doubleValue();
      if (value > max)
        max = value;
    }

    return max;
  }
}
```

public class AnyWildCardLab {
  public static void main(String[] args ) {
    GenericStack<Integer> intStack = new GenericStack<>();
    intStack.push(1); // 1 is autoboxed into new Integer(1)
    intStack.push(2);
    intStack.push(-2);

    print(intStack);
  }

  /** Print objects and empties the stack */
  public static void print(GenericStack<?> stack) {
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }
}

## Submission:
  Submit Canvas.java, WildCardLab.java


