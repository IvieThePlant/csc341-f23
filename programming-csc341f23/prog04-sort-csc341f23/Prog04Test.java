import java.util.Comparator;

public class Prog04Test {

    // TODO: Write non-default Comparators
    public static Comparator<Student> byName = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name().compareTo(s2.name());
        }
    };

    public static Comparator<Student> byUser = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.compareTo(s2);
        }
    };

    public static Comparator<Student> byMajor = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            int compairison = s1.major().compareTo(s2.major());
            if (compairison != 0) {
                return compairison;
            } else {
                return s1.compareTo(s2);
            }
        }
    };

    public static void main(String[] args) {
        // TODO: Create starting list of students
        Student s1 = new Student("u01");
        Student s2 = new Student("u02");
        Student s3 = new Student("u03");
        Student s4 = new Student("u04");
        Student s5 = new Student("u05");
        Student s6 = new Student("u06");
        Student s7 = new Student("u07");
        Student s8 = new Student("u08");

        Student sA = new Student("u10");
        Student sZ = new Student("u11");

        s1.name("Spike");
        s2.name("Jet");
        s3.name("Ein");
        s4.name("Faye");
        s5.name("Edward");
        s6.name("Vicious");
        s7.name("MaoYenrai");
        s8.name("Julia");

        sA.name("AbdulHakim");
        sZ.name("TeddyBomber");

        System.out.println("_________________________RECURSIVE BINARY SEARCH METHOD");
        // TODO: Test findRecurse(Student)
        StudentList listA = new StudentList(8);
        listA.add(s1);
        listA.add(s2);
        listA.add(s3);
        listA.add(s4);
        listA.add(s5);
        listA.add(s6);
        listA.add(s7);
        listA.add(s8);
        Assert.assertEquals(0, listA.findRecurse(s1), "Failed to find s1 - Spike  at listA.students[0]");
        Assert.assertEquals(3, listA.findRecurse(s4), "Failed to find s4 - Faye   at listA.studnets[3]");
        Assert.assertEquals(4, listA.findRecurse(s5), "Failed to find s5 - Edward at listA.students[4]");
        Assert.assertEquals(7, listA.findRecurse(s8), "Failed to find s8 - Julia  at listA.students[7]");
        Assert.assertEquals(-1, listA.findRecurse(sZ),
                "Failed to handle looking for non-existant student (expected -1)");

        System.out.println("\n_________________________REORDER");
        // TODO: Test reorder(Comparator<Student>)
        listA.reorder(byName);
        System.out.println("* Reordered listA by name");

        System.out.println(listA);

        Assert.assertEquals(0, listA.findRecurse(s5), "Failed to find s5 - Edward at listA.students[0]");

        System.out.println("\n_________________________MIN AND MAX");
        System.out.println(" - looking in listA sorted by name");
        // TODO: Test min()
        Assert.assertEquals("u05", listA.min().username(), "Incorrect minnimum. Expected s5 - Edward");

        // TODO: Test max()
        Assert.assertEquals("u06", listA.max().username(), "Incorrect minnimum. Expected s6 - Vicious");

        System.out.println(" - Passing Comparator<Student> to find min and max by username");

        // TODO: Test min(Comparator<Student>)
        Assert.assertEquals("u01", listA.min(byUser).username(), "Incorrect minnimum. Expected s1 - Spike");

        // TODO: Test max(Comparator<Student>)
        Assert.assertEquals("u08", listA.max(byUser).username(), "Incorrect minnimum. Expected s8 - Julia");

        System.out.println("\n_________________________CONVERT METHODS");
        // TODO: Test toArray(Comparator<Student>)

        // TODO: Test findAll(String)
    }
}

// TODO: ADD JAVADOCS