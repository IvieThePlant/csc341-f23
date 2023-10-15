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
		System.out.println("Cap, ordered "+listNameCap.capacity());

		System.out.println("\n_________________________ADD DEFAULT ORDER ");
		StudentList listA = new StudentList(5);
		Assert.assertEquals(true,listA.add(s4),"Failed to add u04 - Ida");
		Assert.assertEquals(true,listA.add(s3),"Failed to add u03 - La");
		Assert.assertEquals(true,listA.add(s1),"Failed to add u01 - Zelda");
		Assert.assertEquals(true,listA.add(s5),"Failed to add u05 - Boo");
		Assert.assertEquals(true,listA.add(s2),"Failed to add u02 - Que");
		System.out.println("USER ORDERED\n"+listA);
		
		System.out.println("\n_________________________ADD NAME ORDER ");
		StudentList listB = new StudentList(byName,5);
		Assert.assertEquals(true,listB.add(s4),"Failed to add u04 - Ida");
		Assert.assertEquals(true,listB.add(s3),"Failed to add u03 - La");
		Assert.assertEquals(true,listB.add(s1),"Failed to add u01 - Zelda");
		Assert.assertEquals(true,listB.add(s5),"Failed to add u05 - Boo");
		Assert.assertEquals(true,listB.add(s2),"Failed to add u02 - Que");
		System.out.println("NAME ORDERED\n"+listB);
		
		System.out.println("\n_________________________BINARY SEARCH USER ");
		StudentList listC = new StudentList(5);
		Assert.assertEquals(true,listC.add(s1),"Failed to add u01 - Zelda");
		Assert.assertEquals(true,listC.add(s2),"Failed to add u02 - Que");
		Assert.assertEquals(true,listC.add(s3),"Failed to add u03 - La");
		Assert.assertEquals(true,listC.add(s4),"Failed to add u04 - Ida");
		Assert.assertEquals(true,listC.add(s5),"Failed to add u05 - Boo");
		int result = listC.findBS(s2);
		System.out.println("s2 at "+result+" (1 Expected)");
		result = listC.findBS(s3);
		System.out.println("s3 at "+result+" (2 Expected)");
		result = listC.findBS(s4);
		System.out.println("s4 at "+result+" (3 Expected)");
		result = listC.findBS(x);
		System.out.println("x not in at "+result+" (-1 Expected)");
		
		System.out.println("\n_________________________BINARY SEARCH NAME ");
		StudentList listD = new StudentList(byName,5);
		Assert.assertEquals(true,listD.add(s1),"Failed to add u01 - Zelda");
		Assert.assertEquals(true,listD.add(s2),"Failed to add u02 - Que");
		Assert.assertEquals(true,listD.add(s3),"Failed to add u03 - La");
		Assert.assertEquals(true,listD.add(s4),"Failed to add u04 - Ida");
		Assert.assertEquals(true,listD.add(s5),"Failed to add u05 - Boo");
		result = listD.findBS(s2);
		System.out.println("s2 at "+result+" (3 Expected)");
		result = listD.findBS(s3);
		System.out.println("s3 at "+result+" (2 Expected)");
		result = listD.findBS(s4);
		System.out.println("s4 at "+result+" (1 Expected)");
		result = listD.findBS(x);
		System.out.println("x not in at "+result+" (-1 Expected)");
		
		
		System.out.println("\n_________________________SUBLIST USER ");
		StudentList listE = new StudentList(5);
		Assert.assertEquals(true,listE.add(s1),"Failed to add u01 - Zelda");
		Assert.assertEquals(true,listE.add(s2),"Failed to add u02 - Que");
		Assert.assertEquals(true,listE.add(s3),"Failed to add u03 - La");
		Assert.assertEquals(true,listE.add(s4),"Failed to add u04 - Ida");
		Assert.assertEquals(true,listE.add(s5),"Failed to add u05 - Boo");
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
		Assert.assertEquals(true,listF.add(s1),"Failed to add u01 - Zelda");
		Assert.assertEquals(true,listF.add(s2),"Failed to add u02 - Que");
		Assert.assertEquals(true,listF.add(s3),"Failed to add u03 - La");
		Assert.assertEquals(true,listF.add(s4),"Failed to add u04 - Ida");
		Assert.assertEquals(true,listF.add(s5),"Failed to add u05 - Boo");
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
	