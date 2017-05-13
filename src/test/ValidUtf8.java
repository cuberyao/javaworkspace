package test;

public class ValidUtf8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
        	data[i] = data[i] & 0b11111111;
        }
        return true;
    }

}
