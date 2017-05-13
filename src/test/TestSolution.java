package test;

public class TestSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(){
			public void run(){
				System.out.print("ping");
			}
			
		};
		t.run();
		print();

	}
	static void print() {
		System.out.print("pong");
	}

}
