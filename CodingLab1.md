# JoyJava
JoyJava Lecture Notes and Code Snippets

  Created - 10/31/2018 <br>  
  Author -- Youngsup Kim
  
# Comparable and Comparator Interfaces

1. Read the follwing two articles in this folder:

	- Comparable and Comparator interfaces
	- Comparator with Lambda Expression in Java 8
	
2. Follow CodingLab 1 & 2 instructions.
3. Use Piazaa to turn in your files.
Blessings
(a debtor)<><
-------------------------------------------------------------------
## Lab Assignment - Part 1
Review through the __Comparable and Comparator Interface__ lesson.  Implement the code in `Student.java` such that it works with `StudentDriver.java`. Complete StudentDriver coding that satisfy the following specifications.

- Comparable interface uses the student ID for comparison. This is a default comparsion, so-called natural ordering.
- Comparator interfaces use every one of instance variables. You have to implement __four Comparator classes__ for three instance variables and additionally one for comparing objects for the length of name. 
- Add the definitions of `four` Comparator classes in `StudentDriver.java` provided with this Lab. There will be a penalty of -2 points for this violation. Why? 

## Lab assignment - Part 2

Review this __Comparator with Lambda expression__ lesson and add the following two sorts and test them.  

- Use a lambda expression to sort the group by each instance variable.
- Use a lambda expression to sort the group by the student name length.
- Add this part of code at the end of StudentDriver.java
	
## Files to submit:
- Student.java
- StudentDriver.java     <--- (Original Code given + Your Part 1 & 2 Code)
	
----------------
## Lab Part 1 & Part 2 Sample Run: 
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


