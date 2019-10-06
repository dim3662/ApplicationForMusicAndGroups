package listeners;

import design.Design;
import managerGroup.Group;
import managerGroup.ManagerGroup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveXML implements ActionListener {
    private final ManagerGroup managerGroup;

    public SaveXML(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    public void actionPerformed(ActionEvent actionEvent) {

        try {
            File fileXML = new File("C:\\Users\\Dima\\Desktop\\Google Диск\\Programs\\OOP3lama5sem\\x-m-l");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("Groups");

            for(int i=0;i< Design.group.getRowCount();i++) {
                    Element el = document.createElement("group");//add name year tour
                    el.setAttribute("name", (String) Design.group.getModel().getValueAt(i,0));
                    el.setAttribute("tour", (String) Design.group.getModel().getValueAt(i,1));
                    el.setAttribute("year", (String) Design.group.getModel().getValueAt(i,2));
                    String nameGroup= (String) Design.group.getModel().getValueAt(i,0);
                    Element elS = document.createElement("structure");
                    for (String string : managerGroup.getGroup(nameGroup).getStructure()) {
                        Element elE = document.createElement("employee");
                        elE.setAttribute("name", string);
                        elS.appendChild(elE);
                    }
                    el.appendChild(elS);

                    Element elR = document.createElement("repertoire");
                    for (String string : managerGroup.getGroup(nameGroup).getRepertoire()) {
                        Element elER = document.createElement("employee");
                        elER.setAttribute("name", string);
                        elR.appendChild(elER);
                    }
                    el.appendChild(elR);

                    rootElement.appendChild(el);
                }

            document.appendChild(rootElement);

            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            // send DOM to file
            tr.transform(new DOMSource(document),
                    new StreamResult(new FileOutputStream(fileXML)));


        } catch (ParserConfigurationException | TransformerConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
