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
	
	/** Checks the given username and password against the usernames ArrayList
	 * @param username Username of logging in user
	 * @param password Password(unhashed) to be checked
	 * @return True if valid, else False
	 */
	public boolean validCredentials(String username, String password) {
		// Find the username in the ArrayList.
		int x = 0;
		boolean userfound = false;
		while (x < usernames.size() &&  !userfound) {
			if (username.equals(usernames.get(x).get(1))) {
				userfound = true;
			} else {
				x ++;
			}
		}

		// If the username is valid, hash the password entered by the user 
		//(using the hash method in Hasher). If not, return false.
		if (x < usernames.size()) {
			// Compare the newly hashed password against the one stored in the ArrayList.
			// If they match, credentials are valid, return true. Else return false.
			if (hasher.hash(password).equals(usernames.get(x).get(2))) {
				return true;
			}
		}

		return false;
	}
	
	/** Open users file and load contents. 
	 * @return ArrayList of username and hashed password pairs from users.txt
	*/
	public ArrayList<Pair> loadUsernames() {
		// Open users.txt file -- must use try-catch
		try{
			File file = new File("users.txt");

			ArrayList<Pair> loadedUsers = new ArrayList<Pair>();
			Scanner scanner = new Scanner(file);

			while(scanner.hasNextLine()){
				// Put each line into new Pair with user value1 and pwd value2
				String[] data = scanner.nextLine().split(",", 8);
				Pair pair = new Pair(data[0],data[1]);

				// Store in new array
				loadedUsers.add(pair);
			} 
			scanner.close();
			// return new array
			return loadedUsers;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
    }

	/** Open students file and load contents. 
	 * @return Arraylist of all Student objects from students.csv
	*/
	public ArrayList<Student> loadStudents() {
		// Open students.csv -- must use try-catch
		try{
			File file = new File("students.csv");
			Scanner scanner = new Scanner(file);

			// Put each line into new Student and store in array.
			ArrayList<Student> loadedStudents = new ArrayList<>();
			while(scanner.hasNextLine()){
				String[] dataLine = scanner.nextLine().split(",");
				ArrayList<String> classes = new ArrayList<>();
				for (int x = 3; x < dataLine.length; x ++) {
					classes.add(dataLine[x]);
				}
				Student daStudent = new Student(dataLine[0], dataLine[1], dataLine[2], classes);
				loadedStudents.add(daStudent);
			}
			scanner.close();
			// return new array
			return loadedStudents;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	/**
	 * Getter for Students
	 */
	public Student student(String username) {
		int x = 0;
		boolean userfound = false;
		while (x < students.size() &&  !userfound) {
			if (username.equals(students.get(x).username())) {
				userfound = true;
			} else {
				x ++;
			}
		}
		if (x < students.size()) {
			return students.get(x);
		}
		return null;
	}
}