package KBS;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
 
public class XmlParsering {
 
	//XML은 기본적으로 제공함. 
    public static void main(String[] args) {
 
        try{
 
            new XmlParsering().start();
 
        }catch (Exception e){
            e.printStackTrace();
        }
 
    }
 
    private void start() throws Exception{
        URL url = new URL("http://nbbs.kbs.co.kr/rss/2r_7080_bbs07.xml");
        URLConnection connection = url.openConnection();
 
        Document doc = parseXML(connection.getInputStream());
        NodeList descNodes = doc.getElementsByTagName("channel");
 
        for(int i=0; i<descNodes.getLength();i++){
 
            for(Node node = descNodes.item(i).getFirstChild(); node!=null; node=node.getNextSibling()){ //첫번째 자식을 시작으로 마지막까지 다음 형제를 실행
 
                if(node.getNodeName().equals("item")){
                    System.out.println(node.getTextContent());
                }else if(node.getNodeName().equals("title")){
                    System.out.println(node.getTextContent());
                }else if(node.getNodeName().equals("link")){
                    System.out.println(node.getTextContent());
                }
 
            }
 
        }
    }
 
    private Document parseXML(InputStream stream) throws Exception{
 
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
 
        try{
 
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
 
            doc = objDocumentBuilder.parse(stream);
 
        }catch(Exception ex){
            throw ex;
        }       
 
        return doc;
    }
 
}