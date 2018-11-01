
# Comparator with Lambda Expression in Jave 8
-------------------

Overview 
In Java 8, the Lambda expression has been introduced. It is very useful and powerful when you use it to write the Comparator and sort a Collection.
------------

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
new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return h1.getName().compareTo(h2.getName());
    }
}
```

This would simply be used to sort the List of Human entities:

@Test
public void sortUsingAnonymousInnerClass() {
    List<Human> humans = Lists.newArrayList(
      new Human("Sarah", 10), 
      new Human("Jack", 12)
    );
     
    Collections.sort(humans, new Comparator<Human>() {
        @Override
        public int compare(Human h1, Human h2) {
            return h1.getName().compareTo(h2.getName());
        }
    });
    Assert.assertThat(humans.get(0), equalTo(new Human("Jack", 12)));
}


