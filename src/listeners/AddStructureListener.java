package listeners;

import design.Design;
import exceptions.MyExeptionForStructureDontHaveGroup;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStructureListener implements ActionListener {
    private final ManagerGroup managerGroup;

    public AddStructureListener(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String result = JOptionPane.showInputDialog(null, "<html><h2>Write a name of new group");
        if (!managerGroup.getGroup(Design.groups.getSelectedItem().toString()).getStructure().contains(result)) {
            DefaultTableModel model = (DefaultTableModel) Design.group1.getModel();
            try {
                managerGroup.getGroup(Design.groups.getSelectedItem().toString()).addSrtucture(result);
                model.addRow(new Object[]{result});
                System.out.println(Design.groups.getSelectedItem().toString());
                System.out.println(managerGroup.getGroup(Design.groups.getSelectedItem().toString()).getName());
            } catch (Exception e) {
                try {
                    throw new MyExeptionForStructureDontHaveGroup();
                } catch (MyExeptionForStructureDontHaveGroup myExeptionForAddStructure) {
                    JOptionPane.showMessageDialog(null, new Object[]{"You can't do something with person because you don't have any group"});
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,new Object[]{"You can't add a person which already exists"});
        }
    }
}