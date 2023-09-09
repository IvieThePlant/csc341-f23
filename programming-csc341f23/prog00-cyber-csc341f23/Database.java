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
		// Find the username in the ArrayList.
		int x = 0;
		boolean userfound = false;
		while (x < usernames.length and not userfound) {
			if (username.equals(usernames[x].get(1)) {
				userfound = true;
			} elif {
				x ++;
			}
		}

		// If the username is valid, hash the password entered by the user 
		//(using the hash method in Hasher). If not, return false.
		if (x < usernames.length) {
			// Compare the newly hashed password against the one stored in the ArrayList.
			// If they match, credentials are valid, return true. Else return false.
			if (hasher.hash(password).equals(usernames.))
		}
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

			// Put each line into new Student and store in array.
			ArrayList<Student> students = new ArrayList<>();
			while(scanner.hasNextLine()){
				String[] dataLine = scanner.nextLine().split(",");
				ArrayList<String> classes = new ArrayList<>();
				for (int x = 3; x < dataLine.length; x ++) {
					classes.add(dataLine[x]);
				}
				Student daStudent = new Student(dataLine[0], dataLine[1], dataLine[2], classes);
				students.add(daStudent);
			}
			scanner.close();
		}catch(Exception e) {
			System.out.println(e);
		}

		// return new array
		return students;
	}

}