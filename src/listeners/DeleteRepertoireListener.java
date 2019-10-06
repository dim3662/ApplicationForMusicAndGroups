package listeners;

import design.Design;
import exceptions.MyExceptionForRepertoireDontHaveGroup;
import managerGroup.ManagerGroup;

import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteRepertoireListener implements ActionListener {
    private final ManagerGroup managerGroup;
    public DeleteRepertoireListener(ManagerGroup managerGroup){
        this.managerGroup=managerGroup;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            DefaultTableModel model = (DefaultTableModel) Design.group2.getModel();
            String result = (String) model.getValueAt(Design.group2.getSelectedRow(),0);
            model.removeRow(Design.group2.getSelectedRow());

            managerGroup.getGroup(Design.groups2.getSelectedItem().toString()).deleteRepertoire(result);
        } catch (Exception e){
            try {
                throw new MyExceptionForRepertoireDontHaveGroup();
            } catch (MyExceptionForRepertoireDontHaveGroup myExeptionForAddStructure) {
                JOptionPane.showMessageDialog(null,new Object[]{"You can't do something with repertoire because you don't have any group"});
            }
        }
    }
}
