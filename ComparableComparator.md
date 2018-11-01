# Comparable and Comparator interfaces in Java
--------------------

## 1. Introduction

When an array or list can be sorted or searched since they have the built-in capability. We say that its elements are comparable (due to the implementation of the Comparable interface). The question, with objects whose classes do not implement the Comparable interface, can be sorted or searched? In this case you need to provide a Comparator or Comparable interface which is the rule for sorting objects.

## 2. Setting up an Example
Let’s take an example of a student group in a group – where we want to line up the students by their student IDs.

We’ll start by creating a simple _Student_ class:

```  
    public class Student {
        private String name;
        private int ID;
        private int year;

        // constructor
        // getters, setters  

        @Override
        public String toString() {
          return name;
        }
    }
```

Next, let’s create a `StudentSorter` class to create our collection and make an attempt to sort it using `Collections.sort`:

```
public static void main(String[] args) {
    List<Student> group = new ArrayList<>();
    Student Student1 = new Student("John", 32, 1);
    Student Student2 = new Student("Moon", 42, 3);
    Student Student3 = new Student("Park", 21, 4);
    group.add(Student1);
    group.add(Student2);
    group.add(Student3);

    System.out.println("Before Sorting : " + group);
    Collections.sort(group);
    System.out.println("After  Sorting : " + group);
```
Here, as expected, this results in a compile-time error:

  > The method sort(List<T>) in the type Collections is not applicable for the arguments (ArrayList<Student>)

Let’s understand what we did wrong here.

## 3. Comparable interface

As the name suggests, __Comparable is an interface defining a strategy of comparing an object with other objects of the same type. This is called the class’s “natural ordering”.__

Accordingly, in order to be able to sort – we must define our Student object as comparable by implementing the `Comparable` interface:

```
public class Student implements Comparable<Student> {

    //...
    @Override
    public int compareTo(Student otherStudent) {
        return (this.getID() - otherStudent.getID());
    }
}
```

__The sorting order is decided by the return value of the__ `compareTo()` __method.__

The method returns a number indicating whether the object being compared is less than, equal to or greater than the object being passed as an argument.

Finally, when we run our `StudentSorter` now, we can see our `Students` sorted by their ID:

```
Before Sorting : [John, Moon, Park]
After  Sorting : [Park, John, Moon]
```

Now that we have a clear understanding of natural ordering with `Comparable`, let’s see __how we can use other types of ordering, in a more flexible manner__ than directly implementing an interface.

## 4. Comparator interface

The `Comparator` __interface defines a compare(arg1, arg2) method__ with two arguments which represent compared objects and works similarly to the `Comparable.compareTo()` method.

### 4.1 Creating Comparators

To create a `Comparator`, we have to implement the `Comparator` interface.

In our first example, we’ll create a `Comparator` to use the `ID` attribute of Student to sort the students:

```
class StudentIDComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
       return (firstStudent.getID() - secondStudent.getID());
    }
}
```

Similarly, we can create a `Comparator` to use the `year` attribute of `Student` to sort the students:

```
class StudentYearComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
       return (firstStudent.getYear() - secondStudent.getYear());
    }
}
```
How about the 'name' attribute of `Student`?

It is left for you as a lab or homework.


### 4.2 Comparators in Action

To demonstrate the concept, let’s modify our `StudentSorter` by introducing a second argument to the `Collections.sort` method which is actually the instance of Comparator we want to use.

__Using this approach, we can override the natural ordering:__

```
StudentIDComparator studentComparator1 = new StudentIDComparator();
Collections.sort(group, studentComparator1);
```
Now, let’s run our StudentIDSorter to see the result:

```
Before Sorting by ID: [John, Moon, Park]
After  Sorting by ID : [Park, John, Moon]
```

If we want a different sorting order, we only need to change the `Comparator` we’re using:

```
StudentYearComparator studentComparator2 = new StudentYearComparator();
Collections.sort(group, studentComparator2);
```
Now, when we run our StudentYearSorter, we can see a different sort order by Year:

```
Before Sorting by year: [John, Moon, Park]
After  Sorting by year : [Moon, John, park]
```

### 4.3 Simplifying Comparator Code by using _anonymous object_

The following two lines of code can be simplified if `studentComparator` is used only once.

```
StudentIDComparator studentComparator3 = new StudentIDComparator();
Collections.sort(group, studentComparator3);
```
Since `studentComparator` object is used once, we can use __anonymous object.__

```
Collections.sort(group, new StudentIDComparator());
```

## 5. Comparator Using a static object defined in the class.

Sometimes creating many extra classes would not be desirable. Maybe it is a burden to maintain them separate (helper) classes.

In your class definition, alternatively, you may provide some different `Comparator` objects that already implemented `compare` methods as needed.

The following code shows how it creates a static object called studentIDComparator using an anonymous class that is implemented in Student class.

```  
public class Student {
    private String name;
    private int ID;

    private int year;

    // constructor
    // getters, setters  

    @override
    public String toString() {
      return name;
    }

    // Create a static object called studentIDComparator
  	public static Comparator<Student> studentIDComparator = new Comparator<Student>() {
  		@Override
  		public int compare(Student a, Student b) {
  			return a.getID() - b.getID();
  		}
  	};

}
```

Then, you simply invoke the `sort` method with the static object.

```
Collections.sort(group, Student.studentIDComparator);
```

## 6. Comparator Using anonymous inner class directly

The Comparators can be coded in the place where you need directly using `anonymous inner class`.

The following static object, `studentIDComparator`, can be replaced with the code that instantiates the object.

```
Collections.sort(group, Student.studentIDComparator);
```

```
// Create a static object called studentIDComparator
public static Comparator<Student> studentIDComparator = new Comparator<Student>() {
  @Override
  public int compare(Student a, Student b) {
    return a.getID() - b.getID();
  }
};
```
Combining two code snippets above, the sort call becomes shown below:

```
Collections.sort(group, new Comparator<Student>() {
          @Override
          public int compare(Student a, Student b) {
            return a.getID() - b.getID();
          }
});
```

## 8.  Comparator Using Lambda expression in Java 8

The Lambda expression will simplify a lot of coding we have done in this section. I strongly recommend that you continue on the next lesson.
[Comparator with Lambda Expression in Java 8](https://github.com/idebtor/JoyJava/blob/master/LamdaExpression.md)


## 7. Comparator Vs Comparable
The `Comparable` interface is a good choice when used for defining the default ordering or, in other words, if it’s the main way of comparing objects.

Then, we must ask ourselves why use a `Comparator` if we already have Comparable?

There are several reasons why:

Sometimes, we can’t modify the source code of the class whose objects we want to sort, thus making the use of `Comparable` impossible. Using `Comparators` allows us to avoid adding additional code to our domain classes
We can define multiple different comparison strategies which isn’t possible when using Comparable.
