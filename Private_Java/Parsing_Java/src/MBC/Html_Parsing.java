package MBC;
import java.io.IOException;

import org.jsoup.Jsoup; //import Jsoup
import org.jsoup.nodes.Document; //import Jsoup
import org.jsoup.select.Elements; //import Jsoup


public class Html_Parsing {

	// Ÿ�� URL ->  http://wizard2.sbs.co.kr/w3/template/tpl_iframetype.jsp?vVodId=V0000330602&vProgId=1000456&vMenuId=1009772
	
	public void html() {
		try {
		      Document doc = Jsoup.connect("http://mini.imbc.com/manager/SelectView.asp?PROG_CD=FM4U000001271&SeqNo=1061&PG=1").get(); //������ ������ �����´�.
		   //   System.out.println(doc.title());
		      Elements title = doc.select("td p");
		      String txt = title.text();
		      System.out.println(txt);
		      
		      
		      Elements contents = doc.select("td.td_artist"); //������ �����´�.
		    //   String text = contents.attr("title"); //attr�� �⺻������ String���̴�. 
		      String text = contents.text();
		       System.out.println(text);
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
