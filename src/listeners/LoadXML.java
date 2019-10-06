package listeners;

import design.Design;
import managerGroup.Group;
import managerGroup.ManagerGroup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadXML implements ActionListener {
    private final ManagerGroup managerGroup;

    public LoadXML(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        try {
            DefaultTableModel model = (DefaultTableModel) Design.group.getModel();
            DefaultTableModel model1 = (DefaultTableModel) Design.group1.getModel();
            DefaultTableModel model2 = (DefaultTableModel) Design.group2.getModel();
            managerGroup.getGroups().clear();
            model.setRowCount(0);
            model1.setRowCount(0);
            model2.setRowCount(0);
            Design.groups.removeAllItems();
            Design.groups2.removeAllItems();

            File fileXML = new File("C:\\Users\\Dima\\Desktop\\Google Диск\\Programs\\OOP3lama5sem\\x-m-l");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileXML);

            NodeList groups = document.getElementsByTagName("group");
            for (int i = 0; i < groups.getLength(); i++) {
                Element group = (Element) groups.item(i);
                String gr=group.getAttribute("name");
                managerGroup.getGroups().add(new Group(gr));
                model.addRow(new Object[]{"", "", ""});
                Design.group.getModel().setValueAt(group.getAttribute("name"), i, 0);
                Design.groups.addItem(group.getAttribute("name"));
                Design.groups2.addItem(group.getAttribute("name"));
                Design.group.getModel().setValueAt(group.getAttribute("tour"), i, 1);
                Design.group.getModel().setValueAt(group.getAttribute("year"), i, 2);

                NodeList elStr=  group.getElementsByTagName("structure");
                Element el= (Element) elStr.item(0);
                NodeList plays = el.getElementsByTagName("employee");
                for (int j = 0; j < plays.getLength(); j++) {
                    Element play = (Element) plays.item(j);
                    String pl=play.getAttribute("name");
                    managerGroup.getGroup(gr).getStructure().add(pl);
                }

                NodeList elPer=  group.getElementsByTagName("repertoire");
                Element elP= (Element) elPer.item(0);
                NodeList persons = elP.getElementsByTagName("employee");
                for (int j = 0; j < persons.getLength(); j++) {
                    Element person = (Element) persons.item(j);
                    String pe=person.getAttribute("name");
                    managerGroup.getGroup(gr).getRepertoire().add(pe);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



