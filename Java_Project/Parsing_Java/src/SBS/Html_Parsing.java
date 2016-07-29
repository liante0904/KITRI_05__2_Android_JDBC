package SBS;
import java.io.IOException;

import org.jsoup.Jsoup; //import Jsoup
import org.jsoup.nodes.Document; //import Jsoup
import org.jsoup.select.Elements; //import Jsoup


public class Html_Parsing {

	String url = "http://radio.sbs.co.kr/music/wizard_broadcast_renew.jsp?vod_id=V0000330602&year=2016&month=07&day=25&position_code=romanticage";
			
	
	public void html() {
		try {
		      Document doc = Jsoup.connect(url).get(); //웹에서 내용을 가져온다.
		
		      
		      Elements head = doc.select("div.schedule_date");
		      String txt = head.text();
		      if (url.contains("code=romanticage")) {
		    	  txt += "최백호의 낭만시대";
			}
		      System.out.println(txt.replace("닫기", ""));
		      
		      
		      Elements contents = doc.select("span.rml_singer_name"); //내용을 가져온다.
		    //   String text = contents.attr("title"); //attr은 기본적으로 String형이다. 
		      String text = contents.text();
		      // System.out.println(txt + "\n - " + text);
		      
		      
		       if (doc != null) {
					 Elements title1 = doc.select("span.rml_songname");
				      Elements artist = doc.select("span.rml_singer_name");
					 for (int i = 0; i < title1.size(); i++) {
						System.out.println( artist.get(i).text() + "  -  " + title1.get(i).text() );
					}
		       }
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
