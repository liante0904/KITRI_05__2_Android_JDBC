package SBS;
import java.io.IOException;

import org.jsoup.Jsoup; //import Jsoup
import org.jsoup.nodes.Document; //import Jsoup
import org.jsoup.select.Elements; //import Jsoup


public class Html_Parsing {

	String url = "http://radio.sbs.co.kr/music/wizard_broadcast_renew.jsp?vod_id=V0000330602&year=2016&month=07&day=25&position_code=romanticage";
			
	
	public void html() {
		try {
		      Document doc = Jsoup.connect(url).get(); //������ ������ �����´�.
		
		      
		      Elements head = doc.select("div.schedule_date");
		      String txt = head.text();
		      if (url.contains("code=romanticage")) {
		    	  txt += "�ֹ�ȣ�� �����ô�";
			}
		      System.out.println(txt.replace("�ݱ�", ""));
		      
		      
		      Elements contents = doc.select("span.rml_singer_name"); //������ �����´�.
		    //   String text = contents.attr("title"); //attr�� �⺻������ String���̴�. 
		      String text = contents.text();
		      // System.out.println(txt + "\n - " + text);
		      
		      
		       if (doc != null) {
					 Elements title1 = doc.select("span.rml_songname");
				      Elements artist = doc.select("span.rml_singer_name");
					 for (int i = 0; i < title1.size(); i++) {
						System.out.println( artist.get(i).text() + "  -  " + title1.get(i).text() );
					}
		       }
		} catch (IOException e) { //Jsoup�� connect �κп��� IOException ������ �� �� �����Ƿ� ����Ѵ�.
		      e.printStackTrace();
		}
	}
	
	// �Ľ� ���� ������ ��º� ����
	public static void main(String[] args) {
		Html_Parsing hp = new Html_Parsing();
		hp.html();
		
	}
	
	
}
