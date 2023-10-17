public class Main {

  public static void main(String[] args) {
  	StudentList slist = new StudentList();

    Student s1 = new Student("u01");
	Student s2 = new Student("u02");
	Student s3 = new Student("u03");
	Student s4 = new Student("u04");
	Student s5 = new Student("u05");
	Student x = new Student("u06");
	Student sZ = new Student("u11");
		
	Student[] contents = {s1,s2,s3,s4,s5};

    System.out.println("\n________________ Adding");
    for (int i=0; i<contents.length; i++) {
      slist.add(contents[i]);
    }

    System.out.println("\n________________ toString");
    System.out.println("expecting u01,u02,u03,u04,u05");
    System.out.println(slist);

    System.out.println("\n________________ Getting");
    System.out.println("expecting u01,u02,u03,u04,u05");
    for (int i=0; i<6; i++) {
      System.out.print(slist.get(i)+" ");
    }
    System.out.println();

    System.out.println("\n________________ Finding");
    System.out.println("expecting u01,u02,u03,u04,u05");
    for (int i=0; i<contents.length; i++) {
      System.out.print(slist.find(contents[i])+" ");
    }
    System.out.println();

    System.out.println("\n________________ Removing at index");
    // in the middle
    slist.remove(2);
    // the first one
    slist.remove(0);
    // the last one
    slist.remove(2);
    // not there
    slist.remove(5);
    System.out.println("expecting u02 u04");
    System.out.println(slist);

    System.out.println("\n________________ Adding at index");
    // the first one
    slist.add(s1,0);
    // in the middle
    slist.add(s3,2);
    // the last one
    slist.add(sZ,3);
    // not there
    slist.add(x,10);
    System.out.println("expecting u1 u2 u3 u11 u4");
    System.out.println(slist);

    System.out.println("\n________________ Removing item");
    // in the middle
    slist.remove(s2);
    // the first one
    slist.remove(s1);
    // the last one
    slist.remove(s4);
    // not there
    slist.remove(x);
    System.out.println("expecting u3 u11");
    System.out.println(slist);

    System.out.println("\n________________ toArray");
    Student[] students = slist.toArray();
    for (Student s: students) {
    	System.out.println(s);
    }
}
}
