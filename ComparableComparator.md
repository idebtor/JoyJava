# Comparable and Comparator interfaces in Java
--------------------

## 1. Introduction

When an array or list can be sorted or searched since they have the built-in capability. We say that its elements are comparable (due to the implementation of the Comparable interface). The question, with objects whose classes do not implement the Comparable interface, can be sorted or searched? In this case you need to provide a Comparator or Comparable interface which is the rule for sorting objects.

## 2. Setting up an Example
Let’s take an example of a stduent group – where we want to line up the students by their student numbers.

We’ll start by creating a simple _Student_ class:

```  
    public class Student {
        private int number;
        private String name;
        private int year;

        // constructor, getters, setters  
    }
```

Next, let’s create a `StudentSorter` class to create our collection and make an attempt to sort it using `Collections.sort`:

```
public static void main(String[] args) {
    List<Student> class = new ArrayList<>();
    Student Student1 = new Student(32, "John", 1);
    Student Student2 = new Student(42, "Moon", 3);
    Student Student3 = new Student(21, "Park", 4);
    class.add(Student1);
    class.add(Student2);
    class.add(Student3);

    System.out.println("Before Sorting : " + class);
    Collections.sort(class);
    System.out.println("After Sorting : " + class);
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
        return (this.getNumber() - otherStudent.getNumber());
    }
}
```

__The sorting order is decided by the return value of the__ `compareTo()` __method.__

The method returns a number indicating whether the object being compared is less than, equal to or greater than the object being passed as an argument.

Finally, when we run our `StudentSorter` now, we can see our `Students` sorted by their number:

Before Sorting : [John, Moon, Park]
After Sorting : [Park, John, Moon]

Now that we have a clear understanding of natural ordering with `Comparable`, let’s see __how we can use other types of ordering, in a more flexible manner__ than directly implementing an interface.

## 4. Comparator interface

The `Comparator` __interface defines a compare(arg1, arg2) method__ with two arguments which represent compared objects and works similarly to the `Comparable.compareTo()` method.

### 4.1 Creating Comparators

To create a `Comparator`, we have to implement the `Comparator` interface.

In our first example, we’ll create a `Comparator` to use the `number` attribute of Student to sort the students:

```
public class StudentNumberComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
       return (firstStudent.getNumber() - secondStudent.getNumber());
    }
}
```

Similarly, we can create a `Comparator` to use the `age` attribute of `Student` to sort the students:

```
public class StudentAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
       return (firstStudent.getAge() - secondStudent.getAge());
    }
}
```
How about the 'name' attribute of `Student`?

It is left for you as a lab or homework.


### 4.2 Comparators in Action

To demonstrate the concept, let’s modify our `StudentSorter` by introducing a second argument to the `Collections.sort` method which is actually the instance of Comparator we want to use.

Using this approach, we can override the natural ordering:

```
StudentRankingComparator StudentComparator = new StudentRankingComparator();
Collections.sort(footballTeam, StudentComparator);
```
