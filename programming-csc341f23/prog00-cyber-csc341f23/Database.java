import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

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
		try{
			File file = new File("users.txt");
			ArrayList<Pair> usernames = new ArrayList<Pair>();
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				// Put each line into new Pair with user value1 and pwd value2
				String[] data = scanner.nextLine().split(",");
				Pair pair = new Pair(data[0],data[1]);

				// Store in new array
				usernames.add(pair);
			} 
			scanner.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		// return new array
    	return usernames;
    }

	/** Open students file and load contents. */
	public ArrayList<Student> loadStudents() {
		// Open students.csv -- must use try-catch
		try{
			File file = new File("students.csv");
			Scanner scanner = new Scanner(file);
			ArrayList<Student> students = new ArrayList<Student>();
			while(scanner.hasNextLine()){
				String[] dataLine = scanner.nextLine().split(",");
				for () {
					
				}
				Student daStudent = new Student(dataLine[0], dataLine[1], dataLine[2], null);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		// Put each line into new Student and store in array.
		
		// return new array
		return null;
	}

}