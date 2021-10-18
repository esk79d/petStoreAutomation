package utils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlUtils {
    public Document convertStringToXMLDocument(String xmlString){
        DocumentBuilderFactory docFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder=null;
        try {
            docBuilder= docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Document convertXMLFileToXMLDocument(String filePath)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try
        {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            return doc;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public String convertDocToString(Document doc) {
        try {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        } catch (TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public Document setCustomerIdNodeValue(Document doc,String customerId) {
        doc.getDocumentElement().getAttributes().getNamedItem("CustomerId").setNodeValue(customerId);
        return doc;
    }
    public Document setCustomerPolicyIdNodeValue(Document doc,String customerPolicyId) {
        doc.getDocumentElement().getAttributes().getNamedItem("PolicyId").setNodeValue(customerPolicyId);
        return doc;
    }
}
