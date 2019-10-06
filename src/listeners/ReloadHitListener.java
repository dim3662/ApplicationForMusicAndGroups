package listeners;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import design.Design;
import managerGroup.Group;
import managerGroup.ManagerGroup;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ReloadHitListener implements ActionListener {
    private final ManagerGroup managerGroup;

    public ReloadHitListener(ManagerGroup managerGroup) {
        this.managerGroup = managerGroup;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Multimap<Integer, String> hit = ArrayListMultimap.create();
        ArrayList<Integer> hitArr=new ArrayList<Integer>();
        DefaultTableModel modelHit = (DefaultTableModel) Design.hit.getModel();
        modelHit.setRowCount(0);
        for (Group group : managerGroup.getGroups()) {
            hit.put(group.getRepertoire().size(), group.getName());
            hitArr.add(group.getRepertoire().size());
        }
        Collections.sort(hitArr);
        for (int i =hitArr.size()-1;i>=0;i--) {
            modelHit.addRow(new Object[]{hit.get(hitArr.get(i))});
            hit.remove(hitArr.get(i),hit.get(hitArr.get(i)));
        }
    }
}
