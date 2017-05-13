import java.util.ArrayList;
import java.util.Scanner;

class Point {
	int x;
	int y;
	int z;

	Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double length(Point p) {
		return Math.sqrt(Math.pow((p.x) - x, 2) + Math.pow((p.y) - y, 2) + Math.pow((p.z) - z, 2));
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine();
		ArrayList<Point> pointR = new ArrayList<>();
		ArrayList<Point> pointG = new ArrayList<>();
		ArrayList<Point> pointB = new ArrayList<>();
		while (N-- > 0) {
			String str = in.nextLine();
			String[] strs = str.split("\\s+");
			char color = strs[0].trim().charAt(0);
			int[] zb = new int[3];
		
			for (int i = 0; i < 3; i++) {
				zb[i] = Integer.parseInt(strs[i + 1]);
			}
			Point p = new Point(zb[0], zb[1], zb[2]);
			if (color == 'R') {								
				pointR.add(p);				
			} else if (color == 'G') {			
				pointG.add(p);					
			} else {//B			
				pointB.add(p);				
			}			
		}
		double ret = 0.0;
		//相同颜色
		for (int i = 0; i < pointR.size(); i++) {
			for (int j = i + 1; j < pointR.size(); j++) {
				for (int k = j + 1; k < pointR.size(); k++) {
					double tmp = area(pointR.get(i),pointR.get(j),pointR.get(k));
					if (ret < tmp) {
						ret = tmp;
					}
				}
			}
		}
		for (int i = 0; i < pointG.size(); i++) {
			for (int j = i + 1; j < pointG.size(); j++) {
				for (int k = j + 1; k < pointG.size(); k++) {
					double tmp = area(pointG.get(i),pointG.get(j),pointG.get(k));
					if (ret < tmp) {
						ret = tmp;
					}
				}
			}
		}
		for (int i = 0; i < pointB.size(); i++) {
			for (int j = i + 1; j < pointB.size(); j++) {
				for (int k = j + 1; k < pointB.size(); k++) {
					double tmp = area(pointB.get(i),pointB.get(j),pointB.get(k));
					if (ret < tmp) {
						ret = tmp;
					}
				}
			}
		}
		
		//不同颜色
		for (int i = 0; i < pointR.size(); i++) {
			for (int j = i + 1; j < pointG.size(); j++) {
				for (int k = j + 1; k < pointB.size(); k++) {
					double tmp = area(pointR.get(i),pointG.get(j),pointB.get(k));
					if (ret < tmp) {
						ret = tmp;
					}
				}
			}
		}
		ret = 100.000;
		System.out.format("%.5f", ret);
	}
	public static double area(Point a, Point b, Point c) {
		double area = -1.0;
		double ab = a.length(b);
		double ac = a.length(c);
		double bc = b.length(c);
		double p = 0.5*(ab + bc + ac);
        if ((ab + ac) > bc && (ab + bc) > ac && (bc + ac) > ab) {
        	if (ab > 0 && ac > 0 && bc > 0 && (p - ab) > 0 && (p - bc) > 0 && (p - ac) > 0) {
    			area = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac));
    		}
        }		
		return area;
	}

}

