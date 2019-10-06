package managerGroup;

import java.util.HashSet;

public abstract class BaseOfGroup implements InterfaceOfGroup,InterfaceOfGroup2 {
    protected int yearOsn;
    protected String name;
    protected HashSet<String> structure;
    protected HashSet<String> repertoire;
    public void deleteStructure(String music) {
        structure.remove(music);
    }

    public void deleteRepertoire(String music) {
        repertoire.remove(music);
    }

    public void addRepertoire(String music) {
        repertoire.add(music);
    }

    public void addSrtucture(String nameArtist) {
        structure.add(nameArtist);
    }

    public int getYearOsn() {
        return yearOsn;
    }

    public String getName() {
        return name;
    }

    public abstract HashSet<String> getStructure();
}
