
# Comparator with Lambda Expression in Jave 8
-------------------

Overview
In Java 8, the Lambda expression has been introduced. It is very useful and powerful when you use it to write the Comparator and sort a Collection. Lambda expressions can be viewed as an anonymous class with a simple expression. The compiler treats a lambda expression as if it is an object created from an anonymous inner class.

-----------

## 1. Setting up an Example
Let’s take an example of a student group in a group – where we want to line up the students by their student numbers.

We’ll start by creating a simple _Student_ class:

```  
    public class Student {
        private String name;
        private int number;
        private int year;

        // constructor
        // getters, setters  
				// equals, hashcode

        @Override
        public String toString() {
          return name + year;
        }
    }
```

## 2. Basic Sort without Lambdas

Before Java 8, sorting a collection would involve __creating an anonymous inner class__ for the `Comparator` used in the sort:

```
System.out.println("Before Sorting by num : " + group);
Collections.sort(group, new Comparator<Student>() {
      @Override
      public int compare(Student a, Student b) {
        return a.getNumber() - b.getNumber();
      }
});
System.out.println("After Sorting : " + group);
```

This would simply be used to sort the List of Student entities:

```
public static void main(String[] args) {
    List<Student> group = new ArrayList<Student>();
    Student Student1 = new Student("John", 32, 1);
    Student Student2 = new Student("Moonkey", 42, 3);
    Student Student3 = new Student("Parker", 21, 4);
    group.add(Student1);
    group.add(Student2);
    group.add(Student3);

    System.out.println("Before Sorting by num : " + group);
    Collections.sort(group, new Comparator<Student>() {
          @Override
          public int compare(Student a, Student b) {
            return a.getNumber() - b.getNumber();
          }
    });
    System.out.println("After Sorting : " + group);
}
```

## 3. Sort with Lambda Expression

Since the `Collection.sort()` method knows that it should have a Comparator object which has a compare method, now it allows leave out all unnecessary things.  Based the code snippet above, what the sort() needs to have parameters and the statement in the body of compare().
Believe it or not, it works even without the type such as <Student> since it understands what it is supposed to be there.  

```
Collections.sort(group, (a, b) -> a.getNumber() - b.getNumber());
```

In this case the compiler understands that the object must be an instance of Comparator<Student>. So, for the compiler to understand lambda expression, the interface contain exactly one abstract method. Such an interface is known as a functional interface or a Single Abstract Method(SAM) interface.

Using this Lambda expression you may write forEach loop as shown below;

```
group.forEach( (s) -> System.out.println(s) );
```
------------------------
## 4. Lab assignment

1. Go through the Comparable and Comparator Interface lesson and this Lambda expression.  Implement the code and test them by yourself.
2. Use a lambda expression to sort the group by their student names.
3. Use a lambda expression to sort the group by their student name lengths.
----------------
