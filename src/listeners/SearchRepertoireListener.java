package listeners;

import design.Design;
import exceptions.MyExceptionForRepertoireDontHaveGroup;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchRepertoireListener implements ActionListener {
    private final ManagerGroup managerGroup;
    public SearchRepertoireListener(ManagerGroup managerGroup){
        this.managerGroup=managerGroup;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DefaultTableModel model = (DefaultTableModel) Design.group2.getModel();

        model.setRowCount(0);
        try {
            for (String str : managerGroup.getGroup(Design.groups2.getSelectedItem().toString()).getRepertoire()) {
                model.addRow(new Object[]{str});
                System.out.println(str);
            }
        }catch (Exception e){
            try {
                throw new MyExceptionForRepertoireDontHaveGroup();
            } catch (MyExceptionForRepertoireDontHaveGroup myExeptionForAddStructure) {
                JOptionPane.showMessageDialog(null,new Object[]{"You can't do something with repertoire because you don't have any group"});
            }
        }

    }
}
