public class Course {
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
		return dept+number+" "+description;
	}
	
	public String dept() { return dept; }
	public Integer number() { return number; }
}