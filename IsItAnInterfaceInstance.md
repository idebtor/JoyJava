
# JoyJava
JoyJava Lecture Notes and Code Snippets

  Created - 10/31/2018 <br>  
  Author -- Youngsup Kim
  
# Is it an interface instance? 
-------------------------------------------------------------------
While we are working on __Comparable and Comparator Interface__ lesson, we have learned __annoymous inner class__ and __interface__. We know that we __cannot__ instantiate an object from an interface since it consists of just abstract methods without any constructors.  Then a question arises with the following code snippets experienced in our Labs. Aren't they creating __an instance of__ `Comparator interface`?

```	
	public static Comparator<Vehicle> sortByCapa = new Comparator<Vehicle>() {
		@Override
		public int compare(Vehicle o1, Vehicle o2) {
			return o1.getCapacity() - o2.getCapacity();
		}
	}; 
```

```
	Collections.sort(arrList, new Comparator<Vehiclex>() {
		@Override
		public int compare(Vehiclex v1, Vehiclex v2) {
			return v1.getName().compareTo(v2.getName());
		}
	}); 
```
		

## Java Anonymous Inner Class

Anonymous inner classes of Java are called _anonymous_ because they have no name. They are anonymous and inline. Anonymous classes are essentially inner classes and defined within some other classes. However, the way anonymous classes are written in Java code may look weird but anonymous inner classes facilitate programmers to declare and instantiate the class at the same time. Another important point to note about anonymous inner classes is that they can be used only once on the place they are coded. In other words, if you want to create only one sub-classed object of a class, then you need not to give the class a name and you can use anonymous inner class in such a case. Anonymous inner classes can be defined not just within a method, but even within an argument to a method. Anonymous inner classes cannot have explicit constructors declared because they have no name to give the constructor.

## How to Declare Java Anonymous Inner Classes?
Anonymous inner classes are defined at the same time they are instantiated with `new`. They are not declared as local classes are done rather anonymous inner classes are defined in the new expression itself, as part of a statement. An anonymous inner class declaration expression looks like a constructor invocation, except that there is a class definition contained in a block of code.

Before going into further details of anonymous inner classes we must understand that an anonymous inner class is not an independent inner class rather it is __a sub-class of either a class type or an anonymous implementer of the specified interface type__. So, when anonymous inner classes are in picture polymorphism must be there. And when polymorphism is there you can only call methods from parent class reference those are defined in the reference variable type. Java's anonymous inner classes being __sub-classes or implementers__ do strictly adhere to the polymorphism rules.

## Java Anonymous Inner Class of a Class Type
Let's take an example of seemingly strange looking syntax that defines an anonymous inner class. In following example code, the Dog reference variable dog refers not to an instance of Dog but to an instance of an anonymous inner subclass of Dog.

```
public class AnonymousClassDemo {
	public static void main(String[] args) {
		Dog mydog = new Dog() {
			@Override
			public void someDog() {
				System.out.println("Anonymous Dog : " + this.getClass().getName());
			}
		}; // anonymous class body closes here
		
		// mydog is an object of anonymous subclass of Dog.
		mydog.someDog();
	}
}

class Dog {
	public void someDog() {
		System.out.println("Classic Dog");
	}
}
```

In above piece of code; see the code line `Dog mydog = new Dog() {`, there is a brace at the end of line, not a semicolon. This curly brace opens the class definition and declares a new class that has no name (anonymous class). Now let's enter into the body of newly defined subclass of class `Dog` and you will see that `someDog()` is being overridden. This is the crux of defining an anonymous inner class because we want to override one or more methods of the super class on the fly.

Remember, anonymous inner classes are inherited ones, and we always use a superclass reference variable to refer to an anonymous subclass object. And, we can only call methods on an anonymous inner class object that are defined in the superclass. Though, we can introduce new methods in anonymous inner class, but we cannot access them through the reference variable of superclass because superclass does not know anything about new methods or data members introduced in subclass.

It would be interesting to know that you can also create an anonymous inner class for an interface type. Magically you can also pass anonymous inner class as an argument to a method. We will talk of them in subsequent sections.


## Java Anonymous Implementer of an Interface Type
In previous example as we have created an anonymous inner class for a class type. Likewise, an anonymous inner class can implement an interface anonymously. Here is an example.

```
public class AnonymousInterfaceDemo {
	public static void main(String[] args) {
		Manageable m = new Manageable() {
			@Override
			public void manage() {
				System.out.println("It is manageable");
			}
		}; // anonymous class that implements Manageable interface closes here
		
		// m is an object of an anonymous class which implements 
		// the Manageable interface.
		m.manage();
	}
}

/* AnonymousInterfaceDemo.java */
interface Manageable {
	public void manage();
}

```
The above code, like the `Dog` example, still creates an instance of anonymous inner class, but this time the new just-in-time class is an implementer of the `Manageable` interface. You would have also noticed the unusual but perfectly valid syntax `Manageable m = new Manageable() {`, where `Manageable` is an interface rather than a non-abstract class type. The code looks like instantiating a `Manageable` object but that is not so. It is creating an instance of a new, anonymous implementer of `Manageable`.

It is very important to note about anonymous inner classes which can __either implement an interface or extend a class__, they can't do both at the same time. There is no such mechanism by which an anonymous inner class can implement multiple interfaces. An anonymous inner class can't even extend a class and implement an interface at the same time.


## References
- [Java Anonymous Inner Class by Example](http://cs-fundamentals.com/java-programming/java-anonymous-inner-classes.php)
