
# JoyJava
JoyJava Lecture Notes and Code Snippets

  Created - 10/31/2018 <br>  
  Author -- Youngsup Kim
  
# Comparable and Comparator Interfaces
-------------------------------------------------------------------
## Lab Assignment - Part 1
Review through the __Comparable and Comparator Interface__ lesson.  Implement some classes such that they work with `ShapeDriver.java`. Complete `StudentDriver.java` coding such that it produces the sample run shown below: 

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



