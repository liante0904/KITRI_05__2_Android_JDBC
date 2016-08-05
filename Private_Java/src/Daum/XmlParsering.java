package Daum;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

 
public class XmlParsering {
 

    public static void main(String[] args) {
 
    	
    	Document doc;
		try {
			doc = Jsoup.connect("https://apis.daum.net/local/v1/search/keyword.xml?apikey=b3577b4fc3d1d40c051fcba963f452ec&query=%EC%9D%BC%EC%8B%9D").get();
			Elements titles = doc.select("title");
			Elements newAddress = doc.select("newAddress");
			
			for(Element e: titles){
				System.out.println("download: " + e.text());
			}
			for(Element e1: newAddress){
				System.out.println("download: " + e1.text());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    }
}