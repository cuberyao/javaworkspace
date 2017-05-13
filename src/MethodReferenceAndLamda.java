import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MethodReferenceAndLamda {

	public static void main(String[] args) {
		Random rand = new Random();
		int N = 10;
		List<Student> list = new ArrayList<>();
//		Student[] stus = new Student[N];
		for (int i = 0; i < N; i++) {
			list.add(new Student(rand.nextInt(100), "name_"+i));
		}
//		Collections.sort(list, Student::compareByAge);
//		Collections.sort(list, (s1, s2) -> (s1.getAge() - s2.getAge()));
		Collections.sort(list, Student::compare);
		//System.out.println(Student.compareByAge(list.get(0), list.get(1)));
		System.out.println(list);

	}

}
class Student {
	private int age;
	private String name;
	Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public static int compareByAge(Student s1, Student s2) {
		return s1.age - s2.age;
	}
	public int compare(Student other) {
		return this.age - other.age;
	}
	public String toString() {
		return this.name + "," + this.age;
	}
	
}
