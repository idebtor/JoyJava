
# Introduction to Generics (since JDK 1.5)

JDK 1.5 introduces _generics_, which supports _abstraction over types (or parameterized types)_. __The class designers__ can be _generic_ about _types in the definition_, while __the users__ can be _specific in the types during the object instantiation or method invocation_.

You are certainly familiar with passing arguments into methods. You place the arguments inside the round bracket () and pass them to the method. In generics, instead of pass arguments, we pass _type information_ inside the angle brackets <>.

The primary usage of generics is to abstract over types when working with _Collections_.

For example, the class `ArrayList` is designed (by the class designer) to take a generics type `<E>` as follows:

```
public class ArrayList<E> implements List<E> .... {
   // Constructor
   public ArraList() { ...... }

   // Public methods
   public boolean add(E e) { ...... }
   public void add(int index, E element) { ...... }
   public boolean addAll(int index, Collection<? extends E> c)
   public abstract E get(int index) { ...... }
   public E remove(int index)
   .......
}
```

To instantiate an `ArrayList`, the users need to provide the actual type for `<E>` for this particular instance. The actual type provided will then substitute all references to `E` inside the class. For example,

```
List<Integer> lst1 = new ArrayList<>(); // E substituted with Integer
lst1.add(0, new Integer(88));
lst1.get(0);

List<String> lst2 = new ArrayList<>();   // E substituted with String
lst2.add(0, "Hello");
lst2.get(0);
```

The above example showed that the class designers could be _generic_ about type; while the class users provide the _specific_ actual type information during instantiation. The type information is passed inside the angle bracket <>, just like method arguments are passed inside the round bracket ().

### Before Generics, Collections are not Type-Safe!
Before JDK 1.5,  collections such as ArrayList are designed to hold `java.lang.Object`. Via polymorphism, any subclass of `Object` can be substituted for `Object`. Since `Object` is the common root class of all the Java's classes, a collection designed to hold `Object` can hold any Java classes.

There is, however, one problem. Suppose, for example, you wish to define an ArrayList of String. In the `add(Object)` operation, the `String` will be upcasted implicitly into `Object` by the compiler. During retrieval, however, it is the programmer's responsibility to downcast the `Object` back to an `String` explicitly. If you inadvertently added in a non-String object. the compiler cannot detect the error, but the downcasting will fail at runtime (`ClassCastException` thrown). Below is an example:
```
// Pre-JDK 1.5
import java.util.*;
public class ArrayListWithoutGenericsDriver {
   public static void main(String[] args) {
      List strLst = new ArrayList();  // List and ArrayList holds Objects
      strLst.add("alpha");            // String upcast to Object implicitly
      strLst.add("beta");
      strLst.add("charlie");

      // Use an Iterator to list items:
      Iterator iter = strLst.iterator();
      //////////////////////////////////////////////////////////////////
      // need to explicitly downcast Object back to String




      //////////////////////////////////////////////////////////////////

      // Add an Integer obj which is OK by compiler and runtime
      //////////////////////////////////////////////////////////////////
      // Compiler/runtime cannot detect this error

      //////////////////////////////////////////////////////////////////

      // The following code compiles ok, but runtime ClassCastException
      String str = (String)strLst.get(3);  
   }
}
```


# 2. Generics

### Let us write our own "type-safe" ArrayList

We shall illustrate the use of generics by writing our own __type-safe__ resizable array for holding a particular type of objects (similar to an `ArrayList`).

Let's begin with a version without generics called `MyArrayList`:

```
// A dynamically allocated array which holds a collection of java.lang.Object - without generics
public class MyArrayList {
   private int size;     // number of elements
   private Object[] elements;

   public MyArrayList() {         // constructor
      elements = new Object[10];  // allocate initial capacity of 10
      size = 0;
   }

   public void add(Object o) {
      if (size < elements.length) {
         elements[size] = o;
      } else {
         // allocate a larger array and add the element, omitted
      }
      ++size;
   }

   public Object get(int index) {
      if (index >= size)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      return elements[index];
   }

   public int size() { return size; }
}
```

The `MyArrayList` is __not type-safe__. For example, if we create a `MyArrayList` which is meant to hold String, but added in an `Integer`. The compiler __cannot__ detect the error. This is because `MyArrayList` is designed to hold `Object`s and any Java classes can be upcast to `Object`.
```
public class MyArrayListDriver {
   public static void main(String[] args) {
      // Intends to hold a list of Strings, but not type-safe
      MyArrayList strLst = new MyArrayList();

      // adding String elements - implicitly upcast to Object
      strLst.add("alpha");
      strLst.add("beta");
      strLst.add("charlie");

      // retrieving - need to explicitly downcast back to String
      ///////////////////////////////////////////////////////////////




      ///////////////////////////////////////////////////////////

      // Inadvertently added a non-String object will cause a runtime
      // ClassCastException. Compiler/Runtime unable to catch the error.
      strLst.add(new Integer(1234));   

      // Compile ok, Runtime ClassCastException
      for (int i = 0; i < strLst.size(); ++i) {
         String str = (String)strLst.get(i);   
         System.out.println(str);
      }
   }
}
```

If you intend to create a list of `String`, but inadvertently added in an non-String object, the non-String will be upcasted to `Object` implicitly. The compiler is not able to check whether the downcasting is valid at compile-time (this is known as late binding or dynamic binding). Incorrect downcasting will show up only at runtime, in the form of `ClassCastException`, which could be too late. The compiler is not able to catch this error at compiled time. Can we make the compiler to catch this error and ensure type safety at runtime?

## 2.1 Generics classes

JDK 1.5 introduces the so-called _generics_ to resolve this problem. _Generics_ allow you to _abstract over types_. You can design a class with a generic type, and provide the specific type information during the instantiation. The compiler is able to perform the necessary type checking during compile time and ensure that _no type-casting error occurs at runtime_. This is known as __type-safety__.

Take a look at the declaration of interface java.util.List<E>:

```
public interface List<E> extends Collection<E> {
   boolean add(E o);
   void add(int index, E element);
   boolean addAll(Collection<? extends E> c);
   boolean containsAll(Collection<?> c);
   ......
}
```

<E> is called the _formal "type" parameter_, which can be used for passing "type" parameters during the actual instantiation.

The mechanism is similar to method invocation. Recall that in a method definition, we declare the _formal parameters_ for passing data into the method.

### Formal Type Parameter Naming Convention
Use an uppercase single-character for formal type parameter. For example,

    - <E> for an element of a collection;
    - <T> for type;
    - <K, V> for key and value.
    - <N> for number
    - S,U,V, etc. for 2nd, 3rd, 4th type parameters

### Example of Generic Class
    In this example, a class called GenericBox, which takes a generic type parameter `E`, holds a content of type `E`. The constructor, getter and setter work on the parameterized type `E`. The `toString()` reveals the actual type of the content.

```
    public class GenericBox<E> {
       // Private variable
       private E content;

       // Constructor
       public GenericBox(E content) {
          this.content = content;
       }

       public E getContent() {
          return content;
       }

       public void setContent(E content) {
          this.content = content;
       }

       public String toString() {
          return content + " (" + content.getClass() + ")";
       }
    }
```

The following test program creates `GenericBox`es with various types (`String`, `Integer` and `Double`). Take note that JDK 1.5 also introduces auto-boxing and unboxing to convert between primitives and wrapper objects.

```java
public class GenericBoxDriver {
   public static void main(String[] args) {

      // Create box1 and insert "Hello". Get the contents and print it.
      /////////////////////////////////////////////////////////////////


      /////////////////////////////////////////////////////////////////
      System.out.println(box1);

      // Create box2 and insert 123. Get the contents and print it.
      ////////////////////////////////////////////////////////////////
                                       // autobox int to Integer
                                       // downcast to Integer, auto-unbox to int
      ////////////////////////////////////////////////////////////////
      System.out.println(box2);

      // Create box3 and insert 12.34. Get the contents and print it.
      /////////////////////////////////////////////////////////////////
                                        // autobox double to Double
                                        // downcast to Double, auto-unbox to double
      /////////////////////////////////////////////////////////////////
      System.out.println(box3);
   }
}
```

The driver prints:

```
Hello (class java.lang.String)
123 (class java.lang.Integer)
12.34 (class java.lang.Double)
```

### Type Erasure

From the previous example, it seems that compiler substituted the parameterized type `E` with the actual type (such as `String`, `Integer`) during instantiation. If this is the case, the compiler would need to create a new class for each actual type (similar to C++ template).

In fact, the compiler replaces all reference to parameterized type `E` with `Object`, performs the type check, and insert the required downcast operators. For example, the GenericBox is compiled as follows (which is compatible with codes without generics):

```java
public class GenericBox {
   // Private variable
   private Object content;

   // Constructor
   public GenericBox(Object content) {
      this.content = content;
   }

   public Object getContent() {
      return content;
   }

   public void setContent(Object content) {
      this.content = content;
   }

   public String toString() {
      return content + " (" + content.getClass() + ")";
   }
}
```

The compiler also inserts the required downcast operator in the test codes:
```
GenericBox box1 = new GenericBox("Hello");  // upcast is type-safe
String str = (String)box1.getContent();     // compiler inserts downcast operation
System.out.println(box1);
```

In this way, the same `class` definition is used for all the types. Most importantly, the bytecode are compatible with those without generics. This process is called __type erasure__.

### Continue with our `type-safe` ArrayList...

Let us return to the `MyArrayList` example. With the use of generics, we can rewrite our program into `MyGenericArrayList` as follows:

```
// A dynamically allocated array with generics
public class MyGenericArrayList<E> {
   private int size;     // number of elements
   private Object[]     elements;

   public MyGenericArrayList() {  // constructor
      elements = new Object[10];  // allocate initial capacity of 10
      size = 0;
   }

   ////////////// add() //////////////////////////////

   ///////////////////////////////////////////////////
      if (size < elements.length) {
         elements[size] = e;
      } else {
         // allocate a larger array and add the element, omitted
      }
      ++size;
   }

   ///////////// get() ///////////////////////////////

   ///////////////////////////////////////////////////
      if (index >= size)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      return (E)elements[index];
   }

   public int size() { return size; }
}
```

When the `class` is instantiated with an actual type parameter, e.g. `MyGenericArrayList<String>`, the compiler ensures `add(E e)` operates on only `String` type. It also inserts the proper downcasting operator to match the return type E of `get()`. For example,

```java
public class MyGenericArrayListDriver {
   public static void main(String[] args) {
      // type safe to hold a list of Strings
      MyGenericArrayList<String> strLst = new MyGenericArrayList<>();

      strLst.add("alpha");   // compiler checks if argument is of type String
      strLst.add("beta");
      strLst.add("charlie");

      // Retrieve strings and print them.
      // Compiler inserts the downcasting operator (String)
      /////////////////////////////////////////////////////////////////




      //////////////////////////////////////////////////////////////////

      // Insert an Integer obj - 1234,
      // Compiler detected argument is NOT String, issues compilation error
      // strLst.add(new Integer(1234));  
   }
}
```

With generics, the compiler is able to perform type checking during compilation and ensure type safety at runtime.

Unlike "template" in C++, which creates a new type for each specific parameterized type, in Java, a generics class is only compiled once, and there is only one single class file which is used to create instances for all the specific types.


## 2.2 Generic Interfaces

Since JDK1.5, Java allows you to define generic classes, interfaces, and methods. Several interfaces and classes in the Java API are modified using generics. For example, prior to JDK 1.5, the `java.lang.Comparable` interface was defined as shown below:

```
package java.lang;

public interface Comparable {
    public int compareTo (Object o);
}
```
But since JDK 1.5 it is modified as shown below:

```
package java.lang;

public interface Comparable<T> {
    public int compareTo (<T> o);
}
```

Here, `<T>` represents a _formal generic type_, which can be replaced later with an _actual concrete type_.

## 2.3 Generic Methods
Methods can be defined with generic types as well (similar to generic class).

Let's suppose we want to implement a static method that accepts an array and prints its elements. The array could be an array of Integers, Strings or others.

Prior JDK 1.5, our code may be something similar as shown below:

```java
public class GenericMethodDriver {
	public static void print(Object list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i] + " ");
		}
	}

	public static void main(String[] args) {
		Integer[] ints = {1, 2, 3, 4};
		String[] strs = {"Seoul", "Pusan", "Pohang"};

		GenericMethodDriver.print(ints);
		GenericMethodDriver.print(strs);
	}
}
```

Using generics since JDK 1.5, the code may be something like:

```
public class GenericMethodDriver {
    /////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i] + " ");
		}
	}

	public static void main(String[] args) {
		Integer[] ints = {1, 2, 3, 4};
		String[] strs = {"Seoul", "Pusan", "Pohang"};

		GenericMethodDriver.print(ints);
		GenericMethodDriver.print(strs);
	}
}
```

This example shown does not show you much about the core of the generics.

Still, however, it tells you that a generic method can declare formal type parameters (e.g. `<E>`, `<K,V>`) _preceding the return type_. The formal type parameters can then be used as placeholders for return type, method's parameters and local variables within a generic method, for proper type-checking by compiler.

Let's see another example shown below:
```
// This method takes an array and add its elements into the ArrayList obj.
public static <E> void ArrayToArrayList(E[] a, ArrayList<E> lst) {
   for (E e : a) lst.add(e);
}
```

Similar to generics class, when the compiler translates a generic method, it replaces the formal type parameters using erasure. All the generic types are replaced with type Object by default (or the upper bound of type). The translated version is as follows:

```
public static void ArrayToArrayList(Object[] a, ArrayList lst) {  
   // compiler checks if a is of type E[], lst is of type ArrayList<E>
   for (Object e : a) lst.add(e);          // compiler checks if e is of type E
}
```
However, compiler checks that a is of the type `E[]`, lst is of type `ArrayList<E>`, and `e` is of type `E`, during invocation to ensure type-safety. For example,

```java
import java.util.*;
public class GenericMethodDriver {

   public static <E> void ArrayToArrayList(E[] a, ArrayList<E> lst) {
      for (E e : a) lst.add(e);
   }

   public static void main(String[] args) {
      ArrayList<Integer> lst = new ArrayList<>();

      Integer[] intArray = {55, 66};  // autobox
      ArrayToArrayList(intArray, lst);
      for (Integer i : lst) System.out.println(i);

      // Compiler knows that lst is an Integer ArrayList type
      String[] strArray = {"one", "two", "three"};
      //ArrayToArrayList(strArray, lst);   // Compilation Error below
   }
}
```

```
TestGenericMethod.java:16: <E>ArrayToArrayList(E[],java.util.ArrayList<E>) in TestGenericMethod
cannot be applied to (java.lang.String[],java.util.ArrayList<java.lang.Integer>)
      ArrayToArrayList(strArray, lst);
      ^
```

## 2.4  Wildcards

Consider the following lines of codes:
```
ArrayList<Object> lst = new ArrayList<String>();
```
It causes a compilation error "incompatible types", as `ArrayList<String>` is not an `ArrayList<Object>`.

This error is against our intuition on polymorphism, as we often assign a subclass instance to a superclass reference.

Consider these two statements:
```
List<String> strLst = new ArrayList<>();         // 1
List<Object> objLst = strList;                   // 2 - Compilation Error
```
Line 2 generates a compilation error. But if line 2 succeeds and some arbitrary objects are added into `objLst`, `strLst` will get "corrupted" and no longer contains only Strings. (`objLst` and `strLst` have the same reference.)

Because of the above, suppose we want to write a method called `printList(List<.>)` to print the elements of a `List`. If we define the method as `printList(List<Object> lst)`, then it can only accept an argument of `List<object>`, but not `List<String>` or `List<Integer>`. For example,

```java
import java.util.*;
public class GenericWildcardDriver {

   public static void printList(List<Object> lst) {  
       // Accept List of Objects only, not List of subclasses of Object
      for (Object o : lst) System.out.println(o);
   }

   public static void main(String[] args) {
      List<Object> objLst = new ArrayList<>();
      objLst.add(new Integer(55));
      printList(objLst);   // matches

      List<String> strLst = new ArrayList<String>();
      strLst.add("one");
      printList(strLst);  // compilation error
   }
}
```

There are three kinds of wildcard generic types to specify a range for a generic type. They are unbounded wildcards, bounded wildcards, and lower-bound wildcards.

### 1. Unbounded Wildcard <?>
To resolve this problem, a wildcard (?) is provided in generics, which stands for _any unknown type_. For example, we can rewrite our `printList()` as follows to accept a `List` of any unknown type.
```
public static void printList(List<?> lst) {
  for (Object o : lst) System.out.println(o);
}
```

### 2. Upperbound Wildcard <? extends type>
The wildcard `<? extends type>` stands for __type or its sub-type__. For example,

```
public static void printList(List<? extends Number> lst) {
  for (Object o : lst) System.out.println(o);
}
```
`List<? extends Number>` accepts List of __Number or any subtype of Number__, e.g., `List<Integer>` and `List<Double>`.

Clearly, `<?>` can be interpreted as `<? extends Object>`, which is applicable to all Java classes.

Another example,
```
// List<Number> lst = new ArrayList<Integer>();  // Compilation Error
List<? extends Number> lst = new ArrayList<Integer>();
```

### 3. Lowerbound Wildcard <? super type>

The wildcard `<? super type>` matches __type, as well as its super-type__. In other words, it specifies the lower bound.  There will be an example in the Lab assignment.

An example is provided at the end this lecture note here.

Read Java Online Tutorial ["More Fun with Wildcards"](https://docs.oracle.com/javase/tutorial/extra/generics/morefun.html).

## 2.5  Bounded Generics

A bounded parameter type is a generic type that specifies a bound for the generic, in the form of `<T extends _ClassUpperBound_>`, e.g., `<T extends Number>` accepts `Number` and its subclasses (such as `Integer` and `Double`).

### Example
The method `add()` takes a type parameter `<T extends Number>`, which accepts `Number` and its subclasses (such as `Integer` and `Double`).

Without using generics:

```
public class GenericMathDriver {
    //////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////
		return first.doubleValue() + second.doubleValue();
	}

	public static void main(String[] args) {
		System.out.println(add(55, 66));     // int -> Integer
		System.out.println(add(5.5f, 6.6f)); // float -> Float
		System.out.println(add(5.5, 6.6));   // double -> Double
	}
}

```
Using generics:

```
public class GenericMathDriver {
   //////////////////////////////////////////////////////////////////

   //////////////////////////////////////////////////////////////////
      return first.doubleValue() + second.doubleValue();
   }

   public static void main(String[] args) {
      System.out.println(add(55, 66));     // int -> Integer
      System.out.println(add(5.5f, 6.6f)); // float -> Float
      System.out.println(add(5.5, 6.6));   // double -> Double
   }
}
```
-------------------
## How the compiler treats the bounded generics?

As mentioned before, by default, all the generic types are replaced with type Object, during the code translation. However, in the case of <? extends Number>, the generic type is replaced by the type Number, which serves as the _upper bound_ of the generic types.

__Example__: Using generics, complete the maximum method such that it returns the maximum among two arguments.

```java
public class TestGenericsMethod {
   public ____________________________________________________________ {
      return (x.compareTo(y) > 0) ? x : y;
   }

   public static void main(String[] args) {
      System.out.println(maximum(55, 66));
      System.out.println(maximum(6.6, 5.5));
      System.out.println(maximum("Monday", "Tuesday"));
   }
}

```
By default, Object is the _upper-bound_ of the parameterized type. `<T extends Comparable<T>>` changes the upper bound to the `Comparable` interface, which declares an abstract method `compareTo()` for comparing two objects.

The compiler translates the above generic method to the following codes:

```java
public static Comparable maximum(Comparable x, Comparable y) {   
    // replace T by upper bound type Comparable
    // Compiler checks x, y are of the type Comparable
    // Compiler inserts a type-cast for the return value
   return (x.compareTo(y) > 0) ? x : y;
}
```
When this method is invoked, e.g. via `maximum(55, 66)`, the primitive ints are auto-boxed to `Integer` objects, which are then implicitly upcasted to `Comparable`. The compiler checks the type to ensure type-safety. The compiler also inserts an explicit downcast operator for the return type. That is,

```
(Comparable)maximum(55, 66);
(Comparable)maximum(6.6, 5.5);
(Comparable)maximum("Monday", "Tuesday");
```
We do not have to pass an actual type argument to a generic method. The compiler infers the type argument automatically, based of the type of the actual argument passed into the method.


-----------------

## What does the above syntax mean?
```
public static <T extends Comparable<? super T>> void sort(List<T> list)
```
This declaration says, that argument to `sort()` method must be of a type `List<T>`,
where T could be any type that implements `Comparable<? super T>` (sort requires `compareTo` method defined in `Comparable` to compare elements of list)
`Comparable<? super T>` means that type ? passed to `Comparable` could be __T__ or __any supertype of T__.

#### Consider this code:
```java
class A implements Comparable<A>{
    private int i;
    public A(int x){
        i = x;
    }
    public int compareTo(A o) {
        return i - o.i;
    }
    public String toString(){
        return "" + i;
    }
}

class B extends A{
    public B(int x){
        super(x + 10);
    }
    // we do not override compareTo
}

public class Test {
     public static void main(String[] args) {
         List<B> list = new ArrayList<B>();
         list.add(new B(3));
         list.add(new B(1));
         list.add(new B(4));
         list.add(new B(2));
         Collections.sort(list); // public static <T extends Comparable<? super T>> void sort(List<T> list)
         for (B x : list)
             System.out.println(x);
     }
}
```
`Class B` doesn't implement `Comparable<B>` (and doesn't define it's own compareTo(B b) method).
`Class B` inherits `compareTo(A x)` method from `class A` (we can say that it implements `Comparamble<A>`).
And `sort(List<B>)` compiles fine, it is conforming with declaration:
```
public static <B extends Comparable<? super B>> void sort(List<B> list)
```


## More References

1. Java Online Tutorial on ["Generics"](http://docs.oracle.com/javase/tutorial/extra/generics/index.html)
2. Java Online Tutorial on ["Collections"](http://docs.oracle.com/javase/tutorial/collections/index.html)
3. Java Programming Tutorial on [Generics](
https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGeneric.html)
