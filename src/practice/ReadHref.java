package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReadHref {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String uri = "C:\\Users\\Yao\\Desktop\\view-source_sports.qq.com_nba_.html";
		String href = "C:\\Users\\Yao\\Desktop\\allhref.txt";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(uri)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(href)));
		String line = null;
		while ((line = br.readLine()) != null) {
			int i = line.indexOf("href=\"http");
			if (i >= 0) {
				line = line.substring(i+6);
				i = line.indexOf("\"");
				String url = line.substring(0, i);
				
				bw.write(url);
				bw.newLine();
				//bw.flush();
			}
		}
		bw.close();
		br.close();
	}

}
