import java.util.ArrayList;

public class Database {

	Hasher hasher = null;

	private ArrayList<Pair> usernames;
	private ArrayList<Student> students;
	
	public Database(Hasher h) {
		hasher = h;
		usernames = loadUsernames();
		students = loadStudents();
	}
	
	private boolean validCredentials(String username, String password) {
	
		return false;
	}
	
	/** Open users file and load contents. */
	public ArrayList<Pair> loadUsernames() {
	
		// Open users.txt file -- must use try-catch
		
		// Put each line into new Pair with user value1 and pwd value2
		// Store in new array
	
		// return new array
    	return null;
    }

	/** Open students file and load contents. */
	public ArrayList<Student> loadStudents() {
	
		// Open students.csv -- must use try-catch
		
		// Put each line into new Student and store in array.
		
		// return new array
		return null;
	}

}