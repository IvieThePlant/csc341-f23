public class Course implements Comparable<Course>{
	private String dept;
	private Integer number;
	private String description;
	
	public Course(String d, Integer n, String desc) {
		dept = d;
		number = n;
		description = desc;
	}
	
	@Override
	public String toString() {
		return dept+number+" ";
	}
	
	public String dept() { return dept; }
	public Integer number() { return number; }

	@Override
	public boolean equals(Object o) {
		if (o instanceof Course) {
			Course oCourse = (Course) o;
			if (this.dept.equals(oCourse.dept)) {
				if (this.number == oCourse.number) {
					if (this.description.equals(oCourse.description)){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public int compareTo(Course o) {
		Course oCourse = (Course) o;
		int res = this.dept.compareTo(oCourse.dept);
		if (res == 0) {
			res = this.number.compareTo(oCourse.number);
			if (res == 0) {
				return this.description.compareTo(oCourse.description);
			} else {
				return res;
			}
		} else {
			return res;
		}
	}
}