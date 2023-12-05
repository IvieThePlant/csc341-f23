import java.util.ArrayList;
import java.util.LinkedList;

public class Dictionary {

    LinkedList<Student>[] dict;

    public Dictionary() {
        dict = new LinkedList[20];
    }

    boolean isEmpty() {
        for (LinkedList<Student> row : dict) {
            if (!row.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    boolean containsKey(String key) {
        for (Student stu : dict[hash(key)]) {
            if (stu.username().equals(key)) {
                return true;
            }
        }
        return false;
    }

    Student get(String uname) {
        for (Student stu : dict[hash(uname)]) {
            if (stu.username().equals(uname)) {
                return stu;
            }
        }
        return null;
    }

    void put(String uname, Student student) {
        dict[0];
    }

    int hash(String uname) {
        uname += "aaa";
        return ((int) uname.charAt(0) + (int) uname.charAt(1) + (int) uname.charAt(2));
    }
}