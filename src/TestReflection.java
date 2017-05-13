import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String str = "T";
		Class c = Class.forName(str);
		c.newInstance();
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			if (m.getName().equals("m1")) {
				m.invoke(c.newInstance());
			}
		}
	}

}
class T {
	int i;
	public T() {
		System.out.println("T constructed");
	}
	
	public void m1() {
		System.out.println("m1 invoked!");
	}
	
	public void m2(int i) {
		this.i = i;
	}
	
}