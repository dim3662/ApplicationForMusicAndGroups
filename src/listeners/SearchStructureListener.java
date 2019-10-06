package listeners;

import design.Design;
import exceptions.MyExeptionForStructureDontHaveGroup;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchStructureListener implements ActionListener {
    private final ManagerGroup managerGroup;
    public SearchStructureListener(ManagerGroup managerGroup){
        this.managerGroup=managerGroup;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DefaultTableModel model = (DefaultTableModel) Design.group1.getModel();

       model.setRowCount(0);
       try {
           for (String str : managerGroup.getGroup(Design.groups.getSelectedItem().toString()).getStructure()) {
               model.addRow(new Object[]{str});
               System.out.println(str);
           }
       } catch (Exception e){
           try {
               throw new MyExeptionForStructureDontHaveGroup();
           } catch (MyExeptionForStructureDontHaveGroup myExeptionForAddStructure) {
               JOptionPane.showMessageDialog(null,new Object[]{"You can't do something with person because you don't have any group"});
           }
       }
    }
}
