
# JoyJava
JoyJava Lecture Notes and Code Snippets

  Created - 10/31/2018 <br>  
  Author -- Youngsup Kim
  
# Comparable and Comparator Interfaces
-------------------------------------------------------------------
## Lab Assignment - 
Review through the __Comparable and Comparator Interface__ lesson.  Implement some classes such that they work with `ShapeDriver.java`. Complete `ShapeDriver.java` coding such that it produces the sample run shown below: 

#### Specifications:
- Shape class has just one instance variable: 

	```private java.util.Date time;             // time stamp ```
	
- Triangle class has just one instance variable called:

	```int width;	// height = width  ```
	
- When you compare two time stamps, use the natural ordering of `Date` class since it must provide `Comparable` interface.

- Use SimpleDateFormat("mm:ss") method to get the simple format of the time in `toString()` method.  
	```
		SimpleDateFormat df = new SimpleDateFormat("mm:ss");   // df.format(this.time) 
	```
- Use `int` for all numerical computations. 
	For example, `PI` is defined as 3 and `getArea()` returns an `int` value. 

- You may make a good use of Eclipse `Source` `Generate` menu to generate some of obivous code.
	
## Files to submit:
- Shape.java, Point.java, Sqaure.java, Circle.java, Triangle.java
- ShapeDriver.java     <--- (Original Code given + Your code added)
	
----------------
## ShapeDriver Sample Run: 
```
[LShape;@7852e922
[Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]], Tri[W=3 Time[05:10]], Poi[x=0 Time[05:11]]]
[Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]], Tri[W=3 Time[05:10]], Poi[x=0 Time[05:11]]]

---Comparable interface:natural order---
By area:[Poi[x=0 Time[05:11]], Tri[W=3 Time[05:10]], Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]]]

=========Comparator interface=========

---Using anoymous object---
By area:[Poi[x=0 Time[05:11]], Tri[W=3 Time[05:10]], Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]]]
By time:[Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]], Tri[W=3 Time[05:10]], Poi[x=0 Time[05:11]]]

---Using static object---
By area:[Poi[x=0 Time[05:11]], Tri[W=3 Time[05:10]], Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]]]
By time:[Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]], Tri[W=3 Time[05:10]], Poi[x=0 Time[05:11]]]

---Using anonymous class---
By area:[Poi[x=0 Time[05:11]], Tri[W=3 Time[05:10]], Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]]]
By time:[Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]], Tri[W=3 Time[05:10]], Poi[x=0 Time[05:11]]]

---Using Lambda expreesion---
By area:[Poi[x=0 Time[05:11]], Tri[W=3 Time[05:10]], Cir[R=2 Time[05:08]], Sqr[S=6 Time[05:09]]]

---forEach() & Lambda expreesion---
Poi[x=0 Time[05:11]]
Tri[W=3 Time[05:10]]
Cir[R=2 Time[05:08]]
Sqr[S=6 Time[05:09]]

```
