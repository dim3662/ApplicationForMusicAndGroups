package listeners;

import design.Design;
import exceptions.MyExeptionForStructureDontHaveGroup;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStructureListener implements ActionListener {
    private final ManagerGroup managerGroup;

    public DeleteStructureListener(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            DefaultTableModel model = (DefaultTableModel) Design.group1.getModel();
            String result = (String) model.getValueAt(Design.group1.getSelectedRow(), 0);
            model.removeRow(Design.group1.getSelectedRow());

            managerGroup.getGroup(Design.groups.getSelectedItem().toString()).deleteStructure(result);
            System.out.println(result);
            System.out.println(managerGroup.getGroup(Design.groups.getSelectedItem().toString()).getName());
        } catch (Exception e) {
            try {
                throw new MyExeptionForStructureDontHaveGroup();
            } catch (MyExeptionForStructureDontHaveGroup myExeptionForAddStructure) {
                JOptionPane.showMessageDialog(null, new Object[]{"You can't do something with person because you don't have any group"});
            }
        }
    }
}
