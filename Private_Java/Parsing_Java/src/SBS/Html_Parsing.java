package SBS;
import java.io.IOException;

import org.jsoup.Jsoup; //import Jsoup
import org.jsoup.nodes.Document; //import Jsoup
import org.jsoup.select.Elements; //import Jsoup


public class Html_Parsing {

	
	public void html() {
		try {
		      Document doc = Jsoup.connect("http://radio.sbs.co.kr/music/wizard_broadcast_renew.jsp?vod_id=V0000330602&year=2016&month=07&day=25&position_code=romanticage").get(); //������ ������ �����´�.
		   //   System.out.println(doc.title());
		      Elements title = doc.select("span.rml_songname");
		      String txt = title.text();
		    //  System.out.println(txt);
		      
		      
		      Elements contents = doc.select("span.rml_singer_name"); //������ �����´�.
		    //   String text = contents.attr("title"); //attr�� �⺻������ String���̴�. 
		      String text = contents.text();
		      System.out.println(txt + "\n - " + text);
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
