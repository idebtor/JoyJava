
# Introduction to Generics (JDK 1.5)

JDK 1.5 introduces _generics_, which supports _abstraction over types (or parameterized types)_. The class designers can be _generic_ about _types in the definition_, while the users can be _specific in the types during the object instantiation or method invocation_.

You are certainly familiar with passing arguments into methods. You place the arguments inside the round bracket () and pass them to the method. In generics, instead of pass arguments, we pass _type information_ inside the angle brackets <>.

The primary usage of generics is to abstract over types when working with _Collections_.

For example, the class ArrayList is designed (by the class designer) to take a generics type <E> as follows:

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

To instantiate an ArrayList, the users need to provide the actual type for <E> for this particular instance. The actual type provided will then substitute all references to E inside the class. For example,

```
List<Integer> lst1 = new ArrayList<>(); // E substituted with Integer
lst1.add(0, new Integer(88));
lst1.get(0);

List<String> lst2 = new ArrayList<>();   // E substituted with String
lst2.add(0, "Hello");
lst2.get(0);
```

The above example showed that the class designers could be _generic_ about type; while the class users provide the _specific_ actual type information during instantiation. The type information is passed inside the angle bracket <>, just like method arguments are passed inside the round bracket ().

# 2. Generics


## references

https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGeneric.html
