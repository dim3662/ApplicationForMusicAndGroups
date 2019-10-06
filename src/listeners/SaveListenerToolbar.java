package listeners;

import design.Design;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SaveListenerToolbar extends Component implements ActionListener {
    private final ManagerGroup managerGroup;
    public SaveListenerToolbar(ManagerGroup managerGroup){
        this.managerGroup=managerGroup;
    }
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setDialogTitle("Select file for save");
        int returnVal = chooser.showDialog(this, "Save");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                System.out.println(file.getAbsolutePath());
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for(int i=0;i< Design.group.getRowCount();i++){
                    String nameGroup= (String) Design.group.getModel().getValueAt(i,0);
                    writer.write("G "+Design.group.getModel().getValueAt(i,0));
                    writer.newLine();
                    writer.write("G "+Design.group.getModel().getValueAt(i,1));
                    writer.newLine();
                    writer.write("G "+Design.group.getModel().getValueAt(i,2));
                    writer.newLine();
                    for(String struct:managerGroup.getGroup(nameGroup).getStructure()){
                        writer.write("S "+struct);
                        writer.newLine();
                    }
                    for(String repert:managerGroup.getGroup(nameGroup).getRepertoire()){
                        writer.write("R "+repert);
                        writer.newLine();
                    }
                }
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
