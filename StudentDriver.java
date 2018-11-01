import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentDriver {
	public static void main(String[] args) {
		
		
	    List<Student> group = new ArrayList<Student>();
	    Student Student0 = new Student("John", 32, 4);
	    Student Student1 = new Student("Johny", 11, 1);
	    Student Student2 = new Student("Moonkey", 42, 3);
	    Student Student3 = new Student("Parker", 21, 4);
	    group.add(Student0);
	    group.add(Student1);
	    group.add(Student2);
	    group.add(Student3);

	    System.out.println("\n--Using Comparable interface");
	    System.out.println("Before Comparable Sorting : " + group);
	    Collections.sort(group);
	    System.out.println("After  Comparable Sorting : " + group);

	    System.out.println("\n--Using Comparator interface");

	    System.out.println("Before Sorting by ID : " + group);
	    StudentIDComparator studentComparator1 = new StudentIDComparator();
	    Collections.sort(group, studentComparator1);
	    System.out.println("After  Sorting by ID : " + group);

	    System.out.println("Before Sorting by year : " + group);
	    StudentYearComparator studentComparator2 = new StudentYearComparator();
	    Collections.sort(group, studentComparator2);
	    System.out.println("After  Sorting by year : " + group);

	    System.out.println("\n--Using a static class object");
	    System.out.println("Before Sorting by ID : " + group);
	    Collections.sort(group, Student.studentIDComparator);
	    System.out.println("After  Sorting by ID : " + group);

	    System.out.println("Before Sorting by name : " + group);
	    StudentNameComparator studentComparator3 = new StudentNameComparator();
	    Collections.sort(group, studentComparator3);
	    System.out.println("After  Sorting by name: " + group);

	    System.out.println("\n--Using anonymous inner class");
	    System.out.println("Before Sorting by year : " + group);
	    Collections.sort(group, new Comparator<Student>() {
	          @Override
	          public int compare(Student a, Student b) {
	            return a.getYear() - b.getYear();
	          }
	    });
	    System.out.println("After  Sorting by year : " + group);
	    
	    System.out.println("Before Sorting by name : " + group);
	    Collections.sort(group, new Comparator<Student>() {
	          @Override
	          public int compare(Student a, Student b) {
	            return a.getName().compareTo(b.getName());
	          }
	    });
	    System.out.println("After  Sorting by name : " + group);
	    
	    
	    System.out.println("\n============= Part 2 ===========");

	    System.out.println("\n--Using Lambda expression");
	    System.out.println("Before Sorting by ID : " + group);
	    
	    System.out.println("After  Sorting by ID : " + group);
	    
	    System.out.println("Before Sorting by year : " + group);
	    
	    System.out.println("After  Sorting by year : " + group);

	    System.out.println("Before Sorting by str : " + group);
	    
	    System.out.println("After  Sorting by str : " + group);

	    System.out.println("Before Sorting by str len: " + group);
	    
	    System.out.println("After  Sorting by str len: " + group);
	}
}
