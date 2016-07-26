package MBC;
import java.io.IOException;

import org.jsoup.Jsoup; //import Jsoup
import org.jsoup.nodes.Document; //import Jsoup
import org.jsoup.select.Elements; //import Jsoup


public class Html_Parsing {

	// 타깃 URL ->  http://wizard2.sbs.co.kr/w3/template/tpl_iframetype.jsp?vVodId=V0000330602&vProgId=1000456&vMenuId=1009772
	
	public void html() {
		try {
		      Document doc = Jsoup.connect("http://mini.imbc.com/manager/SelectView.asp?PROG_CD=FM4U000001271&SeqNo=1061&PG=1").get(); //웹에서 내용을 가져온다.
		   //   System.out.println(doc.title());
		      Elements title = doc.select("td p");
		      String txt = title.text();
		      System.out.println(txt);
		      
		      
		      Elements contents = doc.select("td.td_artist"); //내용을 가져온다.
		    //   String text = contents.attr("title"); //attr은 기본적으로 String형이다. 
		      String text = contents.text();
		       System.out.println(text);
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
