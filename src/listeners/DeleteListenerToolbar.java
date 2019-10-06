package listeners;

import design.Design;
import exceptions.MyExceptionForGroups;
import managerGroup.Group;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListenerToolbar implements ActionListener {
    private final ManagerGroup managerGroup;

    public DeleteListenerToolbar(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        try {
            DefaultTableModel model = (DefaultTableModel) Design.group.getModel();
            DefaultTableModel modelHit = (DefaultTableModel) Design.hit.getModel();
            String result = (String) model.getValueAt(Design.group.getSelectedRow(), 0);
            model.removeRow(Design.group.getSelectedRow());
            modelHit.setRowCount(0);
            Design.groups.removeItem(result);
            Design.groups2.removeItem(result);

            managerGroup.deleteGroup(result);
            for (Group hit : managerGroup.getGroups()) {
                modelHit.addRow(new Object[]{hit.getName()});
            }
        } catch (Exception e) {
            try {
                throw new MyExceptionForGroups();
            } catch (MyExceptionForGroups myExceptionForGroups) {
                JOptionPane.showMessageDialog(null, new Object[]{"You can't delete a group because you don't have any group"});
            }
        }

    }
}
