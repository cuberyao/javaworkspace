import java.io.File;

public class LargestFileSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File rootfile = new File("F:\\JAVA×ÊÁÏ");
		File[] files = rootfile.listFiles();
		long largestSize = -1;
		for (File f : files) {
			long tmp;
			if ((tmp = fileSize(f)) > largestSize) {
				largestSize = tmp; 
			}
		}
		System.out.println(largestSize/1024/1024);

	}
	
	public static long fileSize(File f) {
		if (!f.isDirectory()) {
			return f.length();
		} else {
			long sum = 0;
			for (File subfolder : f.listFiles()) {
				sum += fileSize(subfolder);
			}
			return sum;
		}
	}

}
//class File {
//	File(String path) {
//		
//	}
//	boolean isDirectory() {
//		return true;
//	}
//	File[] listFiles() {
//		
//	}
//}
