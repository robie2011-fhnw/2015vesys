package playground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import sun.net.www.protocol.http.HttpURLConnection;

public class testclient2 {
	public static void main(String[] args) throws IOException {
			URL url = new URL("http://www.google.ch/?gws_rd=ssl");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);		
			con.setRequestMethod("GET");
			con.connect();
				
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			System.out.println(bufferedReader.readLine());

			
			con.getOutputStream().write(1);
			
	}
}
