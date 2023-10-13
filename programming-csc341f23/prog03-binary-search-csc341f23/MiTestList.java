import java.util.*;

public class MiTestList {

	private static Comparator<Student> byName = new Comparator<Student>() {
		@Override
		public int compare(Student s1, Student s2) {
			return s1.name().compareTo(s2.name());
		}
	};

	public static void main(String[] args) {
	
		Student s1 = new Student("u01");
		Student s2 = new Student("u02");
		Student s3 = new Student("u03");
		Student s4 = new Student("u04");
		Student s5 = new Student("u05");
		Student x = new Student("u06");
		
		Student sA = new Student("u10");
		sA.name("Amy");
		Student sZ = new Student("u11");
		sZ.name("Zzazz");
		
		s1.name("Zelda");
		s2.name("Que");
		s3.name("La");
		s4.name("Ida");
		s5.name("Boo");
	
		System.out.println("_________________________CONSTRUCTORS ");
		StudentList listDef = new StudentList();
		System.out.println("Default capacity "+listDef.capacity());
		
		StudentList listCap = new StudentList(5);
		System.out.println("Capped 5 "+listCap.capacity());
		
		StudentList listNameDef = new StudentList(byName);
		System.out.println("Def, ordered "+listNameDef.capacity());
		
		StudentList listNameCap = new StudentList(byName,5);
		System.out.println("Cap, ordered"+listNameCap.capacity());

		System.out.println("\n_________________________ADD DEFAULT ORDER ");
		StudentList listA = new StudentList(5);
		listA.add(s4);
		listA.add(s3);
		listA.add(s1);
		listA.add(s5);
		listA.add(s2);
		System.out.println("USER ORDERED\n"+listA);
		
		
		System.out.println("\n_________________________ADD NAME ORDER ");
		StudentList listB = new StudentList(byName,5);
		listB.add(s4);
		listB.add(s3);
		listB.add(s1);
		listB.add(s5);
		listB.add(s2);
		System.out.println("NAME ORDERED\n"+listB);
		
		System.out.println("\n_________________________BINARY SEARCH USER ");
		StudentList listC = new StudentList(5);
		listC.add(s1);
		listC.add(s2);
		listC.add(s3);
		listC.add(s4);
		listC.add(s5);
		int result = listC.findBS(s2);
		System.out.println("s2 at "+result);
		result = listC.findBS(s3);
		System.out.println("s3 at "+result);
		result = listC.findBS(s4);
		System.out.println("s4 at "+result);
		result = listC.findBS(x);
		System.out.println("x not in at "+result);
		
		System.out.println("\n_________________________BINARY SEARCH NAME ");
		StudentList listD = new StudentList(byName,5);
		listD.add(s1);
		listD.add(s2);
		listD.add(s3);
		listD.add(s4);
		listD.add(s5);
		result = listD.findBS(s2);
		System.out.println("s2 at "+result);
		result = listD.findBS(s3);
		System.out.println("s3 at "+result);
		result = listD.findBS(s4);
		System.out.println("s4 at "+result);
		result = listD.findBS(x);
		System.out.println("x not in at "+result);
		
		
		System.out.println("\n_________________________SUBLIST USER ");
		StudentList listE = new StudentList(5);
		listE.add(s1);
		listE.add(s2);
		listE.add(s3);
		listE.add(s4);
		listE.add(s5);
		Student[] sub = listE.sublist(s1,s5);
		System.out.println("between user2 and user5");
		for (Student s: sub) {
			System.out.println(s);
		}
		sub = listE.sublist(s1,sZ);
		System.out.println("\nbetween user2 and user12");
		for (Student s: sub) {
			System.out.println(s);
		}
		
		System.out.println("\n_________________________SUBLIST NAME ");
		StudentList listF = new StudentList(byName,5);
		listF.add(s1);
		listF.add(s2);
		listF.add(s3);
		listF.add(s4);
		listF.add(s5);
		sub = listF.sublist(s5,s1);
		System.out.println("\nbetween Boo and Zelda");
		for (Student s: sub) {
			System.out.println(s);
		}
		sub = listF.sublist(sA,sZ);
		System.out.println("\nbetween Amy and Zzazz");
		for (Student s: sub) {
			System.out.println(s);
		}
	}
		
}
	