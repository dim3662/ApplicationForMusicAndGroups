package listeners;

import design.Design;
import managerGroup.Group;
import managerGroup.ManagerGroup;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListenerToolbar implements ActionListener {
    private final ManagerGroup managerGroup;

    public AddListenerToolbar(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String result = JOptionPane.showInputDialog(null, "<html><h2>Write a name of new group");
        if (managerGroup.getGroup(result) == null) {
            DefaultTableModel model = (DefaultTableModel) Design.group.getModel();
            DefaultTableModel modelHit = (DefaultTableModel) Design.hit.getModel();
            model.addRow(new Object[]{result});
            modelHit.addRow(new Object[]{result});
            Design.groups.addItem(result);
            Design.groups2.addItem(result);

            managerGroup.getGroups().add(new Group(result));
        } else {
            JOptionPane.showMessageDialog(null,new Object[]{"You can't add a group which already exists"});
        }
    }
}
