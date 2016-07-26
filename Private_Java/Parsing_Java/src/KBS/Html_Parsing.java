package KBS;
import java.io.IOException;

import org.jsoup.Jsoup; //import Jsoup
import org.jsoup.nodes.Document; //import Jsoup
import org.jsoup.select.Elements; //import Jsoup


public class Html_Parsing {
 // 타깃 URL - > http://www.kbs.co.kr/radio/happyfm/7080/song/index.html?bbs_pr=/mode:2/seq:598546/goto_page:1
	
	public void html() {
		try {
		      Document doc = Jsoup.connect("http://nbbs.kbs.co.kr/section/board/bbs_view.html?bbs_cd=2r_7080_bbs07&seq=599716&goto_page=1").get(); //웹에서 내용을 가져온다.
		      System.out.println(doc.title());
		      Elements title = doc.select("div.view_title");
		      String txt = title.text();
		      System.out.println(txt);
		      
		      //
		      Elements contents = doc.select("div.view_cont p"); //내용을 가져온다.
		      // String text = contents.attr("title"); //attr은 기본적으로 String형이다. 
		      String text = contents.text();
		      System.out.println(text);
		      // System.out.println(text);
		} catch (IOException e) { //Jsoup의 connect 부분에서 IOException 오류가 날 수 있으므로 사용한다.
		      e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Html_Parsing hp = new Html_Parsing();
		hp.html();
		
	}
	
	
}
