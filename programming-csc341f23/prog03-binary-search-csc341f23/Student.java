import java.util.ArrayList;
import java.util.Random;
import java.lang.Comparable;

public class Student implements Comparable<Student>{
    public String[] majors = { "CSC", "MAT", "DST", "MIS", "BIO", "PHY", "CHE" };
    private String username;
    private String name;
    private String major;
    private ArrayList<String> completedCourses = new ArrayList<>();

    public Student(String uname) {
        Random rand = new Random();
        username = uname;

        // Assign random values to user
        name = names[rand.nextInt(names.length)];

        major = majors[rand.nextInt(majors.length)];

        int completed = rand.nextInt(9)+1;
        for (int i=0; i<completed; i++) {
            completedCourses.add(majors[rand.nextInt(majors.length)]+(rand.nextInt(300)+100));
        }
    }
    /** Constructor with all information provided
     * @param u username 
     * @param n name of Student
     * @param m major
     * @param cc completed courses
     */
    public Student(String u, String n, String m, ArrayList<String> cc) {
        username = u;
        name = n;
        m = major;
        completedCourses = cc;
    }

    public String toString() {
        return username+","+name+","+major+formatCourses();
    }

    public String formatCourses() {
        String toPrint = "";
        for (String course : completedCourses) {
            toPrint+=","+course;
        }
        return toPrint;
    }

    @Override
    public boolean equals(Object other) {
    	if (null==other) {
    		return false;
    	}
    	if (!(other instanceof Student)) {
    		return false;
    	}
    	Student s = (Student) other;
    	// usernames are unique, so this should be sufficient to test equivalency
    	return username.equals(s.username);
    }

    // TODO
    @Override
    public int compareTo(Student s2) {
        return -1;
    }
    
    public String username() { return username; }
    public String name() { return name; }
    public String major() { return major;}
	public ArrayList<String> courses() { return completedCourses; }


    public void username(String u) { username = u; }
    public void name(String n) { name = n; }
    public void major(String m) { major = m;}
	public void courses(ArrayList<String> c) { completedCourses = c; }


    static String[] names = { 
        "Amy", "Erik", "Pavel", "Matt", "Abdi", "Sadaq", "Miguel", "Jocelyn", "Adnan", "Luis", "Emily", "Drew", "Everett", "Ayden", "Walta", "Joshua", "Keiran", "Elias", "Faiaz", "Sergio", "Ivan", "Max", "Mohamed", "Awal", "Chelsey", "Johnny", "Pao", "Jaron", "Liban", "Taha", "Tenley", "Josh", "Xeng", "Gabriel", "Asli", "Hodan", "Jamila", "Amaal", "Ari", "Quinn", "Mohamud", "Derek", "Dori", "Guleid", "Yuva", "Rudwan", "Aisha", "Hamsa", "Ethan", "Talib", "Kwadwo", "Melissa", "Jake", "Chris", "Skyler", "Zach", "Liban", "Fatima", "Kodjo", "Corey", "Kebba", "Hannah", "Eric", "Jeffrey", "Esmeralda", "Leah", "Halah", "Krystal", "Rahma", "Romeo", "Ivie", "Andy", "Karen", "Elisha", "Khadro", "Adna", "Sundus", "Mohamed", "Ivan", "Timothy", "Vinny", "Mayali", "Betelehem", "Ermais", "Matt", "Collin", "Adnan", "Tommy", "Moua", "Long", "Miriam", "Keenan", "Sumayyah", "Nathan", "Matthew", "Angel", "Vivika", "Thor", "Brandon", "Andy", "Erica", "Bailey", "Ariana", "Linus", "Elliott", "Vincent", "Josh", "Sean", "Katelynn", "Saryn", "Bjorn", "Doua", "Amina", "Muna", "Xera", "Khaalid", "Mitchell", "Zakaria", "Leban", "Chris", "Khalid", "Ryan", "Alinase", "Brian", "Anna", "Zak", "Nikita", "Luke", "Ridwan", "Najma", "Brooklyn", "Ella", "Ceazar", "Mackenzie", "Stephanie", "Myles", "Christopher", "Kevin", "Jason", "Justin", "Odin", "Katie", "Jacob", "Lucy", "Vincent", "Najma", "Ly" 
    };
}
