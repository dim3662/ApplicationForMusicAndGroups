package listeners;

import design.Design;
import exceptions.MyExceptionForRepertoireDontHaveGroup;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRepertoireListener implements ActionListener {
    private final ManagerGroup managerGroup;

    public AddRepertoireListener(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String result = JOptionPane.showInputDialog(null, "<html><h2>Write a name of new group");
        if (!managerGroup.getGroup(Design.groups2.getSelectedItem().toString()).getRepertoire().contains(result)) {
            DefaultTableModel model = (DefaultTableModel) Design.group2.getModel();
            try {
                managerGroup.getGroup(Design.groups2.getSelectedItem().toString()).addRepertoire(result);
                model.addRow(new Object[]{result});
            } catch (Exception e) {
                try {
                    throw new MyExceptionForRepertoireDontHaveGroup();
                } catch (MyExceptionForRepertoireDontHaveGroup myExeptionForAddStructure) {
                    JOptionPane.showMessageDialog(null, new Object[]{"You can't do something with repertoire because you don't have any group"});
                }
            }
        } else{
            JOptionPane.showMessageDialog(null,new Object[]{"You can't add a music which already exists"});
        }
    }
}
