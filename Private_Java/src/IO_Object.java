import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import sun.net.www.protocol.http.HttpURLConnection;

public class IO_Object {


	public static final String GET_URL = "http://www.maniadb.com/api/search/����/?sr=artist&display=10&key=liante0904_gmail&v=0.5";

	public static final String POST_URL = "https://google.com";


	public static void readContentFromGet() throws IOException {

		// �����Ҿ� get ��û URL ���ڿ� ��� URLEncoder.encode ���� Ư���� �� �� ���̴� ���� ���ڵ� �����ϴ�
		String getURL = GET_URL + "?name=" + URLEncoder.encode("zhangshan", "utf-8");
		URL getUrl = new URL(getURL);
		// �����Ҿ� URL�� �� ���� ������ URL ������ ���� �� URL.openConnection �Լ�, 
		// �ٽ� �ٸ� URLConnection ���� Ŭ���� ���, ���� URL �� http ������ ���� ���� ���� HttpURLConnection
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		// �� ���� ������ �����δ� get request �ݵ�� ���� ���� connection.getInputStream () �Լ� �� ��μ� ������ �� ���� ����
		connection.connect();
		// Ȯ���� �Է� �� ��� Reader �б�
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// ���ڵ� ���� �� �Բ� �� ��., �׷��� ������, �߱���
		System.out.println("=============================");
		System.out.println("Contents of get request");
		System.out.println("=============================");
		String lines;
		while ((lines = reader.readLine()) != null) {
			// lines = new String(lines.getBytes(), "utf-8");
			System.out.println(lines);
		}
		reader.close();
		// ���� ����
		connection.disconnect();
		System.out.println("=============================");
		System.out.println("Contents of get request ends");
		System.out.println("=============================");
	}

	public static void readContentFromPost() throws IOException {

		// Post ��û url �� get �ٸ� ���� �ʿ� ������ �Ű� ����
		URL postUrl = new URL(POST_URL);
		// �� ����
		HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
		// Output to the connection. Default is false, set to true because post method must write something to the connection
		// ���� ���� ���� connection ��� ������ �� post ��û, ���� �״ٰ� http ���� �ȿ� �ֱ� ������ �ʿ��ϴ�. �⺻������ true
		connection.setDoOutput(true);
		// Read from the connection. Default is true.
		connection.setDoInput(true);
		// Set the post method. Default is GET
		connection.setRequestMethod("POST");
		// Post cannot use caches
		// �� Post ��û ĳ�� ����ϱ�
		connection.setUseCaches(false);

		// This method takes effects to every instances of this class.URLConnection.setFollowRedirects ���� static �Լ�, ���� �� ��� URLConnection ���. 
		// connection.setFollowRedirects(true);

		// This rh, only takes effacts to this instance.URLConnection.setInstanceFollowRedirects �� ��� �Լ�, �ܿ� ���� �� ���� �Լ�
		connection.setInstanceFollowRedirects(true);
		// Set the content type to urlencoded,because we will write some URL-encoded content to the connection. Settings above must be set before connect!
		// ���� ���� Content-type �̹�, ���� �� application/x-www-form-urlencoded ���� ���� �� urlencoded ���ڵ� ���� form �Ű� ����, �Ʒ� �츮 �� �� �츮���� ���� ���� URLEncoder.encode ���� ���ڵ� ���
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		// ���� postUrl.openConnection (����) �� ���� �ݵ�� connect ���� �ϼ��ؾ� �Ѵ�, 
		// �����ؾ� �ϴ� ���� connection.getOutputStream �� ����ǰ� �ֽ��ϴ� connect ����. 
		connection.connect();
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		// The URL-encoded contend
		// ����, ���� ���� ��� �� get URL �� '?' �� '���ڿ� ��ġ
		String content = "name=" + URLEncoder.encode("���", "utf-8");
		// DataOutputStream.writeBytes �� ���ڿ� �� 16��Ʈ �����ڵ� ���� �� �ִ� 8��Ʈ ���� ���� �ƾ� �帧 �ӿ�
		out.writeBytes(content);
		out.flush();
		out.close();// flush and close
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// ���ڵ� ���� �� �Բ� �� ��., �׷��� ������, �߱���
		String line = "";
		System.out.println("=============================");
		System.out.println("Contents of post request");
		System.out.println("=============================");
		while ((line = reader.readLine()) != null) {
			// line = new String(line.getBytes(), "utf-8");
			System.out.println(line);
		}
		System.out.println("=============================");
		System.out.println("Contents of post request ends");
		System.out.println("=============================");
		reader.close();
		connection.disconnect();
	}


	public static void main(String[] args) {
		try {
			readContentFromGet(); // get����� �Ľ� �޼ҵ带 �����մϴ�.
			//	readContentFromPost(); // post����� �Ľ� �޼ҵ带 �����մϴ�.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

