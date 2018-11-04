
# Comparator with Lambda Expression in Java 8
-------------------

Overview
In Java 8, the Lambda expression has been introduced. It is very useful and powerful when you use it to write the Comparator and sort a Collection. Lambda expressions can be viewed as an anonymous class with a simple expression. The compiler treats a lambda expression as if it is an object created from an anonymous inner class.

-----------

## 1. Setting up an Example
Let’s take an example of a student group in a group – where we want to line up the students by their student IDs.

We’ll start by creating a simple _Student_ class:

```  
    public class Student {
        private String name;
        private int ID;
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
System.out.println("Before Sorting by ID : " + group);
Collections.sort(group, new Comparator<Student>() {
      @Override
      public int compare(Student a, Student b) {
        return a.getID() - b.getID();
      }
});
System.out.println("After  Sorting : " + group);
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

    System.out.println("Before Sorting by ID : " + group);
    Collections.sort(group, new Comparator<Student>() {
          @Override
          public int compare(Student a, Student b) {
            return a.getID() - b.getID();
          }
    });
    System.out.println("After  Sorting : " + group);
}
```

## 3. Sort with Lambda Expression

Since the Java compiler knows that `Collection.sort()` method requires a `Comparator` object that implements with a `compare` method, now it allows leave out all unnecessary things.  Based the code snippet above, what the `Collection.sort()` needs to have parameters and the statement in the body of `compare()`.  Believe it or not, the compiler works even without the type such as `<Student>` since it even understands what it is supposed to be there.  

```
Collections.sort(group, (a, b) -> a.getID() - b.getID());
```

In this case the compiler understands that the object must be an instance of `Comparator<Student>`. So, for the compiler to understand lambda expression, the interface contain exactly one abstract method. Such an interface is known as a __functional interface__ or a __Single Abstract Method(SAM) interface__.

Using this Lambda expression you may write _forEach_ loop as shown below;

```
group.forEach( (s) -> System.out.println(s) );
```
------------------------
# Lab assignment - Part 2

Review this __Comparator with Lambda expression__ lesson and add the following two sorts and test them.  

- Use a lambda expression to sort the group by each instance variable.
- Use a lambda expression to sort the group by the student name length.
- Add this part of code at the end of StudentDriver.java
	
## Files to submit:
- Student.java
- StudentDriver.java  <--- (Original + Part2) Code
	
----------------
# Lab Part 1 & Part 2 Sample Run: 
```
--Using Comparable interface
Before Comparable Sorting : [John32-4, Johny11-1, Moonkey42-3, Parker21-4]
After  Comparable Sorting : [Johny11-1, Parker21-4, John32-4, Moonkey42-3]

--Using Comparator interface
Before Sorting by ID : [Johny11-1, Parker21-4, John32-4, Moonkey42-3]
After  Sorting by ID : [Johny11-1, Parker21-4, John32-4, Moonkey42-3]
Before Sorting by year : [Johny11-1, Parker21-4, John32-4, Moonkey42-3]
After  Sorting by year : [Johny11-1, Moonkey42-3, Parker21-4, John32-4]

--Using a static class object
Before Sorting by ID : [Johny11-1, Moonkey42-3, Parker21-4, John32-4]
After  Sorting by ID : [Johny11-1, Parker21-4, John32-4, Moonkey42-3]
Before Sorting by name : [Johny11-1, Parker21-4, John32-4, Moonkey42-3]
After  Sorting by name: [John32-4, Johny11-1, Moonkey42-3, Parker21-4]

--Using anonymous inner class
Before Sorting by year : [John32-4, Johny11-1, Moonkey42-3, Parker21-4]
After  Sorting by year : [Johny11-1, Moonkey42-3, John32-4, Parker21-4]
Before Sorting by name : [Johny11-1, Moonkey42-3, John32-4, Parker21-4]
After  Sorting by name : [John32-4, Johny11-1, Moonkey42-3, Parker21-4]

============= Part 2 ===========

--Using Lambda expression
Before Sorting by ID : [John32-4, Johny11-1, Moonkey42-3, Parker21-4]
After  Sorting by ID : [Johny11-1, Parker21-4, John32-4, Moonkey42-3]
Before Sorting by year : [Johny11-1, Parker21-4, John32-4, Moonkey42-3]
After  Sorting by year : [Johny11-1, Moonkey42-3, Parker21-4, John32-4]
Before Sorting by str : [Johny11-1, Moonkey42-3, Parker21-4, John32-4]
After  Sorting by str : [John32-4, Johny11-1, Moonkey42-3, Parker21-4]
Before Sorting by str len: [John32-4, Johny11-1, Moonkey42-3, Parker21-4]
After  Sorting by str len: [John32-4, Johny11-1, Parker21-4, Moonkey42-3]
```

