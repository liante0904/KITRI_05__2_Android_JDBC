package KBS;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup; //import Jsoup
import org.jsoup.nodes.Document; //import Jsoup
import org.jsoup.select.Elements; //import Jsoup

import com.sun.javafx.scene.paint.GradientUtils.Parser;


public class Html_Parsing {
 // 타깃 URL - > http://www.kbs.co.kr/radio/happyfm/7080/song/index.html?bbs_pr=/mode:2/seq:598546/goto_page:1
	String url = "http://nbbs.kbs.co.kr/section/board/bbs_view.html?bbs_cd=2r_want_bbs01&seq=605067&goto_page=1";
	
	/*String url = "http://nbbs.kbs.co.kr/section/board/"
      		+ "bbs_view.html?bbs_cd=2r_7080_bbs07&seq=599716&goto_page=1";
	*/
	
	
	
	

	
	public void html() {
		try {
			Document doc = Jsoup.parse(new URL(url).openStream(), "utf-8", url);
		      /*Document doc = Jsoup.connect("http://nbbs.kbs.co.kr/section/board/"
		      		+ "bbs_view.html?bbs_cd=2r_7080_bbs07&seq=599716&goto_page=1").get(); //웹에서 내용을 가져온다.
*/
		      Elements title = doc.select("div.view_title");
		      String txt = title.text();
		      System.out.println(txt); // 날짜 부분
		      
		      
		      Elements contents = doc.select("div.view_cont"); //내용을 가져온다.
		      // String text = contents.attr("title"); //attr은 기본적으로 String형이다. 
		      
		       System.out.println("@@@@@" + contents);
		      String text = contents.text();
		      String replace = text.replace("\u00a0", "");
		     // System.out.println(text);
		      System.out.println(replace);

		   /*   replace.indexOf("1.");
		      System.out.println(replace.indexOf("1."));
		      System.out.println(replace.indexOf("2."));
		      System.out.println(replace.indexOf("3."));
		      System.out.println(replace.indexOf("4."));
		      System.out.println(replace.lastIndexOf("1."));
		      System.out.println(replace.lastIndexOf("2."));
		      System.out.println(replace.lastIndexOf("3."));
		      System.out.println(replace.lastIndexOf("4."));
		      System.out.println(replace.length());
		      
		      System.out.println(replace.indexOf("<선물받으실"));
		      System.out.println(replace.substring(replace.indexOf("<선물받으실"), replace.length()));
		      System.out.println(replace.substring(0, replace.indexOf("<선물받으실")));
		      */
		      
		      
		} catch (IOException e) { //Jsoup의 connect 부분에서 IOException 오류가 날 수 있으므로 사용한다.
		      e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Html_Parsing hp = new Html_Parsing();
		hp.html();
		
	}
	
	
}
