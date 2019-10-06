package managerGroup;

import java.util.HashSet;

public class Group extends BaseOfGroup implements InterfaceOfGroup,InterfaceOfGroup2{

    public Group(String name) {
        this.name = name;
        structure = new HashSet<>();
        repertoire = new HashSet<>();
    }

    public HashSet<String> getRepertoire() {
        return repertoire;
    }

    public HashSet<String> getStructure() {
        return structure;
    }
}
