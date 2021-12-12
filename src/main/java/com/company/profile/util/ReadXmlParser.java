package com.company.profile.util;

import com.company.profile.dto.Company;
import com.company.profile.exception.InternalServiceErrorException;
import com.company.profile.exception.ResourceNotFoundException;
import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXmlParser {

  public static final String XML_FILETYPE = ".xml";

  public static Company xmlParser(String path, String companyId) {
    // Instantiate the Factory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    try {

      // optional, but recommended
      // process XML securely, avoid attacks like XML External Entities (XXE)
      dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

      // parse XML file
      DocumentBuilder db = dbf.newDocumentBuilder();

      Document doc = db.parse(new File(path + companyId + XML_FILETYPE));

      doc.getDocumentElement().normalize();

      System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
      System.out.println("------");

      NodeList list = doc.getElementsByTagName("Data");

      for (int temp = 0; temp < list.getLength(); temp++) {

        Node node = list.item(temp);

        if (node.getNodeType() == Node.ELEMENT_NODE) {

          Element element = (Element) node;

          String id = element.getElementsByTagName("id").item(0).getTextContent();
          String name = element.getElementsByTagName("name").item(0).getTextContent();
          String description = element.getElementsByTagName("description").item(0).getTextContent();

          System.out.println("Current Element :" + node.getNodeName());
          System.out.println("Staff Id : " + id);
          System.out.println("name : " + name);
          System.out.println("description : " + description);

          return Company.of(Integer.parseInt(id), name, description);
        }
      }

    } catch (IOException e) {

      System.out.println("exception encountered : " + e.getMessage());
      throw new ResourceNotFoundException("ResourceNotFoundException");

    } catch (ParserConfigurationException | NullPointerException | SAXException | NumberFormatException e) {

      System.out.println("exception encountered : " + e.getMessage());
      throw new InternalServiceErrorException("InternalServiceErrorException");
    }

    throw new InternalServiceErrorException("InternalServiceErrorException");
  }
}
