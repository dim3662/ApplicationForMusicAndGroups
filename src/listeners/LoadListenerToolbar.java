package listeners;

import design.Design;
import managerGroup.Group;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoadListenerToolbar extends Component implements ActionListener {
    private final ManagerGroup managerGroup;

    public LoadListenerToolbar(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setDialogTitle("Select file from load");
        int returnVal = chooser.showDialog(this, "Load");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                System.out.println(file.getAbsolutePath());
                DefaultTableModel model = (DefaultTableModel) Design.group.getModel();
                DefaultTableModel model1 = (DefaultTableModel) Design.group1.getModel();
                DefaultTableModel model2 = (DefaultTableModel) Design.group2.getModel();
                managerGroup.getGroups().clear();
                model.setRowCount(0);
                model1.setRowCount(0);
                model2.setRowCount(0);
                Design.groups.removeAllItems();
                Design.groups2.removeAllItems();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                int k = 0;
                while (line != null) {
                    String nameGroup = line.substring(2);
                    managerGroup.getGroups().add(new Group(nameGroup));
                    model.addRow(new Object[]{"", "", ""});
                    Design.group.getModel().setValueAt(nameGroup, k, 0);
                    Design.groups.addItem(nameGroup);
                    Design.groups2.addItem(nameGroup);
                    line = reader.readLine();
                    Design.group.getModel().setValueAt(line.substring(2), k, 1);
                    line = reader.readLine();
                    Design.group.getModel().setValueAt(line.substring(2), k, 2);
                    line = reader.readLine();
                    while (line != null && line.charAt(0) == 'S') {
                        managerGroup.getGroup(nameGroup).getStructure().add(line.substring(2));
                        line = reader.readLine();
                    }
                    while (line != null && line.charAt(0) == 'R') {
                        managerGroup.getGroup(nameGroup).getRepertoire().add(line.substring(2));
                        line = reader.readLine();
                    }
                    k++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


