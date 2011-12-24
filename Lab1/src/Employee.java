package lab1;

public class Employee {
	private static int[] nextIds = {
		84, 43, 54, 6, 79,
		76, 30, 20, 44, 47,
		50, 11, 16, 4, 69,
		4, 98, 41, 95, 46,
	};
	
	private static int idx;	

	private int id;
	private String name;
	private int age;
	
	private Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public static void reset() {
		idx = 0;
	}
	
	public static Employee newInstance(String name, int age) {
		return new Employee(nextIds[idx++], name, age);
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return id + ":[" + name + ", " + age + "]";	
	}
}
