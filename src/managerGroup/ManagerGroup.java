package managerGroup;

import java.util.HashSet;

public class ManagerGroup {
    private int size;
    private static HashSet<Group> groups;
    public ManagerGroup(){
        groups=new HashSet<>();
    }

    public Group getGroup(String nameGroup){
        Group result=null;
        for (Group obj : groups) {
            if (obj.getName().equals(nameGroup))
               result=obj;
        }
        return result;
    }

    public void deleteGroup(String nameGroup) {
        Group result = null;
        for (Group obj: groups) {
            if (obj.getName().equals(nameGroup))
                result=obj;
        }
        if(result!=null) groups.remove(result);
    }

    public HashSet<Group> getGroups() {
        return groups;
    }

    public int getSize() {
        return size;
    }
}
