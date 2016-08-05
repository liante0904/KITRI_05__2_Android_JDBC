package Naver_Signin;
import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
public class XmlParsering {
 
	//XML�� �⺻������ ������. 
    public static void main(String[] args) {
 
        try{
 
            new XmlParsering().start();
 
        }catch (Exception e){
            e.printStackTrace();
        }
 
    }
 
    private void start() throws Exception{
 
    	File fXmlFile = new File("c:\\naver.xml");
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList descNodes = doc.getElementsByTagName("response");
 
        for(int i=0; i<descNodes.getLength();i++){
 
            for(Node node = descNodes.item(i).getFirstChild(); node!=null; node=node.getNextSibling()){ 
 
                if(node.getNodeName().equals("email")){
                    System.out.println(node.getTextContent());
                }else if(node.getNodeName().equals("nickname")){
                    System.out.println(node.getTextContent());
                }else if(node.getNodeName().equals("name")){
                    System.out.println(node.getTextContent());
                }
 
            }
 
        }
    }
 
    
 
}