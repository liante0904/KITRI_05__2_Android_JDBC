package SBS;
import java.io.IOException;

import org.jsoup.Jsoup; //import Jsoup
import org.jsoup.nodes.Document; //import Jsoup
import org.jsoup.select.Elements; //import Jsoup


public class Html_Parsing {

	
	public void html() {
		try {
		      Document doc = Jsoup.connect("http://radio.sbs.co.kr/music/wizard_broadcast_renew.jsp?vod_id=V0000330602&year=2016&month=07&day=25&position_code=romanticage").get(); //웹에서 내용을 가져온다.
		   //   System.out.println(doc.title());
		      Elements title = doc.select("span.rml_songname");
		      String txt = title.text();
		    //  System.out.println(txt);
		      
		      
		      Elements contents = doc.select("span.rml_singer_name"); //내용을 가져온다.
		    //   String text = contents.attr("title"); //attr은 기본적으로 String형이다. 
		      String text = contents.text();
		      System.out.println(txt + "\n - " + text);
		} catch (IOException e) { //Jsoup의 connect 부분에서 IOException 오류가 날 수 있으므로 사용한다.
		      e.printStackTrace();
		}
	}
	
	// 파싱 성공 데이터 출력부 수정
	public static void main(String[] args) {
		Html_Parsing hp = new Html_Parsing();
		hp.html();
		
	}
	
	
}
