import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import sun.net.www.protocol.http.HttpURLConnection;

public class IO_Object {


	public static final String GET_URL = "http://www.maniadb.com/api/search/윤하/?sr=artist&display=10&key=liante0904_gmail&v=0.5";

	public static final String POST_URL = "https://google.com";


	public static void readContentFromGet() throws IOException {

		// 끌어모았어 get 요청 URL 문자열 사용 URLEncoder.encode 대한 특별한 및 안 보이는 문자 인코딩 진행하다
		String getURL = GET_URL + "?name=" + URLEncoder.encode("zhangshan", "utf-8");
		URL getUrl = new URL(getURL);
		// 끌어모았어 URL을 열 따라 연결할 URL 형식은 따라 할 URL.openConnection 함수, 
		// 다시 다른 URLConnection 하위 클래스 대상, 여기 URL 한 http 때문에 실제 복귀 것은 HttpURLConnection
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		// 을 연결 하지만 실제로는 get request 반드시 다음 구의 connection.getInputStream () 함수 중 비로소 진정한 발 까지 서버
		connection.connect();
		// 확실한 입력 및 사용 Reader 읽기
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// 인코딩 설정 을 함께 했 다., 그렇지 않으면, 중국어
		System.out.println("=============================");
		System.out.println("Contents of get request");
		System.out.println("=============================");
		String lines;
		while ((lines = reader.readLine()) != null) {
			// lines = new String(lines.getBytes(), "utf-8");
			System.out.println(lines);
		}
		reader.close();
		// 연결 끊기
		connection.disconnect();
		System.out.println("=============================");
		System.out.println("Contents of get request ends");
		System.out.println("=============================");
	}

	public static void readContentFromPost() throws IOException {

		// Post 요청 url 및 get 다른 것은 필요 데리고 매개 변수
		URL postUrl = new URL(POST_URL);
		// 열 연결
		HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
		// Output to the connection. Default is false, set to true because post method must write something to the connection
		// 설정 여부 향해 connection 출력 때문에 이 post 요청, 인자 뒀다가 http 본문 안에 있기 때문에 필요하다. 기본값으로 true
		connection.setDoOutput(true);
		// Read from the connection. Default is true.
		connection.setDoInput(true);
		// Set the post method. Default is GET
		connection.setRequestMethod("POST");
		// Post cannot use caches
		// 못 Post 요청 캐시 사용하기
		connection.setUseCaches(false);

		// This method takes effects to every instances of this class.URLConnection.setFollowRedirects 것은 static 함수, 역할 은 모든 URLConnection 대상. 
		// connection.setFollowRedirects(true);

		// This rh, only takes effacts to this instance.URLConnection.setInstanceFollowRedirects 네 멤버 함수, 겨우 역할 은 현재 함수
		connection.setInstanceFollowRedirects(true);
		// Set the content type to urlencoded,because we will write some URL-encoded content to the connection. Settings above must be set before connect!
		// 연결 설정 Content-type 이번, 설정 을 application/x-www-form-urlencoded 말은 본문 은 urlencoded 인코딩 적이 form 매개 변수, 아래 우리 볼 수 우리에게 본문 내용 URLEncoder.encode 진행 인코딩 사용
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		// 연결 postUrl.openConnection (부터) 이 설정 반드시 connect 전에 완성해야 한다, 
		// 주의해야 하는 것은 connection.getOutputStream 잘 진행되고 있습니다 connect 숨다. 
		connection.connect();
		DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		// The URL-encoded contend
		// 본문, 본문 내용 사실 그 get URL 중 '?' 후 '문자열 일치
		String content = "name=" + URLEncoder.encode("장삼", "utf-8");
		// DataOutputStream.writeBytes 는 문자열 중 16비트 유니코드 문자 로 있는 8비트 문자 형태 됐어 흐름 속에
		out.writeBytes(content);
		out.flush();
		out.close();// flush and close
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));// 인코딩 설정 을 함께 했 다., 그렇지 않으면, 중국어
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
			readContentFromGet(); // get방식의 파싱 메소드를 실행합니다.
			//	readContentFromPost(); // post방식의 파싱 메소드를 실행합니다.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

